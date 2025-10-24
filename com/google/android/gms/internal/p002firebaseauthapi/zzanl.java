package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Map;
import java.util.Objects;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzanl  reason: invalid package */
final class zzanl implements Comparable, Map.Entry {
    private final Comparable zza;
    private Object zzb;
    private final /* synthetic */ zzanh zzc;

    public zzanl(zzanh zzanh, Map.Entry entry) {
        this(zzanh, (Comparable) entry.getKey(), entry.getValue());
    }

    private static boolean zza(Object obj, Object obj2) {
        if (obj != null) {
            return obj.equals(obj2);
        }
        if (obj2 == null) {
            return true;
        }
        return false;
    }

    public final /* synthetic */ int compareTo(Object obj) {
        return ((Comparable) getKey()).compareTo((Comparable) ((zzanl) obj).getKey());
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        if (!zza(this.zza, entry.getKey()) || !zza(this.zzb, entry.getValue())) {
            return false;
        }
        return true;
    }

    public final /* synthetic */ Object getKey() {
        return this.zza;
    }

    public final Object getValue() {
        return this.zzb;
    }

    public final int hashCode() {
        int i;
        Comparable comparable = this.zza;
        int i2 = 0;
        if (comparable == null) {
            i = 0;
        } else {
            i = comparable.hashCode();
        }
        Object obj = this.zzb;
        if (obj != null) {
            i2 = obj.hashCode();
        }
        return i ^ i2;
    }

    public final Object setValue(Object obj) {
        this.zzc.zzg();
        Object obj2 = this.zzb;
        this.zzb = obj;
        return obj2;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zza);
        String valueOf2 = String.valueOf(this.zzb);
        return valueOf + "=" + valueOf2;
    }

    public zzanl(zzanh zzanh, Comparable comparable, Object obj) {
        Objects.requireNonNull(zzanh);
        this.zzc = zzanh;
        this.zza = comparable;
        this.zzb = obj;
    }
}
