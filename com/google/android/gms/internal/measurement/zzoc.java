package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

final class zzoc implements Iterator {
    final /* synthetic */ zzoe zza;
    private int zzb = -1;
    private boolean zzc;
    private Iterator zzd;

    public /* synthetic */ zzoc(zzoe zzoe, byte[] bArr) {
        Objects.requireNonNull(zzoe);
        this.zza = zzoe;
    }

    private final Iterator zza() {
        if (this.zzd == null) {
            this.zzd = this.zza.zzk().entrySet().iterator();
        }
        return this.zzd;
    }

    public final boolean hasNext() {
        int i = this.zzb + 1;
        zzoe zzoe = this.zza;
        if (i < zzoe.zzj()) {
            return true;
        }
        if (zzoe.zzk().isEmpty()) {
            return false;
        }
        if (zza().hasNext()) {
            return true;
        }
        return false;
    }

    public final /* bridge */ /* synthetic */ Object next() {
        this.zzc = true;
        int i = this.zzb + 1;
        this.zzb = i;
        zzoe zzoe = this.zza;
        if (i < zzoe.zzj()) {
            return (zzob) zzoe.zzi()[i];
        }
        return (Map.Entry) zza().next();
    }

    public final void remove() {
        if (this.zzc) {
            this.zzc = false;
            zzoe zzoe = this.zza;
            zzoe.zzh();
            int i = this.zzb;
            if (i < zzoe.zzj()) {
                this.zzb = i - 1;
                zzoe.zzg(i);
                return;
            }
            zza().remove();
            return;
        }
        throw new IllegalStateException("remove() was called before next()");
    }
}
