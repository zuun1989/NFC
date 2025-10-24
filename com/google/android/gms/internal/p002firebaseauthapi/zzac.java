package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.logging.Level;
import java.util.logging.Logger;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzac  reason: invalid package */
public final class zzac {
    public static String zza(String str) {
        return zzp.zzb(str);
    }

    public static String zzb(String str) {
        return zzp.zzc(str);
    }

    public static boolean zzc(String str) {
        return zzp.zzd(str);
    }

    public static String zza(String str, Object... objArr) {
        int indexOf;
        String valueOf = String.valueOf(str);
        int i = 0;
        if (objArr == null) {
            objArr = new Object[]{"(Object[])null"};
        } else {
            for (int i2 = 0; i2 < objArr.length; i2++) {
                objArr[i2] = zza(objArr[i2]);
            }
        }
        StringBuilder sb2 = new StringBuilder(valueOf.length() + (objArr.length * 16));
        int i3 = 0;
        while (i < objArr.length && (indexOf = valueOf.indexOf("%s", i3)) != -1) {
            sb2.append(valueOf, i3, indexOf);
            sb2.append(objArr[i]);
            i3 = indexOf + 2;
            i++;
        }
        sb2.append(valueOf, i3, valueOf.length());
        if (i < objArr.length) {
            sb2.append(" [");
            sb2.append(objArr[i]);
            for (int i4 = i + 1; i4 < objArr.length; i4++) {
                sb2.append(", ");
                sb2.append(objArr[i4]);
            }
            sb2.append(']');
        }
        return sb2.toString();
    }

    private static String zza(Object obj) {
        if (obj == null) {
            return "null";
        }
        try {
            return obj.toString();
        } catch (Exception e) {
            String str = obj.getClass().getName() + "@" + Integer.toHexString(System.identityHashCode(obj));
            Logger.getLogger("com.google.common.base.Strings").logp(Level.WARNING, "com.google.common.base.Strings", "lenientToString", "Exception during lenientFormat for " + str, e);
            return "<" + str + " threw " + e.getClass().getName() + ">";
        }
    }
}
