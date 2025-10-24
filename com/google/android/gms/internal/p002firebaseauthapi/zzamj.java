package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Iterator;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzamj  reason: invalid package */
final class zzamj implements zzamg {
    public final int zza(int i, Object obj, Object obj2) {
        zzamh zzamh = (zzamh) obj;
        zzamf zzamf = (zzamf) obj2;
        if (zzamh.isEmpty()) {
            return 0;
        }
        Iterator it = zzamh.entrySet().iterator();
        if (!it.hasNext()) {
            return 0;
        }
        Map.Entry entry = (Map.Entry) it.next();
        entry.getKey();
        entry.getValue();
        throw new NoSuchMethodError();
    }

    public final Object zzb(Object obj) {
        return zzamh.zza().zzb();
    }

    public final Object zzc(Object obj) {
        ((zzamh) obj).zzc();
        return obj;
    }

    public final Map<?, ?> zzd(Object obj) {
        return (zzamh) obj;
    }

    public final Map<?, ?> zze(Object obj) {
        return (zzamh) obj;
    }

    public final boolean zzf(Object obj) {
        if (!((zzamh) obj).zzd()) {
            return true;
        }
        return false;
    }

    public final zzame<?, ?> zza(Object obj) {
        zzamf zzamf = (zzamf) obj;
        throw new NoSuchMethodError();
    }

    public final Object zza(Object obj, Object obj2) {
        zzamh zzamh = (zzamh) obj;
        zzamh zzamh2 = (zzamh) obj2;
        if (!zzamh2.isEmpty()) {
            if (!zzamh.zzd()) {
                zzamh = zzamh.zzb();
            }
            zzamh.zza(zzamh2);
        }
        return zzamh;
    }
}
