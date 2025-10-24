package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzpa  reason: invalid package */
public final class zzpa {
    private static final zzpa zza = new zzpa();
    private final Map<String, zzce> zzb = new HashMap();

    public static zzpa zza() {
        return zza;
    }

    private final synchronized void zza(String str, zzce zzce) throws GeneralSecurityException {
        try {
            if (!this.zzb.containsKey(str)) {
                this.zzb.put(str, zzce);
            } else if (!this.zzb.get(str).equals(zzce)) {
                String valueOf = String.valueOf(this.zzb.get(str));
                String valueOf2 = String.valueOf(zzce);
                throw new GeneralSecurityException("Parameters object with name " + str + " already exists (" + valueOf + "), cannot insert " + valueOf2);
            }
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
    }

    public final synchronized void zza(Map<String, zzce> map) throws GeneralSecurityException {
        for (Map.Entry next : map.entrySet()) {
            zza((String) next.getKey(), (zzce) next.getValue());
        }
    }
}
