package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzpx  reason: invalid package */
public final class zzpx {
    /* access modifiers changed from: private */
    public final Map<zzqa, zzpr<?, ?>> zza;
    /* access modifiers changed from: private */
    public final Map<Class<?>, zzqc<?, ?>> zzb;

    public final <KeyT extends zzbh, PrimitiveT> zzpx zza(zzpr<KeyT, PrimitiveT> zzpr) throws GeneralSecurityException {
        if (zzpr != null) {
            zzqa zzqa = new zzqa(zzpr.zza(), zzpr.zzb());
            if (this.zza.containsKey(zzqa)) {
                zzpr zzpr2 = this.zza.get(zzqa);
                if (!zzpr2.equals(zzpr) || !zzpr.equals(zzpr2)) {
                    String valueOf = String.valueOf(zzqa);
                    throw new GeneralSecurityException("Attempt to register non-equal PrimitiveConstructor object for already existing object of type: " + valueOf);
                }
            } else {
                this.zza.put(zzqa, zzpr);
            }
            return this;
        }
        throw new NullPointerException("primitive constructor must be non-null");
    }

    private zzpx() {
        this.zza = new HashMap();
        this.zzb = new HashMap();
    }

    private zzpx(zzpv zzpv) {
        this.zza = new HashMap(zzpv.zza);
        this.zzb = new HashMap(zzpv.zzb);
    }

    public final <InputPrimitiveT, WrapperPrimitiveT> zzpx zza(zzqc<InputPrimitiveT, WrapperPrimitiveT> zzqc) throws GeneralSecurityException {
        if (zzqc != null) {
            Class<WrapperPrimitiveT> zzb2 = zzqc.zzb();
            if (this.zzb.containsKey(zzb2)) {
                zzqc zzqc2 = this.zzb.get(zzb2);
                if (!zzqc2.equals(zzqc) || !zzqc.equals(zzqc2)) {
                    String valueOf = String.valueOf(zzb2);
                    throw new GeneralSecurityException("Attempt to register non-equal PrimitiveWrapper object or input class object for already existing object of type" + valueOf);
                }
            } else {
                this.zzb.put(zzb2, zzqc);
            }
            return this;
        }
        throw new NullPointerException("wrapper must be non-null");
    }

    public final zzpv zza() {
        return new zzpv(this);
    }
}
