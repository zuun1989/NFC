package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import javax.crypto.Cipher;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzis  reason: invalid package */
public final class zzis implements zzaz {
    private static final ThreadLocal<Cipher> zza = new zziu();

    /* access modifiers changed from: private */
    public static Cipher zzb() throws GeneralSecurityException {
        try {
            Cipher cipher = zza.get();
            if (cipher != null) {
                return cipher;
            }
            throw new GeneralSecurityException("AES GCM SIV cipher is invalid.");
        } catch (IllegalStateException e) {
            throw new GeneralSecurityException("AES GCM SIV cipher is not available or is invalid.", e);
        }
    }

    public static zzaz zza(zzeb zzeb) throws GeneralSecurityException {
        return zzhc.zza(zzeb, (zzhb<Cipher>) new zzir());
    }

    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        throw new NoSuchMethodError();
    }

    public final byte[] zzb(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        throw new NoSuchMethodError();
    }
}
