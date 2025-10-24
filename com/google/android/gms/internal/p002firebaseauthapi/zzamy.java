package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzamy  reason: invalid package */
final class zzamy {
    private static final zzamy zza = new zzamy();
    private final zzanf zzb = new zzamb();
    private final ConcurrentMap<Class<?>, zzanc<?>> zzc = new ConcurrentHashMap();

    private zzamy() {
    }

    public static zzamy zza() {
        return zza;
    }

    public final <T> zzanc<T> zza(Class<T> cls) {
        zzali.zza(cls, "messageType");
        zzanc<T> zzanc = this.zzc.get(cls);
        if (zzanc != null) {
            return zzanc;
        }
        zzanc<T> zza2 = this.zzb.zza(cls);
        zzali.zza(cls, "messageType");
        zzali.zza(zza2, "schema");
        zzanc<T> putIfAbsent = this.zzc.putIfAbsent(cls, zza2);
        return putIfAbsent != null ? putIfAbsent : zza2;
    }

    public final <T> zzanc<T> zza(T t) {
        return zza(t.getClass());
    }
}
