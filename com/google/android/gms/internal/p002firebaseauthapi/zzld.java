package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzld  reason: invalid package */
final class zzld implements zzbg {
    private final zzpo<zzla> zza;
    private final zzon zzb;

    public zzld(zzpo<zzla> zzpo, zzon zzon) {
        this.zza = zzpo;
        this.zzb = zzon;
    }

    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        for (zzla next : this.zza.zza(bArr)) {
            try {
                byte[] zza2 = next.zza.zza(bArr, bArr2);
                this.zzb.zza(next.zzb, (long) bArr.length);
                return zza2;
            } catch (GeneralSecurityException unused) {
            }
        }
        this.zzb.zza();
        throw new GeneralSecurityException("decryption failed");
    }
}
