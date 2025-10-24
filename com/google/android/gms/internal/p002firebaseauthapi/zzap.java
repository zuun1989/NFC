package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Objects;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzap  reason: invalid package */
final class zzap<E> extends zzah<E> {
    static final zzah<Object> zza = new zzap(new Object[0], 0);
    private final transient Object[] zzb;
    private final transient int zzc;

    public zzap(Object[] objArr, int i) {
        this.zzb = objArr;
        this.zzc = i;
    }

    public final E get(int i) {
        zzu.zza(i, this.zzc);
        E e = this.zzb[i];
        Objects.requireNonNull(e);
        return e;
    }

    public final int size() {
        return this.zzc;
    }

    public final int zza(Object[] objArr, int i) {
        System.arraycopy(this.zzb, 0, objArr, i, this.zzc);
        return i + this.zzc;
    }

    public final int zzb() {
        return 0;
    }

    public final Object[] zze() {
        return this.zzb;
    }

    public final int zza() {
        return this.zzc;
    }
}
