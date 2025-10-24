package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzqy  reason: invalid package */
public final class zzqy implements zzqc<zzqz, zzqz> {
    private static final zzqy zza = new zzqy();

    private zzqy() {
    }

    public static void zzc() throws GeneralSecurityException {
        zzoz.zza().zza(zza);
    }

    public final Class<zzqz> zza() {
        return zzqz.class;
    }

    public final Class<zzqz> zzb() {
        return zzqz.class;
    }

    public final /* synthetic */ Object zza(zzoa zzoa, zzoj zzoj, zzqb zzqb) throws GeneralSecurityException {
        zzaam zzaam;
        zzod zzc = zzoa.zzc();
        if (zzc != null) {
            zzpq zzpq = new zzpq();
            for (int i = 0; i < zzoa.zza(); i++) {
                zzod zza2 = zzoa.zza(i);
                if (zza2.zzc().equals(zzbj.zza)) {
                    zzqz zzqz = (zzqz) zzqb.zza(zza2);
                    zzbh zzb = zza2.zzb();
                    if (zzb instanceof zzrn) {
                        zzaam = ((zzrn) zzb).zze();
                    } else if (zzb instanceof zzoe) {
                        zzaam = ((zzoe) zzb).zzc();
                    } else {
                        String name = zzb.getClass().getName();
                        String valueOf = String.valueOf(zzb.zza());
                        throw new GeneralSecurityException("Cannot get output prefix for key of class " + name + " with parameters " + valueOf);
                    }
                    zzpq.zza(zzaam, zzqz);
                }
            }
            return new zzrb(zzpq.zza(), (zzqz) zzqb.zza(zzc));
        }
        throw new GeneralSecurityException("no primary in primitive set");
    }
}
