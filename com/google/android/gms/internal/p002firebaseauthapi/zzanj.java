package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzanj  reason: invalid package */
final class zzanj implements Iterator {
    private int zza;
    private Iterator zzb;
    private final /* synthetic */ zzanh zzc;

    private final Iterator zza() {
        if (this.zzb == null) {
            this.zzb = this.zzc.zzf.entrySet().iterator();
        }
        return this.zzb;
    }

    public final boolean hasNext() {
        int i = this.zza;
        if ((i <= 0 || i > this.zzc.zzb) && !zza().hasNext()) {
            return false;
        }
        return true;
    }

    public final /* synthetic */ Object next() {
        if (zza().hasNext()) {
            return (Map.Entry) zza().next();
        }
        Object[] zze = this.zzc.zza;
        int i = this.zza - 1;
        this.zza = i;
        return (zzanl) zze[i];
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    private zzanj(zzanh zzanh) {
        Objects.requireNonNull(zzanh);
        this.zzc = zzanh;
        this.zza = zzanh.zzb;
    }
}
