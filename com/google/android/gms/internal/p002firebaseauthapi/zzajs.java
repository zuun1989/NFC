package com.google.android.gms.internal.p002firebaseauthapi;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.eac.CertificateBody;
import com.google.android.gms.internal.p002firebaseauthapi.zzalg;
import java.io.IOException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzajs  reason: invalid package */
final class zzajs {
    private static volatile int zza = 100;

    public static double zza(byte[] bArr, int i) {
        return Double.longBitsToDouble(zzd(bArr, i));
    }

    public static float zzb(byte[] bArr, int i) {
        return Float.intBitsToFloat(zzc(bArr, i));
    }

    public static int zzc(byte[] bArr, int i) {
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    public static int zzd(byte[] bArr, int i, zzajv zzajv) {
        int i2 = i + 1;
        long j = (long) bArr[i];
        if (j >= 0) {
            zzajv.zzb = j;
            return i2;
        }
        int i3 = i + 2;
        byte b = bArr[i2];
        long j2 = (j & 127) | (((long) (b & Byte.MAX_VALUE)) << 7);
        int i4 = 7;
        while (b < 0) {
            int i5 = i3 + 1;
            byte b2 = bArr[i3];
            i4 += 7;
            j2 |= ((long) (b2 & Byte.MAX_VALUE)) << i4;
            int i6 = i5;
            b = b2;
            i3 = i6;
        }
        zzajv.zzb = j2;
        return i3;
    }

    public static int zza(byte[] bArr, int i, zzajv zzajv) throws zzalm {
        int zzc = zzc(bArr, i, zzajv);
        int i2 = zzajv.zza;
        if (i2 < 0) {
            throw zzalm.zzf();
        } else if (i2 > bArr.length - zzc) {
            throw zzalm.zzj();
        } else if (i2 == 0) {
            zzajv.zzc = zzajw.zza;
            return zzc;
        } else {
            zzajv.zzc = zzajw.zza(bArr, zzc, i2);
            return zzc + i2;
        }
    }

    public static int zzb(zzanc<?> zzanc, int i, byte[] bArr, int i2, int i3, zzaln<?> zzaln, zzajv zzajv) throws IOException {
        int zza2 = zza(zzanc, bArr, i2, i3, zzajv);
        zzaln.add(zzajv.zzc);
        while (zza2 < i3) {
            int zzc = zzc(bArr, zza2, zzajv);
            if (i != zzajv.zza) {
                break;
            }
            zza2 = zza(zzanc, bArr, zzc, i3, zzajv);
            zzaln.add(zzajv.zzc);
        }
        return zza2;
    }

    public static int zzc(byte[] bArr, int i, zzajv zzajv) {
        int i2 = i + 1;
        byte b = bArr[i];
        if (b < 0) {
            return zza((int) b, bArr, i2, zzajv);
        }
        zzajv.zza = b;
        return i2;
    }

    public static long zzd(byte[] bArr, int i) {
        return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
    }

    public static int zzb(byte[] bArr, int i, zzajv zzajv) throws zzalm {
        int zzc = zzc(bArr, i, zzajv);
        int i2 = zzajv.zza;
        if (i2 < 0) {
            throw zzalm.zzf();
        } else if (i2 == 0) {
            zzajv.zzc = "";
            return zzc;
        } else {
            zzajv.zzc = zzaob.zzb(bArr, zzc, i2);
            return zzc + i2;
        }
    }

    public static int zza(int i, byte[] bArr, int i2, int i3, Object obj, zzamn zzamn, zzanv<zzany, zzany> zzanv, zzajv zzajv) throws IOException {
        if (zzajv.zzd.zza(zzamn, i >>> 3) == null) {
            return zza(i, bArr, i2, i3, zzamr.zzc(obj), zzajv);
        }
        zzalg.zzd zzd = (zzalg.zzd) obj;
        zzd.zza();
        zzaky<zzalg.zzc> zzaky = zzd.zzc;
        throw new NoSuchMethodError();
    }

    private static <T> int zza(zzanc<T> zzanc, byte[] bArr, int i, int i2, int i3, zzajv zzajv) throws IOException {
        T zza2 = zzanc.zza();
        int zza3 = zza((Object) zza2, zzanc, bArr, i, i2, i3, zzajv);
        zzanc.zzd(zza2);
        zzajv.zzc = zza2;
        return zza3;
    }

    public static int zza(zzanc<?> zzanc, int i, byte[] bArr, int i2, int i3, zzaln<Object> zzaln, zzajv zzajv) throws IOException {
        int i4 = (i & -8) | 4;
        int zza2 = zza(zzanc, bArr, i2, i3, i4, zzajv);
        zzaln.add(zzajv.zzc);
        while (zza2 < i3) {
            int zzc = zzc(bArr, zza2, zzajv);
            if (i != zzajv.zza) {
                break;
            }
            zza2 = zza(zzanc, bArr, zzc, i3, i4, zzajv);
            zzaln.add(zzajv.zzc);
        }
        return zza2;
    }

    public static <T> int zza(zzanc<T> zzanc, byte[] bArr, int i, int i2, zzajv zzajv) throws IOException {
        T zza2 = zzanc.zza();
        int zza3 = zza((Object) zza2, zzanc, bArr, i, i2, zzajv);
        zzanc.zzd(zza2);
        zzajv.zzc = zza2;
        return zza3;
    }

    public static int zza(byte[] bArr, int i, zzaln<?> zzaln, zzajv zzajv) throws IOException {
        zzalj zzalj = (zzalj) zzaln;
        int zzc = zzc(bArr, i, zzajv);
        int i2 = zzajv.zza + zzc;
        while (zzc < i2) {
            zzc = zzc(bArr, zzc, zzajv);
            zzalj.zzc(zzajv.zza);
        }
        if (zzc == i2) {
            return zzc;
        }
        throw zzalm.zzj();
    }

    public static int zza(int i, byte[] bArr, int i2, int i3, zzany zzany, zzajv zzajv) throws zzalm {
        if ((i >>> 3) != 0) {
            int i4 = i & 7;
            if (i4 == 0) {
                int zzd = zzd(bArr, i2, zzajv);
                zzany.zza(i, (Object) Long.valueOf(zzajv.zzb));
                return zzd;
            } else if (i4 == 1) {
                zzany.zza(i, (Object) Long.valueOf(zzd(bArr, i2)));
                return i2 + 8;
            } else if (i4 == 2) {
                int zzc = zzc(bArr, i2, zzajv);
                int i5 = zzajv.zza;
                if (i5 < 0) {
                    throw zzalm.zzf();
                } else if (i5 <= bArr.length - zzc) {
                    if (i5 == 0) {
                        zzany.zza(i, (Object) zzajw.zza);
                    } else {
                        zzany.zza(i, (Object) zzajw.zza(bArr, zzc, i5));
                    }
                    return zzc + i5;
                } else {
                    throw zzalm.zzj();
                }
            } else if (i4 == 3) {
                zzany zzd2 = zzany.zzd();
                int i6 = (i & -8) | 4;
                int i7 = zzajv.zze + 1;
                zzajv.zze = i7;
                zza(i7);
                int i8 = 0;
                while (true) {
                    if (i2 >= i3) {
                        break;
                    }
                    int zzc2 = zzc(bArr, i2, zzajv);
                    int i9 = zzajv.zza;
                    i8 = i9;
                    if (i9 == i6) {
                        i2 = zzc2;
                        break;
                    }
                    int zza2 = zza(i8, bArr, zzc2, i3, zzd2, zzajv);
                    i8 = i9;
                    i2 = zza2;
                }
                zzajv.zze--;
                if (i2 > i3 || i8 != i6) {
                    throw zzalm.zzg();
                }
                zzany.zza(i, (Object) zzd2);
                return i2;
            } else if (i4 == 5) {
                zzany.zza(i, (Object) Integer.valueOf(zzc(bArr, i2)));
                return i2 + 4;
            } else {
                throw zzalm.zzc();
            }
        } else {
            throw zzalm.zzc();
        }
    }

    public static int zza(int i, byte[] bArr, int i2, zzajv zzajv) {
        int i3 = i & CertificateBody.profileType;
        int i4 = i2 + 1;
        byte b = bArr[i2];
        if (b >= 0) {
            zzajv.zza = i3 | (b << 7);
            return i4;
        }
        int i5 = i3 | ((b & Byte.MAX_VALUE) << 7);
        int i6 = i2 + 2;
        byte b2 = bArr[i4];
        if (b2 >= 0) {
            zzajv.zza = i5 | (b2 << 14);
            return i6;
        }
        int i7 = i5 | ((b2 & Byte.MAX_VALUE) << 14);
        int i8 = i2 + 3;
        byte b3 = bArr[i6];
        if (b3 >= 0) {
            zzajv.zza = i7 | (b3 << 21);
            return i8;
        }
        int i9 = i7 | ((b3 & Byte.MAX_VALUE) << 21);
        int i10 = i2 + 4;
        byte b4 = bArr[i8];
        if (b4 >= 0) {
            zzajv.zza = i9 | (b4 << 28);
            return i10;
        }
        int i11 = i9 | ((b4 & Byte.MAX_VALUE) << 28);
        while (true) {
            int i12 = i10 + 1;
            if (bArr[i10] >= 0) {
                zzajv.zza = i11;
                return i12;
            }
            i10 = i12;
        }
    }

    public static int zza(int i, byte[] bArr, int i2, int i3, zzaln<?> zzaln, zzajv zzajv) {
        zzalj zzalj = (zzalj) zzaln;
        int zzc = zzc(bArr, i2, zzajv);
        zzalj.zzc(zzajv.zza);
        while (zzc < i3) {
            int zzc2 = zzc(bArr, zzc, zzajv);
            if (i != zzajv.zza) {
                break;
            }
            zzc = zzc(bArr, zzc2, zzajv);
            zzalj.zzc(zzajv.zza);
        }
        return zzc;
    }

    public static <T> int zza(Object obj, zzanc<T> zzanc, byte[] bArr, int i, int i2, int i3, zzajv zzajv) throws IOException {
        int i4 = zzajv.zze + 1;
        zzajv.zze = i4;
        zza(i4);
        int zza2 = ((zzamr) zzanc).zza(obj, bArr, i, i2, i3, zzajv);
        zzajv.zze--;
        zzajv.zzc = obj;
        return zza2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v6, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <T> int zza(java.lang.Object r6, com.google.android.gms.internal.p002firebaseauthapi.zzanc<T> r7, byte[] r8, int r9, int r10, com.google.android.gms.internal.p002firebaseauthapi.zzajv r11) throws java.io.IOException {
        /*
            int r0 = r9 + 1
            byte r9 = r8[r9]
            if (r9 >= 0) goto L_0x000c
            int r0 = zza((int) r9, (byte[]) r8, (int) r0, (com.google.android.gms.internal.p002firebaseauthapi.zzajv) r11)
            int r9 = r11.zza
        L_0x000c:
            r3 = r0
            if (r9 < 0) goto L_0x002d
            int r10 = r10 - r3
            if (r9 > r10) goto L_0x002d
            int r10 = r11.zze
            int r10 = r10 + 1
            r11.zze = r10
            zza(r10)
            int r9 = r9 + r3
            r0 = r7
            r1 = r6
            r2 = r8
            r4 = r9
            r5 = r11
            r0.zza(r1, r2, r3, r4, r5)
            int r7 = r11.zze
            int r7 = r7 + -1
            r11.zze = r7
            r11.zzc = r6
            return r9
        L_0x002d:
            com.google.android.gms.internal.firebase-auth-api.zzalm r6 = com.google.android.gms.internal.p002firebaseauthapi.zzalm.zzj()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p002firebaseauthapi.zzajs.zza(java.lang.Object, com.google.android.gms.internal.firebase-auth-api.zzanc, byte[], int, int, com.google.android.gms.internal.firebase-auth-api.zzajv):int");
    }

    public static int zza(int i, byte[] bArr, int i2, int i3, zzajv zzajv) throws zzalm {
        if ((i >>> 3) != 0) {
            int i4 = i & 7;
            if (i4 == 0) {
                return zzd(bArr, i2, zzajv);
            }
            if (i4 == 1) {
                return i2 + 8;
            }
            if (i4 == 2) {
                return zzc(bArr, i2, zzajv) + zzajv.zza;
            }
            if (i4 == 3) {
                int i5 = (i & -8) | 4;
                int i6 = 0;
                while (i2 < i3) {
                    i2 = zzc(bArr, i2, zzajv);
                    i6 = zzajv.zza;
                    if (i6 == i5) {
                        break;
                    }
                    i2 = zza(i6, bArr, i2, i3, zzajv);
                }
                if (i2 <= i3 && i6 == i5) {
                    return i2;
                }
                throw zzalm.zzg();
            } else if (i4 == 5) {
                return i2 + 4;
            } else {
                throw zzalm.zzc();
            }
        } else {
            throw zzalm.zzc();
        }
    }

    private static void zza(int i) throws zzalm {
        if (i >= zza) {
            throw zzalm.zzh();
        }
    }
}
