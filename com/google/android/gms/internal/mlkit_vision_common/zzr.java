package com.google.android.gms.internal.mlkit_vision_common;

import java.io.Serializable;
import java.util.Map;
import java.util.Set;

public abstract class zzr implements Map, Serializable {
    private transient zzs zza;
    private transient zzs zzb;
    private transient zzl zzc;

    public static zzr zzc(Object obj, Object obj2) {
        zzi.zza("optional-module-barcode", "com.google.android.gms.vision.barcode");
        return zzz.zzg(1, new Object[]{"optional-module-barcode", "com.google.android.gms.vision.barcode"}, (zzq) null);
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
        return zzaa.zza(entrySet());
    }

    public final boolean isEmpty() {
        return size() == 0;
    }

    public final /* bridge */ /* synthetic */ Set keySet() {
        zzs zzs = this.zzb;
        if (zzs != null) {
            return zzs;
        }
        zzs zze = zze();
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

    public abstract zzl zza();

    /* renamed from: zzb */
    public final zzl values() {
        zzl zzl = this.zzc;
        if (zzl != null) {
            return zzl;
        }
        zzl zza2 = zza();
        this.zzc = zza2;
        return zza2;
    }

    public abstract zzs zzd();

    public abstract zzs zze();

    /* renamed from: zzf */
    public final zzs entrySet() {
        zzs zzs = this.zza;
        if (zzs != null) {
            return zzs;
        }
        zzs zzd = zzd();
        this.zza = zzd;
        return zzd;
    }
}
