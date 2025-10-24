package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Arrays;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzln  reason: invalid package */
final class zzln implements zzmb {
    public final int zza() {
        return 32;
    }

    public final int zzb() {
        return 12;
    }

    public final byte[] zzc() {
        return zzmn.zzk;
    }

    public final byte[] zza(byte[] bArr, byte[] bArr2, byte[] bArr3, int i, byte[] bArr4) throws GeneralSecurityException {
        if (bArr.length != 32) {
            throw new InvalidAlgorithmParameterException("Unexpected key length: " + 32);
        } else if (zzhy.zza()) {
            return zzhy.zza(bArr).zza(bArr2, bArr3, i, bArr4);
        } else {
            return new zzhw(bArr).zza(bArr2, Arrays.copyOfRange(bArr3, i, bArr3.length), bArr4);
        }
    }
}
