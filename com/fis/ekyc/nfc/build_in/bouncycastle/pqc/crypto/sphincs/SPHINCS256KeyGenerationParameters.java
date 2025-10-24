package com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.sphincs;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.Digest;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.KeyGenerationParameters;
import java.security.SecureRandom;

public class SPHINCS256KeyGenerationParameters extends KeyGenerationParameters {
    private final Digest treeDigest;

    public SPHINCS256KeyGenerationParameters(SecureRandom secureRandom, Digest digest) {
        super(secureRandom, 8448);
        this.treeDigest = digest;
    }

    public Digest getTreeDigest() {
        return this.treeDigest;
    }
}
