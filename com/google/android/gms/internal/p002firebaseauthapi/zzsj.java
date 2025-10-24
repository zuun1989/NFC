package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzix;
import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzsj  reason: invalid package */
public final class zzsj implements zzqz {
    private static final zzix.zza zza = zzix.zza.ALGORITHM_REQUIRES_BORINGCRYPTO;

    public zzsj(zzrc zzrc) throws GeneralSecurityException {
        if (!zza.zza()) {
            throw new GeneralSecurityException("Can not use HMAC in FIPS-mode, as BoringCrypto module is not available.");
        }
    }
}
