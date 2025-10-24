package com.google.android.gms.internal.fido;

import java.util.List;

final class zzay extends zzaz {
    final transient int zza;
    final transient int zzb;
    final /* synthetic */ zzaz zzc;

    public zzay(zzaz zzaz, int i, int i2) {
        this.zzc = zzaz;
        this.zza = i;
        this.zzb = i2;
    }

    public final Object get(int i) {
        zzap.zza(i, this.zzb, "index");
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

    public final zzaz zzg(int i, int i2) {
        zzap.zze(i, i2, this.zzb);
        zzaz zzaz = this.zzc;
        int i3 = this.zza;
        return zzaz.subList(i + i3, i2 + i3);
    }
}
