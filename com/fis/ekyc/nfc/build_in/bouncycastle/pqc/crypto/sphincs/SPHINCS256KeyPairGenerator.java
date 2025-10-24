package com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.sphincs;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.AsymmetricCipherKeyPair;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.AsymmetricCipherKeyPairGenerator;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.Digest;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.KeyGenerationParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.AsymmetricKeyParameter;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.sphincs.Tree;
import java.security.SecureRandom;

public class SPHINCS256KeyPairGenerator implements AsymmetricCipherKeyPairGenerator {
    private SecureRandom random;
    private Digest treeDigest;

    public AsymmetricCipherKeyPair generateKeyPair() {
        Tree.leafaddr leafaddr = new Tree.leafaddr();
        byte[] bArr = new byte[1088];
        this.random.nextBytes(bArr);
        byte[] bArr2 = new byte[1056];
        System.arraycopy(bArr, 32, bArr2, 0, 1024);
        leafaddr.level = 11;
        leafaddr.subtree = 0;
        leafaddr.subleaf = 0;
        Tree.treehash(new HashFunctions(this.treeDigest), bArr2, 1024, 5, bArr, leafaddr, bArr2, 0);
        return new AsymmetricCipherKeyPair((AsymmetricKeyParameter) new SPHINCSPublicKeyParameters(bArr2, this.treeDigest.getAlgorithmName()), (AsymmetricKeyParameter) new SPHINCSPrivateKeyParameters(bArr, this.treeDigest.getAlgorithmName()));
    }

    public void init(KeyGenerationParameters keyGenerationParameters) {
        this.random = keyGenerationParameters.getRandom();
        this.treeDigest = ((SPHINCS256KeyGenerationParameters) keyGenerationParameters).getTreeDigest();
    }
}
