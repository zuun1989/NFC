package com.google.android.gms.internal.measurement;

import java.util.List;

public final class zzt extends zzai {
    private final zzr zza;

    public zzt(zzr zzr) {
        super("internal.logger");
        this.zza = zzr;
        this.zze.put("log", new zzs(this, false, true));
        this.zze.put("silent", new zzp(this, "silent"));
        ((zzai) this.zze.get("silent")).zzm("log", new zzs(this, true, true));
        this.zze.put("unmonitored", new zzq(this, "unmonitored"));
        ((zzai) this.zze.get("unmonitored")).zzm("log", new zzs(this, false, false));
    }

    public final zzao zza(zzg zzg, List list) {
        return zzao.zzf;
    }

    public final /* synthetic */ zzr zzb() {
        return this.zza;
    }
}
