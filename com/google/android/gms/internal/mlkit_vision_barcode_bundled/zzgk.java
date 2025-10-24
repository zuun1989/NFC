package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import java.util.Iterator;
import java.util.Map;

final class zzgk implements Iterator {
    final /* synthetic */ zzgo zza;
    private int zzb = -1;
    private boolean zzc;
    private Iterator zzd;

    public /* synthetic */ zzgk(zzgo zzgo, zzgj zzgj) {
        this.zza = zzgo;
    }

    private final Iterator zza() {
        if (this.zzd == null) {
            this.zzd = this.zza.zzc.entrySet().iterator();
        }
        return this.zzd;
    }

    public final boolean hasNext() {
        int i = this.zzb + 1;
        zzgo zzgo = this.zza;
        if (i < zzgo.zzb) {
            return true;
        }
        if (zzgo.zzc.isEmpty()) {
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
        zzgo zzgo = this.zza;
        if (i < zzgo.zzb) {
            return (zzgi) zzgo.zza[i];
        }
        return (Map.Entry) zza().next();
    }

    public final void remove() {
        if (this.zzc) {
            this.zzc = false;
            this.zza.zzo();
            int i = this.zzb;
            zzgo zzgo = this.zza;
            if (i < zzgo.zzb) {
                this.zzb = i - 1;
                Object unused = zzgo.zzm(i);
                return;
            }
            zza().remove();
            return;
        }
        throw new IllegalStateException("remove() was called before next()");
    }
}
