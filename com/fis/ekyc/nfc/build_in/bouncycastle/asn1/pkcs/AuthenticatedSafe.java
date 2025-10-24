package com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Encodable;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Object;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Sequence;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.BERSequence;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DLSequence;

public class AuthenticatedSafe extends ASN1Object {
    private ContentInfo[] info;
    private boolean isBer = true;

    private AuthenticatedSafe(ASN1Sequence aSN1Sequence) {
        this.info = new ContentInfo[aSN1Sequence.size()];
        int i = 0;
        while (true) {
            ContentInfo[] contentInfoArr = this.info;
            if (i != contentInfoArr.length) {
                contentInfoArr[i] = ContentInfo.getInstance(aSN1Sequence.getObjectAt(i));
                i++;
            } else {
                this.isBer = aSN1Sequence instanceof BERSequence;
                return;
            }
        }
    }

    private ContentInfo[] copy(ContentInfo[] contentInfoArr) {
        int length = contentInfoArr.length;
        ContentInfo[] contentInfoArr2 = new ContentInfo[length];
        System.arraycopy(contentInfoArr, 0, contentInfoArr2, 0, length);
        return contentInfoArr2;
    }

    public static AuthenticatedSafe getInstance(Object obj) {
        if (obj instanceof AuthenticatedSafe) {
            return (AuthenticatedSafe) obj;
        }
        if (obj != null) {
            return new AuthenticatedSafe(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public ContentInfo[] getContentInfo() {
        return copy(this.info);
    }

    public ASN1Primitive toASN1Primitive() {
        if (this.isBer) {
            return new BERSequence((ASN1Encodable[]) this.info);
        }
        return new DLSequence((ASN1Encodable[]) this.info);
    }

    public AuthenticatedSafe(ContentInfo[] contentInfoArr) {
        this.info = copy(contentInfoArr);
    }
}
