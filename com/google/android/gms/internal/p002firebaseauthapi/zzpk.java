package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzce;
import com.google.android.gms.internal.p002firebaseauthapi.zzqi;
import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzpk  reason: invalid package */
public abstract class zzpk<ParametersT extends zzce, SerializationT extends zzqi> {
    private final Class<ParametersT> zza;
    private final Class<SerializationT> zzb;

    public static <ParametersT extends zzce, SerializationT extends zzqi> zzpk<ParametersT, SerializationT> zza(zzpm<ParametersT, SerializationT> zzpm, Class<ParametersT> cls, Class<SerializationT> cls2) {
        return new zzpj(cls, cls2, zzpm);
    }

    public abstract SerializationT zza(ParametersT parameterst) throws GeneralSecurityException;

    public final Class<SerializationT> zzb() {
        return this.zzb;
    }

    private zzpk(Class<ParametersT> cls, Class<SerializationT> cls2) {
        this.zza = cls;
        this.zzb = cls2;
    }

    public final Class<ParametersT> zza() {
        return this.zza;
    }
}
