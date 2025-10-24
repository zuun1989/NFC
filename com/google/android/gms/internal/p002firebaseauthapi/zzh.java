package com.google.android.gms.internal.p002firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzh  reason: invalid package */
final class zzh extends zzi {
    private final char zza;

    public zzh(char c) {
        this.zza = c;
    }

    public final String toString() {
        char c = this.zza;
        char[] cArr = {'\\', 'u', 0, 0, 0, 0};
        for (int i = 0; i < 4; i++) {
            cArr[5 - i] = "0123456789ABCDEF".charAt(c & 15);
            c = (char) (c >> 4);
        }
        String copyValueOf = String.copyValueOf(cArr);
        return "CharMatcher.is('" + copyValueOf + "')";
    }

    public final boolean zza(char c) {
        if (c == this.zza) {
            return true;
        }
        return false;
    }
}
