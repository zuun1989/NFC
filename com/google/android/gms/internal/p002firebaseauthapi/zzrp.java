package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzrp  reason: invalid package */
public final class zzrp implements zzqc<zzcb, zzcb> {
    private static final zzrp zza = new zzrp();
    private static final zzpr<zzoe, zzcb> zzb = zzpr.zza(new zzro(), zzoe.class, zzcb.class);

    public static void zzc() throws GeneralSecurityException {
        zzoz.zza().zza(zza);
        zzoz.zza().zza(zzb);
    }

    public final Class<zzcb> zza() {
        return zzcb.class;
    }

    public final Class<zzcb> zzb() {
        return zzcb.class;
    }

    public final /* synthetic */ Object zza(zzoa zzoa, zzoj zzoj, zzqb zzqb) throws GeneralSecurityException {
        zzon zzon;
        zzon zzon2;
        zzaam zzaam;
        zzpq zzpq = new zzpq();
        for (int i = 0; i < zzoa.zza(); i++) {
            zzod zza2 = zzoa.zza(i);
            if (zza2.zzc().equals(zzbj.zza)) {
                zzcb zzcb = (zzcb) zzqb.zza(zza2);
                zzbh zzb2 = zza2.zzb();
                if (zzb2 instanceof zzrn) {
                    zzaam = ((zzrn) zzb2).zze();
                } else if (zzb2 instanceof zzoe) {
                    zzaam = ((zzoe) zzb2).zzc();
                } else {
                    String name = zzb2.getClass().getName();
                    String valueOf = String.valueOf(zzb2.zza());
                    throw new GeneralSecurityException("Cannot get output prefix for key of class " + name + " with parameters " + valueOf);
                }
                zzpq.zza(zzaam, new zzrr(zzcb, zza2.zza()));
            }
        }
        if (!zzoj.zza()) {
            zzoo zza3 = zzov.zzb().zza();
            zzon zza4 = zza3.zza(zzoa, zzoj, "mac", "compute");
            zzon = zza3.zza(zzoa, zzoj, "mac", "verify");
            zzon2 = zza4;
        } else {
            zzon2 = zzoq.zza;
            zzon = zzon2;
        }
        return new zzrq(new zzrr((zzcb) zzqb.zza(zzoa.zzc()), zzoa.zzc().zza()), zzpq.zza(), zzon2, zzon);
    }
}
