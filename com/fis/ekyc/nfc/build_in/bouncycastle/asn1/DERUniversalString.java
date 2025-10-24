package com.fis.ekyc.nfc.build_in.bouncycastle.asn1;

import com.fis.ekyc.nfc.build_in.bouncycastle.util.Arrays;
import com.fis.ekyc.nfc.build_in.eidparser.IdCardService;
import java.io.IOException;

public class DERUniversalString extends ASN1Primitive implements ASN1String {
    private static final char[] table = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    private final byte[] string;

    public DERUniversalString(byte[] bArr) {
        this.string = Arrays.clone(bArr);
    }

    public static DERUniversalString getInstance(Object obj) {
        if (obj == null || (obj instanceof DERUniversalString)) {
            return (DERUniversalString) obj;
        }
        if (obj instanceof byte[]) {
            try {
                return (DERUniversalString) ASN1Primitive.fromByteArray((byte[]) obj);
            } catch (Exception e) {
                throw new IllegalArgumentException("encoding error getInstance: " + e.toString());
            }
        } else {
            throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
        }
    }

    public boolean asn1Equals(ASN1Primitive aSN1Primitive) {
        if (!(aSN1Primitive instanceof DERUniversalString)) {
            return false;
        }
        return Arrays.areEqual(this.string, ((DERUniversalString) aSN1Primitive).string);
    }

    public void encode(ASN1OutputStream aSN1OutputStream, boolean z) throws IOException {
        aSN1OutputStream.writeEncoded(z, 28, this.string);
    }

    public int encodedLength() {
        return StreamUtil.calculateBodyLength(this.string.length) + 1 + this.string.length;
    }

    public byte[] getOctets() {
        return Arrays.clone(this.string);
    }

    public String getString() {
        StringBuffer stringBuffer = new StringBuffer("#");
        try {
            byte[] encoded = getEncoded();
            for (int i = 0; i != encoded.length; i++) {
                char[] cArr = table;
                stringBuffer.append(cArr[(encoded[i] >>> 4) & 15]);
                stringBuffer.append(cArr[encoded[i] & IdCardService.SFI_DG15]);
            }
            return stringBuffer.toString();
        } catch (IOException unused) {
            throw new ASN1ParsingException("internal error encoding UniversalString");
        }
    }

    public int hashCode() {
        return Arrays.hashCode(this.string);
    }

    public boolean isConstructed() {
        return false;
    }

    public String toString() {
        return getString();
    }

    public static DERUniversalString getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        ASN1Primitive object = aSN1TaggedObject.getObject();
        if (z || (object instanceof DERUniversalString)) {
            return getInstance(object);
        }
        return new DERUniversalString(ASN1OctetString.getInstance(object).getOctets());
    }
}
