package com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.gost;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Encodable;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Encoding;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Integer;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1OctetString;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DEROctetString;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.cryptopro.GOST3410PublicKeyAlgParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.AlgorithmIdentifier;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.GOST3410PrivateKeyParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.util.GOST3410Util;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.util.PKCS12BagAttributeCarrierImpl;
import com.fis.ekyc.nfc.build_in.bouncycastle.jce.interfaces.GOST3410Params;
import com.fis.ekyc.nfc.build_in.bouncycastle.jce.interfaces.GOST3410PrivateKey;
import com.fis.ekyc.nfc.build_in.bouncycastle.jce.interfaces.PKCS12BagAttributeCarrier;
import com.fis.ekyc.nfc.build_in.bouncycastle.jce.spec.GOST3410ParameterSpec;
import com.fis.ekyc.nfc.build_in.bouncycastle.jce.spec.GOST3410PrivateKeySpec;
import com.fis.ekyc.nfc.build_in.bouncycastle.jce.spec.GOST3410PublicKeyParameterSetSpec;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.util.Enumeration;

public class BCGOST3410PrivateKey implements GOST3410PrivateKey, PKCS12BagAttributeCarrier {
    static final long serialVersionUID = 8581661527592305464L;
    private transient PKCS12BagAttributeCarrier attrCarrier = new PKCS12BagAttributeCarrierImpl();
    private transient GOST3410Params gost3410Spec;
    private BigInteger x;

    public BCGOST3410PrivateKey() {
    }

