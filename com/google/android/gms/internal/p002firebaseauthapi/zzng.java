package com.google.android.gms.internal.p002firebaseauthapi;

import java.lang.reflect.InvocationTargetException;
import java.security.Provider;
import java.security.Security;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzng  reason: invalid package */
public final class zzng {
    private static final String[] zza = {"GmsCore_OpenSSL", "AndroidOpenSSL", "Conscrypt"};

    public static Provider zza() {
        for (String provider : zza) {
            Provider provider2 = Security.getProvider(provider);
            if (provider2 != null) {
                return provider2;
            }
        }
        return null;
    }

    public static Provider zzb() {
        try {
            return (Provider) Class.forName("org.conscrypt.Conscrypt").getMethod("newProvider", (Class[]) null).invoke((Object) null, (Object[]) null);
        } catch (ClassNotFoundException | IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException unused) {
            return null;
        }
    }
}
