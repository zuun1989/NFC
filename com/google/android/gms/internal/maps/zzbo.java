package com.google.android.gms.internal.maps;

import java.util.Arrays;
import java.util.Objects;
import java.util.Set;

public abstract class zzbo extends zzbh implements Set {
    private transient zzbk zza;

    public static int zzf(int i) {
        int max = Math.max(i, 2);
        if (max < 751619276) {
            int highestOneBit = Integer.highestOneBit(max - 1);
            do {
                highestOneBit += highestOneBit;
            } while (((double) highestOneBit) * 0.7d < ((double) max));
            return highestOneBit;
        } else if (max < 1073741824) {
            return 1073741824;
        } else {
            throw new IllegalArgumentException("collection too large");
        }
    }

    @SafeVarargs
    public static zzbo zzi(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object... objArr) {
        Object[] objArr2 = new Object[7];
        objArr2[0] = "ADMINISTRATIVE_AREA_LEVEL_1";
        objArr2[1] = "ADMINISTRATIVE_AREA_LEVEL_2";
        objArr2[2] = "COUNTRY";
        objArr2[3] = "LOCALITY";
        objArr2[4] = "POSTAL_CODE";
        objArr2[5] = "SCHOOL_DISTRICT";
        System.arraycopy(objArr, 0, objArr2, 6, 1);
        return zzk(7, objArr2);
    }

    private static zzbo zzk(int i, Object... objArr) {
        if (i == 0) {
            return zzbw.zza;
        }
        if (i != 1) {
            int zzf = zzf(i);
            Object[] objArr2 = new Object[zzf];
            int i2 = zzf - 1;
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            while (i3 < i) {
                Object obj = objArr[i3];
                if (obj != null) {
                    int hashCode = obj.hashCode();
                    int zza2 = zzbg.zza(hashCode);
                    while (true) {
                        int i6 = zza2 & i2;
                        Object obj2 = objArr2[i6];
                        if (obj2 != null) {
                            if (obj2.equals(obj)) {
                                break;
                            }
                            zza2++;
                        } else {
                            objArr[i5] = obj;
                            objArr2[i6] = obj;
                            i4 += hashCode;
                            i5++;
                            break;
                        }
                    }
                    i3++;
                } else {
                    throw new NullPointerException("at index " + i3);
                }
            }
            Arrays.fill(objArr, i5, i, (Object) null);
            if (i5 == 1) {
                Object obj3 = objArr[0];
                Objects.requireNonNull(obj3);
                return new zzby(obj3);
            }
            if (zzf(i5) < zzf / 2) {
                return zzk(i5, objArr);
            }
            if (i5 < 4) {
                objArr = Arrays.copyOf(objArr, i5);
            }
            return new zzbw(objArr, i4, objArr2, i2, i5);
        }
        Object obj4 = objArr[0];
        Objects.requireNonNull(obj4);
        return new zzby(obj4);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof zzbo) && zzj() && ((zzbo) obj).zzj() && hashCode() != obj.hashCode()) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            try {
                if (size() == set.size() && containsAll(set)) {
                    return true;
                }
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    public int hashCode() {
        return zzbx.zza(this);
    }

    /* renamed from: zzd */
    public abstract zzbz iterator();

    public final zzbk zzg() {
        zzbk zzbk = this.zza;
        if (zzbk != null) {
            return zzbk;
        }
        zzbk zzh = zzh();
        this.zza = zzh;
        return zzh;
    }

    public zzbk zzh() {
        Object[] array = toArray();
        int i = zzbk.zzd;
        return zzbk.zzg(array, array.length);
    }

    public boolean zzj() {
        return false;
    }
}
