package com.fis.ekyc.nfc.build_in.eidparser;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Encodable;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1InputStream;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Integer;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Sequence;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.DHParameter;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.AlgorithmIdentifier;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x9.X962NamedCurves;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x9.X9ECParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x9.X9ECPoint;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.DHParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ECDomainParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ECPrivateKeyParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ECPublicKeyParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.signers.PSSSigner;
import com.fis.ekyc.nfc.build_in.bouncycastle.jce.ECNamedCurveTable;
import com.fis.ekyc.nfc.build_in.bouncycastle.jce.provider.BouncyCastleProvider;
import com.fis.ekyc.nfc.build_in.bouncycastle.jce.spec.ECNamedCurveParameterSpec;
import com.fis.ekyc.nfc.build_in.bouncycastle.jce.spec.ECNamedCurveSpec;
import com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECCurve;
import com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECFieldElement;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.jcajce.spec.McElieceCCA2KeyGenParameterSpec;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.encoders.Hex;
import com.fis.ekyc.nfc.build_in.eidparser.lds.PACEInfo;
import com.fis.ekyc.nfc.build_in.eidparser.lds.SecurityInfo;
import com.fis.ekyc.nfc.build_in.eidparser.lds.icao.MRZInfo;
import com.fis.ekyc.nfc.build_in.scuba.smartcards.ISO7816;
import com.fis.ekyc.nfc.build_in.scuba.tlv.TLVInputStream;
import com.fis.ekyc.nfc.build_in.scuba.tlv.TLVUtil;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.PublicKey;
import java.security.Signature;
import java.security.cert.CertificateFactory;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.ECField;
import java.security.spec.ECFieldF2m;
import java.security.spec.ECFieldFp;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.ECPublicKeySpec;
import java.security.spec.EllipticCurve;
import java.security.spec.KeySpec;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.KeyAgreement;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.interfaces.DHPublicKey;
import javax.crypto.spec.DHParameterSpec;

public final class Util {
    private static final Provider BC_PROVIDER = new BouncyCastleProvider();
    public static final int ENC_MODE = 1;
    private static final Logger LOGGER = Logger.getLogger("com.fis.ekyc.sdk.nfc.build_in..jmrtd");
    public static final int MAC_MODE = 2;
    public static final int PACE_MODE = 3;
    @Deprecated
    public static final DHParameters RFC5114_1024_160 = fromPGQ(RFC5114_1024_160_P, RFC5114_1024_160_G, RFC5114_1024_160_Q);
    private static final String RFC5114_1024_160_G = "A4D1CBD5C3FD34126765A442EFB99905F8104DD258AC507FD6406CFF14266D31266FEA1E5C41564B777E690F5504F213160217B4B01B886A5E91547F9E2749F4D7FBD7D3B9A92EE1909D0D2263F80A76A6A24C087A091F531DBF0A0169B6A28AD662A4D18E73AFA32D779D5918D08BC8858F4DCEF97C2A24855E6EEB22B3B2E5";
    private static final String RFC5114_1024_160_P = "B10B8F96A080E01DDE92DE5EAE5D54EC52C99FBCFB06A3C69A6A9DCA52D23B616073E28675A23D189838EF1E2EE652C013ECB4AEA906112324975C3CD49B83BFACCBDD7D90C4BD7098488E9C219A73724EFFD6FAE5644738FAA31A4FF55BCCC0A151AF5F0DC8B4BD45BF37DF365C1A65E68CFDA76D4DA708DF1FB2BC2E4A4371";
    private static final String RFC5114_1024_160_Q = "F518AA8781A8DF278ABA4E7D64B7CB9D49462353";
    @Deprecated
    public static final DHParameters RFC5114_2048_224 = fromPGQ(RFC5114_2048_224_P, RFC5114_2048_224_G, RFC5114_2048_224_Q);
    private static final String RFC5114_2048_224_G = "AC4032EF4F2D9AE39DF30B5C8FFDAC506CDEBE7B89998CAF74866A08CFE4FFE3A6824A4E10B9A6F0DD921F01A70C4AFAAB739D7700C29F52C57DB17C620A8652BE5E9001A8D66AD7C17669101999024AF4D027275AC1348BB8A762D0521BC98AE247150422EA1ED409939D54DA7460CDB5F6C6B250717CBEF180EB34118E98D119529A45D6F834566E3025E316A330EFBB77A86F0C1AB15B051AE3D428C8F8ACB70A8137150B8EEB10E183EDD19963DDD9E263E4770589EF6AA21E7F5F2FF381B539CCE3409D13CD566AFBB48D6C019181E1BCFE94B30269EDFE72FE9B6AA4BD7B5A0F1C71CFFF4C19C418E1F6EC017981BC087F2A7065B384B890D3191F2BFA";
    private static final String RFC5114_2048_224_P = "AD107E1E9123A9D0D660FAA79559C51FA20D64E5683B9FD1B54B1597B61D0A75E6FA141DF95A56DBAF9A3C407BA1DF15EB3D688A309C180E1DE6B85A1274A0A66D3F8152AD6AC2129037C9EDEFDA4DF8D91E8FEF55B7394B7AD5B7D0B6C12207C9F98D11ED34DBF6C6BA0B2C8BBC27BE6A00E0A0B9C49708B3BF8A317091883681286130BC8985DB1602E714415D9330278273C7DE31EFDC7310F7121FD5A07415987D9ADC0A486DCDF93ACC44328387315D75E198C641A480CD86A1B9E587E8BE60E69CC928B2B9C52172E413042E9B23F10B0E16E79763C9B53DCF4BA80A29E3FB73C16B8E75B97EF363E2FFA31F71CF9DE5384E71B81C0AC4DFFE0C10E64F";
    private static final String RFC5114_2048_224_Q = "801C0D34C58D93FE997177101F80535A4738CEBCBF389A99B36371EB";
    @Deprecated
    public static final DHParameters RFC5114_2048_256 = fromPGQ(RFC5114_2048_256_P, RFC5114_2048_256_G, RFC5114_2048_256_Q);
    private static final String RFC5114_2048_256_G = "3FB32C9B73134D0B2E77506660EDBD484CA7B18F21EF205407F4793A1A0BA12510DBC15077BE463FFF4FED4AAC0BB555BE3A6C1B0C6B47B1BC3773BF7E8C6F62901228F8C28CBB18A55AE31341000A650196F931C77A57F2DDF463E5E9EC144B777DE62AAAB8A8628AC376D282D6ED3864E67982428EBC831D14348F6F2F9193B5045AF2767164E1DFC967C1FB3F2E55A4BD1BFFE83B9C80D052B985D182EA0ADB2A3B7313D3FE14C8484B1E052588B9B7D2BBD2DF016199ECD06E1557CD0915B3353BBB64E0EC377FD028370DF92B52C7891428CDC67EB6184B523D1DB246C32F63078490F00EF8D647D148D47954515E2327CFEF98C582664B4C0F6CC41659";
    private static final String RFC5114_2048_256_P = "87A8E61DB4B6663CFFBBD19C651959998CEEF608660DD0F25D2CEED4435E3B00E00DF8F1D61957D4FAF7DF4561B2AA3016C3D91134096FAA3BF4296D830E9A7C209E0C6497517ABD5A8A9D306BCF67ED91F9E6725B4758C022E0B1EF4275BF7B6C5BFC11D45F9088B941F54EB1E59BB8BC39A0BF12307F5C4FDB70C581B23F76B63ACAE1CAA6B7902D52526735488A0EF13C6D9A51BFA4AB3AD8347796524D8EF6A167B5A41825D967E144E5140564251CCACB83E6B486F6B3CA3F7971506026C0B857F689962856DED4010ABD0BE621C3A3960A54E710C375F26375D7014103A4B54330C198AF126116D2276E11715F693877FAD7EF09CADB094AE91E1A1597";
    private static final String RFC5114_2048_256_Q = "8CF83642A709A097B447997640129DA299B1A47D1EB3750BA308B0FE64F5FBD3";

