package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzdb  reason: invalid package */
final class zzdb implements zzaz {
    private final zzdc zza;
    private final zzpo<zzdc> zzb;
    private final zzon zzc;
    private final zzon zzd;

    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        for (zzdc next : this.zzb.zza(bArr)) {
            try {
                byte[] zza2 = next.zza.zza(bArr, bArr2);
                this.zzd.zza(next.zzb, (long) bArr.length);
                return zza2;
            } catch (GeneralSecurityException unused) {
            }
        }
        this.zzd.zza();
        throw new GeneralSecurityException("decryption failed");
    }

    public final byte[] zzb(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        try {
            byte[] zzb2 = this.zza.zza.zzb(bArr, bArr2);
            this.zzc.zza(this.zza.zzb, (long) bArr.length);
            return zzb2;
        } catch (GeneralSecurityException e) {
            this.zzc.zza();
            throw e;
        }
    }

    private zzdb(zzdc zzdc, zzpo<zzdc> zzpo, zzon zzon, zzon zzon2) {
        this.zza = zzdc;
        this.zzb = zzpo;
        this.zzc = zzon;
        this.zzd = zzon2;
    }
}
