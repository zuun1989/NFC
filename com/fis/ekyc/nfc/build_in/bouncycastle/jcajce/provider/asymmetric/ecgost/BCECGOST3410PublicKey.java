package com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.ecgost;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Encodable;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1OctetString;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERBitString;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DEROctetString;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.cryptopro.ECGOST3410NamedCurves;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.cryptopro.GOST3410PublicKeyAlgParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.AlgorithmIdentifier;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x9.X962Parameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x9.X9ECParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x9.X9ECPoint;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ECDomainParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ECGOST3410Parameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ECPublicKeyParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.util.EC5Util;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.util.ECUtil;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.util.KeyUtil;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.config.ProviderConfiguration;
import com.fis.ekyc.nfc.build_in.bouncycastle.jce.ECGOST3410NamedCurveTable;
import com.fis.ekyc.nfc.build_in.bouncycastle.jce.interfaces.ECPointEncoder;
import com.fis.ekyc.nfc.build_in.bouncycastle.jce.provider.BouncyCastleProvider;
import com.fis.ekyc.nfc.build_in.bouncycastle.jce.spec.ECNamedCurveParameterSpec;
import com.fis.ekyc.nfc.build_in.bouncycastle.jce.spec.ECNamedCurveSpec;
import com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECCurve;
import com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECPoint;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPublicKeySpec;
import java.security.spec.EllipticCurve;

public class BCECGOST3410PublicKey implements ECPublicKey, com.fis.ekyc.nfc.build_in.bouncycastle.jce.interfaces.ECPublicKey, ECPointEncoder {
    static final long serialVersionUID = 7026240464295649314L;
    private String algorithm;
    private transient ECPublicKeyParameters ecPublicKey;
    private transient ECParameterSpec ecSpec;
    private transient ASN1Encodable gostParams;
    private boolean withCompression;

    public BCECGOST3410PublicKey(BCECGOST3410PublicKey bCECGOST3410PublicKey) {
        this.algorithm = "ECGOST3410";
        this.ecPublicKey = bCECGOST3410PublicKey.ecPublicKey;
        this.ecSpec = bCECGOST3410PublicKey.ecSpec;
        this.withCompression = bCECGOST3410PublicKey.withCompression;
        this.gostParams = bCECGOST3410PublicKey.gostParams;
    }

    private ECParameterSpec createSpec(EllipticCurve ellipticCurve, ECDomainParameters eCDomainParameters) {
        return new ECParameterSpec(ellipticCurve, EC5Util.convertPoint(eCDomainParameters.getG()), eCDomainParameters.getN(), eCDomainParameters.getH().intValue());
    }

    private void extractBytes(byte[] bArr, int i, BigInteger bigInteger) {
        byte[] byteArray = bigInteger.toByteArray();
        if (byteArray.length < 32) {
            byte[] bArr2 = new byte[32];
            System.arraycopy(byteArray, 0, bArr2, 32 - byteArray.length, byteArray.length);
            byteArray = bArr2;
        }
        for (int i2 = 0; i2 != 32; i2++) {
            bArr[i + i2] = byteArray[(byteArray.length - 1) - i2];
        }
    }

