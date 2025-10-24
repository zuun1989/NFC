package com.google.android.gms.internal.measurement;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public final class zzng extends LinkedHashMap {
    private static final zzng zzb;
    private boolean zza = true;

    static {
        zzng zzng = new zzng();
        zzb = zzng;
        zzng.zza = false;
    }

    private zzng() {
    }

    public static zzng zza() {
        return zzb;
    }

    private static int zzf(Object obj) {
        if (obj instanceof byte[]) {
            byte[] bArr = (byte[]) obj;
            byte[] bArr2 = zzmp.zzb;
            int length = bArr.length;
            int zzc = zzmp.zzc(length, bArr, 0, length);
            if (zzc == 0) {
                return 1;
            }
            return zzc;
        } else if (!(obj instanceof zzmj)) {
            return obj.hashCode();
        } else {
            throw new UnsupportedOperationException();
        }
    }

    private final void zzg() {
        if (!this.zza) {
            throw new UnsupportedOperationException();
        }
    }

    public final void clear() {
        zzg();
        super.clear();
    }

    public final Set entrySet() {
        if (isEmpty()) {
            return Collections.emptySet();
        }
        return super.entrySet();
    }

    public final boolean equals(Object obj) {
        boolean z;
        if (!(obj instanceof Map)) {
            return false;
        }
        Map map = (Map) obj;
        if (this == map) {
            return true;
        }
        if (size() != map.size()) {
            return false;
        }
        for (Map.Entry entry : entrySet()) {
            if (!map.containsKey(entry.getKey())) {
                return false;
            }
            Object value = entry.getValue();
            Object obj2 = map.get(entry.getKey());
            if (!(value instanceof byte[]) || !(obj2 instanceof byte[])) {
                z = value.equals(obj2);
                continue;
            } else {
                z = Arrays.equals((byte[]) value, (byte[]) obj2);
                continue;
            }
            if (!z) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i = 0;
        for (Map.Entry entry : entrySet()) {
            i += zzf(entry.getValue()) ^ zzf(entry.getKey());
        }
        return i;
    }

    public final Object put(Object obj, Object obj2) {
        zzg();
        byte[] bArr = zzmp.zzb;
        obj.getClass();
        obj2.getClass();
        return super.put(obj, obj2);
    }

    public final void putAll(Map map) {
        zzg();
        for (Object next : map.keySet()) {
            byte[] bArr = zzmp.zzb;
            next.getClass();
            map.get(next).getClass();
        }
        super.putAll(map);
    }

    public final Object remove(Object obj) {
        zzg();
        return super.remove(obj);
    }

    public final void zzb(zzng zzng) {
        zzg();
        if (!zzng.isEmpty()) {
            putAll(zzng);
        }
    }

    public final zzng zzc() {
        if (isEmpty()) {
            return new zzng();
        }
        return new zzng(this);
    }

    public final void zzd() {
        this.zza = false;
    }

    public final boolean zze() {
        return this.zza;
    }

    private zzng(Map map) {
        super(map);
    }
}
