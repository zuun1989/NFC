package com.fis.ekyc.nfc.build_in.bouncycastle.pqc.jcajce.provider.mceliece;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.X509ObjectIdentifiers;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.Digest;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.InvalidCipherTextException;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.AsymmetricKeyParameter;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ParametersWithRandom;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.util.DigestFactory;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.mceliece.McElieceCCA2KeyParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.mceliece.McEliecePointchevalCipher;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.jcajce.provider.util.AsymmetricHybridCipher;
import java.io.ByteArrayOutputStream;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.BadPaddingException;

public class McEliecePointchevalCipherSpi extends AsymmetricHybridCipher implements PKCSObjectIdentifiers, X509ObjectIdentifiers {
    private ByteArrayOutputStream buf = new ByteArrayOutputStream();
    private McEliecePointchevalCipher cipher;
    private Digest digest;

    public static class McEliecePointcheval extends McEliecePointchevalCipherSpi {
        public McEliecePointcheval() {
            super(DigestFactory.createSHA1(), new McEliecePointchevalCipher());
        }
    }

    public static class McEliecePointcheval224 extends McEliecePointchevalCipherSpi {
        public McEliecePointcheval224() {
            super(DigestFactory.createSHA224(), new McEliecePointchevalCipher());
        }
    }

    public static class McEliecePointcheval256 extends McEliecePointchevalCipherSpi {
        public McEliecePointcheval256() {
            super(DigestFactory.createSHA256(), new McEliecePointchevalCipher());
        }
    }

    public static class McEliecePointcheval384 extends McEliecePointchevalCipherSpi {
        public McEliecePointcheval384() {
            super(DigestFactory.createSHA384(), new McEliecePointchevalCipher());
        }
    }

    public static class McEliecePointcheval512 extends McEliecePointchevalCipherSpi {
        public McEliecePointcheval512() {
            super(DigestFactory.createSHA512(), new McEliecePointchevalCipher());
        }
    }

    public McEliecePointchevalCipherSpi(Digest digest2, McEliecePointchevalCipher mcEliecePointchevalCipher) {
        this.digest = digest2;
        this.cipher = mcEliecePointchevalCipher;
        this.buf = new ByteArrayOutputStream();
    }

    public int decryptOutputSize(int i) {
        return 0;
    }

    public byte[] doFinal(byte[] bArr, int i, int i2) throws BadPaddingException {
        update(bArr, i, i2);
        byte[] byteArray = this.buf.toByteArray();
        this.buf.reset();
        int i3 = this.opMode;
        if (i3 == 1) {
            return this.cipher.messageEncrypt(byteArray);
        }
        if (i3 != 2) {
            return null;
        }
        try {
            return this.cipher.messageDecrypt(byteArray);
        } catch (InvalidCipherTextException e) {
            throw new BadPaddingException(e.getMessage());
        }
    }

    public int encryptOutputSize(int i) {
        return 0;
    }

    public int getKeySize(Key key) throws InvalidKeyException {
        McElieceCCA2KeyParameters mcElieceCCA2KeyParameters;
        if (key instanceof PublicKey) {
            mcElieceCCA2KeyParameters = (McElieceCCA2KeyParameters) McElieceCCA2KeysToParams.generatePublicKeyParameter((PublicKey) key);
        } else {
            mcElieceCCA2KeyParameters = (McElieceCCA2KeyParameters) McElieceCCA2KeysToParams.generatePrivateKeyParameter((PrivateKey) key);
        }
        return this.cipher.getKeySize(mcElieceCCA2KeyParameters);
    }

    public String getName() {
        return "McEliecePointchevalCipher";
    }

    public void initCipherDecrypt(Key key, AlgorithmParameterSpec algorithmParameterSpec) throws InvalidKeyException, InvalidAlgorithmParameterException {
        AsymmetricKeyParameter generatePrivateKeyParameter = McElieceCCA2KeysToParams.generatePrivateKeyParameter((PrivateKey) key);
        this.digest.reset();
        this.cipher.init(false, generatePrivateKeyParameter);
    }

    public void initCipherEncrypt(Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        ParametersWithRandom parametersWithRandom = new ParametersWithRandom(McElieceCCA2KeysToParams.generatePublicKeyParameter((PublicKey) key), secureRandom);
        this.digest.reset();
        this.cipher.init(true, parametersWithRandom);
    }

    public byte[] update(byte[] bArr, int i, int i2) {
        this.buf.write(bArr, i, i2);
        return new byte[0];
    }
}
