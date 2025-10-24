package com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.edec;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Encoding;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1InputStream;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1OctetString;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Sequence;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DEROctetString;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.edec.EdECObjectIdentifiers;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.AlgorithmIdentifier;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.AsymmetricKeyParameter;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.Ed25519PrivateKeyParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.Ed25519PublicKeyParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.util.OpenSSHPrivateKeyUtil;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.util.OpenSSHPublicKeyUtil;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.util.BaseKeyFactorySpi;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.util.AsymmetricKeyInfoConverter;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.spec.EdDSAParameterSpec;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.spec.OpenSSHPrivateKeySpec;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.spec.OpenSSHPublicKeySpec;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.spec.XDHParameterSpec;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.encoders.Hex;
import com.fis.ekyc.nfc.build_in.eidparser.lds.LDSFile;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.security.spec.X509EncodedKeySpec;

public class KeyFactorySpi extends BaseKeyFactorySpi implements AsymmetricKeyInfoConverter {
    static final byte[] Ed25519Prefix = Hex.decode("302a300506032b6570032100");
    private static final byte Ed25519_type = 112;
    static final byte[] Ed448Prefix = Hex.decode("3043300506032b6571033a00");
    private static final byte Ed448_type = 113;
    static final byte[] x25519Prefix = Hex.decode("302a300506032b656e032100");
    private static final byte x25519_type = 110;
    static final byte[] x448Prefix = Hex.decode("3042300506032b656f033900");
    private static final byte x448_type = 111;
    String algorithm;
    private final boolean isXdh;
    private final int specificBase;

    public static class Ed25519 extends KeyFactorySpi {
        public Ed25519() {
            super(EdDSAParameterSpec.Ed25519, false, LDSFile.EF_DG16_TAG);
        }
    }

    public static class Ed448 extends KeyFactorySpi {
        public Ed448() {
            super(EdDSAParameterSpec.Ed448, false, 113);
        }
    }

    public static class EdDSA extends KeyFactorySpi {
        public EdDSA() {
            super("EdDSA", false, 0);
        }
    }

    public static class X25519 extends KeyFactorySpi {
        public X25519() {
            super(XDHParameterSpec.X25519, true, LDSFile.EF_DG14_TAG);
        }
    }

    public static class X448 extends KeyFactorySpi {
        public X448() {
            super(XDHParameterSpec.X448, true, LDSFile.EF_DG15_TAG);
        }
    }

    public static class XDH extends KeyFactorySpi {
        public XDH() {
            super("XDH", true, 0);
        }
    }

    public KeyFactorySpi(String str, boolean z, int i) {
        this.algorithm = str;
        this.isXdh = z;
        this.specificBase = i;
    }

    public PrivateKey engineGeneratePrivate(KeySpec keySpec) throws InvalidKeySpecException {
        if (!(keySpec instanceof OpenSSHPrivateKeySpec)) {
            return super.engineGeneratePrivate(keySpec);
        }
        AsymmetricKeyParameter parsePrivateKeyBlob = OpenSSHPrivateKeyUtil.parsePrivateKeyBlob(((OpenSSHPrivateKeySpec) keySpec).getEncoded());
        if (parsePrivateKeyBlob instanceof Ed25519PrivateKeyParameters) {
            return new BCEdDSAPrivateKey((AsymmetricKeyParameter) (Ed25519PrivateKeyParameters) parsePrivateKeyBlob);
        }
        throw new IllegalStateException("openssh private key not Ed25519 private key");
    }

