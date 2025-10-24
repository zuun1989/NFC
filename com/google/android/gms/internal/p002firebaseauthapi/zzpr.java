package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzbh;
import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzpr  reason: invalid package */
public abstract class zzpr<KeyT extends zzbh, PrimitiveT> {
    private final Class<KeyT> zza;
    private final Class<PrimitiveT> zzb;

    public static <KeyT extends zzbh, PrimitiveT> zzpr<KeyT, PrimitiveT> zza(zzpt<KeyT, PrimitiveT> zzpt, Class<KeyT> cls, Class<PrimitiveT> cls2) {
        return new zzpu(cls, cls2, zzpt);
    }

    public abstract PrimitiveT zza(KeyT keyt) throws GeneralSecurityException;

    public final Class<PrimitiveT> zzb() {
        return this.zzb;
    }

    private zzpr(Class<KeyT> cls, Class<PrimitiveT> cls2) {
        this.zza = cls;
        this.zzb = cls2;
    }

    public final Class<KeyT> zza() {
        return this.zza;
    }
}
