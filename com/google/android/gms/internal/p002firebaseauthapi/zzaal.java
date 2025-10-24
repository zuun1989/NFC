package com.google.android.gms.internal.p002firebaseauthapi;

import java.math.BigInteger;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaal  reason: invalid package */
public final class zzaal {
    private final BigInteger zza;

    private zzaal(BigInteger bigInteger) {
        this.zza = bigInteger;
    }

    public static zzaal zza(BigInteger bigInteger, zzck zzck) {
        if (zzck != null) {
            return new zzaal(bigInteger);
        }
        throw new NullPointerException("SecretKeyAccess required");
    }

    public final BigInteger zza(zzck zzck) {
        if (zzck != null) {
            return this.zza;
        }
        throw new NullPointerException("SecretKeyAccess required");
    }
}
