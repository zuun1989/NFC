package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzqh  reason: invalid package */
public final class zzqh {
    /* access modifiers changed from: private */
    public final Map<zzqm, zznw<?, ?>> zza;
    /* access modifiers changed from: private */
    public final Map<zzqj, zzns<?>> zzb;
    /* access modifiers changed from: private */
    public final Map<zzqm, zzpk<?, ?>> zzc;
    /* access modifiers changed from: private */
    public final Map<zzqj, zzpg<?>> zzd;

    private zzqh(zzqk zzqk) {
        this.zza = new HashMap(zzqk.zza);
        this.zzb = new HashMap(zzqk.zzb);
        this.zzc = new HashMap(zzqk.zzc);
        this.zzd = new HashMap(zzqk.zzd);
    }

    public final <SerializationT extends zzqi> zzbh zza(SerializationT serializationt, zzck zzck) throws GeneralSecurityException {
        zzqj zzqj = new zzqj(serializationt.getClass(), serializationt.zzb());
        if (this.zzb.containsKey(zzqj)) {
            return this.zzb.get(zzqj).zza(serializationt, zzck);
        }
        String valueOf = String.valueOf(zzqj);
        throw new GeneralSecurityException("No Key Parser for requested key type " + valueOf + " available");
    }

    public final <SerializationT extends zzqi> boolean zzb(SerializationT serializationt) {
        return this.zzb.containsKey(new zzqj(serializationt.getClass(), serializationt.zzb()));
    }

    public final <SerializationT extends zzqi> boolean zzc(SerializationT serializationt) {
        return this.zzd.containsKey(new zzqj(serializationt.getClass(), serializationt.zzb()));
    }

    public final <SerializationT extends zzqi> zzce zza(SerializationT serializationt) throws GeneralSecurityException {
        zzqj zzqj = new zzqj(serializationt.getClass(), serializationt.zzb());
        if (this.zzd.containsKey(zzqj)) {
            return this.zzd.get(zzqj).zza(serializationt);
        }
        String valueOf = String.valueOf(zzqj);
        throw new GeneralSecurityException("No Parameters Parser for requested key type " + valueOf + " available");
    }

    public final <KeyT extends zzbh, SerializationT extends zzqi> SerializationT zza(KeyT keyt, Class<SerializationT> cls, zzck zzck) throws GeneralSecurityException {
        zzqm zzqm = new zzqm(keyt.getClass(), cls);
        if (this.zza.containsKey(zzqm)) {
            return this.zza.get(zzqm).zza(keyt, zzck);
        }
        String valueOf = String.valueOf(zzqm);
        throw new GeneralSecurityException("No Key serializer for " + valueOf + " available");
    }

    public final <ParametersT extends zzce, SerializationT extends zzqi> SerializationT zza(ParametersT parameterst, Class<SerializationT> cls) throws GeneralSecurityException {
        zzqm zzqm = new zzqm(parameterst.getClass(), cls);
        if (this.zzc.containsKey(zzqm)) {
            return this.zzc.get(zzqm).zza(parameterst);
        }
        String valueOf = String.valueOf(zzqm);
        throw new GeneralSecurityException("No Key Format serializer for " + valueOf + " available");
    }
}