    private Util() {
    }

    public static ECPoint add(ECPoint eCPoint, ECPoint eCPoint2, ECParameterSpec eCParameterSpec) {
        return fromBouncyCastleECPoint(toBouncyCastleECPoint(eCPoint, eCParameterSpec).add(toBouncyCastleECPoint(eCPoint2, eCParameterSpec)));
    }

    public static PublicKey addMissingParametersToPublicKey(AlgorithmParameterSpec algorithmParameterSpec, PublicKey publicKey) {
        if (publicKey == null) {
            return null;
        }
        try {
            String algorithm = publicKey.getAlgorithm();
            if ((!"EC".equals(algorithm) && !"ECDSA".equals(algorithm) && !"ECDH".equals(algorithm)) || !(algorithmParameterSpec instanceof ECParameterSpec)) {
                return publicKey;
            }
            return KeyFactory.getInstance("EC", BC_PROVIDER).generatePublic(new ECPublicKeySpec(((ECPublicKey) publicKey).getW(), (ECParameterSpec) algorithmParameterSpec));
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Could not make public key param spec explicit", e);
            return publicKey;
        }
    }

    public static byte[] alignKeyDataToSize(byte[] bArr, int i) {
        int i2;
        byte[] bArr2 = new byte[i];
        if (bArr.length < i) {
            i2 = bArr.length;
        } else {
            i2 = i;
        }
        System.arraycopy(bArr, bArr.length - i2, bArr2, i - i2, i2);
        return bArr2;
    }

    public static BigInteger computeAffineY(BigInteger bigInteger, ECParameterSpec eCParameterSpec) {
        ECCurve bouncyCastleECCurve = toBouncyCastleECCurve(eCParameterSpec);
        ECFieldElement a = bouncyCastleECCurve.getA();
        ECFieldElement b = bouncyCastleECCurve.getB();
        ECFieldElement fromBigInteger = bouncyCastleECCurve.fromBigInteger(bigInteger);
        return fromBigInteger.multiply(fromBigInteger).add(a).multiply(fromBigInteger).add(b).sqrt().toBigInteger();
    }

    public static byte[] computeKeySeed(String str, String str2, String str3, String str4, boolean z) throws GeneralSecurityException {
        return computeKeySeed(str + MRZInfo.checkDigit(str) + str2 + MRZInfo.checkDigit(str2) + str3 + MRZInfo.checkDigit(str3), str4, z);
    }

    public static SecretKey deriveKey(byte[] bArr, int i) throws GeneralSecurityException {
        return deriveKey(bArr, "DESede", 128, i);
    }

