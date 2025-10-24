package com.google.android.gms.flags.impl;

import android.content.SharedPreferences;
import android.util.Log;
import com.google.android.gms.internal.flags.zze;

public final class zzb extends zza<Boolean> {
    public static Boolean zza(SharedPreferences sharedPreferences, String str, Boolean bool) {
        String str2;
        try {
            return (Boolean) zze.zza(new zzc(sharedPreferences, str, bool));
        } catch (Exception e) {
            String valueOf = String.valueOf(e.getMessage());
            if (valueOf.length() != 0) {
                str2 = "Flag value not available, returning default: ".concat(valueOf);
            } else {
                str2 = new String("Flag value not available, returning default: ");
            }
            Log.w("FlagDataUtils", str2);
            return bool;
        }
    }
}
