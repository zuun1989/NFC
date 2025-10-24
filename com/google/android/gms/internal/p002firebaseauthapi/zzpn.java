package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzpn  reason: invalid package */
final class zzpn implements Iterable {
    private final /* synthetic */ List zza;
    private final /* synthetic */ List zzb;

    public zzpn(zzpo zzpo, List list, List list2) {
        this.zza = list;
        this.zzb = list2;
        Objects.requireNonNull(zzpo);
    }

    public final Iterator iterator() {
        return new zzpp(this.zza.iterator(), this.zzb.iterator());
    }
}
