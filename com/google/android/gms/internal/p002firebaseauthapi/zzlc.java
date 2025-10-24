package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzlc  reason: invalid package */
public final class zzlc implements zzqc<zzbf, zzbf> {
    private static final zzlc zza = new zzlc();
    private static final zzpr<zzoe, zzbf> zzb = zzpr.zza(new zzlf(), zzoe.class, zzbf.class);

    public static void zzc() throws GeneralSecurityException {
        zzoz.zza().zza(zza);
        zzoz.zza().zza(zzb);
    }

    public final Class<zzbf> zza() {
        return zzbf.class;
    }

    public final Class<zzbf> zzb() {
        return zzbf.class;
    }

    public final /* synthetic */ Object zza(zzoa zzoa, zzoj zzoj, zzqb zzqb) throws GeneralSecurityException {
        zzon zzon;
        if (!zzoj.zza()) {
            zzon = zzov.zzb().zza().zza(zzoa, zzoj, "hybrid_encrypt", "encrypt");
        } else {
            zzon = zzoq.zza;
        }
        zzod zzc = zzoa.zzc();
        return new zzlh(new zzle((zzbf) zzqb.zza(zzc), zzc.zza()), zzon);
    }

    public static void zza(zzpx zzpx) throws GeneralSecurityException {
        zzpx.zza(zza);
    }
}
