package com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.lms;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import java.util.HashMap;
import java.util.Map;

public class LMSigParameters {
    public static final LMSigParameters lms_sha256_n32_h10;
    public static final LMSigParameters lms_sha256_n32_h15;
    public static final LMSigParameters lms_sha256_n32_h20;
    public static final LMSigParameters lms_sha256_n32_h25;
    public static final LMSigParameters lms_sha256_n32_h5;
    private static Map<Object, LMSigParameters> paramBuilders = new HashMap<Object, LMSigParameters>() {
        {
            LMSigParameters lMSigParameters = LMSigParameters.lms_sha256_n32_h5;
            put(Integer.valueOf(lMSigParameters.type), lMSigParameters);
            LMSigParameters lMSigParameters2 = LMSigParameters.lms_sha256_n32_h10;
            put(Integer.valueOf(lMSigParameters2.type), lMSigParameters2);
            LMSigParameters lMSigParameters3 = LMSigParameters.lms_sha256_n32_h15;
            put(Integer.valueOf(lMSigParameters3.type), lMSigParameters3);
            LMSigParameters lMSigParameters4 = LMSigParameters.lms_sha256_n32_h20;
            put(Integer.valueOf(lMSigParameters4.type), lMSigParameters4);
            LMSigParameters lMSigParameters5 = LMSigParameters.lms_sha256_n32_h25;
            put(Integer.valueOf(lMSigParameters5.type), lMSigParameters5);
        }
    };
    private final ASN1ObjectIdentifier digestOid;
    private final int h;
    private final int m;
    /* access modifiers changed from: private */
    public final int type;

    static {
        ASN1ObjectIdentifier aSN1ObjectIdentifier = NISTObjectIdentifiers.id_sha256;
        lms_sha256_n32_h5 = new LMSigParameters(5, 32, 5, aSN1ObjectIdentifier);
        lms_sha256_n32_h10 = new LMSigParameters(6, 32, 10, aSN1ObjectIdentifier);
        lms_sha256_n32_h15 = new LMSigParameters(7, 32, 15, aSN1ObjectIdentifier);
        lms_sha256_n32_h20 = new LMSigParameters(8, 32, 20, aSN1ObjectIdentifier);
        lms_sha256_n32_h25 = new LMSigParameters(9, 32, 25, aSN1ObjectIdentifier);
    }

    public LMSigParameters(int i, int i2, int i3, ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        this.type = i;
        this.m = i2;
        this.h = i3;
        this.digestOid = aSN1ObjectIdentifier;
    }

    public static LMSigParameters getParametersForType(int i) {
        return paramBuilders.get(Integer.valueOf(i));
    }

    public ASN1ObjectIdentifier getDigestOID() {
        return this.digestOid;
    }

    public int getH() {
        return this.h;
    }

    public int getM() {
        return this.m;
    }

    public int getType() {
        return this.type;
    }
}
