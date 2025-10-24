package com.google.android.gms.internal.mlkit_vision_face;

import java.util.List;

final class zzbm extends zzbn {
    final transient int zza;
    final transient int zzb;
    final /* synthetic */ zzbn zzc;

    public zzbm(zzbn zzbn, int i, int i2) {
        this.zzc = zzbn;
        this.zza = i;
        this.zzb = i2;
    }

    public final Object get(int i) {
        zzab.zza(i, this.zzb, "index");
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

    public final zzbn zzf(int i, int i2) {
        zzab.zzc(i, i2, this.zzb);
        zzbn zzbn = this.zzc;
        int i3 = this.zza;
        return zzbn.subList(i + i3, i2 + i3);
    }
}
