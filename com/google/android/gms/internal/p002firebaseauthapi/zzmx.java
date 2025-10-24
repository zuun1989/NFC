package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Arrays;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzmx  reason: invalid package */
final class zzmx implements zzme {
    private final zzly zza;
    private final zzms zzb;

    public zzmx(zzly zzly) {
        zzms zzms;
        this.zza = zzly;
        try {
            zzms = zzmu.zzb();
        } catch (GeneralSecurityException unused) {
            zzms = new zzmw();
        }
        this.zzb = zzms;
    }

    public final byte[] zza(byte[] bArr, zzmh zzmh) throws GeneralSecurityException {
        byte[] zza2 = this.zzb.zza(zzmh.zza().zzb(), bArr);
        byte[] zza3 = zzzc.zza(bArr, zzmh.zzb().zzb());
        byte[] zza4 = zzmn.zza(zzmn.zzb);
        zzly zzly = this.zza;
        return zzly.zza((byte[]) null, zza2, "eae_prk", zza3, "shared_secret", zza4, zzly.zza());
    }

    public final byte[] zza() throws GeneralSecurityException {
        if (Arrays.equals(this.zza.zzb(), zzmn.zzf)) {
            return zzmn.zzb;
        }
        throw new GeneralSecurityException("Could not determine HPKE KEM ID");
    }
}
