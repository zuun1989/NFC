package com.google.android.gms.internal.p002firebaseauthapi;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zza  reason: invalid package */
public abstract class zza {
    private static zza zza = new zzc();

    public static synchronized zza zza() {
        zza zza2;
        synchronized (zza.class) {
            zza2 = zza;
        }
        return zza2;
    }

    public abstract URLConnection zza(URL url, String str) throws IOException;
}
