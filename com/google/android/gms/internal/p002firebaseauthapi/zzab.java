package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.NoSuchElementException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzab  reason: invalid package */
abstract class zzab<E> extends zzax<E> {
    private final int zza;
    private int zzb;

    public zzab(int i, int i2) {
        zzu.zzb(i2, i);
        this.zza = i;
        this.zzb = i2;
    }

    public final boolean hasNext() {
        if (this.zzb < this.zza) {
            return true;
        }
        return false;
    }

    public final boolean hasPrevious() {
        if (this.zzb > 0) {
            return true;
        }
        return false;
    }

    public final E next() {
        if (hasNext()) {
            int i = this.zzb;
            this.zzb = i + 1;
            return zza(i);
        }
        throw new NoSuchElementException();
    }

    public final int nextIndex() {
        return this.zzb;
    }

    public final E previous() {
        if (hasPrevious()) {
            int i = this.zzb - 1;
            this.zzb = i;
            return zza(i);
        }
        throw new NoSuchElementException();
    }

    public final int previousIndex() {
        return this.zzb - 1;
    }

    public abstract E zza(int i);
}
