package com.google.android.gms.internal.auth;

import I0.f;
import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import android.util.Log;

final class zzco implements zzcl {
    private static zzco zza;
    private final Context zzb;
    private final ContentObserver zzc;

    private zzco() {
        this.zzb = null;
        this.zzc = null;
    }

    public static zzco zza(Context context) {
        zzco zzco;
        zzco zzco2;
        synchronized (zzco.class) {
            try {
                if (zza == null) {
                    if (f.c(context, "com.google.android.providers.gsf.permission.READ_GSERVICES") == 0) {
                        zzco2 = new zzco(context);
                    } else {
                        zzco2 = new zzco();
                    }
                    zza = zzco2;
                }
                zzco = zza;
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzco;
    }

    public static synchronized void zze() {
        Context context;
        synchronized (zzco.class) {
            try {
                zzco zzco = zza;
                if (!(zzco == null || (context = zzco.zzb) == null || zzco.zzc == null)) {
                    context.getContentResolver().unregisterContentObserver(zza.zzc);
                }
                zza = null;
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
    }

    /* renamed from: zzc */
    public final String zzb(String str) {
        Context context = this.zzb;
        if (context != null && !zzcc.zza(context)) {
            try {
                return (String) zzcj.zza(new zzcm(this, str));
            } catch (IllegalStateException | NullPointerException | SecurityException e) {
                Log.e("GservicesLoader", "Unable to read GServices for: ".concat(String.valueOf(str)), e);
            }
        }
        return null;
    }

    public final /* synthetic */ String zzd(String str) {
        return zzcb.zza(this.zzb.getContentResolver(), str, (String) null);
    }

    private zzco(Context context) {
        this.zzb = context;
        zzcn zzcn = new zzcn(this, (Handler) null);
        this.zzc = zzcn;
        context.getContentResolver().registerContentObserver(zzcb.zza, true, zzcn);
    }
}
