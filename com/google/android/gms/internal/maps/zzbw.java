package com.google.android.gms.internal.maps;

import java.util.Iterator;

final class zzbw extends zzbo {
    static final zzbw zza;
    private static final Object[] zzd;
    final transient Object[] zzb;
    final transient Object[] zzc;
    private final transient int zze;
    private final transient int zzf;
    private final transient int zzg;

    static {
        Object[] objArr = new Object[0];
        zzd = objArr;
        zza = new zzbw(objArr, 0, objArr, 0, 0);
    }

    public zzbw(Object[] objArr, int i, Object[] objArr2, int i2, int i3) {
        this.zzb = objArr;
        this.zze = i;
        this.zzc = objArr2;
        this.zzf = i2;
        this.zzg = i3;
    }

    public final boolean contains(Object obj) {
        if (obj != null) {
            Object[] objArr = this.zzc;
            if (objArr.length != 0) {
                int zza2 = zzbg.zza(obj.hashCode());
                while (true) {
                    int i = zza2 & this.zzf;
                    Object obj2 = objArr[i];
                    if (obj2 == null) {
                        return false;
                    }
                    if (obj2.equals(obj)) {
                        return true;
                    }
                    zza2 = i + 1;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.zze;
    }

    public final /* synthetic */ Iterator iterator() {
        return zzg().listIterator(0);
    }

    public final int size() {
        return this.zzg;
    }

    public final int zza(Object[] objArr, int i) {
        Object[] objArr2 = this.zzb;
        int i2 = this.zzg;
        System.arraycopy(objArr2, 0, objArr, 0, i2);
        return i2;
    }

    public final int zzb() {
        return this.zzg;
    }

    public final int zzc() {
        return 0;
    }

    public final zzbz zzd() {
        return zzg().listIterator(0);
    }

    public final Object[] zze() {
        return this.zzb;
    }

    public final zzbk zzh() {
        return zzbk.zzg(this.zzb, this.zzg);
    }

    public final boolean zzj() {
        return true;
    }
}
