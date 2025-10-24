package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzmc  reason: invalid package */
public final class zzmc implements zzbf {
    private zzmc(zzaam zzaam, zzme zzme, zzmf zzmf, zzmb zzmb, zzaam zzaam2) {
        zzaam.zzb();
        zzaam2.zzb();
    }

    public static zzbf zza(zzkt zzkt) throws GeneralSecurityException {
        zzki zzki = (zzki) ((zzlj) zzkt.zza());
        return new zzmc(zzkt.zze(), zzmg.zza(zzki.zze()), zzmg.zza(zzki.zzd()), zzmg.zza(zzki.zzb()), zzkt.zzd());
    }
}
