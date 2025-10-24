package com.google.android.gms.internal.mlkit_vision_face;

import java.io.Serializable;
import java.util.Map;
import java.util.Set;

public abstract class zzbp implements Map, Serializable {
    private transient zzbq zza;
    private transient zzbq zzb;
    private transient zzbi zzc;

    public static zzbp zzc(Object obj, Object obj2) {
        zzau.zzb("optional-module-barcode", "com.google.android.gms.vision.barcode");
        return zzch.zzg(1, new Object[]{"optional-module-barcode", "com.google.android.gms.vision.barcode"}, (zzbo) null);
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
        return zzcj.zza(entrySet());
    }

    public final boolean isEmpty() {
        return size() == 0;
    }

    public final /* bridge */ /* synthetic */ Set keySet() {
        zzbq zzbq = this.zzb;
        if (zzbq != null) {
            return zzbq;
        }
        zzbq zze = zze();
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
        zzau.zza(size, "size");
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

    public abstract zzbi zza();

    /* renamed from: zzb */
    public final zzbi values() {
        zzbi zzbi = this.zzc;
        if (zzbi != null) {
            return zzbi;
        }
        zzbi zza2 = zza();
        this.zzc = zza2;
        return zza2;
    }

    public abstract zzbq zzd();

    public abstract zzbq zze();

    /* renamed from: zzf */
    public final zzbq entrySet() {
        zzbq zzbq = this.zza;
        if (zzbq != null) {
            return zzbq;
        }
        zzbq zzd = zzd();
        this.zza = zzd;
        return zzd;
    }
}
