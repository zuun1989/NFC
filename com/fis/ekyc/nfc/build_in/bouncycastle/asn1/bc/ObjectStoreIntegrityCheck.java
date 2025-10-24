package com.fis.ekyc.nfc.build_in.bouncycastle.asn1.bc;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Choice;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Encodable;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Object;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Sequence;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1TaggedObject;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERTaggedObject;
import java.io.IOException;

public class ObjectStoreIntegrityCheck extends ASN1Object implements ASN1Choice {
    public static final int PBKD_MAC_CHECK = 0;
    public static final int SIG_CHECK = 1;
    private final ASN1Object integrityCheck;
    private final int type;

    public ObjectStoreIntegrityCheck(PbkdMacIntegrityCheck pbkdMacIntegrityCheck) {
        this((ASN1Encodable) pbkdMacIntegrityCheck);
    }

    public static ObjectStoreIntegrityCheck getInstance(Object obj) {
        if (obj instanceof ObjectStoreIntegrityCheck) {
            return (ObjectStoreIntegrityCheck) obj;
        }
        if (obj instanceof byte[]) {
            try {
                return new ObjectStoreIntegrityCheck((ASN1Encodable) ASN1Primitive.fromByteArray((byte[]) obj));
            } catch (IOException unused) {
                throw new IllegalArgumentException("Unable to parse integrity check details.");
            }
        } else if (obj != null) {
            return new ObjectStoreIntegrityCheck((ASN1Encodable) obj);
        } else {
            return null;
        }
    }

    public ASN1Object getIntegrityCheck() {
        return this.integrityCheck;
    }

    public int getType() {
        return this.type;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1Object aSN1Object = this.integrityCheck;
        if (aSN1Object instanceof SignatureCheck) {
            return new DERTaggedObject(0, aSN1Object);
        }
        return aSN1Object.toASN1Primitive();
    }

    public ObjectStoreIntegrityCheck(SignatureCheck signatureCheck) {
        this((ASN1Encodable) new DERTaggedObject(0, signatureCheck));
    }

    private ObjectStoreIntegrityCheck(ASN1Encodable aSN1Encodable) {
        if ((aSN1Encodable instanceof ASN1Sequence) || (aSN1Encodable instanceof PbkdMacIntegrityCheck)) {
            this.type = 0;
            this.integrityCheck = PbkdMacIntegrityCheck.getInstance(aSN1Encodable);
        } else if (aSN1Encodable instanceof ASN1TaggedObject) {
            this.type = 1;
            this.integrityCheck = SignatureCheck.getInstance(((ASN1TaggedObject) aSN1Encodable).getObject());
        } else {
            throw new IllegalArgumentException("Unknown check object in integrity check.");
        }
    }
}
