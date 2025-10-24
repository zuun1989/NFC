package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzjl  reason: invalid package */
public final class zzjl implements zzqc<zzbd, zzbd> {
    private static final zzjl zza = new zzjl();
    private static final zzpr<zzoe, zzbd> zzb = zzpr.zza(new zzjo(), zzoe.class, zzbd.class);

    public static void zzc() throws GeneralSecurityException {
        zzoz.zza().zza(zza);
        zzoz.zza().zza(zzb);
    }

    public final Class<zzbd> zza() {
        return zzbd.class;
    }

    public final Class<zzbd> zzb() {
        return zzbd.class;
    }

    public final /* synthetic */ Object zza(zzoa zzoa, zzoj zzoj, zzqb zzqb) throws GeneralSecurityException {
        zzon zzon;
        zzon zzon2;
        zzaam zzaam;
        zzpq zzpq = new zzpq();
        for (int i = 0; i < zzoa.zza(); i++) {
            zzod zza2 = zzoa.zza(i);
            if (zza2.zzc().equals(zzbj.zza)) {
                zzbd zzbd = (zzbd) zzqb.zza(zza2);
                zzbh zzb2 = zza2.zzb();
                if (zzb2 instanceof zzjj) {
                    zzaam = ((zzjj) zzb2).zze();
                } else if (zzb2 instanceof zzoe) {
                    zzaam = ((zzoe) zzb2).zzc();
                } else {
                    String name = zzb2.getClass().getName();
                    String valueOf = String.valueOf(zzb2.zza());
                    throw new GeneralSecurityException("Cannot get output prefix for key of class " + name + " with parameters " + valueOf);
                }
                zzpq.zza(zzaam, new zzjn(zzbd, zza2.zza()));
            }
        }
        if (!zzoj.zza()) {
            zzoo zza3 = zzov.zzb().zza();
            zzon2 = zza3.zza(zzoa, zzoj, "daead", "encrypt");
            zzon = zza3.zza(zzoa, zzoj, "daead", "decrypt");
        } else {
            zzon2 = zzoq.zza;
            zzon = zzon2;
        }
        return new zzjq(new zzjn((zzbd) zzqb.zza(zzoa.zzc()), zzoa.zzc().zza()), zzpq.zza(), zzon2, zzon);
    }
}
