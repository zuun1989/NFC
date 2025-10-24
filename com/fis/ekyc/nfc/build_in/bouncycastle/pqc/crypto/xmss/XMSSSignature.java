package com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.xmss;

import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.xmss.XMSSReducedSignature;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.Encodable;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.Pack;
import java.io.IOException;

public final class XMSSSignature extends XMSSReducedSignature implements XMSSStoreableObjectInterface, Encodable {
    private final int index;
    private final byte[] random;

    public static class Builder extends XMSSReducedSignature.Builder {
        /* access modifiers changed from: private */
        public int index = 0;
        private final XMSSParameters params;
        /* access modifiers changed from: private */
        public byte[] random = null;

        public Builder(XMSSParameters xMSSParameters) {
            super(xMSSParameters);
            this.params = xMSSParameters;
        }

        public Builder withIndex(int i) {
            this.index = i;
            return this;
        }

        public Builder withRandom(byte[] bArr) {
            this.random = XMSSUtil.cloneArray(bArr);
            return this;
        }

        public Builder withSignature(byte[] bArr) {
            if (bArr != null) {
                int treeDigestSize = this.params.getTreeDigestSize();
                int len = this.params.getWOTSPlus().getParams().getLen();
                this.index = Pack.bigEndianToInt(bArr, 0);
                this.random = XMSSUtil.extractBytesAtOffset(bArr, 4, treeDigestSize);
                withReducedSignature(XMSSUtil.extractBytesAtOffset(bArr, 4 + treeDigestSize, (len * treeDigestSize) + (this.params.getHeight() * treeDigestSize)));
                return this;
            }
            throw new NullPointerException("signature == null");
        }

        public XMSSSignature build() {
            return new XMSSSignature(this);
        }
    }

    public byte[] getEncoded() throws IOException {
        return toByteArray();
    }

    public int getIndex() {
        return this.index;
    }

    public byte[] getRandom() {
        return XMSSUtil.cloneArray(this.random);
    }

    public byte[] toByteArray() {
        int treeDigestSize = getParams().getTreeDigestSize();
        byte[] bArr = new byte[(treeDigestSize + 4 + (getParams().getWOTSPlus().getParams().getLen() * treeDigestSize) + (getParams().getHeight() * treeDigestSize))];
        Pack.intToBigEndian(this.index, bArr, 0);
        XMSSUtil.copyBytesAtOffset(bArr, this.random, 4);
        int i = 4 + treeDigestSize;
        byte[][] byteArray = getWOTSPlusSignature().toByteArray();
        for (byte[] copyBytesAtOffset : byteArray) {
            XMSSUtil.copyBytesAtOffset(bArr, copyBytesAtOffset, i);
            i += treeDigestSize;
        }
        for (int i2 = 0; i2 < getAuthPath().size(); i2++) {
            XMSSUtil.copyBytesAtOffset(bArr, getAuthPath().get(i2).getValue(), i);
            i += treeDigestSize;
        }
        return bArr;
    }

    private XMSSSignature(Builder builder) {
        super(builder);
        this.index = builder.index;
        int treeDigestSize = getParams().getTreeDigestSize();
        byte[] access$100 = builder.random;
        if (access$100 == null) {
            this.random = new byte[treeDigestSize];
        } else if (access$100.length == treeDigestSize) {
            this.random = access$100;
        } else {
            throw new IllegalArgumentException("size of random needs to be equal to size of digest");
        }
    }
}
