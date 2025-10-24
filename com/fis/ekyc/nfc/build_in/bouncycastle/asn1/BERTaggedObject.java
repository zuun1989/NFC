package com.fis.ekyc.nfc.build_in.bouncycastle.asn1;

import java.io.IOException;
import java.util.Enumeration;

public class BERTaggedObject extends ASN1TaggedObject {
    public BERTaggedObject(int i, ASN1Encodable aSN1Encodable) {
        super(true, i, aSN1Encodable);
    }

    public void encode(ASN1OutputStream aSN1OutputStream, boolean z) throws IOException {
        Enumeration enumeration;
        aSN1OutputStream.writeTag(z, 160, this.tagNo);
        aSN1OutputStream.write(128);
        if (!this.explicit) {
            ASN1Encodable aSN1Encodable = this.obj;
            if (aSN1Encodable instanceof ASN1OctetString) {
                if (aSN1Encodable instanceof BEROctetString) {
                    enumeration = ((BEROctetString) aSN1Encodable).getObjects();
                } else {
                    enumeration = new BEROctetString(((ASN1OctetString) aSN1Encodable).getOctets()).getObjects();
                }
            } else if (aSN1Encodable instanceof ASN1Sequence) {
                enumeration = ((ASN1Sequence) aSN1Encodable).getObjects();
            } else if (aSN1Encodable instanceof ASN1Set) {
                enumeration = ((ASN1Set) aSN1Encodable).getObjects();
            } else {
                throw new ASN1Exception("not implemented: " + this.obj.getClass().getName());
            }
            aSN1OutputStream.writeElements(enumeration);
        } else {
            aSN1OutputStream.writePrimitive(this.obj.toASN1Primitive(), true);
        }
        aSN1OutputStream.write(0);
        aSN1OutputStream.write(0);
    }

    public int encodedLength() throws IOException {
        int calculateTagLength;
        int encodedLength = this.obj.toASN1Primitive().encodedLength();
        if (this.explicit) {
            calculateTagLength = StreamUtil.calculateTagLength(this.tagNo) + StreamUtil.calculateBodyLength(encodedLength);
        } else {
            encodedLength--;
            calculateTagLength = StreamUtil.calculateTagLength(this.tagNo);
        }
        return calculateTagLength + encodedLength;
    }

    public boolean isConstructed() {
        if (this.explicit || this.obj.toASN1Primitive().isConstructed()) {
            return true;
        }
        return false;
    }

    public BERTaggedObject(boolean z, int i, ASN1Encodable aSN1Encodable) {
        super(z, i, aSN1Encodable);
    }

    public BERTaggedObject(int i) {
        super(false, i, new BERSequence());
    }
}
