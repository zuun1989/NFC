package com.google.android.gms.internal.auth;

final class zzhm {
    private static final zzhk zza = new zzhl();

    static {
        if (zzhi.zzu() && zzhi.zzv()) {
            int i = zzdr.zza;
        }
    }

    public static /* bridge */ /* synthetic */ int zza(byte[] bArr, int i, int i2) {
        byte b = bArr[i - 1];
        int i3 = i2 - i;
        if (i3 != 0) {
            if (i3 == 1) {
                byte b2 = bArr[i];
                if (b <= -12 && b2 <= -65) {
                    return b ^ (b2 << 8);
                }
            } else if (i3 == 2) {
                byte b3 = bArr[i];
                byte b4 = bArr[i + 1];
                if (b <= -12 && b3 <= -65 && b4 <= -65) {
                    return ((b3 << 8) ^ b) ^ (b4 << 16);
                }
            } else {
                throw new AssertionError();
            }
        } else if (b <= -12) {
            return b;
        }
        return -1;
    }

    public static String zzb(byte[] bArr, int i, int i2) throws zzfa {
        int length = bArr.length;
        if ((i | i2 | ((length - i) - i2)) >= 0) {
            int i3 = i + i2;
            char[] cArr = new char[i2];
            int i4 = 0;
            while (r10 < i3) {
                byte b = bArr[r10];
                if (!zzhj.zzd(b)) {
                    break;
                }
                i = r10 + 1;
                cArr[i4] = (char) b;
                i4++;
            }
            int i5 = i4;
            while (r10 < i3) {
                int i6 = r10 + 1;
                byte b2 = bArr[r10];
                if (zzhj.zzd(b2)) {
                    cArr[i5] = (char) b2;
                    i5++;
                    r10 = i6;
                    while (r10 < i3) {
                        byte b3 = bArr[r10];
                        if (!zzhj.zzd(b3)) {
                            break;
                        }
                        r10++;
                        cArr[i5] = (char) b3;
                        i5++;
                    }
                } else if (b2 < -32) {
                    if (i6 < i3) {
                        r10 += 2;
                        zzhj.zzc(b2, bArr[i6], cArr, i5);
                        i5++;
                    } else {
                        throw zzfa.zzb();
                    }
                } else if (b2 < -16) {
                    if (i6 < i3 - 1) {
                        int i7 = r10 + 2;
                        r10 += 3;
                        zzhj.zzb(b2, bArr[i6], bArr[i7], cArr, i5);
                        i5++;
                    } else {
                        throw zzfa.zzb();
                    }
                } else if (i6 < i3 - 2) {
                    int i8 = r10 + 2;
                    int i9 = r10 + 3;
                    r10 += 4;
                    zzhj.zza(b2, bArr[i6], bArr[i8], bArr[i9], cArr, i5);
                    i5 += 2;
                } else {
                    throw zzfa.zzb();
                }
            }
            return new String(cArr, 0, i5);
        }
        throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", new Object[]{Integer.valueOf(length), Integer.valueOf(i), Integer.valueOf(i2)}));
    }

    public static boolean zzc(byte[] bArr) {
        return zza.zzb(bArr, 0, bArr.length);
    }

    public static boolean zzd(byte[] bArr, int i, int i2) {
        return zza.zzb(bArr, i, i2);
    }
}
