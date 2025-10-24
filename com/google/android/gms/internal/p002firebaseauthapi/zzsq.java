package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Objects;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzsq  reason: invalid package */
public final class zzsq extends zzsv {
    private final int zza;

    private zzsq(int i) {
        this.zza = i;
    }

    public final boolean equals(Object obj) {
        if ((obj instanceof zzsq) && ((zzsq) obj).zza == this.zza) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(new Object[]{zzsq.class, Integer.valueOf(this.zza)});
    }

    public final String toString() {
        int i = this.zza;
        return "AesCmac PRF Parameters (" + i + "-byte key)";
    }

    public final boolean zza() {
        return false;
    }

    public final int zzb() {
        return this.zza;
    }

    public static zzsq zza(int i) throws GeneralSecurityException {
        if (i == 16 || i == 32) {
            return new zzsq(i);
        }
        throw new InvalidAlgorithmParameterException(String.format("Invalid key size %d; only 128-bit and 256-bit are supported", new Object[]{Integer.valueOf(i << 3)}));
    }
}
