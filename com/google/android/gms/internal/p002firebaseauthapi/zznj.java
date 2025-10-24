package com.google.android.gms.internal.p002firebaseauthapi;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.signers.PSSSigner;
import com.fis.ekyc.nfc.build_in.scuba.smartcards.ISO7816;
import com.fis.ekyc.nfc.build_in.scuba.smartcards.ISOFileInfo;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.util.Arrays;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zznj  reason: invalid package */
public final class zznj {
    private static final byte[][] zza = {new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, new byte[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, new byte[]{ISO7816.INS_CREATE_FILE, -21, 122, 124, 59, 65, -72, -82, 22, 86, -29, -6, -15, -97, -60, 106, ISO7816.INS_PUT_DATA, 9, ISOFileInfo.ENV_TEMP_EF, -21, -100, ISO7816.INS_INCREASE, ISO7816.INS_READ_BINARY2, -3, -122, ISOFileInfo.FCP_BYTE, 5, 22, 95, 73, -72, 0}, new byte[]{95, -100, -107, PSSSigner.TRAILER_IMPLICIT, -93, 80, ISOFileInfo.SECURITY_ATTR_COMPACT, ISO7816.INS_CHANGE_CHV, ISO7816.INS_READ_BINARY2, ISO7816.INS_WRITE_BINARY, ISO7816.INS_READ_BINARY2, 85, -100, ISOFileInfo.FILE_IDENTIFIER, -17, 91, 4, ISO7816.INS_REHABILITATE_CHV, 92, -60, 88, 28, ISOFileInfo.CHANNEL_SECURITY, -122, ISO7816.INS_LOAD_KEY_FILE, ISO7816.INS_MSE, 78, -35, ISO7816.INS_WRITE_BINARY, -97, 17, 87}, new byte[]{-20, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, Byte.MAX_VALUE}, new byte[]{-19, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, Byte.MAX_VALUE}, new byte[]{-18, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, Byte.MAX_VALUE}};

    public static void zza(long[] jArr, byte[] bArr, byte[] bArr2) throws InvalidKeyException {
        long[] jArr2 = jArr;
        byte[] bArr3 = bArr2;
        int i = 32;
        if (bArr3.length == 32) {
            byte[] copyOf = Arrays.copyOf(bArr3, bArr3.length);
            copyOf[31] = (byte) (copyOf[31] & Byte.MAX_VALUE);
            int i2 = 0;
            int i3 = 0;
            while (true) {
                byte[][] bArr4 = zza;
                if (i3 >= bArr4.length) {
                    long[] zza2 = zznp.zza(copyOf);
                    long[] jArr3 = new long[19];
                    long[] jArr4 = new long[19];
                    jArr4[0] = 1;
                    long[] jArr5 = new long[19];
                    jArr5[0] = 1;
                    long[] jArr6 = new long[19];
                    long[] jArr7 = new long[19];
                    long[] jArr8 = new long[19];
                    jArr8[0] = 1;
                    long[] jArr9 = new long[19];
                    long[] jArr10 = new long[19];
                    jArr10[0] = 1;
                    int i4 = 10;
                    System.arraycopy(zza2, 0, jArr3, 0, 10);
                    int i5 = 0;
                    while (i5 < i) {
                        byte b = bArr[31 - i5] & 255;
                        while (i2 < 8) {
                            int i6 = (b >> (7 - i2)) & 1;
                            zza(jArr5, jArr3, i6);
                            zza(jArr6, jArr4, i6);
                            long[] copyOf2 = Arrays.copyOf(jArr5, i4);
                            byte b2 = b;
                            long[] jArr11 = new long[19];
                            int i7 = i5;
                            long[] jArr12 = new long[19];
                            int i8 = i2;
                            long[] jArr13 = new long[19];
                            int i9 = i6;
                            long[] jArr14 = new long[19];
                            long[] jArr15 = jArr10;
                            long[] jArr16 = new long[19];
                            long[] jArr17 = new long[19];
                            zznp.zzd(jArr5, jArr6);
                            zznp.zzc(jArr6, copyOf2);
                            long[] copyOf3 = Arrays.copyOf(jArr3, 10);
                            zznp.zzd(jArr3, jArr4);
                            zznp.zzc(jArr4, copyOf3);
                            zznp.zzb(jArr13, jArr3, jArr6);
                            zznp.zzb(jArr14, jArr5, jArr4);
                            zznp.zzb(jArr13);
                            zznp.zza(jArr13);
                            zznp.zzb(jArr14);
                            zznp.zza(jArr14);
                            long[] jArr18 = jArr3;
                            System.arraycopy(jArr13, 0, copyOf3, 0, 10);
                            zznp.zzd(jArr13, jArr14);
                            zznp.zzc(jArr14, copyOf3);
                            zznp.zzb(jArr17, jArr13);
                            zznp.zzb(jArr16, jArr14);
                            zznp.zzb(jArr14, jArr16, zza2);
                            zznp.zzb(jArr14);
                            zznp.zza(jArr14);
                            System.arraycopy(jArr17, 0, jArr7, 0, 10);
                            System.arraycopy(jArr14, 0, jArr8, 0, 10);
                            zznp.zzb(jArr11, jArr5);
                            zznp.zzb(jArr12, jArr6);
                            zznp.zzb(jArr9, jArr11, jArr12);
                            zznp.zzb(jArr9);
                            zznp.zza(jArr9);
                            zznp.zzc(jArr12, jArr11);
                            long[] jArr19 = new long[19];
                            Arrays.fill(jArr19, 10, 18, 0);
                            zznp.zza(jArr19, jArr12, 121665);
                            zznp.zza(jArr19);
                            zznp.zzd(jArr19, jArr11);
                            long[] jArr20 = jArr15;
                            zznp.zzb(jArr20, jArr12, jArr19);
                            zznp.zzb(jArr20);
                            zznp.zza(jArr20);
                            int i10 = i9;
                            zza(jArr9, jArr7, i10);
                            zza(jArr20, jArr8, i10);
                            i2 = i8 + 1;
                            long[] jArr21 = jArr;
                            byte[] bArr5 = bArr2;
                            jArr3 = jArr7;
                            b = b2;
                            i5 = i7;
                            jArr7 = jArr18;
                            i4 = 10;
                            long[] jArr22 = jArr8;
                            jArr8 = jArr4;
                            jArr4 = jArr22;
                            long[] jArr23 = jArr9;
                            jArr9 = jArr5;
                            jArr5 = jArr23;
                            long[] jArr24 = jArr20;
                            jArr10 = jArr6;
                            jArr6 = jArr24;
                        }
                        long[] jArr25 = jArr3;
                        i5++;
                        long[] jArr26 = jArr;
                        byte[] bArr6 = bArr2;
                        i = 32;
                        i2 = 0;
                        i4 = 10;
                    }
                    int i11 = i4;
                    long[] jArr27 = new long[i11];
                    zznp.zza(jArr27, jArr6);
                    long[] jArr28 = jArr;
                    zznp.zza(jArr28, jArr5, jArr27);
                    long[] jArr29 = new long[i11];
                    long[] jArr30 = new long[i11];
                    long[] jArr31 = new long[11];
                    long[] jArr32 = new long[11];
                    long[] jArr33 = new long[11];
                    zznp.zza(jArr29, zza2, jArr28);
                    zznp.zzd(jArr30, zza2, jArr28);
                    long[] jArr34 = new long[i11];
                    jArr34[0] = 486662;
                    zznp.zzd(jArr32, jArr30, jArr34);
                    zznp.zza(jArr32, jArr32, jArr4);
                    zznp.zzd(jArr32, jArr3);
                    zznp.zza(jArr32, jArr32, jArr29);
                    zznp.zza(jArr32, jArr32, jArr3);
                    zznp.zza(jArr31, jArr32, 4);
                    zznp.zza(jArr31);
                    zznp.zza(jArr32, jArr29, jArr4);
                    zznp.zzc(jArr32, jArr32, jArr4);
                    zznp.zza(jArr33, jArr30, jArr3);
                    zznp.zzd(jArr32, jArr32, jArr33);
                    zznp.zzb(jArr32, jArr32);
                    if (!MessageDigest.isEqual(zznp.zzc(jArr31), zznp.zzc(jArr32))) {
                        throw new IllegalStateException("Arithmetic error in curve multiplication with the public key: " + zzaaa.zza(bArr2));
                    }
                    return;
                } else if (!MessageDigest.isEqual(bArr4[i3], copyOf)) {
                    i3++;
                } else {
                    throw new InvalidKeyException("Banned public key: " + zzaaa.zza(bArr4[i3]));
                }
            }
        } else {
            throw new InvalidKeyException("Public key length is not 32-byte");
        }
    }

    private static void zza(long[] jArr, long[] jArr2, int i) {
        int i2 = -i;
        for (int i3 = 0; i3 < 10; i3++) {
            long j = jArr[i3];
            int i4 = (((int) j) ^ ((int) jArr2[i3])) & i2;
            jArr[i3] = (long) (((int) j) ^ i4);
            jArr2[i3] = (long) (((int) jArr2[i3]) ^ i4);
        }
    }
}
