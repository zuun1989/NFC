package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzix;
import java.security.GeneralSecurityException;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzyx  reason: invalid package */
public final class zzyx implements zzaz {
    private static final zzix.zza zza = zzix.zza.ALGORITHM_REQUIRES_BORINGCRYPTO;
    private final SecretKey zzb;
    private final byte[] zzc;

    private zzyx(byte[] bArr, zzaam zzaam) throws GeneralSecurityException {
        if (zza.zza()) {
            this.zzb = zzgu.zzb(bArr);
            this.zzc = zzaam.zzb();
            return;
        }
        throw new GeneralSecurityException("Can not use AES-GCM in FIPS-mode, as BoringCrypto module is not available.");
    }

    public static zzaz zza(zzds zzds) throws GeneralSecurityException {
        if (((zzdz) ((zzcx) zzds.zza())).zzb() != 12) {
            int zzb2 = ((zzdz) ((zzcx) zzds.zza())).zzb();
            throw new GeneralSecurityException("Expected IV Size 12, got " + zzb2);
        } else if (((zzdz) ((zzcx) zzds.zza())).zzd() == 16) {
            return new zzyx(zzds.zzf().zza(zzbi.zza()), zzds.zzd());
        } else {
            int zzd = ((zzdz) ((zzcx) zzds.zza())).zzd();
            throw new GeneralSecurityException("Expected tag Size 16, got " + zzd);
        }
    }

    public final byte[] zzb(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (bArr != null) {
            byte[] zza2 = zzqg.zza(12);
            AlgorithmParameterSpec zza3 = zzgu.zza(zza2);
            Cipher zza4 = zzgu.zza();
            zza4.init(1, this.zzb, zza3);
            if (!(bArr2 == null || bArr2.length == 0)) {
                zza4.updateAAD(bArr2);
            }
            int outputSize = zza4.getOutputSize(bArr.length);
            byte[] bArr3 = this.zzc;
            if (outputSize <= 2147483635 - bArr3.length) {
                byte[] copyOf = Arrays.copyOf(bArr3, bArr3.length + 12 + outputSize);
                System.arraycopy(zza2, 0, copyOf, this.zzc.length, 12);
                if (zza4.doFinal(bArr, 0, bArr.length, copyOf, this.zzc.length + 12) == outputSize) {
                    return copyOf;
                }
                throw new GeneralSecurityException("not enough data written");
            }
            throw new GeneralSecurityException("plaintext too long");
        }
        throw new NullPointerException("plaintext is null");
    }

    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (bArr != null) {
            int length = bArr.length;
            byte[] bArr3 = this.zzc;
            if (length < bArr3.length + 28) {
                throw new GeneralSecurityException("ciphertext too short");
            } else if (zzqq.zza(bArr3, bArr)) {
                AlgorithmParameterSpec zza2 = zzgu.zza(bArr, this.zzc.length, 12);
                Cipher zza3 = zzgu.zza();
                zza3.init(2, this.zzb, zza2);
                if (!(bArr2 == null || bArr2.length == 0)) {
                    zza3.updateAAD(bArr2);
                }
                byte[] bArr4 = this.zzc;
                return zza3.doFinal(bArr, bArr4.length + 12, (bArr.length - bArr4.length) - 12);
            } else {
                throw new GeneralSecurityException("Decryption failed (OutputPrefix mismatch).");
            }
        } else {
            throw new NullPointerException("ciphertext is null");
        }
    }
}
