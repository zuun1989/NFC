package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzd  reason: invalid package */
abstract class zzd<T> implements Iterator<T> {
    private int zza = 2;
    private T zzb;

    public final boolean hasNext() {
        int i = this.zza;
        if (i != 4) {
            int i2 = i - 1;
            if (i2 == 0) {
                return true;
            }
            if (i2 != 2) {
                this.zza = 4;
                this.zzb = zza();
                if (this.zza != 3) {
                    this.zza = 1;
                    return true;
                }
            }
            return false;
        }
        throw new IllegalStateException();
    }

    public final T next() {
        if (hasNext()) {
            this.zza = 2;
            T t = this.zzb;
            this.zzb = null;
            return t;
        }
        throw new NoSuchElementException();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    public abstract T zza();

    public final T zzb() {
        this.zza = 3;
        return null;
    }
}
