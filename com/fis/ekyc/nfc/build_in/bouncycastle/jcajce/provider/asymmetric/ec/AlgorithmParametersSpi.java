package com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.ec;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Null;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERNull;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x9.ECNamedCurveTable;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x9.X962Parameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x9.X9ECParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x9.X9ECPoint;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.util.EC5Util;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.util.ECUtil;
import com.fis.ekyc.nfc.build_in.bouncycastle.jce.provider.BouncyCastleProvider;
import com.fis.ekyc.nfc.build_in.bouncycastle.jce.spec.ECNamedCurveSpec;
import com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECCurve;
import java.io.IOException;
import java.math.BigInteger;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.ECGenParameterSpec;
import java.security.spec.ECParameterSpec;
import java.security.spec.InvalidParameterSpecException;

public class AlgorithmParametersSpi extends java.security.AlgorithmParametersSpi {
    private String curveName;
    private ECParameterSpec ecParameterSpec;

    public byte[] engineGetEncoded() throws IOException {
        return engineGetEncoded("ASN.1");
    }

    public <T extends AlgorithmParameterSpec> T engineGetParameterSpec(Class<T> cls) throws InvalidParameterSpecException {
        if (ECParameterSpec.class.isAssignableFrom(cls) || cls == AlgorithmParameterSpec.class) {
            return this.ecParameterSpec;
        }
        if (ECGenParameterSpec.class.isAssignableFrom(cls)) {
            String str = this.curveName;
            if (str != null) {
                ASN1ObjectIdentifier namedCurveOid = ECUtil.getNamedCurveOid(str);
                if (namedCurveOid != null) {
                    return new ECGenParameterSpec(namedCurveOid.getId());
                }
                return new ECGenParameterSpec(this.curveName);
            }
            ASN1ObjectIdentifier namedCurveOid2 = ECUtil.getNamedCurveOid(EC5Util.convertSpec(this.ecParameterSpec));
            if (namedCurveOid2 != null) {
                return new ECGenParameterSpec(namedCurveOid2.getId());
            }
        }
        throw new InvalidParameterSpecException("EC AlgorithmParameters cannot convert to " + cls.getName());
    }

    public void engineInit(AlgorithmParameterSpec algorithmParameterSpec) throws InvalidParameterSpecException {
        if (algorithmParameterSpec instanceof ECGenParameterSpec) {
            ECGenParameterSpec eCGenParameterSpec = (ECGenParameterSpec) algorithmParameterSpec;
            X9ECParameters domainParametersFromGenSpec = ECUtils.getDomainParametersFromGenSpec(eCGenParameterSpec);
            if (domainParametersFromGenSpec != null) {
                this.curveName = eCGenParameterSpec.getName();
                ECParameterSpec convertToSpec = EC5Util.convertToSpec(domainParametersFromGenSpec);
                this.ecParameterSpec = new ECNamedCurveSpec(this.curveName, convertToSpec.getCurve(), convertToSpec.getGenerator(), convertToSpec.getOrder(), BigInteger.valueOf((long) convertToSpec.getCofactor()));
                return;
            }
            throw new InvalidParameterSpecException("EC curve name not recognized: " + eCGenParameterSpec.getName());
        } else if (algorithmParameterSpec instanceof ECParameterSpec) {
            if (algorithmParameterSpec instanceof ECNamedCurveSpec) {
                this.curveName = ((ECNamedCurveSpec) algorithmParameterSpec).getName();
            } else {
                this.curveName = null;
            }
            this.ecParameterSpec = (ECParameterSpec) algorithmParameterSpec;
        } else {
            throw new InvalidParameterSpecException("AlgorithmParameterSpec class not recognized: " + algorithmParameterSpec.getClass().getName());
        }
    }

    public String engineToString() {
        return "EC Parameters";
    }

    public boolean isASN1FormatString(String str) {
        if (str == null || str.equals("ASN.1")) {
            return true;
        }
        return false;
    }

    public byte[] engineGetEncoded(String str) throws IOException {
        X962Parameters x962Parameters;
        if (isASN1FormatString(str)) {
            ECParameterSpec eCParameterSpec = this.ecParameterSpec;
            if (eCParameterSpec == null) {
                x962Parameters = new X962Parameters((ASN1Null) DERNull.INSTANCE);
            } else {
                String str2 = this.curveName;
                if (str2 != null) {
                    x962Parameters = new X962Parameters(ECUtil.getNamedCurveOid(str2));
                } else {
                    com.fis.ekyc.nfc.build_in.bouncycastle.jce.spec.ECParameterSpec convertSpec = EC5Util.convertSpec(eCParameterSpec);
                    x962Parameters = new X962Parameters(new X9ECParameters(convertSpec.getCurve(), new X9ECPoint(convertSpec.getG(), false), convertSpec.getN(), convertSpec.getH(), convertSpec.getSeed()));
                }
            }
            return x962Parameters.getEncoded();
        }
        throw new IOException("Unknown parameters format in AlgorithmParameters object: " + str);
    }

    public void engineInit(byte[] bArr) throws IOException {
        engineInit(bArr, "ASN.1");
    }

    public void engineInit(byte[] bArr, String str) throws IOException {
        if (isASN1FormatString(str)) {
            X962Parameters instance = X962Parameters.getInstance(bArr);
            ECCurve curve = EC5Util.getCurve(BouncyCastleProvider.CONFIGURATION, instance);
            if (instance.isNamedCurve()) {
                ASN1ObjectIdentifier instance2 = ASN1ObjectIdentifier.getInstance(instance.getParameters());
                String name = ECNamedCurveTable.getName(instance2);
                this.curveName = name;
                if (name == null) {
                    this.curveName = instance2.getId();
                }
            }
            this.ecParameterSpec = EC5Util.convertToSpec(instance, curve);
            return;
        }
        throw new IOException("Unknown encoded parameters format in AlgorithmParameters object: " + str);
    }
}
