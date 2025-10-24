package com.google.android.gms.internal.p002firebaseauthapi;

import java.lang.Enum;
import java.security.GeneralSecurityException;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zznk  reason: invalid package */
public final class zznk<E extends Enum<E>, O> {
    private final Map<E, O> zza;
    private final Map<O, E> zzb;

    public static <E extends Enum<E>, O> zznn<E, O> zza() {
        return new zznn<>();
    }

    private zznk(Map<E, O> map, Map<O, E> map2) {
        this.zza = map;
        this.zzb = map2;
    }

    public final E zza(O o) throws GeneralSecurityException {
        E e = (Enum) this.zzb.get(o);
        if (e != null) {
            return e;
        }
        String valueOf = String.valueOf(o);
        throw new GeneralSecurityException("Unable to convert object enum: " + valueOf);
    }

    public final O zza(E e) throws GeneralSecurityException {
        O o = this.zza.get(e);
        if (o != null) {
            return o;
        }
        String valueOf = String.valueOf(e);
        throw new GeneralSecurityException("Unable to convert proto enum: " + valueOf);
    }
}
