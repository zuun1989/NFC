package com.google.android.gms.internal.measurement;

public final class zzf {
    final zzaw zza;
    final zzg zzb;
    final zzg zzc;
    final zzj zzd;

    public zzf() {
        zzaw zzaw = new zzaw();
        this.zza = zzaw;
        zzg zzg = new zzg((zzg) null, zzaw);
        this.zzc = zzg;
        this.zzb = zzg.zzc();
        zzj zzj = new zzj();
        this.zzd = zzj;
        zzg.zze("require", new zzw(zzj));
        zzj.zza("internal.platform", zze.zza);
        zzg.zze("runtime.counter", new zzah(Double.valueOf(0.0d)));
    }

    public final zzao zza(zzg zzg, zzje... zzjeArr) {
        zzao zzao = zzao.zzf;
        for (zzje zzb2 : zzjeArr) {
            zzao = zzi.zzb(zzb2);
            zzh.zzl(this.zzc);
            if ((zzao instanceof zzap) || (zzao instanceof zzan)) {
                zzao = this.zza.zzb(zzg, zzao);
            }
        }
        return zzao;
    }
}
