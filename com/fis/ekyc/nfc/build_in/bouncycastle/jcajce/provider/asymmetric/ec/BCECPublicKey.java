package com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.ec;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.AlgorithmIdentifier;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x9.X9ObjectIdentifiers;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ECDomainParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ECPublicKeyParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.util.EC5Util;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.util.ECUtil;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.util.KeyUtil;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.config.ProviderConfiguration;
import com.fis.ekyc.nfc.build_in.bouncycastle.jce.interfaces.ECPointEncoder;
import com.fis.ekyc.nfc.build_in.bouncycastle.jce.provider.BouncyCastleProvider;
import com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECPoint;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.Properties;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPublicKeySpec;
import java.security.spec.EllipticCurve;

public class BCECPublicKey implements ECPublicKey, com.fis.ekyc.nfc.build_in.bouncycastle.jce.interfaces.ECPublicKey, ECPointEncoder {
    static final long serialVersionUID = 2422789860422731812L;
    private String algorithm;
    private transient ProviderConfiguration configuration;
    private transient ECPublicKeyParameters ecPublicKey;
    private transient ECParameterSpec ecSpec;
    private boolean withCompression;

    public BCECPublicKey(String str, BCECPublicKey bCECPublicKey) {
        this.algorithm = str;
        this.ecPublicKey = bCECPublicKey.ecPublicKey;
        this.ecSpec = bCECPublicKey.ecSpec;
        this.withCompression = bCECPublicKey.withCompression;
        this.configuration = bCECPublicKey.configuration;
    }

    private ECParameterSpec createSpec(EllipticCurve ellipticCurve, ECDomainParameters eCDomainParameters) {
        return new ECParameterSpec(ellipticCurve, EC5Util.convertPoint(eCDomainParameters.getG()), eCDomainParameters.getN(), eCDomainParameters.getH().intValue());
    }

