package com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.sphincsplus;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.Digest;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.Xof;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.digests.SHA256Digest;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.digests.SHA512Digest;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.digests.SHAKEDigest;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.generators.MGF1BytesGenerator;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.macs.HMac;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.KeyParameter;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.MGFParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.Arrays;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.Pack;

abstract class SPHINCSPlusEngine {
    final int A;
    final int D;
    final int H;
    final int H_PRIME;
    final int K;
    final int N;
    final int T;
    final int WOTS_LEN;
    final int WOTS_LEN1;
    final int WOTS_LEN2;
    final int WOTS_LOGW;
    final int WOTS_W;
    final boolean robust;

    public static class Sha256Engine extends SPHINCSPlusEngine {
        private final byte[] digestBuf;
        private final byte[] hmacBuf;
        private final MGF1BytesGenerator mgf1;
        private final Digest msgDigest;
        private final byte[] padding = new byte[64];
        private final Digest treeDigest;
        private final HMac treeHMac;

        public Sha256Engine(boolean z, int i, int i2, int i3, int i4, int i5, int i6) {
            super(z, i, i2, i3, i4, i5, i6);
            SHA256Digest sHA256Digest = new SHA256Digest();
            this.treeDigest = sHA256Digest;
            if (i == 32) {
                this.msgDigest = new SHA512Digest();
                this.treeHMac = new HMac(new SHA512Digest());
                this.mgf1 = new MGF1BytesGenerator(new SHA512Digest());
            } else {
                this.msgDigest = new SHA256Digest();
                this.treeHMac = new HMac(new SHA256Digest());
                this.mgf1 = new MGF1BytesGenerator(new SHA256Digest());
            }
            this.digestBuf = new byte[sHA256Digest.getDigestSize()];
            this.hmacBuf = new byte[this.treeHMac.getMacSize()];
        }

        private byte[] compressedADRS(ADRS adrs) {
            byte[] bArr = new byte[22];
            System.arraycopy(adrs.value, 3, bArr, 0, 1);
            System.arraycopy(adrs.value, 8, bArr, 1, 8);
            System.arraycopy(adrs.value, 19, bArr, 9, 1);
            System.arraycopy(adrs.value, 20, bArr, 10, 12);
            return bArr;
        }

        public byte[] F(byte[] bArr, ADRS adrs, byte[] bArr2) {
            byte[] compressedADRS = compressedADRS(adrs);
            if (this.robust) {
                bArr2 = bitmask256(Arrays.concatenate(bArr, compressedADRS), bArr2);
            }
            this.treeDigest.update(bArr, 0, bArr.length);
            this.treeDigest.update(this.padding, 0, 64 - bArr.length);
            this.treeDigest.update(compressedADRS, 0, compressedADRS.length);
            this.treeDigest.update(bArr2, 0, bArr2.length);
            this.treeDigest.doFinal(this.digestBuf, 0);
            return Arrays.copyOfRange(this.digestBuf, 0, this.N);
        }

        public byte[] H(byte[] bArr, ADRS adrs, byte[] bArr2, byte[] bArr3) {
            byte[] concatenate = Arrays.concatenate(bArr2, bArr3);
            byte[] compressedADRS = compressedADRS(adrs);
            if (this.robust) {
                concatenate = bitmask256(Arrays.concatenate(bArr, compressedADRS), concatenate);
            }
            this.treeDigest.update(bArr, 0, bArr.length);
            this.treeDigest.update(this.padding, 0, 64 - this.N);
            this.treeDigest.update(compressedADRS, 0, compressedADRS.length);
            this.treeDigest.update(concatenate, 0, concatenate.length);
            this.treeDigest.doFinal(this.digestBuf, 0);
            return Arrays.copyOfRange(this.digestBuf, 0, this.N);
        }

        public IndexedDigest H_msg(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) {
            int i = ((this.A * this.K) + 7) / 8;
            int i2 = this.H;
            int i3 = i2 / this.D;
            int i4 = i2 - i3;
            int i5 = (i3 + 7) / 8;
            int i6 = (i4 + 7) / 8;
            byte[] bArr5 = new byte[this.msgDigest.getDigestSize()];
            this.msgDigest.update(bArr, 0, bArr.length);
            this.msgDigest.update(bArr2, 0, bArr2.length);
            this.msgDigest.update(bArr3, 0, bArr3.length);
            this.msgDigest.update(bArr4, 0, bArr4.length);
            this.msgDigest.doFinal(bArr5, 0);
            byte[] bitmask = bitmask(Arrays.concatenate(bArr, bArr2, bArr5), new byte[(i + i5 + i6)]);
            byte[] bArr6 = new byte[8];
            System.arraycopy(bitmask, i, bArr6, 8 - i6, i6);
            long bigEndianToLong = Pack.bigEndianToLong(bArr6, 0) & (-1 >>> (64 - i4));
            byte[] bArr7 = new byte[4];
            System.arraycopy(bitmask, i6 + i, bArr7, 4 - i5, i5);
            return new IndexedDigest(bigEndianToLong, Pack.bigEndianToInt(bArr7, 0) & (-1 >>> (32 - i3)), Arrays.copyOfRange(bitmask, 0, i));
        }

