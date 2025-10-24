package com.fis.ekyc.nfc.build_in.bouncycastle.asn1;

import java.io.IOException;

public class DERTaggedObject extends ASN1TaggedObject {
    public DERTaggedObject(boolean z, int i, ASN1Encodable aSN1Encodable) {
        super(z, i, aSN1Encodable);
    }

    public void encode(ASN1OutputStream aSN1OutputStream, boolean z) throws IOException {
        int i;
        ASN1Primitive dERObject = this.obj.toASN1Primitive().toDERObject();
        if (this.explicit || dERObject.isConstructed()) {
            i = 160;
        } else {
            i = 128;
        }
        aSN1OutputStream.writeTag(z, i, this.tagNo);
        if (this.explicit) {
            aSN1OutputStream.writeLength(dERObject.encodedLength());
        }
        dERObject.encode(aSN1OutputStream.getDERSubStream(), this.explicit);
    }

    public int encodedLength() throws IOException {
        int calculateTagLength;
        int encodedLength = this.obj.toASN1Primitive().toDERObject().encodedLength();
        if (this.explicit) {
            calculateTagLength = StreamUtil.calculateTagLength(this.tagNo) + StreamUtil.calculateBodyLength(encodedLength);
        } else {
            encodedLength--;
            calculateTagLength = StreamUtil.calculateTagLength(this.tagNo);
        }
        return calculateTagLength + encodedLength;
    }

    public boolean isConstructed() {
        if (this.explicit || this.obj.toASN1Primitive().toDERObject().isConstructed()) {
            return true;
        }
        return false;
    }

    public ASN1Primitive toDERObject() {
        return this;
    }

    public ASN1Primitive toDLObject() {
        return this;
    }

    public DERTaggedObject(int i, ASN1Encodable aSN1Encodable) {
        super(true, i, aSN1Encodable);
    }
}
