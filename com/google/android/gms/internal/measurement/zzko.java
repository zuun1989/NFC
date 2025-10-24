package com.google.android.gms.internal.measurement;

import G5.o;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.StrictMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import w0.a;

public final class zzko implements zzjv {
    private static final Map zza = new a();
    private final SharedPreferences zzb;
    private SharedPreferences.OnSharedPreferenceChangeListener zzc;
    private final Object zzd = new Object();
    private volatile Map zze;
    private final List zzf = new ArrayList();

    private zzko(SharedPreferences sharedPreferences, Runnable runnable) {
        this.zzb = sharedPreferences;
    }

    public static zzko zza(Context context, String str, Runnable runnable) {
        zzko zzko;
        SharedPreferences zza2;
        if (zzjm.zza() && !str.startsWith("direct_boot:") && !zzjm.zzc(context)) {
            return null;
        }
        synchronized (zzko.class) {
            Map map = zza;
            zzko = (zzko) map.get(str);
            if (zzko == null) {
                StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
                try {
                    if (str.startsWith("direct_boot:")) {
                        if (zzjm.zza()) {
                            context = context.createDeviceProtectedStorageContext();
                        }
                        zza2 = zzcf.zza(context, str.substring(12), 0, zzcb.zza);
                    } else {
                        zza2 = zzcf.zza(context, str, 0, zzcb.zza);
                    }
                    StrictMode.setThreadPolicy(allowThreadDiskReads);
                    zzko = new zzko(zza2, runnable);
                    zzkn zzkn = new zzkn(zzko);
                    zzko.zzc = zzkn;
                    zzko.zzb.registerOnSharedPreferenceChangeListener(zzkn);
                    map.put(str, zzko);
                } catch (Throwable th) {
                    StrictMode.setThreadPolicy(allowThreadDiskReads);
                    throw th;
                }
            }
        }
        return zzko;
    }

    public static synchronized void zzb() {
        synchronized (zzko.class) {
            try {
                Map map = zza;
                for (zzko zzko : map.values()) {
                    zzko.zzb.unregisterOnSharedPreferenceChangeListener((SharedPreferences.OnSharedPreferenceChangeListener) o.o(zzko.zzc));
                }
                map.clear();
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
    }

    public final /* synthetic */ void zzc(SharedPreferences sharedPreferences, String str) {
        synchronized (this.zzd) {
            this.zze = null;
            zzkm.zzc();
        }
        synchronized (this) {
            try {
                for (zzjs zza2 : this.zzf) {
                    zza2.zza();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final Object zze(String str) {
        StrictMode.ThreadPolicy allowThreadDiskReads;
        Map<String, ?> map = this.zze;
        if (map == null) {
            synchronized (this.zzd) {
                try {
                    map = this.zze;
                    if (map == null) {
                        allowThreadDiskReads = StrictMode.allowThreadDiskReads();
                        Map<String, ?> all = this.zzb.getAll();
                        this.zze = all;
                        StrictMode.setThreadPolicy(allowThreadDiskReads);
                        map = all;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        if (map != null) {
            return map.get(str);
        }
        return null;
    }
}