        public byte[] PRF(byte[] bArr, byte[] bArr2, ADRS adrs) {
            int length = bArr2.length;
            this.treeDigest.update(bArr2, 0, bArr2.length);
            byte[] compressedADRS = compressedADRS(adrs);
            this.treeDigest.update(compressedADRS, 0, compressedADRS.length);
            this.treeDigest.doFinal(this.digestBuf, 0);
            return Arrays.copyOfRange(this.digestBuf, 0, length);
        }

        public byte[] PRF_msg(byte[] bArr, byte[] bArr2, byte[] bArr3) {
            this.treeHMac.init(new KeyParameter(bArr));
            this.treeHMac.update(bArr2, 0, bArr2.length);
            this.treeHMac.update(bArr3, 0, bArr3.length);
            this.treeHMac.doFinal(this.hmacBuf, 0);
            return Arrays.copyOfRange(this.hmacBuf, 0, this.N);
        }

        public byte[] T_l(byte[] bArr, ADRS adrs, byte[] bArr2) {
            byte[] compressedADRS = compressedADRS(adrs);
            if (this.robust) {
                bArr2 = bitmask256(Arrays.concatenate(bArr, compressedADRS), bArr2);
            }
            this.treeDigest.update(bArr, 0, bArr.length);
            this.treeDigest.update(this.padding, 0, 64 - this.N);
            this.treeDigest.update(compressedADRS, 0, compressedADRS.length);
            this.treeDigest.update(bArr2, 0, bArr2.length);
            this.treeDigest.doFinal(this.digestBuf, 0);
            return Arrays.copyOfRange(this.digestBuf, 0, this.N);
        }

        public byte[] bitmask(byte[] bArr, byte[] bArr2) {
            int length = bArr2.length;
            byte[] bArr3 = new byte[length];
            this.mgf1.init(new MGFParameters(bArr));
            this.mgf1.generateBytes(bArr3, 0, length);
            for (int i = 0; i < bArr2.length; i++) {
                bArr3[i] = (byte) (bArr3[i] ^ bArr2[i]);
            }
            return bArr3;
        }

        public byte[] bitmask256(byte[] bArr, byte[] bArr2) {
            int length = bArr2.length;
            byte[] bArr3 = new byte[length];
            MGF1BytesGenerator mGF1BytesGenerator = new MGF1BytesGenerator(new SHA256Digest());
            mGF1BytesGenerator.init(new MGFParameters(bArr));
            mGF1BytesGenerator.generateBytes(bArr3, 0, length);
            for (int i = 0; i < bArr2.length; i++) {
                bArr3[i] = (byte) (bArr3[i] ^ bArr2[i]);
            }
            return bArr3;
        }
    }

    public static class Shake256Engine extends SPHINCSPlusEngine {
        private final Xof treeDigest = new SHAKEDigest(256);

        public Shake256Engine(boolean z, int i, int i2, int i3, int i4, int i5, int i6) {
            super(z, i, i2, i3, i4, i5, i6);
        }

        public byte[] F(byte[] bArr, ADRS adrs, byte[] bArr2) {
            if (this.robust) {
                bArr2 = bitmask(bArr, adrs, bArr2);
            }
            int i = this.N;
            byte[] bArr3 = new byte[i];
            this.treeDigest.update(bArr, 0, bArr.length);
            Xof xof = this.treeDigest;
            byte[] bArr4 = adrs.value;
            xof.update(bArr4, 0, bArr4.length);
            this.treeDigest.update(bArr2, 0, bArr2.length);
            this.treeDigest.doFinal(bArr3, 0, i);
            return bArr3;
        }

        public byte[] H(byte[] bArr, ADRS adrs, byte[] bArr2, byte[] bArr3) {
            byte[] concatenate = Arrays.concatenate(bArr2, bArr3);
            if (this.robust) {
                concatenate = bitmask(bArr, adrs, concatenate);
            }
            int i = this.N;
            byte[] bArr4 = new byte[i];
            this.treeDigest.update(bArr, 0, bArr.length);
            Xof xof = this.treeDigest;
            byte[] bArr5 = adrs.value;
            xof.update(bArr5, 0, bArr5.length);
            this.treeDigest.update(concatenate, 0, concatenate.length);
            this.treeDigest.doFinal(bArr4, 0, i);
            return bArr4;
        }

        public IndexedDigest H_msg(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) {
            int i = ((this.A * this.K) + 7) / 8;
            int i2 = this.H;
            int i3 = i2 / this.D;
            int i4 = i2 - i3;
            int i5 = (i3 + 7) / 8;
            int i6 = (i4 + 7) / 8;
            int i7 = i + i5 + i6;
            byte[] bArr5 = new byte[i7];
            this.treeDigest.update(bArr, 0, bArr.length);
            this.treeDigest.update(bArr2, 0, bArr2.length);
            this.treeDigest.update(bArr3, 0, bArr3.length);
            this.treeDigest.update(bArr4, 0, bArr4.length);
            this.treeDigest.doFinal(bArr5, 0, i7);
            byte[] bArr6 = new byte[8];
            System.arraycopy(bArr5, i, bArr6, 8 - i6, i6);
            long bigEndianToLong = Pack.bigEndianToLong(bArr6, 0) & (-1 >>> (64 - i4));
            byte[] bArr7 = new byte[4];
            System.arraycopy(bArr5, i6 + i, bArr7, 4 - i5, i5);
            return new IndexedDigest(bigEndianToLong, Pack.bigEndianToInt(bArr7, 0) & (-1 >>> (32 - i3)), Arrays.copyOfRange(bArr5, 0, i));
        }