    public PublicKey engineGeneratePublic(KeySpec keySpec) throws InvalidKeySpecException {
        if (keySpec instanceof X509EncodedKeySpec) {
            byte[] encoded = ((X509EncodedKeySpec) keySpec).getEncoded();
            int i = this.specificBase;
            if (i == 0 || i == encoded[8]) {
                if (encoded[9] == 5 && encoded[10] == 0) {
                    SubjectPublicKeyInfo instance = SubjectPublicKeyInfo.getInstance(encoded);
                    try {
                        encoded = new SubjectPublicKeyInfo(new AlgorithmIdentifier(instance.getAlgorithm().getAlgorithm()), instance.getPublicKeyData().getBytes()).getEncoded(ASN1Encoding.DER);
                    } catch (IOException e) {
                        throw new InvalidKeySpecException("attempt to reconstruct key failed: " + e.getMessage());
                    }
                }
                switch (encoded[8]) {
                    case LDSFile.EF_DG14_TAG /*110*/:
                        return new BCXDHPublicKey(x25519Prefix, encoded);
                    case LDSFile.EF_DG15_TAG /*111*/:
                        return new BCXDHPublicKey(x448Prefix, encoded);
                    case LDSFile.EF_DG16_TAG /*112*/:
                        return new BCEdDSAPublicKey(Ed25519Prefix, encoded);
                    case 113:
                        return new BCEdDSAPublicKey(Ed448Prefix, encoded);
                    default:
                        return super.engineGeneratePublic(keySpec);
                }
            }
        } else if (keySpec instanceof OpenSSHPublicKeySpec) {
            AsymmetricKeyParameter parsePublicKey = OpenSSHPublicKeyUtil.parsePublicKey(((OpenSSHPublicKeySpec) keySpec).getEncoded());
            if (parsePublicKey instanceof Ed25519PublicKeyParameters) {
                return new BCEdDSAPublicKey(new byte[0], ((Ed25519PublicKeyParameters) parsePublicKey).getEncoded());
            }
            throw new IllegalStateException("openssh public key not Ed25519 public key");
        }
        return super.engineGeneratePublic(keySpec);
    }

    public KeySpec engineGetKeySpec(Key key, Class cls) throws InvalidKeySpecException {
        if (cls.isAssignableFrom(OpenSSHPrivateKeySpec.class) && (key instanceof BCEdDSAPrivateKey)) {
            try {
                return new OpenSSHPrivateKeySpec(OpenSSHPrivateKeyUtil.encodePrivateKey(new Ed25519PrivateKeyParameters(ASN1OctetString.getInstance(new ASN1InputStream(((DEROctetString) ASN1Sequence.getInstance(key.getEncoded()).getObjectAt(2)).getOctets()).readObject()).getOctets(), 0)));
            } catch (IOException e) {
                throw new InvalidKeySpecException(e.getMessage(), e.getCause());
            }
        } else if (cls.isAssignableFrom(OpenSSHPublicKeySpec.class) && (key instanceof BCEdDSAPublicKey)) {
            try {
                return new OpenSSHPublicKeySpec(OpenSSHPublicKeyUtil.encodePublicKey(new Ed25519PublicKeyParameters(key.getEncoded(), Ed25519Prefix.length)));
            } catch (IOException e2) {
                throw new InvalidKeySpecException(e2.getMessage(), e2.getCause());
            }
        } else if (cls.isAssignableFrom(com.fis.ekyc.nfc.build_in.bouncycastle.jce.spec.OpenSSHPrivateKeySpec.class) && (key instanceof BCEdDSAPrivateKey)) {
            try {
                return new com.fis.ekyc.nfc.build_in.bouncycastle.jce.spec.OpenSSHPrivateKeySpec(OpenSSHPrivateKeyUtil.encodePrivateKey(new Ed25519PrivateKeyParameters(ASN1OctetString.getInstance(new ASN1InputStream(((DEROctetString) ASN1Sequence.getInstance(key.getEncoded()).getObjectAt(2)).getOctets()).readObject()).getOctets(), 0)));
            } catch (IOException e3) {
                throw new InvalidKeySpecException(e3.getMessage(), e3.getCause());
            }
        } else if (!cls.isAssignableFrom(com.fis.ekyc.nfc.build_in.bouncycastle.jce.spec.OpenSSHPublicKeySpec.class) || !(key instanceof BCEdDSAPublicKey)) {
            return super.engineGetKeySpec(key, cls);
        } else {
            try {
                return new com.fis.ekyc.nfc.build_in.bouncycastle.jce.spec.OpenSSHPublicKeySpec(OpenSSHPublicKeyUtil.encodePublicKey(new Ed25519PublicKeyParameters(key.getEncoded(), Ed25519Prefix.length)));
            } catch (IOException e4) {
                throw new InvalidKeySpecException(e4.getMessage(), e4.getCause());
            }
        }
    }