    /* JADX WARNING: type inference failed for: r7v6, types: [com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void populateFromPubKeyInfo(com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.SubjectPublicKeyInfo r7) {
        /*
            r6 = this;
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.AlgorithmIdentifier r0 = r7.getAlgorithm()
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Encodable r0 = r0.getParameters()
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x9.X962Parameters r0 = com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x9.X962Parameters.getInstance(r0)
            com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.config.ProviderConfiguration r1 = r6.configuration
            com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECCurve r1 = com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.util.EC5Util.getCurve(r1, r0)
            java.security.spec.ECParameterSpec r2 = com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.util.EC5Util.convertToSpec(r0, r1)
            r6.ecSpec = r2
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERBitString r7 = r7.getPublicKeyData()
            byte[] r7 = r7.getBytes()
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DEROctetString r2 = new com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DEROctetString
            r2.<init>((byte[]) r7)
            r3 = 0
            byte r3 = r7[r3]
            r4 = 4
            if (r3 != r4) goto L_0x0057
            r3 = 1
            byte r3 = r7[r3]
            int r4 = r7.length
            r5 = 2
            int r4 = r4 - r5
            if (r3 != r4) goto L_0x0057
            byte r3 = r7[r5]
            r4 = 3
            if (r3 == r5) goto L_0x003a
            if (r3 != r4) goto L_0x0057
        L_0x003a:
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x9.X9IntegerConverter r3 = new com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x9.X9IntegerConverter
            r3.<init>()
            int r3 = r3.getByteLength((com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECCurve) r1)
            int r5 = r7.length
            int r5 = r5 - r4
            if (r3 < r5) goto L_0x0057
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive r7 = com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive.fromByteArray(r7)     // Catch:{ IOException -> 0x004f }
            r2 = r7
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1OctetString r2 = (com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1OctetString) r2     // Catch:{ IOException -> 0x004f }
            goto L_0x0057
        L_0x004f:
            java.lang.IllegalArgumentException r7 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "error recovering public key"
            r7.<init>(r0)
            throw r7
        L_0x0057:
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x9.X9ECPoint r7 = new com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x9.X9ECPoint
            r7.<init>((com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECCurve) r1, (com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1OctetString) r2)
            com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ECPublicKeyParameters r1 = new com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ECPublicKeyParameters
            com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECPoint r7 = r7.getPoint()
            com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.config.ProviderConfiguration r2 = r6.configuration
            com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ECDomainParameters r0 = com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.util.ECUtil.getDomainParameters((com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.config.ProviderConfiguration) r2, (com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x9.X962Parameters) r0)
            r1.<init>(r7, r0)
            r6.ecPublicKey = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.ec.BCECPublicKey.populateFromPubKeyInfo(com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.SubjectPublicKeyInfo):void");
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.configuration = BouncyCastleProvider.CONFIGURATION;
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
        return this.configuration.getEcImplicitlyCa();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof BCECPublicKey)) {
            return false;
        }
        BCECPublicKey bCECPublicKey = (BCECPublicKey) obj;
        if (!this.ecPublicKey.getQ().equals(bCECPublicKey.ecPublicKey.getQ()) || !engineGetSpec().equals(bCECPublicKey.engineGetSpec())) {
            return false;
        }
        return true;
    }

    public String getAlgorithm() {
        return this.algorithm;
    }

    public byte[] getEncoded() {
        boolean z;
        if (this.withCompression || Properties.isOverrideSet("com.fis.ekyc.nfc.build_in.bouncycastle.ec.enable_pc")) {
            z = true;
        } else {
            z = false;
        }
        return KeyUtil.getEncodedSubjectPublicKeyInfo(new AlgorithmIdentifier(X9ObjectIdentifiers.id_ecPublicKey, ECUtils.getDomainParametersFromName(this.ecSpec, z)), this.ecPublicKey.getQ().getEncoded(z));
    }

    public String getFormat() {
        return "X.509";
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
        ECPoint q = this.ecPublicKey.getQ();
        if (this.ecSpec == null) {
            return q.getDetachedPoint();
        }
        return q;
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
        return ECUtil.publicKeyToString("EC", this.ecPublicKey.getQ(), engineGetSpec());
    }

    public BCECPublicKey(String str, ECPublicKeySpec eCPublicKeySpec, ProviderConfiguration providerConfiguration) {
        this.algorithm = str;
        ECParameterSpec params = eCPublicKeySpec.getParams();
        this.ecSpec = params;
        this.ecPublicKey = new ECPublicKeyParameters(EC5Util.convertPoint(params, eCPublicKeySpec.getW()), EC5Util.getDomainParameters(providerConfiguration, eCPublicKeySpec.getParams()));
        this.configuration = providerConfiguration;
    }

    public BCECPublicKey(String str, com.fis.ekyc.nfc.build_in.bouncycastle.jce.spec.ECPublicKeySpec eCPublicKeySpec, ProviderConfiguration providerConfiguration) {
        this.algorithm = str;
        if (eCPublicKeySpec.getParams() != null) {
            EllipticCurve convertCurve = EC5Util.convertCurve(eCPublicKeySpec.getParams().getCurve(), eCPublicKeySpec.getParams().getSeed());
            this.ecPublicKey = new ECPublicKeyParameters(eCPublicKeySpec.getQ(), ECUtil.getDomainParameters(providerConfiguration, eCPublicKeySpec.getParams()));
            this.ecSpec = EC5Util.convertSpec(convertCurve, eCPublicKeySpec.getParams());
        } else {
            this.ecPublicKey = new ECPublicKeyParameters(providerConfiguration.getEcImplicitlyCa().getCurve().createPoint(eCPublicKeySpec.getQ().getAffineXCoord().toBigInteger(), eCPublicKeySpec.getQ().getAffineYCoord().toBigInteger()), EC5Util.getDomainParameters(providerConfiguration, (ECParameterSpec) null));
            this.ecSpec = null;
        }
        this.configuration = providerConfiguration;
    }

    public BCECPublicKey(String str, ECPublicKeyParameters eCPublicKeyParameters, ECParameterSpec eCParameterSpec, ProviderConfiguration providerConfiguration) {
        this.algorithm = "EC";
        ECDomainParameters parameters = eCPublicKeyParameters.getParameters();
        this.algorithm = str;
        this.ecPublicKey = eCPublicKeyParameters;
        if (eCParameterSpec == null) {
            this.ecSpec = createSpec(EC5Util.convertCurve(parameters.getCurve(), parameters.getSeed()), parameters);
        } else {
            this.ecSpec = eCParameterSpec;
        }
        this.configuration = providerConfiguration;
    }

    public BCECPublicKey(String str, ECPublicKeyParameters eCPublicKeyParameters, com.fis.ekyc.nfc.build_in.bouncycastle.jce.spec.ECParameterSpec eCParameterSpec, ProviderConfiguration providerConfiguration) {
        this.algorithm = "EC";
        ECDomainParameters parameters = eCPublicKeyParameters.getParameters();
        this.algorithm = str;
        if (eCParameterSpec == null) {
            this.ecSpec = createSpec(EC5Util.convertCurve(parameters.getCurve(), parameters.getSeed()), parameters);
        } else {
            this.ecSpec = EC5Util.convertSpec(EC5Util.convertCurve(eCParameterSpec.getCurve(), eCParameterSpec.getSeed()), eCParameterSpec);
        }
        this.ecPublicKey = eCPublicKeyParameters;
        this.configuration = providerConfiguration;
    }

    public BCECPublicKey(String str, ECPublicKeyParameters eCPublicKeyParameters, ProviderConfiguration providerConfiguration) {
        this.algorithm = str;
        this.ecPublicKey = eCPublicKeyParameters;
        this.ecSpec = null;
        this.configuration = providerConfiguration;
    }

    public BCECPublicKey(ECPublicKey eCPublicKey, ProviderConfiguration providerConfiguration) {
        this.algorithm = "EC";
        this.algorithm = eCPublicKey.getAlgorithm();
        ECParameterSpec params = eCPublicKey.getParams();
        this.ecSpec = params;
        this.ecPublicKey = new ECPublicKeyParameters(EC5Util.convertPoint(params, eCPublicKey.getW()), EC5Util.getDomainParameters(providerConfiguration, eCPublicKey.getParams()));
        this.configuration = providerConfiguration;
    }

    public BCECPublicKey(String str, SubjectPublicKeyInfo subjectPublicKeyInfo, ProviderConfiguration providerConfiguration) {
        this.algorithm = str;
        this.configuration = providerConfiguration;
        populateFromPubKeyInfo(subjectPublicKeyInfo);
    }
}
