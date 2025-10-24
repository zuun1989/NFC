package com.google.android.gms.internal.p002firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzanw  reason: invalid package */
public final class zzanw extends RuntimeException {
    public zzanw(zzamn zzamn) {
        super("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
    }

    public final zzalm zza() {
        return new zzalm(getMessage());
    }
}
