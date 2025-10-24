package com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.symmetric.util;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DEROctetString;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.cms.GCMParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.BlockCipher;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.BufferedBlockCipher;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.CipherParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.DataLengthException;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.InvalidCipherTextException;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.OutputLengthException;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines.DSTU7624Engine;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.modes.AEADBlockCipher;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.modes.AEADCipher;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.modes.CBCBlockCipher;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.modes.CCMBlockCipher;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.modes.CFBBlockCipher;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.modes.CTSBlockCipher;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.modes.EAXBlockCipher;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.modes.GCFBBlockCipher;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.modes.GCMBlockCipher;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.modes.GOFBBlockCipher;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.modes.KCCMBlockCipher;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.modes.KCTRBlockCipher;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.modes.KGCMBlockCipher;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.modes.OCBBlockCipher;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.modes.OFBBlockCipher;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.modes.OpenPGPCFBBlockCipher;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.modes.PGPCFBBlockCipher;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.modes.SICBlockCipher;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.paddings.BlockCipherPadding;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.paddings.ISO10126d2Padding;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.paddings.ISO7816d4Padding;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.paddings.PaddedBufferedBlockCipher;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.paddings.TBCPadding;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.paddings.X923Padding;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.paddings.ZeroBytePadding;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.AEADParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ParametersWithIV;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.spec.GOST28147ParameterSpec;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.Arrays;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.Strings;
import java.lang.reflect.Constructor;
import java.nio.ByteBuffer;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.ShortBufferException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEParameterSpec;
import javax.crypto.spec.RC2ParameterSpec;
import javax.crypto.spec.RC5ParameterSpec;

public class BaseBlockCipher extends BaseWrapCipher implements PBE {
    private static final int BUF_SIZE = 512;
    private static final Class gcmSpecClass = ClassUtil.loadClass(BaseBlockCipher.class, "javax.crypto.spec.GCMParameterSpec");
    private AEADParameters aeadParams;
    private Class[] availableSpecs;
    private BlockCipher baseEngine;
    private GenericBlockCipher cipher;
    private int digest;
    private BlockCipherProvider engineProvider;
    private boolean fixedIv;
    private int ivLength;
    private ParametersWithIV ivParam;
    private int keySizeInBits;
    private String modeName;
    private boolean padded;
    private String pbeAlgorithm;
    private PBEParameterSpec pbeSpec;
    private int scheme;

    public static class AEADGenericBlockCipher implements GenericBlockCipher {
        private static final Constructor aeadBadTagConstructor;
        /* access modifiers changed from: private */
        public AEADCipher cipher;

        static {
            Class loadClass = ClassUtil.loadClass(BaseBlockCipher.class, "javax.crypto.AEADBadTagException");
            if (loadClass != null) {
                aeadBadTagConstructor = findExceptionConstructor(loadClass);
            } else {
                aeadBadTagConstructor = null;
            }
        }

        public AEADGenericBlockCipher(AEADCipher aEADCipher) {
            this.cipher = aEADCipher;
        }

        private static Constructor findExceptionConstructor(Class cls) {
            try {
                return cls.getConstructor(new Class[]{String.class});
            } catch (Exception unused) {
                return null;
            }
        }

        public int doFinal(byte[] bArr, int i) throws IllegalStateException, BadPaddingException {
            BadPaddingException badPaddingException;
            try {
                return this.cipher.doFinal(bArr, i);
            } catch (InvalidCipherTextException e) {
                Constructor constructor = aeadBadTagConstructor;
                if (constructor != null) {
                    try {
                        badPaddingException = (BadPaddingException) constructor.newInstance(new Object[]{e.getMessage()});
                    } catch (Exception unused) {
                        badPaddingException = null;
                    }
                    if (badPaddingException != null) {
                        throw badPaddingException;
                    }
                }
                throw new BadPaddingException(e.getMessage());
            }
        }

        public String getAlgorithmName() {
            AEADCipher aEADCipher = this.cipher;
            if (aEADCipher instanceof AEADBlockCipher) {
                return ((AEADBlockCipher) aEADCipher).getUnderlyingCipher().getAlgorithmName();
            }
            return aEADCipher.getAlgorithmName();
        }

        public int getOutputSize(int i) {
            return this.cipher.getOutputSize(i);
        }

        public BlockCipher getUnderlyingCipher() {
            AEADCipher aEADCipher = this.cipher;
            if (aEADCipher instanceof AEADBlockCipher) {
                return ((AEADBlockCipher) aEADCipher).getUnderlyingCipher();
            }
            return null;
        }

        public int getUpdateOutputSize(int i) {
            return this.cipher.getUpdateOutputSize(i);
        }

        public void init(boolean z, CipherParameters cipherParameters) throws IllegalArgumentException {
            this.cipher.init(z, cipherParameters);
        }

        public int processByte(byte b, byte[] bArr, int i) throws DataLengthException {
            return this.cipher.processByte(b, bArr, i);
        }

        public int processBytes(byte[] bArr, int i, int i2, byte[] bArr2, int i3) throws DataLengthException {
            return this.cipher.processBytes(bArr, i, i2, bArr2, i3);
        }

        public void updateAAD(byte[] bArr, int i, int i2) {
            this.cipher.processAADBytes(bArr, i, i2);
        }

        public boolean wrapOnNoPadding() {
            return false;
        }
    }

    public interface GenericBlockCipher {
        int doFinal(byte[] bArr, int i) throws IllegalStateException, BadPaddingException;

        String getAlgorithmName();

        int getOutputSize(int i);

        BlockCipher getUnderlyingCipher();

        int getUpdateOutputSize(int i);

        void init(boolean z, CipherParameters cipherParameters) throws IllegalArgumentException;

        int processByte(byte b, byte[] bArr, int i) throws DataLengthException;

        int processBytes(byte[] bArr, int i, int i2, byte[] bArr2, int i3) throws DataLengthException;

        void updateAAD(byte[] bArr, int i, int i2);

        boolean wrapOnNoPadding();
    }

