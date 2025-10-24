package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzpc  reason: invalid package */
public final class zzpc {
    private static final zzpc zza = ((zzpc) zzqo.zza(new zzpb()));
    private final AtomicReference<zzqh> zzb = new AtomicReference<>(new zzqk().zza());

    public final <SerializationT extends zzqi> zzbh zza(SerializationT serializationt, zzck zzck) throws GeneralSecurityException {
        return this.zzb.get().zza(serializationt, zzck);
    }

    public final <SerializationT extends zzqi> boolean zzb(SerializationT serializationt) {
        return this.zzb.get().zzb(serializationt);
    }

    public final <SerializationT extends zzqi> boolean zzc(SerializationT serializationt) {
        return this.zzb.get().zzc(serializationt);
    }

    public final <SerializationT extends zzqi> zzce zza(SerializationT serializationt) throws GeneralSecurityException {
        return this.zzb.get().zza(serializationt);
    }

    public static zzpc zza() {
        return zza;
    }

    public final <KeyT extends zzbh, SerializationT extends zzqi> SerializationT zza(KeyT keyt, Class<SerializationT> cls, zzck zzck) throws GeneralSecurityException {
        return this.zzb.get().zza(keyt, cls, zzck);
    }

    public final <ParametersT extends zzce, SerializationT extends zzqi> SerializationT zza(ParametersT parameterst, Class<SerializationT> cls) throws GeneralSecurityException {
        return this.zzb.get().zza(parameterst, cls);
    }

    public final synchronized <SerializationT extends zzqi> void zza(zzns<SerializationT> zzns) throws GeneralSecurityException {
        this.zzb.set(new zzqk(this.zzb.get()).zza(zzns).zza());
    }

    public final synchronized <KeyT extends zzbh, SerializationT extends zzqi> void zza(zznw<KeyT, SerializationT> zznw) throws GeneralSecurityException {
        this.zzb.set(new zzqk(this.zzb.get()).zza(zznw).zza());
    }

    public final synchronized <SerializationT extends zzqi> void zza(zzpg<SerializationT> zzpg) throws GeneralSecurityException {
        this.zzb.set(new zzqk(this.zzb.get()).zza(zzpg).zza());
    }

    public final synchronized <ParametersT extends zzce, SerializationT extends zzqi> void zza(zzpk<ParametersT, SerializationT> zzpk) throws GeneralSecurityException {
        this.zzb.set(new zzqk(this.zzb.get()).zza(zzpk).zza());
    }
}
