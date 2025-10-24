package com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.ec;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Null;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERNull;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x9.X962Parameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x9.X9ECParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x9.X9ECPoint;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.AsymmetricKeyParameter;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.util.EC5Util;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.util.ECUtil;
import com.fis.ekyc.nfc.build_in.bouncycastle.jce.spec.ECNamedCurveSpec;
import com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECCurve;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.PublicKey;
import java.security.spec.ECGenParameterSpec;
import java.security.spec.ECParameterSpec;

class ECUtils {
    public static AsymmetricKeyParameter generatePublicKeyParameter(PublicKey publicKey) throws InvalidKeyException {
        if (publicKey instanceof BCECPublicKey) {
            return ((BCECPublicKey) publicKey).engineGetKeyParameters();
        }
        return ECUtil.generatePublicKeyParameter(publicKey);
    }

    public static X9ECParameters getDomainParametersFromGenSpec(ECGenParameterSpec eCGenParameterSpec) {
        return getDomainParametersFromName(eCGenParameterSpec.getName());
    }

    public static X9ECParameters getDomainParametersFromName(String str) {
        try {
            if (str.charAt(0) >= '0' && str.charAt(0) <= '2') {
                return ECUtil.getNamedCurveByOid(new ASN1ObjectIdentifier(str));
            }
            if (str.indexOf(32) > 0) {
                return ECUtil.getNamedCurveByName(str.substring(str.indexOf(32) + 1));
            }
            return ECUtil.getNamedCurveByName(str);
        } catch (IllegalArgumentException unused) {
            return ECUtil.getNamedCurveByName(str);
        }
    }

    public static X962Parameters getDomainParametersFromName(ECParameterSpec eCParameterSpec, boolean z) {
        if (eCParameterSpec instanceof ECNamedCurveSpec) {
            ECNamedCurveSpec eCNamedCurveSpec = (ECNamedCurveSpec) eCParameterSpec;
            ASN1ObjectIdentifier namedCurveOid = ECUtil.getNamedCurveOid(eCNamedCurveSpec.getName());
            if (namedCurveOid == null) {
                namedCurveOid = new ASN1ObjectIdentifier(eCNamedCurveSpec.getName());
            }
            return new X962Parameters(namedCurveOid);
        } else if (eCParameterSpec == null) {
            return new X962Parameters((ASN1Null) DERNull.INSTANCE);
        } else {
            ECCurve convertCurve = EC5Util.convertCurve(eCParameterSpec.getCurve());
            return new X962Parameters(new X9ECParameters(convertCurve, new X9ECPoint(EC5Util.convertPoint(convertCurve, eCParameterSpec.getGenerator()), z), eCParameterSpec.getOrder(), BigInteger.valueOf((long) eCParameterSpec.getCofactor()), eCParameterSpec.getCurve().getSeed()));
        }
    }
}
