package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.internal.p002firebaseauthapi.zzix;
import java.security.GeneralSecurityException;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzhr  reason: invalid package */
public final class zzhr {
    private static final zzix.zza zza = zzix.zza.ALGORITHM_REQUIRES_BORINGCRYPTO;
    private final SecretKey zzb;

    public zzhr(byte[] bArr) throws GeneralSecurityException {
        if (zza.zza()) {
            this.zzb = zzgu.zzb(bArr);
            return;
        }
        throw new GeneralSecurityException("Can not use AES-GCM in FIPS-mode, as BoringCrypto module is not available.");
    }

    public final byte[] zza(byte[] bArr, byte[] bArr2, int i, byte[] bArr3) throws GeneralSecurityException {
        if (bArr.length != 12) {
            throw new GeneralSecurityException("iv is wrong size");
        } else if (bArr2.length >= i + 16) {
            AlgorithmParameterSpec zza2 = zzgu.zza(bArr);
            Cipher zza3 = zzgu.zza();
            zza3.init(2, this.zzb, zza2);
            if (!(bArr3 == null || bArr3.length == 0)) {
                zza3.updateAAD(bArr3);
            }
            return zza3.doFinal(bArr2, i, bArr2.length - i);
        } else {
            throw new GeneralSecurityException("ciphertext too short");
        }
    }

    public final byte[] zzb(byte[] bArr, byte[] bArr2, int i, byte[] bArr3) throws GeneralSecurityException {
        if (bArr.length == 12) {
            AlgorithmParameterSpec zza2 = zzgu.zza(bArr);
            Cipher zza3 = zzgu.zza();
            zza3.init(1, this.zzb, zza2);
            if (!(bArr3 == null || bArr3.length == 0)) {
                zza3.updateAAD(bArr3);
            }
            int outputSize = zza3.getOutputSize(bArr2.length);
            if (outputSize <= Api.BaseClientBuilder.API_PRIORITY_OTHER - i) {
                byte[] bArr4 = new byte[(i + outputSize)];
                if (zza3.doFinal(bArr2, 0, bArr2.length, bArr4, i) == outputSize) {
                    return bArr4;
                }
                throw new GeneralSecurityException("not enough data written");
            }
            throw new GeneralSecurityException("plaintext too long");
        }
        throw new GeneralSecurityException("iv is wrong size");
    }
}
