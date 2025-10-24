package com.fis.ekyc.nfc.build_in.bouncycastle.its.asn1;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Null;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Object;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Sequence;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERNull;
import java.io.IOException;

public class SspRange extends ASN1Object {
    private final BitmapSspRange bitmapSspRange;
    private final boolean isAll;
    private final SequenceOfOctetString opaque;

    private SspRange() {
        this.isAll = true;
        this.opaque = null;
        this.bitmapSspRange = null;
    }

    public static SspRange getInstance(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof SspRange) {
            return (SspRange) obj;
        }
        if (obj instanceof ASN1Null) {
            return new SspRange();
        }
        if (obj instanceof ASN1Sequence) {
            return new SspRange(SequenceOfOctetString.getInstance(obj));
        }
        if (obj instanceof byte[]) {
            try {
                return getInstance(ASN1Primitive.fromByteArray((byte[]) obj));
            } catch (IOException unused) {
                throw new IllegalArgumentException("unable to parse encoded general name");
            }
        } else {
            throw new IllegalArgumentException("unknown object in getInstance: " + obj.getClass().getName());
        }
    }

    public BitmapSspRange getBitmapSspRange() {
        return this.bitmapSspRange;
    }

    public SequenceOfOctetString getOpaque() {
        return this.opaque;
    }

    public boolean isAll() {
        return this.isAll;
    }

    public boolean maybeOpaque() {
        if (this.opaque != null) {
            return true;
        }
        return false;
    }

    public ASN1Primitive toASN1Primitive() {
        if (this.isAll) {
            return DERNull.INSTANCE;
        }
        BitmapSspRange bitmapSspRange2 = this.bitmapSspRange;
        if (bitmapSspRange2 != null) {
            return bitmapSspRange2.toASN1Primitive();
        }
        return this.opaque.toASN1Primitive();
    }

    private SspRange(SequenceOfOctetString sequenceOfOctetString) {
        this.isAll = false;
        BitmapSspRange bitmapSspRange2 = null;
        if (sequenceOfOctetString.size() != 2) {
            this.opaque = sequenceOfOctetString;
            this.bitmapSspRange = null;
            return;
        }
        this.opaque = SequenceOfOctetString.getInstance(sequenceOfOctetString);
        try {
            bitmapSspRange2 = BitmapSspRange.getInstance(sequenceOfOctetString);
        } catch (IllegalArgumentException unused) {
        }
        this.bitmapSspRange = bitmapSspRange2;
    }

    public SspRange(BitmapSspRange bitmapSspRange2) {
        this.isAll = false;
        this.bitmapSspRange = bitmapSspRange2;
        this.opaque = null;
    }
}
