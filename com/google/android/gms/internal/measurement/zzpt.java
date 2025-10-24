package com.google.android.gms.internal.measurement;

public final class zzpt implements zzps {
    public static final zzkm zza;
    public static final zzkm zzb;

    static {
        zzkg zzb2 = new zzkg(zzkb.zza("com.google.android.gms.measurement")).zza().zzb();
        zzb2.zzd("measurement.collection.event_safelist", true);
        zza = zzb2.zzd("measurement.service.store_null_safelist", true);
        zzb = zzb2.zzd("measurement.service.store_safelist", true);
    }

    public final boolean zza() {
        return true;
    }

    public final boolean zzb() {
        return ((Boolean) zza.zzd()).booleanValue();
    }

    public final boolean zzc() {
        return ((Boolean) zzb.zzd()).booleanValue();
    }
}
