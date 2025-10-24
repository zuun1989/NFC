package com.google.android.gms.internal.measurement;

public final class zzqo implements zzqn {
    public static final zzkm zza;
    public static final zzkm zzb;
    public static final zzkm zzc;
    public static final zzkm zzd;
    public static final zzkm zze;
    public static final zzkm zzf;

    static {
        zzkg zzb2 = new zzkg(zzkb.zza("com.google.android.gms.measurement")).zza().zzb();
        zza = zzb2.zzd("measurement.test.boolean_flag", false);
        zzb = zzb2.zzc("measurement.test.cached_long_flag", -1);
        zzc = zzb2.zze("measurement.test.double_flag", -3.0d);
        zzd = zzb2.zzc("measurement.test.int_flag", -2);
        zze = zzb2.zzc("measurement.test.long_flag", -1);
        zzf = zzb2.zzf("measurement.test.string_flag", "---");
    }

    public final boolean zza() {
        return ((Boolean) zza.zzd()).booleanValue();
    }

    public final long zzb() {
        return ((Long) zzb.zzd()).longValue();
    }

    public final double zzc() {
        return ((Double) zzc.zzd()).doubleValue();
    }

    public final long zzd() {
        return ((Long) zzd.zzd()).longValue();
    }

    public final long zze() {
        return ((Long) zze.zzd()).longValue();
    }

    public final String zzf() {
        return (String) zzf.zzd();
    }
}
