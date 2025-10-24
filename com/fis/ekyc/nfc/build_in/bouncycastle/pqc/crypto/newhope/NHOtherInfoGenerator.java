package com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.newhope;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.AlgorithmIdentifier;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.AsymmetricCipherKeyPair;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.KeyGenerationParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.util.DEROtherInfo;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.asn1.PQCObjectIdentifiers;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.ExchangePair;
import java.io.IOException;
import java.security.SecureRandom;

public class NHOtherInfoGenerator {
    protected final DEROtherInfo.Builder otherInfoBuilder;
    protected final SecureRandom random;
    protected boolean used = false;

    public static class PartyU extends NHOtherInfoGenerator {
        private AsymmetricCipherKeyPair aKp;
        private NHAgreement agreement = new NHAgreement();

        public PartyU(AlgorithmIdentifier algorithmIdentifier, byte[] bArr, byte[] bArr2, SecureRandom secureRandom) {
            super(algorithmIdentifier, bArr, bArr2, secureRandom);
            NHKeyPairGenerator nHKeyPairGenerator = new NHKeyPairGenerator();
            nHKeyPairGenerator.init(new KeyGenerationParameters(secureRandom, 2048));
            AsymmetricCipherKeyPair generateKeyPair = nHKeyPairGenerator.generateKeyPair();
            this.aKp = generateKeyPair;
            this.agreement.init(generateKeyPair.getPrivate());
        }

        public DEROtherInfo generate(byte[] bArr) {
            if (!this.used) {
                this.used = true;
                this.otherInfoBuilder.withSuppPrivInfo(this.agreement.calculateAgreement(NHOtherInfoGenerator.getPublicKey(bArr)));
                return this.otherInfoBuilder.build();
            }
            throw new IllegalStateException("builder already used");
        }

        public byte[] getSuppPrivInfoPartA() {
            return NHOtherInfoGenerator.getEncoded((NHPublicKeyParameters) this.aKp.getPublic());
        }

        public NHOtherInfoGenerator withSuppPubInfo(byte[] bArr) {
            this.otherInfoBuilder.withSuppPubInfo(bArr);
            return this;
        }
    }

    public static class PartyV extends NHOtherInfoGenerator {
        public PartyV(AlgorithmIdentifier algorithmIdentifier, byte[] bArr, byte[] bArr2, SecureRandom secureRandom) {
            super(algorithmIdentifier, bArr, bArr2, secureRandom);
        }

        public DEROtherInfo generate() {
            if (!this.used) {
                this.used = true;
                return this.otherInfoBuilder.build();
            }
            throw new IllegalStateException("builder already used");
        }

        public byte[] getSuppPrivInfoPartB(byte[] bArr) {
            ExchangePair generateExchange = new NHExchangePairGenerator(this.random).generateExchange(NHOtherInfoGenerator.getPublicKey(bArr));
            this.otherInfoBuilder.withSuppPrivInfo(generateExchange.getSharedValue());
            return NHOtherInfoGenerator.getEncoded((NHPublicKeyParameters) generateExchange.getPublicKey());
        }

        public NHOtherInfoGenerator withSuppPubInfo(byte[] bArr) {
            this.otherInfoBuilder.withSuppPubInfo(bArr);
            return this;
        }
    }

    public NHOtherInfoGenerator(AlgorithmIdentifier algorithmIdentifier, byte[] bArr, byte[] bArr2, SecureRandom secureRandom) {
        this.otherInfoBuilder = new DEROtherInfo.Builder(algorithmIdentifier, bArr, bArr2);
        this.random = secureRandom;
    }

    /* access modifiers changed from: private */
    public static byte[] getEncoded(NHPublicKeyParameters nHPublicKeyParameters) {
        try {
            return new SubjectPublicKeyInfo(new AlgorithmIdentifier(PQCObjectIdentifiers.newHope), nHPublicKeyParameters.getPubData()).getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    /* access modifiers changed from: private */
    public static NHPublicKeyParameters getPublicKey(byte[] bArr) {
        return new NHPublicKeyParameters(SubjectPublicKeyInfo.getInstance(bArr).getPublicKeyData().getOctets());
    }
}
