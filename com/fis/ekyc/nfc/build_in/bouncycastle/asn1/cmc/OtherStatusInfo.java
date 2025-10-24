package com.fis.ekyc.nfc.build_in.bouncycastle.asn1.cmc;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Choice;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Encodable;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Integer;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Object;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Sequence;
import java.io.IOException;

public class OtherStatusInfo extends ASN1Object implements ASN1Choice {
    private final ExtendedFailInfo extendedFailInfo;
    private final CMCFailInfo failInfo;
    private final PendInfo pendInfo;

    public OtherStatusInfo(CMCFailInfo cMCFailInfo) {
        this(cMCFailInfo, (PendInfo) null, (ExtendedFailInfo) null);
    }

    public static OtherStatusInfo getInstance(Object obj) {
        if (obj instanceof OtherStatusInfo) {
            return (OtherStatusInfo) obj;
        }
        if (obj instanceof ASN1Encodable) {
            ASN1Primitive aSN1Primitive = ((ASN1Encodable) obj).toASN1Primitive();
            if (aSN1Primitive instanceof ASN1Integer) {
                return new OtherStatusInfo(CMCFailInfo.getInstance(aSN1Primitive));
            }
            if (aSN1Primitive instanceof ASN1Sequence) {
                if (((ASN1Sequence) aSN1Primitive).getObjectAt(0) instanceof ASN1ObjectIdentifier) {
                    return new OtherStatusInfo(ExtendedFailInfo.getInstance(aSN1Primitive));
                }
                return new OtherStatusInfo(PendInfo.getInstance(aSN1Primitive));
            }
        } else if (obj instanceof byte[]) {
            try {
                return getInstance(ASN1Primitive.fromByteArray((byte[]) obj));
            } catch (IOException e) {
                throw new IllegalArgumentException("parsing error: " + e.getMessage());
            }
        }
        throw new IllegalArgumentException("unknown object in getInstance(): " + obj.getClass().getName());
    }

    public boolean isExtendedFailInfo() {
        if (this.extendedFailInfo != null) {
            return true;
        }
        return false;
    }

    public boolean isFailInfo() {
        if (this.failInfo != null) {
            return true;
        }
        return false;
    }

    public boolean isPendingInfo() {
        if (this.pendInfo != null) {
            return true;
        }
        return false;
    }

    public ASN1Primitive toASN1Primitive() {
        PendInfo pendInfo2 = this.pendInfo;
        if (pendInfo2 != null) {
            return pendInfo2.toASN1Primitive();
        }
        CMCFailInfo cMCFailInfo = this.failInfo;
        if (cMCFailInfo != null) {
            return cMCFailInfo.toASN1Primitive();
        }
        return this.extendedFailInfo.toASN1Primitive();
    }

    public OtherStatusInfo(PendInfo pendInfo2) {
        this((CMCFailInfo) null, pendInfo2, (ExtendedFailInfo) null);
    }

    public OtherStatusInfo(ExtendedFailInfo extendedFailInfo2) {
        this((CMCFailInfo) null, (PendInfo) null, extendedFailInfo2);
    }

    private OtherStatusInfo(CMCFailInfo cMCFailInfo, PendInfo pendInfo2, ExtendedFailInfo extendedFailInfo2) {
        this.failInfo = cMCFailInfo;
        this.pendInfo = pendInfo2;
        this.extendedFailInfo = extendedFailInfo2;
    }
}
