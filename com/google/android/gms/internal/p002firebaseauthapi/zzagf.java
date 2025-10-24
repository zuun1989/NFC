package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.logging.Logger;
import com.google.android.gms.tasks.OnFailureListener;
import java.util.Objects;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzagf  reason: invalid package */
final class zzagf implements OnFailureListener {
    public zzagf(zzagd zzagd) {
        Objects.requireNonNull(zzagd);
    }

    public final void onFailure(Exception exc) {
        Logger zza = zzagd.zza;
        String message = exc.getMessage();
        zza.e("SmsRetrieverClient failed to start: " + message, new Object[0]);
    }
}
