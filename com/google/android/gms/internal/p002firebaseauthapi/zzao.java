package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Arrays;
import java.util.Collection;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzao  reason: invalid package */
public final class zzao<K, V> {
    zzan zza;
    private Object[] zzb;
    private int zzc;

    public zzao() {
        this(4);
    }

    public final zzao<K, V> zza(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
        if (iterable instanceof Collection) {
            zza(this.zzc + ((Collection) iterable).size());
        }
        for (Map.Entry entry : iterable) {
            Object key = entry.getKey();
            Object value = entry.getValue();
            zza(this.zzc + 1);
            zzae.zza(key, value);
            Object[] objArr = this.zzb;
            int i = this.zzc;
            objArr[i * 2] = key;
            objArr[(i * 2) + 1] = value;
            this.zzc = i + 1;
        }
        return this;
    }

    public zzao(int i) {
        this.zzb = new Object[(i * 2)];
        this.zzc = 0;
    }

    public final zzal<K, V> zza() {
        zzan zzan = this.zza;
        if (zzan == null) {
            zzas zza2 = zzas.zza(this.zzc, this.zzb, this);
            zzan zzan2 = this.zza;
            if (zzan2 == null) {
                return zza2;
            }
            throw zzan2.zza();
        }
        throw zzan.zza();
    }

    private final void zza(int i) {
        int i2 = i << 1;
        Object[] objArr = this.zzb;
        if (i2 > objArr.length) {
            this.zzb = Arrays.copyOf(objArr, zzai.zza(objArr.length, i2));
        }
    }
}
