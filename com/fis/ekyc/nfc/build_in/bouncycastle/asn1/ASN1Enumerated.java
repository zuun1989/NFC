package com.fis.ekyc.nfc.build_in.bouncycastle.asn1;

import com.fis.ekyc.nfc.build_in.bouncycastle.util.Arrays;
import com.fis.ekyc.nfc.build_in.scuba.smartcards.ISOFileInfo;
import java.io.IOException;
import java.math.BigInteger;

public class ASN1Enumerated extends ASN1Primitive {
    private static ASN1Enumerated[] cache = new ASN1Enumerated[12];
    private final byte[] bytes;
    private final int start;

    public ASN1Enumerated(int i) {
        if (i >= 0) {
            this.bytes = BigInteger.valueOf((long) i).toByteArray();
            this.start = 0;
            return;
        }
        throw new IllegalArgumentException("enumerated must be non-negative");
    }

    public static ASN1Enumerated fromOctetString(byte[] bArr) {
        if (bArr.length > 1) {
            return new ASN1Enumerated(bArr);
        }
        if (bArr.length != 0) {
            byte b = bArr[0] & 255;
            ASN1Enumerated[] aSN1EnumeratedArr = cache;
            if (b >= aSN1EnumeratedArr.length) {
                return new ASN1Enumerated(bArr);
            }
            ASN1Enumerated aSN1Enumerated = aSN1EnumeratedArr[b];
            if (aSN1Enumerated != null) {
                return aSN1Enumerated;
            }
            ASN1Enumerated aSN1Enumerated2 = new ASN1Enumerated(bArr);
            aSN1EnumeratedArr[b] = aSN1Enumerated2;
            return aSN1Enumerated2;
        }
        throw new IllegalArgumentException("ENUMERATED has zero length");
    }

    public static ASN1Enumerated getInstance(Object obj) {
        if (obj == null || (obj instanceof ASN1Enumerated)) {
            return (ASN1Enumerated) obj;
        }
        if (obj instanceof byte[]) {
            try {
                return (ASN1Enumerated) ASN1Primitive.fromByteArray((byte[]) obj);
            } catch (Exception e) {
                throw new IllegalArgumentException("encoding error in getInstance: " + e.toString());
            }
        } else {
            throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
        }
    }

    public boolean asn1Equals(ASN1Primitive aSN1Primitive) {
        if (!(aSN1Primitive instanceof ASN1Enumerated)) {
            return false;
        }
        return Arrays.areEqual(this.bytes, ((ASN1Enumerated) aSN1Primitive).bytes);
    }

    public void encode(ASN1OutputStream aSN1OutputStream, boolean z) throws IOException {
        aSN1OutputStream.writeEncoded(z, 10, this.bytes);
    }

    public int encodedLength() {
        return StreamUtil.calculateBodyLength(this.bytes.length) + 1 + this.bytes.length;
    }

    public BigInteger getValue() {
        return new BigInteger(this.bytes);
    }

    public boolean hasValue(BigInteger bigInteger) {
        if (bigInteger == null || ASN1Integer.intValue(this.bytes, this.start, -1) != bigInteger.intValue() || !getValue().equals(bigInteger)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Arrays.hashCode(this.bytes);
    }

    public int intValueExact() {
        byte[] bArr = this.bytes;
        int length = bArr.length;
        int i = this.start;
        if (length - i <= 4) {
            return ASN1Integer.intValue(bArr, i, -1);
        }
        throw new ArithmeticException("ASN.1 Enumerated out of int range");
    }

    public boolean isConstructed() {
        return false;
    }

    public ASN1Enumerated(BigInteger bigInteger) {
        if (bigInteger.signum() >= 0) {
            this.bytes = bigInteger.toByteArray();
            this.start = 0;
            return;
        }
        throw new IllegalArgumentException("enumerated must be non-negative");
    }

    public static ASN1Enumerated getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        ASN1Primitive object = aSN1TaggedObject.getObject();
        if (z || (object instanceof ASN1Enumerated)) {
            return getInstance(object);
        }
        return fromOctetString(ASN1OctetString.getInstance(object).getOctets());
    }

    public ASN1Enumerated(byte[] bArr) {
        if (ASN1Integer.isMalformed(bArr)) {
            throw new IllegalArgumentException("malformed enumerated");
        } else if ((bArr[0] & ISOFileInfo.DATA_BYTES1) == 0) {
            this.bytes = Arrays.clone(bArr);
            this.start = ASN1Integer.signBytesToSkip(bArr);
        } else {
            throw new IllegalArgumentException("enumerated must be non-negative");
        }
    }
}
