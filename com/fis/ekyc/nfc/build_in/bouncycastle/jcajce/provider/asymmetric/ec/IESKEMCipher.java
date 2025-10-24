package com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.ec;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x9.X9IntegerConverter;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.Digest;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.EphemeralKeyPair;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.KeyEncoder;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.Mac;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.agreement.ECDHCBasicAgreement;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines.IESEngine;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.generators.ECKeyPairGenerator;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.generators.EphemeralKeyPairGenerator;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.generators.KDF2BytesGenerator;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.macs.HMac;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.AsymmetricKeyParameter;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ECDomainParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ECKeyGenerationParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ECKeyParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ECPrivateKeyParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ECPublicKeyParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.KDFParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.KeyParameter;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.util.DigestFactory;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.util.BaseCipherSpi;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.util.ECUtil;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.spec.IESKEMParameterSpec;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.util.BCJcaJceHelper;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.util.JcaJceHelper;
import com.fis.ekyc.nfc.build_in.bouncycastle.jce.interfaces.ECKey;
import com.fis.ekyc.nfc.build_in.bouncycastle.jce.spec.IESParameterSpec;
import com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECCurve;
import com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECPoint;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.Arrays;
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
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.ShortBufferException;

public class IESKEMCipher extends BaseCipherSpi {
    private static final X9IntegerConverter converter = new X9IntegerConverter();
    private final ECDHCBasicAgreement agreement;
    private ByteArrayOutputStream buffer = new ByteArrayOutputStream();
    private boolean dhaesMode = false;
    private IESEngine engine;
    private AlgorithmParameters engineParam = null;
    private IESKEMParameterSpec engineSpec = null;
    private final Mac hMac;
    private final JcaJceHelper helper = new BCJcaJceHelper();
    private int ivLength;
    private final KDF2BytesGenerator kdf;
    private AsymmetricKeyParameter key;
    private final int macKeyLength;
    private final int macLength;
    private AsymmetricKeyParameter otherKeyParameter = null;
    private SecureRandom random;
    private int state = -1;

    public static class KEM extends IESKEMCipher {
        public KEM(Digest digest, Digest digest2, int i, int i2) {
            super(new ECDHCBasicAgreement(), new KDF2BytesGenerator(digest), new HMac(digest2), i, i2);
        }
    }

    public static class KEMwithSHA256 extends KEM {
        public KEMwithSHA256() {
            super(DigestFactory.createSHA256(), DigestFactory.createSHA256(), 32, 16);
        }
    }

    public IESKEMCipher(ECDHCBasicAgreement eCDHCBasicAgreement, KDF2BytesGenerator kDF2BytesGenerator, Mac mac, int i, int i2) {
        this.agreement = eCDHCBasicAgreement;
        this.kdf = kDF2BytesGenerator;
        this.hMac = mac;
        this.macKeyLength = i;
        this.macLength = i2;
    }

