package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaab  reason: invalid package */
final class zzaab implements zzst {
    private final zzst zza;
    private final zzst zzb;

    public final byte[] zza(byte[] bArr, int i) throws GeneralSecurityException {
        if (bArr.length <= 64) {
            return this.zza.zza(bArr, i);
        }
        return this.zzb.zza(bArr, i);
    }

    private zzaab(zzst zzst, zzst zzst2) {
        this.zza = zzst;
        this.zzb = zzst2;
    }
}
