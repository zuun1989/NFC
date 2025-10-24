package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Collections;
import java.util.HashMap;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzom  reason: invalid package */
public final class zzom {
    private HashMap<String, String> zza = new HashMap<>();

    public final zzoj zza() {
        if (this.zza != null) {
            zzoj zzoj = new zzoj(Collections.unmodifiableMap(this.zza));
            this.zza = null;
            return zzoj;
        }
        throw new IllegalStateException("cannot call build() twice");
    }
}
