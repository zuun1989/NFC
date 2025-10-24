package com.google.android.gms.internal.p002firebaseauthapi;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.KeyStore;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zznc  reason: invalid package */
public final class zznc {
    public static zzaz zza(String str) throws GeneralSecurityException {
        return new zznb(str, zza());
    }

    public static boolean zzb(String str) throws GeneralSecurityException {
        return zza().containsAlias(str);
    }

    private static KeyStore zza() throws GeneralSecurityException {
        try {
            KeyStore instance = KeyStore.getInstance("AndroidKeyStore");
            instance.load((KeyStore.LoadStoreParameter) null);
            return instance;
        } catch (IOException e) {
            throw new GeneralSecurityException(e);
        }
    }
}
