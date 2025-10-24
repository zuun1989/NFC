package com.google.android.gms.internal.clearcut;

import java.util.Map;

final class zzep implements Comparable, Map.Entry {
    private Object value;
    private final /* synthetic */ zzei zzos;
    private final Comparable zzov;

    public zzep(zzei zzei, Comparable comparable, Object obj) {
        this.zzos = zzei;
        this.zzov = comparable;
        this.value = obj;
    }

    public final /* synthetic */ int compareTo(Object obj) {
        return ((Comparable) getKey()).compareTo((Comparable) ((zzep) obj).getKey());
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        return equals(this.zzov, entry.getKey()) && equals(this.value, entry.getValue());
    }

    public final /* synthetic */ Object getKey() {
        return this.zzov;
    }

    public final Object getValue() {
        return this.value;
    }

    public final int hashCode() {
        Comparable comparable = this.zzov;
        int i = 0;
        int hashCode = comparable == null ? 0 : comparable.hashCode();
        Object obj = this.value;
        if (obj != null) {
            i = obj.hashCode();
        }
        return hashCode ^ i;
    }

    public final Object setValue(Object obj) {
        this.zzos.zzdu();
        Object obj2 = this.value;
        this.value = obj;
        return obj2;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zzov);
        String valueOf2 = String.valueOf(this.value);
        StringBuilder sb2 = new StringBuilder(valueOf.length() + 1 + valueOf2.length());
        sb2.append(valueOf);
        sb2.append("=");
        sb2.append(valueOf2);
        return sb2.toString();
    }

    public zzep(zzei zzei, Map.Entry entry) {
        this(zzei, (Comparable) entry.getKey(), entry.getValue());
    }

    private static boolean equals(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }
}
