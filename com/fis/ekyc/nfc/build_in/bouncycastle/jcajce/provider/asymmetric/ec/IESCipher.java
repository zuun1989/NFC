package com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.ec;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.BlockCipher;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.CipherParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.InvalidCipherTextException;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.KeyEncoder;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.KeyParser;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.agreement.ECDHBasicAgreement;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines.AESEngine;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines.DESedeEngine;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines.IESEngine;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.generators.ECKeyPairGenerator;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.generators.EphemeralKeyPairGenerator;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.generators.KDF2BytesGenerator;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.macs.HMac;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.modes.CBCBlockCipher;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.paddings.PaddedBufferedBlockCipher;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.AsymmetricKeyParameter;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ECDomainParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ECKeyGenerationParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ECKeyParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ECPublicKeyParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.IESWithCipherParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ParametersWithIV;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.parsers.ECIESPublicKeyParser;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.util.DigestFactory;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.util.ECUtil;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.util.IESUtil;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.util.BadBlockException;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.util.BCJcaJceHelper;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.util.JcaJceHelper;
import com.fis.ekyc.nfc.build_in.bouncycastle.jce.interfaces.ECKey;
import com.fis.ekyc.nfc.build_in.bouncycastle.jce.interfaces.IESKey;
import com.fis.ekyc.nfc.build_in.bouncycastle.jce.spec.IESParameterSpec;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.Strings;
import java.io.ByteArrayOutputStream;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.BadPaddingException;
import javax.crypto.CipherSpi;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.ShortBufferException;

public class IESCipher extends CipherSpi {
    private ByteArrayOutputStream buffer = new ByteArrayOutputStream();
    private boolean dhaesMode = false;
    private IESEngine engine;
    private AlgorithmParameters engineParam = null;
    private IESParameterSpec engineSpec = null;
    private final JcaJceHelper helper = new BCJcaJceHelper();
    private int ivLength;
    private AsymmetricKeyParameter key;
    private AsymmetricKeyParameter otherKeyParameter = null;
    private SecureRandom random;
    private int state = -1;

    public static class ECIES extends IESCipher {
        public ECIES() {
            super(new IESEngine(new ECDHBasicAgreement(), new KDF2BytesGenerator(DigestFactory.createSHA1()), new HMac(DigestFactory.createSHA1())));
        }
    }

    public static class ECIESwithAESCBC extends ECIESwithCipher {
        public ECIESwithAESCBC() {
            super(new CBCBlockCipher(new AESEngine()), 16);
        }
    }

    public static class ECIESwithCipher extends IESCipher {
        public ECIESwithCipher(BlockCipher blockCipher, int i) {
            super(new IESEngine(new ECDHBasicAgreement(), new KDF2BytesGenerator(DigestFactory.createSHA1()), new HMac(DigestFactory.createSHA1()), new PaddedBufferedBlockCipher(blockCipher)), i);
        }
    }

    public static class ECIESwithDESedeCBC extends ECIESwithCipher {
        public ECIESwithDESedeCBC() {
            super(new CBCBlockCipher(new DESedeEngine()), 8);
        }
    }

    public IESCipher(IESEngine iESEngine) {
        this.engine = iESEngine;
        this.ivLength = 0;
    }

