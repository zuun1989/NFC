package com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.elgamal;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.AsymmetricBlockCipher;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.Digest;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.InvalidCipherTextException;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.encodings.ISO9796d1Encoding;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.encodings.OAEPEncoding;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.encodings.PKCS1Encoding;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines.ElGamalEngine;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ParametersWithRandom;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.util.BaseCipherSpi;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.util.BadBlockException;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.util.DigestFactory;
import com.fis.ekyc.nfc.build_in.bouncycastle.jce.interfaces.ElGamalKey;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.jcajce.spec.McElieceCCA2KeyGenParameterSpec;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.Strings;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.InvalidParameterException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.MGF1ParameterSpec;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.ShortBufferException;
import javax.crypto.interfaces.DHKey;
import javax.crypto.interfaces.DHPrivateKey;
import javax.crypto.interfaces.DHPublicKey;
import javax.crypto.spec.OAEPParameterSpec;
import javax.crypto.spec.PSource;

public class CipherSpi extends BaseCipherSpi {
    private BaseCipherSpi.ErasableOutputStream bOut = new BaseCipherSpi.ErasableOutputStream();
    private AsymmetricBlockCipher cipher;
    private AlgorithmParameters engineParams;
    private AlgorithmParameterSpec paramSpec;

    public static class NoPadding extends CipherSpi {
        public NoPadding() {
            super(new ElGamalEngine());
        }
    }

    public static class PKCS1v1_5Padding extends CipherSpi {
        public PKCS1v1_5Padding() {
            super(new PKCS1Encoding(new ElGamalEngine()));
        }
    }

    public CipherSpi(AsymmetricBlockCipher asymmetricBlockCipher) {
        this.cipher = asymmetricBlockCipher;
    }

    private byte[] getOutput() throws BadPaddingException {
        try {
            byte[] processBlock = this.cipher.processBlock(this.bOut.getBuf(), 0, this.bOut.size());
            this.bOut.erase();
            return processBlock;
        } catch (InvalidCipherTextException e) {
            throw new BadBlockException("unable to decrypt block", e);
        } catch (ArrayIndexOutOfBoundsException e2) {
            throw new BadBlockException("unable to decrypt block", e2);
        } catch (Throwable th) {
            this.bOut.erase();
            throw th;
        }
    }

    private void initFromSpec(OAEPParameterSpec oAEPParameterSpec) throws NoSuchPaddingException {
        MGF1ParameterSpec mGF1ParameterSpec = (MGF1ParameterSpec) oAEPParameterSpec.getMGFParameters();
        Digest digest = DigestFactory.getDigest(mGF1ParameterSpec.getDigestAlgorithm());
        if (digest != null) {
            this.cipher = new OAEPEncoding(new ElGamalEngine(), digest, ((PSource.PSpecified) oAEPParameterSpec.getPSource()).getValue());
            this.paramSpec = oAEPParameterSpec;
            return;
        }
        throw new NoSuchPaddingException("no match on OAEP constructor for digest algorithm: " + mGF1ParameterSpec.getDigestAlgorithm());
    }

    public byte[] engineDoFinal(byte[] bArr, int i, int i2) throws IllegalBlockSizeException, BadPaddingException {
        if (bArr != null) {
            this.bOut.write(bArr, i, i2);
        }
        if (this.cipher instanceof ElGamalEngine) {
            if (this.bOut.size() > this.cipher.getInputBlockSize() + 1) {
                throw new ArrayIndexOutOfBoundsException("too much data for ElGamal block");
            }
        } else if (this.bOut.size() > this.cipher.getInputBlockSize()) {
            throw new ArrayIndexOutOfBoundsException("too much data for ElGamal block");
        }
        return getOutput();
    }

    public int engineGetBlockSize() {
        return this.cipher.getInputBlockSize();
    }

    public int engineGetKeySize(Key key) {
        if (key instanceof ElGamalKey) {
            return ((ElGamalKey) key).getParameters().getP().bitLength();
        }
        if (key instanceof DHKey) {
            return ((DHKey) key).getParams().getP().bitLength();
        }
        throw new IllegalArgumentException("not an ElGamal key!");
    }

    public int engineGetOutputSize(int i) {
        return this.cipher.getOutputBlockSize();
    }

