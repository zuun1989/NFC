package com.fis.ekyc.nfc.build_in.bouncycastle.jce.provider;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Encodable;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Null;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERNull;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DEROctetString;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.cryptopro.ECGOST3410NamedCurves;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.cryptopro.GOST3410PublicKeyAlgParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.AlgorithmIdentifier;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x9.X962Parameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x9.X9ECParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x9.X9ECPoint;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x9.X9ObjectIdentifiers;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ECDomainParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ECPublicKeyParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.util.EC5Util;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.util.ECUtil;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.util.KeyUtil;
import com.fis.ekyc.nfc.build_in.bouncycastle.jce.interfaces.ECPointEncoder;
import com.fis.ekyc.nfc.build_in.bouncycastle.jce.spec.ECNamedCurveSpec;
import com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECCurve;
import com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECPoint;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.Strings;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPublicKeySpec;
import java.security.spec.EllipticCurve;

public class JCEECPublicKey implements ECPublicKey, com.fis.ekyc.nfc.build_in.bouncycastle.jce.interfaces.ECPublicKey, ECPointEncoder {
    private String algorithm;
    private ECParameterSpec ecSpec;
    private GOST3410PublicKeyAlgParameters gostParams;
    private ECPoint q;
    private boolean withCompression;

