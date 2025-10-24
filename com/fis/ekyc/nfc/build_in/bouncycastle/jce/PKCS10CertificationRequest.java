package com.fis.ekyc.nfc.build_in.bouncycastle.jce;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Encodable;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Encoding;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1InputStream;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Integer;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Sequence;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Set;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERBitString;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERNull;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.oiw.OIWObjectIdentifiers;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.CertificationRequest;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.CertificationRequestInfo;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.RSASSAPSSparams;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.teletrust.TeleTrusTObjectIdentifiers;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.AlgorithmIdentifier;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.X509Name;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x9.X9ObjectIdentifiers;
import com.fis.ekyc.nfc.build_in.bouncycastle.jce.provider.BouncyCastleProvider;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.Strings;
import com.fis.ekyc.nfc.build_in.eidparser.lds.SignedDataUtil;
import java.io.IOException;
import java.security.AlgorithmParameters;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PSSParameterSpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;
import javax.security.auth.x500.X500Principal;

public class PKCS10CertificationRequest extends CertificationRequest {
    private static Hashtable algorithms = new Hashtable();
    private static Hashtable keyAlgorithms = new Hashtable();
    private static Set noParams = new HashSet();
    private static Hashtable oids = new Hashtable();
    private static Hashtable params = new Hashtable();

