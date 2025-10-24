package com.google.android.gms.internal.common;

import java.util.List;

final class zzaj extends zzak {
    final transient int zza;
    final transient int zzb;
    final /* synthetic */ zzak zzc;

    public zzaj(zzak zzak, int i, int i2) {
        this.zzc = zzak;
        this.zza = i;
        this.zzb = i2;
    }

    public final Object get(int i) {
        zzv.zza(i, this.zzb, "index");
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

    public final boolean zzf() {
        return true;
    }

    public final Object[] zzg() {
        return this.zzc.zzg();
    }

    public final zzak zzh(int i, int i2) {
        zzv.zzc(i, i2, this.zzb);
        int i3 = this.zza;
        return this.zzc.subList(i + i3, i2 + i3);
    }
}
