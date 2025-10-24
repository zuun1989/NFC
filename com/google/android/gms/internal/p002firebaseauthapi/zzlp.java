package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Arrays;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzlp  reason: invalid package */
final class zzlp implements zzlq {
    private final zzdk zza;
    private final int zzb;

    public zzlp(zzdk zzdk) {
        this.zza = zzdk;
        this.zzb = zzdk.zzb() + zzdk.zzc();
    }

    public final int zza() {
        return this.zzb;
    }

    public final byte[] zza(byte[] bArr, byte[] bArr2, int i) throws GeneralSecurityException {
        if (bArr2.length >= i) {
            return zzzj.zza(zzdd.zze().zza(this.zza).zza(zzaan.zza(Arrays.copyOf(bArr, this.zza.zzb()), zzbi.zza())).zzb(zzaan.zza(Arrays.copyOfRange(bArr, this.zza.zzb(), this.zza.zzb() + this.zza.zzc()), zzbi.zza())).zza()).zza(Arrays.copyOfRange(bArr2, i, bArr2.length), zzlm.zza);
        }
        throw new GeneralSecurityException("ciphertext too short");
    }
}
