package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import javax.crypto.Cipher;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzyy  reason: invalid package */
final class zzyy extends ThreadLocal<Cipher> {
    private static Cipher zza() {
        try {
            return zzzm.zza.zza("AES/CTR/NOPADDING");
        } catch (GeneralSecurityException e) {
            throw new IllegalStateException(e);
        }
    }

    public final /* synthetic */ Object initialValue() {
        return zza();
    }
}
