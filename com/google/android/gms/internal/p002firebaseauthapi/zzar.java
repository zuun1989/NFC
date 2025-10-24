package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Iterator;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzar  reason: invalid package */
final class zzar<K, V> extends zzaq<Map.Entry<K, V>> {
    private final transient zzal<K, V> zza;
    /* access modifiers changed from: private */
    public final transient Object[] zzb;
    /* access modifiers changed from: private */
    public final transient int zzc;

    public zzar(zzal<K, V> zzal, Object[] objArr, int i, int i2) {
        this.zza = zzal;
        this.zzb = objArr;
        this.zzc = i2;
    }

    public final boolean contains(Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (value == null || !value.equals(this.zza.get(key))) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final /* synthetic */ Iterator iterator() {
        return iterator();
    }

    public final int size() {
        return this.zzc;
    }

    public final zzay<Map.Entry<K, V>> zzd() {
        return (zzay) zzc().iterator();
    }

    public final zzah<Map.Entry<K, V>> zzf() {
        return new zzau(this);
    }

    public final int zza(Object[] objArr, int i) {
        return zzc().zza(objArr, i);
    }
}
