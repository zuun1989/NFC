package com.google.android.gms.internal.measurement;

import java.util.NoSuchElementException;
import java.util.Objects;

final class zzla extends zzlb {
    final /* synthetic */ zzlh zza;
    private int zzb = 0;
    private final int zzc;

    public zzla(zzlh zzlh) {
        Objects.requireNonNull(zzlh);
        this.zza = zzlh;
        this.zzc = zzlh.zzc();
    }

    public final boolean hasNext() {
        return this.zzb < this.zzc;
    }

    public final byte zza() {
        int i = this.zzb;
        if (i < this.zzc) {
            this.zzb = i + 1;
            return this.zza.zzb(i);
        }
        throw new NoSuchElementException();
    }
}
