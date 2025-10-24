package com.fis.ekyc.nfc.build_in.bouncycastle.jce.interfaces;

import com.fis.ekyc.nfc.build_in.bouncycastle.jce.spec.GOST3410PublicKeyParameterSetSpec;

public interface GOST3410Params {
    String getDigestParamSetOID();

    String getEncryptionParamSetOID();

    String getPublicKeyParamSetOID();

    GOST3410PublicKeyParameterSetSpec getPublicKeyParameters();
}
