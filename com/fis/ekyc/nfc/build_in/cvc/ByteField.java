package com.fis.ekyc.nfc.build_in.cvc;

import com.fis.ekyc.nfc.build_in.cvc.util.StringConverter;
import java.math.BigInteger;

public class ByteField extends AbstractDataField {
    private static final long serialVersionUID = 1;
    private byte[] data;
    private boolean showBitLength;

    public ByteField(CVCTagEnum cVCTagEnum) {
        super(cVCTagEnum);
        this.showBitLength = false;
    }

    public byte[] getData() {
        return this.data;
    }

    public byte[] getEncoded() {
        return this.data;
    }

    public boolean isShowBitLength() {
        return this.showBitLength;
    }

    public void setShowBitLength(boolean z) {
        this.showBitLength = z;
    }

    public String valueAsText() {
        String str;
        int i;
        if (this.showBitLength) {
            if (this.data != null) {
                i = new BigInteger(1, this.data).bitLength();
            } else {
                i = 0;
            }
            str = "[" + i + "]  ";
        } else {
            str = "";
        }
        return str + StringConverter.byteToHex(this.data);
    }

    public ByteField(CVCTagEnum cVCTagEnum, byte[] bArr) {
        this(cVCTagEnum, bArr, false);
    }

    public ByteField(CVCTagEnum cVCTagEnum, byte[] bArr, boolean z) {
        super(cVCTagEnum);
        this.data = bArr;
        this.showBitLength = z;
    }
}
