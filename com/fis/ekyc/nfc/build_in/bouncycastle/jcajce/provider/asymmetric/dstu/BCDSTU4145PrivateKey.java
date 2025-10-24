package com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.dstu;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Encodable;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Encoding;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Null;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERBitString;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERNull;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ua.UAObjectIdentifiers;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.AlgorithmIdentifier;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x9.X962Parameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x9.X9ECParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x9.X9ECPoint;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x9.X9ObjectIdentifiers;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ECDomainParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ECPrivateKeyParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.util.EC5Util;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.util.ECUtil;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.util.PKCS12BagAttributeCarrierImpl;
import com.fis.ekyc.nfc.build_in.bouncycastle.jce.interfaces.ECPointEncoder;
import com.fis.ekyc.nfc.build_in.bouncycastle.jce.interfaces.PKCS12BagAttributeCarrier;
import com.fis.ekyc.nfc.build_in.bouncycastle.jce.provider.BouncyCastleProvider;
import com.fis.ekyc.nfc.build_in.bouncycastle.jce.spec.ECNamedCurveSpec;
import com.fis.ekyc.nfc.build_in.bouncycastle.jce.spec.ECPrivateKeySpec;
import com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECCurve;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.interfaces.ECPrivateKey;
import java.security.spec.ECParameterSpec;
import java.util.Enumeration;

public class BCDSTU4145PrivateKey implements ECPrivateKey, com.fis.ekyc.nfc.build_in.bouncycastle.jce.interfaces.ECPrivateKey, PKCS12BagAttributeCarrier, ECPointEncoder {
    static final long serialVersionUID = 7245981689601667138L;
    private String algorithm = "DSTU4145";
    private transient PKCS12BagAttributeCarrierImpl attrCarrier = new PKCS12BagAttributeCarrierImpl();
    private transient BigInteger d;
    private transient ECParameterSpec ecSpec;
    private transient DERBitString publicKey;
    private boolean withCompression;

    public BCDSTU4145PrivateKey() {
    }

