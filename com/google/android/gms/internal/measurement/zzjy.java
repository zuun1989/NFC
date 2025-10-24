package com.google.android.gms.internal.measurement;

import G5.o;
import I0.f;
import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import android.util.Log;

final class zzjy implements zzjv {
    private static zzjy zza;
    private final Context zzb;
    private final ContentObserver zzc;
    private boolean zzd;

    private zzjy() {
        this.zzd = false;
        this.zzb = null;
        this.zzc = null;
    }

    public static zzjy zza(Context context) {
        zzjy zzjy;
        zzjy zzjy2;
        synchronized (zzjy.class) {
            try {
                if (zza == null) {
                    if (f.c(context, "com.google.android.providers.gsf.permission.READ_GSERVICES") == 0) {
                        zzjy2 = new zzjy(context);
                    } else {
                        zzjy2 = new zzjy();
                    }
                    zza = zzjy2;
                }
                zzjy zzjy3 = zza;
                if (!(zzjy3 == null || zzjy3.zzc == null || zzjy3.zzd)) {
                    context.getContentResolver().registerContentObserver(zzjg.zza, true, zza.zzc);
                    ((zzjy) o.o(zza)).zzd = true;
                }
            } catch (SecurityException e) {
                Log.e("GservicesLoader", "Unable to register Gservices content observer", e);
            } catch (Throwable th) {
                throw th;
            }
            zzjy = (zzjy) o.o(zza);
        }
        return zzjy;
    }

    public static synchronized void zzc() {
        Context context;
        synchronized (zzjy.class) {
            try {
                zzjy zzjy = zza;
                if (!(zzjy == null || (context = zzjy.zzb) == null || zzjy.zzc == null || !zzjy.zzd)) {
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

    /* renamed from: zzb */
    public final String zze(String str) {
        Context context = this.zzb;
        if (context != null && !zzjm.zzb(context)) {
            try {
                return (String) zzjv.zzh(new zzjx(this, str));
            } catch (IllegalStateException | NullPointerException | SecurityException e) {
                Log.e("GservicesLoader", "Unable to read GServices for: ".concat(str), e);
            }
        }
        return null;
    }

    public final /* synthetic */ String zzd(String str) {
        return zzjf.zza(((Context) o.o(this.zzb)).getContentResolver(), str, (String) null);
    }

    private zzjy(Context context) {
        this.zzd = false;
        this.zzb = context;
        this.zzc = new zzjw(this, (Handler) null);
    }
}
