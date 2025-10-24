package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzcn  reason: invalid package */
public final class zzcn {
    private static final zzno zza = zzb();

    public static /* synthetic */ zzaz zza(zzgb zzgb) {
        if (zzij.zza()) {
            return zzij.zza(zzgb);
        }
        return zzaaj.zza(zzgb);
    }

    private static zzno zzb() {
        Class<zzaz> cls = zzaz.class;
        try {
            zzpx zza2 = zzpv.zza();
            zzda.zza(zza2);
            zza2.zza(zzpr.zza(new zzcq(), zzdd.class, cls));
            zza2.zza(zzpr.zza(new zzcp(), zzds.class, cls));
            zza2.zza(zzpr.zza(new zzcs(), zzeb.class, cls));
            zza2.zza(zzpr.zza(new zzcr(), zzdl.class, cls));
            zza2.zza(zzpr.zza(new zzcu(), zzei.class, cls));
            zza2.zza(zzpr.zza(new zzct(), zzgb.class, cls));
            zza2.zza(zzpr.zza(new zzcw(), zzfv.class, cls));
            return zzno.zza(zza2.zza());
        } catch (GeneralSecurityException e) {
            throw new IllegalStateException(e);
        }
    }

    public static /* synthetic */ zzaz zza(zzei zzei) {
        if (zzhk.zzb()) {
            return zzhk.zza(zzei);
        }
        return zzzb.zza(zzei);
    }

    public static zzbe zza() throws GeneralSecurityException {
        if (!zzix.zzb()) {
            return zza;
        }
        throw new GeneralSecurityException("Cannot use non-FIPS-compliant AeadConfigurationV1 in FIPS mode");
    }
}
