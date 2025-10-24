package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.Provider;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzzn  reason: invalid package */
final class zzzn<JcePrimitiveT> implements zzzq<JcePrimitiveT> {
    private final zzzs<JcePrimitiveT> zza;

    public final JcePrimitiveT zza(String str) throws GeneralSecurityException {
        Exception exc = null;
        for (Provider zza2 : zzzm.zza("GmsCore_OpenSSL", "AndroidOpenSSL", "Conscrypt")) {
            try {
                return this.zza.zza(str, zza2);
            } catch (Exception e) {
                if (exc == null) {
                    exc = e;
                }
            }
        }
        throw new GeneralSecurityException("No good Provider found.", exc);
    }

    private zzzn(zzzs<JcePrimitiveT> zzzs) {
        this.zza = zzzs;
    }
}