    private DERBitString getPublicKeyDetails(BCDSTU4145PublicKey bCDSTU4145PublicKey) {
        try {
            return SubjectPublicKeyInfo.getInstance(ASN1Primitive.fromByteArray(bCDSTU4145PublicKey.getEncoded())).getPublicKeyData();
        } catch (IOException unused) {
            return null;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v0, resolved type: com.fis.ekyc.nfc.build_in.bouncycastle.jce.spec.ECNamedCurveParameterSpec} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v2, resolved type: com.fis.ekyc.nfc.build_in.bouncycastle.jce.spec.ECParameterSpec} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v6, resolved type: com.fis.ekyc.nfc.build_in.bouncycastle.jce.spec.ECNamedCurveParameterSpec} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v19, resolved type: com.fis.ekyc.nfc.build_in.bouncycastle.jce.spec.ECNamedCurveParameterSpec} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void populateFromPrivKeyInfo(com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.PrivateKeyInfo r13) throws java.io.IOException {
        /*
            r12 = this;
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.AlgorithmIdentifier r0 = r13.getPrivateKeyAlgorithm()
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Encodable r0 = r0.getParameters()
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x9.X962Parameters r0 = com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x9.X962Parameters.getInstance(r0)
            boolean r1 = r0.isNamedCurve()
            if (r1 == 0) goto L_0x0078
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive r0 = r0.getParameters()
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier r0 = com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier.getInstance(r0)
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x9.X9ECParameters r1 = com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.util.ECUtil.getNamedCurveByOid(r0)
            if (r1 != 0) goto L_0x004e
            com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ECDomainParameters r1 = com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ua.DSTU4145NamedCurves.getByOID(r0)
            com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECCurve r2 = r1.getCurve()
            byte[] r3 = r1.getSeed()
            java.security.spec.EllipticCurve r6 = com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.util.EC5Util.convertCurve(r2, r3)
            com.fis.ekyc.nfc.build_in.bouncycastle.jce.spec.ECNamedCurveSpec r2 = new com.fis.ekyc.nfc.build_in.bouncycastle.jce.spec.ECNamedCurveSpec
            java.lang.String r5 = r0.getId()
            com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECPoint r0 = r1.getG()
            java.security.spec.ECPoint r7 = com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.util.EC5Util.convertPoint(r0)
            java.math.BigInteger r8 = r1.getN()
            java.math.BigInteger r9 = r1.getH()
            r4 = r2
            r4.<init>((java.lang.String) r5, (java.security.spec.EllipticCurve) r6, (java.security.spec.ECPoint) r7, (java.math.BigInteger) r8, (java.math.BigInteger) r9)
            r12.ecSpec = r2
            goto L_0x017e
        L_0x004e:
            com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECCurve r2 = r1.getCurve()
            byte[] r3 = r1.getSeed()
            java.security.spec.EllipticCurve r6 = com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.util.EC5Util.convertCurve(r2, r3)
            com.fis.ekyc.nfc.build_in.bouncycastle.jce.spec.ECNamedCurveSpec r2 = new com.fis.ekyc.nfc.build_in.bouncycastle.jce.spec.ECNamedCurveSpec
            java.lang.String r5 = com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.util.ECUtil.getCurveName(r0)
            com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECPoint r0 = r1.getG()
            java.security.spec.ECPoint r7 = com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.util.EC5Util.convertPoint(r0)
            java.math.BigInteger r8 = r1.getN()
            java.math.BigInteger r9 = r1.getH()
            r4 = r2
            r4.<init>((java.lang.String) r5, (java.security.spec.EllipticCurve) r6, (java.security.spec.ECPoint) r7, (java.math.BigInteger) r8, (java.math.BigInteger) r9)
            r12.ecSpec = r2
            goto L_0x017e
        L_0x0078:
            boolean r1 = r0.isImplicitlyCA()
            if (r1 == 0) goto L_0x0083
            r0 = 0
            r12.ecSpec = r0
            goto L_0x017e
        L_0x0083:
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive r1 = r0.getParameters()
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Sequence r1 = com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Sequence.getInstance(r1)
            r2 = 0
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Encodable r2 = r1.getObjectAt(r2)
            boolean r2 = r2 instanceof com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Integer
            if (r2 == 0) goto L_0x00c5
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive r0 = r0.getParameters()
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x9.X9ECParameters r0 = com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x9.X9ECParameters.getInstance(r0)
            com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECCurve r1 = r0.getCurve()
            byte[] r2 = r0.getSeed()
            java.security.spec.EllipticCurve r1 = com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.util.EC5Util.convertCurve(r1, r2)
            java.security.spec.ECParameterSpec r2 = new java.security.spec.ECParameterSpec
            com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECPoint r3 = r0.getG()
            java.security.spec.ECPoint r3 = com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.util.EC5Util.convertPoint(r3)
            java.math.BigInteger r4 = r0.getN()
            java.math.BigInteger r0 = r0.getH()
            int r0 = r0.intValue()
            r2.<init>(r1, r3, r4, r0)
            r12.ecSpec = r2
            goto L_0x017e
        L_0x00c5:
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ua.DSTU4145Params r0 = com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ua.DSTU4145Params.getInstance(r1)
            boolean r1 = r0.isNamedCurve()
            if (r1 == 0) goto L_0x00f6
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier r0 = r0.getNamedCurve()
            com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ECDomainParameters r1 = com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ua.DSTU4145NamedCurves.getByOID(r0)
            com.fis.ekyc.nfc.build_in.bouncycastle.jce.spec.ECNamedCurveParameterSpec r9 = new com.fis.ekyc.nfc.build_in.bouncycastle.jce.spec.ECNamedCurveParameterSpec
            java.lang.String r3 = r0.getId()
            com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECCurve r4 = r1.getCurve()
            com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECPoint r5 = r1.getG()
            java.math.BigInteger r6 = r1.getN()
            java.math.BigInteger r7 = r1.getH()
            byte[] r8 = r1.getSeed()
            r2 = r9
            r2.<init>(r3, r4, r5, r6, r7, r8)
            goto L_0x0157
        L_0x00f6:
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ua.DSTU4145ECBinary r0 = r0.getECBinary()
            byte[] r1 = r0.getB()
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.AlgorithmIdentifier r2 = r13.getPrivateKeyAlgorithm()
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier r2 = r2.getAlgorithm()
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier r3 = com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ua.UAObjectIdentifiers.dstu4145le
            boolean r2 = r2.equals((com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive) r3)
            if (r2 == 0) goto L_0x0111
            r12.reverseBytes(r1)
        L_0x0111:
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ua.DSTU4145BinaryField r2 = r0.getField()
            com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECCurve$F2m r11 = new com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECCurve$F2m
            int r5 = r2.getM()
            int r6 = r2.getK1()
            int r7 = r2.getK2()
            int r8 = r2.getK3()
            java.math.BigInteger r9 = r0.getA()
            java.math.BigInteger r10 = new java.math.BigInteger
            r2 = 1
            r10.<init>(r2, r1)
            r4 = r11
            r4.<init>((int) r5, (int) r6, (int) r7, (int) r8, (java.math.BigInteger) r9, (java.math.BigInteger) r10)
            byte[] r1 = r0.getG()
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.AlgorithmIdentifier r2 = r13.getPrivateKeyAlgorithm()
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier r2 = r2.getAlgorithm()
            boolean r2 = r2.equals((com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive) r3)
            if (r2 == 0) goto L_0x014a
            r12.reverseBytes(r1)
        L_0x014a:
            com.fis.ekyc.nfc.build_in.bouncycastle.jce.spec.ECParameterSpec r9 = new com.fis.ekyc.nfc.build_in.bouncycastle.jce.spec.ECParameterSpec
            com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECPoint r1 = com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ua.DSTU4145PointEncoder.decodePoint(r11, r1)
            java.math.BigInteger r0 = r0.getN()
            r9.<init>(r11, r1, r0)
        L_0x0157:
            com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECCurve r0 = r9.getCurve()
            byte[] r1 = r9.getSeed()
            java.security.spec.EllipticCurve r0 = com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.util.EC5Util.convertCurve(r0, r1)
            java.security.spec.ECParameterSpec r1 = new java.security.spec.ECParameterSpec
            com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECPoint r2 = r9.getG()
            java.security.spec.ECPoint r2 = com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.util.EC5Util.convertPoint(r2)
            java.math.BigInteger r3 = r9.getN()
            java.math.BigInteger r4 = r9.getH()
            int r4 = r4.intValue()
            r1.<init>(r0, r2, r3, r4)
            r12.ecSpec = r1
        L_0x017e:
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Encodable r13 = r13.parsePrivateKey()
            boolean r0 = r13 instanceof com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Integer
            if (r0 == 0) goto L_0x0191
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Integer r13 = com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Integer.getInstance(r13)
            java.math.BigInteger r13 = r13.getValue()
            r12.d = r13
            goto L_0x01a1
        L_0x0191:
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.sec.ECPrivateKey r13 = com.fis.ekyc.nfc.build_in.bouncycastle.asn1.sec.ECPrivateKey.getInstance(r13)
            java.math.BigInteger r0 = r13.getKey()
            r12.d = r0
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERBitString r13 = r13.getPublicKey()
            r12.publicKey = r13
        L_0x01a1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.dstu.BCDSTU4145PrivateKey.populateFromPrivKeyInfo(com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.PrivateKeyInfo):void");
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        populateFromPrivKeyInfo(PrivateKeyInfo.getInstance(ASN1Primitive.fromByteArray((byte[]) objectInputStream.readObject())));
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
    }

    private void reverseBytes(byte[] bArr) {
        for (int i = 0; i < bArr.length / 2; i++) {
            byte b = bArr[i];
            bArr[i] = bArr[(bArr.length - 1) - i];
            bArr[(bArr.length - 1) - i] = b;
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(getEncoded());
    }

    public com.fis.ekyc.nfc.build_in.bouncycastle.jce.spec.ECParameterSpec engineGetSpec() {
        ECParameterSpec eCParameterSpec = this.ecSpec;
        if (eCParameterSpec != null) {
            return EC5Util.convertSpec(eCParameterSpec);
        }
        return BouncyCastleProvider.CONFIGURATION.getEcImplicitlyCa();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof BCDSTU4145PrivateKey)) {
            return false;
        }
        BCDSTU4145PrivateKey bCDSTU4145PrivateKey = (BCDSTU4145PrivateKey) obj;
        if (!getD().equals(bCDSTU4145PrivateKey.getD()) || !engineGetSpec().equals(bCDSTU4145PrivateKey.engineGetSpec())) {
            return false;
        }
        return true;
    }

    public String getAlgorithm() {
        return this.algorithm;
    }

    public ASN1Encodable getBagAttribute(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return this.attrCarrier.getBagAttribute(aSN1ObjectIdentifier);
    }

    public Enumeration getBagAttributeKeys() {
        return this.attrCarrier.getBagAttributeKeys();
    }

    public BigInteger getD() {
        return this.d;
    }

    public byte[] getEncoded() {
        X962Parameters x962Parameters;
        int i;
        com.fis.ekyc.nfc.build_in.bouncycastle.asn1.sec.ECPrivateKey eCPrivateKey;
        PrivateKeyInfo privateKeyInfo;
        ECParameterSpec eCParameterSpec = this.ecSpec;
        if (eCParameterSpec instanceof ECNamedCurveSpec) {
            ASN1ObjectIdentifier namedCurveOid = ECUtil.getNamedCurveOid(((ECNamedCurveSpec) eCParameterSpec).getName());
            if (namedCurveOid == null) {
                namedCurveOid = new ASN1ObjectIdentifier(((ECNamedCurveSpec) this.ecSpec).getName());
            }
            x962Parameters = new X962Parameters(namedCurveOid);
            i = ECUtil.getOrderBitLength(BouncyCastleProvider.CONFIGURATION, this.ecSpec.getOrder(), getS());
        } else if (eCParameterSpec == null) {
            x962Parameters = new X962Parameters((ASN1Null) DERNull.INSTANCE);
            i = ECUtil.getOrderBitLength(BouncyCastleProvider.CONFIGURATION, (BigInteger) null, getS());
        } else {
            ECCurve convertCurve = EC5Util.convertCurve(eCParameterSpec.getCurve());
            x962Parameters = new X962Parameters(new X9ECParameters(convertCurve, new X9ECPoint(EC5Util.convertPoint(convertCurve, this.ecSpec.getGenerator()), this.withCompression), this.ecSpec.getOrder(), BigInteger.valueOf((long) this.ecSpec.getCofactor()), this.ecSpec.getCurve().getSeed()));
            i = ECUtil.getOrderBitLength(BouncyCastleProvider.CONFIGURATION, this.ecSpec.getOrder(), getS());
        }
        if (this.publicKey != null) {
            eCPrivateKey = new com.fis.ekyc.nfc.build_in.bouncycastle.asn1.sec.ECPrivateKey(i, getS(), this.publicKey, x962Parameters);
        } else {
            eCPrivateKey = new com.fis.ekyc.nfc.build_in.bouncycastle.asn1.sec.ECPrivateKey(i, getS(), (ASN1Encodable) x962Parameters);
        }
        try {
            if (this.algorithm.equals("DSTU4145")) {
                privateKeyInfo = new PrivateKeyInfo(new AlgorithmIdentifier(UAObjectIdentifiers.dstu4145be, x962Parameters.toASN1Primitive()), eCPrivateKey.toASN1Primitive());
            } else {
                privateKeyInfo = new PrivateKeyInfo(new AlgorithmIdentifier(X9ObjectIdentifiers.id_ecPublicKey, x962Parameters.toASN1Primitive()), eCPrivateKey.toASN1Primitive());
            }
            return privateKeyInfo.getEncoded(ASN1Encoding.DER);
        } catch (IOException unused) {
            return null;
        }
    }

    public String getFormat() {
        return "PKCS#8";
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

    public BigInteger getS() {
        return this.d;
    }

    public int hashCode() {
        return getD().hashCode() ^ engineGetSpec().hashCode();
    }

    public void setBagAttribute(ASN1ObjectIdentifier aSN1ObjectIdentifier, ASN1Encodable aSN1Encodable) {
        this.attrCarrier.setBagAttribute(aSN1ObjectIdentifier, aSN1Encodable);
    }

    public void setPointFormat(String str) {
        this.withCompression = !"UNCOMPRESSED".equalsIgnoreCase(str);
    }

    public String toString() {
        return ECUtil.privateKeyToString(this.algorithm, this.d, engineGetSpec());
    }

    public BCDSTU4145PrivateKey(ECPrivateKey eCPrivateKey) {
        this.d = eCPrivateKey.getS();
        this.algorithm = eCPrivateKey.getAlgorithm();
        this.ecSpec = eCPrivateKey.getParams();
    }

    public BCDSTU4145PrivateKey(ECPrivateKeySpec eCPrivateKeySpec) {
        this.d = eCPrivateKeySpec.getD();
        if (eCPrivateKeySpec.getParams() != null) {
            this.ecSpec = EC5Util.convertSpec(EC5Util.convertCurve(eCPrivateKeySpec.getParams().getCurve(), eCPrivateKeySpec.getParams().getSeed()), eCPrivateKeySpec.getParams());
        } else {
            this.ecSpec = null;
        }
    }

    public BCDSTU4145PrivateKey(java.security.spec.ECPrivateKeySpec eCPrivateKeySpec) {
        this.d = eCPrivateKeySpec.getS();
        this.ecSpec = eCPrivateKeySpec.getParams();
    }

    public BCDSTU4145PrivateKey(BCDSTU4145PrivateKey bCDSTU4145PrivateKey) {
        this.d = bCDSTU4145PrivateKey.d;
        this.ecSpec = bCDSTU4145PrivateKey.ecSpec;
        this.withCompression = bCDSTU4145PrivateKey.withCompression;
        this.attrCarrier = bCDSTU4145PrivateKey.attrCarrier;
        this.publicKey = bCDSTU4145PrivateKey.publicKey;
    }

    public BCDSTU4145PrivateKey(String str, ECPrivateKeyParameters eCPrivateKeyParameters, BCDSTU4145PublicKey bCDSTU4145PublicKey, ECParameterSpec eCParameterSpec) {
        ECDomainParameters parameters = eCPrivateKeyParameters.getParameters();
        this.algorithm = str;
        this.d = eCPrivateKeyParameters.getD();
        if (eCParameterSpec == null) {
            this.ecSpec = new ECParameterSpec(EC5Util.convertCurve(parameters.getCurve(), parameters.getSeed()), EC5Util.convertPoint(parameters.getG()), parameters.getN(), parameters.getH().intValue());
        } else {
            this.ecSpec = eCParameterSpec;
        }
        this.publicKey = getPublicKeyDetails(bCDSTU4145PublicKey);
    }

    public BCDSTU4145PrivateKey(String str, ECPrivateKeyParameters eCPrivateKeyParameters, BCDSTU4145PublicKey bCDSTU4145PublicKey, com.fis.ekyc.nfc.build_in.bouncycastle.jce.spec.ECParameterSpec eCParameterSpec) {
        ECDomainParameters parameters = eCPrivateKeyParameters.getParameters();
        this.algorithm = str;
        this.d = eCPrivateKeyParameters.getD();
        if (eCParameterSpec == null) {
            this.ecSpec = new ECParameterSpec(EC5Util.convertCurve(parameters.getCurve(), parameters.getSeed()), EC5Util.convertPoint(parameters.getG()), parameters.getN(), parameters.getH().intValue());
        } else {
            this.ecSpec = new ECParameterSpec(EC5Util.convertCurve(eCParameterSpec.getCurve(), eCParameterSpec.getSeed()), EC5Util.convertPoint(eCParameterSpec.getG()), eCParameterSpec.getN(), eCParameterSpec.getH().intValue());
        }
        this.publicKey = getPublicKeyDetails(bCDSTU4145PublicKey);
    }

    public BCDSTU4145PrivateKey(String str, ECPrivateKeyParameters eCPrivateKeyParameters) {
        this.algorithm = str;
        this.d = eCPrivateKeyParameters.getD();
        this.ecSpec = null;
    }

    public BCDSTU4145PrivateKey(PrivateKeyInfo privateKeyInfo) throws IOException {
        populateFromPrivKeyInfo(privateKeyInfo);
    }
}