    public Key engineTranslateKey(Key key) throws InvalidKeyException {
        throw new InvalidKeyException("key type unknown");
    }

    public PrivateKey generatePrivate(PrivateKeyInfo privateKeyInfo) throws IOException {
        ASN1ObjectIdentifier algorithm2 = privateKeyInfo.getPrivateKeyAlgorithm().getAlgorithm();
        if (this.isXdh) {
            int i = this.specificBase;
            if ((i == 0 || i == 111) && algorithm2.equals((ASN1Primitive) EdECObjectIdentifiers.id_X448)) {
                return new BCXDHPrivateKey(privateKeyInfo);
            }
            int i2 = this.specificBase;
            if ((i2 == 0 || i2 == 110) && algorithm2.equals((ASN1Primitive) EdECObjectIdentifiers.id_X25519)) {
                return new BCXDHPrivateKey(privateKeyInfo);
            }
        } else {
            ASN1ObjectIdentifier aSN1ObjectIdentifier = EdECObjectIdentifiers.id_Ed448;
            if (algorithm2.equals((ASN1Primitive) aSN1ObjectIdentifier) || algorithm2.equals((ASN1Primitive) EdECObjectIdentifiers.id_Ed25519)) {
                int i3 = this.specificBase;
                if ((i3 == 0 || i3 == 113) && algorithm2.equals((ASN1Primitive) aSN1ObjectIdentifier)) {
                    return new BCEdDSAPrivateKey(privateKeyInfo);
                }
                int i4 = this.specificBase;
                if ((i4 == 0 || i4 == 112) && algorithm2.equals((ASN1Primitive) EdECObjectIdentifiers.id_Ed25519)) {
                    return new BCEdDSAPrivateKey(privateKeyInfo);
                }
            }
        }
        throw new IOException("algorithm identifier " + algorithm2 + " in key not recognized");
    }

    public PublicKey generatePublic(SubjectPublicKeyInfo subjectPublicKeyInfo) throws IOException {
        ASN1ObjectIdentifier algorithm2 = subjectPublicKeyInfo.getAlgorithm().getAlgorithm();
        if (this.isXdh) {
            int i = this.specificBase;
            if ((i == 0 || i == 111) && algorithm2.equals((ASN1Primitive) EdECObjectIdentifiers.id_X448)) {
                return new BCXDHPublicKey(subjectPublicKeyInfo);
            }
            int i2 = this.specificBase;
            if ((i2 == 0 || i2 == 110) && algorithm2.equals((ASN1Primitive) EdECObjectIdentifiers.id_X25519)) {
                return new BCXDHPublicKey(subjectPublicKeyInfo);
            }
        } else {
            ASN1ObjectIdentifier aSN1ObjectIdentifier = EdECObjectIdentifiers.id_Ed448;
            if (algorithm2.equals((ASN1Primitive) aSN1ObjectIdentifier) || algorithm2.equals((ASN1Primitive) EdECObjectIdentifiers.id_Ed25519)) {
                int i3 = this.specificBase;
                if ((i3 == 0 || i3 == 113) && algorithm2.equals((ASN1Primitive) aSN1ObjectIdentifier)) {
                    return new BCEdDSAPublicKey(subjectPublicKeyInfo);
                }
                int i4 = this.specificBase;
                if ((i4 == 0 || i4 == 112) && algorithm2.equals((ASN1Primitive) EdECObjectIdentifiers.id_Ed25519)) {
                    return new BCEdDSAPublicKey(subjectPublicKeyInfo);
                }
            }
        }
        throw new IOException("algorithm identifier " + algorithm2 + " in key not recognized");
    }
}
