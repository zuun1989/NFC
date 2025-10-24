package com.google.android.gms.internal.mlkit_vision_face;

import java.util.Map;

final class zzbb extends zzaq {
    final /* synthetic */ zzbd zza;
    private final Object zzb;
    private int zzc;

    public zzbb(zzbd zzbd, int i) {
        this.zza = zzbd;
        this.zzb = zzbd.zzg(zzbd, i);
        this.zzc = i;
    }

    private final void zza() {
        int i = this.zzc;
        if (i == -1 || i >= this.zza.size() || !zzx.zza(this.zzb, zzbd.zzg(this.zza, this.zzc))) {
            this.zzc = this.zza.zzv(this.zzb);
        }
    }

    public final Object getKey() {
        return this.zzb;
    }

    public final Object getValue() {
        Map zzl = this.zza.zzl();
        if (zzl != null) {
            return zzl.get(this.zzb);
        }
        zza();
        int i = this.zzc;
        if (i == -1) {
            return null;
        }
        return zzbd.zzj(this.zza, i);
    }

    public final Object setValue(Object obj) {
        Map zzl = this.zza.zzl();
        if (zzl != null) {
            return zzl.put(this.zzb, obj);
        }
        zza();
        int i = this.zzc;
        if (i == -1) {
            this.zza.put(this.zzb, obj);
            return null;
        }
        Object zzj = zzbd.zzj(this.zza, i);
        zzbd.zzm(this.zza, this.zzc, obj);
        return zzj;
    }
}
