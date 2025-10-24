package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzbh;
import com.google.android.gms.internal.p002firebaseauthapi.zzqi;
import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zznw  reason: invalid package */
public abstract class zznw<KeyT extends zzbh, SerializationT extends zzqi> {
    private final Class<KeyT> zza;
    private final Class<SerializationT> zzb;

    public static <KeyT extends zzbh, SerializationT extends zzqi> zznw<KeyT, SerializationT> zza(zzny<KeyT, SerializationT> zzny, Class<KeyT> cls, Class<SerializationT> cls2) {
        return new zznz(cls, cls2, zzny);
    }

    public abstract SerializationT zza(KeyT keyt, zzck zzck) throws GeneralSecurityException;

    public final Class<SerializationT> zzb() {
        return this.zzb;
    }

    private zznw(Class<KeyT> cls, Class<SerializationT> cls2) {
        this.zza = cls;
        this.zzb = cls2;
    }

    public final Class<KeyT> zza() {
        return this.zza;
    }
}
