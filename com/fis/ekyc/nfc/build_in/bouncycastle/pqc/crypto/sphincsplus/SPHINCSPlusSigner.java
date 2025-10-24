package com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.sphincsplus;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.CipherParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ParametersWithRandom;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.MessageSigner;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.Arrays;
import java.security.SecureRandom;

public class SPHINCSPlusSigner implements MessageSigner {
    private SPHINCSPlusPrivateKeyParameters privKey;
    private SPHINCSPlusPublicKeyParameters pubKey;
    private SecureRandom random;

    public byte[] generateSignature(byte[] bArr) {
        SPHINCSPlusEngine engine = this.privKey.getParameters().getEngine();
        int i = engine.N;
        byte[] bArr2 = new byte[i];
        SecureRandom secureRandom = this.random;
        int i2 = 0;
        if (secureRandom != null) {
            secureRandom.nextBytes(bArr2);
        } else {
            System.arraycopy(this.privKey.pk.seed, 0, bArr2, 0, i);
        }
        Fors fors = new Fors(engine);
        byte[] PRF_msg = engine.PRF_msg(this.privKey.sk.prf, bArr2, bArr);
        PK pk = this.privKey.pk;
        IndexedDigest H_msg = engine.H_msg(PRF_msg, pk.seed, pk.root, bArr);
        byte[] bArr3 = H_msg.digest;
        long j = H_msg.idx_tree;
        int i3 = H_msg.idx_leaf;
        ADRS adrs = new ADRS();
        adrs.setType(3);
        adrs.setTreeAddress(j);
        adrs.setKeyPairAddress(i3);
        SPHINCSPlusPrivateKeyParameters sPHINCSPlusPrivateKeyParameters = this.privKey;
        SIG_FORS[] sign = fors.sign(bArr3, sPHINCSPlusPrivateKeyParameters.sk.seed, sPHINCSPlusPrivateKeyParameters.pk.seed, adrs);
        byte[] pkFromSig = fors.pkFromSig(sign, bArr3, this.privKey.pk.seed, adrs);
        new ADRS().setType(2);
        byte[] sign2 = new HT(engine, this.privKey.getSeed(), this.privKey.getPublicSeed()).sign(pkFromSig, j, i3);
        int length = sign.length;
        byte[][] bArr4 = new byte[(length + 2)][];
        bArr4[0] = PRF_msg;
        while (i2 != sign.length) {
            int i4 = i2 + 1;
            SIG_FORS sig_fors = sign[i2];
            bArr4[i4] = Arrays.concatenate(sig_fors.sk, Arrays.concatenate(sig_fors.authPath));
            i2 = i4;
        }
        bArr4[length + 1] = sign2;
        return Arrays.concatenate(bArr4);
    }

    public void init(boolean z, CipherParameters cipherParameters) {
        if (!z) {
            this.pubKey = (SPHINCSPlusPublicKeyParameters) cipherParameters;
        } else if (cipherParameters instanceof ParametersWithRandom) {
            ParametersWithRandom parametersWithRandom = (ParametersWithRandom) cipherParameters;
            this.privKey = (SPHINCSPlusPrivateKeyParameters) parametersWithRandom.getParameters();
            this.random = parametersWithRandom.getRandom();
        } else {
            this.privKey = (SPHINCSPlusPrivateKeyParameters) cipherParameters;
        }
    }

    public boolean verifySignature(byte[] bArr, byte[] bArr2) {
        SPHINCSPlusEngine engine = this.pubKey.getParameters().getEngine();
        ADRS adrs = new ADRS();
        SIG sig = new SIG(engine.N, engine.K, engine.A, engine.D, engine.H_PRIME, engine.WOTS_LEN, bArr2);
        byte[] r = sig.getR();
        SIG_FORS[] sig_fors = sig.getSIG_FORS();
        SIG_XMSS[] sig_ht = sig.getSIG_HT();
        IndexedDigest H_msg = engine.H_msg(r, this.pubKey.getSeed(), this.pubKey.getRoot(), bArr);
        byte[] bArr3 = H_msg.digest;
        long j = H_msg.idx_tree;
        int i = H_msg.idx_leaf;
        adrs.setLayerAddress(0);
        adrs.setTreeAddress(j);
        adrs.setType(3);
        adrs.setKeyPairAddress(i);
        byte[] pkFromSig = new Fors(engine).pkFromSig(sig_fors, bArr3, this.pubKey.getSeed(), adrs);
        adrs.setType(2);
        return new HT(engine, (byte[]) null, this.pubKey.getSeed()).verify(pkFromSig, sig_ht, this.pubKey.getSeed(), j, i, this.pubKey.getRoot());
    }
}
