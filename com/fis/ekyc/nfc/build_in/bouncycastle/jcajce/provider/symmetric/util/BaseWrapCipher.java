package com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.symmetric.util;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.InvalidCipherTextException;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.Wrapper;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.KeyParameter;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ParametersWithIV;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ParametersWithRandom;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ParametersWithSBox;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ParametersWithUKM;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.symmetric.util.PBE;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.spec.GOST28147WrapParameterSpec;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.util.BCJcaJceHelper;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.util.JcaJceHelper;
import com.fis.ekyc.nfc.build_in.bouncycastle.jce.provider.BouncyCastleProvider;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.Arrays;
import java.io.ByteArrayOutputStream;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.InvalidParameterException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.CipherSpi;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.ShortBufferException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEParameterSpec;
import javax.crypto.spec.RC2ParameterSpec;
import javax.crypto.spec.RC5ParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public abstract class BaseWrapCipher extends CipherSpi implements PBE {
    private Class[] availableSpecs;
    protected AlgorithmParameters engineParams;
    private boolean forWrapping;
    private final JcaJceHelper helper;
    private byte[] iv;
    private int ivSize;
    protected int pbeHash;
    protected int pbeIvSize;
    protected int pbeKeySize;
    protected int pbeType;
    protected Wrapper wrapEngine;
    private ErasableOutputStream wrapStream;

    public static final class ErasableOutputStream extends ByteArrayOutputStream {
        public void erase() {
            Arrays.fill(this.buf, (byte) 0);
            reset();
        }

        public byte[] getBuf() {
            return this.buf;
        }
    }

    public static class InvalidKeyOrParametersException extends InvalidKeyException {
        private final Throwable cause;

        public InvalidKeyOrParametersException(String str, Throwable th) {
            super(str);
            this.cause = th;
        }

        public Throwable getCause() {
            return this.cause;
        }
    }

    public BaseWrapCipher() {
        this.availableSpecs = new Class[]{GOST28147WrapParameterSpec.class, PBEParameterSpec.class, RC2ParameterSpec.class, RC5ParameterSpec.class, IvParameterSpec.class};
        this.pbeType = 2;
        this.pbeHash = 1;
        this.engineParams = null;
        this.wrapEngine = null;
        this.wrapStream = null;
        this.helper = new BCJcaJceHelper();
    }

    public final AlgorithmParameters createParametersInstance(String str) throws NoSuchAlgorithmException, NoSuchProviderException {
        return this.helper.createAlgorithmParameters(str);
    }

    public byte[] engineDoFinal(byte[] bArr, int i, int i2) throws IllegalBlockSizeException, BadPaddingException {
        byte[] unwrap;
        ErasableOutputStream erasableOutputStream = this.wrapStream;
        if (erasableOutputStream != null) {
            if (bArr != null) {
                erasableOutputStream.write(bArr, i, i2);
            }
            try {
                if (this.forWrapping) {
                    unwrap = this.wrapEngine.wrap(this.wrapStream.getBuf(), 0, this.wrapStream.size());
                } else {
                    unwrap = this.wrapEngine.unwrap(this.wrapStream.getBuf(), 0, this.wrapStream.size());
                }
                this.wrapStream.erase();
                return unwrap;
            } catch (InvalidCipherTextException e) {
                throw new BadPaddingException(e.getMessage());
            } catch (Exception e2) {
                throw new IllegalBlockSizeException(e2.getMessage());
            } catch (Throwable th) {
                this.wrapStream.erase();
                throw th;
            }
        } else {
            throw new IllegalStateException("not supported in a wrapping mode");
        }
    }

    public int engineGetBlockSize() {
        return 0;
    }

    public byte[] engineGetIV() {
        return Arrays.clone(this.iv);
    }

    public int engineGetKeySize(Key key) {
        return key.getEncoded().length * 8;
    }

    public int engineGetOutputSize(int i) {
        return -1;
    }

    public AlgorithmParameters engineGetParameters() {
        if (this.engineParams == null && this.iv != null) {
            String algorithmName = this.wrapEngine.getAlgorithmName();
            if (algorithmName.indexOf(47) >= 0) {
                algorithmName = algorithmName.substring(0, algorithmName.indexOf(47));
            }
            try {
                AlgorithmParameters createParametersInstance = createParametersInstance(algorithmName);
                this.engineParams = createParametersInstance;
                createParametersInstance.init(new IvParameterSpec(this.iv));
            } catch (Exception e) {
                throw new RuntimeException(e.toString());
            }
        }
        return this.engineParams;
    }

    public void engineInit(int i, Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        ParametersWithIV parametersWithIV;
        int i2;
        if (key instanceof BCPBEKey) {
            BCPBEKey bCPBEKey = (BCPBEKey) key;
            if (algorithmParameterSpec instanceof PBEParameterSpec) {
                parametersWithIV = PBE.Util.makePBEParameters(bCPBEKey, algorithmParameterSpec, this.wrapEngine.getAlgorithmName());
            } else if (bCPBEKey.getParam() != null) {
                parametersWithIV = bCPBEKey.getParam();
            } else {
                throw new InvalidAlgorithmParameterException("PBE requires PBE parameters to be set.");
            }
        } else {
            parametersWithIV = new KeyParameter(key.getEncoded());
        }
        if (algorithmParameterSpec instanceof IvParameterSpec) {
            byte[] iv2 = ((IvParameterSpec) algorithmParameterSpec).getIV();
            this.iv = iv2;
            parametersWithIV = new ParametersWithIV(parametersWithIV, iv2);
        }
        if (algorithmParameterSpec instanceof GOST28147WrapParameterSpec) {
            GOST28147WrapParameterSpec gOST28147WrapParameterSpec = (GOST28147WrapParameterSpec) algorithmParameterSpec;
            byte[] sBox = gOST28147WrapParameterSpec.getSBox();
            if (sBox != null) {
                parametersWithIV = new ParametersWithSBox(parametersWithIV, sBox);
            }
            parametersWithIV = new ParametersWithUKM(parametersWithIV, gOST28147WrapParameterSpec.getUKM());
        }
        if ((parametersWithIV instanceof KeyParameter) && (i2 = this.ivSize) != 0 && (i == 3 || i == 1)) {
            byte[] bArr = new byte[i2];
            this.iv = bArr;
            secureRandom.nextBytes(bArr);
            parametersWithIV = new ParametersWithIV(parametersWithIV, this.iv);
        }
        if (secureRandom != null) {
            parametersWithIV = new ParametersWithRandom(parametersWithIV, secureRandom);
        }
        if (i == 1) {
            this.wrapEngine.init(true, parametersWithIV);
            this.wrapStream = new ErasableOutputStream();
            this.forWrapping = true;
        } else if (i == 2) {
            this.wrapEngine.init(false, parametersWithIV);
            this.wrapStream = new ErasableOutputStream();
            this.forWrapping = false;
        } else if (i == 3) {
            this.wrapEngine.init(true, parametersWithIV);
            this.wrapStream = null;
            this.forWrapping = true;
        } else if (i == 4) {
            try {
                this.wrapEngine.init(false, parametersWithIV);
                this.wrapStream = null;
                this.forWrapping = false;
            } catch (Exception e) {
                throw new InvalidKeyOrParametersException(e.getMessage(), e);
            }
        } else {
            throw new InvalidParameterException("Unknown mode parameter passed to init.");
        }
    }

    public void engineSetMode(String str) throws NoSuchAlgorithmException {
        throw new NoSuchAlgorithmException("can't support mode " + str);
    }

    public void engineSetPadding(String str) throws NoSuchPaddingException {
        throw new NoSuchPaddingException("Padding " + str + " unknown.");
    }

    public Key engineUnwrap(byte[] bArr, String str, int i) throws InvalidKeyException, NoSuchAlgorithmException {
        byte[] bArr2;
        try {
            Wrapper wrapper = this.wrapEngine;
            if (wrapper == null) {
                bArr2 = engineDoFinal(bArr, 0, bArr.length);
            } else {
                bArr2 = wrapper.unwrap(bArr, 0, bArr.length);
            }
            if (i == 3) {
                return new SecretKeySpec(bArr2, str);
            }
            if (!str.equals("") || i != 2) {
                try {
                    KeyFactory createKeyFactory = this.helper.createKeyFactory(str);
                    if (i == 1) {
                        return createKeyFactory.generatePublic(new X509EncodedKeySpec(bArr2));
                    }
                    if (i == 2) {
                        return createKeyFactory.generatePrivate(new PKCS8EncodedKeySpec(bArr2));
                    }
                    throw new InvalidKeyException("Unknown key type " + i);
                } catch (NoSuchProviderException e) {
                    throw new InvalidKeyException("Unknown key type " + e.getMessage());
                } catch (InvalidKeySpecException e2) {
                    throw new InvalidKeyException("Unknown key type " + e2.getMessage());
                }
            } else {
                try {
                    PrivateKeyInfo instance = PrivateKeyInfo.getInstance(bArr2);
                    PrivateKey privateKey = BouncyCastleProvider.getPrivateKey(instance);
                    if (privateKey != null) {
                        return privateKey;
                    }
                    throw new InvalidKeyException("algorithm " + instance.getPrivateKeyAlgorithm().getAlgorithm() + " not supported");
                } catch (Exception unused) {
                    throw new InvalidKeyException("Invalid key encoding.");
                }
            }
        } catch (InvalidCipherTextException e3) {
            throw new InvalidKeyException(e3.getMessage());
        } catch (BadPaddingException e4) {
            throw new InvalidKeyException(e4.getMessage());
        } catch (IllegalBlockSizeException e5) {
            throw new InvalidKeyException(e5.getMessage());
        }
    }

    public byte[] engineUpdate(byte[] bArr, int i, int i2) {
        ErasableOutputStream erasableOutputStream = this.wrapStream;
        if (erasableOutputStream != null) {
            erasableOutputStream.write(bArr, i, i2);
            return null;
        }
        throw new IllegalStateException("not supported in a wrapping mode");
    }

    public byte[] engineWrap(Key key) throws IllegalBlockSizeException, InvalidKeyException {
        byte[] encoded = key.getEncoded();
        if (encoded != null) {
            try {
                Wrapper wrapper = this.wrapEngine;
                if (wrapper == null) {
                    return engineDoFinal(encoded, 0, encoded.length);
                }
                return wrapper.wrap(encoded, 0, encoded.length);
            } catch (BadPaddingException e) {
                throw new IllegalBlockSizeException(e.getMessage());
            }
        } else {
            throw new InvalidKeyException("Cannot wrap key, null encoding.");
        }
    }

    public int engineUpdate(byte[] bArr, int i, int i2, byte[] bArr2, int i3) throws ShortBufferException {
        ErasableOutputStream erasableOutputStream = this.wrapStream;
        if (erasableOutputStream != null) {
            erasableOutputStream.write(bArr, i, i2);
            return 0;
        }
        throw new IllegalStateException("not supported in a wrapping mode");
    }

    public BaseWrapCipher(Wrapper wrapper) {
        this(wrapper, 0);
    }

    public BaseWrapCipher(Wrapper wrapper, int i) {
        this.availableSpecs = new Class[]{GOST28147WrapParameterSpec.class, PBEParameterSpec.class, RC2ParameterSpec.class, RC5ParameterSpec.class, IvParameterSpec.class};
        this.pbeType = 2;
        this.pbeHash = 1;
        this.engineParams = null;
        this.wrapEngine = null;
        this.wrapStream = null;
        this.helper = new BCJcaJceHelper();
        this.wrapEngine = wrapper;
        this.ivSize = i;
    }

    public int engineDoFinal(byte[] bArr, int i, int i2, byte[] bArr2, int i3) throws IllegalBlockSizeException, BadPaddingException, ShortBufferException {
        byte[] bArr3;
        ErasableOutputStream erasableOutputStream = this.wrapStream;
        if (erasableOutputStream != null) {
            erasableOutputStream.write(bArr, i, i2);
            try {
                if (this.forWrapping) {
                    bArr3 = this.wrapEngine.wrap(this.wrapStream.getBuf(), 0, this.wrapStream.size());
                } else {
                    bArr3 = this.wrapEngine.unwrap(this.wrapStream.getBuf(), 0, this.wrapStream.size());
                }
                if (bArr3.length + i3 <= bArr2.length) {
                    System.arraycopy(bArr3, 0, bArr2, i3, bArr3.length);
                    int length = bArr3.length;
                    this.wrapStream.erase();
                    return length;
                }
                throw new ShortBufferException("output buffer too short for input.");
            } catch (InvalidCipherTextException e) {
                throw new BadPaddingException(e.getMessage());
            } catch (Exception e2) {
                throw new IllegalBlockSizeException(e2.getMessage());
            } catch (Throwable th) {
                this.wrapStream.erase();
                throw th;
            }
        } else {
            throw new IllegalStateException("not supported in a wrapping mode");
        }
    }

    public void engineInit(int i, Key key, AlgorithmParameters algorithmParameters, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        AlgorithmParameterSpec algorithmParameterSpec;
        if (algorithmParameters != null) {
            algorithmParameterSpec = SpecUtil.extractSpec(algorithmParameters, this.availableSpecs);
            if (algorithmParameterSpec == null) {
                throw new InvalidAlgorithmParameterException("can't handle parameter " + algorithmParameters.toString());
            }
        } else {
            algorithmParameterSpec = null;
        }
        this.engineParams = algorithmParameters;
        engineInit(i, key, algorithmParameterSpec, secureRandom);
    }

    public void engineInit(int i, Key key, SecureRandom secureRandom) throws InvalidKeyException {
        try {
            engineInit(i, key, (AlgorithmParameterSpec) null, secureRandom);
        } catch (InvalidAlgorithmParameterException e) {
            throw new InvalidKeyOrParametersException(e.getMessage(), e);
        }
    }
}
