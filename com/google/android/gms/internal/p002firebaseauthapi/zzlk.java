package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzlk  reason: invalid package */
final class zzlk implements zzmb {
    private final int zza;

    public zzlk(int i) throws InvalidAlgorithmParameterException {
        if (i == 16 || i == 32) {
            this.zza = i;
            return;
        }
        throw new InvalidAlgorithmParameterException("Unsupported key length: " + i);
    }

    public final int zza() {
        return this.zza;
    }

    public final int zzb() {
        return 12;
    }

    public final byte[] zzc() throws GeneralSecurityException {
        int i = this.zza;
        if (i == 16) {
            return zzmn.zzi;
        }
        if (i == 32) {
            return zzmn.zzj;
        }
        throw new GeneralSecurityException("Could not determine HPKE AEAD ID");
    }

    public final byte[] zza(byte[] bArr, byte[] bArr2, byte[] bArr3, int i, byte[] bArr4) throws GeneralSecurityException {
        if (bArr.length == this.zza) {
            return new zzhr(bArr).zza(bArr2, bArr3, i, bArr4);
        }
        int length = bArr.length;
        throw new InvalidAlgorithmParameterException("Unexpected key length: " + length);
    }
}