    public byte[] engineDoFinal(byte[] bArr, int i, int i2) throws IllegalBlockSizeException, BadPaddingException {
        if (i2 != 0) {
            this.buffer.write(bArr, i, i2);
        }
        this.buffer.toByteArray();
        this.buffer.reset();
        ECDomainParameters parameters = ((ECKeyParameters) this.key).getParameters();
        int i3 = this.state;
        if (i3 == 1 || i3 == 3) {
            ECKeyPairGenerator eCKeyPairGenerator = new ECKeyPairGenerator();
            eCKeyPairGenerator.init(new ECKeyGenerationParameters(parameters, this.random));
            final boolean hasUsePointCompression = this.engineSpec.hasUsePointCompression();
            EphemeralKeyPair generate = new EphemeralKeyPairGenerator(eCKeyPairGenerator, new KeyEncoder() {
                public byte[] getEncoded(AsymmetricKeyParameter asymmetricKeyParameter) {
                    return ((ECPublicKeyParameters) asymmetricKeyParameter).getQ().getEncoded(hasUsePointCompression);
                }
            }).generate();
            this.agreement.init(generate.getKeyPair().getPrivate());
            X9IntegerConverter x9IntegerConverter = converter;
            byte[] integerToBytes = x9IntegerConverter.integerToBytes(this.agreement.calculateAgreement(this.key), x9IntegerConverter.getByteLength(parameters.getCurve()));
            int i4 = this.macKeyLength + i2;
            byte[] bArr2 = new byte[i4];
            this.kdf.init(new KDFParameters(integerToBytes, this.engineSpec.getRecipientInfo()));
            this.kdf.generateBytes(bArr2, 0, i4);
            byte[] bArr3 = new byte[(this.macLength + i2)];
            for (int i5 = 0; i5 != i2; i5++) {
                bArr3[i5] = (byte) (bArr[i + i5] ^ bArr2[i5]);
            }
            KeyParameter keyParameter = new KeyParameter(bArr2, i2, i4 - i2);
            this.hMac.init(keyParameter);
            this.hMac.update(bArr3, 0, i2);
            byte[] bArr4 = new byte[this.hMac.getMacSize()];
            this.hMac.doFinal(bArr4, 0);
            Arrays.clear(keyParameter.getKey());
            Arrays.clear(bArr2);
            System.arraycopy(bArr4, 0, bArr3, i2, this.macLength);
            return Arrays.concatenate(generate.getEncodedPublicKey(), bArr3);
        } else if (i3 == 2 || i3 == 4) {
            ECPrivateKeyParameters eCPrivateKeyParameters = (ECPrivateKeyParameters) this.key;
            ECCurve curve = eCPrivateKeyParameters.getParameters().getCurve();
            int fieldSize = (curve.getFieldSize() + 7) / 8;
            if (bArr[i] == 4) {
                fieldSize *= 2;
            }
            int i6 = fieldSize + 1;
            int i7 = i2 - (this.macLength + i6);
            int i8 = i6 + i;
            ECPoint decodePoint = curve.decodePoint(Arrays.copyOfRange(bArr, i, i8));
            this.agreement.init(this.key);
            X9IntegerConverter x9IntegerConverter2 = converter;
            byte[] integerToBytes2 = x9IntegerConverter2.integerToBytes(this.agreement.calculateAgreement(new ECPublicKeyParameters(decodePoint, eCPrivateKeyParameters.getParameters())), x9IntegerConverter2.getByteLength(parameters.getCurve()));
            int i9 = this.macKeyLength + i7;
            byte[] bArr5 = new byte[i9];
            this.kdf.init(new KDFParameters(integerToBytes2, this.engineSpec.getRecipientInfo()));
            this.kdf.generateBytes(bArr5, 0, i9);
            byte[] bArr6 = new byte[i7];
            for (int i10 = 0; i10 != i7; i10++) {
                bArr6[i10] = (byte) (bArr[i8 + i10] ^ bArr5[i10]);
            }
            KeyParameter keyParameter2 = new KeyParameter(bArr5, i7, i9 - i7);
            this.hMac.init(keyParameter2);
            this.hMac.update(bArr, i8, i7);
            byte[] bArr7 = new byte[this.hMac.getMacSize()];
            this.hMac.doFinal(bArr7, 0);
            Arrays.clear(keyParameter2.getKey());
            Arrays.clear(bArr5);
            int i11 = this.macLength;
            if (Arrays.constantTimeAreEqual(i11, bArr7, 0, bArr, i + (i2 - i11))) {
                return bArr6;
            }
            throw new BadPaddingException("mac field");
        } else {
            throw new IllegalStateException("cipher not initialised");
        }
    }

    public int engineGetBlockSize() {
        return 0;
    }

    public byte[] engineGetIV() {
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
        if (this.key != null) {
            int macSize = this.engine.getMac().getMacSize();
            if (this.otherKeyParameter == null) {
                i2 = ((((ECKeyParameters) this.key).getParameters().getCurve().getFieldSize() + 7) / 8) * 2;
            } else {
                i2 = 0;
            }
            int size = this.buffer.size() + i;
            if (this.engine.getCipher() != null) {
                int i3 = this.state;
                if (i3 == 1 || i3 == 3) {
                    size = this.engine.getCipher().getOutputSize(size);
                } else if (i3 == 2 || i3 == 4) {
                    size = this.engine.getCipher().getOutputSize((size - macSize) - i2);
                } else {
                    throw new IllegalStateException("cipher not initialised");
                }
            }
            int i4 = this.state;
            if (i4 == 1 || i4 == 3) {
                return macSize + i2 + size;
            }
            if (i4 == 2 || i4 == 4) {
                return size;
            }
            throw new IllegalStateException("cipher not initialised");
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
        throw new NoSuchAlgorithmException("can't support mode " + str);
    }

    public void engineSetPadding(String str) throws NoSuchPaddingException {
        throw new NoSuchPaddingException("padding not available with IESCipher");
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
        this.otherKeyParameter = null;
        this.engineSpec = (IESKEMParameterSpec) algorithmParameterSpec;
        if (i == 1 || i == 3) {
            if (key2 instanceof PublicKey) {
                this.key = ECUtils.generatePublicKeyParameter((PublicKey) key2);
            } else {
                throw new InvalidKeyException("must be passed recipient's public EC key for encryption");
            }
        } else if (i != 2 && i != 4) {
            throw new InvalidKeyException("must be passed EC key");
        } else if (key2 instanceof PrivateKey) {
            this.key = ECUtil.generatePrivateKeyParameter((PrivateKey) key2);
        } else {
            throw new InvalidKeyException("must be passed recipient's private EC key for decryption");
        }
        this.random = secureRandom;
        this.state = i;
        this.buffer.reset();
    }

    public void engineInit(int i, Key key2, SecureRandom secureRandom) throws InvalidKeyException {
        try {
            engineInit(i, key2, (AlgorithmParameterSpec) null, secureRandom);
        } catch (InvalidAlgorithmParameterException e) {
            throw new IllegalArgumentException("cannot handle supplied parameter spec: " + e.getMessage());
        }
    }

    public int engineDoFinal(byte[] bArr, int i, int i2, byte[] bArr2, int i3) throws ShortBufferException, IllegalBlockSizeException, BadPaddingException {
        byte[] engineDoFinal = engineDoFinal(bArr, i, i2);
        System.arraycopy(engineDoFinal, 0, bArr2, i3, engineDoFinal.length);
        return engineDoFinal.length;
    }
}