    public BaseBlockCipher(BlockCipher blockCipher) {
        this.availableSpecs = new Class[]{RC2ParameterSpec.class, RC5ParameterSpec.class, gcmSpecClass, GOST28147ParameterSpec.class, IvParameterSpec.class, PBEParameterSpec.class};
        this.scheme = -1;
        this.ivLength = 0;
        this.fixedIv = true;
        this.pbeSpec = null;
        this.pbeAlgorithm = null;
        this.modeName = null;
        this.baseEngine = blockCipher;
        this.cipher = new BufferedGenericBlockCipher(blockCipher);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ParametersWithSBox} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ParametersWithIV} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v9, resolved type: com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ParametersWithSBox} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v10, resolved type: com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ParametersWithSBox} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v11, resolved type: com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ParametersWithSBox} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.fis.ekyc.nfc.build_in.bouncycastle.crypto.CipherParameters adjustParameters(java.security.spec.AlgorithmParameterSpec r4, com.fis.ekyc.nfc.build_in.bouncycastle.crypto.CipherParameters r5) {
        /*
            r3 = this;
            boolean r0 = r5 instanceof com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ParametersWithIV
            if (r0 == 0) goto L_0x0044
            r0 = r5
            com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ParametersWithIV r0 = (com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ParametersWithIV) r0
            com.fis.ekyc.nfc.build_in.bouncycastle.crypto.CipherParameters r0 = r0.getParameters()
            boolean r1 = r4 instanceof javax.crypto.spec.IvParameterSpec
            if (r1 == 0) goto L_0x001d
            javax.crypto.spec.IvParameterSpec r4 = (javax.crypto.spec.IvParameterSpec) r4
            com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ParametersWithIV r5 = new com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ParametersWithIV
            byte[] r4 = r4.getIV()
            r5.<init>(r0, r4)
            r3.ivParam = r5
            goto L_0x0079
        L_0x001d:
            boolean r1 = r4 instanceof com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.spec.GOST28147ParameterSpec
            if (r1 == 0) goto L_0x0079
            com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.spec.GOST28147ParameterSpec r4 = (com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.spec.GOST28147ParameterSpec) r4
            com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ParametersWithSBox r1 = new com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ParametersWithSBox
            byte[] r2 = r4.getSbox()
            r1.<init>(r5, r2)
            byte[] r5 = r4.getIV()
            if (r5 == 0) goto L_0x0042
            int r5 = r3.ivLength
            if (r5 == 0) goto L_0x0042
            com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ParametersWithIV r5 = new com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ParametersWithIV
            byte[] r4 = r4.getIV()
            r5.<init>(r0, r4)
            r3.ivParam = r5
            goto L_0x0079
        L_0x0042:
            r5 = r1
            goto L_0x0079
        L_0x0044:
            boolean r0 = r4 instanceof javax.crypto.spec.IvParameterSpec
            if (r0 == 0) goto L_0x0057
            javax.crypto.spec.IvParameterSpec r4 = (javax.crypto.spec.IvParameterSpec) r4
            com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ParametersWithIV r0 = new com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ParametersWithIV
            byte[] r4 = r4.getIV()
            r0.<init>(r5, r4)
            r3.ivParam = r0
        L_0x0055:
            r5 = r0
            goto L_0x0079
        L_0x0057:
            boolean r0 = r4 instanceof com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.spec.GOST28147ParameterSpec
            if (r0 == 0) goto L_0x0079
            com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.spec.GOST28147ParameterSpec r4 = (com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.spec.GOST28147ParameterSpec) r4
            com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ParametersWithSBox r0 = new com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ParametersWithSBox
            byte[] r1 = r4.getSbox()
            r0.<init>(r5, r1)
            byte[] r5 = r4.getIV()
            if (r5 == 0) goto L_0x0055
            int r5 = r3.ivLength
            if (r5 == 0) goto L_0x0055
            com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ParametersWithIV r5 = new com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ParametersWithIV
            byte[] r4 = r4.getIV()
            r5.<init>(r0, r4)
        L_0x0079:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.symmetric.util.BaseBlockCipher.adjustParameters(java.security.spec.AlgorithmParameterSpec, com.fis.ekyc.nfc.build_in.bouncycastle.crypto.CipherParameters):com.fis.ekyc.nfc.build_in.bouncycastle.crypto.CipherParameters");
    }

    private boolean isAEADModeName(String str) {
        if ("CCM".equals(str) || "EAX".equals(str) || "GCM".equals(str) || "OCB".equals(str)) {
            return true;
        }
        return false;
    }

    public byte[] engineDoFinal(byte[] bArr, int i, int i2) throws IllegalBlockSizeException, BadPaddingException {
        int engineGetOutputSize = engineGetOutputSize(i2);
        byte[] bArr2 = new byte[engineGetOutputSize];
        int processBytes = i2 != 0 ? this.cipher.processBytes(bArr, i, i2, bArr2, 0) : 0;
        try {
            int doFinal = processBytes + this.cipher.doFinal(bArr2, processBytes);
            if (doFinal == engineGetOutputSize) {
                return bArr2;
            }
            if (doFinal <= engineGetOutputSize) {
                byte[] bArr3 = new byte[doFinal];
                System.arraycopy(bArr2, 0, bArr3, 0, doFinal);
                return bArr3;
            }
            throw new IllegalBlockSizeException("internal buffer overflow");
        } catch (DataLengthException e) {
            throw new IllegalBlockSizeException(e.getMessage());
        }
    }

    public int engineGetBlockSize() {
        BlockCipher blockCipher = this.baseEngine;
        if (blockCipher == null) {
            return -1;
        }
        return blockCipher.getBlockSize();
    }

    public byte[] engineGetIV() {
        AEADParameters aEADParameters = this.aeadParams;
        if (aEADParameters != null) {
            return aEADParameters.getNonce();
        }
        ParametersWithIV parametersWithIV = this.ivParam;
        if (parametersWithIV != null) {
            return parametersWithIV.getIV();
        }
        return null;
    }

    public int engineGetKeySize(Key key) {
        return key.getEncoded().length * 8;
    }

    public int engineGetOutputSize(int i) {
        return this.cipher.getOutputSize(i);
    }

    public AlgorithmParameters engineGetParameters() {
        if (this.engineParams == null) {
            if (this.pbeSpec != null) {
                try {
                    AlgorithmParameters createParametersInstance = createParametersInstance(this.pbeAlgorithm);
                    this.engineParams = createParametersInstance;
                    createParametersInstance.init(this.pbeSpec);
                } catch (Exception unused) {
                    return null;
                }
            } else if (this.aeadParams != null) {
                if (this.baseEngine == null) {
                    try {
                        AlgorithmParameters createParametersInstance2 = createParametersInstance(PKCSObjectIdentifiers.id_alg_AEADChaCha20Poly1305.getId());
                        this.engineParams = createParametersInstance2;
                        createParametersInstance2.init(new DEROctetString(this.aeadParams.getNonce()).getEncoded());
                    } catch (Exception e) {
                        throw new RuntimeException(e.toString());
                    }
                } else {
                    try {
                        AlgorithmParameters createParametersInstance3 = createParametersInstance("GCM");
                        this.engineParams = createParametersInstance3;
                        createParametersInstance3.init(new GCMParameters(this.aeadParams.getNonce(), this.aeadParams.getMacSize() / 8).getEncoded());
                    } catch (Exception e2) {
                        throw new RuntimeException(e2.toString());
                    }
                }
            } else if (this.ivParam != null) {
                String algorithmName = this.cipher.getUnderlyingCipher().getAlgorithmName();
                if (algorithmName.indexOf(47) >= 0) {
                    algorithmName = algorithmName.substring(0, algorithmName.indexOf(47));
                }
                try {
                    AlgorithmParameters createParametersInstance4 = createParametersInstance(algorithmName);
                    this.engineParams = createParametersInstance4;
                    createParametersInstance4.init(new IvParameterSpec(this.ivParam.getIV()));
                } catch (Exception e3) {
                    throw new RuntimeException(e3.toString());
                }
            }
        }
        return this.engineParams;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v3, resolved type: com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ParametersWithRandom} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v4, resolved type: com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ParametersWithRandom} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v5, resolved type: com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ParametersWithRandom} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v14, resolved type: com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ParametersWithIV} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v6, resolved type: com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ParametersWithRandom} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v11, resolved type: com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ParametersWithIV} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v43, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v45, resolved type: com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ParametersWithRandom} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v46, resolved type: com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ParametersWithRandom} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v47, resolved type: com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ParametersWithRandom} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v48, resolved type: com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ParametersWithRandom} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v49, resolved type: com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.AEADParameters} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v50, resolved type: com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.RC5Parameters} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v51, resolved type: com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.RC5Parameters} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v52, resolved type: com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.RC2Parameters} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v53, resolved type: com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.RC2Parameters} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v54, resolved type: com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ParametersWithSBox} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v55, resolved type: com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ParametersWithSBox} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v56, resolved type: com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ParametersWithIV} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v57, resolved type: com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.AEADParameters} */
    /* JADX WARNING: type inference failed for: r5v0 */
    /* JADX WARNING: type inference failed for: r5v1, types: [com.fis.ekyc.nfc.build_in.bouncycastle.crypto.CipherParameters] */
    /* JADX WARNING: type inference failed for: r5v2, types: [com.fis.ekyc.nfc.build_in.bouncycastle.crypto.CipherParameters] */
    /* JADX WARNING: type inference failed for: r5v58 */
    /* JADX WARNING: type inference failed for: r5v59 */
    /* JADX WARNING: type inference failed for: r5v61 */
    /* JADX WARNING: type inference failed for: r5v62 */
    /* JADX WARNING: type inference failed for: r5v63 */
    /* JADX WARNING: type inference failed for: r5v64 */
    /* JADX WARNING: type inference failed for: r5v65 */
    /* JADX WARNING: type inference failed for: r5v68 */
    /* JADX WARNING: type inference failed for: r5v69 */
    /* JADX WARNING: type inference failed for: r5v70 */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:233:0x04a3 A[Catch:{ IllegalArgumentException -> 0x048b, Exception -> 0x0489 }] */
    /* JADX WARNING: Removed duplicated region for block: B:243:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void engineInit(int r21, java.security.Key r22, java.security.spec.AlgorithmParameterSpec r23, java.security.SecureRandom r24) throws java.security.InvalidKeyException, java.security.InvalidAlgorithmParameterException {
        /*
            r20 = this;
            r1 = r20
            r0 = r21
            r2 = r22
            r3 = r23
            r4 = r24
            r5 = 0
            r1.pbeSpec = r5
            r1.pbeAlgorithm = r5
            r1.engineParams = r5
            r1.aeadParams = r5
            boolean r6 = r2 instanceof javax.crypto.SecretKey
            if (r6 != 0) goto L_0x0039
            java.security.InvalidKeyException r0 = new java.security.InvalidKeyException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Key for algorithm "
            r3.append(r4)
            if (r2 == 0) goto L_0x0029
            java.lang.String r5 = r22.getAlgorithm()
        L_0x0029:
            r3.append(r5)
            java.lang.String r2 = " not suitable for symmetric enryption."
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            r0.<init>(r2)
            throw r0
        L_0x0039:
            java.lang.String r6 = "RC5-64"
            if (r3 != 0) goto L_0x0054
            com.fis.ekyc.nfc.build_in.bouncycastle.crypto.BlockCipher r7 = r1.baseEngine
            if (r7 == 0) goto L_0x0054
            java.lang.String r7 = r7.getAlgorithmName()
            boolean r7 = r7.startsWith(r6)
            if (r7 != 0) goto L_0x004c
            goto L_0x0054
        L_0x004c:
            java.security.InvalidAlgorithmParameterException r0 = new java.security.InvalidAlgorithmParameterException
            java.lang.String r2 = "RC5 requires an RC5ParametersSpec to be passed in."
            r0.<init>(r2)
            throw r0
        L_0x0054:
            int r7 = r1.scheme
            java.lang.String r8 = "Algorithm requires a PBE key"
            r9 = 4
            r10 = 2
            r11 = 1
            if (r7 == r10) goto L_0x0174
            boolean r12 = r2 instanceof com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.PKCS12Key
            if (r12 == 0) goto L_0x0063
            goto L_0x0174
        L_0x0063:
            boolean r12 = r2 instanceof com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.PBKDF1Key
            if (r12 == 0) goto L_0x00b5
            r5 = r2
            com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.PBKDF1Key r5 = (com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.PBKDF1Key) r5
            boolean r7 = r3 instanceof javax.crypto.spec.PBEParameterSpec
            if (r7 == 0) goto L_0x0073
            r7 = r3
            javax.crypto.spec.PBEParameterSpec r7 = (javax.crypto.spec.PBEParameterSpec) r7
            r1.pbeSpec = r7
        L_0x0073:
            boolean r7 = r5 instanceof com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.PBKDF1KeyWithParameters
            if (r7 == 0) goto L_0x008d
            javax.crypto.spec.PBEParameterSpec r7 = r1.pbeSpec
            if (r7 != 0) goto L_0x008d
            javax.crypto.spec.PBEParameterSpec r7 = new javax.crypto.spec.PBEParameterSpec
            r8 = r5
            com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.PBKDF1KeyWithParameters r8 = (com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.PBKDF1KeyWithParameters) r8
            byte[] r12 = r8.getSalt()
            int r8 = r8.getIterationCount()
            r7.<init>(r12, r8)
            r1.pbeSpec = r7
        L_0x008d:
            byte[] r13 = r5.getEncoded()
            int r15 = r1.digest
            int r5 = r1.keySizeInBits
            int r7 = r1.ivLength
            int r17 = r7 * 8
            javax.crypto.spec.PBEParameterSpec r7 = r1.pbeSpec
            com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.symmetric.util.BaseBlockCipher$GenericBlockCipher r8 = r1.cipher
            java.lang.String r19 = r8.getAlgorithmName()
            r14 = 0
            r16 = r5
            r18 = r7
            com.fis.ekyc.nfc.build_in.bouncycastle.crypto.CipherParameters r5 = com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.symmetric.util.PBE.Util.makePBEParameters(r13, r14, r15, r16, r17, r18, r19)
            boolean r7 = r5 instanceof com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ParametersWithIV
            if (r7 == 0) goto L_0x0211
            r7 = r5
            com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ParametersWithIV r7 = (com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ParametersWithIV) r7
            r1.ivParam = r7
            goto L_0x0211
        L_0x00b5:
            boolean r12 = r2 instanceof com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.symmetric.util.BCPBEKey
            if (r12 == 0) goto L_0x010c
            r5 = r2
            com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.symmetric.util.BCPBEKey r5 = (com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.symmetric.util.BCPBEKey) r5
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier r7 = r5.getOID()
            if (r7 == 0) goto L_0x00cd
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier r7 = r5.getOID()
            java.lang.String r7 = r7.getId()
            r1.pbeAlgorithm = r7
            goto L_0x00d3
        L_0x00cd:
            java.lang.String r7 = r5.getAlgorithm()
            r1.pbeAlgorithm = r7
        L_0x00d3:
            com.fis.ekyc.nfc.build_in.bouncycastle.crypto.CipherParameters r7 = r5.getParam()
            if (r7 == 0) goto L_0x00e2
            com.fis.ekyc.nfc.build_in.bouncycastle.crypto.CipherParameters r5 = r5.getParam()
            com.fis.ekyc.nfc.build_in.bouncycastle.crypto.CipherParameters r5 = r1.adjustParameters(r3, r5)
            goto L_0x00f9
        L_0x00e2:
            boolean r7 = r3 instanceof javax.crypto.spec.PBEParameterSpec
            if (r7 == 0) goto L_0x0104
            r7 = r3
            javax.crypto.spec.PBEParameterSpec r7 = (javax.crypto.spec.PBEParameterSpec) r7
            r1.pbeSpec = r7
            com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.symmetric.util.BaseBlockCipher$GenericBlockCipher r7 = r1.cipher
            com.fis.ekyc.nfc.build_in.bouncycastle.crypto.BlockCipher r7 = r7.getUnderlyingCipher()
            java.lang.String r7 = r7.getAlgorithmName()
            com.fis.ekyc.nfc.build_in.bouncycastle.crypto.CipherParameters r5 = com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.symmetric.util.PBE.Util.makePBEParameters(r5, r3, r7)
        L_0x00f9:
            boolean r7 = r5 instanceof com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ParametersWithIV
            if (r7 == 0) goto L_0x0211
            r7 = r5
            com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ParametersWithIV r7 = (com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ParametersWithIV) r7
            r1.ivParam = r7
            goto L_0x0211
        L_0x0104:
            java.security.InvalidAlgorithmParameterException r0 = new java.security.InvalidAlgorithmParameterException
            java.lang.String r2 = "PBE requires PBE parameters to be set."
            r0.<init>(r2)
            throw r0
        L_0x010c:
            boolean r12 = r2 instanceof javax.crypto.interfaces.PBEKey
            if (r12 == 0) goto L_0x0156
            r5 = r2
            javax.crypto.interfaces.PBEKey r5 = (javax.crypto.interfaces.PBEKey) r5
            r7 = r3
            javax.crypto.spec.PBEParameterSpec r7 = (javax.crypto.spec.PBEParameterSpec) r7
            r1.pbeSpec = r7
            boolean r8 = r5 instanceof com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.PKCS12KeyWithParameters
            if (r8 == 0) goto L_0x012d
            if (r7 != 0) goto L_0x012d
            javax.crypto.spec.PBEParameterSpec r7 = new javax.crypto.spec.PBEParameterSpec
            byte[] r8 = r5.getSalt()
            int r12 = r5.getIterationCount()
            r7.<init>(r8, r12)
            r1.pbeSpec = r7
        L_0x012d:
            byte[] r13 = r5.getEncoded()
            int r14 = r1.scheme
            int r15 = r1.digest
            int r5 = r1.keySizeInBits
            int r7 = r1.ivLength
            int r17 = r7 * 8
            javax.crypto.spec.PBEParameterSpec r7 = r1.pbeSpec
            com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.symmetric.util.BaseBlockCipher$GenericBlockCipher r8 = r1.cipher
            java.lang.String r19 = r8.getAlgorithmName()
            r16 = r5
            r18 = r7
            com.fis.ekyc.nfc.build_in.bouncycastle.crypto.CipherParameters r5 = com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.symmetric.util.PBE.Util.makePBEParameters(r13, r14, r15, r16, r17, r18, r19)
            boolean r7 = r5 instanceof com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ParametersWithIV
            if (r7 == 0) goto L_0x0211
            r7 = r5
            com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ParametersWithIV r7 = (com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ParametersWithIV) r7
            r1.ivParam = r7
            goto L_0x0211
        L_0x0156:
            boolean r12 = r2 instanceof com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.spec.RepeatedSecretKeySpec
            if (r12 != 0) goto L_0x0211
            if (r7 == 0) goto L_0x016e
            if (r7 == r9) goto L_0x016e
            if (r7 == r11) goto L_0x016e
            r5 = 5
            if (r7 == r5) goto L_0x016e
            com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.KeyParameter r5 = new com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.KeyParameter
            byte[] r7 = r22.getEncoded()
            r5.<init>(r7)
            goto L_0x0211
        L_0x016e:
            java.security.InvalidKeyException r0 = new java.security.InvalidKeyException
            r0.<init>(r8)
            throw r0
        L_0x0174:
            r5 = r2
            javax.crypto.SecretKey r5 = (javax.crypto.SecretKey) r5     // Catch:{ Exception -> 0x04da }
            boolean r7 = r3 instanceof javax.crypto.spec.PBEParameterSpec
            if (r7 == 0) goto L_0x0180
            r7 = r3
            javax.crypto.spec.PBEParameterSpec r7 = (javax.crypto.spec.PBEParameterSpec) r7
            r1.pbeSpec = r7
        L_0x0180:
            boolean r7 = r5 instanceof javax.crypto.interfaces.PBEKey
            if (r7 == 0) goto L_0x01a9
            javax.crypto.spec.PBEParameterSpec r12 = r1.pbeSpec
            if (r12 != 0) goto L_0x01a9
            r12 = r5
            javax.crypto.interfaces.PBEKey r12 = (javax.crypto.interfaces.PBEKey) r12
            byte[] r13 = r12.getSalt()
            if (r13 == 0) goto L_0x01a1
            javax.crypto.spec.PBEParameterSpec r13 = new javax.crypto.spec.PBEParameterSpec
            byte[] r14 = r12.getSalt()
            int r12 = r12.getIterationCount()
            r13.<init>(r14, r12)
            r1.pbeSpec = r13
            goto L_0x01a9
        L_0x01a1:
            java.security.InvalidAlgorithmParameterException r0 = new java.security.InvalidAlgorithmParameterException
            java.lang.String r2 = "PBEKey requires parameters to specify salt"
            r0.<init>(r2)
            throw r0
        L_0x01a9:
            javax.crypto.spec.PBEParameterSpec r12 = r1.pbeSpec
            if (r12 != 0) goto L_0x01b6
            if (r7 == 0) goto L_0x01b0
            goto L_0x01b6
        L_0x01b0:
            java.security.InvalidKeyException r0 = new java.security.InvalidKeyException
            r0.<init>(r8)
            throw r0
        L_0x01b6:
            boolean r7 = r2 instanceof com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.symmetric.util.BCPBEKey
            if (r7 == 0) goto L_0x01ed
            r7 = r2
            com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.symmetric.util.BCPBEKey r7 = (com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.symmetric.util.BCPBEKey) r7
            com.fis.ekyc.nfc.build_in.bouncycastle.crypto.CipherParameters r7 = r7.getParam()
            boolean r8 = r7 instanceof com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ParametersWithIV
            if (r8 == 0) goto L_0x01c6
            goto L_0x01e3
        L_0x01c6:
            if (r7 != 0) goto L_0x01e5
            byte[] r12 = r5.getEncoded()
            int r14 = r1.digest
            int r15 = r1.keySizeInBits
            int r5 = r1.ivLength
            int r16 = r5 * 8
            javax.crypto.spec.PBEParameterSpec r5 = r1.pbeSpec
            com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.symmetric.util.BaseBlockCipher$GenericBlockCipher r7 = r1.cipher
            java.lang.String r18 = r7.getAlgorithmName()
            r13 = 2
            r17 = r5
            com.fis.ekyc.nfc.build_in.bouncycastle.crypto.CipherParameters r7 = com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.symmetric.util.PBE.Util.makePBEParameters(r12, r13, r14, r15, r16, r17, r18)
        L_0x01e3:
            r5 = r7
            goto L_0x0208
        L_0x01e5:
            java.security.InvalidKeyException r0 = new java.security.InvalidKeyException
            java.lang.String r2 = "Algorithm requires a PBE key suitable for PKCS12"
            r0.<init>(r2)
            throw r0
        L_0x01ed:
            byte[] r12 = r5.getEncoded()
            int r14 = r1.digest
            int r15 = r1.keySizeInBits
            int r5 = r1.ivLength
            int r16 = r5 * 8
            javax.crypto.spec.PBEParameterSpec r5 = r1.pbeSpec
            com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.symmetric.util.BaseBlockCipher$GenericBlockCipher r7 = r1.cipher
            java.lang.String r18 = r7.getAlgorithmName()
            r13 = 2
            r17 = r5
            com.fis.ekyc.nfc.build_in.bouncycastle.crypto.CipherParameters r5 = com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.symmetric.util.PBE.Util.makePBEParameters(r12, r13, r14, r15, r16, r17, r18)
        L_0x0208:
            boolean r7 = r5 instanceof com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ParametersWithIV
            if (r7 == 0) goto L_0x0211
            r7 = r5
            com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ParametersWithIV r7 = (com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ParametersWithIV) r7
            r1.ivParam = r7
        L_0x0211:
            boolean r7 = r3 instanceof com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.spec.AEADParameterSpec
            if (r7 == 0) goto L_0x0254
            java.lang.String r2 = r1.modeName
            boolean r2 = r1.isAEADModeName(r2)
            if (r2 != 0) goto L_0x022c
            com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.symmetric.util.BaseBlockCipher$GenericBlockCipher r2 = r1.cipher
            boolean r2 = r2 instanceof com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.symmetric.util.BaseBlockCipher.AEADGenericBlockCipher
            if (r2 == 0) goto L_0x0224
            goto L_0x022c
        L_0x0224:
            java.security.InvalidAlgorithmParameterException r0 = new java.security.InvalidAlgorithmParameterException
            java.lang.String r2 = "AEADParameterSpec can only be used with AEAD modes."
            r0.<init>(r2)
            throw r0
        L_0x022c:
            r2 = r3
            com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.spec.AEADParameterSpec r2 = (com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.spec.AEADParameterSpec) r2
            boolean r3 = r5 instanceof com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ParametersWithIV
            if (r3 == 0) goto L_0x023c
            com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ParametersWithIV r5 = (com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ParametersWithIV) r5
            com.fis.ekyc.nfc.build_in.bouncycastle.crypto.CipherParameters r3 = r5.getParameters()
            com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.KeyParameter r3 = (com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.KeyParameter) r3
            goto L_0x023f
        L_0x023c:
            r3 = r5
            com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.KeyParameter r3 = (com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.KeyParameter) r3
        L_0x023f:
            com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.AEADParameters r5 = new com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.AEADParameters
            int r6 = r2.getMacSizeInBits()
            byte[] r7 = r2.getNonce()
            byte[] r2 = r2.getAssociatedData()
            r5.<init>(r3, r6, r7, r2)
            r1.aeadParams = r5
            goto L_0x0414
        L_0x0254:
            boolean r7 = r3 instanceof javax.crypto.spec.IvParameterSpec
            if (r7 == 0) goto L_0x02ca
            int r2 = r1.ivLength
            if (r2 == 0) goto L_0x02b4
            r2 = r3
            javax.crypto.spec.IvParameterSpec r2 = (javax.crypto.spec.IvParameterSpec) r2
            byte[] r3 = r2.getIV()
            int r3 = r3.length
            int r6 = r1.ivLength
            if (r3 == r6) goto L_0x0291
            com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.symmetric.util.BaseBlockCipher$GenericBlockCipher r3 = r1.cipher
            boolean r3 = r3 instanceof com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.symmetric.util.BaseBlockCipher.AEADGenericBlockCipher
            if (r3 != 0) goto L_0x0291
            boolean r3 = r1.fixedIv
            if (r3 != 0) goto L_0x0273
            goto L_0x0291
        L_0x0273:
            java.security.InvalidAlgorithmParameterException r0 = new java.security.InvalidAlgorithmParameterException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "IV must be "
            r2.append(r3)
            int r3 = r1.ivLength
            r2.append(r3)
            java.lang.String r3 = " bytes long."
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r0.<init>(r2)
            throw r0
        L_0x0291:
            boolean r3 = r5 instanceof com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ParametersWithIV
            if (r3 == 0) goto L_0x02a6
            com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ParametersWithIV r3 = new com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ParametersWithIV
            com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ParametersWithIV r5 = (com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ParametersWithIV) r5
            com.fis.ekyc.nfc.build_in.bouncycastle.crypto.CipherParameters r5 = r5.getParameters()
            byte[] r2 = r2.getIV()
            r3.<init>(r5, r2)
        L_0x02a4:
            r5 = r3
            goto L_0x02b0
        L_0x02a6:
            com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ParametersWithIV r3 = new com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ParametersWithIV
            byte[] r2 = r2.getIV()
            r3.<init>(r5, r2)
            goto L_0x02a4
        L_0x02b0:
            r1.ivParam = r5
            goto L_0x0414
        L_0x02b4:
            java.lang.String r2 = r1.modeName
            if (r2 == 0) goto L_0x0414
            java.lang.String r3 = "ECB"
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L_0x02c2
            goto L_0x0414
        L_0x02c2:
            java.security.InvalidAlgorithmParameterException r0 = new java.security.InvalidAlgorithmParameterException
            java.lang.String r2 = "ECB mode does not use an IV"
            r0.<init>(r2)
            throw r0
        L_0x02ca:
            boolean r7 = r3 instanceof com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.spec.GOST28147ParameterSpec
            if (r7 == 0) goto L_0x02fa
            com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.spec.GOST28147ParameterSpec r3 = (com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.spec.GOST28147ParameterSpec) r3
            com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ParametersWithSBox r5 = new com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ParametersWithSBox
            com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.KeyParameter r6 = new com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.KeyParameter
            byte[] r2 = r22.getEncoded()
            r6.<init>(r2)
            byte[] r2 = r3.getSbox()
            r5.<init>(r6, r2)
            byte[] r2 = r3.getIV()
            if (r2 == 0) goto L_0x0414
            int r2 = r1.ivLength
            if (r2 == 0) goto L_0x0414
            com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ParametersWithIV r2 = new com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ParametersWithIV
            byte[] r3 = r3.getIV()
            r2.<init>(r5, r3)
            r1.ivParam = r2
        L_0x02f7:
            r5 = r2
            goto L_0x0414
        L_0x02fa:
            boolean r7 = r3 instanceof javax.crypto.spec.RC2ParameterSpec
            if (r7 == 0) goto L_0x0323
            javax.crypto.spec.RC2ParameterSpec r3 = (javax.crypto.spec.RC2ParameterSpec) r3
            com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.RC2Parameters r5 = new com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.RC2Parameters
            byte[] r2 = r22.getEncoded()
            int r6 = r3.getEffectiveKeyBits()
            r5.<init>(r2, r6)
            byte[] r2 = r3.getIV()
            if (r2 == 0) goto L_0x0414
            int r2 = r1.ivLength
            if (r2 == 0) goto L_0x0414
            com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ParametersWithIV r2 = new com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ParametersWithIV
            byte[] r3 = r3.getIV()
            r2.<init>(r5, r3)
            r1.ivParam = r2
            goto L_0x02f7
        L_0x0323:
            boolean r7 = r3 instanceof javax.crypto.spec.RC5ParameterSpec
            if (r7 == 0) goto L_0x03cd
            javax.crypto.spec.RC5ParameterSpec r3 = (javax.crypto.spec.RC5ParameterSpec) r3
            com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.RC5Parameters r5 = new com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.RC5Parameters
            byte[] r2 = r22.getEncoded()
            int r7 = r3.getRounds()
            r5.<init>(r2, r7)
            com.fis.ekyc.nfc.build_in.bouncycastle.crypto.BlockCipher r2 = r1.baseEngine
            java.lang.String r2 = r2.getAlgorithmName()
            java.lang.String r7 = "RC5"
            boolean r2 = r2.startsWith(r7)
            if (r2 == 0) goto L_0x03c5
            com.fis.ekyc.nfc.build_in.bouncycastle.crypto.BlockCipher r2 = r1.baseEngine
            java.lang.String r2 = r2.getAlgorithmName()
            java.lang.String r7 = "RC5-32"
            boolean r2 = r2.equals(r7)
            java.lang.String r7 = "."
            if (r2 == 0) goto L_0x037b
            int r2 = r3.getWordSize()
            r6 = 32
            if (r2 != r6) goto L_0x035d
            goto L_0x03ae
        L_0x035d:
            java.security.InvalidAlgorithmParameterException r0 = new java.security.InvalidAlgorithmParameterException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = "RC5 already set up for a word size of 32 not "
            r2.append(r4)
            int r3 = r3.getWordSize()
            r2.append(r3)
            r2.append(r7)
            java.lang.String r2 = r2.toString()
            r0.<init>(r2)
            throw r0
        L_0x037b:
            com.fis.ekyc.nfc.build_in.bouncycastle.crypto.BlockCipher r2 = r1.baseEngine
            java.lang.String r2 = r2.getAlgorithmName()
            boolean r2 = r2.equals(r6)
            if (r2 == 0) goto L_0x03ae
            int r2 = r3.getWordSize()
            r6 = 64
            if (r2 != r6) goto L_0x0390
            goto L_0x03ae
        L_0x0390:
            java.security.InvalidAlgorithmParameterException r0 = new java.security.InvalidAlgorithmParameterException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = "RC5 already set up for a word size of 64 not "
            r2.append(r4)
            int r3 = r3.getWordSize()
            r2.append(r3)
            r2.append(r7)
            java.lang.String r2 = r2.toString()
            r0.<init>(r2)
            throw r0
        L_0x03ae:
            byte[] r2 = r3.getIV()
            if (r2 == 0) goto L_0x0414
            int r2 = r1.ivLength
            if (r2 == 0) goto L_0x0414
            com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ParametersWithIV r2 = new com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ParametersWithIV
            byte[] r3 = r3.getIV()
            r2.<init>(r5, r3)
            r1.ivParam = r2
            goto L_0x02f7
        L_0x03c5:
            java.security.InvalidAlgorithmParameterException r0 = new java.security.InvalidAlgorithmParameterException
            java.lang.String r2 = "RC5 parameters passed to a cipher that is not RC5."
            r0.<init>(r2)
            throw r0
        L_0x03cd:
            java.lang.Class r2 = gcmSpecClass
            if (r2 == 0) goto L_0x0405
            boolean r2 = r2.isInstance(r3)
            if (r2 == 0) goto L_0x0405
            java.lang.String r2 = r1.modeName
            boolean r2 = r1.isAEADModeName(r2)
            if (r2 != 0) goto L_0x03ee
            com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.symmetric.util.BaseBlockCipher$GenericBlockCipher r2 = r1.cipher
            boolean r2 = r2 instanceof com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.symmetric.util.BaseBlockCipher.AEADGenericBlockCipher
            if (r2 == 0) goto L_0x03e6
            goto L_0x03ee
        L_0x03e6:
            java.security.InvalidAlgorithmParameterException r0 = new java.security.InvalidAlgorithmParameterException
            java.lang.String r2 = "GCMParameterSpec can only be used with AEAD modes."
            r0.<init>(r2)
            throw r0
        L_0x03ee:
            boolean r2 = r5 instanceof com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ParametersWithIV
            if (r2 == 0) goto L_0x03fb
            com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ParametersWithIV r5 = (com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ParametersWithIV) r5
            com.fis.ekyc.nfc.build_in.bouncycastle.crypto.CipherParameters r2 = r5.getParameters()
            com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.KeyParameter r2 = (com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.KeyParameter) r2
            goto L_0x03fe
        L_0x03fb:
            r2 = r5
            com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.KeyParameter r2 = (com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.KeyParameter) r2
        L_0x03fe:
            com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.AEADParameters r5 = com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.symmetric.util.GcmSpecUtil.extractAeadParameters(r2, r3)
            r1.aeadParams = r5
            goto L_0x0414
        L_0x0405:
            if (r3 == 0) goto L_0x0414
            boolean r2 = r3 instanceof javax.crypto.spec.PBEParameterSpec
            if (r2 == 0) goto L_0x040c
            goto L_0x0414
        L_0x040c:
            java.security.InvalidAlgorithmParameterException r0 = new java.security.InvalidAlgorithmParameterException
            java.lang.String r2 = "unknown parameter type."
            r0.<init>(r2)
            throw r0
        L_0x0414:
            int r2 = r1.ivLength
            r3 = 3
            if (r2 == 0) goto L_0x0458
            boolean r2 = r5 instanceof com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ParametersWithIV
            if (r2 != 0) goto L_0x0458
            boolean r2 = r5 instanceof com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.AEADParameters
            if (r2 != 0) goto L_0x0458
            if (r4 != 0) goto L_0x0428
            java.security.SecureRandom r2 = com.fis.ekyc.nfc.build_in.bouncycastle.crypto.CryptoServicesRegistrar.getSecureRandom()
            goto L_0x0429
        L_0x0428:
            r2 = r4
        L_0x0429:
            if (r0 == r11) goto L_0x0449
            if (r0 != r3) goto L_0x042e
            goto L_0x0449
        L_0x042e:
            com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.symmetric.util.BaseBlockCipher$GenericBlockCipher r2 = r1.cipher
            com.fis.ekyc.nfc.build_in.bouncycastle.crypto.BlockCipher r2 = r2.getUnderlyingCipher()
            java.lang.String r2 = r2.getAlgorithmName()
            java.lang.String r6 = "PGPCFB"
            int r2 = r2.indexOf(r6)
            if (r2 < 0) goto L_0x0441
            goto L_0x0458
        L_0x0441:
            java.security.InvalidAlgorithmParameterException r0 = new java.security.InvalidAlgorithmParameterException
            java.lang.String r2 = "no IV set when one expected"
            r0.<init>(r2)
            throw r0
        L_0x0449:
            int r6 = r1.ivLength
            byte[] r6 = new byte[r6]
            r2.nextBytes(r6)
            com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ParametersWithIV r2 = new com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ParametersWithIV
            r2.<init>(r5, r6)
            r1.ivParam = r2
            r5 = r2
        L_0x0458:
            if (r4 == 0) goto L_0x0464
            boolean r2 = r1.padded
            if (r2 == 0) goto L_0x0464
            com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ParametersWithRandom r2 = new com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ParametersWithRandom
            r2.<init>(r5, r4)
            r5 = r2
        L_0x0464:
            if (r0 == r11) goto L_0x0494
            if (r0 == r10) goto L_0x048d
            if (r0 == r3) goto L_0x0494
            if (r0 != r9) goto L_0x046d
            goto L_0x048d
        L_0x046d:
            java.security.InvalidParameterException r2 = new java.security.InvalidParameterException     // Catch:{ IllegalArgumentException -> 0x048b, Exception -> 0x0489 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IllegalArgumentException -> 0x048b, Exception -> 0x0489 }
            r3.<init>()     // Catch:{ IllegalArgumentException -> 0x048b, Exception -> 0x0489 }
            java.lang.String r4 = "unknown opmode "
            r3.append(r4)     // Catch:{ IllegalArgumentException -> 0x048b, Exception -> 0x0489 }
            r3.append(r0)     // Catch:{ IllegalArgumentException -> 0x048b, Exception -> 0x0489 }
            java.lang.String r0 = " passed"
            r3.append(r0)     // Catch:{ IllegalArgumentException -> 0x048b, Exception -> 0x0489 }
            java.lang.String r0 = r3.toString()     // Catch:{ IllegalArgumentException -> 0x048b, Exception -> 0x0489 }
            r2.<init>(r0)     // Catch:{ IllegalArgumentException -> 0x048b, Exception -> 0x0489 }
            throw r2     // Catch:{ IllegalArgumentException -> 0x048b, Exception -> 0x0489 }
        L_0x0489:
            r0 = move-exception
            goto L_0x04c6
        L_0x048b:
            r0 = move-exception
            goto L_0x04d0
        L_0x048d:
            com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.symmetric.util.BaseBlockCipher$GenericBlockCipher r0 = r1.cipher     // Catch:{ IllegalArgumentException -> 0x048b, Exception -> 0x0489 }
            r2 = 0
            r0.init(r2, r5)     // Catch:{ IllegalArgumentException -> 0x048b, Exception -> 0x0489 }
            goto L_0x0499
        L_0x0494:
            com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.symmetric.util.BaseBlockCipher$GenericBlockCipher r0 = r1.cipher     // Catch:{ IllegalArgumentException -> 0x048b, Exception -> 0x0489 }
            r0.init(r11, r5)     // Catch:{ IllegalArgumentException -> 0x048b, Exception -> 0x0489 }
        L_0x0499:
            com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.symmetric.util.BaseBlockCipher$GenericBlockCipher r0 = r1.cipher     // Catch:{ IllegalArgumentException -> 0x048b, Exception -> 0x0489 }
            boolean r2 = r0 instanceof com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.symmetric.util.BaseBlockCipher.AEADGenericBlockCipher     // Catch:{ IllegalArgumentException -> 0x048b, Exception -> 0x0489 }
            if (r2 == 0) goto L_0x04c5
            com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.AEADParameters r2 = r1.aeadParams     // Catch:{ IllegalArgumentException -> 0x048b, Exception -> 0x0489 }
            if (r2 != 0) goto L_0x04c5
            com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.symmetric.util.BaseBlockCipher$AEADGenericBlockCipher r0 = (com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.symmetric.util.BaseBlockCipher.AEADGenericBlockCipher) r0     // Catch:{ IllegalArgumentException -> 0x048b, Exception -> 0x0489 }
            com.fis.ekyc.nfc.build_in.bouncycastle.crypto.modes.AEADCipher r0 = r0.cipher     // Catch:{ IllegalArgumentException -> 0x048b, Exception -> 0x0489 }
            com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.AEADParameters r2 = new com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.AEADParameters     // Catch:{ IllegalArgumentException -> 0x048b, Exception -> 0x0489 }
            com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ParametersWithIV r3 = r1.ivParam     // Catch:{ IllegalArgumentException -> 0x048b, Exception -> 0x0489 }
            com.fis.ekyc.nfc.build_in.bouncycastle.crypto.CipherParameters r3 = r3.getParameters()     // Catch:{ IllegalArgumentException -> 0x048b, Exception -> 0x0489 }
            com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.KeyParameter r3 = (com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.KeyParameter) r3     // Catch:{ IllegalArgumentException -> 0x048b, Exception -> 0x0489 }
            byte[] r0 = r0.getMac()     // Catch:{ IllegalArgumentException -> 0x048b, Exception -> 0x0489 }
            int r0 = r0.length     // Catch:{ IllegalArgumentException -> 0x048b, Exception -> 0x0489 }
            int r0 = r0 * 8
            com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.ParametersWithIV r4 = r1.ivParam     // Catch:{ IllegalArgumentException -> 0x048b, Exception -> 0x0489 }
            byte[] r4 = r4.getIV()     // Catch:{ IllegalArgumentException -> 0x048b, Exception -> 0x0489 }
            r2.<init>(r3, r0, r4)     // Catch:{ IllegalArgumentException -> 0x048b, Exception -> 0x0489 }
            r1.aeadParams = r2     // Catch:{ IllegalArgumentException -> 0x048b, Exception -> 0x0489 }
        L_0x04c5:
            return
        L_0x04c6:
            com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.symmetric.util.BaseWrapCipher$InvalidKeyOrParametersException r2 = new com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.symmetric.util.BaseWrapCipher$InvalidKeyOrParametersException
            java.lang.String r3 = r0.getMessage()
            r2.<init>(r3, r0)
            throw r2
        L_0x04d0:
            java.security.InvalidAlgorithmParameterException r2 = new java.security.InvalidAlgorithmParameterException
            java.lang.String r3 = r0.getMessage()
            r2.<init>(r3, r0)
            throw r2
        L_0x04da:
            java.security.InvalidKeyException r0 = new java.security.InvalidKeyException
            java.lang.String r2 = "PKCS12 requires a SecretKey/PBEKey"
            r0.<init>(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.symmetric.util.BaseBlockCipher.engineInit(int, java.security.Key, java.security.spec.AlgorithmParameterSpec, java.security.SecureRandom):void");
    }

    public void engineSetMode(String str) throws NoSuchAlgorithmException {
        if (this.baseEngine != null) {
            String upperCase = Strings.toUpperCase(str);
            this.modeName = upperCase;
            if (upperCase.equals("ECB")) {
                this.ivLength = 0;
                this.cipher = new BufferedGenericBlockCipher(this.baseEngine);
            } else if (this.modeName.equals("CBC")) {
                this.ivLength = this.baseEngine.getBlockSize();
                this.cipher = new BufferedGenericBlockCipher((BlockCipher) new CBCBlockCipher(this.baseEngine));
            } else if (this.modeName.startsWith("OFB")) {
                this.ivLength = this.baseEngine.getBlockSize();
                if (this.modeName.length() != 3) {
                    this.cipher = new BufferedGenericBlockCipher((BlockCipher) new OFBBlockCipher(this.baseEngine, Integer.parseInt(this.modeName.substring(3))));
                    return;
                }
                BlockCipher blockCipher = this.baseEngine;
                this.cipher = new BufferedGenericBlockCipher((BlockCipher) new OFBBlockCipher(blockCipher, blockCipher.getBlockSize() * 8));
            } else if (this.modeName.startsWith("CFB")) {
                this.ivLength = this.baseEngine.getBlockSize();
                if (this.modeName.length() != 3) {
                    this.cipher = new BufferedGenericBlockCipher((BlockCipher) new CFBBlockCipher(this.baseEngine, Integer.parseInt(this.modeName.substring(3))));
                    return;
                }
                BlockCipher blockCipher2 = this.baseEngine;
                this.cipher = new BufferedGenericBlockCipher((BlockCipher) new CFBBlockCipher(blockCipher2, blockCipher2.getBlockSize() * 8));
            } else if (this.modeName.startsWith("PGPCFB")) {
                boolean equals = this.modeName.equals("PGPCFBWITHIV");
                if (equals || this.modeName.length() == 6) {
                    this.ivLength = this.baseEngine.getBlockSize();
                    this.cipher = new BufferedGenericBlockCipher((BlockCipher) new PGPCFBBlockCipher(this.baseEngine, equals));
                    return;
                }
                throw new NoSuchAlgorithmException("no mode support for " + this.modeName);
            } else if (this.modeName.equals("OPENPGPCFB")) {
                this.ivLength = 0;
                this.cipher = new BufferedGenericBlockCipher((BlockCipher) new OpenPGPCFBBlockCipher(this.baseEngine));
            } else if (this.modeName.equals("SIC")) {
                int blockSize = this.baseEngine.getBlockSize();
                this.ivLength = blockSize;
                if (blockSize >= 16) {
                    this.fixedIv = false;
                    this.cipher = new BufferedGenericBlockCipher(new BufferedBlockCipher(new SICBlockCipher(this.baseEngine)));
                    return;
                }
                throw new IllegalArgumentException("Warning: SIC-Mode can become a twotime-pad if the blocksize of the cipher is too small. Use a cipher with a block size of at least 128 bits (e.g. AES)");
            } else if (this.modeName.equals("CTR")) {
                this.ivLength = this.baseEngine.getBlockSize();
                this.fixedIv = false;
                BlockCipher blockCipher3 = this.baseEngine;
                if (blockCipher3 instanceof DSTU7624Engine) {
                    this.cipher = new BufferedGenericBlockCipher(new BufferedBlockCipher(new KCTRBlockCipher(blockCipher3)));
                } else {
                    this.cipher = new BufferedGenericBlockCipher(new BufferedBlockCipher(new SICBlockCipher(blockCipher3)));
                }
            } else if (this.modeName.equals("GOFB")) {
                this.ivLength = this.baseEngine.getBlockSize();
                this.cipher = new BufferedGenericBlockCipher(new BufferedBlockCipher(new GOFBBlockCipher(this.baseEngine)));
            } else if (this.modeName.equals("GCFB")) {
                this.ivLength = this.baseEngine.getBlockSize();
                this.cipher = new BufferedGenericBlockCipher(new BufferedBlockCipher(new GCFBBlockCipher(this.baseEngine)));
            } else if (this.modeName.equals("CTS")) {
                this.ivLength = this.baseEngine.getBlockSize();
                this.cipher = new BufferedGenericBlockCipher((BufferedBlockCipher) new CTSBlockCipher(new CBCBlockCipher(this.baseEngine)));
            } else if (this.modeName.equals("CCM")) {
                this.ivLength = 12;
                if (this.baseEngine instanceof DSTU7624Engine) {
                    this.cipher = new AEADGenericBlockCipher(new KCCMBlockCipher(this.baseEngine));
                } else {
                    this.cipher = new AEADGenericBlockCipher(new CCMBlockCipher(this.baseEngine));
                }
            } else if (this.modeName.equals("OCB")) {
                if (this.engineProvider != null) {
                    this.ivLength = 15;
                    this.cipher = new AEADGenericBlockCipher(new OCBBlockCipher(this.baseEngine, this.engineProvider.get()));
                    return;
                }
                throw new NoSuchAlgorithmException("can't support mode " + str);
            } else if (this.modeName.equals("EAX")) {
                this.ivLength = this.baseEngine.getBlockSize();
                this.cipher = new AEADGenericBlockCipher(new EAXBlockCipher(this.baseEngine));
            } else if (this.modeName.equals("GCM")) {
                this.ivLength = this.baseEngine.getBlockSize();
                if (this.baseEngine instanceof DSTU7624Engine) {
                    this.cipher = new AEADGenericBlockCipher(new KGCMBlockCipher(this.baseEngine));
                } else {
                    this.cipher = new AEADGenericBlockCipher(new GCMBlockCipher(this.baseEngine));
                }
            } else {
                throw new NoSuchAlgorithmException("can't support mode " + str);
            }
        } else {
            throw new NoSuchAlgorithmException("no mode supported for this algorithm");
        }
    }

    public void engineSetPadding(String str) throws NoSuchPaddingException {
        if (this.baseEngine != null) {
            String upperCase = Strings.toUpperCase(str);
            if (upperCase.equals("NOPADDING")) {
                if (this.cipher.wrapOnNoPadding()) {
                    this.cipher = new BufferedGenericBlockCipher(new BufferedBlockCipher(this.cipher.getUnderlyingCipher()));
                }
            } else if (upperCase.equals("WITHCTS") || upperCase.equals("CTSPADDING") || upperCase.equals("CS3PADDING")) {
                this.cipher = new BufferedGenericBlockCipher((BufferedBlockCipher) new CTSBlockCipher(this.cipher.getUnderlyingCipher()));
            } else {
                this.padded = true;
                if (isAEADModeName(this.modeName)) {
                    throw new NoSuchPaddingException("Only NoPadding can be used with AEAD modes.");
                } else if (upperCase.equals("PKCS5PADDING") || upperCase.equals("PKCS7PADDING")) {
                    this.cipher = new BufferedGenericBlockCipher(this.cipher.getUnderlyingCipher());
                } else if (upperCase.equals("ZEROBYTEPADDING")) {
                    this.cipher = new BufferedGenericBlockCipher(this.cipher.getUnderlyingCipher(), new ZeroBytePadding());
                } else if (upperCase.equals("ISO10126PADDING") || upperCase.equals("ISO10126-2PADDING")) {
                    this.cipher = new BufferedGenericBlockCipher(this.cipher.getUnderlyingCipher(), new ISO10126d2Padding());
                } else if (upperCase.equals("X9.23PADDING") || upperCase.equals("X923PADDING")) {
                    this.cipher = new BufferedGenericBlockCipher(this.cipher.getUnderlyingCipher(), new X923Padding());
                } else if (upperCase.equals("ISO7816-4PADDING") || upperCase.equals("ISO9797-1PADDING")) {
                    this.cipher = new BufferedGenericBlockCipher(this.cipher.getUnderlyingCipher(), new ISO7816d4Padding());
                } else if (upperCase.equals("TBCPADDING")) {
                    this.cipher = new BufferedGenericBlockCipher(this.cipher.getUnderlyingCipher(), new TBCPadding());
                } else {
                    throw new NoSuchPaddingException("Padding " + str + " unknown.");
                }
            }
        } else {
            throw new NoSuchPaddingException("no padding supported for this algorithm");
        }
    }

    public byte[] engineUpdate(byte[] bArr, int i, int i2) {
        int updateOutputSize = this.cipher.getUpdateOutputSize(i2);
        if (updateOutputSize > 0) {
            byte[] bArr2 = new byte[updateOutputSize];
            int processBytes = this.cipher.processBytes(bArr, i, i2, bArr2, 0);
            if (processBytes == 0) {
                return null;
            }
            if (processBytes == updateOutputSize) {
                return bArr2;
            }
            byte[] bArr3 = new byte[processBytes];
            System.arraycopy(bArr2, 0, bArr3, 0, processBytes);
            return bArr3;
        }
        this.cipher.processBytes(bArr, i, i2, (byte[]) null, 0);
        return null;
    }

    public void engineUpdateAAD(byte[] bArr, int i, int i2) {
        this.cipher.updateAAD(bArr, i, i2);
    }

    public static class BufferedGenericBlockCipher implements GenericBlockCipher {
        private BufferedBlockCipher cipher;

        public BufferedGenericBlockCipher(BufferedBlockCipher bufferedBlockCipher) {
            this.cipher = bufferedBlockCipher;
        }

        public int doFinal(byte[] bArr, int i) throws IllegalStateException, BadPaddingException {
            try {
                return this.cipher.doFinal(bArr, i);
            } catch (InvalidCipherTextException e) {
                throw new BadPaddingException(e.getMessage());
            }
        }

        public String getAlgorithmName() {
            return this.cipher.getUnderlyingCipher().getAlgorithmName();
        }

        public int getOutputSize(int i) {
            return this.cipher.getOutputSize(i);
        }

        public BlockCipher getUnderlyingCipher() {
            return this.cipher.getUnderlyingCipher();
        }

        public int getUpdateOutputSize(int i) {
            return this.cipher.getUpdateOutputSize(i);
        }

        public void init(boolean z, CipherParameters cipherParameters) throws IllegalArgumentException {
            this.cipher.init(z, cipherParameters);
        }

        public int processByte(byte b, byte[] bArr, int i) throws DataLengthException {
            return this.cipher.processByte(b, bArr, i);
        }

        public int processBytes(byte[] bArr, int i, int i2, byte[] bArr2, int i3) throws DataLengthException {
            return this.cipher.processBytes(bArr, i, i2, bArr2, i3);
        }

        public void updateAAD(byte[] bArr, int i, int i2) {
            throw new UnsupportedOperationException("AAD is not supported in the current mode.");
        }

        public boolean wrapOnNoPadding() {
            return !(this.cipher instanceof CTSBlockCipher);
        }

        public BufferedGenericBlockCipher(BlockCipher blockCipher) {
            this.cipher = new PaddedBufferedBlockCipher(blockCipher);
        }

        public BufferedGenericBlockCipher(BlockCipher blockCipher, BlockCipherPadding blockCipherPadding) {
            this.cipher = new PaddedBufferedBlockCipher(blockCipher, blockCipherPadding);
        }
    }

    public void engineUpdateAAD(ByteBuffer byteBuffer) {
        int remaining = byteBuffer.remaining();
        if (remaining >= 1) {
            if (byteBuffer.hasArray()) {
                engineUpdateAAD(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), remaining);
                byteBuffer.position(byteBuffer.limit());
            } else if (remaining <= 512) {
                byte[] bArr = new byte[remaining];
                byteBuffer.get(bArr);
                engineUpdateAAD(bArr, 0, remaining);
                Arrays.fill(bArr, (byte) 0);
            } else {
                byte[] bArr2 = new byte[512];
                do {
                    int min = Math.min(512, remaining);
                    byteBuffer.get(bArr2, 0, min);
                    engineUpdateAAD(bArr2, 0, min);
                    remaining -= min;
                } while (remaining > 0);
                Arrays.fill(bArr2, (byte) 0);
            }
        }
    }

    public int engineUpdate(byte[] bArr, int i, int i2, byte[] bArr2, int i3) throws ShortBufferException {
        if (this.cipher.getUpdateOutputSize(i2) + i3 <= bArr2.length) {
            try {
                return this.cipher.processBytes(bArr, i, i2, bArr2, i3);
            } catch (DataLengthException e) {
                throw new IllegalStateException(e.toString());
            }
        } else {
            throw new ShortBufferException("output buffer too short for input.");
        }
    }

    public int engineDoFinal(byte[] bArr, int i, int i2, byte[] bArr2, int i3) throws IllegalBlockSizeException, BadPaddingException, ShortBufferException {
        int i4;
        if (engineGetOutputSize(i2) + i3 <= bArr2.length) {
            if (i2 != 0) {
                try {
                    i4 = this.cipher.processBytes(bArr, i, i2, bArr2, i3);
                } catch (OutputLengthException e) {
                    throw new IllegalBlockSizeException(e.getMessage());
                } catch (DataLengthException e2) {
                    throw new IllegalBlockSizeException(e2.getMessage());
                }
            } else {
                i4 = 0;
            }
            return i4 + this.cipher.doFinal(bArr2, i3 + i4);
        }
        throw new ShortBufferException("output buffer too short for input.");
    }

    public BaseBlockCipher(BlockCipher blockCipher, int i, int i2, int i3, int i4) {
        this.availableSpecs = new Class[]{RC2ParameterSpec.class, RC5ParameterSpec.class, gcmSpecClass, GOST28147ParameterSpec.class, IvParameterSpec.class, PBEParameterSpec.class};
        this.fixedIv = true;
        this.pbeSpec = null;
        this.pbeAlgorithm = null;
        this.modeName = null;
        this.baseEngine = blockCipher;
        this.scheme = i;
        this.digest = i2;
        this.keySizeInBits = i3;
        this.ivLength = i4;
        this.cipher = new BufferedGenericBlockCipher(blockCipher);
    }

    public BaseBlockCipher(BlockCipherProvider blockCipherProvider) {
        this.availableSpecs = new Class[]{RC2ParameterSpec.class, RC5ParameterSpec.class, gcmSpecClass, GOST28147ParameterSpec.class, IvParameterSpec.class, PBEParameterSpec.class};
        this.scheme = -1;
        this.ivLength = 0;
        this.fixedIv = true;
        this.pbeSpec = null;
        this.pbeAlgorithm = null;
        this.modeName = null;
        this.baseEngine = blockCipherProvider.get();
        this.engineProvider = blockCipherProvider;
        this.cipher = new BufferedGenericBlockCipher(blockCipherProvider.get());
    }

    public BaseBlockCipher(AEADBlockCipher aEADBlockCipher) {
        this.availableSpecs = new Class[]{RC2ParameterSpec.class, RC5ParameterSpec.class, gcmSpecClass, GOST28147ParameterSpec.class, IvParameterSpec.class, PBEParameterSpec.class};
        this.scheme = -1;
        this.ivLength = 0;
        this.fixedIv = true;
        this.pbeSpec = null;
        this.pbeAlgorithm = null;
        this.modeName = null;
        BlockCipher underlyingCipher = aEADBlockCipher.getUnderlyingCipher();
        this.baseEngine = underlyingCipher;
        this.ivLength = underlyingCipher.getBlockSize();
        this.cipher = new AEADGenericBlockCipher(aEADBlockCipher);
    }

    public BaseBlockCipher(AEADCipher aEADCipher, boolean z, int i) {
        this.availableSpecs = new Class[]{RC2ParameterSpec.class, RC5ParameterSpec.class, gcmSpecClass, GOST28147ParameterSpec.class, IvParameterSpec.class, PBEParameterSpec.class};
        this.scheme = -1;
        this.pbeSpec = null;
        this.pbeAlgorithm = null;
        this.modeName = null;
        this.baseEngine = null;
        this.fixedIv = z;
        this.ivLength = i;
        this.cipher = new AEADGenericBlockCipher(aEADCipher);
    }

    public BaseBlockCipher(AEADBlockCipher aEADBlockCipher, boolean z, int i) {
        this.availableSpecs = new Class[]{RC2ParameterSpec.class, RC5ParameterSpec.class, gcmSpecClass, GOST28147ParameterSpec.class, IvParameterSpec.class, PBEParameterSpec.class};
        this.scheme = -1;
        this.ivLength = 0;
        this.fixedIv = true;
        this.pbeSpec = null;
        this.pbeAlgorithm = null;
        this.modeName = null;
        this.baseEngine = aEADBlockCipher.getUnderlyingCipher();
        this.fixedIv = z;
        this.ivLength = i;
        this.cipher = new AEADGenericBlockCipher(aEADBlockCipher);
    }

    public BaseBlockCipher(BlockCipher blockCipher, int i) {
        this(blockCipher, true, i);
    }

    public BaseBlockCipher(BlockCipher blockCipher, boolean z, int i) {
        this.availableSpecs = new Class[]{RC2ParameterSpec.class, RC5ParameterSpec.class, gcmSpecClass, GOST28147ParameterSpec.class, IvParameterSpec.class, PBEParameterSpec.class};
        this.scheme = -1;
        this.ivLength = 0;
        this.pbeSpec = null;
        this.pbeAlgorithm = null;
        this.modeName = null;
        this.baseEngine = blockCipher;
        this.fixedIv = z;
        this.cipher = new BufferedGenericBlockCipher(blockCipher);
        this.ivLength = i / 8;
    }

    public BaseBlockCipher(BufferedBlockCipher bufferedBlockCipher, int i) {
        this(bufferedBlockCipher, true, i);
    }

    public BaseBlockCipher(BufferedBlockCipher bufferedBlockCipher, boolean z, int i) {
        this.availableSpecs = new Class[]{RC2ParameterSpec.class, RC5ParameterSpec.class, gcmSpecClass, GOST28147ParameterSpec.class, IvParameterSpec.class, PBEParameterSpec.class};
        this.scheme = -1;
        this.ivLength = 0;
        this.fixedIv = true;
        this.pbeSpec = null;
        this.pbeAlgorithm = null;
        this.modeName = null;
        this.baseEngine = bufferedBlockCipher.getUnderlyingCipher();
        this.cipher = new BufferedGenericBlockCipher(bufferedBlockCipher);
        this.fixedIv = z;
        this.ivLength = i / 8;
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
        engineInit(i, key, algorithmParameterSpec, secureRandom);
        this.engineParams = algorithmParameters;
    }

    public void engineInit(int i, Key key, SecureRandom secureRandom) throws InvalidKeyException {
        try {
            engineInit(i, key, (AlgorithmParameterSpec) null, secureRandom);
        } catch (InvalidAlgorithmParameterException e) {
            throw new InvalidKeyException(e.getMessage());
        }
    }
}
