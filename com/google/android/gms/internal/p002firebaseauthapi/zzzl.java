package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.Provider;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzzl  reason: invalid package */
final class zzzl<JcePrimitiveT> implements zzzq<JcePrimitiveT> {
    private final zzzs<JcePrimitiveT> zza;

    public final JcePrimitiveT zza(String str) throws GeneralSecurityException {
        Exception exc = null;
        for (Provider zza2 : zzzm.zza("GmsCore_OpenSSL", "AndroidOpenSSL")) {
            try {
                return this.zza.zza(str, zza2);
            } catch (Exception e) {
                if (exc == null) {
                    exc = e;
                }
            }
        }
        return this.zza.zza(str, (Provider) null);
    }

    private zzzl(zzzs<JcePrimitiveT> zzzs) {
        this.zza = zzzs;
    }
}
