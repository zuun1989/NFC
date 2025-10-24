package com.google.android.gms.internal.measurement;

import java.util.Map;
import java.util.Objects;

final class zzob implements Map.Entry, Comparable {
    final /* synthetic */ zzoe zza;
    private final Comparable zzb;
    private Object zzc;

    public zzob(zzoe zzoe, Comparable comparable, Object obj) {
        Objects.requireNonNull(zzoe);
        this.zza = zzoe;
        this.zzb = comparable;
        this.zzc = obj;
    }

    private static final boolean zzb(Object obj, Object obj2) {
        if (obj != null) {
            return obj.equals(obj2);
        }
        if (obj2 != null) {
            return false;
        }
        return true;
    }

    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return this.zzb.compareTo(((zzob) obj).zzb);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        if (!zzb(this.zzb, entry.getKey()) || !zzb(this.zzc, entry.getValue())) {
            return false;
        }
        return true;
    }

    public final /* synthetic */ Object getKey() {
        return this.zzb;
    }

    public final Object getValue() {
        return this.zzc;
    }

    public final int hashCode() {
        int i;
        Comparable comparable = this.zzb;
        int i2 = 0;
        if (comparable == null) {
            i = 0;
        } else {
            i = comparable.hashCode();
        }
        Object obj = this.zzc;
        if (obj != null) {
            i2 = obj.hashCode();
        }
        return i ^ i2;
    }

    public final Object setValue(Object obj) {
        this.zza.zzh();
        Object obj2 = this.zzc;
        this.zzc = obj;
        return obj2;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zzb);
        String valueOf2 = String.valueOf(this.zzc);
        StringBuilder sb2 = new StringBuilder(valueOf.length() + 1 + valueOf2.length());
        sb2.append(valueOf);
        sb2.append("=");
        sb2.append(valueOf2);
        return sb2.toString();
    }

    public final Comparable zza() {
        return this.zzb;
    }
}