    private boolean compareObj(Object obj, Object obj2) {
        if (obj == obj2) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        return obj.equals(obj2);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        String str = (String) objectInputStream.readObject();
        if (str != null) {
            this.gost3410Spec = new GOST3410ParameterSpec(str, (String) objectInputStream.readObject(), (String) objectInputStream.readObject());
        } else {
            this.gost3410Spec = new GOST3410ParameterSpec(new GOST3410PublicKeyParameterSetSpec((BigInteger) objectInputStream.readObject(), (BigInteger) objectInputStream.readObject(), (BigInteger) objectInputStream.readObject()));
            objectInputStream.readObject();
            objectInputStream.readObject();
        }
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        if (this.gost3410Spec.getPublicKeyParamSetOID() != null) {
            objectOutputStream.writeObject(this.gost3410Spec.getPublicKeyParamSetOID());
            objectOutputStream.writeObject(this.gost3410Spec.getDigestParamSetOID());
            objectOutputStream.writeObject(this.gost3410Spec.getEncryptionParamSetOID());
            return;
        }
        objectOutputStream.writeObject((Object) null);
        objectOutputStream.writeObject(this.gost3410Spec.getPublicKeyParameters().getP());
        objectOutputStream.writeObject(this.gost3410Spec.getPublicKeyParameters().getQ());
        objectOutputStream.writeObject(this.gost3410Spec.getPublicKeyParameters().getA());
        objectOutputStream.writeObject(this.gost3410Spec.getDigestParamSetOID());
        objectOutputStream.writeObject(this.gost3410Spec.getEncryptionParamSetOID());
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof GOST3410PrivateKey)) {
            return false;
        }
        GOST3410PrivateKey gOST3410PrivateKey = (GOST3410PrivateKey) obj;
        if (!getX().equals(gOST3410PrivateKey.getX()) || !getParameters().getPublicKeyParameters().equals(gOST3410PrivateKey.getParameters().getPublicKeyParameters()) || !getParameters().getDigestParamSetOID().equals(gOST3410PrivateKey.getParameters().getDigestParamSetOID()) || !compareObj(getParameters().getEncryptionParamSetOID(), gOST3410PrivateKey.getParameters().getEncryptionParamSetOID())) {
            return false;
        }
        return true;
    }

    public String getAlgorithm() {
        return "GOST3410";
    }

    public ASN1Encodable getBagAttribute(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return this.attrCarrier.getBagAttribute(aSN1ObjectIdentifier);
    }

    public Enumeration getBagAttributeKeys() {
        return this.attrCarrier.getBagAttributeKeys();
    }

    public byte[] getEncoded() {
        byte[] bArr;
        PrivateKeyInfo privateKeyInfo;
        byte[] byteArray = getX().toByteArray();
        if (byteArray[0] == 0) {
            bArr = new byte[(byteArray.length - 1)];
        } else {
            bArr = new byte[byteArray.length];
        }
        for (int i = 0; i != bArr.length; i++) {
            bArr[i] = byteArray[(byteArray.length - 1) - i];
        }
        try {
            if (this.gost3410Spec instanceof GOST3410ParameterSpec) {
                privateKeyInfo = new PrivateKeyInfo(new AlgorithmIdentifier(CryptoProObjectIdentifiers.gostR3410_94, new GOST3410PublicKeyAlgParameters(new ASN1ObjectIdentifier(this.gost3410Spec.getPublicKeyParamSetOID()), new ASN1ObjectIdentifier(this.gost3410Spec.getDigestParamSetOID()))), new DEROctetString(bArr));
            } else {
                privateKeyInfo = new PrivateKeyInfo(new AlgorithmIdentifier(CryptoProObjectIdentifiers.gostR3410_94), new DEROctetString(bArr));
            }
            return privateKeyInfo.getEncoded(ASN1Encoding.DER);
        } catch (IOException unused) {
            return null;
        }
    }

    public String getFormat() {
        return "PKCS#8";
    }

    public GOST3410Params getParameters() {
        return this.gost3410Spec;
    }

    public BigInteger getX() {
        return this.x;
    }

    public int hashCode() {
        return getX().hashCode() ^ this.gost3410Spec.hashCode();
    }

    public void setBagAttribute(ASN1ObjectIdentifier aSN1ObjectIdentifier, ASN1Encodable aSN1Encodable) {
        this.attrCarrier.setBagAttribute(aSN1ObjectIdentifier, aSN1Encodable);
    }

    public String toString() {
        try {
            return GOSTUtil.privateKeyToString("GOST3410", this.x, ((GOST3410PrivateKeyParameters) GOST3410Util.generatePrivateKeyParameter(this)).getParameters());
        } catch (InvalidKeyException e) {
            throw new IllegalStateException(e.getMessage());
        }
    }

    public BCGOST3410PrivateKey(GOST3410PrivateKey gOST3410PrivateKey) {
        this.x = gOST3410PrivateKey.getX();
        this.gost3410Spec = gOST3410PrivateKey.getParameters();
    }

    public BCGOST3410PrivateKey(GOST3410PrivateKeySpec gOST3410PrivateKeySpec) {
        this.x = gOST3410PrivateKeySpec.getX();
        this.gost3410Spec = new GOST3410ParameterSpec(new GOST3410PublicKeyParameterSetSpec(gOST3410PrivateKeySpec.getP(), gOST3410PrivateKeySpec.getQ(), gOST3410PrivateKeySpec.getA()));
    }

    public BCGOST3410PrivateKey(PrivateKeyInfo privateKeyInfo) throws IOException {
        GOST3410PublicKeyAlgParameters instance = GOST3410PublicKeyAlgParameters.getInstance(privateKeyInfo.getPrivateKeyAlgorithm().getParameters());
        ASN1Encodable parsePrivateKey = privateKeyInfo.parsePrivateKey();
        if (parsePrivateKey instanceof ASN1Integer) {
            this.x = ASN1Integer.getInstance(parsePrivateKey).getPositiveValue();
        } else {
            byte[] octets = ASN1OctetString.getInstance(privateKeyInfo.parsePrivateKey()).getOctets();
            byte[] bArr = new byte[octets.length];
            for (int i = 0; i != octets.length; i++) {
                bArr[i] = octets[(octets.length - 1) - i];
            }
            this.x = new BigInteger(1, bArr);
        }
        this.gost3410Spec = GOST3410ParameterSpec.fromPublicKeyAlg(instance);
    }

    public BCGOST3410PrivateKey(GOST3410PrivateKeyParameters gOST3410PrivateKeyParameters, GOST3410ParameterSpec gOST3410ParameterSpec) {
        this.x = gOST3410PrivateKeyParameters.getX();
        this.gost3410Spec = gOST3410ParameterSpec;
        if (gOST3410ParameterSpec == null) {
            throw new IllegalArgumentException("spec is null");
        }
    }
}