    public static byte[] ecPoint2OS(ECPoint eCPoint, int i) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        BigInteger affineX = eCPoint.getAffineX();
        BigInteger affineY = eCPoint.getAffineY();
        try {
            byteArrayOutputStream.write(4);
            double d = ((double) i) / 8.0d;
            byteArrayOutputStream.write(i2os(affineX, (int) Math.ceil(d)));
            byteArrayOutputStream.write(i2os(affineY, (int) Math.ceil(d)));
            byteArrayOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            throw new IllegalStateException("Exception", e);
        }
    }

    public static ECPoint fromBouncyCastleECPoint(com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECPoint eCPoint) {
        com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECPoint normalize = eCPoint.normalize();
        if (!normalize.isValid()) {
            LOGGER.warning("point not valid");
        }
        return new ECPoint(normalize.getAffineXCoord().toBigInteger(), normalize.getAffineYCoord().toBigInteger());
    }

    private static BigInteger fromHex(String str) {
        return new BigInteger(1, Hex.decodeStrict(str));
    }

    private static DHParameters fromPGQ(String str, String str2, String str3) {
        return new DHParameters(fromHex(str), fromHex(str2), fromHex(str3));
    }

    public static Provider getBouncyCastleProvider() {
        return BC_PROVIDER;
    }

    public static byte[] getBytes(String str) {
        byte[] bytes = str.getBytes();
        try {
            return str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            LOGGER.log(Level.WARNING, "Exception", e);
            return bytes;
        }
    }

    public static CertificateFactory getCertificateFactory(String str) throws GeneralSecurityException {
        try {
            return CertificateFactory.getInstance(str);
        } catch (Exception e) {
            LOGGER.log(Level.FINE, "Default provider could not provide this Certificate Factory, falling back ot explicit BC", e);
            return CertificateFactory.getInstance(str, BC_PROVIDER);
        }
    }

    public static Cipher getCipher(String str) throws GeneralSecurityException {
        try {
            return Cipher.getInstance(str);
        } catch (Exception e) {
            LOGGER.log(Level.FINE, "Default provider could not provide this cipher, falling back to explicit BC", e);
            return Cipher.getInstance(str, BC_PROVIDER);
        }
    }

    public static String getCurveName(ECParameterSpec eCParameterSpec) {
        ECNamedCurveSpec namedCurveSpec = toNamedCurveSpec(eCParameterSpec);
        if (namedCurveSpec == null) {
            return null;
        }
        return namedCurveSpec.getName();
    }

    public static String getDetailedPrivateKeyAlgorithm(PrivateKey privateKey) {
        String curveName;
        if (privateKey == null) {
            return "null";
        }
        String algorithm = privateKey.getAlgorithm();
        if (privateKey instanceof RSAPrivateKey) {
            int bitLength = ((RSAPrivateKey) privateKey).getModulus().bitLength();
            return algorithm + " [" + bitLength + " bit]";
        } else if (!(privateKey instanceof ECPrivateKey) || (curveName = getCurveName(((ECPrivateKey) privateKey).getParams())) == null) {
            return algorithm;
        } else {
            return algorithm + " [" + curveName + "]";
        }
    }

    public static String getDetailedPublicKeyAlgorithm(PublicKey publicKey) {
        if (publicKey == null) {
            return "null";
        }
        String algorithm = publicKey.getAlgorithm();
        if (publicKey instanceof RSAPublicKey) {
            int bitLength = ((RSAPublicKey) publicKey).getModulus().bitLength();
            return algorithm + " [" + bitLength + " bit]";
        } else if (publicKey instanceof ECPublicKey) {
            String curveName = getCurveName(((ECPublicKey) publicKey).getParams());
            if (curveName == null) {
                return algorithm;
            }
            return algorithm + " [" + curveName + "]";
        } else if (!(publicKey instanceof DHPublicKey)) {
            return algorithm;
        } else {
            DHPublicKey dHPublicKey = (DHPublicKey) publicKey;
            dHPublicKey.getY();
            DHParameterSpec params = dHPublicKey.getParams();
            BigInteger g = params.getG();
            int l = params.getL();
            BigInteger p = params.getP();
            return algorithm + " [p.length = " + p.bitLength() + ", g.length = " + g.bitLength() + ", l = " + l + "]";
        }
    }

    public static KeyAgreement getKeyAgreement(String str) throws GeneralSecurityException {
        try {
            return KeyAgreement.getInstance(str);
        } catch (Exception e) {
            LOGGER.log(Level.FINE, "Default provider could not provide this Key Agreement, falling back to explicit BC", e);
            return KeyAgreement.getInstance(str, BC_PROVIDER);
        }
    }

    public static KeyPairGenerator getKeyPairGenerator(String str) throws GeneralSecurityException {
        try {
            return KeyPairGenerator.getInstance(str);
        } catch (Exception e) {
            LOGGER.log(Level.FINE, "Default provider could not provide this Key Pair Generator, falling back to explicit BC", e);
            return KeyPairGenerator.getInstance(str, BC_PROVIDER);
        }
    }

    public static Mac getMac(String str) throws GeneralSecurityException {
        try {
            return Mac.getInstance(str);
        } catch (Exception e) {
            LOGGER.log(Level.FINE, "Default provider could not provide this Mac, falling back to explicit BC", e);
            return Mac.getInstance(str, BC_PROVIDER);
        }
    }

    public static MessageDigest getMessageDigest(String str) throws GeneralSecurityException {
        try {
            return MessageDigest.getInstance(str);
        } catch (Exception e) {
            LOGGER.log(Level.FINE, "Default provider could not provide this Message Digest, falling back to explicit BC", e);
            return MessageDigest.getInstance(str, BC_PROVIDER);
        }
    }

    public static BigInteger getPrime(AlgorithmParameterSpec algorithmParameterSpec) {
        if (algorithmParameterSpec == null) {
            throw new IllegalArgumentException("Parameters null");
        } else if (algorithmParameterSpec instanceof DHParameterSpec) {
            return ((DHParameterSpec) algorithmParameterSpec).getP();
        } else {
            if (algorithmParameterSpec instanceof ECParameterSpec) {
                ECField field = ((ECParameterSpec) algorithmParameterSpec).getCurve().getField();
                if (field instanceof ECFieldFp) {
                    return ((ECFieldFp) field).getP();
                }
                throw new IllegalStateException("Was expecting prime field of type ECFieldFp, found " + field.getClass().getCanonicalName());
            }
            throw new IllegalArgumentException("Unsupported agreement algorithm, was expecting DHParameterSpec or ECParameterSpec, found " + algorithmParameterSpec.getClass().getCanonicalName());
        }
    }

    public static PublicKey getPublicKey(String str, KeySpec keySpec) throws GeneralSecurityException {
        try {
            return KeyFactory.getInstance(str).generatePublic(keySpec);
        } catch (Exception e) {
            LOGGER.log(Level.FINE, "Default provider could not provide this Key Factory or Public Key, falling back to explicit BC", e);
            return KeyFactory.getInstance(str, BC_PROVIDER).generatePublic(keySpec);
        }
    }

    public static byte[] getRawECDSASignature(byte[] bArr, int i) throws IOException {
        ASN1InputStream aSN1InputStream = new ASN1InputStream(bArr);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            Enumeration objects = ((ASN1Sequence) aSN1InputStream.readObject()).getObjects();
            while (objects.hasMoreElements()) {
                byteArrayOutputStream.write(alignKeyDataToSize(((ASN1Integer) objects.nextElement()).getValue().toByteArray(), i));
            }
            byteArrayOutputStream.flush();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            aSN1InputStream.close();
            byteArrayOutputStream.close();
            return byteArray;
        } catch (Throwable th) {
            aSN1InputStream.close();
            byteArrayOutputStream.close();
            throw th;
        }
    }

    public static Signature getSignature(String str) throws GeneralSecurityException {
        try {
            return Signature.getInstance(str);
        } catch (Exception e) {
            LOGGER.log(Level.FINE, "Default provider could not provide this Signature, falling back to explicit BC", e);
            return Signature.getInstance(str, BC_PROVIDER);
        }
    }

    public static byte[] i2os(BigInteger bigInteger, int i) {
        BigInteger valueOf = BigInteger.valueOf(256);
        byte[] bArr = new byte[i];
        for (int i2 = 0; i2 < i; i2++) {
            BigInteger mod = bigInteger.mod(valueOf);
            bigInteger = bigInteger.divide(valueOf);
            bArr[(i - 1) - i2] = (byte) mod.intValue();
        }
        return bArr;
    }

    public static String inferDigestAlgorithmFromCipherAlgorithmForKeyDerivation(String str, int i) {
        if (str == null) {
            throw new IllegalArgumentException();
        } else if ("DESede".equals(str) || "AES-128".equals(str)) {
            return McElieceCCA2KeyGenParameterSpec.SHA1;
        } else {
            if ("AES".equals(str) && i == 128) {
                return McElieceCCA2KeyGenParameterSpec.SHA1;
            }
            if ("AES-256".equals(str) || "AES-192".equals(str)) {
                return "SHA-256";
            }
            if ("AES".equals(str) && (i == 192 || i == 256)) {
                return "SHA-256";
            }
            throw new IllegalArgumentException("Unsupported cipher algorithm or key length \"" + str + "\", " + i);
        }
    }

    public static String inferDigestAlgorithmFromSignatureAlgorithm(String str) {
        String str2;
        if (str != null) {
            String upperCase = str.toUpperCase();
            if (upperCase.contains("WITH")) {
                str2 = upperCase.split("WITH")[0];
            } else {
                str2 = null;
            }
            if ("SHA1".equalsIgnoreCase(str2)) {
                return McElieceCCA2KeyGenParameterSpec.SHA1;
            }
            if ("SHA224".equalsIgnoreCase(str2)) {
                return McElieceCCA2KeyGenParameterSpec.SHA224;
            }
            if ("SHA256".equalsIgnoreCase(str2)) {
                return "SHA-256";
            }
            if ("SHA384".equalsIgnoreCase(str2)) {
                return McElieceCCA2KeyGenParameterSpec.SHA384;
            }
            if ("SHA512".equalsIgnoreCase(str2)) {
                return "SHA-512";
            }
            return str2;
        }
        throw new IllegalArgumentException();
    }

    public static String inferKeyAgreementAlgorithm(PublicKey publicKey) {
        if (publicKey instanceof ECPublicKey) {
            return "ECDH";
        }
        if (publicKey instanceof DHPublicKey) {
            return "DH";
        }
        throw new IllegalArgumentException("Unsupported public key: " + publicKey);
    }

    public static String inferProtocolIdentifier(PublicKey publicKey) {
        String algorithm = publicKey.getAlgorithm();
        if ("EC".equals(algorithm) || "ECDH".equals(algorithm)) {
            return SecurityInfo.ID_PK_ECDH;
        }
        if ("DH".equals(algorithm)) {
            return SecurityInfo.ID_PK_DH;
        }
        throw new IllegalArgumentException("Wrong key type. Was expecting ECDH or DH public key.");
    }

    public static boolean isPointOnCurve(ECPoint eCPoint, ECParameterSpec eCParameterSpec) {
        BigInteger affineX = eCPoint.getAffineX();
        BigInteger affineY = eCPoint.getAffineY();
        BigInteger prime = getPrime(eCParameterSpec);
        EllipticCurve curve = eCParameterSpec.getCurve();
        BigInteger a = curve.getA();
        return affineY.multiply(affineY).mod(prime).equals(affineX.multiply(affineX).multiply(affineX).add(a.multiply(affineX)).add(curve.getB()).mod(prime));
    }

    public static boolean isValid(ECPoint eCPoint, ECParameterSpec eCParameterSpec) {
        return toBouncyCastleECPoint(eCPoint, eCParameterSpec).isValid();
    }

    public static ECPoint multiply(BigInteger bigInteger, ECPoint eCPoint, ECParameterSpec eCParameterSpec) {
        return fromBouncyCastleECPoint(toBouncyCastleECPoint(eCPoint, eCParameterSpec).multiply(bigInteger));
    }

    public static ECPoint normalize(ECPoint eCPoint, ECParameterSpec eCParameterSpec) {
        return fromBouncyCastleECPoint(toBouncyCastleECPoint(eCPoint, eCParameterSpec).normalize());
    }

    public static ECPoint os2ECPoint(byte[] bArr) {
        DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(bArr));
        try {
            if (dataInputStream.read() == 4) {
                int length = (bArr.length - 1) / 2;
                byte[] bArr2 = new byte[length];
                byte[] bArr3 = new byte[length];
                dataInputStream.readFully(bArr2);
                dataInputStream.readFully(bArr3);
                dataInputStream.close();
                ECPoint eCPoint = new ECPoint(os2i(bArr2), os2i(bArr3));
                try {
                    dataInputStream.close();
                } catch (IOException e) {
                    LOGGER.log(Level.FINE, "Error closing stream", e);
                }
                return eCPoint;
            }
            throw new IllegalArgumentException("Expected encoded ECPoint to start with 0x04");
        } catch (IOException e2) {
            throw new IllegalArgumentException("Exception", e2);
        } catch (Throwable th) {
            try {
                dataInputStream.close();
            } catch (IOException e3) {
                LOGGER.log(Level.FINE, "Error closing stream", e3);
            }
            throw th;
        }
    }

    public static BigInteger os2fe(byte[] bArr, BigInteger bigInteger) {
        return os2i(bArr).mod(bigInteger);
    }

    public static BigInteger os2i(byte[] bArr) {
        if (bArr != null) {
            return os2i(bArr, 0, bArr.length);
        }
        throw new IllegalArgumentException();
    }

    public static byte[] pad(byte[] bArr, int i) {
        return pad(bArr, 0, bArr.length, i);
    }

    public static List<byte[]> partition(int i, byte[] bArr) {
        ArrayList arrayList = new ArrayList();
        if (bArr == null || i <= 0) {
            throw new IllegalArgumentException("Cannot partition");
        }
        int min = Math.min(bArr.length, i);
        int length = bArr.length / min;
        int length2 = bArr.length % min;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            byte[] bArr2 = new byte[min];
            System.arraycopy(bArr, i2, bArr2, 0, min);
            arrayList.add(bArr2);
            i2 += min;
        }
        if (length2 != 0) {
            byte[] bArr3 = new byte[length2];
            System.arraycopy(bArr, i2, bArr3, 0, length2);
            arrayList.add(bArr3);
        }
        return arrayList;
    }

    public static PublicKey reconstructPublicKey(PublicKey publicKey) {
        if (!(publicKey instanceof ECPublicKey)) {
            return publicKey;
        }
        try {
            ECPublicKey eCPublicKey = (ECPublicKey) publicKey;
            return KeyFactory.getInstance("EC", BC_PROVIDER).generatePublic(new ECPublicKeySpec(eCPublicKey.getW(), toExplicitECParameterSpec(eCPublicKey.getParams())));
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Could not make public key param spec explicit", e);
            return publicKey;
        }
    }

    public static byte[] recoverMessage(int i, byte[] bArr) {
        int i2;
        if (bArr == null || bArr.length < 1) {
            throw new IllegalArgumentException("Plaintext is too short to recover message");
        } else if (((bArr[bArr.length - 1] & IdCardService.SFI_DG15) ^ IdCardService.SFI_DG12) == 0) {
            if (((bArr[bArr.length - 1] & 255) ^ PSSSigner.TRAILER_IMPLICIT) == 0) {
                i2 = 1;
            } else if (((bArr[bArr.length - 1] & 255) ^ 204) == 0) {
                i2 = 2;
            } else {
                throw new NumberFormatException("Not an ISO 9796-2 scheme 2 signature trailer");
            }
            byte b = bArr[0];
            if (((b & ISO7816.INS_GET_RESPONSE) ^ 64) != 0) {
                throw new NumberFormatException("Could not get M1");
            } else if ((b & ISO7816.INS_VERIFY) != 0) {
                int i3 = 0;
                while (i3 < bArr.length && ((bArr[i3] & IdCardService.SFI_DG15) ^ 10) != 0) {
                    i3++;
                }
                int i4 = i3 + 1;
                int length = ((bArr.length - i2) - i) - i4;
                if (length > 0) {
                    byte[] bArr2 = new byte[length];
                    System.arraycopy(bArr, i4, bArr2, 0, length);
                    return bArr2;
                }
                throw new NumberFormatException("Could not get M1");
            } else {
                throw new NumberFormatException("Could not get M1, first byte indicates partial recovery not enabled: " + Integer.toHexString(bArr[0]));
            }
        } else {
            throw new NumberFormatException("Could not get M1, malformed trailer");
        }
    }

    public static byte[] stripLeadingZeroes(byte[] bArr) {
        if (bArr != null && bArr.length > 1) {
            while (bArr.length > 0 && bArr[0] == 0) {
                int length = bArr.length - 1;
                byte[] bArr2 = new byte[length];
                System.arraycopy(bArr, 1, bArr2, 0, length);
                bArr = bArr2;
            }
        }
        return bArr;
    }

    private static ECCurve toBouncyCastleECCurve(ECParameterSpec eCParameterSpec) {
        EllipticCurve curve = eCParameterSpec.getCurve();
        ECField field = curve.getField();
        if (field instanceof ECFieldFp) {
            int cofactor = eCParameterSpec.getCofactor();
            BigInteger order = eCParameterSpec.getOrder();
            return new ECCurve.Fp(getPrime(eCParameterSpec), curve.getA(), curve.getB(), order, BigInteger.valueOf((long) cofactor));
        }
        throw new IllegalArgumentException("Only prime field supported (for now), found " + field.getClass().getCanonicalName());
    }

    public static com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECPoint toBouncyCastleECPoint(ECPoint eCPoint, ECParameterSpec eCParameterSpec) {
        return toBouncyCastleECCurve(eCParameterSpec).createPoint(eCPoint.getAffineX(), eCPoint.getAffineY());
    }

    public static ECDomainParameters toBouncyECDomainParameters(ECParameterSpec eCParameterSpec) {
        return new ECDomainParameters(toBouncyCastleECCurve(eCParameterSpec), toBouncyCastleECPoint(eCParameterSpec.getGenerator(), eCParameterSpec), eCParameterSpec.getOrder(), BigInteger.valueOf((long) eCParameterSpec.getCofactor()), eCParameterSpec.getCurve().getSeed());
    }

    public static ECPrivateKeyParameters toBouncyECPrivateKeyParameters(ECPrivateKey eCPrivateKey) {
        return new ECPrivateKeyParameters(eCPrivateKey.getS(), toBouncyECDomainParameters(eCPrivateKey.getParams()));
    }

    public static ECPublicKeyParameters toBouncyECPublicKeyParameters(ECPublicKey eCPublicKey) {
        ECParameterSpec params = eCPublicKey.getParams();
        return new ECPublicKeyParameters(toBouncyCastleECPoint(eCPublicKey.getW(), params), toBouncyECDomainParameters(params));
    }

    public static ECNamedCurveSpec toECNamedCurveSpec(ECNamedCurveParameterSpec eCNamedCurveParameterSpec) {
        return new ECNamedCurveSpec(eCNamedCurveParameterSpec.getName(), eCNamedCurveParameterSpec.getCurve(), eCNamedCurveParameterSpec.getG(), eCNamedCurveParameterSpec.getN(), eCNamedCurveParameterSpec.getH(), eCNamedCurveParameterSpec.getSeed());
    }

    public static DHParameterSpec toExplicitDHParameterSpec(DHParameters dHParameters) {
        BigInteger p = dHParameters.getP();
        BigInteger g = dHParameters.getG();
        BigInteger q = dHParameters.getQ();
        int l = dHParameters.getL();
        if (q == null) {
            return new DHParameterSpec(p, g, l);
        }
        return new PACEInfo.DHCParameterSpec(p, g, q);
    }

    public static ECParameterSpec toExplicitECParameterSpec(ECNamedCurveParameterSpec eCNamedCurveParameterSpec) {
        return toExplicitECParameterSpec((ECParameterSpec) toECNamedCurveSpec(eCNamedCurveParameterSpec));
    }

    private static ECNamedCurveSpec toNamedCurveSpec(ECParameterSpec eCParameterSpec) {
        if (eCParameterSpec == null) {
            return null;
        }
        if (eCParameterSpec instanceof ECNamedCurveSpec) {
            return (ECNamedCurveSpec) eCParameterSpec;
        }
        ArrayList<String> list = Collections.list(ECNamedCurveTable.getNames());
        ArrayList arrayList = new ArrayList();
        for (String parameterSpec : list) {
            ECNamedCurveSpec eCNamedCurveSpec = toECNamedCurveSpec(ECNamedCurveTable.getParameterSpec(parameterSpec));
            if (eCNamedCurveSpec.getCurve().equals(eCParameterSpec.getCurve()) && eCNamedCurveSpec.getGenerator().equals(eCParameterSpec.getGenerator()) && eCNamedCurveSpec.getOrder().equals(eCParameterSpec.getOrder()) && eCNamedCurveSpec.getCofactor() == eCParameterSpec.getCofactor()) {
                arrayList.add(eCNamedCurveSpec);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        if (arrayList.size() == 1) {
            return (ECNamedCurveSpec) arrayList.get(0);
        }
        return (ECNamedCurveSpec) arrayList.get(0);
    }

    public static byte[] toOIDBytes(String str) {
        TLVInputStream tLVInputStream;
        try {
            tLVInputStream = new TLVInputStream(new ByteArrayInputStream(new ASN1ObjectIdentifier(str).getEncoded()));
            tLVInputStream.readTag();
            tLVInputStream.readLength();
            byte[] readValue = tLVInputStream.readValue();
            tLVInputStream.close();
            return TLVUtil.wrapDO(128, readValue);
        } catch (IOException e) {
            throw new IllegalArgumentException("Illegal OID: \"" + str, e);
        } catch (Throwable th) {
            tLVInputStream.close();
            throw th;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
        LOGGER.log(java.util.logging.Level.FINE, "Not DH public key? Fine, try EC public key", r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0031, code lost:
        return java.security.KeyFactory.getInstance("EC", BC_PROVIDER).generatePublic(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0034, code lost:
        LOGGER.log(java.util.logging.Level.WARNING, "Exception", r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x003b, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0019, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001b, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x0019 A[ExcHandler: Exception (r6v2 'e' java.lang.Exception A[CUSTOM_DECLARE]), Splitter:B:1:0x0005] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.security.PublicKey toPublicKey(com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.SubjectPublicKeyInfo r6) {
        /*
            java.lang.String r0 = "Exception"
            r1 = 0
            java.lang.String r2 = "DER"
            byte[] r6 = r6.getEncoded(r2)     // Catch:{ GeneralSecurityException -> 0x0032, Exception -> 0x0019 }
            java.security.spec.X509EncodedKeySpec r2 = new java.security.spec.X509EncodedKeySpec     // Catch:{ GeneralSecurityException -> 0x0032, Exception -> 0x0019 }
            r2.<init>(r6)     // Catch:{ GeneralSecurityException -> 0x0032, Exception -> 0x0019 }
            java.lang.String r6 = "DH"
            java.security.KeyFactory r6 = java.security.KeyFactory.getInstance(r6)     // Catch:{ GeneralSecurityException -> 0x001b, Exception -> 0x0019 }
            java.security.PublicKey r6 = r6.generatePublic(r2)     // Catch:{ GeneralSecurityException -> 0x001b, Exception -> 0x0019 }
            return r6
        L_0x0019:
            r6 = move-exception
            goto L_0x0034
        L_0x001b:
            r6 = move-exception
            java.util.logging.Logger r3 = LOGGER     // Catch:{ GeneralSecurityException -> 0x0032, Exception -> 0x0019 }
            java.util.logging.Level r4 = java.util.logging.Level.FINE     // Catch:{ GeneralSecurityException -> 0x0032, Exception -> 0x0019 }
            java.lang.String r5 = "Not DH public key? Fine, try EC public key"
            r3.log(r4, r5, r6)     // Catch:{ GeneralSecurityException -> 0x0032, Exception -> 0x0019 }
            java.lang.String r6 = "EC"
            java.security.Provider r3 = BC_PROVIDER     // Catch:{ GeneralSecurityException -> 0x0032, Exception -> 0x0019 }
            java.security.KeyFactory r6 = java.security.KeyFactory.getInstance(r6, r3)     // Catch:{ GeneralSecurityException -> 0x0032, Exception -> 0x0019 }
            java.security.PublicKey r6 = r6.generatePublic(r2)     // Catch:{ GeneralSecurityException -> 0x0032, Exception -> 0x0019 }
            return r6
        L_0x0032:
            r6 = move-exception
            goto L_0x003c
        L_0x0034:
            java.util.logging.Logger r2 = LOGGER
            java.util.logging.Level r3 = java.util.logging.Level.WARNING
            r2.log(r3, r0, r6)
            return r1
        L_0x003c:
            java.util.logging.Logger r2 = LOGGER
            java.util.logging.Level r3 = java.util.logging.Level.WARNING
            r2.log(r3, r0, r6)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fis.ekyc.nfc.build_in.eidparser.Util.toPublicKey(com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.SubjectPublicKeyInfo):java.security.PublicKey");
    }

    public static SubjectPublicKeyInfo toSubjectPublicKeyInfo(PublicKey publicKey) {
        ASN1InputStream aSN1InputStream;
        ASN1InputStream aSN1InputStream2;
        try {
            String algorithm = publicKey.getAlgorithm();
            if ("EC".equals(algorithm) || "ECDH".equals(algorithm) || (publicKey instanceof ECPublicKey)) {
                aSN1InputStream = new ASN1InputStream(publicKey.getEncoded());
                SubjectPublicKeyInfo instance = SubjectPublicKeyInfo.getInstance(aSN1InputStream.readObject());
                AlgorithmIdentifier algorithm2 = instance.getAlgorithm();
                String id = algorithm2.getAlgorithm().getId();
                if (SecurityInfo.ID_EC_PUBLIC_KEY.equals(id)) {
                    ASN1Primitive aSN1Primitive = algorithm2.getParameters().toASN1Primitive();
                    if (aSN1Primitive instanceof ASN1ObjectIdentifier) {
                        ASN1ObjectIdentifier aSN1ObjectIdentifier = (ASN1ObjectIdentifier) aSN1Primitive;
                        X9ECParameters byOID = X962NamedCurves.getByOID(aSN1ObjectIdentifier);
                        if (byOID != null) {
                            com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECPoint g = byOID.getG();
                            X9ECParameters x9ECParameters = new X9ECParameters(byOID.getCurve(), new X9ECPoint(g.getCurve().createPoint(g.getAffineXCoord().toBigInteger(), g.getAffineYCoord().toBigInteger()), false), byOID.getN(), byOID.getH(), byOID.getSeed());
                            if (publicKey instanceof com.fis.ekyc.nfc.build_in.bouncycastle.jce.interfaces.ECPublicKey) {
                                SubjectPublicKeyInfo subjectPublicKeyInfo = new SubjectPublicKeyInfo(new AlgorithmIdentifier(instance.getAlgorithm().getAlgorithm(), x9ECParameters.toASN1Primitive()), ((com.fis.ekyc.nfc.build_in.bouncycastle.jce.interfaces.ECPublicKey) publicKey).getQ().getEncoded(false));
                                aSN1InputStream.close();
                                return subjectPublicKeyInfo;
                            }
                            aSN1InputStream.close();
                            return instance;
                        }
                        throw new IllegalStateException("Could not find X9.62 named curve for OID " + aSN1ObjectIdentifier.getId());
                    }
                    aSN1InputStream.close();
                    return instance;
                }
                throw new IllegalStateException("Was expecting id-ecPublicKey (" + SecurityInfo.ID_EC_PUBLIC_KEY_TYPE + "), found " + id);
            }
            if (!"DH".equals(algorithm)) {
                if (!(publicKey instanceof DHPublicKey)) {
                    throw new IllegalArgumentException("Unrecognized key type, found " + publicKey.getAlgorithm() + ", should be DH or ECDH");
                }
            }
            aSN1InputStream2 = new ASN1InputStream(publicKey.getEncoded());
            AlgorithmIdentifier algorithm3 = SubjectPublicKeyInfo.getInstance(aSN1InputStream2.readObject()).getAlgorithm();
            DHPublicKey dHPublicKey = (DHPublicKey) publicKey;
            DHParameterSpec params = dHPublicKey.getParams();
            SubjectPublicKeyInfo subjectPublicKeyInfo2 = new SubjectPublicKeyInfo(new AlgorithmIdentifier(algorithm3.getAlgorithm(), new DHParameter(params.getP(), params.getG(), params.getL()).toASN1Primitive()), (ASN1Encodable) new ASN1Integer(dHPublicKey.getY()));
            aSN1InputStream2.close();
            return subjectPublicKeyInfo2;
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Exception", e);
            return null;
        } catch (Throwable th) {
            aSN1InputStream2.close();
            throw th;
        }
    }

    public static byte[] unpad(byte[] bArr) throws BadPaddingException {
        int length = bArr.length - 1;
        while (length >= 0 && bArr[length] == 0) {
            length--;
        }
        if ((bArr[length] & 255) == 128) {
            byte[] bArr2 = new byte[length];
            System.arraycopy(bArr, 0, bArr2, 0, length);
            return bArr2;
        }
        throw new BadPaddingException("Expected constant 0x80, found 0x" + Integer.toHexString(bArr[length] & 255));
    }

    public static SecretKey deriveKey(byte[] bArr, String str, int i, int i2) throws GeneralSecurityException {
        return deriveKey(bArr, str, i, (byte[]) null, i2);
    }

    public static byte[] pad(byte[] bArr, int i, int i2, int i3) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byteArrayOutputStream.write(bArr, i, i2);
        byteArrayOutputStream.write(-128);
        while (byteArrayOutputStream.size() % i3 != 0) {
            byteArrayOutputStream.write(0);
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static ECParameterSpec toExplicitECParameterSpec(ECParameterSpec eCParameterSpec) {
        if (eCParameterSpec == null) {
            return null;
        }
        try {
            ECPoint generator = eCParameterSpec.getGenerator();
            BigInteger order = eCParameterSpec.getOrder();
            int cofactor = eCParameterSpec.getCofactor();
            EllipticCurve curve = eCParameterSpec.getCurve();
            BigInteger a = curve.getA();
            BigInteger b = curve.getB();
            ECField field = curve.getField();
            if (field instanceof ECFieldFp) {
                return new ECParameterSpec(new EllipticCurve(new ECFieldFp(((ECFieldFp) field).getP()), a, b), generator, order, cofactor);
            }
            if (field instanceof ECFieldF2m) {
                return new ECParameterSpec(new EllipticCurve(new ECFieldF2m(((ECFieldF2m) field).getM()), a, b), generator, order, cofactor);
            }
            LOGGER.warning("Could not make named EC param spec explicit");
            return eCParameterSpec;
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Could not make named EC param spec explicit", e);
            return eCParameterSpec;
        }
    }

    public static byte[] computeKeySeed(String str, String str2, boolean z) throws GeneralSecurityException {
        MessageDigest instance = MessageDigest.getInstance(str2);
        instance.update(getBytes(str));
        byte[] digest = instance.digest();
        if (!z) {
            return digest;
        }
        byte[] bArr = new byte[16];
        System.arraycopy(digest, 0, bArr, 0, 16);
        return bArr;
    }

    public static SecretKey deriveKey(byte[] bArr, String str, int i, byte[] bArr2, int i2) throws GeneralSecurityException {
        return deriveKey(bArr, str, i, bArr2, i2, (byte) 0);
    }

    public static BigInteger os2i(byte[] bArr, int i, int i2) {
        if (bArr != null) {
            BigInteger bigInteger = BigInteger.ZERO;
            BigInteger valueOf = BigInteger.valueOf(256);
            for (int i3 = i; i3 < i + i2; i3++) {
                bigInteger = bigInteger.multiply(valueOf).add(BigInteger.valueOf((long) (bArr[i3] & 255)));
            }
            return bigInteger;
        }
        throw new IllegalArgumentException();
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x00ac  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00b2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static javax.crypto.SecretKey deriveKey(byte[] r4, java.lang.String r5, int r6, byte[] r7, int r8, byte r9) throws java.security.GeneralSecurityException {
        /*
            r0 = 0
            java.lang.String r1 = inferDigestAlgorithmFromCipherAlgorithmForKeyDerivation(r5, r6)
            java.security.MessageDigest r1 = getMessageDigest(r1)
            r1.reset()
            r1.update(r4)
            if (r7 == 0) goto L_0x0014
            r1.update(r7)
        L_0x0014:
            byte r4 = (byte) r8
            r7 = 4
            byte[] r7 = new byte[r7]
            r7[r0] = r0
            r8 = 1
            r7[r8] = r0
            r8 = 2
            r7[r8] = r0
            r8 = 3
            r7[r8] = r4
            r1.update(r7)
            byte[] r4 = r1.digest()
            java.lang.String r7 = "DESede"
            boolean r7 = r7.equalsIgnoreCase(r5)
            r8 = 128(0x80, float:1.794E-43)
            r1 = 16
            r2 = 24
            if (r7 != 0) goto L_0x008d
            java.lang.String r7 = "3DES"
            boolean r7 = r7.equalsIgnoreCase(r5)
            if (r7 != 0) goto L_0x008d
            java.lang.String r7 = "AES"
            boolean r3 = r7.equalsIgnoreCase(r5)
            if (r3 != 0) goto L_0x0051
            boolean r7 = r5.startsWith(r7)
            if (r7 == 0) goto L_0x004f
            goto L_0x0051
        L_0x004f:
            r4 = 0
            goto L_0x00aa
        L_0x0051:
            if (r6 == r8) goto L_0x0087
            r7 = 192(0xc0, float:2.69E-43)
            if (r6 == r7) goto L_0x0080
            r7 = 256(0x100, float:3.59E-43)
            if (r6 != r7) goto L_0x0064
            r6 = 32
            byte[] r7 = new byte[r6]
            java.lang.System.arraycopy(r4, r0, r7, r0, r6)
            r4 = r7
            goto L_0x00aa
        L_0x0064:
            java.lang.IllegalArgumentException r4 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r7 = "KDF can only use AES with 128-bit, 192-bit key or 256-bit length, found: "
            r5.append(r7)
            r5.append(r6)
            java.lang.String r6 = "-bit key length"
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            r4.<init>(r5)
            throw r4
        L_0x0080:
            byte[] r6 = new byte[r2]
            java.lang.System.arraycopy(r4, r0, r6, r0, r2)
        L_0x0085:
            r4 = r6
            goto L_0x00aa
        L_0x0087:
            byte[] r6 = new byte[r1]
            java.lang.System.arraycopy(r4, r0, r6, r0, r1)
            goto L_0x0085
        L_0x008d:
            r7 = 112(0x70, float:1.57E-43)
            if (r6 == r7) goto L_0x009c
            if (r6 != r8) goto L_0x0094
            goto L_0x009c
        L_0x0094:
            java.lang.IllegalArgumentException r4 = new java.lang.IllegalArgumentException
            java.lang.String r5 = "KDF can only use DESede with 128-bit key length"
            r4.<init>(r5)
            throw r4
        L_0x009c:
            byte[] r6 = new byte[r2]
            r7 = 8
            java.lang.System.arraycopy(r4, r0, r6, r0, r7)
            java.lang.System.arraycopy(r4, r7, r6, r7, r7)
            java.lang.System.arraycopy(r4, r0, r6, r1, r7)
            goto L_0x0085
        L_0x00aa:
            if (r9 != 0) goto L_0x00b2
            javax.crypto.spec.SecretKeySpec r6 = new javax.crypto.spec.SecretKeySpec
            r6.<init>(r4, r5)
            goto L_0x00b7
        L_0x00b2:
            com.fis.ekyc.nfc.build_in.eidparser.PACESecretKeySpec r6 = new com.fis.ekyc.nfc.build_in.eidparser.PACESecretKeySpec
            r6.<init>(r4, r5, r9)
        L_0x00b7:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fis.ekyc.nfc.build_in.eidparser.Util.deriveKey(byte[], java.lang.String, int, byte[], int, byte):javax.crypto.SecretKey");
    }

    public static Cipher getCipher(String str, int i, Key key) throws GeneralSecurityException {
        try {
            Cipher instance = Cipher.getInstance(str);
            instance.init(i, key);
            return instance;
        } catch (Exception e) {
            LOGGER.log(Level.FINE, "Default provider could not provide this Cipher, falling back to explicit BC", e);
            Cipher instance2 = Cipher.getInstance(str, BC_PROVIDER);
            instance2.init(i, key);
            return instance2;
        }
    }

    public static Mac getMac(String str, Key key) throws GeneralSecurityException {
        try {
            Mac instance = Mac.getInstance(str);
            instance.init(key);
            return instance;
        } catch (Exception e) {
            LOGGER.log(Level.FINE, "Default provider could not provide this Mac, falling back to explicit BC", e);
            Mac instance2 = Mac.getInstance(str, BC_PROVIDER);
            instance2.init(key);
            return instance2;
        }
    }

    public static byte[] i2os(BigInteger bigInteger) {
        int length = bigInteger.toString(16).length();
        if (length % 2 != 0) {
            length++;
        }
        return i2os(bigInteger, length / 2);
    }
}
