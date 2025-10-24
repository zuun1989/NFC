package com.google.android.gms.internal.p002firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzqo  reason: invalid package */
public final class zzqo extends RuntimeException {
    public zzqo(String str) {
        super(str);
    }

    public static <T> T zza(zzqn<T> zzqn) {
        try {
            return zzqn.zza();
        } catch (Exception e) {
            throw new zzqo((Throwable) e);
        }
    }

    public zzqo(Throwable th) {
        super(th);
    }

    public zzqo(String str, Throwable th) {
        super(str, th);
    }
}