        public byte[] PRF(byte[] bArr, byte[] bArr2, ADRS adrs) {
            this.treeDigest.update(bArr2, 0, bArr2.length);
            Xof xof = this.treeDigest;
            byte[] bArr3 = adrs.value;
            xof.update(bArr3, 0, bArr3.length);
            int i = this.N;
            byte[] bArr4 = new byte[i];
            this.treeDigest.doFinal(bArr4, 0, i);
            return bArr4;
        }

        public byte[] PRF_msg(byte[] bArr, byte[] bArr2, byte[] bArr3) {
            this.treeDigest.update(bArr, 0, bArr.length);
            this.treeDigest.update(bArr2, 0, bArr2.length);
            this.treeDigest.update(bArr3, 0, bArr3.length);
            int i = this.N;
            byte[] bArr4 = new byte[i];
            this.treeDigest.doFinal(bArr4, 0, i);
            return bArr4;
        }

        public byte[] T_l(byte[] bArr, ADRS adrs, byte[] bArr2) {
            if (this.robust) {
                bArr2 = bitmask(bArr, adrs, bArr2);
            }
            int i = this.N;
            byte[] bArr3 = new byte[i];
            this.treeDigest.update(bArr, 0, bArr.length);
            Xof xof = this.treeDigest;
            byte[] bArr4 = adrs.value;
            xof.update(bArr4, 0, bArr4.length);
            this.treeDigest.update(bArr2, 0, bArr2.length);
            this.treeDigest.doFinal(bArr3, 0, i);
            return bArr3;
        }

        public byte[] bitmask(byte[] bArr, ADRS adrs, byte[] bArr2) {
            int length = bArr2.length;
            byte[] bArr3 = new byte[length];
            this.treeDigest.update(bArr, 0, bArr.length);
            Xof xof = this.treeDigest;
            byte[] bArr4 = adrs.value;
            xof.update(bArr4, 0, bArr4.length);
            this.treeDigest.doFinal(bArr3, 0, length);
            for (int i = 0; i < bArr2.length; i++) {
                bArr3[i] = (byte) (bArr3[i] ^ bArr2[i]);
            }
            return bArr3;
        }
    }

    public SPHINCSPlusEngine(boolean z, int i, int i2, int i3, int i4, int i5, int i6) {
        this.N = i;
        if (i2 == 16) {
            this.WOTS_LOGW = 4;
            this.WOTS_LEN1 = (i * 8) / 4;
            if (i <= 8) {
                this.WOTS_LEN2 = 2;
            } else if (i <= 136) {
                this.WOTS_LEN2 = 3;
            } else if (i <= 256) {
                this.WOTS_LEN2 = 4;
            } else {
                throw new IllegalArgumentException("cannot precompute SPX_WOTS_LEN2 for n outside {2, .., 256}");
            }
        } else if (i2 == 256) {
            this.WOTS_LOGW = 8;
            this.WOTS_LEN1 = (i * 8) / 8;
            if (i <= 1) {
                this.WOTS_LEN2 = 1;
            } else if (i <= 256) {
                this.WOTS_LEN2 = 2;
            } else {
                throw new IllegalArgumentException("cannot precompute SPX_WOTS_LEN2 for n outside {2, .., 256}");
            }
        } else {
            throw new IllegalArgumentException("wots_w assumed 16 or 256");
        }
        this.WOTS_W = i2;
        this.WOTS_LEN = this.WOTS_LEN1 + this.WOTS_LEN2;
        this.robust = z;
        this.D = i3;
        this.A = i4;
        this.K = i5;
        this.H = i6;
        this.H_PRIME = i6 / i3;
        this.T = 1 << i4;
    }

    public static byte[] xor(byte[] bArr, byte[] bArr2) {
        byte[] clone = Arrays.clone(bArr);
        for (int i = 0; i < bArr.length; i++) {
            clone[i] = (byte) (clone[i] ^ bArr2[i]);
        }
        return clone;
    }

    public abstract byte[] F(byte[] bArr, ADRS adrs, byte[] bArr2);

    public abstract byte[] H(byte[] bArr, ADRS adrs, byte[] bArr2, byte[] bArr3);

    public abstract IndexedDigest H_msg(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4);

    public abstract byte[] PRF(byte[] bArr, byte[] bArr2, ADRS adrs);

    public abstract byte[] PRF_msg(byte[] bArr, byte[] bArr2, byte[] bArr3);

    public abstract byte[] T_l(byte[] bArr, ADRS adrs, byte[] bArr2);
}
