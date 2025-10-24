package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzqk  reason: invalid package */
public final class zzqk {
    /* access modifiers changed from: private */
    public final Map<zzqm, zznw<?, ?>> zza;
    /* access modifiers changed from: private */
    public final Map<zzqj, zzns<?>> zzb;
    /* access modifiers changed from: private */
    public final Map<zzqm, zzpk<?, ?>> zzc;
    /* access modifiers changed from: private */
    public final Map<zzqj, zzpg<?>> zzd;

    public zzqk() {
        this.zza = new HashMap();
        this.zzb = new HashMap();
        this.zzc = new HashMap();
        this.zzd = new HashMap();
    }

    public final <SerializationT extends zzqi> zzqk zza(zzns<SerializationT> zzns) throws GeneralSecurityException {
        zzqj zzqj = new zzqj(zzns.zzb(), zzns.zza());
        if (this.zzb.containsKey(zzqj)) {
            zzns zzns2 = this.zzb.get(zzqj);
            if (!zzns2.equals(zzns) || !zzns.equals(zzns2)) {
                String valueOf = String.valueOf(zzqj);
                throw new GeneralSecurityException("Attempt to register non-equal parser for already existing object of type: " + valueOf);
            }
        } else {
            this.zzb.put(zzqj, zzns);
        }
        return this;
    }

    public zzqk(zzqh zzqh) {
        this.zza = new HashMap(zzqh.zza);
        this.zzb = new HashMap(zzqh.zzb);
        this.zzc = new HashMap(zzqh.zzc);
        this.zzd = new HashMap(zzqh.zzd);
    }

    public final <KeyT extends zzbh, SerializationT extends zzqi> zzqk zza(zznw<KeyT, SerializationT> zznw) throws GeneralSecurityException {
        zzqm zzqm = new zzqm(zznw.zza(), zznw.zzb());
        if (this.zza.containsKey(zzqm)) {
            zznw zznw2 = this.zza.get(zzqm);
            if (!zznw2.equals(zznw) || !zznw.equals(zznw2)) {
                String valueOf = String.valueOf(zzqm);
                throw new GeneralSecurityException("Attempt to register non-equal serializer for already existing object of type: " + valueOf);
            }
        } else {
            this.zza.put(zzqm, zznw);
        }
        return this;
    }

    public final <SerializationT extends zzqi> zzqk zza(zzpg<SerializationT> zzpg) throws GeneralSecurityException {
        zzqj zzqj = new zzqj(zzpg.zzb(), zzpg.zza());
        if (this.zzd.containsKey(zzqj)) {
            zzpg zzpg2 = this.zzd.get(zzqj);
            if (!zzpg2.equals(zzpg) || !zzpg.equals(zzpg2)) {
                String valueOf = String.valueOf(zzqj);
                throw new GeneralSecurityException("Attempt to register non-equal parser for already existing object of type: " + valueOf);
            }
        } else {
            this.zzd.put(zzqj, zzpg);
        }
        return this;
    }

    public final <ParametersT extends zzce, SerializationT extends zzqi> zzqk zza(zzpk<ParametersT, SerializationT> zzpk) throws GeneralSecurityException {
        zzqm zzqm = new zzqm(zzpk.zza(), zzpk.zzb());
        if (this.zzc.containsKey(zzqm)) {
            zzpk zzpk2 = this.zzc.get(zzqm);
            if (!zzpk2.equals(zzpk) || !zzpk.equals(zzpk2)) {
                String valueOf = String.valueOf(zzqm);
                throw new GeneralSecurityException("Attempt to register non-equal serializer for already existing object of type: " + valueOf);
            }
        } else {
            this.zzc.put(zzqm, zzpk);
        }
        return this;
    }

    public final zzqh zza() {
        return new zzqh(this);
    }
}
