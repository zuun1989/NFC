package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzky  reason: invalid package */
public final class zzky implements zzqc<zzbg, zzbg> {
    private static final zzky zza = new zzky();
    private static final zzpr<zzoe, zzbg> zzb = zzpr.zza(new zzlb(), zzoe.class, zzbg.class);

    public static void zzc() throws GeneralSecurityException {
        zzoz.zza().zza(zza);
        zzoz.zza().zza(zzb);
    }

    public final Class<zzbg> zza() {
        return zzbg.class;
    }

    public final Class<zzbg> zzb() {
        return zzbg.class;
    }

    public final /* synthetic */ Object zza(zzoa zzoa, zzoj zzoj, zzqb zzqb) throws GeneralSecurityException {
        zzon zzon;
        zzaam zzaam;
        zzpq zzpq = new zzpq();
        for (int i = 0; i < zzoa.zza(); i++) {
            zzod zza2 = zzoa.zza(i);
            if (zza2.zzc().equals(zzbj.zza)) {
                zzbg zzbg = (zzbg) zzqb.zza(zza2);
                zzbh zzb2 = zza2.zzb();
                if (zzb2 instanceof zzli) {
                    zzaam = ((zzli) zzb2).zzh();
                } else if (zzb2 instanceof zzoe) {
                    zzaam = ((zzoe) zzb2).zzc();
                } else {
                    String name = zzb2.getClass().getName();
                    String valueOf = String.valueOf(zzb2.zza());
                    throw new GeneralSecurityException("Cannot get output prefix for key of class " + name + " with parameters " + valueOf);
                }
                zzpq.zza(zzaam, new zzla(zzbg, zza2.zza()));
            }
        }
        if (!zzoj.zza()) {
            zzon = zzov.zzb().zza().zza(zzoa, zzoj, "hybrid_decrypt", "decrypt");
        } else {
            zzon = zzoq.zza;
        }
        return new zzld(zzpq.zza(), zzon);
    }

    public static void zza(zzpx zzpx) throws GeneralSecurityException {
        zzpx.zza(zza);
    }
}
