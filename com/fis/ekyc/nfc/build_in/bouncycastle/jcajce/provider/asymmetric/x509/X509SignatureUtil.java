package com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.x509;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Encodable;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Null;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Sequence;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERNull;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.edec.EdECObjectIdentifiers;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.misc.MiscObjectIdentifiers;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.oiw.OIWObjectIdentifiers;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.RSASSAPSSparams;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.AlgorithmIdentifier;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x9.X9ObjectIdentifiers;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.spec.EdDSAParameterSpec;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.util.MessageDigestUtils;
import com.fis.ekyc.nfc.build_in.bouncycastle.jce.provider.BouncyCastleProvider;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.encoders.Hex;
import java.io.IOException;
import java.security.AlgorithmParameters;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.Security;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.PSSParameterSpec;
import java.util.HashMap;
import java.util.Map;

class X509SignatureUtil {
    private static final Map<ASN1ObjectIdentifier, String> algNames;
    private static final ASN1Null derNull = DERNull.INSTANCE;

    static {
        HashMap hashMap = new HashMap();
        algNames = hashMap;
        hashMap.put(EdECObjectIdentifiers.id_Ed25519, EdDSAParameterSpec.Ed25519);
        hashMap.put(EdECObjectIdentifiers.id_Ed448, EdDSAParameterSpec.Ed448);
        hashMap.put(OIWObjectIdentifiers.dsaWithSHA1, "SHA1withDSA");
        hashMap.put(X9ObjectIdentifiers.id_dsa_with_sha1, "SHA1withDSA");
    }

    private static String findAlgName(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        String lookupAlg;
        String lookupAlg2;
        Provider provider = Security.getProvider(BouncyCastleProvider.PROVIDER_NAME);
        if (provider != null && (lookupAlg2 = lookupAlg(provider, aSN1ObjectIdentifier)) != null) {
            return lookupAlg2;
        }
        Provider[] providers = Security.getProviders();
        for (int i = 0; i != providers.length; i++) {
            Provider provider2 = providers[i];
            if (provider != provider2 && (lookupAlg = lookupAlg(provider2, aSN1ObjectIdentifier)) != null) {
                return lookupAlg;
            }
        }
        return aSN1ObjectIdentifier.getId();
    }

    private static String getDigestAlgName(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        String digestName = MessageDigestUtils.getDigestName(aSN1ObjectIdentifier);
        int indexOf = digestName.indexOf(45);
        if (indexOf <= 0 || digestName.startsWith("SHA3")) {
            return digestName;
        }
        return digestName.substring(0, indexOf) + digestName.substring(indexOf + 1);
    }

    public static String getSignatureName(AlgorithmIdentifier algorithmIdentifier) {
        ASN1Encodable parameters = algorithmIdentifier.getParameters();
        if (parameters != null && !derNull.equals(parameters)) {
            if (algorithmIdentifier.getAlgorithm().equals((ASN1Primitive) PKCSObjectIdentifiers.id_RSASSA_PSS)) {
                RSASSAPSSparams instance = RSASSAPSSparams.getInstance(parameters);
                return getDigestAlgName(instance.getHashAlgorithm().getAlgorithm()) + "withRSAandMGF1";
            } else if (algorithmIdentifier.getAlgorithm().equals((ASN1Primitive) X9ObjectIdentifiers.ecdsa_with_SHA2)) {
                ASN1Sequence instance2 = ASN1Sequence.getInstance(parameters);
                return getDigestAlgName((ASN1ObjectIdentifier) instance2.getObjectAt(0)) + "withECDSA";
            }
        }
        String str = algNames.get(algorithmIdentifier.getAlgorithm());
        if (str != null) {
            return str;
        }
        return findAlgName(algorithmIdentifier.getAlgorithm());
    }

    public static boolean isCompositeAlgorithm(AlgorithmIdentifier algorithmIdentifier) {
        return MiscObjectIdentifiers.id_alg_composite.equals((ASN1Primitive) algorithmIdentifier.getAlgorithm());
    }

    private static String lookupAlg(Provider provider, ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        String property = provider.getProperty("Alg.Alias.Signature." + aSN1ObjectIdentifier);
        if (property != null) {
            return property;
        }
        String property2 = provider.getProperty("Alg.Alias.Signature.OID." + aSN1ObjectIdentifier);
        if (property2 != null) {
            return property2;
        }
        return null;
    }

    public static void prettyPrintSignature(byte[] bArr, StringBuffer stringBuffer, String str) {
        if (bArr.length > 20) {
            stringBuffer.append("            Signature: ");
            stringBuffer.append(Hex.toHexString(bArr, 0, 20));
            stringBuffer.append(str);
            for (int i = 20; i < bArr.length; i += 20) {
                if (i < bArr.length - 20) {
                    stringBuffer.append("                       ");
                    stringBuffer.append(Hex.toHexString(bArr, i, 20));
                    stringBuffer.append(str);
                } else {
                    stringBuffer.append("                       ");
                    stringBuffer.append(Hex.toHexString(bArr, i, bArr.length - i));
                    stringBuffer.append(str);
                }
            }
            return;
        }
        stringBuffer.append("            Signature: ");
        stringBuffer.append(Hex.toHexString(bArr));
        stringBuffer.append(str);
    }

    public static void setSignatureParameters(Signature signature, ASN1Encodable aSN1Encodable) throws NoSuchAlgorithmException, SignatureException, InvalidKeyException {
        if (aSN1Encodable != null && !derNull.equals(aSN1Encodable)) {
            AlgorithmParameters instance = AlgorithmParameters.getInstance(signature.getAlgorithm(), signature.getProvider());
            try {
                instance.init(aSN1Encodable.toASN1Primitive().getEncoded());
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
}
