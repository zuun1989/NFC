package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzix;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzsh  reason: invalid package */
public final class zzsh implements zzqz {
    private static final zzix.zza zza = zzix.zza.ALGORITHM_NOT_FIPS;

    private zzsh(zzqp zzqp, Provider provider) throws GeneralSecurityException {
        if (provider == null) {
            throw new IllegalArgumentException("conscrypt is null");
        } else if (zza.zza()) {
            try {
                Mac.getInstance("AESCMAC", provider);
                zzqp.zze().zzb();
                new SecretKeySpec(zzqp.zzf().zza(zzbi.zza()), "AES");
            } catch (NoSuchAlgorithmException e) {
                throw new GeneralSecurityException("AES-CMAC not available.", e);
            }
        } else {
            throw new GeneralSecurityException("Cannot use AES-CMAC in FIPS-mode.");
        }
    }

    public static zzqz zza(zzqp zzqp, Provider provider) throws GeneralSecurityException {
        return new zzsh(zzqp, provider);
    }
}
