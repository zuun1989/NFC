package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.interfaces.ECPrivateKey;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzmq  reason: invalid package */
final class zzmq implements zzme {
    private final zzzh zza;
    private final zzly zzb;

    private zzmq(zzly zzly, zzzh zzzh) {
        this.zzb = zzly;
        this.zza = zzzh;
    }

    public static zzmq zza(zzzh zzzh) throws GeneralSecurityException {
        int i = zzmt.zza[zzzh.ordinal()];
        if (i == 1) {
            return new zzmq(new zzly("HmacSha256"), zzzh.NIST_P256);
        }
        if (i == 2) {
            return new zzmq(new zzly("HmacSha384"), zzzh.NIST_P384);
        }
        if (i == 3) {
            return new zzmq(new zzly("HmacSha512"), zzzh.NIST_P521);
        }
        String valueOf = String.valueOf(zzzh);
        throw new GeneralSecurityException("invalid curve type: " + valueOf);
    }

    public final byte[] zza(byte[] bArr, zzmh zzmh) throws GeneralSecurityException {
        ECPrivateKey zza2 = zzzi.zza(this.zza, zzmh.zza().zzb());
        zzzh zzzh = this.zza;
        byte[] zza3 = zzzi.zza(zza2, zzzi.zza(zzzi.zza(zzzh), zzzk.UNCOMPRESSED, bArr));
        byte[] zza4 = zzzc.zza(bArr, zzmh.zzb().zzb());
        byte[] zza5 = zzmn.zza(zza());
        zzly zzly = this.zzb;
        return zzly.zza((byte[]) null, zza3, "eae_prk", zza4, "shared_secret", zza5, zzly.zza());
    }

    public final byte[] zza() throws GeneralSecurityException {
        int i = zzmt.zza[this.zza.ordinal()];
        if (i == 1) {
            return zzmn.zzc;
        }
        if (i == 2) {
            return zzmn.zzd;
        }
        if (i == 3) {
            return zzmn.zze;
        }
        throw new GeneralSecurityException("Could not determine HPKE KEM ID");
    }
}
