package com.google.android.gms.internal.auth;

import android.util.Log;

final class zzcx extends zzdc {
    public zzcx(zzcz zzcz, String str, Double d, boolean z) {
        super(zzcz, str, d, true, (zzdb) null);
    }

    public final /* bridge */ /* synthetic */ Object zza(Object obj) {
        try {
            return Double.valueOf(Double.parseDouble((String) obj));
        } catch (NumberFormatException unused) {
            String zzc = super.zzc();
            Log.e("PhenotypeFlag", "Invalid double value for " + zzc + ": " + ((String) obj));
            return null;
        }
    }
}
