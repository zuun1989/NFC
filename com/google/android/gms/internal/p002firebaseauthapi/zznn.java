package com.google.android.gms.internal.p002firebaseauthapi;

import java.lang.Enum;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zznn  reason: invalid package */
public final class zznn<E extends Enum<E>, O> {
    private Map<E, O> zza;
    private Map<O, E> zzb;

    public final zznn<E, O> zza(E e, O o) {
        this.zza.put(e, o);
        this.zzb.put(o, e);
        return this;
    }

    private zznn() {
        this.zza = new HashMap();
        this.zzb = new HashMap();
    }

    public final zznk<E, O> zza() {
        return new zznk<>(Collections.unmodifiableMap(this.zza), Collections.unmodifiableMap(this.zzb));
    }
}