    static {
        algorithms.put("MD2WITHRSAENCRYPTION", new ASN1ObjectIdentifier(SignedDataUtil.PKCS1_MD2_WITH_RSA_OID));
        algorithms.put("MD2WITHRSA", new ASN1ObjectIdentifier(SignedDataUtil.PKCS1_MD2_WITH_RSA_OID));
        algorithms.put("MD5WITHRSAENCRYPTION", new ASN1ObjectIdentifier(SignedDataUtil.PKCS1_MD5_WITH_RSA_OID));
        algorithms.put("MD5WITHRSA", new ASN1ObjectIdentifier(SignedDataUtil.PKCS1_MD5_WITH_RSA_OID));
        algorithms.put("RSAWITHMD5", new ASN1ObjectIdentifier(SignedDataUtil.PKCS1_MD5_WITH_RSA_OID));
        algorithms.put("SHA1WITHRSAENCRYPTION", new ASN1ObjectIdentifier(SignedDataUtil.PKCS1_SHA1_WITH_RSA_OID));
        algorithms.put("SHA1WITHRSA", new ASN1ObjectIdentifier(SignedDataUtil.PKCS1_SHA1_WITH_RSA_OID));
        Hashtable hashtable = algorithms;
        ASN1ObjectIdentifier aSN1ObjectIdentifier = PKCSObjectIdentifiers.sha224WithRSAEncryption;
        hashtable.put("SHA224WITHRSAENCRYPTION", aSN1ObjectIdentifier);
        algorithms.put("SHA224WITHRSA", aSN1ObjectIdentifier);
        Hashtable hashtable2 = algorithms;
        ASN1ObjectIdentifier aSN1ObjectIdentifier2 = PKCSObjectIdentifiers.sha256WithRSAEncryption;
        hashtable2.put("SHA256WITHRSAENCRYPTION", aSN1ObjectIdentifier2);
        algorithms.put("SHA256WITHRSA", aSN1ObjectIdentifier2);
        Hashtable hashtable3 = algorithms;
        ASN1ObjectIdentifier aSN1ObjectIdentifier3 = PKCSObjectIdentifiers.sha384WithRSAEncryption;
        hashtable3.put("SHA384WITHRSAENCRYPTION", aSN1ObjectIdentifier3);
        algorithms.put("SHA384WITHRSA", aSN1ObjectIdentifier3);
        Hashtable hashtable4 = algorithms;
        ASN1ObjectIdentifier aSN1ObjectIdentifier4 = PKCSObjectIdentifiers.sha512WithRSAEncryption;
        hashtable4.put("SHA512WITHRSAENCRYPTION", aSN1ObjectIdentifier4);
        algorithms.put("SHA512WITHRSA", aSN1ObjectIdentifier4);
        Hashtable hashtable5 = algorithms;
        ASN1ObjectIdentifier aSN1ObjectIdentifier5 = PKCSObjectIdentifiers.id_RSASSA_PSS;
        hashtable5.put("SHA1WITHRSAANDMGF1", aSN1ObjectIdentifier5);
        algorithms.put("SHA224WITHRSAANDMGF1", aSN1ObjectIdentifier5);
        algorithms.put("SHA256WITHRSAANDMGF1", aSN1ObjectIdentifier5);
        algorithms.put("SHA384WITHRSAANDMGF1", aSN1ObjectIdentifier5);
        algorithms.put("SHA512WITHRSAANDMGF1", aSN1ObjectIdentifier5);
        algorithms.put("RSAWITHSHA1", new ASN1ObjectIdentifier(SignedDataUtil.PKCS1_SHA1_WITH_RSA_OID));
        Hashtable hashtable6 = algorithms;
        ASN1ObjectIdentifier aSN1ObjectIdentifier6 = TeleTrusTObjectIdentifiers.rsaSignatureWithripemd128;
        hashtable6.put("RIPEMD128WITHRSAENCRYPTION", aSN1ObjectIdentifier6);
        algorithms.put("RIPEMD128WITHRSA", aSN1ObjectIdentifier6);
        Hashtable hashtable7 = algorithms;
        ASN1ObjectIdentifier aSN1ObjectIdentifier7 = TeleTrusTObjectIdentifiers.rsaSignatureWithripemd160;
        hashtable7.put("RIPEMD160WITHRSAENCRYPTION", aSN1ObjectIdentifier7);
        algorithms.put("RIPEMD160WITHRSA", aSN1ObjectIdentifier7);
        Hashtable hashtable8 = algorithms;
        ASN1ObjectIdentifier aSN1ObjectIdentifier8 = TeleTrusTObjectIdentifiers.rsaSignatureWithripemd256;
        hashtable8.put("RIPEMD256WITHRSAENCRYPTION", aSN1ObjectIdentifier8);
        algorithms.put("RIPEMD256WITHRSA", aSN1ObjectIdentifier8);
        Hashtable hashtable9 = algorithms;
        ASN1ObjectIdentifier aSN1ObjectIdentifier9 = new ASN1ObjectIdentifier("1.2.840.10040.4.3");
        String str = SignedDataUtil.PKCS1_MD2_WITH_RSA_OID;
        hashtable9.put("SHA1WITHDSA", aSN1ObjectIdentifier9);
        algorithms.put("DSAWITHSHA1", new ASN1ObjectIdentifier("1.2.840.10040.4.3"));
        Hashtable hashtable10 = algorithms;
        ASN1ObjectIdentifier aSN1ObjectIdentifier10 = NISTObjectIdentifiers.dsa_with_sha224;
        hashtable10.put("SHA224WITHDSA", aSN1ObjectIdentifier10);
        Hashtable hashtable11 = algorithms;
        ASN1ObjectIdentifier aSN1ObjectIdentifier11 = aSN1ObjectIdentifier10;
        ASN1ObjectIdentifier aSN1ObjectIdentifier12 = NISTObjectIdentifiers.dsa_with_sha256;
        hashtable11.put("SHA256WITHDSA", aSN1ObjectIdentifier12);
        ASN1ObjectIdentifier aSN1ObjectIdentifier13 = aSN1ObjectIdentifier12;
        algorithms.put("SHA384WITHDSA", NISTObjectIdentifiers.dsa_with_sha384);
        algorithms.put("SHA512WITHDSA", NISTObjectIdentifiers.dsa_with_sha512);
        Hashtable hashtable12 = algorithms;
        ASN1ObjectIdentifier aSN1ObjectIdentifier14 = X9ObjectIdentifiers.ecdsa_with_SHA1;
        hashtable12.put("SHA1WITHECDSA", aSN1ObjectIdentifier14);
        Hashtable hashtable13 = algorithms;
        ASN1ObjectIdentifier aSN1ObjectIdentifier15 = X9ObjectIdentifiers.ecdsa_with_SHA224;
        hashtable13.put("SHA224WITHECDSA", aSN1ObjectIdentifier15);
        Hashtable hashtable14 = algorithms;
        ASN1ObjectIdentifier aSN1ObjectIdentifier16 = aSN1ObjectIdentifier15;
        ASN1ObjectIdentifier aSN1ObjectIdentifier17 = X9ObjectIdentifiers.ecdsa_with_SHA256;
        hashtable14.put("SHA256WITHECDSA", aSN1ObjectIdentifier17);
        Hashtable hashtable15 = algorithms;
        ASN1ObjectIdentifier aSN1ObjectIdentifier18 = aSN1ObjectIdentifier17;
        ASN1ObjectIdentifier aSN1ObjectIdentifier19 = X9ObjectIdentifiers.ecdsa_with_SHA384;
        hashtable15.put("SHA384WITHECDSA", aSN1ObjectIdentifier19);
        Hashtable hashtable16 = algorithms;
        ASN1ObjectIdentifier aSN1ObjectIdentifier20 = X9ObjectIdentifiers.ecdsa_with_SHA512;
        ASN1ObjectIdentifier aSN1ObjectIdentifier21 = aSN1ObjectIdentifier19;
        hashtable16.put("SHA512WITHECDSA", aSN1ObjectIdentifier20);
        algorithms.put("ECDSAWITHSHA1", aSN1ObjectIdentifier14);
        Hashtable hashtable17 = algorithms;
        ASN1ObjectIdentifier aSN1ObjectIdentifier22 = CryptoProObjectIdentifiers.gostR3411_94_with_gostR3410_94;
        ASN1ObjectIdentifier aSN1ObjectIdentifier23 = aSN1ObjectIdentifier20;
        hashtable17.put("GOST3411WITHGOST3410", aSN1ObjectIdentifier22);
        algorithms.put("GOST3410WITHGOST3411", aSN1ObjectIdentifier22);
        Hashtable hashtable18 = algorithms;
        ASN1ObjectIdentifier aSN1ObjectIdentifier24 = CryptoProObjectIdentifiers.gostR3411_94_with_gostR3410_2001;
        ASN1ObjectIdentifier aSN1ObjectIdentifier25 = aSN1ObjectIdentifier14;
        hashtable18.put("GOST3411WITHECGOST3410", aSN1ObjectIdentifier24);
        algorithms.put("GOST3411WITHECGOST3410-2001", aSN1ObjectIdentifier24);
        algorithms.put("GOST3411WITHGOST3410-2001", aSN1ObjectIdentifier24);
        oids.put(new ASN1ObjectIdentifier(SignedDataUtil.PKCS1_SHA1_WITH_RSA_OID), "SHA1WITHRSA");
        oids.put(aSN1ObjectIdentifier, "SHA224WITHRSA");
        oids.put(aSN1ObjectIdentifier2, "SHA256WITHRSA");
        oids.put(aSN1ObjectIdentifier3, "SHA384WITHRSA");
        oids.put(aSN1ObjectIdentifier4, "SHA512WITHRSA");
        oids.put(aSN1ObjectIdentifier22, "GOST3411WITHGOST3410");
        oids.put(aSN1ObjectIdentifier24, "GOST3411WITHECGOST3410");
        oids.put(new ASN1ObjectIdentifier(SignedDataUtil.PKCS1_MD5_WITH_RSA_OID), "MD5WITHRSA");
        oids.put(new ASN1ObjectIdentifier(str), "MD2WITHRSA");
        Object obj = "SHA1WITHDSA";
        oids.put(new ASN1ObjectIdentifier("1.2.840.10040.4.3"), obj);
        ASN1ObjectIdentifier aSN1ObjectIdentifier26 = aSN1ObjectIdentifier25;
        oids.put(aSN1ObjectIdentifier26, "SHA1WITHECDSA");
        ASN1ObjectIdentifier aSN1ObjectIdentifier27 = aSN1ObjectIdentifier16;
        oids.put(aSN1ObjectIdentifier27, "SHA224WITHECDSA");
        ASN1ObjectIdentifier aSN1ObjectIdentifier28 = aSN1ObjectIdentifier18;
        oids.put(aSN1ObjectIdentifier28, "SHA256WITHECDSA");
        ASN1ObjectIdentifier aSN1ObjectIdentifier29 = aSN1ObjectIdentifier21;
        oids.put(aSN1ObjectIdentifier29, "SHA384WITHECDSA");
        ASN1ObjectIdentifier aSN1ObjectIdentifier30 = aSN1ObjectIdentifier23;
        oids.put(aSN1ObjectIdentifier30, "SHA512WITHECDSA");
        oids.put(OIWObjectIdentifiers.sha1WithRSA, "SHA1WITHRSA");
        Hashtable hashtable19 = oids;
        ASN1ObjectIdentifier aSN1ObjectIdentifier31 = OIWObjectIdentifiers.dsaWithSHA1;
        hashtable19.put(aSN1ObjectIdentifier31, obj);
        ASN1ObjectIdentifier aSN1ObjectIdentifier32 = aSN1ObjectIdentifier11;
        oids.put(aSN1ObjectIdentifier32, "SHA224WITHDSA");
        ASN1ObjectIdentifier aSN1ObjectIdentifier33 = aSN1ObjectIdentifier13;
        oids.put(aSN1ObjectIdentifier33, "SHA256WITHDSA");
        keyAlgorithms.put(PKCSObjectIdentifiers.rsaEncryption, "RSA");
        keyAlgorithms.put(X9ObjectIdentifiers.id_dsa, "DSA");
        noParams.add(aSN1ObjectIdentifier26);
        noParams.add(aSN1ObjectIdentifier27);
        noParams.add(aSN1ObjectIdentifier28);
        noParams.add(aSN1ObjectIdentifier29);
        noParams.add(aSN1ObjectIdentifier30);
        noParams.add(X9ObjectIdentifiers.id_dsa_with_sha1);
        noParams.add(aSN1ObjectIdentifier31);
        noParams.add(aSN1ObjectIdentifier32);
        noParams.add(aSN1ObjectIdentifier33);
        noParams.add(aSN1ObjectIdentifier22);
        noParams.add(aSN1ObjectIdentifier24);
        ASN1ObjectIdentifier aSN1ObjectIdentifier34 = OIWObjectIdentifiers.idSHA1;
        DERNull dERNull = DERNull.INSTANCE;
        Object obj2 = "SHA1WITHRSAANDMGF1";
        params.put(obj2, creatPSSParams(new AlgorithmIdentifier(aSN1ObjectIdentifier34, dERNull), 20));
        Object obj3 = "SHA224WITHRSAANDMGF1";
        params.put(obj3, creatPSSParams(new AlgorithmIdentifier(NISTObjectIdentifiers.id_sha224, dERNull), 28));
        Object obj4 = "SHA256WITHRSAANDMGF1";
        params.put(obj4, creatPSSParams(new AlgorithmIdentifier(NISTObjectIdentifiers.id_sha256, dERNull), 32));
        Object obj5 = "SHA384WITHRSAANDMGF1";
        params.put(obj5, creatPSSParams(new AlgorithmIdentifier(NISTObjectIdentifiers.id_sha384, dERNull), 48));
        AlgorithmIdentifier algorithmIdentifier = new AlgorithmIdentifier(NISTObjectIdentifiers.id_sha512, dERNull);
        params.put("SHA512WITHRSAANDMGF1", creatPSSParams(algorithmIdentifier, 64));
    }

