package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzmo  reason: invalid package */
public final class zzmo implements zzbf {
    private zzmo(zzbf zzbf, byte[] bArr) {
    }

    public static zzbf zza(zzoe zzoe) throws GeneralSecurityException {
        byte[] bArr;
        zzqe zza = zzoe.zza(zzbi.zza());
        zzbf zzbf = (zzbf) zznt.zza().zza(zza.zzf(), zzbf.class).zzb(zza.zzd());
        zzyc zzc = zza.zzc();
        int i = zzmr.zza[zzc.ordinal()];
        if (i == 1) {
            bArr = zzpd.zza.zzb();
        } else if (i == 2 || i == 3) {
            bArr = zzpd.zza(zzoe.zzb().intValue()).zzb();
        } else if (i == 4) {
            bArr = zzpd.zzb(zzoe.zzb().intValue()).zzb();
        } else {
            String valueOf = String.valueOf(zzc);
            throw new GeneralSecurityException("unknown output prefix type " + valueOf);
        }
        return new zzmo(zzbf, bArr);
    }
}
