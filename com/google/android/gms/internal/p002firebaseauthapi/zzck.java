package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzck  reason: invalid package */
public final class zzck {
    private static final zzck zza = new zzck();

    private zzck() {
    }

    public static zzck zza() {
        return zza;
    }

    public static zzck zza(zzck zzck) throws GeneralSecurityException {
        if (zzck != null) {
            return zzck;
        }
        throw new GeneralSecurityException("SecretKeyAccess is required");
    }
}
