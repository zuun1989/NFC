package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.AbstractMap;
import java.util.Objects;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzau  reason: invalid package */
final class zzau extends zzah {
    private final /* synthetic */ zzar zza;

    public zzau(zzar zzar) {
        Objects.requireNonNull(zzar);
        this.zza = zzar;
    }

    public final /* synthetic */ Object get(int i) {
        zzu.zza(i, this.zza.zzc);
        int i2 = i * 2;
        Object obj = this.zza.zzb[i2];
        Objects.requireNonNull(obj);
        Object obj2 = this.zza.zzb[i2 + 1];
        Objects.requireNonNull(obj2);
        return new AbstractMap.SimpleImmutableEntry(obj, obj2);
    }

    public final int size() {
        return this.zza.zzc;
    }
}
