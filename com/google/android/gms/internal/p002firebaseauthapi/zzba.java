package com.google.android.gms.internal.p002firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzba  reason: invalid package */
public final class zzba {
    @Deprecated
    public static long zza(long j, long j2) {
        boolean z;
        long j3 = j + j2;
        boolean z2 = false;
        if ((j2 ^ j) < 0) {
            z = true;
        } else {
            z = false;
        }
        if ((j ^ j3) >= 0) {
            z2 = true;
        }
        if (z || z2) {
            return j3;
        }
        throw new ArithmeticException();
    }

    @Deprecated
    public static long zzb(long j, long j2) {
        boolean z;
        long j3 = j - 1;
        boolean z2 = false;
        if ((1 ^ j) >= 0) {
            z = true;
        } else {
            z = false;
        }
        if ((j ^ j3) >= 0) {
            z2 = true;
        }
        if (z || z2) {
            return j3;
        }
        throw new ArithmeticException();
    }
}
