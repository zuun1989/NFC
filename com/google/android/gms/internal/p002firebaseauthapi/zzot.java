package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzot  reason: invalid package */
public final class zzot {
    private static final zzot zza = new zzot();
    private final Map<Class<? extends zzce>, zzow<? extends zzce>> zzb = new HashMap();

    public static zzot zza() {
        return zza;
    }

    public final synchronized <ParametersT extends zzce> void zza(zzow<ParametersT> zzow, Class<ParametersT> cls) throws GeneralSecurityException {
        try {
            zzow zzow2 = this.zzb.get(cls);
            if (zzow2 != null) {
                if (!zzow2.equals(zzow)) {
                    throw new GeneralSecurityException("Different key creator for parameters class already inserted");
                }
            }
            this.zzb.put(cls, zzow);
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
    }
}
