package com.fis.ekyc.nfc.build_in.bouncycastle.crypto.signers;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.AsymmetricBlockCipher;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.CipherParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.CryptoException;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.DataLengthException;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.Digest;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.Signer;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.AsymmetricKeyParameter;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ParametersWithRandom;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.Arrays;

public class GenericSigner implements Signer {
    private final Digest digest;
    private final AsymmetricBlockCipher engine;
    private boolean forSigning;

    public GenericSigner(AsymmetricBlockCipher asymmetricBlockCipher, Digest digest2) {
        this.engine = asymmetricBlockCipher;
        this.digest = digest2;
    }

    public byte[] generateSignature() throws CryptoException, DataLengthException {
        if (this.forSigning) {
            int digestSize = this.digest.getDigestSize();
            byte[] bArr = new byte[digestSize];
            this.digest.doFinal(bArr, 0);
            return this.engine.processBlock(bArr, 0, digestSize);
        }
        throw new IllegalStateException("GenericSigner not initialised for signature generation.");
    }

    public void init(boolean z, CipherParameters cipherParameters) {
        AsymmetricKeyParameter asymmetricKeyParameter;
        this.forSigning = z;
        if (cipherParameters instanceof ParametersWithRandom) {
            asymmetricKeyParameter = (AsymmetricKeyParameter) ((ParametersWithRandom) cipherParameters).getParameters();
        } else {
            asymmetricKeyParameter = (AsymmetricKeyParameter) cipherParameters;
        }
        if (z && !asymmetricKeyParameter.isPrivate()) {
            throw new IllegalArgumentException("signing requires private key");
        } else if (z || !asymmetricKeyParameter.isPrivate()) {
            reset();
            this.engine.init(z, cipherParameters);
        } else {
            throw new IllegalArgumentException("verification requires public key");
        }
    }

    public void reset() {
        this.digest.reset();
    }

    public void update(byte b) {
        this.digest.update(b);
    }

    public boolean verifySignature(byte[] bArr) {
        if (!this.forSigning) {
            int digestSize = this.digest.getDigestSize();
            byte[] bArr2 = new byte[digestSize];
            this.digest.doFinal(bArr2, 0);
            try {
                byte[] processBlock = this.engine.processBlock(bArr, 0, bArr.length);
                if (processBlock.length < digestSize) {
                    byte[] bArr3 = new byte[digestSize];
                    System.arraycopy(processBlock, 0, bArr3, digestSize - processBlock.length, processBlock.length);
                    processBlock = bArr3;
                }
                return Arrays.constantTimeAreEqual(processBlock, bArr2);
            } catch (Exception unused) {
                return false;
            }
        } else {
            throw new IllegalStateException("GenericSigner not initialised for verification");
        }
    }

    public void update(byte[] bArr, int i, int i2) {
        this.digest.update(bArr, i, i2);
    }
}
