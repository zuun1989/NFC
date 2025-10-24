package com.google.android.gms.internal.measurement;

public final class zzrm implements zzrl {
    public static final zzkm zza;

    static {
        zzkg zzb = new zzkg(zzkb.zza("com.google.android.gms.measurement")).zza().zzb();
        zza = zzb.zzd("measurement.tcf.consent_fix", true);
        zzb.zzd("measurement.tcf.client", true);
        zzb.zzd("measurement.tcf.empty_pref_fix", true);
    }

    public final boolean zza() {
        return ((Boolean) zza.zzd()).booleanValue();
    }
}
