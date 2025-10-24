package com.google.android.gms.internal.clearcut;

import android.content.SharedPreferences;
import android.util.Log;

final class zzaj extends zzae<Boolean> {
    public zzaj(zzao zzao, String str, Boolean bool) {
        super(zzao, str, bool, (zzai) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: zzb */
    public final Boolean zza(SharedPreferences sharedPreferences) {
        try {
            return Boolean.valueOf(sharedPreferences.getBoolean(this.zzds, false));
        } catch (ClassCastException e) {
            String valueOf = String.valueOf(this.zzds);
            Log.e("PhenotypeFlag", valueOf.length() != 0 ? "Invalid boolean value in SharedPreferences for ".concat(valueOf) : new String("Invalid boolean value in SharedPreferences for "), e);
            return null;
        }
    }

    public final /* synthetic */ Object zzb(String str) {
        if (zzy.zzcr.matcher(str).matches()) {
            return Boolean.TRUE;
        }
        if (zzy.zzcs.matcher(str).matches()) {
            return Boolean.FALSE;
        }
        String str2 = this.zzds;
        StringBuilder sb2 = new StringBuilder(String.valueOf(str2).length() + 28 + String.valueOf(str).length());
        sb2.append("Invalid boolean value for ");
        sb2.append(str2);
        sb2.append(": ");
        sb2.append(str);
        Log.e("PhenotypeFlag", sb2.toString());
        return null;
    }
}
