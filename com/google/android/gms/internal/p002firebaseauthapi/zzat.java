package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Iterator;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzat  reason: invalid package */
final class zzat<K> extends zzaq<K> {
    private final transient zzal<K, ?> zza;
    private final transient zzah<K> zzb;

    public zzat(zzal<K, ?> zzal, zzah<K> zzah) {
        this.zza = zzal;
        this.zzb = zzah;
    }

    public final boolean contains(Object obj) {
        if (this.zza.get(obj) != null) {
            return true;
        }
        return false;
    }

    public final /* synthetic */ Iterator iterator() {
        return iterator();
    }

    public final int size() {
        return this.zza.size();
    }

    public final int zza(Object[] objArr, int i) {
        return zzc().zza(objArr, i);
    }

    public final zzah<K> zzc() {
        return this.zzb;
    }

    public final zzay<K> zzd() {
        return (zzay) zzc().iterator();
    }
}
