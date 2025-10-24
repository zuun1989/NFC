package com.google.android.gms.internal.maps;

import java.util.List;

final class zzbj extends zzbk {
    final transient int zza;
    final transient int zzb;
    final /* synthetic */ zzbk zzc;

    public zzbj(zzbk zzbk, int i, int i2) {
        this.zzc = zzbk;
        this.zza = i;
        this.zzb = i2;
    }

    public final Object get(int i) {
        zzbc.zza(i, this.zzb, "index");
        return this.zzc.get(i + this.zza);
    }

    public final int size() {
        return this.zzb;
    }

    public final /* bridge */ /* synthetic */ List subList(int i, int i2) {
        return subList(i, i2);
    }

    public final int zzb() {
        return this.zzc.zzc() + this.zza + this.zzb;
    }

    public final int zzc() {
        return this.zzc.zzc() + this.zza;
    }

    public final Object[] zze() {
        return this.zzc.zze();
    }

    public final zzbk zzf(int i, int i2) {
        zzbc.zzc(i, i2, this.zzb);
        int i3 = this.zza;
        return this.zzc.subList(i + i3, i2 + i3);
    }
}