    public JCEECPublicKey(String str, JCEECPublicKey jCEECPublicKey) {
        this.algorithm = str;
        this.q = jCEECPublicKey.q;
        this.ecSpec = jCEECPublicKey.ecSpec;
        this.withCompression = jCEECPublicKey.withCompression;
        this.gostParams = jCEECPublicKey.gostParams;
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

    /* JADX WARNING: type inference failed for: r15v6, types: [com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void populateFromPubKeyInfo(com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.SubjectPublicKeyInfo r15) {
        /*
            r14 = this;
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.AlgorithmIdentifier r0 = r15.getAlgorithm()
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier r1 = r0.getAlgorithm()
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier r2 = com.fis.ekyc.nfc.build_in.bouncycastle.asn1.cryptopro.CryptoProObjectIdentifiers.gostR3410_2001
            boolean r1 = r1.equals((com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive) r2)
            java.lang.String r2 = "error recovering public key"
            r3 = 4
            r4 = 0
            r5 = 1
            if (r1 == 0) goto L_0x0098
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERBitString r15 = r15.getPublicKeyData()
            java.lang.String r1 = "ECGOST3410"
            r14.algorithm = r1
            byte[] r15 = r15.getBytes()     // Catch:{ IOException -> 0x0092 }
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive r15 = com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive.fromByteArray(r15)     // Catch:{ IOException -> 0x0092 }
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1OctetString r15 = (com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1OctetString) r15     // Catch:{ IOException -> 0x0092 }
            byte[] r15 = r15.getOctets()
            r1 = 65
            byte[] r1 = new byte[r1]
            r1[r4] = r3
        L_0x0031:
            r2 = 32
            if (r5 > r2) goto L_0x0046
            int r2 = 32 - r5
            byte r2 = r15[r2]
            r1[r5] = r2
            int r2 = r5 + 32
            int r3 = 64 - r5
            byte r3 = r15[r3]
            r1[r2] = r3
            int r5 = r5 + 1
            goto L_0x0031
        L_0x0046:
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Encodable r15 = r0.getParameters()
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.cryptopro.GOST3410PublicKeyAlgParameters r15 = com.fis.ekyc.nfc.build_in.bouncycastle.asn1.cryptopro.GOST3410PublicKeyAlgParameters.getInstance(r15)
            r14.gostParams = r15
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier r15 = r15.getPublicKeyParamSet()
            java.lang.String r15 = com.fis.ekyc.nfc.build_in.bouncycastle.asn1.cryptopro.ECGOST3410NamedCurves.getName(r15)
            com.fis.ekyc.nfc.build_in.bouncycastle.jce.spec.ECNamedCurveParameterSpec r15 = com.fis.ekyc.nfc.build_in.bouncycastle.jce.ECGOST3410NamedCurveTable.getParameterSpec(r15)
            com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECCurve r0 = r15.getCurve()
            byte[] r2 = r15.getSeed()
            java.security.spec.EllipticCurve r5 = com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.util.EC5Util.convertCurve(r0, r2)
            com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECPoint r0 = r0.decodePoint(r1)
            r14.q = r0
            com.fis.ekyc.nfc.build_in.bouncycastle.jce.spec.ECNamedCurveSpec r0 = new com.fis.ekyc.nfc.build_in.bouncycastle.jce.spec.ECNamedCurveSpec
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.cryptopro.GOST3410PublicKeyAlgParameters r1 = r14.gostParams
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier r1 = r1.getPublicKeyParamSet()
            java.lang.String r4 = com.fis.ekyc.nfc.build_in.bouncycastle.asn1.cryptopro.ECGOST3410NamedCurves.getName(r1)
            com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECPoint r1 = r15.getG()
            java.security.spec.ECPoint r6 = com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.util.EC5Util.convertPoint(r1)
            java.math.BigInteger r7 = r15.getN()
            java.math.BigInteger r8 = r15.getH()
            r3 = r0
            r3.<init>((java.lang.String) r4, (java.security.spec.EllipticCurve) r5, (java.security.spec.ECPoint) r6, (java.math.BigInteger) r7, (java.math.BigInteger) r8)
            r14.ecSpec = r0
            goto L_0x0161
        L_0x0092:
            java.lang.IllegalArgumentException r15 = new java.lang.IllegalArgumentException
            r15.<init>(r2)
            throw r15
        L_0x0098:
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Encodable r0 = r0.getParameters()
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x9.X962Parameters r0 = com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x9.X962Parameters.getInstance(r0)
            boolean r1 = r0.isNamedCurve()
            if (r1 == 0) goto L_0x00d9
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive r0 = r0.getParameters()
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier r0 = (com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier) r0
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x9.X9ECParameters r1 = com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.util.ECUtil.getNamedCurveByOid(r0)
            com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECCurve r6 = r1.getCurve()
            byte[] r7 = r1.getSeed()
            java.security.spec.EllipticCurve r10 = com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.util.EC5Util.convertCurve(r6, r7)
            com.fis.ekyc.nfc.build_in.bouncycastle.jce.spec.ECNamedCurveSpec r7 = new com.fis.ekyc.nfc.build_in.bouncycastle.jce.spec.ECNamedCurveSpec
            java.lang.String r9 = com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.util.ECUtil.getCurveName(r0)
            com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECPoint r0 = r1.getG()
            java.security.spec.ECPoint r11 = com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.util.EC5Util.convertPoint(r0)
            java.math.BigInteger r12 = r1.getN()
            java.math.BigInteger r13 = r1.getH()
            r8 = r7
            r8.<init>((java.lang.String) r9, (java.security.spec.EllipticCurve) r10, (java.security.spec.ECPoint) r11, (java.math.BigInteger) r12, (java.math.BigInteger) r13)
            r14.ecSpec = r7
            goto L_0x011c
        L_0x00d9:
            boolean r1 = r0.isImplicitlyCA()
            if (r1 == 0) goto L_0x00ed
            r0 = 0
            r14.ecSpec = r0
            com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.config.ProviderConfiguration r0 = com.fis.ekyc.nfc.build_in.bouncycastle.jce.provider.BouncyCastleProvider.CONFIGURATION
            com.fis.ekyc.nfc.build_in.bouncycastle.jce.spec.ECParameterSpec r0 = r0.getEcImplicitlyCa()
            com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECCurve r6 = r0.getCurve()
            goto L_0x011c
        L_0x00ed:
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive r0 = r0.getParameters()
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x9.X9ECParameters r0 = com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x9.X9ECParameters.getInstance(r0)
            com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECCurve r6 = r0.getCurve()
            byte[] r1 = r0.getSeed()
            java.security.spec.EllipticCurve r1 = com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.util.EC5Util.convertCurve(r6, r1)
            java.security.spec.ECParameterSpec r7 = new java.security.spec.ECParameterSpec
            com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECPoint r8 = r0.getG()
            java.security.spec.ECPoint r8 = com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.util.EC5Util.convertPoint(r8)
            java.math.BigInteger r9 = r0.getN()
            java.math.BigInteger r0 = r0.getH()
            int r0 = r0.intValue()
            r7.<init>(r1, r8, r9, r0)
            r14.ecSpec = r7
        L_0x011c:
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERBitString r15 = r15.getPublicKeyData()
            byte[] r15 = r15.getBytes()
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DEROctetString r0 = new com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DEROctetString
            r0.<init>((byte[]) r15)
            byte r1 = r15[r4]
            if (r1 != r3) goto L_0x0156
            byte r1 = r15[r5]
            int r3 = r15.length
            r4 = 2
            int r3 = r3 - r4
            if (r1 != r3) goto L_0x0156
            byte r1 = r15[r4]
            r3 = 3
            if (r1 == r4) goto L_0x013b
            if (r1 != r3) goto L_0x0156
        L_0x013b:
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x9.X9IntegerConverter r1 = new com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x9.X9IntegerConverter
            r1.<init>()
            int r1 = r1.getByteLength((com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECCurve) r6)
            int r4 = r15.length
            int r4 = r4 - r3
            if (r1 < r4) goto L_0x0156
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive r15 = com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive.fromByteArray(r15)     // Catch:{ IOException -> 0x0150 }
            r0 = r15
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1OctetString r0 = (com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1OctetString) r0     // Catch:{ IOException -> 0x0150 }
            goto L_0x0156
        L_0x0150:
            java.lang.IllegalArgumentException r15 = new java.lang.IllegalArgumentException
            r15.<init>(r2)
            throw r15
        L_0x0156:
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x9.X9ECPoint r15 = new com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x9.X9ECPoint
            r15.<init>((com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECCurve) r6, (com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1OctetString) r0)
            com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECPoint r15 = r15.getPoint()
            r14.q = r15
        L_0x0161:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fis.ekyc.nfc.build_in.bouncycastle.jce.provider.JCEECPublicKey.populateFromPubKeyInfo(com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.SubjectPublicKeyInfo):void");
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        populateFromPubKeyInfo(SubjectPublicKeyInfo.getInstance(ASN1Primitive.fromByteArray((byte[]) objectInputStream.readObject())));
        this.algorithm = (String) objectInputStream.readObject();
        this.withCompression = objectInputStream.readBoolean();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeObject(getEncoded());
        objectOutputStream.writeObject(this.algorithm);
        objectOutputStream.writeBoolean(this.withCompression);
    }

    public ECPoint engineGetQ() {
        return this.q;
    }

    public com.fis.ekyc.nfc.build_in.bouncycastle.jce.spec.ECParameterSpec engineGetSpec() {
        ECParameterSpec eCParameterSpec = this.ecSpec;
        if (eCParameterSpec != null) {
            return EC5Util.convertSpec(eCParameterSpec);
        }
        return BouncyCastleProvider.CONFIGURATION.getEcImplicitlyCa();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof JCEECPublicKey)) {
            return false;
        }
        JCEECPublicKey jCEECPublicKey = (JCEECPublicKey) obj;
        if (!engineGetQ().equals(jCEECPublicKey.engineGetQ()) || !engineGetSpec().equals(jCEECPublicKey.engineGetSpec())) {
            return false;
        }
        return true;
    }

    public String getAlgorithm() {
        return this.algorithm;
    }

    public byte[] getEncoded() {
        SubjectPublicKeyInfo subjectPublicKeyInfo;
        X962Parameters x962Parameters;
        ASN1Encodable x962Parameters2;
        if (this.algorithm.equals("ECGOST3410")) {
            ASN1Encodable aSN1Encodable = this.gostParams;
            if (aSN1Encodable == null) {
                ECParameterSpec eCParameterSpec = this.ecSpec;
                if (eCParameterSpec instanceof ECNamedCurveSpec) {
                    x962Parameters2 = new GOST3410PublicKeyAlgParameters(ECGOST3410NamedCurves.getOID(((ECNamedCurveSpec) eCParameterSpec).getName()), CryptoProObjectIdentifiers.gostR3411_94_CryptoProParamSet);
                } else {
                    ECCurve convertCurve = EC5Util.convertCurve(eCParameterSpec.getCurve());
                    x962Parameters2 = new X962Parameters(new X9ECParameters(convertCurve, new X9ECPoint(EC5Util.convertPoint(convertCurve, this.ecSpec.getGenerator()), this.withCompression), this.ecSpec.getOrder(), BigInteger.valueOf((long) this.ecSpec.getCofactor()), this.ecSpec.getCurve().getSeed()));
                }
                aSN1Encodable = x962Parameters2;
            }
            BigInteger bigInteger = this.q.getAffineXCoord().toBigInteger();
            BigInteger bigInteger2 = this.q.getAffineYCoord().toBigInteger();
            byte[] bArr = new byte[64];
            extractBytes(bArr, 0, bigInteger);
            extractBytes(bArr, 32, bigInteger2);
            try {
                subjectPublicKeyInfo = new SubjectPublicKeyInfo(new AlgorithmIdentifier(CryptoProObjectIdentifiers.gostR3410_2001, aSN1Encodable), (ASN1Encodable) new DEROctetString(bArr));
            } catch (IOException unused) {
                return null;
            }
        } else {
            ECParameterSpec eCParameterSpec2 = this.ecSpec;
            if (eCParameterSpec2 instanceof ECNamedCurveSpec) {
                ASN1ObjectIdentifier namedCurveOid = ECUtil.getNamedCurveOid(((ECNamedCurveSpec) eCParameterSpec2).getName());
                if (namedCurveOid == null) {
                    namedCurveOid = new ASN1ObjectIdentifier(((ECNamedCurveSpec) this.ecSpec).getName());
                }
                x962Parameters = new X962Parameters(namedCurveOid);
            } else if (eCParameterSpec2 == null) {
                x962Parameters = new X962Parameters((ASN1Null) DERNull.INSTANCE);
            } else {
                ECCurve convertCurve2 = EC5Util.convertCurve(eCParameterSpec2.getCurve());
                x962Parameters = new X962Parameters(new X9ECParameters(convertCurve2, new X9ECPoint(EC5Util.convertPoint(convertCurve2, this.ecSpec.getGenerator()), this.withCompression), this.ecSpec.getOrder(), BigInteger.valueOf((long) this.ecSpec.getCofactor()), this.ecSpec.getCurve().getSeed()));
            }
            subjectPublicKeyInfo = new SubjectPublicKeyInfo(new AlgorithmIdentifier(X9ObjectIdentifiers.id_ecPublicKey, x962Parameters), getQ().getEncoded(this.withCompression));
        }
        return KeyUtil.getEncodedSubjectPublicKeyInfo(subjectPublicKeyInfo);
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
        if (this.ecSpec == null) {
            return this.q.getDetachedPoint();
        }
        return this.q;
    }

    public java.security.spec.ECPoint getW() {
        return EC5Util.convertPoint(this.q);
    }

    public int hashCode() {
        return engineGetQ().hashCode() ^ engineGetSpec().hashCode();
    }

    public void setPointFormat(String str) {
        this.withCompression = !"UNCOMPRESSED".equalsIgnoreCase(str);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        String lineSeparator = Strings.lineSeparator();
        stringBuffer.append("EC Public Key");
        stringBuffer.append(lineSeparator);
        stringBuffer.append("            X: ");
        stringBuffer.append(this.q.getAffineXCoord().toBigInteger().toString(16));
        stringBuffer.append(lineSeparator);
        stringBuffer.append("            Y: ");
        stringBuffer.append(this.q.getAffineYCoord().toBigInteger().toString(16));
        stringBuffer.append(lineSeparator);
        return stringBuffer.toString();
    }

    public JCEECPublicKey(String str, ECPublicKeySpec eCPublicKeySpec) {
        this.algorithm = str;
        ECParameterSpec params = eCPublicKeySpec.getParams();
        this.ecSpec = params;
        this.q = EC5Util.convertPoint(params, eCPublicKeySpec.getW());
    }

    public JCEECPublicKey(String str, com.fis.ekyc.nfc.build_in.bouncycastle.jce.spec.ECPublicKeySpec eCPublicKeySpec) {
        this.algorithm = str;
        this.q = eCPublicKeySpec.getQ();
        if (eCPublicKeySpec.getParams() != null) {
            this.ecSpec = EC5Util.convertSpec(EC5Util.convertCurve(eCPublicKeySpec.getParams().getCurve(), eCPublicKeySpec.getParams().getSeed()), eCPublicKeySpec.getParams());
            return;
        }
        if (this.q.getCurve() == null) {
            this.q = BouncyCastleProvider.CONFIGURATION.getEcImplicitlyCa().getCurve().createPoint(this.q.getAffineXCoord().toBigInteger(), this.q.getAffineYCoord().toBigInteger());
        }
        this.ecSpec = null;
    }

    public JCEECPublicKey(String str, ECPublicKeyParameters eCPublicKeyParameters, ECParameterSpec eCParameterSpec) {
        this.algorithm = "EC";
        ECDomainParameters parameters = eCPublicKeyParameters.getParameters();
        this.algorithm = str;
        this.q = eCPublicKeyParameters.getQ();
        if (eCParameterSpec == null) {
            this.ecSpec = createSpec(EC5Util.convertCurve(parameters.getCurve(), parameters.getSeed()), parameters);
        } else {
            this.ecSpec = eCParameterSpec;
        }
    }

    public JCEECPublicKey(String str, ECPublicKeyParameters eCPublicKeyParameters, com.fis.ekyc.nfc.build_in.bouncycastle.jce.spec.ECParameterSpec eCParameterSpec) {
        this.algorithm = "EC";
        ECDomainParameters parameters = eCPublicKeyParameters.getParameters();
        this.algorithm = str;
        this.q = eCPublicKeyParameters.getQ();
        if (eCParameterSpec == null) {
            this.ecSpec = createSpec(EC5Util.convertCurve(parameters.getCurve(), parameters.getSeed()), parameters);
        } else {
            this.ecSpec = EC5Util.convertSpec(EC5Util.convertCurve(eCParameterSpec.getCurve(), eCParameterSpec.getSeed()), eCParameterSpec);
        }
    }

    public JCEECPublicKey(String str, ECPublicKeyParameters eCPublicKeyParameters) {
        this.algorithm = str;
        this.q = eCPublicKeyParameters.getQ();
        this.ecSpec = null;
    }

    public JCEECPublicKey(ECPublicKey eCPublicKey) {
        this.algorithm = "EC";
        this.algorithm = eCPublicKey.getAlgorithm();
        ECParameterSpec params = eCPublicKey.getParams();
        this.ecSpec = params;
        this.q = EC5Util.convertPoint(params, eCPublicKey.getW());
    }

    public JCEECPublicKey(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        this.algorithm = "EC";
        populateFromPubKeyInfo(subjectPublicKeyInfo);
    }
}
