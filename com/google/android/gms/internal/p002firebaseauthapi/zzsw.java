package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzix;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.Key;
import java.security.Provider;
import java.util.Arrays;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzsw  reason: invalid package */
public final class zzsw implements zzst {
    private static final zzix.zza zza = zzix.zza.ALGORITHM_NOT_FIPS;
    private final Key zzb;
    private final Provider zzc;

    private zzsw(byte[] bArr, Provider provider) throws GeneralSecurityException {
        if (zza.zza()) {
            this.zzb = new SecretKeySpec(bArr, "AES");
            this.zzc = provider;
            return;
        }
        throw new GeneralSecurityException("Cannot use AES-CMAC in FIPS-mode, as BoringCrypto module is not available");
    }

    public static zzst zza(zzsr zzsr) throws GeneralSecurityException {
        Provider zza2 = zzng.zza();
        if (zza2 != null) {
            Mac.getInstance("AESCMAC", zza2);
            return new zzsw(zzsr.zzd().zza(zzbi.zza()), zza2);
        }
        throw new GeneralSecurityException("Conscrypt not available");
    }

    public final byte[] zza(byte[] bArr, int i) throws GeneralSecurityException {
        if (i <= 16) {
            Mac instance = Mac.getInstance("AESCMAC", this.zzc);
            instance.init(this.zzb);
            byte[] doFinal = instance.doFinal(bArr);
            if (i == doFinal.length) {
                return doFinal;
            }
            return Arrays.copyOf(doFinal, i);
        }
        throw new InvalidAlgorithmParameterException("outputLength must not be larger than 16");
    }
}
