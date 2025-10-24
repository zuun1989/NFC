package com.fis.ekyc.nfc.build_in.bouncycastle.crypto.util;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1InputStream;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1OctetString;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.AsymmetricKeyParameter;
import java.io.IOException;
import java.io.InputStream;

public class PrivateKeyFactory {
    public static AsymmetricKeyParameter createKey(byte[] bArr) throws IOException {
        return createKey(PrivateKeyInfo.getInstance(ASN1Primitive.fromByteArray(bArr)));
    }

    private static byte[] getRawKey(PrivateKeyInfo privateKeyInfo, int i) throws IOException {
        byte[] octets = ASN1OctetString.getInstance(privateKeyInfo.parsePrivateKey()).getOctets();
        if (i == octets.length) {
            return octets;
        }
        throw new RuntimeException("private key encoding has incorrect length");
    }

    public static AsymmetricKeyParameter createKey(InputStream inputStream) throws IOException {
        return createKey(PrivateKeyInfo.getInstance(new ASN1InputStream(inputStream).readObject()));
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v15, resolved type: com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ECGOST3410Parameters} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v16, resolved type: com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ECGOST3410Parameters} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v17, resolved type: com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ECGOST3410Parameters} */
    /* JADX WARNING: type inference failed for: r3v2, types: [com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ECDomainParameters] */
    /* JADX WARNING: type inference failed for: r3v4, types: [com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ECGOST3410Parameters] */
    /* JADX WARNING: type inference failed for: r3v5, types: [com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ECGOST3410Parameters] */
    /* JADX WARNING: type inference failed for: r3v11 */
    /* JADX WARNING: type inference failed for: r3v12 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.AsymmetricKeyParameter createKey(com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.PrivateKeyInfo r10) throws java.io.IOException {
        /*
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.AlgorithmIdentifier r0 = r10.getPrivateKeyAlgorithm()
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier r1 = r0.getAlgorithm()
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier r2 = com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers.rsaEncryption
            boolean r2 = r1.equals((com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive) r2)
            if (r2 != 0) goto L_0x02b8
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier r2 = com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers.id_RSASSA_PSS
            boolean r2 = r1.equals((com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive) r2)
            if (r2 != 0) goto L_0x02b8
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier r2 = com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.X509ObjectIdentifiers.id_ea_rsa
            boolean r2 = r1.equals((com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive) r2)
            if (r2 == 0) goto L_0x0022
            goto L_0x02b8
        L_0x0022:
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier r2 = com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers.dhKeyAgreement
            boolean r2 = r1.equals((com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive) r2)
            r3 = 0
            r4 = 0
            if (r2 == 0) goto L_0x005c
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Encodable r0 = r0.getParameters()
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.DHParameter r0 = com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.DHParameter.getInstance(r0)
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Encodable r10 = r10.parsePrivateKey()
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Integer r10 = (com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Integer) r10
            java.math.BigInteger r1 = r0.getL()
            if (r1 != 0) goto L_0x0041
            goto L_0x0045
        L_0x0041:
            int r4 = r1.intValue()
        L_0x0045:
            com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.DHParameters r1 = new com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.DHParameters
            java.math.BigInteger r2 = r0.getP()
            java.math.BigInteger r0 = r0.getG()
            r1.<init>(r2, r0, r3, r4)
            com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.DHPrivateKeyParameters r0 = new com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.DHPrivateKeyParameters
            java.math.BigInteger r10 = r10.getValue()
            r0.<init>(r10, r1)
            return r0
        L_0x005c:
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier r2 = com.fis.ekyc.nfc.build_in.bouncycastle.asn1.oiw.OIWObjectIdentifiers.elGamalAlgorithm
            boolean r2 = r1.equals((com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive) r2)
            if (r2 == 0) goto L_0x0089
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Encodable r0 = r0.getParameters()
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.oiw.ElGamalParameter r0 = com.fis.ekyc.nfc.build_in.bouncycastle.asn1.oiw.ElGamalParameter.getInstance(r0)
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Encodable r10 = r10.parsePrivateKey()
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Integer r10 = (com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Integer) r10
            com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ElGamalPrivateKeyParameters r1 = new com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ElGamalPrivateKeyParameters
            java.math.BigInteger r10 = r10.getValue()
            com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ElGamalParameters r2 = new com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ElGamalParameters
            java.math.BigInteger r3 = r0.getP()
            java.math.BigInteger r0 = r0.getG()
            r2.<init>(r3, r0)
            r1.<init>(r10, r2)
            return r1
        L_0x0089:
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier r2 = com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x9.X9ObjectIdentifiers.id_dsa
            boolean r2 = r1.equals((com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive) r2)
            if (r2 == 0) goto L_0x00c0
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Encodable r10 = r10.parsePrivateKey()
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Integer r10 = (com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Integer) r10
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Encodable r0 = r0.getParameters()
            if (r0 == 0) goto L_0x00b6
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive r0 = r0.toASN1Primitive()
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.DSAParameter r0 = com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.DSAParameter.getInstance(r0)
            com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.DSAParameters r3 = new com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.DSAParameters
            java.math.BigInteger r1 = r0.getP()
            java.math.BigInteger r2 = r0.getQ()
            java.math.BigInteger r0 = r0.getG()
            r3.<init>(r1, r2, r0)
        L_0x00b6:
            com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.DSAPrivateKeyParameters r0 = new com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.DSAPrivateKeyParameters
            java.math.BigInteger r10 = r10.getValue()
            r0.<init>(r10, r3)
            return r0
        L_0x00c0:
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier r2 = com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x9.X9ObjectIdentifiers.id_ecPublicKey
            boolean r2 = r1.equals((com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive) r2)
            if (r2 == 0) goto L_0x0121
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Encodable r0 = r0.getParameters()
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x9.X962Parameters r0 = com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x9.X962Parameters.getInstance(r0)
            boolean r1 = r0.isNamedCurve()
            if (r1 == 0) goto L_0x00ec
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive r0 = r0.getParameters()
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier r0 = (com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier) r0
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x9.X9ECParameters r1 = com.fis.ekyc.nfc.build_in.bouncycastle.crypto.ec.CustomNamedCurves.getByOID(r0)
            if (r1 != 0) goto L_0x00e6
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x9.X9ECParameters r1 = com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x9.ECNamedCurveTable.getByOID(r0)
        L_0x00e6:
            com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ECNamedDomainParameters r2 = new com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ECNamedDomainParameters
            r2.<init>((com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier) r0, (com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x9.X9ECParameters) r1)
            goto L_0x010f
        L_0x00ec:
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive r0 = r0.getParameters()
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x9.X9ECParameters r0 = com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x9.X9ECParameters.getInstance(r0)
            com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ECDomainParameters r7 = new com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ECDomainParameters
            com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECCurve r2 = r0.getCurve()
            com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECPoint r3 = r0.getG()
            java.math.BigInteger r4 = r0.getN()
            java.math.BigInteger r5 = r0.getH()
            byte[] r6 = r0.getSeed()
            r1 = r7
            r1.<init>(r2, r3, r4, r5, r6)
            r2 = r7
        L_0x010f:
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Encodable r10 = r10.parsePrivateKey()
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.sec.ECPrivateKey r10 = com.fis.ekyc.nfc.build_in.bouncycastle.asn1.sec.ECPrivateKey.getInstance(r10)
            java.math.BigInteger r10 = r10.getKey()
            com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ECPrivateKeyParameters r0 = new com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ECPrivateKeyParameters
            r0.<init>(r10, r2)
            return r0
        L_0x0121:
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier r0 = com.fis.ekyc.nfc.build_in.bouncycastle.asn1.edec.EdECObjectIdentifiers.id_X25519
            boolean r0 = r1.equals((com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive) r0)
            r2 = 32
            if (r0 == 0) goto L_0x0135
            com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.X25519PrivateKeyParameters r0 = new com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.X25519PrivateKeyParameters
            byte[] r10 = getRawKey(r10, r2)
            r0.<init>(r10, r4)
            return r0
        L_0x0135:
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier r0 = com.fis.ekyc.nfc.build_in.bouncycastle.asn1.edec.EdECObjectIdentifiers.id_X448
            boolean r0 = r1.equals((com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive) r0)
            if (r0 == 0) goto L_0x0149
            com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.X448PrivateKeyParameters r0 = new com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.X448PrivateKeyParameters
            r1 = 56
            byte[] r10 = getRawKey(r10, r1)
            r0.<init>(r10, r4)
            return r0
        L_0x0149:
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier r0 = com.fis.ekyc.nfc.build_in.bouncycastle.asn1.edec.EdECObjectIdentifiers.id_Ed25519
            boolean r0 = r1.equals((com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive) r0)
            if (r0 == 0) goto L_0x015b
            com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.Ed25519PrivateKeyParameters r0 = new com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.Ed25519PrivateKeyParameters
            byte[] r10 = getRawKey(r10, r2)
            r0.<init>(r10, r4)
            return r0
        L_0x015b:
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier r0 = com.fis.ekyc.nfc.build_in.bouncycastle.asn1.edec.EdECObjectIdentifiers.id_Ed448
            boolean r0 = r1.equals((com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive) r0)
            if (r0 == 0) goto L_0x016f
            com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.Ed448PrivateKeyParameters r0 = new com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.Ed448PrivateKeyParameters
            r1 = 57
            byte[] r10 = getRawKey(r10, r1)
            r0.<init>(r10, r4)
            return r0
        L_0x016f:
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier r0 = com.fis.ekyc.nfc.build_in.bouncycastle.asn1.cryptopro.CryptoProObjectIdentifiers.gostR3410_2001
            boolean r0 = r1.equals((com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive) r0)
            if (r0 != 0) goto L_0x0190
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier r0 = com.fis.ekyc.nfc.build_in.bouncycastle.asn1.rosstandart.RosstandartObjectIdentifiers.id_tc26_gost_3410_12_512
            boolean r0 = r1.equals((com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive) r0)
            if (r0 != 0) goto L_0x0190
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier r0 = com.fis.ekyc.nfc.build_in.bouncycastle.asn1.rosstandart.RosstandartObjectIdentifiers.id_tc26_gost_3410_12_256
            boolean r0 = r1.equals((com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive) r0)
            if (r0 == 0) goto L_0x0188
            goto L_0x0190
        L_0x0188:
            java.lang.RuntimeException r10 = new java.lang.RuntimeException
            java.lang.String r0 = "algorithm identifier in private key not recognised"
            r10.<init>(r0)
            throw r10
        L_0x0190:
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.AlgorithmIdentifier r0 = r10.getPrivateKeyAlgorithm()
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Encodable r0 = r0.getParameters()
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.cryptopro.GOST3410PublicKeyAlgParameters r0 = com.fis.ekyc.nfc.build_in.bouncycastle.asn1.cryptopro.GOST3410PublicKeyAlgParameters.getInstance(r0)
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.AlgorithmIdentifier r4 = r10.getPrivateKeyAlgorithm()
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Encodable r4 = r4.getParameters()
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive r4 = r4.toASN1Primitive()
            boolean r5 = r4 instanceof com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Sequence
            if (r5 == 0) goto L_0x022e
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Sequence r5 = com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Sequence.getInstance(r4)
            int r5 = r5.size()
            r6 = 2
            if (r5 == r6) goto L_0x01c2
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Sequence r4 = com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Sequence.getInstance(r4)
            int r4 = r4.size()
            r5 = 3
            if (r4 != r5) goto L_0x022e
        L_0x01c2:
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier r1 = r0.getPublicKeyParamSet()
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x9.X9ECParameters r1 = com.fis.ekyc.nfc.build_in.bouncycastle.asn1.cryptopro.ECGOST3410NamedCurves.getByOIDX9(r1)
            com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ECGOST3410Parameters r3 = new com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ECGOST3410Parameters
            com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ECNamedDomainParameters r4 = new com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ECNamedDomainParameters
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier r5 = r0.getPublicKeyParamSet()
            r4.<init>((com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier) r5, (com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x9.X9ECParameters) r1)
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier r1 = r0.getPublicKeyParamSet()
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier r5 = r0.getDigestParamSet()
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier r6 = r0.getEncryptionParamSet()
            r3.<init>(r4, r1, r5, r6)
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1OctetString r1 = r10.getPrivateKey()
            byte[] r4 = r1.getOctets()
            int r4 = r4.length
            r5 = 1
            if (r4 == r2) goto L_0x0220
            byte[] r2 = r1.getOctets()
            int r2 = r2.length
            r4 = 64
            if (r2 != r4) goto L_0x01fa
            goto L_0x0220
        L_0x01fa:
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Encodable r10 = r10.parsePrivateKey()
            boolean r1 = r10 instanceof com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Integer
            if (r1 == 0) goto L_0x020c
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Integer r10 = com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Integer.getInstance(r10)
            java.math.BigInteger r10 = r10.getPositiveValue()
            goto L_0x02a1
        L_0x020c:
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1OctetString r10 = com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1OctetString.getInstance(r10)
            byte[] r10 = r10.getOctets()
            byte[] r10 = com.fis.ekyc.nfc.build_in.bouncycastle.util.Arrays.reverse((byte[]) r10)
            java.math.BigInteger r1 = new java.math.BigInteger
            r1.<init>(r5, r10)
            r10 = r1
            goto L_0x02a1
        L_0x0220:
            java.math.BigInteger r10 = new java.math.BigInteger
            byte[] r1 = r1.getOctets()
            byte[] r1 = com.fis.ekyc.nfc.build_in.bouncycastle.util.Arrays.reverse((byte[]) r1)
            r10.<init>(r5, r1)
            goto L_0x02a1
        L_0x022e:
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.AlgorithmIdentifier r2 = r10.getPrivateKeyAlgorithm()
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Encodable r2 = r2.getParameters()
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x9.X962Parameters r2 = com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x9.X962Parameters.getInstance(r2)
            boolean r4 = r2.isNamedCurve()
            if (r4 == 0) goto L_0x0263
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive r1 = r2.getParameters()
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier r1 = com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier.getInstance(r1)
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x9.X9ECParameters r2 = com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x9.ECNamedCurveTable.getByOID(r1)
            com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ECGOST3410Parameters r3 = new com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ECGOST3410Parameters
            com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ECNamedDomainParameters r4 = new com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ECNamedDomainParameters
            r4.<init>((com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier) r1, (com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x9.X9ECParameters) r2)
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier r1 = r0.getPublicKeyParamSet()
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier r2 = r0.getDigestParamSet()
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier r5 = r0.getEncryptionParamSet()
            r3.<init>(r4, r1, r2, r5)
            goto L_0x0288
        L_0x0263:
            boolean r4 = r2.isImplicitlyCA()
            if (r4 == 0) goto L_0x026a
            goto L_0x0288
        L_0x026a:
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive r2 = r2.getParameters()
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x9.X9ECParameters r2 = com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x9.X9ECParameters.getInstance(r2)
            com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ECGOST3410Parameters r3 = new com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ECGOST3410Parameters
            com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ECNamedDomainParameters r4 = new com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ECNamedDomainParameters
            r4.<init>((com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier) r1, (com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x9.X9ECParameters) r2)
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier r1 = r0.getPublicKeyParamSet()
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier r2 = r0.getDigestParamSet()
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier r5 = r0.getEncryptionParamSet()
            r3.<init>(r4, r1, r2, r5)
        L_0x0288:
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Encodable r10 = r10.parsePrivateKey()
            boolean r1 = r10 instanceof com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Integer
            if (r1 == 0) goto L_0x0299
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Integer r10 = com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Integer.getInstance(r10)
            java.math.BigInteger r10 = r10.getValue()
            goto L_0x02a1
        L_0x0299:
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.sec.ECPrivateKey r10 = com.fis.ekyc.nfc.build_in.bouncycastle.asn1.sec.ECPrivateKey.getInstance(r10)
            java.math.BigInteger r10 = r10.getKey()
        L_0x02a1:
            com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ECPrivateKeyParameters r1 = new com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ECPrivateKeyParameters
            com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ECGOST3410Parameters r2 = new com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ECGOST3410Parameters
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier r4 = r0.getPublicKeyParamSet()
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier r5 = r0.getDigestParamSet()
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier r0 = r0.getEncryptionParamSet()
            r2.<init>(r3, r4, r5, r0)
            r1.<init>(r10, r2)
            return r1
        L_0x02b8:
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Encodable r10 = r10.parsePrivateKey()
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.RSAPrivateKey r10 = com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.RSAPrivateKey.getInstance(r10)
            com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.RSAPrivateCrtKeyParameters r9 = new com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.RSAPrivateCrtKeyParameters
            java.math.BigInteger r1 = r10.getModulus()
            java.math.BigInteger r2 = r10.getPublicExponent()
            java.math.BigInteger r3 = r10.getPrivateExponent()
            java.math.BigInteger r4 = r10.getPrime1()
            java.math.BigInteger r5 = r10.getPrime2()
            java.math.BigInteger r6 = r10.getExponent1()
            java.math.BigInteger r7 = r10.getExponent2()
            java.math.BigInteger r8 = r10.getCoefficient()
            r0 = r9
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fis.ekyc.nfc.build_in.bouncycastle.crypto.util.PrivateKeyFactory.createKey(com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.PrivateKeyInfo):com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.AsymmetricKeyParameter");
    }
}
