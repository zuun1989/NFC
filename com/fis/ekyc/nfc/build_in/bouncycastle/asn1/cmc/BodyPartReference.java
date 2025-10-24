package com.fis.ekyc.nfc.build_in.bouncycastle.asn1.cmc;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Choice;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Encodable;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Integer;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Object;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Sequence;
import java.io.IOException;

public class BodyPartReference extends ASN1Object implements ASN1Choice {
    private final BodyPartID bodyPartID;
    private final BodyPartPath bodyPartPath;

    public BodyPartReference(BodyPartID bodyPartID2) {
        this.bodyPartID = bodyPartID2;
        this.bodyPartPath = null;
    }

    public static BodyPartReference getInstance(Object obj) {
        if (obj instanceof BodyPartReference) {
            return (BodyPartReference) obj;
        }
        if (obj == null) {
            return null;
        }
        if (obj instanceof ASN1Encodable) {
            ASN1Primitive aSN1Primitive = ((ASN1Encodable) obj).toASN1Primitive();
            if (aSN1Primitive instanceof ASN1Integer) {
                return new BodyPartReference(BodyPartID.getInstance(aSN1Primitive));
            }
            if (aSN1Primitive instanceof ASN1Sequence) {
                return new BodyPartReference(BodyPartPath.getInstance(aSN1Primitive));
            }
        }
        if (obj instanceof byte[]) {
            try {
                return getInstance(ASN1Primitive.fromByteArray((byte[]) obj));
            } catch (IOException unused) {
                throw new IllegalArgumentException("unknown encoding in getInstance()");
            }
        } else {
            throw new IllegalArgumentException("unknown object in getInstance(): " + obj.getClass().getName());
        }
    }

    public BodyPartID getBodyPartID() {
        return this.bodyPartID;
    }

    public BodyPartPath getBodyPartPath() {
        return this.bodyPartPath;
    }

    public boolean isBodyPartID() {
        if (this.bodyPartID != null) {
            return true;
        }
        return false;
    }

    public ASN1Primitive toASN1Primitive() {
        BodyPartID bodyPartID2 = this.bodyPartID;
        if (bodyPartID2 != null) {
            return bodyPartID2.toASN1Primitive();
        }
        return this.bodyPartPath.toASN1Primitive();
    }

    public BodyPartReference(BodyPartPath bodyPartPath2) {
        this.bodyPartID = null;
        this.bodyPartPath = bodyPartPath2;
    }
}
