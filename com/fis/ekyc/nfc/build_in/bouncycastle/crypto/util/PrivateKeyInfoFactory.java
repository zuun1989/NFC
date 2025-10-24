package com.fis.ekyc.nfc.build_in.bouncycastle.crypto.util;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Integer;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Null;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Set;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERBitString;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERNull;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DEROctetString;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.cryptopro.GOST3410PublicKeyAlgParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.edec.EdECObjectIdentifiers;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.RSAPrivateKey;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.rosstandart.RosstandartObjectIdentifiers;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.sec.ECPrivateKey;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.AlgorithmIdentifier;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.DSAParameter;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x9.X962Parameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x9.X9ECParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x9.X9ECPoint;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x9.X9ObjectIdentifiers;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.AsymmetricKeyParameter;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.DSAParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.DSAPrivateKeyParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ECDomainParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ECGOST3410Parameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ECNamedDomainParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ECPrivateKeyParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.Ed25519PrivateKeyParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.Ed448PrivateKeyParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.RSAKeyParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.RSAPrivateCrtKeyParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.X25519PrivateKeyParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.X448PrivateKeyParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.FixedPointCombMultiplier;
import java.io.IOException;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

public class PrivateKeyInfoFactory {
    private static Set cryptoProOids;

    static {
        HashSet hashSet = new HashSet(5);
        cryptoProOids = hashSet;
        hashSet.add(CryptoProObjectIdentifiers.gostR3410_2001_CryptoPro_A);
        cryptoProOids.add(CryptoProObjectIdentifiers.gostR3410_2001_CryptoPro_B);
        cryptoProOids.add(CryptoProObjectIdentifiers.gostR3410_2001_CryptoPro_C);
        cryptoProOids.add(CryptoProObjectIdentifiers.gostR3410_2001_CryptoPro_XchA);
        cryptoProOids.add(CryptoProObjectIdentifiers.gostR3410_2001_CryptoPro_XchB);
    }

    private PrivateKeyInfoFactory() {
    }

    public static PrivateKeyInfo createPrivateKeyInfo(AsymmetricKeyParameter asymmetricKeyParameter) throws IOException {
        return createPrivateKeyInfo(asymmetricKeyParameter, (ASN1Set) null);
    }

    private static void extractBytes(byte[] bArr, int i, int i2, BigInteger bigInteger) {
        byte[] byteArray = bigInteger.toByteArray();
        if (byteArray.length < i) {
            byte[] bArr2 = new byte[i];
            System.arraycopy(byteArray, 0, bArr2, i - byteArray.length, byteArray.length);
            byteArray = bArr2;
        }
        for (int i3 = 0; i3 != i; i3++) {
            bArr[i2 + i3] = byteArray[(byteArray.length - 1) - i3];
        }
    }

