package com.fis.ekyc.nfc.build_in.bouncycastle.asn1.cmp;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Encodable;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Integer;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Object;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Sequence;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERSequence;
import java.math.BigInteger;

public class PollReqContent extends ASN1Object {
    private ASN1Sequence content;

    private PollReqContent(ASN1Sequence aSN1Sequence) {
        this.content = aSN1Sequence;
    }

    public static PollReqContent getInstance(Object obj) {
        if (obj instanceof PollReqContent) {
            return (PollReqContent) obj;
        }
        if (obj != null) {
            return new PollReqContent(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    private static ASN1Integer[] intsToASN1(BigInteger[] bigIntegerArr) {
        int length = bigIntegerArr.length;
        ASN1Integer[] aSN1IntegerArr = new ASN1Integer[length];
        for (int i = 0; i != length; i++) {
            aSN1IntegerArr[i] = new ASN1Integer(bigIntegerArr[i]);
        }
        return aSN1IntegerArr;
    }

    private static DERSequence[] intsToSequence(ASN1Integer[] aSN1IntegerArr) {
        int length = aSN1IntegerArr.length;
        DERSequence[] dERSequenceArr = new DERSequence[length];
        for (int i = 0; i != length; i++) {
            dERSequenceArr[i] = new DERSequence((ASN1Encodable) aSN1IntegerArr[i]);
        }
        return dERSequenceArr;
    }

    private static ASN1Integer[] sequenceToASN1IntegerArray(ASN1Sequence aSN1Sequence) {
        int size = aSN1Sequence.size();
        ASN1Integer[] aSN1IntegerArr = new ASN1Integer[size];
        for (int i = 0; i != size; i++) {
            aSN1IntegerArr[i] = ASN1Integer.getInstance(aSN1Sequence.getObjectAt(i));
        }
        return aSN1IntegerArr;
    }

    public BigInteger[] getCertReqIdValues() {
        int size = this.content.size();
        BigInteger[] bigIntegerArr = new BigInteger[size];
        for (int i = 0; i != size; i++) {
            bigIntegerArr[i] = ASN1Integer.getInstance(ASN1Sequence.getInstance(this.content.getObjectAt(i)).getObjectAt(0)).getValue();
        }
        return bigIntegerArr;
    }

    public ASN1Integer[][] getCertReqIds() {
        int size = this.content.size();
        ASN1Integer[][] aSN1IntegerArr = new ASN1Integer[size][];
        for (int i = 0; i != size; i++) {
            aSN1IntegerArr[i] = sequenceToASN1IntegerArray((ASN1Sequence) this.content.getObjectAt(i));
        }
        return aSN1IntegerArr;
    }

    public ASN1Primitive toASN1Primitive() {
        return this.content;
    }

    public PollReqContent(ASN1Integer aSN1Integer) {
        this((ASN1Sequence) new DERSequence((ASN1Encodable) new DERSequence((ASN1Encodable) aSN1Integer)));
    }

    public PollReqContent(ASN1Integer[] aSN1IntegerArr) {
        this((ASN1Sequence) new DERSequence((ASN1Encodable[]) intsToSequence(aSN1IntegerArr)));
    }

    public PollReqContent(BigInteger bigInteger) {
        this(new ASN1Integer(bigInteger));
    }

    public PollReqContent(BigInteger[] bigIntegerArr) {
        this(intsToASN1(bigIntegerArr));
    }
}
