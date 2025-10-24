package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.Provider;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzzy  reason: invalid package */
public final class zzzy implements zzzs<MessageDigest> {
    public final /* synthetic */ Object zza(String str, Provider provider) throws GeneralSecurityException {
        if (provider == null) {
            return MessageDigest.getInstance(str);
        }
        return MessageDigest.getInstance(str, provider);
    }
}
