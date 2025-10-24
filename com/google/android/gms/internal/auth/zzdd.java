package com.google.android.gms.internal.auth;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.StrictMode;
import java.util.Iterator;
import java.util.Map;
import w0.a;

public final class zzdd implements zzcl {
    private static final Map zza = new a();
    private final SharedPreferences zzb;
    private final SharedPreferences.OnSharedPreferenceChangeListener zzc;

    public static zzdd zza(Context context, String str, Runnable runnable) {
        zzdd zzdd;
        StrictMode.ThreadPolicy allowThreadDiskReads;
        if (!zzcc.zzb()) {
            synchronized (zzdd.class) {
                try {
                    zzdd = (zzdd) zza.get((Object) null);
                    if (zzdd == null) {
                        allowThreadDiskReads = StrictMode.allowThreadDiskReads();
                        throw null;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return zzdd;
        }
        throw null;
    }

    public static synchronized void zzc() {
        synchronized (zzdd.class) {
            Map map = zza;
            Iterator it = map.values().iterator();
            if (!it.hasNext()) {
                map.clear();
            } else {
                SharedPreferences sharedPreferences = ((zzdd) it.next()).zzb;
                throw null;
            }
        }
    }

    public final Object zzb(String str) {
        throw null;
    }
}
