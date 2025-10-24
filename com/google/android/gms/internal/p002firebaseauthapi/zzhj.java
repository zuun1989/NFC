package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import javax.crypto.Cipher;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzhj  reason: invalid package */
final class zzhj extends ThreadLocal<Cipher> {
    private static Cipher zza() {
        try {
            Cipher zza = zzzm.zza.zza("ChaCha20-Poly1305");
            if (!zzhk.zzb(zza)) {
                return null;
            }
            return zza;
        } catch (GeneralSecurityException unused) {
            return null;
        }
    }

    public final /* synthetic */ Object initialValue() {
        return zza();
    }
}