    public byte[] engineDoFinal(byte[] bArr, int i, int i2) throws IllegalBlockSizeException, BadPaddingException {
        if (i2 != 0) {
            this.buffer.write(bArr, i, i2);
        }
        byte[] byteArray = this.buffer.toByteArray();
        this.buffer.reset();
        CipherParameters iESWithCipherParameters = new IESWithCipherParameters(this.engineSpec.getDerivationV(), this.engineSpec.getEncodingV(), this.engineSpec.getMacKeySize(), this.engineSpec.getCipherKeySize());
        if (this.engineSpec.getNonce() != null) {
            iESWithCipherParameters = new ParametersWithIV(iESWithCipherParameters, this.engineSpec.getNonce());
        }
        ECDomainParameters parameters = ((ECKeyParameters) this.key).getParameters();
        AsymmetricKeyParameter asymmetricKeyParameter = this.otherKeyParameter;
        if (asymmetricKeyParameter != null) {
            try {
                int i3 = this.state;
                if (i3 != 1) {
                    if (i3 != 3) {
                        this.engine.init(false, this.key, asymmetricKeyParameter, iESWithCipherParameters);
                        return this.engine.processBlock(byteArray, 0, byteArray.length);
                    }
                }
                this.engine.init(true, asymmetricKeyParameter, this.key, iESWithCipherParameters);
                return this.engine.processBlock(byteArray, 0, byteArray.length);
            } catch (Exception e) {
                throw new BadBlockException("unable to process block", e);
            }
        } else {
            int i4 = this.state;
            if (i4 == 1 || i4 == 3) {
                ECKeyPairGenerator eCKeyPairGenerator = new ECKeyPairGenerator();
                eCKeyPairGenerator.init(new ECKeyGenerationParameters(parameters, this.random));
                final boolean pointCompression = this.engineSpec.getPointCompression();
                try {
                    this.engine.init(this.key, iESWithCipherParameters, new EphemeralKeyPairGenerator(eCKeyPairGenerator, new KeyEncoder() {
                        public byte[] getEncoded(AsymmetricKeyParameter asymmetricKeyParameter) {
                            return ((ECPublicKeyParameters) asymmetricKeyParameter).getQ().getEncoded(pointCompression);
                        }
                    }));
                    return this.engine.processBlock(byteArray, 0, byteArray.length);
                } catch (Exception e2) {
                    throw new BadBlockException("unable to process block", e2);
                }
            } else if (i4 == 2 || i4 == 4) {
                try {
                    this.engine.init(this.key, iESWithCipherParameters, (KeyParser) new ECIESPublicKeyParser(parameters));
                    return this.engine.processBlock(byteArray, 0, byteArray.length);
                } catch (InvalidCipherTextException e3) {
                    throw new BadBlockException("unable to process block", e3);
                }
            } else {
                throw new IllegalStateException("cipher not initialised");
            }
        }
    }

    public int engineGetBlockSize() {
        if (this.engine.getCipher() != null) {
            return this.engine.getCipher().getBlockSize();
        }
        return 0;
    }

    public byte[] engineGetIV() {
        IESParameterSpec iESParameterSpec = this.engineSpec;
        if (iESParameterSpec != null) {
            return iESParameterSpec.getNonce();
        }
        return null;
    }

    public int engineGetKeySize(Key key2) {
        if (key2 instanceof ECKey) {
            return ((ECKey) key2).getParameters().getCurve().getFieldSize();
        }
        throw new IllegalArgumentException("not an EC key");
    }

    public int engineGetOutputSize(int i) {
        int i2;
        int size;
        if (this.key != null) {
            int macSize = this.engine.getMac().getMacSize();
            if (this.otherKeyParameter == null) {
                i2 = ((((ECKeyParameters) this.key).getParameters().getCurve().getFieldSize() + 7) / 8) * 2;
            } else {
                i2 = 0;
            }
            if (this.engine.getCipher() != null) {
                int i3 = this.state;
                if (i3 == 1 || i3 == 3) {
                    i = this.engine.getCipher().getOutputSize(i);
                } else if (i3 == 2 || i3 == 4) {
                    i = this.engine.getCipher().getOutputSize((i - macSize) - i2);
                } else {
                    throw new IllegalStateException("cipher not initialised");
                }
            }
            int i4 = this.state;
            if (i4 == 1 || i4 == 3) {
                size = this.buffer.size() + macSize + 1 + i2;
            } else if (i4 == 2 || i4 == 4) {
                size = (this.buffer.size() - macSize) - i2;
            } else {
                throw new IllegalStateException("cipher not initialised");
            }
            return size + i;
        }
        throw new IllegalStateException("cipher not initialised");
    }

    public AlgorithmParameters engineGetParameters() {
        if (this.engineParam == null && this.engineSpec != null) {
            try {
                AlgorithmParameters createAlgorithmParameters = this.helper.createAlgorithmParameters("IES");
                this.engineParam = createAlgorithmParameters;
                createAlgorithmParameters.init(this.engineSpec);
            } catch (Exception e) {
                throw new RuntimeException(e.toString());
            }
        }
        return this.engineParam;
    }

    public void engineInit(int i, Key key2, AlgorithmParameters algorithmParameters, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        AlgorithmParameterSpec algorithmParameterSpec;
        if (algorithmParameters != null) {
            try {
                algorithmParameterSpec = algorithmParameters.getParameterSpec(IESParameterSpec.class);
            } catch (Exception e) {
                throw new InvalidAlgorithmParameterException("cannot recognise parameters: " + e.toString());
            }
        } else {
            algorithmParameterSpec = null;
        }
        this.engineParam = algorithmParameters;
        engineInit(i, key2, algorithmParameterSpec, secureRandom);
    }

