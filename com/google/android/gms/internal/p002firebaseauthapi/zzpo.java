package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzpo  reason: invalid package */
public final class zzpo<P> {
    private static final zzaam zza = zzaam.zza(new byte[0]);
    private final Map<zzaam, List<P>> zzb;

    public final Iterable<P> zza(byte[] bArr) {
        List list;
        List list2 = this.zzb.get(zza);
        if (bArr.length >= 5) {
            list = this.zzb.get(zzaam.zza(bArr, 0, 5));
        } else {
            list = null;
        }
        if (list2 == null && list == null) {
            return new ArrayList();
        }
        if (list2 == null) {
            return list;
        }
        if (list == null) {
            return list2;
        }
        return new zzpn(this, list, list2);
    }

    private zzpo(Map<zzaam, List<P>> map) {
        this.zzb = map;
    }
}
