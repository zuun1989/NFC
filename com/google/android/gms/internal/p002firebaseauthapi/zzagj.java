package com.google.android.gms.internal.p002firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzagj  reason: invalid package */
public final class zzagj {
    public static String zza(String str) {
        try {
            Object invoke = Class.forName("android.os.SystemProperties").getDeclaredMethod("get", new Class[]{String.class}).invoke((Object) null, new Object[]{str});
            if (invoke instanceof String) {
                return (String) invoke;
            }
        } catch (Exception unused) {
        }
        return null;
    }
}