    public PKCS10CertificationRequest(byte[] bArr) {
        super(toDERSequence(bArr));
    }

    private static X509Name convertName(X500Principal x500Principal) {
        try {
            return new X509Principal(x500Principal.getEncoded());
        } catch (IOException unused) {
            throw new IllegalArgumentException("can't convert name");
        }
    }

    private static RSASSAPSSparams creatPSSParams(AlgorithmIdentifier algorithmIdentifier, int i) {
        return new RSASSAPSSparams(algorithmIdentifier, new AlgorithmIdentifier(PKCSObjectIdentifiers.id_mgf1, algorithmIdentifier), new ASN1Integer((long) i), new ASN1Integer(1));
    }

    private static String getDigestAlgName(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        if (PKCSObjectIdentifiers.md5.equals((ASN1Primitive) aSN1ObjectIdentifier)) {
            return "MD5";
        }
        if (OIWObjectIdentifiers.idSHA1.equals((ASN1Primitive) aSN1ObjectIdentifier)) {
            return "SHA1";
        }
        if (NISTObjectIdentifiers.id_sha224.equals((ASN1Primitive) aSN1ObjectIdentifier)) {
            return "SHA224";
        }
        if (NISTObjectIdentifiers.id_sha256.equals((ASN1Primitive) aSN1ObjectIdentifier)) {
            return "SHA256";
        }
        if (NISTObjectIdentifiers.id_sha384.equals((ASN1Primitive) aSN1ObjectIdentifier)) {
            return "SHA384";
        }
        if (NISTObjectIdentifiers.id_sha512.equals((ASN1Primitive) aSN1ObjectIdentifier)) {
            return "SHA512";
        }
        if (TeleTrusTObjectIdentifiers.ripemd128.equals((ASN1Primitive) aSN1ObjectIdentifier)) {
            return "RIPEMD128";
        }
        if (TeleTrusTObjectIdentifiers.ripemd160.equals((ASN1Primitive) aSN1ObjectIdentifier)) {
            return "RIPEMD160";
        }
        if (TeleTrusTObjectIdentifiers.ripemd256.equals((ASN1Primitive) aSN1ObjectIdentifier)) {
            return "RIPEMD256";
        }
        if (CryptoProObjectIdentifiers.gostR3411.equals((ASN1Primitive) aSN1ObjectIdentifier)) {
            return "GOST3411";
        }
        return aSN1ObjectIdentifier.getId();
    }

