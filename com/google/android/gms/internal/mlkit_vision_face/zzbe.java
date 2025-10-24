package com.google.android.gms.internal.mlkit_vision_face;

final class zzbe {
    public static int zza(int i) {
        return (i < 32 ? 4 : 2) * (i + 1);
    }

    public static int zzb(Object obj, Object obj2, int i, Object obj3, int[] iArr, Object[] objArr, Object[] objArr2) {
        int i2;
        int i3;
        int zza = zzbf.zza(obj);
        int i4 = zza & i;
        int zzc = zzc(obj3, i4);
        if (zzc != 0) {
            int i5 = ~i;
            int i6 = zza & i5;
            int i7 = -1;
            while (true) {
                i2 = zzc - 1;
                i3 = iArr[i2];
                if ((i3 & i5) != i6 || !zzx.zza(obj, objArr[i2]) || (objArr2 != null && !zzx.zza(obj2, objArr2[i2]))) {
                    int i8 = i3 & i;
                    if (i8 == 0) {
                        break;
                    }
                    int i9 = i8;
                    i7 = i2;
                    zzc = i9;
                }
            }
            int i10 = i3 & i;
            if (i7 == -1) {
                zze(obj3, i4, i10);
            } else {
                iArr[i7] = (i10 & i) | (iArr[i7] & i5);
            }
            return i2;
        }
        return -1;
    }

    public static int zzc(Object obj, int i) {
        if (obj instanceof byte[]) {
            return ((byte[]) obj)[i] & 255;
        }
        if (obj instanceof short[]) {
            return (char) ((short[]) obj)[i];
        }
        return ((int[]) obj)[i];
    }

    public static Object zzd(int i) {
        if (i < 2 || i > 1073741824 || Integer.highestOneBit(i) != i) {
            StringBuilder sb2 = new StringBuilder(52);
            sb2.append("must be power of 2 between 2^1 and 2^30: ");
            sb2.append(i);
            throw new IllegalArgumentException(sb2.toString());
        } else if (i <= 256) {
            return new byte[i];
        } else {
            if (i <= 65536) {
                return new short[i];
            }
            return new int[i];
        }
    }

    public static void zze(Object obj, int i, int i2) {
        if (obj instanceof byte[]) {
            ((byte[]) obj)[i] = (byte) i2;
        } else if (obj instanceof short[]) {
            ((short[]) obj)[i] = (short) i2;
        } else {
            ((int[]) obj)[i] = i2;
        }
    }
}
