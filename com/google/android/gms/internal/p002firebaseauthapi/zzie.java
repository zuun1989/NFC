package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Arrays;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzie  reason: invalid package */
public final class zzie implements zzaz {
    private final byte[] zza;
    private final int zzb;
    private final zzst zzc;

    private zzie(byte[] bArr, zzaam zzaam, int i) throws GeneralSecurityException {
        this.zzc = zzaac.zza(zzsr.zza(zzsq.zza(bArr.length), zzaan.zza(bArr, zzbi.zza())));
        this.zza = zzaam.zzb();
        this.zzb = i;
    }

    public static zzaz zza(zzfv zzfv) throws GeneralSecurityException {
        if (((zzfz) ((zzcx) zzfv.zza())).zzb() >= 8 && ((zzfz) ((zzcx) zzfv.zza())).zzb() <= 12) {
            return new zzie(zzfv.zze().zza(zzbi.zza()), zzfv.zzd(), ((zzfz) ((zzcx) zzfv.zza())).zzb());
        }
        throw new GeneralSecurityException("invalid salt size");
    }

    public final byte[] zzb(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (bArr != null) {
            byte[] zza2 = zzqg.zza(this.zzb + 12);
            byte[] copyOf = Arrays.copyOf(zza2, this.zzb);
            int i = this.zzb;
            byte[] copyOfRange = Arrays.copyOfRange(zza2, i, i + 12);
            byte[] zzb2 = new zzhr(zza(copyOf)).zzb(copyOfRange, bArr, this.zza.length + this.zzb + copyOfRange.length, bArr2);
            byte[] bArr3 = this.zza;
            System.arraycopy(bArr3, 0, zzb2, 0, bArr3.length);
            System.arraycopy(zza2, 0, zzb2, this.zza.length, zza2.length);
            return zzb2;
        }
        throw new NullPointerException("plaintext is null");
    }

    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (bArr != null) {
            int length = bArr.length;
            byte[] bArr3 = this.zza;
            if (length < bArr3.length + this.zzb + 28) {
                throw new GeneralSecurityException("ciphertext too short");
            } else if (zzqq.zza(bArr3, bArr)) {
                int length2 = this.zza.length + this.zzb;
                int i = length2 + 12;
                return new zzhr(zza(Arrays.copyOfRange(bArr, this.zza.length, length2))).zza(Arrays.copyOfRange(bArr, length2, i), bArr, i, bArr2);
            } else {
                throw new GeneralSecurityException("Decryption failed (OutputPrefix mismatch).");
            }
        } else {
            throw new NullPointerException("ciphertext is null");
        }
    }

    private final byte[] zza(byte[] bArr) throws GeneralSecurityException {
        byte[] bArr2 = {0, 1, 88, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        byte[] bArr3 = {0, 2, 88, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        if (bArr.length > 12 || bArr.length < 8) {
            throw new GeneralSecurityException("invalid salt size");
        }
        System.arraycopy(bArr, 0, bArr2, 4, bArr.length);
        System.arraycopy(bArr, 0, bArr3, 4, bArr.length);
        byte[] bArr4 = new byte[32];
        System.arraycopy(this.zzc.zza(bArr2, 16), 0, bArr4, 0, 16);
        System.arraycopy(this.zzc.zza(bArr3, 16), 0, bArr4, 16, 16);
        return bArr4;
    }
}
