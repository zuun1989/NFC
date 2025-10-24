package com.google.android.gms.internal.p002firebaseauthapi;

import java.lang.reflect.Type;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaey  reason: invalid package */
public class zzaey {
    private zzaey() {
    }

    public static Object zza(String str, Type type) throws zzaco {
        if (type == String.class) {
            try {
                zzagu zzagu = (zzagu) new zzagu().zza(str);
                if (zzagu.zzb()) {
                    return zzagu.zza();
                }
                throw new zzaco("No error message: " + str);
            } catch (Exception e) {
                String message = e.getMessage();
                throw new zzaco("Json conversion failed! " + message, e);
            }
        } else if (type == Void.class) {
            return null;
        } else {
            try {
                try {
                    return ((zzafa) ((Class) type).getConstructor((Class[]) null).newInstance((Object[]) null)).zza(str);
                } catch (Exception e2) {
                    String message2 = e2.getMessage();
                    throw new zzaco("Json conversion failed! " + message2, e2);
                }
            } catch (Exception e3) {
                String valueOf = String.valueOf(type);
                throw new zzaco("Instantiation of JsonResponse failed! " + valueOf, e3);
            }
        }
    }
}
