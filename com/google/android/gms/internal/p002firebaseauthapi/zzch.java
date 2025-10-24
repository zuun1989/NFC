package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Logger;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzch  reason: invalid package */
public final class zzch {
    static {
        Logger.getLogger(zzch.class.getName());
        new ConcurrentHashMap();
        HashSet hashSet = new HashSet();
        hashSet.add(zzaz.class);
        hashSet.add(zzbd.class);
        hashSet.add(zzcj.class);
        hashSet.add(zzbf.class);
        hashSet.add(zzbg.class);
        hashSet.add(zzcb.class);
        hashSet.add(zzst.class);
        hashSet.add(zzcf.class);
        hashSet.add(zzci.class);
        Collections.unmodifiableSet(hashSet);
    }

    private zzch() {
    }

    @Deprecated
    public static zzxa zza(String str, zzajw zzajw) throws GeneralSecurityException {
        zzbk<?> zza = zznt.zza().zza(str);
        if (zza instanceof zzcg) {
            return ((zzcg) zza).zzc(zzajw);
        }
        throw new GeneralSecurityException("manager for key type " + str + " is not a PrivateKeyManager");
    }
}
