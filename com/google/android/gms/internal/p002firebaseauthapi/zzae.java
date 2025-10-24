package com.google.android.gms.internal.p002firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzae  reason: invalid package */
final class zzae {
    public static int zza(int i, String str) {
        if (i >= 0) {
            return i;
        }
        throw new IllegalArgumentException(str + " cannot be negative but was: " + i);
    }

    public static void zza(Object obj, Object obj2) {
        if (obj == null) {
            String valueOf = String.valueOf(obj2);
            throw new NullPointerException("null key in entry: null=" + valueOf);
        } else if (obj2 == null) {
            String valueOf2 = String.valueOf(obj);
            throw new NullPointerException("null value in entry: " + valueOf2 + "=null");
        }
    }
}
