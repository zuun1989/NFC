package com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.xmss;

import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.xmss.XMSSAddress;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.Pack;

final class HashTreeAddress extends XMSSAddress {
    private static final int PADDING = 0;
    private static final int TYPE = 2;
    private final int padding;
    private final int treeHeight;
    private final int treeIndex;

    public static class Builder extends XMSSAddress.Builder<Builder> {
        /* access modifiers changed from: private */
        public int treeHeight = 0;
        /* access modifiers changed from: private */
        public int treeIndex = 0;

        public Builder() {
            super(2);
        }

        public XMSSAddress build() {
            return new HashTreeAddress(this);
        }

        public Builder getThis() {
            return this;
        }

        public Builder withTreeHeight(int i) {
            this.treeHeight = i;
            return this;
        }

        public Builder withTreeIndex(int i) {
            this.treeIndex = i;
            return this;
        }
    }

    public int getPadding() {
        return this.padding;
    }

    public int getTreeHeight() {
        return this.treeHeight;
    }

    public int getTreeIndex() {
        return this.treeIndex;
    }

    public byte[] toByteArray() {
        byte[] byteArray = super.toByteArray();
        Pack.intToBigEndian(this.padding, byteArray, 16);
        Pack.intToBigEndian(this.treeHeight, byteArray, 20);
        Pack.intToBigEndian(this.treeIndex, byteArray, 24);
        return byteArray;
    }

    private HashTreeAddress(Builder builder) {
        super(builder);
        this.padding = 0;
        this.treeHeight = builder.treeHeight;
        this.treeIndex = builder.treeIndex;
    }
}
