package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Iterator;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzalt  reason: invalid package */
final class zzalt<K> implements Iterator<Map.Entry<K, Object>> {
    private Iterator<Map.Entry<K, Object>> zza;

    public zzalt(Iterator<Map.Entry<K, Object>> it) {
        this.zza = it;
    }

    public final boolean hasNext() {
        return this.zza.hasNext();
    }

    public final /* synthetic */ Object next() {
        Map.Entry next = this.zza.next();
        if (next.getValue() instanceof zzalr) {
            return new zzalq(next);
        }
        return next;
    }

    public final void remove() {
        this.zza.remove();
    }
}
