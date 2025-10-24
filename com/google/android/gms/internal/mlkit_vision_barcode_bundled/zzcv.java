package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.eac.CertificateBody;
import java.io.IOException;

final class zzcv {
    public static final /* synthetic */ int zza = 0;
    private static volatile int zzb = 100;

    public static int zza(byte[] bArr, int i, zzcu zzcu) throws zzer {
        int zzj = zzj(bArr, i, zzcu);
        int i2 = zzcu.zza;
        if (i2 < 0) {
            throw new zzer("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        } else if (i2 > bArr.length - zzj) {
            throw new zzer("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        } else if (i2 == 0) {
            zzcu.zzc = zzdf.zzb;
            return zzj;
        } else {
            zzcu.zzc = zzdf.zzr(bArr, zzj, i2);
            return zzj + i2;
        }
    }

    public static int zzb(int i, byte[] bArr, int i2, int i3, zzed zzed, zzef zzef, zzgs zzgs, zzcu zzcu) throws IOException {
        int i4;
        boolean z;
        zzdx zzdx = zzed.zzb;
        zzhf zzhf = zzef.zzb.zzb;
        Object obj = null;
        if (zzhf != zzhf.ENUM) {
            switch (zzhf.ordinal()) {
                case 0:
                    i4 = i2 + 8;
                    obj = Double.valueOf(Double.longBitsToDouble(zzq(bArr, i2)));
                    break;
                case 1:
                    i4 = i2 + 4;
                    obj = Float.valueOf(Float.intBitsToFloat(zzc(bArr, i2)));
                    break;
                case 2:
                case 3:
                    i2 = zzm(bArr, i2, zzcu);
                    obj = Long.valueOf(zzcu.zzb);
                    break;
                case 4:
                case 12:
                    i2 = zzj(bArr, i2, zzcu);
                    obj = Integer.valueOf(zzcu.zza);
                    break;
                case 5:
                case 15:
                    i4 = i2 + 8;
                    obj = Long.valueOf(zzq(bArr, i2));
                    break;
                case 6:
                case 14:
                    i4 = i2 + 4;
                    obj = Integer.valueOf(zzc(bArr, i2));
                    break;
                case 7:
                    i2 = zzm(bArr, i2, zzcu);
                    if (zzcu.zzb != 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    obj = Boolean.valueOf(z);
                    break;
                case 8:
                    i2 = zzh(bArr, i2, zzcu);
                    obj = zzcu.zzc;
                    break;
                case 9:
                    int i5 = ((i >>> 3) << 3) | 4;
                    zzge zzb2 = zzfu.zza().zzb(zzef.zza.getClass());
                    Object zze = zzdx.zze(zzef.zzb);
                    if (zze == null) {
                        zze = zzb2.zze();
                        zzdx.zzi(zzef.zzb, zze);
                    }
                    return zzn(zze, zzb2, bArr, i2, i3, i5, zzcu);
                case 10:
                    zzge zzb3 = zzfu.zza().zzb(zzef.zza.getClass());
                    Object zze2 = zzdx.zze(zzef.zzb);
                    if (zze2 == null) {
                        zze2 = zzb3.zze();
                        zzdx.zzi(zzef.zzb, zze2);
                    }
                    return zzo(zze2, zzb3, bArr, i2, i3, zzcu);
                case 11:
                    i2 = zza(bArr, i2, zzcu);
                    obj = zzcu.zzc;
                    break;
                case 13:
                    throw new IllegalStateException("Shouldn't reach here.");
                case 16:
                    i2 = zzj(bArr, i2, zzcu);
                    obj = Integer.valueOf(zzdj.zzb(zzcu.zza));
                    break;
                case 17:
                    i2 = zzm(bArr, i2, zzcu);
                    obj = Long.valueOf(zzdj.zzc(zzcu.zzb));
                    break;
            }
            i2 = i4;
            zzdx.zzi(zzef.zzb, obj);
            return i2;
        }
        zzj(bArr, i2, zzcu);
        throw null;
    }

    public static int zzc(byte[] bArr, int i) {
        int i2 = (bArr[i + 1] & 255) << 8;
        return ((bArr[i + 3] & 255) << 24) | i2 | (bArr[i] & 255) | ((bArr[i + 2] & 255) << 16);
    }

    public static int zzd(zzge zzge, byte[] bArr, int i, int i2, int i3, zzcu zzcu) throws IOException {
        Object zze = zzge.zze();
        int zzn = zzn(zze, zzge, bArr, i, i2, i3, zzcu);
        zzge.zzf(zze);
        zzcu.zzc = zze;
        return zzn;
    }

    public static int zze(zzge zzge, byte[] bArr, int i, int i2, zzcu zzcu) throws IOException {
        Object zze = zzge.zze();
        int zzo = zzo(zze, zzge, bArr, i, i2, zzcu);
        zzge.zzf(zze);
        zzcu.zzc = zze;
        return zzo;
    }

    public static int zzf(zzge zzge, int i, byte[] bArr, int i2, int i3, zzeo zzeo, zzcu zzcu) throws IOException {
        int zze = zze(zzge, bArr, i2, i3, zzcu);
        zzeo.add(zzcu.zzc);
        while (zze < i3) {
            int zzj = zzj(bArr, zze, zzcu);
            if (i != zzcu.zza) {
                break;
            }
            zze = zze(zzge, bArr, zzj, i3, zzcu);
            zzeo.add(zzcu.zzc);
        }
        return zze;
    }

    public static int zzg(byte[] bArr, int i, zzeo zzeo, zzcu zzcu) throws IOException {
        zzei zzei = (zzei) zzeo;
        int zzj = zzj(bArr, i, zzcu);
        int i2 = zzcu.zza + zzj;
        while (zzj < i2) {
            zzj = zzj(bArr, zzj, zzcu);
            zzei.zzg(zzcu.zza);
        }
        if (zzj == i2) {
            return zzj;
        }
        throw new zzer("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    public static int zzh(byte[] bArr, int i, zzcu zzcu) throws zzer {
        int zzj = zzj(bArr, i, zzcu);
        int i2 = zzcu.zza;
        if (i2 < 0) {
            throw new zzer("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        } else if (i2 == 0) {
            zzcu.zzc = "";
            return zzj;
        } else {
            zzcu.zzc = new String(bArr, zzj, i2, zzep.zza);
            return zzj + i2;
        }
    }

    public static int zzi(int i, byte[] bArr, int i2, int i3, zzgt zzgt, zzcu zzcu) throws zzer {
        if ((i >>> 3) != 0) {
            int i4 = i & 7;
            if (i4 == 0) {
                int zzm = zzm(bArr, i2, zzcu);
                zzgt.zzj(i, Long.valueOf(zzcu.zzb));
                return zzm;
            } else if (i4 == 1) {
                zzgt.zzj(i, Long.valueOf(zzq(bArr, i2)));
                return i2 + 8;
            } else if (i4 == 2) {
                int zzj = zzj(bArr, i2, zzcu);
                int i5 = zzcu.zza;
                if (i5 < 0) {
                    throw new zzer("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                } else if (i5 <= bArr.length - zzj) {
                    if (i5 == 0) {
                        zzgt.zzj(i, zzdf.zzb);
                    } else {
                        zzgt.zzj(i, zzdf.zzr(bArr, zzj, i5));
                    }
                    return zzj + i5;
                } else {
                    throw new zzer("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                }
            } else if (i4 == 3) {
                int i6 = (i & -8) | 4;
                zzgt zzf = zzgt.zzf();
                int i7 = zzcu.zze + 1;
                zzcu.zze = i7;
                zzr(i7);
                int i8 = 0;
                while (true) {
                    if (i2 >= i3) {
                        break;
                    }
                    int zzj2 = zzj(bArr, i2, zzcu);
                    i8 = zzcu.zza;
                    if (i8 == i6) {
                        i2 = zzj2;
                        break;
                    }
                    i2 = zzi(i8, bArr, zzj2, i3, zzf, zzcu);
                }
                zzcu.zze--;
                if (i2 > i3 || i8 != i6) {
                    throw new zzer("Failed to parse the message.");
                }
                zzgt.zzj(i, zzf);
                return i2;
            } else if (i4 == 5) {
                zzgt.zzj(i, Integer.valueOf(zzc(bArr, i2)));
                return i2 + 4;
            } else {
                throw new zzer("Protocol message contained an invalid tag (zero).");
            }
        } else {
            throw new zzer("Protocol message contained an invalid tag (zero).");
        }
    }

    public static int zzj(byte[] bArr, int i, zzcu zzcu) {
        int i2 = i + 1;
        byte b = bArr[i];
        if (b < 0) {
            return zzk(b, bArr, i2, zzcu);
        }
        zzcu.zza = b;
        return i2;
    }

    public static int zzk(int i, byte[] bArr, int i2, zzcu zzcu) {
        byte b = bArr[i2];
        int i3 = i2 + 1;
        int i4 = i & CertificateBody.profileType;
        if (b >= 0) {
            zzcu.zza = i4 | (b << 7);
            return i3;
        }
        int i5 = i4 | ((b & Byte.MAX_VALUE) << 7);
        int i6 = i2 + 2;
        byte b2 = bArr[i3];
        if (b2 >= 0) {
            zzcu.zza = i5 | (b2 << 14);
            return i6;
        }
        int i7 = i5 | ((b2 & Byte.MAX_VALUE) << 14);
        int i8 = i2 + 3;
        byte b3 = bArr[i6];
        if (b3 >= 0) {
            zzcu.zza = i7 | (b3 << 21);
            return i8;
        }
        int i9 = i7 | ((b3 & Byte.MAX_VALUE) << 21);
        int i10 = i2 + 4;
        byte b4 = bArr[i8];
        if (b4 >= 0) {
            zzcu.zza = i9 | (b4 << 28);
            return i10;
        }
        int i11 = i9 | ((b4 & Byte.MAX_VALUE) << 28);
        while (true) {
            int i12 = i10 + 1;
            if (bArr[i10] < 0) {
                i10 = i12;
            } else {
                zzcu.zza = i11;
                return i12;
            }
        }
    }

    public static int zzl(int i, byte[] bArr, int i2, int i3, zzeo zzeo, zzcu zzcu) {
        zzei zzei = (zzei) zzeo;
        int zzj = zzj(bArr, i2, zzcu);
        zzei.zzg(zzcu.zza);
        while (zzj < i3) {
            int zzj2 = zzj(bArr, zzj, zzcu);
            if (i != zzcu.zza) {
                break;
            }
            zzj = zzj(bArr, zzj2, zzcu);
            zzei.zzg(zzcu.zza);
        }
        return zzj;
    }

    public static int zzm(byte[] bArr, int i, zzcu zzcu) {
        long j = (long) bArr[i];
        int i2 = i + 1;
        if (j >= 0) {
            zzcu.zzb = j;
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
        zzcu.zzb = j2;
        return i3;
    }

    public static int zzn(Object obj, zzge zzge, byte[] bArr, int i, int i2, int i3, zzcu zzcu) throws IOException {
        int i4 = zzcu.zze + 1;
        zzcu.zze = i4;
        zzr(i4);
        int zzc = ((zzfp) zzge).zzc(obj, bArr, i, i2, i3, zzcu);
        zzcu.zze--;
        zzcu.zzc = obj;
        return zzc;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v6, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int zzo(java.lang.Object r6, com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzge r7, byte[] r8, int r9, int r10, com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcu r11) throws java.io.IOException {
        /*
            int r0 = r9 + 1
            byte r9 = r8[r9]
            if (r9 >= 0) goto L_0x000c
            int r0 = zzk(r9, r8, r0, r11)
            int r9 = r11.zza
        L_0x000c:
            r3 = r0
            if (r9 < 0) goto L_0x002d
            int r10 = r10 - r3
            if (r9 > r10) goto L_0x002d
            int r10 = r11.zze
            int r10 = r10 + 1
            r11.zze = r10
            zzr(r10)
            int r9 = r9 + r3
            r0 = r7
            r1 = r6
            r2 = r8
            r4 = r9
            r5 = r11
            r0.zzh(r1, r2, r3, r4, r5)
            int r7 = r11.zze
            int r7 = r7 + -1
            r11.zze = r7
            r11.zzc = r6
            return r9
        L_0x002d:
            com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzer r6 = new com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzer
            java.lang.String r7 = "While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length."
            r6.<init>((java.lang.String) r7)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcv.zzo(java.lang.Object, com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzge, byte[], int, int, com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcu):int");
    }

    public static int zzp(int i, byte[] bArr, int i2, int i3, zzcu zzcu) throws zzer {
        if ((i >>> 3) != 0) {
            int i4 = i & 7;
            if (i4 == 0) {
                return zzm(bArr, i2, zzcu);
            }
            if (i4 == 1) {
                return i2 + 8;
            }
            if (i4 == 2) {
                return zzj(bArr, i2, zzcu) + zzcu.zza;
            }
            if (i4 == 3) {
                int i5 = (i & -8) | 4;
                int i6 = 0;
                while (i2 < i3) {
                    i2 = zzj(bArr, i2, zzcu);
                    i6 = zzcu.zza;
                    if (i6 == i5) {
                        break;
                    }
                    i2 = zzp(i6, bArr, i2, i3, zzcu);
                }
                if (i2 <= i3 && i6 == i5) {
                    return i2;
                }
                throw new zzer("Failed to parse the message.");
            } else if (i4 == 5) {
                return i2 + 4;
            } else {
                throw new zzer("Protocol message contained an invalid tag (zero).");
            }
        } else {
            throw new zzer("Protocol message contained an invalid tag (zero).");
        }
    }

    public static long zzq(byte[] bArr, int i) {
        return (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48) | ((((long) bArr[i + 7]) & 255) << 56);
    }

    private static void zzr(int i) throws zzer {
        if (i >= zzb) {
            throw new zzer("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
        }
    }
}
