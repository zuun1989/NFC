package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzpq  reason: invalid package */
public final class zzpq<P> {
    private final Map<zzaam, List<P>> zza = new HashMap();

    public final zzpq<P> zza(zzaam zzaam, P p) throws GeneralSecurityException {
        List list;
        if (zzaam.zza() == 0 || zzaam.zza() == 5) {
            if (this.zza.containsKey(zzaam)) {
                list = this.zza.get(zzaam);
            } else {
                ArrayList arrayList = new ArrayList();
                this.zza.put(zzaam, arrayList);
                list = arrayList;
            }
            list.add(p);
            return this;
        }
        throw new GeneralSecurityException("PrefixMap only supports 0 and 5 byte prefixes");
    }

    public final zzpo<P> zza() {
        return new zzpo<>(this.zza);
    }
}