    public void engineSetMode(String str) throws NoSuchAlgorithmException {
        String upperCase = Strings.toUpperCase(str);
        if (upperCase.equals("NONE")) {
            this.dhaesMode = false;
        } else if (upperCase.equals("DHAES")) {
            this.dhaesMode = true;
        } else {
            throw new IllegalArgumentException("can't support mode " + str);
        }
    }

    public void engineSetPadding(String str) throws NoSuchPaddingException {
        String upperCase = Strings.toUpperCase(str);
        if (!upperCase.equals("NOPADDING") && !upperCase.equals("PKCS5PADDING") && !upperCase.equals("PKCS7PADDING")) {
            throw new NoSuchPaddingException("padding not available with IESCipher");
        }
    }

    public byte[] engineUpdate(byte[] bArr, int i, int i2) {
        this.buffer.write(bArr, i, i2);
        return null;
    }

    public int engineUpdate(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        this.buffer.write(bArr, i, i2);
        return 0;
    }

    public void engineInit(int i, Key key2, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException, InvalidKeyException {
        byte[] bArr = null;
        this.otherKeyParameter = null;
        if (algorithmParameterSpec == null) {
            int i2 = this.ivLength;
            if (i2 != 0 && i == 1) {
                bArr = new byte[i2];
                secureRandom.nextBytes(bArr);
            }
            this.engineSpec = IESUtil.guessParameterSpec(this.engine.getCipher(), bArr);
        } else if (algorithmParameterSpec instanceof IESParameterSpec) {
            this.engineSpec = (IESParameterSpec) algorithmParameterSpec;
        } else {
            throw new InvalidAlgorithmParameterException("must be passed IES parameters");
        }
        byte[] nonce = this.engineSpec.getNonce();
        int i3 = this.ivLength;
        if (i3 == 0 || (nonce != null && nonce.length == i3)) {
            if (i == 1 || i == 3) {
                if (key2 instanceof PublicKey) {
                    this.key = ECUtils.generatePublicKeyParameter((PublicKey) key2);
                } else if (key2 instanceof IESKey) {
                    IESKey iESKey = (IESKey) key2;
                    this.key = ECUtils.generatePublicKeyParameter(iESKey.getPublic());
                    this.otherKeyParameter = ECUtil.generatePrivateKeyParameter(iESKey.getPrivate());
                } else {
                    throw new InvalidKeyException("must be passed recipient's public EC key for encryption");
                }
            } else if (i != 2 && i != 4) {
                throw new InvalidKeyException("must be passed EC key");
            } else if (key2 instanceof PrivateKey) {
                this.key = ECUtil.generatePrivateKeyParameter((PrivateKey) key2);
            } else if (key2 instanceof IESKey) {
                IESKey iESKey2 = (IESKey) key2;
                this.otherKeyParameter = ECUtils.generatePublicKeyParameter(iESKey2.getPublic());
                this.key = ECUtil.generatePrivateKeyParameter(iESKey2.getPrivate());
            } else {
                throw new InvalidKeyException("must be passed recipient's private EC key for decryption");
            }
            this.random = secureRandom;
            this.state = i;
            this.buffer.reset();
            return;
        }
        throw new InvalidAlgorithmParameterException("NONCE in IES Parameters needs to be " + this.ivLength + " bytes long");
    }

    public IESCipher(IESEngine iESEngine, int i) {
        this.engine = iESEngine;
        this.ivLength = i;
    }

    public int engineDoFinal(byte[] bArr, int i, int i2, byte[] bArr2, int i3) throws ShortBufferException, IllegalBlockSizeException, BadPaddingException {
        byte[] engineDoFinal = engineDoFinal(bArr, i, i2);
        System.arraycopy(engineDoFinal, 0, bArr2, i3, engineDoFinal.length);
        return engineDoFinal.length;
    }

    public void engineInit(int i, Key key2, SecureRandom secureRandom) throws InvalidKeyException {
        try {
            engineInit(i, key2, (AlgorithmParameterSpec) null, secureRandom);
        } catch (InvalidAlgorithmParameterException e) {
            throw new IllegalArgumentException("cannot handle supplied parameter spec: " + e.getMessage());
        }
    }
}
