package com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.xmss;

final class WOTSPlusPrivateKeyParameters {
    private final byte[][] privateKey;

    public WOTSPlusPrivateKeyParameters(WOTSPlusParameters wOTSPlusParameters, byte[][] bArr) {
        if (wOTSPlusParameters == null) {
            throw new NullPointerException("params == null");
        } else if (bArr == null) {
            throw new NullPointerException("privateKey == null");
        } else if (XMSSUtil.hasNullPointer(bArr)) {
            throw new NullPointerException("privateKey byte array == null");
        } else if (bArr.length == wOTSPlusParameters.getLen()) {
            int i = 0;
            while (i < bArr.length) {
                if (bArr[i].length == wOTSPlusParameters.getTreeDigestSize()) {
                    i++;
                } else {
                    throw new IllegalArgumentException("wrong privateKey format");
                }
            }
            this.privateKey = XMSSUtil.cloneArray(bArr);
        } else {
            throw new IllegalArgumentException("wrong privateKey format");
        }
    }

    public byte[][] toByteArray() {
        return XMSSUtil.cloneArray(this.privateKey);
    }
}
