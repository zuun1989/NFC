package com.google.android.gms.internal.measurement;

import G5.v;
import android.content.Context;

final class zzjn extends zzkh {
    private final Context zza;
    private final v zzb;

    public zzjn(Context context, v vVar) {
        this.zza = context;
        this.zzb = vVar;
    }

    public final boolean equals(Object obj) {
        v vVar;
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzkh) {
            zzkh zzkh = (zzkh) obj;
            if (!this.zza.equals(zzkh.zza()) || ((vVar = this.zzb) != null ? !vVar.equals(zzkh.zzb()) : zzkh.zzb() != null)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i;
        int hashCode = this.zza.hashCode() ^ 1000003;
        v vVar = this.zzb;
        if (vVar == null) {
            i = 0;
        } else {
            i = vVar.hashCode();
        }
        return (hashCode * 1000003) ^ i;
    }

    public final String toString() {
        String obj = this.zza.toString();
        int length = obj.length();
        String valueOf = String.valueOf(this.zzb);
        StringBuilder sb2 = new StringBuilder(length + 45 + valueOf.length() + 1);
        sb2.append("FlagsContext{context=");
        sb2.append(obj);
        sb2.append(", hermeticFileOverrides=");
        sb2.append(valueOf);
        sb2.append("}");
        return sb2.toString();
    }

    public final Context zza() {
        return this.zza;
    }

    public final v zzb() {
        return this.zzb;
    }
}
