package com.fis.ekyc.nfc.build_in.bouncycastle.pqc.jcajce.provider.saber;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.CryptoServicesRegistrar;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.InvalidCipherTextException;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.SecretWithEncapsulation;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.Wrapper;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.KeyParameter;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.spec.KEMParameterSpec;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.saber.SABERKEMExtractor;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.saber.SABERKEMGenerator;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.jcajce.provider.util.WrapUtil;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.Arrays;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.Exceptions;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.InvalidParameterException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.BadPaddingException;
import javax.crypto.CipherSpi;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.ShortBufferException;
import javax.crypto.spec.SecretKeySpec;
import javax.security.auth.DestroyFailedException;

class SABERCipherSpi extends CipherSpi {
    private final String algorithmName;
    private AlgorithmParameters engineParams;
    private SABERKEMGenerator kemGen;
    private KEMParameterSpec kemParameterSpec;
    private SecureRandom random;
    private BCSABERPrivateKey unwrapKey;
    private BCSABERPublicKey wrapKey;

    public static class Base extends SABERCipherSpi {
        public Base() throws NoSuchAlgorithmException {
            super("SABER");
        }
    }

    public SABERCipherSpi(String str) throws NoSuchAlgorithmException {
        this.algorithmName = str;
    }

    public byte[] engineDoFinal(byte[] bArr, int i, int i2) throws IllegalBlockSizeException, BadPaddingException {
        throw new IllegalStateException("Not supported in a wrapping mode");
    }

    public int engineGetBlockSize() {
        return 0;
    }

    public byte[] engineGetIV() {
        return null;
    }

    public int engineGetKeySize(Key key) {
        return 2048;
    }

    public int engineGetOutputSize(int i) {
        return -1;
    }

    public AlgorithmParameters engineGetParameters() {
        if (this.engineParams == null) {
            try {
                AlgorithmParameters instance = AlgorithmParameters.getInstance(this.algorithmName, "BCPQC");
                this.engineParams = instance;
                instance.init(this.kemParameterSpec);
            } catch (Exception e) {
                throw Exceptions.illegalStateException(e.toString(), e);
            }
        }
        return this.engineParams;
    }

    public void engineInit(int i, Key key, SecureRandom secureRandom) throws InvalidKeyException {
        try {
            engineInit(i, key, (AlgorithmParameterSpec) null, secureRandom);
        } catch (InvalidAlgorithmParameterException e) {
            throw Exceptions.illegalArgumentException(e.getMessage(), e);
        }
    }

    public void engineSetMode(String str) throws NoSuchAlgorithmException {
        throw new NoSuchAlgorithmException("Cannot support mode " + str);
    }

    public void engineSetPadding(String str) throws NoSuchPaddingException {
        throw new NoSuchPaddingException("Padding " + str + " unknown");
    }

    public Key engineUnwrap(byte[] bArr, String str, int i) throws InvalidKeyException, NoSuchAlgorithmException {
        if (i == 3) {
            try {
                SABERKEMExtractor sABERKEMExtractor = new SABERKEMExtractor(this.unwrapKey.getKeyParams());
                byte[] extractSecret = sABERKEMExtractor.extractSecret(Arrays.copyOfRange(bArr, 0, sABERKEMExtractor.getInputSize()));
                Wrapper wrapper = WrapUtil.getWrapper(this.kemParameterSpec.getKeyAlgorithmName());
                KeyParameter keyParameter = new KeyParameter(extractSecret);
                Arrays.clear(extractSecret);
                wrapper.init(false, keyParameter);
                byte[] copyOfRange = Arrays.copyOfRange(bArr, sABERKEMExtractor.getInputSize(), bArr.length);
                SecretKeySpec secretKeySpec = new SecretKeySpec(wrapper.unwrap(copyOfRange, 0, copyOfRange.length), str);
                Arrays.clear(keyParameter.getKey());
                return secretKeySpec;
            } catch (IllegalArgumentException e) {
                throw new NoSuchAlgorithmException("unable to extract KTS secret: " + e.getMessage());
            } catch (InvalidCipherTextException e2) {
                throw new InvalidKeyException("unable to extract KTS secret: " + e2.getMessage());
            }
        } else {
            throw new InvalidKeyException("only SECRET_KEY supported");
        }
    }

