package com.google.android.gms.internal.measurement;

import android.content.SharedPreferences;

final /* synthetic */ class zzkn implements SharedPreferences.OnSharedPreferenceChangeListener {
    private final /* synthetic */ zzko zza;

    public /* synthetic */ zzkn(zzko zzko) {
        this.zza = zzko;
    }

    public final /* synthetic */ void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        this.zza.zzc(sharedPreferences, str);
    }
}
