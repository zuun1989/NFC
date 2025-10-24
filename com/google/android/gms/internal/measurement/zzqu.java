package com.google.android.gms.internal.measurement;

public final class zzqu implements zzqt {
    public static final zzkm zza;

    static {
        zzkg zzb = new zzkg(zzkb.zza("com.google.android.gms.measurement")).zza().zzb();
        zza = zzb.zzd("measurement.add_first_launch_logging_timestamp.service", false);
        zzb.zzc("measurement.id.add_first_launch_logging_timestamp.service", 0);
    }

    public final boolean zza() {
        return ((Boolean) zza.zzd()).booleanValue();
    }
}
