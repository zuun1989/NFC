package com.google.android.gms.internal.mlkit_vision_barcode;

import java.io.Serializable;
import java.util.Map;
import java.util.Set;

public abstract class zzcu implements Map, Serializable {
    private transient zzcv zza;
    private transient zzcv zzb;
    private transient zzcn zzc;

    public static zzcu zzc(Object obj, Object obj2) {
        zzby.zzb("optional-module-barcode", "com.google.android.gms.vision.barcode");
        return zzdp.zzg(1, new Object[]{"optional-module-barcode", "com.google.android.gms.vision.barcode"}, (zzct) null);
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
        return zzds.zza(entrySet());
    }

    public final boolean isEmpty() {
        return false;
    }

    public final /* bridge */ /* synthetic */ Set keySet() {
        zzcv zzcv = this.zzb;
        if (zzcv != null) {
            return zzcv;
        }
        zzcv zze = zze();
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
        zzby.zza(size, "size");
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

    public abstract zzcn zza();

    /* renamed from: zzb */
    public final zzcn values() {
        zzcn zzcn = this.zzc;
        if (zzcn != null) {
            return zzcn;
        }
        zzcn zza2 = zza();
        this.zzc = zza2;
        return zza2;
    }

    public abstract zzcv zzd();

    public abstract zzcv zze();

    /* renamed from: zzf */
    public final zzcv entrySet() {
        zzcv zzcv = this.zza;
        if (zzcv != null) {
            return zzcv;
        }
        zzcv zzd = zzd();
        this.zza = zzd;
        return zzd;
    }
}
