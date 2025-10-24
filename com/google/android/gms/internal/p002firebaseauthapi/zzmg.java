package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzki;
import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzmg  reason: invalid package */
public final class zzmg {
    public static zzmb zza(zzki.zza zza) throws GeneralSecurityException {
        if (zza == zzki.zza.zza) {
            return new zzlk(16);
        }
        if (zza == zzki.zza.zzb) {
            return new zzlk(32);
        }
        if (zza == zzki.zza.zzc) {
            return new zzln();
        }
        throw new IllegalArgumentException("Unrecognized HPKE AEAD identifier");
    }

    public static zzmf zza(zzki.zze zze) {
        if (zze == zzki.zze.zza) {
            return new zzly("HmacSha256");
        }
        if (zze == zzki.zze.zzb) {
            return new zzly("HmacSha384");
        }
        if (zze == zzki.zze.zzc) {
            return new zzly("HmacSha512");
        }
        throw new IllegalArgumentException("Unrecognized HPKE KDF identifier");
    }

    public static zzme zza(zzki.zzd zzd) throws GeneralSecurityException {
        if (zzd == zzki.zzd.zzd) {
            return new zzmx(new zzly("HmacSha256"));
        }
        if (zzd == zzki.zzd.zza) {
            return zzmq.zza(zzzh.NIST_P256);
        }
        if (zzd == zzki.zzd.zzb) {
            return zzmq.zza(zzzh.NIST_P384);
        }
        if (zzd == zzki.zzd.zzc) {
            return zzmq.zza(zzzh.NIST_P521);
        }
        throw new IllegalArgumentException("Unrecognized HPKE KEM identifier");
    }
}
