package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.NoSuchElementException;
import java.util.Objects;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzajz  reason: invalid package */
final class zzajz extends zzakb {
    private int zza = 0;
    private final int zzb;
    private final /* synthetic */ zzajw zzc;

    public zzajz(zzajw zzajw) {
        Objects.requireNonNull(zzajw);
        this.zzc = zzajw;
        this.zzb = zzajw.zzb();
    }

    public final boolean hasNext() {
        if (this.zza < this.zzb) {
            return true;
        }
        return false;
    }

    public final byte zza() {
        int i = this.zza;
        if (i < this.zzb) {
            this.zza = i + 1;
            return this.zzc.zzb(i);
        }
        throw new NoSuchElementException();
    }
}
