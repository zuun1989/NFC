package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Arrays;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzlr  reason: invalid package */
final class zzlr implements zzlq {
    private final zzjh zza;
    private final int zzb;

    public zzlr(zzjh zzjh) {
        this.zza = zzjh;
        this.zzb = zzjh.zzb();
    }

    public final int zza() {
        return this.zzb;
    }

    public final byte[] zza(byte[] bArr, byte[] bArr2, int i) throws GeneralSecurityException {
        if (bArr2.length >= i) {
            return zzza.zza(zzja.zzc().zza(this.zza).zza(zzaan.zza(bArr, zzbi.zza())).zza()).zza(Arrays.copyOfRange(bArr2, i, bArr2.length), zzlm.zza);
        }
        throw new GeneralSecurityException("ciphertext too short");
    }
}
