package com.fis.ekyc.nfc.build_in.bouncycastle.asn1;

import java.io.IOException;

public class DLTaggedObject extends ASN1TaggedObject {
    public DLTaggedObject(boolean z, int i, ASN1Encodable aSN1Encodable) {
        super(z, i, aSN1Encodable);
    }

    public void encode(ASN1OutputStream aSN1OutputStream, boolean z) throws IOException {
        int i;
        ASN1Primitive dLObject = this.obj.toASN1Primitive().toDLObject();
        if (this.explicit || dLObject.isConstructed()) {
            i = 160;
        } else {
            i = 128;
        }
        aSN1OutputStream.writeTag(z, i, this.tagNo);
        if (this.explicit) {
            aSN1OutputStream.writeLength(dLObject.encodedLength());
        }
        aSN1OutputStream.getDLSubStream().writePrimitive(dLObject, this.explicit);
    }

    public int encodedLength() throws IOException {
        int calculateTagLength;
        int encodedLength = this.obj.toASN1Primitive().toDLObject().encodedLength();
        if (this.explicit) {
            calculateTagLength = StreamUtil.calculateTagLength(this.tagNo) + StreamUtil.calculateBodyLength(encodedLength);
        } else {
            encodedLength--;
            calculateTagLength = StreamUtil.calculateTagLength(this.tagNo);
        }
        return calculateTagLength + encodedLength;
    }

    public boolean isConstructed() {
        if (this.explicit || this.obj.toASN1Primitive().toDLObject().isConstructed()) {
            return true;
        }
        return false;
    }

    public ASN1Primitive toDLObject() {
        return this;
    }
}
