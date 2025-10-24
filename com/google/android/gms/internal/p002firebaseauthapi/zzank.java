package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzank  reason: invalid package */
final class zzank implements Iterator {
    private int zza;
    private boolean zzb;
    private Iterator zzc;
    private final /* synthetic */ zzanh zzd;

    private final Iterator zza() {
        if (this.zzc == null) {
            this.zzc = this.zzd.zzc.entrySet().iterator();
        }
        return this.zzc;
    }

    public final boolean hasNext() {
        if (this.zza + 1 < this.zzd.zzb || (!this.zzd.zzc.isEmpty() && zza().hasNext())) {
            return true;
        }
        return false;
    }

    public final /* synthetic */ Object next() {
        this.zzb = true;
        int i = this.zza + 1;
        this.zza = i;
        if (i < this.zzd.zzb) {
            return (zzanl) this.zzd.zza[this.zza];
        }
        return (Map.Entry) zza().next();
    }

    public final void remove() {
        if (this.zzb) {
            this.zzb = false;
            this.zzd.zzg();
            if (this.zza < this.zzd.zzb) {
                zzanh zzanh = this.zzd;
                int i = this.zza;
                this.zza = i - 1;
                Object unused = zzanh.zzb(i);
                return;
            }
            zza().remove();
            return;
        }
        throw new IllegalStateException("remove() was called before next()");
    }

    private zzank(zzanh zzanh) {
        Objects.requireNonNull(zzanh);
        this.zzd = zzanh;
        this.zza = -1;
    }
}
