package com.fis.ekyc.nfc.build_in.bouncycastle.pqc.jcajce.provider.sphincs;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.AsymmetricCipherKeyPair;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.CryptoServicesRegistrar;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.digests.SHA3Digest;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.digests.SHA512tDigest;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.sphincs.SPHINCS256KeyGenerationParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.sphincs.SPHINCS256KeyPairGenerator;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.sphincs.SPHINCSPrivateKeyParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.sphincs.SPHINCSPublicKeyParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.jcajce.spec.SPHINCS256KeyGenParameterSpec;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;

public class Sphincs256KeyPairGeneratorSpi extends KeyPairGenerator {
    SPHINCS256KeyPairGenerator engine = new SPHINCS256KeyPairGenerator();
    boolean initialised = false;
    SPHINCS256KeyGenerationParameters param;
    SecureRandom random = CryptoServicesRegistrar.getSecureRandom();
    ASN1ObjectIdentifier treeDigest = NISTObjectIdentifiers.id_sha512_256;

    public Sphincs256KeyPairGeneratorSpi() {
        super("SPHINCS256");
    }

    public KeyPair generateKeyPair() {
        if (!this.initialised) {
            SPHINCS256KeyGenerationParameters sPHINCS256KeyGenerationParameters = new SPHINCS256KeyGenerationParameters(this.random, new SHA512tDigest(256));
            this.param = sPHINCS256KeyGenerationParameters;
            this.engine.init(sPHINCS256KeyGenerationParameters);
            this.initialised = true;
        }
        AsymmetricCipherKeyPair generateKeyPair = this.engine.generateKeyPair();
        return new KeyPair(new BCSphincs256PublicKey(this.treeDigest, (SPHINCSPublicKeyParameters) generateKeyPair.getPublic()), new BCSphincs256PrivateKey(this.treeDigest, (SPHINCSPrivateKeyParameters) generateKeyPair.getPrivate()));
    }

    public void initialize(int i, SecureRandom secureRandom) {
        throw new IllegalArgumentException("use AlgorithmParameterSpec");
    }

    public void initialize(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
        if (algorithmParameterSpec instanceof SPHINCS256KeyGenParameterSpec) {
            SPHINCS256KeyGenParameterSpec sPHINCS256KeyGenParameterSpec = (SPHINCS256KeyGenParameterSpec) algorithmParameterSpec;
            if (sPHINCS256KeyGenParameterSpec.getTreeDigest().equals(SPHINCS256KeyGenParameterSpec.SHA512_256)) {
                this.treeDigest = NISTObjectIdentifiers.id_sha512_256;
                this.param = new SPHINCS256KeyGenerationParameters(secureRandom, new SHA512tDigest(256));
            } else if (sPHINCS256KeyGenParameterSpec.getTreeDigest().equals("SHA3-256")) {
                this.treeDigest = NISTObjectIdentifiers.id_sha3_256;
                this.param = new SPHINCS256KeyGenerationParameters(secureRandom, new SHA3Digest(256));
            }
            this.engine.init(this.param);
            this.initialised = true;
            return;
        }
        throw new InvalidAlgorithmParameterException("parameter object not a SPHINCS256KeyGenParameterSpec");
    }
}
