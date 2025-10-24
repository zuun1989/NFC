package com.fis.ekyc.nfc.build_in.bouncycastle.asn1;

import com.fis.ekyc.nfc.build_in.bouncycastle.util.Arrays;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.encoders.Hex;
import com.fis.ekyc.nfc.build_in.scuba.smartcards.ISO7816;
import com.fis.ekyc.nfc.build_in.scuba.smartcards.ISOFileInfo;
import java.io.IOException;

public abstract class ASN1ApplicationSpecific extends ASN1Primitive {
    protected final boolean isConstructed;
    protected final byte[] octets;
    protected final int tag;

    public ASN1ApplicationSpecific(boolean z, int i, byte[] bArr) {
        this.isConstructed = z;
        this.tag = i;
        this.octets = Arrays.clone(bArr);
    }

    public static ASN1ApplicationSpecific getInstance(Object obj) {
        if (obj == null || (obj instanceof ASN1ApplicationSpecific)) {
            return (ASN1ApplicationSpecific) obj;
        }
        if (obj instanceof byte[]) {
            try {
                return getInstance(ASN1Primitive.fromByteArray((byte[]) obj));
            } catch (IOException e) {
                throw new IllegalArgumentException("Failed to construct object from byte[]: " + e.getMessage());
            }
        } else {
            throw new IllegalArgumentException("unknown object in getInstance: " + obj.getClass().getName());
        }
    }

    public static int getLengthOfHeader(byte[] bArr) {
        byte b = bArr[1];
        byte b2 = b & 255;
        if (b2 == 128 || b2 <= Byte.MAX_VALUE) {
            return 2;
        }
        byte b3 = b & Byte.MAX_VALUE;
        if (b3 <= 4) {
            return b3 + 2;
        }
        throw new IllegalStateException("DER length more than 4 bytes: " + b3);
    }

    private byte[] replaceTagNumber(int i, byte[] bArr) throws IOException {
        int i2;
        if ((bArr[0] & 31) == 31) {
            byte b = bArr[1];
            byte b2 = b & 255;
            if ((b & Byte.MAX_VALUE) != 0) {
                i2 = 2;
                while ((b2 & ISOFileInfo.DATA_BYTES1) != 0) {
                    b2 = bArr[i2] & 255;
                    i2++;
                }
            } else {
                throw new IOException("corrupted stream - invalid high tag number found");
            }
        } else {
            i2 = 1;
        }
        int length = bArr.length - i2;
        byte[] bArr2 = new byte[(length + 1)];
        System.arraycopy(bArr, i2, bArr2, 1, length);
        bArr2[0] = (byte) i;
        return bArr2;
    }

    public boolean asn1Equals(ASN1Primitive aSN1Primitive) {
        if (!(aSN1Primitive instanceof ASN1ApplicationSpecific)) {
            return false;
        }
        ASN1ApplicationSpecific aSN1ApplicationSpecific = (ASN1ApplicationSpecific) aSN1Primitive;
        if (this.isConstructed == aSN1ApplicationSpecific.isConstructed && this.tag == aSN1ApplicationSpecific.tag && Arrays.areEqual(this.octets, aSN1ApplicationSpecific.octets)) {
            return true;
        }
        return false;
    }

    public void encode(ASN1OutputStream aSN1OutputStream, boolean z) throws IOException {
        int i;
        if (this.isConstructed) {
            i = 96;
        } else {
            i = 64;
        }
        aSN1OutputStream.writeEncoded(z, i, this.tag, this.octets);
    }

    public int encodedLength() throws IOException {
        return StreamUtil.calculateTagLength(this.tag) + StreamUtil.calculateBodyLength(this.octets.length) + this.octets.length;
    }

    public int getApplicationTag() {
        return this.tag;
    }

    public byte[] getContents() {
        return Arrays.clone(this.octets);
    }

    public ASN1Primitive getObject() throws IOException {
        return ASN1Primitive.fromByteArray(getContents());
    }

    public int hashCode() {
        return (this.isConstructed ^ this.tag) ^ Arrays.hashCode(this.octets) ? 1 : 0;
    }

    public boolean isConstructed() {
        return this.isConstructed;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[");
        if (isConstructed()) {
            stringBuffer.append("CONSTRUCTED ");
        }
        stringBuffer.append("APPLICATION ");
        stringBuffer.append(Integer.toString(getApplicationTag()));
        stringBuffer.append("]");
        if (this.octets != null) {
            stringBuffer.append(" #");
            stringBuffer.append(Hex.toHexString(this.octets));
        } else {
            stringBuffer.append(" #null");
        }
        stringBuffer.append(" ");
        return stringBuffer.toString();
    }

    public ASN1Primitive getObject(int i) throws IOException {
        if (i < 31) {
            byte[] encoded = getEncoded();
            byte[] replaceTagNumber = replaceTagNumber(i, encoded);
            if ((encoded[0] & ISO7816.INS_VERIFY) != 0) {
                replaceTagNumber[0] = (byte) (replaceTagNumber[0] | ISO7816.INS_VERIFY);
            }
            return ASN1Primitive.fromByteArray(replaceTagNumber);
        }
        throw new IOException("unsupported tag number");
    }
}
