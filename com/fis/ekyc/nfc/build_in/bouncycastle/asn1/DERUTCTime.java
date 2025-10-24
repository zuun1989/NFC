package com.fis.ekyc.nfc.build_in.bouncycastle.asn1;

import java.util.Date;

public class DERUTCTime extends ASN1UTCTime {
    public DERUTCTime(byte[] bArr) {
        super(bArr);
    }

    public DERUTCTime(Date date) {
        super(date);
    }

    public DERUTCTime(String str) {
        super(str);
    }
}
