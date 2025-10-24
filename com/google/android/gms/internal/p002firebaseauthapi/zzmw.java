package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzmw  reason: invalid package */
final class zzmw implements zzms {
    private zzmw() {
    }

    public final zzmv zza() throws GeneralSecurityException {
        byte[] zza = zzaak.zza();
        return new zzmv(zza, zzaak.zza(zza));
    }

    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        return zzaak.zza(bArr, bArr2);
    }
}
