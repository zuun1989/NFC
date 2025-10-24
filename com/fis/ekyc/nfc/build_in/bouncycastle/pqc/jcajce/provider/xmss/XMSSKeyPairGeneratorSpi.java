package com.fis.ekyc.nfc.build_in.bouncycastle.pqc.jcajce.provider.xmss;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.AsymmetricCipherKeyPair;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.CryptoServicesRegistrar;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.Digest;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.digests.SHA256Digest;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.digests.SHA512Digest;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.digests.SHAKEDigest;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.xmss.XMSSKeyGenerationParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.xmss.XMSSKeyPairGenerator;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.xmss.XMSSParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.xmss.XMSSPrivateKeyParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.xmss.XMSSPublicKeyParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.jcajce.spec.XMSSParameterSpec;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;

public class XMSSKeyPairGeneratorSpi extends KeyPairGenerator {
    private XMSSKeyPairGenerator engine = new XMSSKeyPairGenerator();
    private boolean initialised = false;
    private XMSSKeyGenerationParameters param;
    private SecureRandom random = CryptoServicesRegistrar.getSecureRandom();
    private ASN1ObjectIdentifier treeDigest;

    public XMSSKeyPairGeneratorSpi() {
        super("XMSS");
    }

    public KeyPair generateKeyPair() {
        if (!this.initialised) {
            XMSSKeyGenerationParameters xMSSKeyGenerationParameters = new XMSSKeyGenerationParameters(new XMSSParameters(10, (Digest) new SHA512Digest()), this.random);
            this.param = xMSSKeyGenerationParameters;
            this.engine.init(xMSSKeyGenerationParameters);
            this.initialised = true;
        }
        AsymmetricCipherKeyPair generateKeyPair = this.engine.generateKeyPair();
        return new KeyPair(new BCXMSSPublicKey(this.treeDigest, (XMSSPublicKeyParameters) generateKeyPair.getPublic()), new BCXMSSPrivateKey(this.treeDigest, (XMSSPrivateKeyParameters) generateKeyPair.getPrivate()));
    }

    public void initialize(int i, SecureRandom secureRandom) {
        throw new IllegalArgumentException("use AlgorithmParameterSpec");
    }

    public void initialize(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
        if (algorithmParameterSpec instanceof XMSSParameterSpec) {
            XMSSParameterSpec xMSSParameterSpec = (XMSSParameterSpec) algorithmParameterSpec;
            if (xMSSParameterSpec.getTreeDigest().equals("SHA256")) {
                this.treeDigest = NISTObjectIdentifiers.id_sha256;
                this.param = new XMSSKeyGenerationParameters(new XMSSParameters(xMSSParameterSpec.getHeight(), (Digest) new SHA256Digest()), secureRandom);
            } else if (xMSSParameterSpec.getTreeDigest().equals("SHA512")) {
                this.treeDigest = NISTObjectIdentifiers.id_sha512;
                this.param = new XMSSKeyGenerationParameters(new XMSSParameters(xMSSParameterSpec.getHeight(), (Digest) new SHA512Digest()), secureRandom);
            } else if (xMSSParameterSpec.getTreeDigest().equals("SHAKE128")) {
                this.treeDigest = NISTObjectIdentifiers.id_shake128;
                this.param = new XMSSKeyGenerationParameters(new XMSSParameters(xMSSParameterSpec.getHeight(), (Digest) new SHAKEDigest(128)), secureRandom);
            } else if (xMSSParameterSpec.getTreeDigest().equals("SHAKE256")) {
                this.treeDigest = NISTObjectIdentifiers.id_shake256;
                this.param = new XMSSKeyGenerationParameters(new XMSSParameters(xMSSParameterSpec.getHeight(), (Digest) new SHAKEDigest(256)), secureRandom);
            }
            this.engine.init(this.param);
            this.initialised = true;
            return;
        }
        throw new InvalidAlgorithmParameterException("parameter object not a XMSSParameterSpec");
    }
}
