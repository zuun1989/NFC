package com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.xmss;

import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.xmss.XMSSAddress;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.Pack;

final class OTSHashAddress extends XMSSAddress {
    private static final int TYPE = 0;
    private final int chainAddress;
    private final int hashAddress;
    private final int otsAddress;

    public static class Builder extends XMSSAddress.Builder<Builder> {
        /* access modifiers changed from: private */
        public int chainAddress = 0;
        /* access modifiers changed from: private */
        public int hashAddress = 0;
        /* access modifiers changed from: private */
        public int otsAddress = 0;

        public Builder() {
            super(0);
        }

        public XMSSAddress build() {
            return new OTSHashAddress(this);
        }

        public Builder getThis() {
            return this;
        }

        public Builder withChainAddress(int i) {
            this.chainAddress = i;
            return this;
        }

        public Builder withHashAddress(int i) {
            this.hashAddress = i;
            return this;
        }

        public Builder withOTSAddress(int i) {
            this.otsAddress = i;
            return this;
        }
    }

    public int getChainAddress() {
        return this.chainAddress;
    }

    public int getHashAddress() {
        return this.hashAddress;
    }

    public int getOTSAddress() {
        return this.otsAddress;
    }

    public byte[] toByteArray() {
        byte[] byteArray = super.toByteArray();
        Pack.intToBigEndian(this.otsAddress, byteArray, 16);
        Pack.intToBigEndian(this.chainAddress, byteArray, 20);
        Pack.intToBigEndian(this.hashAddress, byteArray, 24);
        return byteArray;
    }

    private OTSHashAddress(Builder builder) {
        super(builder);
        this.otsAddress = builder.otsAddress;
        this.chainAddress = builder.chainAddress;
        this.hashAddress = builder.hashAddress;
    }
}
