package com.google.android.gms.internal.clearcut;

final class zzbs {
    private static final Class<?> zzgl = zzak();

    private static Class<?> zzak() {
        try {
            return Class.forName("com.google.protobuf.ExtensionRegistry");
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public static zzbt zzal() {
        Class<?> cls = zzgl;
        if (cls != null) {
            try {
                return (zzbt) cls.getDeclaredMethod("getEmptyRegistry", (Class[]) null).invoke((Object) null, (Object[]) null);
            } catch (Exception unused) {
            }
        }
        return zzbt.zzgo;
    }
}
