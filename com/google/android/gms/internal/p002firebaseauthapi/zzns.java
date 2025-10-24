package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzqi;
import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzns  reason: invalid package */
public abstract class zzns<SerializationT extends zzqi> {
    private final zzaam zza;
    private final Class<SerializationT> zzb;

    public static <SerializationT extends zzqi> zzns<SerializationT> zza(zznu<SerializationT> zznu, zzaam zzaam, Class<SerializationT> cls) {
        return new zznv(zzaam, cls, zznu);
    }

    public abstract zzbh zza(SerializationT serializationt, zzck zzck) throws GeneralSecurityException;

    public final Class<SerializationT> zzb() {
        return this.zzb;
    }

    private zzns(zzaam zzaam, Class<SerializationT> cls) {
        this.zza = zzaam;
        this.zzb = cls;
    }

    public final zzaam zza() {
        return this.zza;
    }
}
