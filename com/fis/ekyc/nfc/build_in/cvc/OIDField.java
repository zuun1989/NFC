package com.fis.ekyc.nfc.build_in.cvc;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DEROctetString;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERTaggedObject;
import java.io.IOException;

public class OIDField extends AbstractDataField {
    private static final long serialVersionUID = 5212215839749666908L;
    private String id;

    public OIDField() {
        super(CVCTagEnum.OID);
    }

    public boolean equals(Object obj) {
        if (obj instanceof OIDField) {
            return this.id.equals(((OIDField) obj).getValue());
        }
        return false;
    }

    public byte[] getEncoded() {
        try {
            byte[] encoded = new ASN1ObjectIdentifier(this.id).getEncoded();
            int length = encoded.length - 2;
            byte[] bArr = new byte[length];
            System.arraycopy(encoded, 2, bArr, 0, length);
            return bArr;
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public String getValue() {
        return this.id;
    }

    public String toString() {
        return getValue();
    }

    public String valueAsText() {
        return this.id;
    }

    public OIDField(String str) {
        this();
        this.id = str;
    }

    public OIDField(byte[] bArr) {
        this();
        this.id = ASN1ObjectIdentifier.getInstance(new DERTaggedObject(true, 0, new DEROctetString(bArr)), false).getId();
    }
}
