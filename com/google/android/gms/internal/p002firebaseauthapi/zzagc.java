package com.google.android.gms.internal.p002firebaseauthapi;

import android.app.Activity;
import com.google.android.gms.common.util.DefaultClock;
import com.google.firebase.auth.b;
import java.util.Map;
import java.util.concurrent.Executor;
import w0.a;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzagc  reason: invalid package */
public final class zzagc {
    private static final Map<String, zzage> zza = new a();

    public static b.b zza(String str, b.b bVar, zzafg zzafg) {
        zza(str, zzafg);
        return new zzagb(bVar, str);
    }

    public static void zza() {
        zza.clear();
    }

    private static void zza(String str, zzafg zzafg) {
        zza.put(str, new zzage(zzafg, DefaultClock.getInstance().currentTimeMillis()));
    }

    public static boolean zza(String str, b.b bVar, Activity activity, Executor executor) {
        Map<String, zzage> map = zza;
        if (map.containsKey(str)) {
            zzage zzage = map.get(str);
            if (DefaultClock.getInstance().currentTimeMillis() - zzage.zzb < 120000) {
                zzafg zzafg = zzage.zza;
                if (zzafg == null) {
                    return true;
                }
                zzafg.zza(bVar, activity, executor, str);
                return true;
            }
            zza(str, (zzafg) null);
            return false;
        }
        zza(str, (zzafg) null);
        return false;
    }
}
