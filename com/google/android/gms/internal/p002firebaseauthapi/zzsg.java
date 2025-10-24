package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzix;
import java.security.GeneralSecurityException;
import java.security.Provider;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzsg  reason: invalid package */
public final class zzsg implements zzqz {
    private static final zzix.zza zza = zzix.zza.ALGORITHM_NOT_FIPS;

    private zzsg(zzqp zzqp) {
    }

    public static zzqz zza(zzqp zzqp) throws GeneralSecurityException {
        if (zza.zza()) {
            Provider zza2 = zzng.zza();
            if (zza2 != null) {
                try {
                    return zzsh.zza(zzqp, zza2);
                } catch (GeneralSecurityException unused) {
                }
            }
            return new zzsg(zzqp);
        }
        throw new GeneralSecurityException("Cannot use AES-CMAC in FIPS-mode.");
    }
}
