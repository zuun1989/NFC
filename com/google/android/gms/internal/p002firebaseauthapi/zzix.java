package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;
import java.util.logging.Logger;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzix  reason: invalid package */
public final class zzix {
    private static final Logger zza = Logger.getLogger(zzix.class.getName());
    private static final AtomicBoolean zzb = new AtomicBoolean(false);

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzix$zza */
    public enum zza {
        ALGORITHM_NOT_FIPS((String) null),
        ALGORITHM_REQUIRES_BORINGCRYPTO((String) null);

        public abstract boolean zza();
    }

    private zzix() {
    }

    public static Boolean zza() {
        try {
            return (Boolean) Class.forName("org.conscrypt.Conscrypt").getMethod("isBoringSslFIPSBuild", (Class[]) null).invoke((Object) null, (Object[]) null);
        } catch (Exception unused) {
            zza.logp(Level.INFO, "com.google.crypto.tink.config.internal.TinkFipsUtil", "checkConscryptIsAvailableAndUsesFipsBoringSsl", "Conscrypt is not available or does not support checking for FIPS build.");
            return Boolean.FALSE;
        }
    }

    public static boolean zzb() {
        if (zzb.get()) {
            return true;
        }
        return false;
    }
}
