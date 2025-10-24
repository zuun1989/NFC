package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Objects;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaw  reason: invalid package */
final class zzaw extends zzah<Object> {
    private final transient Object[] zza;
    private final transient int zzb;
    private final transient int zzc;

    public zzaw(Object[] objArr, int i, int i2) {
        this.zza = objArr;
        this.zzb = i;
        this.zzc = i2;
    }

    public final Object get(int i) {
        zzu.zza(i, this.zzc);
        Object obj = this.zza[(i * 2) + this.zzb];
        Objects.requireNonNull(obj);
        return obj;
    }

    public final int size() {
        return this.zzc;
    }
}