    public static PrivateKeyInfo createPrivateKeyInfo(AsymmetricKeyParameter asymmetricKeyParameter, ASN1Set aSN1Set) throws IOException {
        int i;
        X962Parameters x962Parameters;
        ASN1ObjectIdentifier aSN1ObjectIdentifier;
        ASN1ObjectIdentifier aSN1ObjectIdentifier2;
        if (asymmetricKeyParameter instanceof RSAKeyParameters) {
            RSAPrivateCrtKeyParameters rSAPrivateCrtKeyParameters = (RSAPrivateCrtKeyParameters) asymmetricKeyParameter;
            return new PrivateKeyInfo(new AlgorithmIdentifier(PKCSObjectIdentifiers.rsaEncryption, DERNull.INSTANCE), new RSAPrivateKey(rSAPrivateCrtKeyParameters.getModulus(), rSAPrivateCrtKeyParameters.getPublicExponent(), rSAPrivateCrtKeyParameters.getExponent(), rSAPrivateCrtKeyParameters.getP(), rSAPrivateCrtKeyParameters.getQ(), rSAPrivateCrtKeyParameters.getDP(), rSAPrivateCrtKeyParameters.getDQ(), rSAPrivateCrtKeyParameters.getQInv()), aSN1Set);
        } else if (asymmetricKeyParameter instanceof DSAPrivateKeyParameters) {
            DSAPrivateKeyParameters dSAPrivateKeyParameters = (DSAPrivateKeyParameters) asymmetricKeyParameter;
            DSAParameters parameters = dSAPrivateKeyParameters.getParameters();
            return new PrivateKeyInfo(new AlgorithmIdentifier(X9ObjectIdentifiers.id_dsa, new DSAParameter(parameters.getP(), parameters.getQ(), parameters.getG())), new ASN1Integer(dSAPrivateKeyParameters.getX()), aSN1Set);
        } else if (asymmetricKeyParameter instanceof ECPrivateKeyParameters) {
            ECPrivateKeyParameters eCPrivateKeyParameters = (ECPrivateKeyParameters) asymmetricKeyParameter;
            ECDomainParameters parameters2 = eCPrivateKeyParameters.getParameters();
            if (parameters2 == null) {
                x962Parameters = new X962Parameters((ASN1Null) DERNull.INSTANCE);
                i = eCPrivateKeyParameters.getD().bitLength();
            } else if (parameters2 instanceof ECGOST3410Parameters) {
                ECGOST3410Parameters eCGOST3410Parameters = (ECGOST3410Parameters) parameters2;
                GOST3410PublicKeyAlgParameters gOST3410PublicKeyAlgParameters = new GOST3410PublicKeyAlgParameters(eCGOST3410Parameters.getPublicKeyParamSet(), eCGOST3410Parameters.getDigestParamSet(), eCGOST3410Parameters.getEncryptionParamSet());
                int i2 = 32;
                if (cryptoProOids.contains(gOST3410PublicKeyAlgParameters.getPublicKeyParamSet())) {
                    aSN1ObjectIdentifier = CryptoProObjectIdentifiers.gostR3410_2001;
                } else {
                    boolean z = eCPrivateKeyParameters.getD().bitLength() > 256;
                    if (z) {
                        aSN1ObjectIdentifier2 = RosstandartObjectIdentifiers.id_tc26_gost_3410_12_512;
                    } else {
                        aSN1ObjectIdentifier2 = RosstandartObjectIdentifiers.id_tc26_gost_3410_12_256;
                    }
                    if (z) {
                        i2 = 64;
                    }
                    aSN1ObjectIdentifier = aSN1ObjectIdentifier2;
                }
                byte[] bArr = new byte[i2];
                extractBytes(bArr, i2, 0, eCPrivateKeyParameters.getD());
                return new PrivateKeyInfo(new AlgorithmIdentifier(aSN1ObjectIdentifier, gOST3410PublicKeyAlgParameters), new DEROctetString(bArr));
            } else if (parameters2 instanceof ECNamedDomainParameters) {
                x962Parameters = new X962Parameters(((ECNamedDomainParameters) parameters2).getName());
                i = parameters2.getN().bitLength();
            } else {
                X962Parameters x962Parameters2 = new X962Parameters(new X9ECParameters(parameters2.getCurve(), new X9ECPoint(parameters2.getG(), false), parameters2.getN(), parameters2.getH(), parameters2.getSeed()));
                i = parameters2.getN().bitLength();
                x962Parameters = x962Parameters2;
            }
            return new PrivateKeyInfo(new AlgorithmIdentifier(X9ObjectIdentifiers.id_ecPublicKey, x962Parameters), new ECPrivateKey(i, eCPrivateKeyParameters.getD(), new DERBitString(new FixedPointCombMultiplier().multiply(parameters2.getG(), eCPrivateKeyParameters.getD()).getEncoded(false)), x962Parameters), aSN1Set);
        } else if (asymmetricKeyParameter instanceof X448PrivateKeyParameters) {
            X448PrivateKeyParameters x448PrivateKeyParameters = (X448PrivateKeyParameters) asymmetricKeyParameter;
            return new PrivateKeyInfo(new AlgorithmIdentifier(EdECObjectIdentifiers.id_X448), new DEROctetString(x448PrivateKeyParameters.getEncoded()), aSN1Set, x448PrivateKeyParameters.generatePublicKey().getEncoded());
        } else if (asymmetricKeyParameter instanceof X25519PrivateKeyParameters) {
            X25519PrivateKeyParameters x25519PrivateKeyParameters = (X25519PrivateKeyParameters) asymmetricKeyParameter;
            return new PrivateKeyInfo(new AlgorithmIdentifier(EdECObjectIdentifiers.id_X25519), new DEROctetString(x25519PrivateKeyParameters.getEncoded()), aSN1Set, x25519PrivateKeyParameters.generatePublicKey().getEncoded());
        } else if (asymmetricKeyParameter instanceof Ed448PrivateKeyParameters) {
            Ed448PrivateKeyParameters ed448PrivateKeyParameters = (Ed448PrivateKeyParameters) asymmetricKeyParameter;
            return new PrivateKeyInfo(new AlgorithmIdentifier(EdECObjectIdentifiers.id_Ed448), new DEROctetString(ed448PrivateKeyParameters.getEncoded()), aSN1Set, ed448PrivateKeyParameters.generatePublicKey().getEncoded());
        } else if (asymmetricKeyParameter instanceof Ed25519PrivateKeyParameters) {
            Ed25519PrivateKeyParameters ed25519PrivateKeyParameters = (Ed25519PrivateKeyParameters) asymmetricKeyParameter;
            return new PrivateKeyInfo(new AlgorithmIdentifier(EdECObjectIdentifiers.id_Ed25519), new DEROctetString(ed25519PrivateKeyParameters.getEncoded()), aSN1Set, ed25519PrivateKeyParameters.generatePublicKey().getEncoded());
        } else {
            throw new IOException("key parameters not recognized");
        }
    }
}
