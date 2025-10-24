package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzdz;
import java.security.GeneralSecurityException;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzlo  reason: invalid package */
final class zzlo implements zzlq {
    private final int zza;

    public zzlo(zzdz zzdz) throws GeneralSecurityException {
        if (zzdz.zzb() != 12) {
            throw new GeneralSecurityException("invalid IV size");
        } else if (zzdz.zzd() != 16) {
            throw new GeneralSecurityException("invalid tag size");
        } else if (zzdz.zzf() == zzdz.zzb.zzc) {
            this.zza = zzdz.zzc();
        } else {
            throw new GeneralSecurityException("invalid variant");
        }
    }

    public final int zza() {
        return this.zza;
    }

    public final byte[] zza(byte[] bArr, byte[] bArr2, int i) throws GeneralSecurityException {
        if (bArr2.length < i) {
            throw new GeneralSecurityException("ciphertext too short");
        } else if (bArr.length == this.zza) {
            SecretKey zzb = zzgu.zzb(bArr);
            int i2 = i + 12;
            if (bArr2.length >= i + 28) {
                AlgorithmParameterSpec zza2 = zzgu.zza(bArr2, i, 12);
                Cipher zza3 = zzgu.zza();
                zza3.init(2, zzb, zza2);
                return zza3.doFinal(bArr2, i2, (bArr2.length - i) - 12);
            }
            throw new GeneralSecurityException("ciphertext too short");
        } else {
            throw new GeneralSecurityException("invalid key size");
        }
    }
}
