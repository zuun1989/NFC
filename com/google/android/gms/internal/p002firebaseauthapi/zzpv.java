package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzpv  reason: invalid package */
public final class zzpv {
    /* access modifiers changed from: private */
    public final Map<zzqa, zzpr<?, ?>> zza;
    /* access modifiers changed from: private */
    public final Map<Class<?>, zzqc<?, ?>> zzb;

    public static zzpx zza() {
        return new zzpx();
    }

    private zzpv(zzpx zzpx) {
        this.zza = new HashMap(zzpx.zza);
        this.zzb = new HashMap(zzpx.zzb);
    }

    public static zzpx zza(zzpv zzpv) {
        return new zzpx(zzpv);
    }

    public final <KeyT extends zzbh, PrimitiveT> PrimitiveT zza(KeyT keyt, Class<PrimitiveT> cls) throws GeneralSecurityException {
        zzqa zzqa = new zzqa(keyt.getClass(), cls);
        if (this.zza.containsKey(zzqa)) {
            return this.zza.get(zzqa).zza(keyt);
        }
        String valueOf = String.valueOf(zzqa);
        throw new GeneralSecurityException("No PrimitiveConstructor for " + valueOf + " available, see https://developers.google.com/tink/faq/registration_errors");
    }

    public final <WrappedPrimitiveT> WrappedPrimitiveT zza(zzoa zzoa, zzoj zzoj, Class<WrappedPrimitiveT> cls) throws GeneralSecurityException {
        if (this.zzb.containsKey(cls)) {
            zzqc zzqc = this.zzb.get(cls);
            return zzqc.zza(zzoa, zzoj, new zzpy(this, zzqc));
        }
        String valueOf = String.valueOf(cls);
        throw new GeneralSecurityException("No wrapper found for " + valueOf);
    }
}
