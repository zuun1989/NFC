package com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.spec;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.cryptopro.ECGOST3410NamedCurves;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.rosstandart.RosstandartObjectIdentifiers;
import java.security.spec.AlgorithmParameterSpec;

public class GOST3410ParameterSpec implements AlgorithmParameterSpec {
    private final ASN1ObjectIdentifier digestParamSet;
    private final ASN1ObjectIdentifier encryptionParamSet;
    private final ASN1ObjectIdentifier publicKeyParamSet;

    public GOST3410ParameterSpec(String str) {
        this(getOid(str), getDigestOid(str), (ASN1ObjectIdentifier) null);
    }

    private static ASN1ObjectIdentifier getDigestOid(String str) {
        if (str.indexOf("12-512") > 0) {
            return RosstandartObjectIdentifiers.id_tc26_gost_3411_12_512;
        }
        if (str.indexOf("12-256") > 0) {
            return RosstandartObjectIdentifiers.id_tc26_gost_3411_12_256;
        }
        return CryptoProObjectIdentifiers.gostR3411_94_CryptoProParamSet;
    }

    private static ASN1ObjectIdentifier getOid(String str) {
        return ECGOST3410NamedCurves.getOID(str);
    }

    public ASN1ObjectIdentifier getDigestParamSet() {
        return this.digestParamSet;
    }

    public ASN1ObjectIdentifier getEncryptionParamSet() {
        return this.encryptionParamSet;
    }

    public ASN1ObjectIdentifier getPublicKeyParamSet() {
        return this.publicKeyParamSet;
    }

    public String getPublicKeyParamSetName() {
        return ECGOST3410NamedCurves.getName(getPublicKeyParamSet());
    }

    public GOST3410ParameterSpec(ASN1ObjectIdentifier aSN1ObjectIdentifier, ASN1ObjectIdentifier aSN1ObjectIdentifier2) {
        this(aSN1ObjectIdentifier, aSN1ObjectIdentifier2, (ASN1ObjectIdentifier) null);
    }

    public GOST3410ParameterSpec(ASN1ObjectIdentifier aSN1ObjectIdentifier, ASN1ObjectIdentifier aSN1ObjectIdentifier2, ASN1ObjectIdentifier aSN1ObjectIdentifier3) {
        this.publicKeyParamSet = aSN1ObjectIdentifier;
        this.digestParamSet = aSN1ObjectIdentifier2;
        this.encryptionParamSet = aSN1ObjectIdentifier3;
    }
}