    private void populateFromPubKeyInfo(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        ASN1ObjectIdentifier aSN1ObjectIdentifier;
        DERBitString publicKeyData = subjectPublicKeyInfo.getPublicKeyData();
        this.algorithm = "ECGOST3410";
        try {
            byte[] octets = ((ASN1OctetString) ASN1Primitive.fromByteArray(publicKeyData.getBytes())).getOctets();
            byte[] bArr = new byte[65];
            bArr[0] = 4;
            for (int i = 1; i <= 32; i++) {
                bArr[i] = octets[32 - i];
                bArr[i + 32] = octets[64 - i];
            }
            if (subjectPublicKeyInfo.getAlgorithm().getParameters() instanceof ASN1ObjectIdentifier) {
                aSN1ObjectIdentifier = ASN1ObjectIdentifier.getInstance(subjectPublicKeyInfo.getAlgorithm().getParameters());
                this.gostParams = aSN1ObjectIdentifier;
            } else {
                GOST3410PublicKeyAlgParameters instance = GOST3410PublicKeyAlgParameters.getInstance(subjectPublicKeyInfo.getAlgorithm().getParameters());
                this.gostParams = instance;
                aSN1ObjectIdentifier = instance.getPublicKeyParamSet();
            }
            ECNamedCurveParameterSpec parameterSpec = ECGOST3410NamedCurveTable.getParameterSpec(ECGOST3410NamedCurves.getName(aSN1ObjectIdentifier));
            ECCurve curve = parameterSpec.getCurve();
            EllipticCurve convertCurve = EC5Util.convertCurve(curve, parameterSpec.getSeed());
            this.ecPublicKey = new ECPublicKeyParameters(curve.decodePoint(bArr), ECUtil.getDomainParameters((ProviderConfiguration) null, (com.fis.ekyc.nfc.build_in.bouncycastle.jce.spec.ECParameterSpec) parameterSpec));
            this.ecSpec = new ECNamedCurveSpec(ECGOST3410NamedCurves.getName(aSN1ObjectIdentifier), convertCurve, EC5Util.convertPoint(parameterSpec.getG()), parameterSpec.getN(), parameterSpec.getH());
        } catch (IOException unused) {
            throw new IllegalArgumentException("error recovering public key");
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        populateFromPubKeyInfo(SubjectPublicKeyInfo.getInstance(ASN1Primitive.fromByteArray((byte[]) objectInputStream.readObject())));
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(getEncoded());
    }

    public ECPublicKeyParameters engineGetKeyParameters() {
        return this.ecPublicKey;
    }

    public com.fis.ekyc.nfc.build_in.bouncycastle.jce.spec.ECParameterSpec engineGetSpec() {
        ECParameterSpec eCParameterSpec = this.ecSpec;
        if (eCParameterSpec != null) {
            return EC5Util.convertSpec(eCParameterSpec);
        }
        return BouncyCastleProvider.CONFIGURATION.getEcImplicitlyCa();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof BCECGOST3410PublicKey)) {
            return false;
        }
        BCECGOST3410PublicKey bCECGOST3410PublicKey = (BCECGOST3410PublicKey) obj;
        if (!this.ecPublicKey.getQ().equals(bCECGOST3410PublicKey.ecPublicKey.getQ()) || !engineGetSpec().equals(bCECGOST3410PublicKey.engineGetSpec())) {
            return false;
        }
        return true;
    }

    public String getAlgorithm() {
        return this.algorithm;
    }

    public byte[] getEncoded() {
        ASN1Encodable x962Parameters;
        ASN1Encodable gostParams2 = getGostParams();
        if (gostParams2 == null) {
            ECParameterSpec eCParameterSpec = this.ecSpec;
            if (eCParameterSpec instanceof ECNamedCurveSpec) {
                x962Parameters = new GOST3410PublicKeyAlgParameters(ECGOST3410NamedCurves.getOID(((ECNamedCurveSpec) eCParameterSpec).getName()), CryptoProObjectIdentifiers.gostR3411_94_CryptoProParamSet);
            } else {
                ECCurve convertCurve = EC5Util.convertCurve(eCParameterSpec.getCurve());
                x962Parameters = new X962Parameters(new X9ECParameters(convertCurve, new X9ECPoint(EC5Util.convertPoint(convertCurve, this.ecSpec.getGenerator()), this.withCompression), this.ecSpec.getOrder(), BigInteger.valueOf((long) this.ecSpec.getCofactor()), this.ecSpec.getCurve().getSeed()));
            }
            gostParams2 = x962Parameters;
        }
        BigInteger bigInteger = this.ecPublicKey.getQ().getAffineXCoord().toBigInteger();
        BigInteger bigInteger2 = this.ecPublicKey.getQ().getAffineYCoord().toBigInteger();
        byte[] bArr = new byte[64];
        extractBytes(bArr, 0, bigInteger);
        extractBytes(bArr, 32, bigInteger2);
        try {
            return KeyUtil.getEncodedSubjectPublicKeyInfo(new SubjectPublicKeyInfo(new AlgorithmIdentifier(CryptoProObjectIdentifiers.gostR3410_2001, gostParams2), (ASN1Encodable) new DEROctetString(bArr)));
        } catch (IOException unused) {
            return null;
        }
    }

    public String getFormat() {
        return "X.509";
    }

    public ASN1Encodable getGostParams() {
        if (this.gostParams == null) {
            ECParameterSpec eCParameterSpec = this.ecSpec;
            if (eCParameterSpec instanceof ECNamedCurveSpec) {
                this.gostParams = new GOST3410PublicKeyAlgParameters(ECGOST3410NamedCurves.getOID(((ECNamedCurveSpec) eCParameterSpec).getName()), CryptoProObjectIdentifiers.gostR3411_94_CryptoProParamSet);
            }
        }
        return this.gostParams;
    }

    public com.fis.ekyc.nfc.build_in.bouncycastle.jce.spec.ECParameterSpec getParameters() {
        ECParameterSpec eCParameterSpec = this.ecSpec;
        if (eCParameterSpec == null) {
            return null;
        }
        return EC5Util.convertSpec(eCParameterSpec);
    }

    public ECParameterSpec getParams() {
        return this.ecSpec;
    }

    public ECPoint getQ() {
        if (this.ecSpec == null) {
            return this.ecPublicKey.getQ().getDetachedPoint();
        }
        return this.ecPublicKey.getQ();
    }

    public java.security.spec.ECPoint getW() {
        return EC5Util.convertPoint(this.ecPublicKey.getQ());
    }

    public int hashCode() {
        return this.ecPublicKey.getQ().hashCode() ^ engineGetSpec().hashCode();
    }

    public void setPointFormat(String str) {
        this.withCompression = !"UNCOMPRESSED".equalsIgnoreCase(str);
    }

    public String toString() {
        return ECUtil.publicKeyToString(this.algorithm, this.ecPublicKey.getQ(), engineGetSpec());
    }

    public BCECGOST3410PublicKey(ECPublicKeySpec eCPublicKeySpec) {
        this.algorithm = "ECGOST3410";
        ECParameterSpec params = eCPublicKeySpec.getParams();
        this.ecSpec = params;
        this.ecPublicKey = new ECPublicKeyParameters(EC5Util.convertPoint(params, eCPublicKeySpec.getW()), EC5Util.getDomainParameters((ProviderConfiguration) null, eCPublicKeySpec.getParams()));
    }

    public BCECGOST3410PublicKey(com.fis.ekyc.nfc.build_in.bouncycastle.jce.spec.ECPublicKeySpec eCPublicKeySpec, ProviderConfiguration providerConfiguration) {
        this.algorithm = "ECGOST3410";
        if (eCPublicKeySpec.getParams() != null) {
            EllipticCurve convertCurve = EC5Util.convertCurve(eCPublicKeySpec.getParams().getCurve(), eCPublicKeySpec.getParams().getSeed());
            this.ecPublicKey = new ECPublicKeyParameters(eCPublicKeySpec.getQ(), ECUtil.getDomainParameters(providerConfiguration, eCPublicKeySpec.getParams()));
            this.ecSpec = EC5Util.convertSpec(convertCurve, eCPublicKeySpec.getParams());
            return;
        }
        this.ecPublicKey = new ECPublicKeyParameters(providerConfiguration.getEcImplicitlyCa().getCurve().createPoint(eCPublicKeySpec.getQ().getAffineXCoord().toBigInteger(), eCPublicKeySpec.getQ().getAffineYCoord().toBigInteger()), EC5Util.getDomainParameters(providerConfiguration, (ECParameterSpec) null));
        this.ecSpec = null;
    }

    public BCECGOST3410PublicKey(String str, ECPublicKeyParameters eCPublicKeyParameters, ECParameterSpec eCParameterSpec) {
        this.algorithm = "ECGOST3410";
        ECDomainParameters parameters = eCPublicKeyParameters.getParameters();
        if (parameters instanceof ECGOST3410Parameters) {
            ECGOST3410Parameters eCGOST3410Parameters = (ECGOST3410Parameters) parameters;
            this.gostParams = new GOST3410PublicKeyAlgParameters(eCGOST3410Parameters.getPublicKeyParamSet(), eCGOST3410Parameters.getDigestParamSet(), eCGOST3410Parameters.getEncryptionParamSet());
        }
        this.algorithm = str;
        this.ecPublicKey = eCPublicKeyParameters;
        if (eCParameterSpec == null) {
            this.ecSpec = createSpec(EC5Util.convertCurve(parameters.getCurve(), parameters.getSeed()), parameters);
        } else {
            this.ecSpec = eCParameterSpec;
        }
    }

    public BCECGOST3410PublicKey(String str, ECPublicKeyParameters eCPublicKeyParameters, com.fis.ekyc.nfc.build_in.bouncycastle.jce.spec.ECParameterSpec eCParameterSpec) {
        this.algorithm = "ECGOST3410";
        ECDomainParameters parameters = eCPublicKeyParameters.getParameters();
        this.algorithm = str;
        this.ecPublicKey = eCPublicKeyParameters;
        if (eCParameterSpec == null) {
            this.ecSpec = createSpec(EC5Util.convertCurve(parameters.getCurve(), parameters.getSeed()), parameters);
        } else {
            this.ecSpec = EC5Util.convertSpec(EC5Util.convertCurve(eCParameterSpec.getCurve(), eCParameterSpec.getSeed()), eCParameterSpec);
        }
    }

    public BCECGOST3410PublicKey(String str, ECPublicKeyParameters eCPublicKeyParameters) {
        this.algorithm = str;
        this.ecPublicKey = eCPublicKeyParameters;
        this.ecSpec = null;
    }

    public BCECGOST3410PublicKey(ECPublicKey eCPublicKey) {
        this.algorithm = "ECGOST3410";
        this.algorithm = eCPublicKey.getAlgorithm();
        ECParameterSpec params = eCPublicKey.getParams();
        this.ecSpec = params;
        this.ecPublicKey = new ECPublicKeyParameters(EC5Util.convertPoint(params, eCPublicKey.getW()), EC5Util.getDomainParameters((ProviderConfiguration) null, eCPublicKey.getParams()));
    }

    public BCECGOST3410PublicKey(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        this.algorithm = "ECGOST3410";
        populateFromPubKeyInfo(subjectPublicKeyInfo);
    }
}
