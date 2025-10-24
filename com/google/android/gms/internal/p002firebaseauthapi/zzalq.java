package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzalq  reason: invalid package */
final class zzalq<K> implements Map.Entry<K, Object> {
    private Map.Entry<K, zzalr> zza;

    public final K getKey() {
        return this.zza.getKey();
    }

    public final Object getValue() {
        if (this.zza.getValue() == null) {
            return null;
        }
        throw new NoSuchMethodError();
    }

    public final Object setValue(Object obj) {
        if (obj instanceof zzamn) {
            return this.zza.getValue().zza((zzamn) obj);
        }
        throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
    }

    public final zzalr zza() {
        return this.zza.getValue();
    }

    private zzalq(Map.Entry<K, zzalr> entry) {
        this.zza = entry;
    }
}
