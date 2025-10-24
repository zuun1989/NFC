package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import javax.crypto.Cipher;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zziu  reason: invalid package */
final class zziu extends ThreadLocal<Cipher> {
    private static Cipher zza() {
        try {
            Cipher zza = zzzm.zza.zza("AES/GCM-SIV/NoPadding");
            if (!zzhc.zza(zza)) {
                return null;
            }
            return zza;
        } catch (GeneralSecurityException e) {
            throw new IllegalStateException(e);
        }
    }

    public final /* synthetic */ Object initialValue() {
        return zza();
    }
}
