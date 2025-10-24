package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzda  reason: invalid package */
public final class zzda implements zzqc<zzaz, zzaz> {
    private static final zzda zza = new zzda();
    private static final zzpr<zzoe, zzaz> zzb = zzpr.zza(new zzcz(), zzoe.class, zzaz.class);

    public static void zzc() throws GeneralSecurityException {
        zzoz.zza().zza(zza);
        zzoz.zza().zza(zzb);
    }

    public final Class<zzaz> zza() {
        return zzaz.class;
    }

    public final Class<zzaz> zzb() {
        return zzaz.class;
    }

    public final /* synthetic */ Object zza(zzoa zzoa, zzoj zzoj, zzqb zzqb) throws GeneralSecurityException {
        zzon zzon;
        zzon zzon2;
        zzaam zzaam;
        zzpq zzpq = new zzpq();
        for (int i = 0; i < zzoa.zza(); i++) {
            zzod zza2 = zzoa.zza(i);
            if (zza2.zzc().equals(zzbj.zza)) {
                zzbh zzb2 = zza2.zzb();
                if (zzb2 instanceof zzcv) {
                    zzaam = ((zzcv) zzb2).zzd();
                } else if (zzb2 instanceof zzoe) {
                    zzaam = ((zzoe) zzb2).zzc();
                } else {
                    String name = zzb2.getClass().getName();
                    String valueOf = String.valueOf(zzb2.zza());
                    throw new GeneralSecurityException("Cannot get output prefix for key of class " + name + " with parameters " + valueOf);
                }
                zzpq.zza(zzaam, new zzdc((zzaz) zzqb.zza(zza2), zza2.zza()));
            }
        }
        if (!zzoj.zza()) {
            zzoo zza3 = zzov.zzb().zza();
            zzon zza4 = zza3.zza(zzoa, zzoj, "aead", "encrypt");
            zzon = zza3.zza(zzoa, zzoj, "aead", "decrypt");
            zzon2 = zza4;
        } else {
            zzon2 = zzoq.zza;
            zzon = zzon2;
        }
        return new zzdb(new zzdc((zzaz) zzqb.zza(zzoa.zzc()), zzoa.zzc().zza()), zzpq.zza(), zzon2, zzon);
    }

    public static void zza(zzpx zzpx) throws GeneralSecurityException {
        zzpx.zza(zza);
    }
}