    public static String getSignatureName(AlgorithmIdentifier algorithmIdentifier) {
        ASN1Encodable parameters = algorithmIdentifier.getParameters();
        if (parameters == null || DERNull.INSTANCE.equals(parameters) || !algorithmIdentifier.getAlgorithm().equals((ASN1Primitive) PKCSObjectIdentifiers.id_RSASSA_PSS)) {
            return algorithmIdentifier.getAlgorithm().getId();
        }
        RSASSAPSSparams instance = RSASSAPSSparams.getInstance(parameters);
        return getDigestAlgName(instance.getHashAlgorithm().getAlgorithm()) + "withRSAandMGF1";
    }

    private void setSignatureParameters(Signature signature, ASN1Encodable aSN1Encodable) throws NoSuchAlgorithmException, SignatureException, InvalidKeyException {
        if (aSN1Encodable != null && !DERNull.INSTANCE.equals(aSN1Encodable)) {
            AlgorithmParameters instance = AlgorithmParameters.getInstance(signature.getAlgorithm(), signature.getProvider());
            try {
                instance.init(aSN1Encodable.toASN1Primitive().getEncoded(ASN1Encoding.DER));
                if (signature.getAlgorithm().endsWith("MGF1")) {
                    try {
                        signature.setParameter(instance.getParameterSpec(PSSParameterSpec.class));
                    } catch (GeneralSecurityException e) {
                        throw new SignatureException("Exception extracting parameters: " + e.getMessage());
                    }
                }
            } catch (IOException e2) {
                throw new SignatureException("IOException decoding parameters: " + e2.getMessage());
            }
        }
    }

