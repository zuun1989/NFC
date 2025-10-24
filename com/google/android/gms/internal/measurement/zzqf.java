package com.google.android.gms.internal.measurement;

public final class zzqf implements zzqe {
    public static final zzkm zza;

    static {
        zzkg zzb = new zzkg(zzkb.zza("com.google.android.gms.measurement")).zza().zzb();
        zzb.zzd("measurement.gbraid_campaign.gbraid.client", true);
        zza = zzb.zzd("measurement.gbraid_campaign.stop_lgclid", false);
    }

    public final boolean zza() {
        return ((Boolean) zza.zzd()).booleanValue();
    }
}
