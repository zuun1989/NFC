package com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.xmss;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.AsymmetricCipherKeyPair;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.AsymmetricCipherKeyPairGenerator;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.KeyGenerationParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.AsymmetricKeyParameter;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.xmss.OTSHashAddress;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.xmss.XMSSPrivateKeyParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.xmss.XMSSPublicKeyParameters;
import java.security.SecureRandom;

public final class XMSSKeyPairGenerator implements AsymmetricCipherKeyPairGenerator {
    private XMSSParameters params;
    private SecureRandom prng;

    private XMSSPrivateKeyParameters generatePrivateKey(XMSSParameters xMSSParameters, SecureRandom secureRandom) {
        int treeDigestSize = xMSSParameters.getTreeDigestSize();
        byte[] bArr = new byte[treeDigestSize];
        secureRandom.nextBytes(bArr);
        byte[] bArr2 = new byte[treeDigestSize];
        secureRandom.nextBytes(bArr2);
        byte[] bArr3 = new byte[treeDigestSize];
        secureRandom.nextBytes(bArr3);
        return new XMSSPrivateKeyParameters.Builder(xMSSParameters).withSecretKeySeed(bArr).withSecretKeyPRF(bArr2).withPublicSeed(bArr3).withBDSState(new BDS(xMSSParameters, bArr3, bArr, (OTSHashAddress) new OTSHashAddress.Builder().build())).build();
    }

    public AsymmetricCipherKeyPair generateKeyPair() {
        XMSSPrivateKeyParameters generatePrivateKey = generatePrivateKey(this.params, this.prng);
        XMSSNode root = generatePrivateKey.getBDSState().getRoot();
        XMSSPrivateKeyParameters build = new XMSSPrivateKeyParameters.Builder(this.params).withSecretKeySeed(generatePrivateKey.getSecretKeySeed()).withSecretKeyPRF(generatePrivateKey.getSecretKeyPRF()).withPublicSeed(generatePrivateKey.getPublicSeed()).withRoot(root.getValue()).withBDSState(generatePrivateKey.getBDSState()).build();
        return new AsymmetricCipherKeyPair((AsymmetricKeyParameter) new XMSSPublicKeyParameters.Builder(this.params).withRoot(root.getValue()).withPublicSeed(build.getPublicSeed()).build(), (AsymmetricKeyParameter) build);
    }

    public void init(KeyGenerationParameters keyGenerationParameters) {
        XMSSKeyGenerationParameters xMSSKeyGenerationParameters = (XMSSKeyGenerationParameters) keyGenerationParameters;
        this.prng = xMSSKeyGenerationParameters.getRandom();
        this.params = xMSSKeyGenerationParameters.getParameters();
    }
}