    private static ASN1Sequence toDERSequence(byte[] bArr) {
        try {
            return (ASN1Sequence) new ASN1InputStream(bArr).readObject();
        } catch (Exception unused) {
            throw new IllegalArgumentException("badly encoded request");
        }
    }

    public byte[] getEncoded() {
        try {
            return getEncoded(ASN1Encoding.DER);
        } catch (IOException e) {
            throw new RuntimeException(e.toString());
        }
    }

    public PublicKey getPublicKey() throws NoSuchAlgorithmException, NoSuchProviderException, InvalidKeyException {
        return getPublicKey(BouncyCastleProvider.PROVIDER_NAME);
    }

    public boolean verify() throws NoSuchAlgorithmException, NoSuchProviderException, InvalidKeyException, SignatureException {
        return verify(BouncyCastleProvider.PROVIDER_NAME);
    }

    public PKCS10CertificationRequest(ASN1Sequence aSN1Sequence) {
        super(aSN1Sequence);
    }

    public PublicKey getPublicKey(String str) throws NoSuchAlgorithmException, NoSuchProviderException, InvalidKeyException {
        X509EncodedKeySpec x509EncodedKeySpec;
        AlgorithmIdentifier algorithm;
        SubjectPublicKeyInfo subjectPublicKeyInfo = this.reqInfo.getSubjectPublicKeyInfo();
        try {
            x509EncodedKeySpec = new X509EncodedKeySpec(new DERBitString((ASN1Encodable) subjectPublicKeyInfo).getOctets());
            algorithm = subjectPublicKeyInfo.getAlgorithm();
            if (str == null) {
                return KeyFactory.getInstance(algorithm.getAlgorithm().getId()).generatePublic(x509EncodedKeySpec);
            }
            return KeyFactory.getInstance(algorithm.getAlgorithm().getId(), str).generatePublic(x509EncodedKeySpec);
        } catch (NoSuchAlgorithmException e) {
            if (keyAlgorithms.get(algorithm.getAlgorithm()) != null) {
                String str2 = (String) keyAlgorithms.get(algorithm.getAlgorithm());
                if (str == null) {
                    return KeyFactory.getInstance(str2).generatePublic(x509EncodedKeySpec);
                }
                return KeyFactory.getInstance(str2, str).generatePublic(x509EncodedKeySpec);
            }
            throw e;
        } catch (InvalidKeySpecException unused) {
            throw new InvalidKeyException("error decoding public key");
        } catch (IOException unused2) {
            throw new InvalidKeyException("error decoding public key");
        }
    }

    public boolean verify(String str) throws NoSuchAlgorithmException, NoSuchProviderException, InvalidKeyException, SignatureException {
        return verify(getPublicKey(str), str);
    }

