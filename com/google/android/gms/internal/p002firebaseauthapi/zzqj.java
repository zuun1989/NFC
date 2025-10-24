package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Objects;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzqj  reason: invalid package */
final class zzqj {
    private final Class<? extends zzqi> zza;
    private final zzaam zzb;

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzqj)) {
            return false;
        }
        zzqj zzqj = (zzqj) obj;
        if (!zzqj.zza.equals(this.zza) || !zzqj.zzb.equals(this.zzb)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Objects.hash(new Object[]{this.zza, this.zzb});
    }

    public final String toString() {
        String simpleName = this.zza.getSimpleName();
        String valueOf = String.valueOf(this.zzb);
        return simpleName + ", object identifier: " + valueOf;
    }

    private zzqj(Class<? extends zzqi> cls, zzaam zzaam) {
        this.zza = cls;
        this.zzb = zzaam;
    }
}