    public AlgorithmParameters engineGetParameters() {
        if (this.engineParams == null && this.paramSpec != null) {
            try {
                AlgorithmParameters createParametersInstance = createParametersInstance("OAEP");
                this.engineParams = createParametersInstance;
                createParametersInstance.init(this.paramSpec);
            } catch (Exception e) {
                throw new RuntimeException(e.toString());
            }
        }
        return this.engineParams;
    }

    public void engineInit(int i, Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        ParametersWithRandom parametersWithRandom;
        if (key instanceof DHPublicKey) {
            parametersWithRandom = ElGamalUtil.generatePublicKeyParameter((PublicKey) key);
        } else if (key instanceof DHPrivateKey) {
            parametersWithRandom = ElGamalUtil.generatePrivateKeyParameter((PrivateKey) key);
        } else {
            throw new InvalidKeyException("unknown key type passed to ElGamal");
        }
        if (algorithmParameterSpec instanceof OAEPParameterSpec) {
            OAEPParameterSpec oAEPParameterSpec = (OAEPParameterSpec) algorithmParameterSpec;
            this.paramSpec = algorithmParameterSpec;
            if (!oAEPParameterSpec.getMGFAlgorithm().equalsIgnoreCase("MGF1") && !oAEPParameterSpec.getMGFAlgorithm().equals(PKCSObjectIdentifiers.id_mgf1.getId())) {
                throw new InvalidAlgorithmParameterException("unknown mask generation function specified");
            } else if (oAEPParameterSpec.getMGFParameters() instanceof MGF1ParameterSpec) {
                Digest digest = DigestFactory.getDigest(oAEPParameterSpec.getDigestAlgorithm());
                if (digest != null) {
                    MGF1ParameterSpec mGF1ParameterSpec = (MGF1ParameterSpec) oAEPParameterSpec.getMGFParameters();
                    Digest digest2 = DigestFactory.getDigest(mGF1ParameterSpec.getDigestAlgorithm());
                    if (digest2 != null) {
                        this.cipher = new OAEPEncoding(new ElGamalEngine(), digest, digest2, ((PSource.PSpecified) oAEPParameterSpec.getPSource()).getValue());
                    } else {
                        throw new InvalidAlgorithmParameterException("no match on MGF digest algorithm: " + mGF1ParameterSpec.getDigestAlgorithm());
                    }
                } else {
                    throw new InvalidAlgorithmParameterException("no match on digest algorithm: " + oAEPParameterSpec.getDigestAlgorithm());
                }
            } else {
                throw new InvalidAlgorithmParameterException("unkown MGF parameters");
            }
        } else if (algorithmParameterSpec != null) {
            throw new InvalidAlgorithmParameterException("unknown parameter type.");
        }
        if (secureRandom != null) {
            parametersWithRandom = new ParametersWithRandom(parametersWithRandom, secureRandom);
        }
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        throw new InvalidParameterException("unknown opmode " + i + " passed to ElGamal");
                    }
                }
            }
            this.cipher.init(false, parametersWithRandom);
            return;
        }
        this.cipher.init(true, parametersWithRandom);
    }

    public void engineSetMode(String str) throws NoSuchAlgorithmException {
        String upperCase = Strings.toUpperCase(str);
        if (!upperCase.equals("NONE") && !upperCase.equals("ECB")) {
            throw new NoSuchAlgorithmException("can't support mode " + str);
        }
    }

    public void engineSetPadding(String str) throws NoSuchPaddingException {
        String upperCase = Strings.toUpperCase(str);
        if (upperCase.equals("NOPADDING")) {
            this.cipher = new ElGamalEngine();
        } else if (upperCase.equals("PKCS1PADDING")) {
            this.cipher = new PKCS1Encoding(new ElGamalEngine());
        } else if (upperCase.equals("ISO9796-1PADDING")) {
            this.cipher = new ISO9796d1Encoding(new ElGamalEngine());
        } else if (upperCase.equals("OAEPPADDING")) {
            initFromSpec(OAEPParameterSpec.DEFAULT);
        } else if (upperCase.equals("OAEPWITHMD5ANDMGF1PADDING")) {
            initFromSpec(new OAEPParameterSpec("MD5", "MGF1", new MGF1ParameterSpec("MD5"), PSource.PSpecified.DEFAULT));
        } else if (upperCase.equals("OAEPWITHSHA1ANDMGF1PADDING")) {
            initFromSpec(OAEPParameterSpec.DEFAULT);
        } else if (upperCase.equals("OAEPWITHSHA224ANDMGF1PADDING")) {
            initFromSpec(new OAEPParameterSpec(McElieceCCA2KeyGenParameterSpec.SHA224, "MGF1", new MGF1ParameterSpec(McElieceCCA2KeyGenParameterSpec.SHA224), PSource.PSpecified.DEFAULT));
        } else if (upperCase.equals("OAEPWITHSHA256ANDMGF1PADDING")) {
            initFromSpec(new OAEPParameterSpec("SHA-256", "MGF1", MGF1ParameterSpec.SHA256, PSource.PSpecified.DEFAULT));
        } else if (upperCase.equals("OAEPWITHSHA384ANDMGF1PADDING")) {
            initFromSpec(new OAEPParameterSpec(McElieceCCA2KeyGenParameterSpec.SHA384, "MGF1", MGF1ParameterSpec.SHA384, PSource.PSpecified.DEFAULT));
        } else if (upperCase.equals("OAEPWITHSHA512ANDMGF1PADDING")) {
            initFromSpec(new OAEPParameterSpec("SHA-512", "MGF1", MGF1ParameterSpec.SHA512, PSource.PSpecified.DEFAULT));
        } else if (upperCase.equals("OAEPWITHSHA3-224ANDMGF1PADDING")) {
            initFromSpec(new OAEPParameterSpec("SHA3-224", "MGF1", new MGF1ParameterSpec("SHA3-224"), PSource.PSpecified.DEFAULT));
        } else if (upperCase.equals("OAEPWITHSHA3-256ANDMGF1PADDING")) {
            initFromSpec(new OAEPParameterSpec("SHA3-256", "MGF1", new MGF1ParameterSpec("SHA3-256"), PSource.PSpecified.DEFAULT));
        } else if (upperCase.equals("OAEPWITHSHA3-384ANDMGF1PADDING")) {
            initFromSpec(new OAEPParameterSpec("SHA3-384", "MGF1", new MGF1ParameterSpec("SHA3-384"), PSource.PSpecified.DEFAULT));
        } else if (upperCase.equals("OAEPWITHSHA3-512ANDMGF1PADDING")) {
            initFromSpec(new OAEPParameterSpec("SHA3-512", "MGF1", new MGF1ParameterSpec("SHA3-512"), PSource.PSpecified.DEFAULT));
        } else {
            throw new NoSuchPaddingException(str + " unavailable with ElGamal.");
        }
    }

    public byte[] engineUpdate(byte[] bArr, int i, int i2) {
        this.bOut.write(bArr, i, i2);
        return null;
    }

    public int engineUpdate(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        this.bOut.write(bArr, i, i2);
        return 0;
    }

    public int engineDoFinal(byte[] bArr, int i, int i2, byte[] bArr2, int i3) throws IllegalBlockSizeException, BadPaddingException, ShortBufferException {
        if (engineGetOutputSize(i2) + i3 <= bArr2.length) {
            if (bArr != null) {
                this.bOut.write(bArr, i, i2);
            }
            if (this.cipher instanceof ElGamalEngine) {
                if (this.bOut.size() > this.cipher.getInputBlockSize() + 1) {
                    throw new ArrayIndexOutOfBoundsException("too much data for ElGamal block");
                }
            } else if (this.bOut.size() > this.cipher.getInputBlockSize()) {
                throw new ArrayIndexOutOfBoundsException("too much data for ElGamal block");
            }
            byte[] output = getOutput();
            for (int i4 = 0; i4 != output.length; i4++) {
                bArr2[i3 + i4] = output[i4];
            }
            return output.length;
        }
        throw new ShortBufferException("output buffer too short for input.");
    }

    public void engineInit(int i, Key key, AlgorithmParameters algorithmParameters, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        throw new InvalidAlgorithmParameterException("can't handle parameters in ElGamal");
    }

    public void engineInit(int i, Key key, SecureRandom secureRandom) throws InvalidKeyException {
        try {
            engineInit(i, key, (AlgorithmParameterSpec) null, secureRandom);
        } catch (InvalidAlgorithmParameterException e) {
            throw new InvalidKeyException("Eeeek! " + e.toString(), e);
        }
    }
}
