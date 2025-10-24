package com.google.android.gms.internal.p002firebaseauthapi;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzal  reason: invalid package */
public abstract class zzal<K, V> implements Serializable, Map<K, V> {
    private transient zzaq<Map.Entry<K, V>> zza;
    private transient zzaq<K> zzb;
    private transient zzag<V> zzc;

    public static <K, V> zzal<K, V> zza(Map<? extends K, ? extends V> map) {
        if (!(map instanceof zzal) || (map instanceof SortedMap)) {
            Set<Map.Entry<? extends K, ? extends V>> entrySet = map.entrySet();
            zzao zzao = new zzao(entrySet != null ? entrySet.size() : 4);
            zzao.zza(entrySet);
            return zzao.zza();
        }
        zzal<K, V> zzal = (zzal) map;
        zzal.zzd();
        return zzal;
    }

    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    public boolean containsKey(Object obj) {
        if (get(obj) != null) {
            return true;
        }
        return false;
    }

    public boolean containsValue(Object obj) {
        return ((zzag) values()).contains(obj);
    }

    public /* synthetic */ Set entrySet() {
        zzaq<Map.Entry<K, V>> zzaq = this.zza;
        if (zzaq != null) {
            return zzaq;
        }
        zzaq<Map.Entry<K, V>> zzb2 = zzb();
        this.zza = zzb2;
        return zzb2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Map) {
            return entrySet().equals(((Map) obj).entrySet());
        }
        return false;
    }

    public abstract V get(Object obj);

    public final V getOrDefault(Object obj, V v) {
        V v2 = get(obj);
        if (v2 != null) {
            return v2;
        }
        return v;
    }

    public int hashCode() {
        return zzav.zza((zzaq) entrySet());
    }

    public boolean isEmpty() {
        if (size() == 0) {
            return true;
        }
        return false;
    }

    public /* synthetic */ Set keySet() {
        zzaq<K> zzaq = this.zzb;
        if (zzaq != null) {
            return zzaq;
        }
        zzaq<K> zzc2 = zzc();
        this.zzb = zzc2;
        return zzc2;
    }

    @Deprecated
    public final V put(K k, V v) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void putAll(Map<? extends K, ? extends V> map) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final V remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    public String toString() {
        int size = size();
        zzae.zza(size, "size");
        StringBuilder sb2 = new StringBuilder((int) Math.min(((long) size) << 3, 1073741824));
        sb2.append('{');
        boolean z = true;
        for (Map.Entry entry : entrySet()) {
            if (!z) {
                sb2.append(", ");
            }
            sb2.append(entry.getKey());
            sb2.append('=');
            sb2.append(entry.getValue());
            z = false;
        }
        sb2.append('}');
        return sb2.toString();
    }

    public /* synthetic */ Collection values() {
        zzag<V> zzag = this.zzc;
        if (zzag != null) {
            return zzag;
        }
        zzag<V> zza2 = zza();
        this.zzc = zza2;
        return zza2;
    }

    public abstract zzag<V> zza();

    public abstract zzaq<Map.Entry<K, V>> zzb();

    public abstract zzaq<K> zzc();

    public abstract boolean zzd();
}
