package com.google.android.gms.internal.measurement;

public final class zzpn implements zzpm {
    public static final zzkm zza;
    public static final zzkm zzb;

    static {
        zzkg zzb2 = new zzkg(zzkb.zza("com.google.android.gms.measurement")).zza().zzb();
        zza = zzb2.zzd("measurement.set_default_event_parameters_propagate_clear.client.dev", true);
        zzb = zzb2.zzd("measurement.set_default_event_parameters_propagate_clear.service", true);
    }

    public final boolean zza() {
        return ((Boolean) zza.zzd()).booleanValue();
    }

    public final boolean zzb() {
        return ((Boolean) zzb.zzd()).booleanValue();
    }
}
