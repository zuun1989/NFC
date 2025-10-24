package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzjq  reason: invalid package */
final class zzjq implements zzbd {
    private final zzpo<zzjn> zza;
    private final zzon zzb;

    public zzjq(zzjn zzjn, zzpo<zzjn> zzpo, zzon zzon, zzon zzon2) {
        this.zza = zzpo;
        this.zzb = zzon2;
    }

    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        for (zzjn next : this.zza.zza(bArr)) {
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