    public PKCS10CertificationRequest(String str, X509Name x509Name, PublicKey publicKey, ASN1Set aSN1Set, PrivateKey privateKey) throws NoSuchAlgorithmException, NoSuchProviderException, InvalidKeyException, SignatureException {
        this(str, x509Name, publicKey, aSN1Set, privateKey, BouncyCastleProvider.PROVIDER_NAME);
    }

    public boolean verify(PublicKey publicKey, String str) throws NoSuchAlgorithmException, NoSuchProviderException, InvalidKeyException, SignatureException {
        Signature signature;
        if (str == null) {
            try {
                signature = Signature.getInstance(getSignatureName(this.sigAlgId));
            } catch (NoSuchAlgorithmException e) {
                if (oids.get(this.sigAlgId.getAlgorithm()) != null) {
                    String str2 = (String) oids.get(this.sigAlgId.getAlgorithm());
                    if (str == null) {
                        signature = Signature.getInstance(str2);
                    } else {
                        signature = Signature.getInstance(str2, str);
                    }
                } else {
                    throw e;
                }
            }
        } else {
            signature = Signature.getInstance(getSignatureName(this.sigAlgId), str);
        }
        setSignatureParameters(signature, this.sigAlgId.getParameters());
        signature.initVerify(publicKey);
        try {
            signature.update(this.reqInfo.getEncoded(ASN1Encoding.DER));
            return signature.verify(this.sigBits.getOctets());
        } catch (Exception e2) {
            throw new SignatureException("exception encoding TBS cert request - " + e2);
        }
    }

    public PKCS10CertificationRequest(String str, X500Principal x500Principal, PublicKey publicKey, ASN1Set aSN1Set, PrivateKey privateKey) throws NoSuchAlgorithmException, NoSuchProviderException, InvalidKeyException, SignatureException {
        this(str, convertName(x500Principal), publicKey, aSN1Set, privateKey, BouncyCastleProvider.PROVIDER_NAME);
    }

    public PKCS10CertificationRequest(String str, X500Principal x500Principal, PublicKey publicKey, ASN1Set aSN1Set, PrivateKey privateKey, String str2) throws NoSuchAlgorithmException, NoSuchProviderException, InvalidKeyException, SignatureException {
        this(str, convertName(x500Principal), publicKey, aSN1Set, privateKey, str2);
    }

    public PKCS10CertificationRequest(String str, X509Name x509Name, PublicKey publicKey, ASN1Set aSN1Set, PrivateKey privateKey, String str2) throws NoSuchAlgorithmException, NoSuchProviderException, InvalidKeyException, SignatureException {
        Signature signature;
        String upperCase = Strings.toUpperCase(str);
        ASN1ObjectIdentifier aSN1ObjectIdentifier = (ASN1ObjectIdentifier) algorithms.get(upperCase);
        if (aSN1ObjectIdentifier == null) {
            try {
                aSN1ObjectIdentifier = new ASN1ObjectIdentifier(upperCase);
            } catch (Exception unused) {
                throw new IllegalArgumentException("Unknown signature type requested");
            }
        }
        if (x509Name == null) {
            throw new IllegalArgumentException("subject must not be null");
        } else if (publicKey != null) {
            if (noParams.contains(aSN1ObjectIdentifier)) {
                this.sigAlgId = new AlgorithmIdentifier(aSN1ObjectIdentifier);
            } else if (params.containsKey(upperCase)) {
                this.sigAlgId = new AlgorithmIdentifier(aSN1ObjectIdentifier, (ASN1Encodable) params.get(upperCase));
            } else {
                this.sigAlgId = new AlgorithmIdentifier(aSN1ObjectIdentifier, DERNull.INSTANCE);
            }
            try {
                this.reqInfo = new CertificationRequestInfo(x509Name, SubjectPublicKeyInfo.getInstance((ASN1Sequence) ASN1Primitive.fromByteArray(publicKey.getEncoded())), aSN1Set);
                if (str2 == null) {
                    signature = Signature.getInstance(str);
                } else {
                    signature = Signature.getInstance(str, str2);
                }
                signature.initSign(privateKey);
                try {
                    signature.update(this.reqInfo.getEncoded(ASN1Encoding.DER));
                    this.sigBits = new DERBitString(signature.sign());
                } catch (Exception e) {
                    throw new IllegalArgumentException("exception encoding TBS cert request - " + e);
                }
            } catch (IOException unused2) {
                throw new IllegalArgumentException("can't encode public key");
            }
        } else {
            throw new IllegalArgumentException("public key must not be null");
        }
    }
}
