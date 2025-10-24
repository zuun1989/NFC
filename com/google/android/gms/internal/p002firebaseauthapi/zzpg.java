package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzqi;
import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzpg  reason: invalid package */
public abstract class zzpg<SerializationT extends zzqi> {
    private final zzaam zza;
    private final Class<SerializationT> zzb;

    public static <SerializationT extends zzqi> zzpg<SerializationT> zza(zzpi<SerializationT> zzpi, zzaam zzaam, Class<SerializationT> cls) {
        return new zzpf(zzaam, cls, zzpi);
    }

    public abstract zzce zza(SerializationT serializationt) throws GeneralSecurityException;

    public final Class<SerializationT> zzb() {
        return this.zzb;
    }

    private zzpg(zzaam zzaam, Class<SerializationT> cls) {
        this.zza = zzaam;
        this.zzb = cls;
    }

    public final zzaam zza() {
        return this.zza;
    }
}