    public byte[] engineUpdate(byte[] bArr, int i, int i2) {
        throw new IllegalStateException("Not supported in a wrapping mode");
    }

    public byte[] engineWrap(Key key) throws IllegalBlockSizeException, InvalidKeyException {
        if (key.getEncoded() != null) {
            try {
                SecretWithEncapsulation generateEncapsulated = this.kemGen.generateEncapsulated(this.wrapKey.getKeyParams());
                Wrapper wrapper = WrapUtil.getWrapper(this.kemParameterSpec.getKeyAlgorithmName());
                wrapper.init(true, new KeyParameter(generateEncapsulated.getSecret()));
                byte[] encapsulation = generateEncapsulated.getEncapsulation();
                generateEncapsulated.destroy();
                byte[] encoded = key.getEncoded();
                byte[] concatenate = Arrays.concatenate(encapsulation, wrapper.wrap(encoded, 0, encoded.length));
                Arrays.clear(encoded);
                return concatenate;
            } catch (IllegalArgumentException e) {
                throw new IllegalBlockSizeException("unable to generate KTS secret: " + e.getMessage());
            } catch (DestroyFailedException e2) {
                throw new IllegalBlockSizeException("unable to destroy interim values: " + e2.getMessage());
            }
        } else {
            throw new InvalidKeyException("Cannot wrap key, null encoding.");
        }
    }

    public int engineDoFinal(byte[] bArr, int i, int i2, byte[] bArr2, int i3) throws ShortBufferException, IllegalBlockSizeException, BadPaddingException {
        throw new IllegalStateException("Not supported in a wrapping mode");
    }

    public int engineUpdate(byte[] bArr, int i, int i2, byte[] bArr2, int i3) throws ShortBufferException {
        throw new IllegalStateException("Not supported in a wrapping mode");
    }

    public void engineInit(int i, Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        if (secureRandom == null) {
            this.random = CryptoServicesRegistrar.getSecureRandom();
        }
        if (algorithmParameterSpec == null) {
            this.kemParameterSpec = new KEMParameterSpec("AES-KWP");
        } else if (algorithmParameterSpec instanceof KEMParameterSpec) {
            this.kemParameterSpec = (KEMParameterSpec) algorithmParameterSpec;
        } else {
            throw new InvalidAlgorithmParameterException(this.algorithmName + " can only accept KTSParameterSpec");
        }
        if (i == 3) {
            if (key instanceof BCSABERPublicKey) {
                this.wrapKey = (BCSABERPublicKey) key;
                this.kemGen = new SABERKEMGenerator(secureRandom);
                return;
            }
            throw new InvalidKeyException("Only an RSA public key can be used for wrapping");
        } else if (i != 4) {
            throw new InvalidParameterException("Cipher only valid for wrapping/unwrapping");
        } else if (key instanceof BCSABERPrivateKey) {
            this.unwrapKey = (BCSABERPrivateKey) key;
        } else {
            throw new InvalidKeyException("Only an RSA private key can be used for unwrapping");
        }
    }

    public void engineInit(int i, Key key, AlgorithmParameters algorithmParameters, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        AlgorithmParameterSpec algorithmParameterSpec;
        if (algorithmParameters != null) {
            try {
                algorithmParameterSpec = algorithmParameters.getParameterSpec(KEMParameterSpec.class);
            } catch (Exception unused) {
                throw new InvalidAlgorithmParameterException("can't handle parameter " + algorithmParameters.toString());
            }
        } else {
            algorithmParameterSpec = null;
        }
        engineInit(i, key, algorithmParameterSpec, this.random);
    }
}
