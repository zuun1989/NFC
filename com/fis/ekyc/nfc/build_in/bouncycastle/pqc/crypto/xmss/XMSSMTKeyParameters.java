package com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.xmss;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.AsymmetricKeyParameter;

public class XMSSMTKeyParameters extends AsymmetricKeyParameter {
    private final String treeDigest;

    public XMSSMTKeyParameters(boolean z, String str) {
        super(z);
        this.treeDigest = str;
    }

    public String getTreeDigest() {
        return this.treeDigest;
    }
}
