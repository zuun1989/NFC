package com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.xmss;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.AsymmetricCipherKeyPair;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.AsymmetricCipherKeyPairGenerator;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.KeyGenerationParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.AsymmetricKeyParameter;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.xmss.OTSHashAddress;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.xmss.XMSSMTPrivateKeyParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.xmss.XMSSMTPublicKeyParameters;
import java.security.SecureRandom;

public final class XMSSMTKeyPairGenerator implements AsymmetricCipherKeyPairGenerator {
    private XMSSMTParameters params;
    private SecureRandom prng;
    private XMSSParameters xmssParams;

    private XMSSMTPrivateKeyParameters generatePrivateKey(BDSStateMap bDSStateMap) {
        int treeDigestSize = this.params.getTreeDigestSize();
        byte[] bArr = new byte[treeDigestSize];
        this.prng.nextBytes(bArr);
        byte[] bArr2 = new byte[treeDigestSize];
        this.prng.nextBytes(bArr2);
        byte[] bArr3 = new byte[treeDigestSize];
        this.prng.nextBytes(bArr3);
        return new XMSSMTPrivateKeyParameters.Builder(this.params).withSecretKeySeed(bArr).withSecretKeyPRF(bArr2).withPublicSeed(bArr3).withBDSState(bDSStateMap).build();
    }

    public AsymmetricCipherKeyPair generateKeyPair() {
        XMSSMTPrivateKeyParameters generatePrivateKey = generatePrivateKey(new XMSSMTPrivateKeyParameters.Builder(this.params).build().getBDSState());
        this.xmssParams.getWOTSPlus().importKeys(new byte[this.params.getTreeDigestSize()], generatePrivateKey.getPublicSeed());
        int layers = this.params.getLayers() - 1;
        BDS bds = new BDS(this.xmssParams, generatePrivateKey.getPublicSeed(), generatePrivateKey.getSecretKeySeed(), (OTSHashAddress) ((OTSHashAddress.Builder) new OTSHashAddress.Builder().withLayerAddress(layers)).build());
        XMSSNode root = bds.getRoot();
        generatePrivateKey.getBDSState().put(layers, bds);
        XMSSMTPrivateKeyParameters build = new XMSSMTPrivateKeyParameters.Builder(this.params).withSecretKeySeed(generatePrivateKey.getSecretKeySeed()).withSecretKeyPRF(generatePrivateKey.getSecretKeyPRF()).withPublicSeed(generatePrivateKey.getPublicSeed()).withRoot(root.getValue()).withBDSState(generatePrivateKey.getBDSState()).build();
        return new AsymmetricCipherKeyPair((AsymmetricKeyParameter) new XMSSMTPublicKeyParameters.Builder(this.params).withRoot(root.getValue()).withPublicSeed(build.getPublicSeed()).build(), (AsymmetricKeyParameter) build);
    }

    public void init(KeyGenerationParameters keyGenerationParameters) {
        XMSSMTKeyGenerationParameters xMSSMTKeyGenerationParameters = (XMSSMTKeyGenerationParameters) keyGenerationParameters;
        this.prng = xMSSMTKeyGenerationParameters.getRandom();
        XMSSMTParameters parameters = xMSSMTKeyGenerationParameters.getParameters();
        this.params = parameters;
        this.xmssParams = parameters.getXMSSParameters();
    }
}
