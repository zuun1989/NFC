package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzkv  reason: invalid package */
public final class zzkv {
    private static final zzno zza = zzb();

    public static zzbe zza() throws GeneralSecurityException {
        if (!zzix.zzb()) {
            return zza;
        }
        throw new GeneralSecurityException("Cannot use non-FIPS-compliant HybridConfigurationV1 in FIPS mode");
    }

    private static zzno zzb() {
        Class<zzbg> cls = zzbg.class;
        Class<zzbf> cls2 = zzbf.class;
        try {
            zzpx zza2 = zzpv.zza();
            zzlc.zza(zza2);
            zza2.zza(zzpr.zza(new zzku(), zzkg.class, cls2));
            zza2.zza(zzpr.zza(new zzkx(), zzkt.class, cls2));
            zzky.zza(zza2);
            zza2.zza(zzpr.zza(new zzkw(), zzkh.class, cls));
            zza2.zza(zzpr.zza(new zzkz(), zzkl.class, cls));
            return zzno.zza(zza2.zza());
        } catch (GeneralSecurityException e) {
            throw new IllegalStateException(e);
        }
    }
}
