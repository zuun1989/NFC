package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzrq  reason: invalid package */
final class zzrq implements zzcb {
    private final zzrr zza;
    private final zzpo<zzrr> zzb;
    private final zzon zzc;
    private final zzon zzd;

    public final void zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        for (zzrr next : this.zzb.zza(bArr)) {
            try {
                next.zza.zza(bArr, bArr2);
                this.zzd.zza(next.zzb, (long) bArr2.length);
                return;
            } catch (GeneralSecurityException unused) {
            }
        }
        this.zzd.zza();
        throw new GeneralSecurityException("invalid MAC");
    }

    private zzrq(zzrr zzrr, zzpo<zzrr> zzpo, zzon zzon, zzon zzon2) {
        this.zza = zzrr;
        this.zzb = zzpo;
        this.zzc = zzon;
        this.zzd = zzon2;
    }

    public final byte[] zza(byte[] bArr) throws GeneralSecurityException {
        try {
            byte[] zza2 = this.zza.zza.zza(bArr);
            this.zzc.zza(this.zza.zzb, (long) bArr.length);
            return zza2;
        } catch (GeneralSecurityException e) {
            this.zzc.zza();
            throw e;
        }
    }
}
