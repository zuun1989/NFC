package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaac  reason: invalid package */
public final class zzaac implements zzst {
    public static zzst zza(zzsr zzsr) throws GeneralSecurityException {
        zzst zza = zzsu.zza(zzsr);
        try {
            return new zzaab(zza, zzsw.zza(zzsr));
        } catch (GeneralSecurityException unused) {
            return zza;
        }
    }

    public final byte[] zza(byte[] bArr, int i) throws GeneralSecurityException {
        throw new NoSuchMethodError();
    }
}
