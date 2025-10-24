package com.google.android.gms.internal.maps;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

public abstract class zzbn implements Map, Serializable {
    private transient zzbo zza;
    private transient zzbo zzb;
    private transient zzbh zzc;

    public static zzbn zzc(Iterable iterable) {
        int i;
        if (iterable instanceof Collection) {
            i = ((Collection) iterable).size();
        } else {
            i = 4;
        }
        zzbm zzbm = new zzbm(i);
        zzbm.zza(iterable);
        zzbl zzbl = zzbm.zzc;
        if (zzbl == null) {
            zzbv zzg = zzbv.zzg(zzbm.zzb, zzbm.zza, zzbm);
            zzbl zzbl2 = zzbm.zzc;
            if (zzbl2 == null) {
                return zzg;
            }
            throw zzbl2.zza();
        }
        throw zzbl.zza();
    }

    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    public final boolean containsKey(Object obj) {
        if (get(obj) != null) {
            return true;
        }
        return false;
    }

    public final boolean containsValue(Object obj) {
        return values().contains(obj);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Map)) {
            return false;
        }
        return entrySet().equals(((Map) obj).entrySet());
    }

    public abstract Object get(Object obj);

    public final Object getOrDefault(Object obj, Object obj2) {
        Object obj3 = get(obj);
        if (obj3 != null) {
            return obj3;
        }
        return obj2;
    }

    public final int hashCode() {
        return zzbx.zza(entrySet());
    }

    public final boolean isEmpty() {
        return size() == 0;
    }

    public final /* bridge */ /* synthetic */ Set keySet() {
        zzbo zzbo = this.zzb;
        if (zzbo != null) {
            return zzbo;
        }
        zzbo zze = zze();
        this.zzb = zze;
        return zze;
    }

    @Deprecated
    public final Object put(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void putAll(Map map) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final Object remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    public final String toString() {
        int size = size();
        if (size >= 0) {
            StringBuilder sb2 = new StringBuilder((int) Math.min(((long) size) * 8, 1073741824));
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
        throw new IllegalArgumentException("size cannot be negative but was: " + size);
    }

    public abstract zzbh zza();

    /* renamed from: zzb */
    public final zzbh values() {
        zzbh zzbh = this.zzc;
        if (zzbh != null) {
            return zzbh;
        }
        zzbh zza2 = zza();
        this.zzc = zza2;
        return zza2;
    }

    public abstract zzbo zzd();

    public abstract zzbo zze();

    /* renamed from: zzf */
    public final zzbo entrySet() {
        zzbo zzbo = this.zza;
        if (zzbo != null) {
            return zzbo;
        }
        zzbo zzd = zzd();
        this.zza = zzd;
        return zzd;
    }
}
