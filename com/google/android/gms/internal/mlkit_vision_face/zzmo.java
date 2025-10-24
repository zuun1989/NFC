package com.google.android.gms.internal.mlkit_vision_face;

final class zzmo extends zzmq {
    private final String zza;
    private final boolean zzb;
    private final int zzc;

    public /* synthetic */ zzmo(String str, boolean z, int i, zzmn zzmn) {
        this.zza = str;
        this.zzb = z;
        this.zzc = i;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzmq) {
            zzmq zzmq = (zzmq) obj;
            if (this.zza.equals(zzmq.zzb()) && this.zzb == zzmq.zzc() && this.zzc == zzmq.zza()) {
                return true;
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        int i;
        int hashCode = (this.zza.hashCode() ^ 1000003) * 1000003;
        if (true != this.zzb) {
            i = 1237;
        } else {
            i = 1231;
        }
        return ((hashCode ^ i) * 1000003) ^ this.zzc;
    }

    public final String toString() {
        String str = this.zza;
        boolean z = this.zzb;
        int i = this.zzc;
        StringBuilder sb2 = new StringBuilder(str.length() + 84);
        sb2.append("MLKitLoggingOptions{libraryName=");
        sb2.append(str);
        sb2.append(", enableFirelog=");
        sb2.append(z);
        sb2.append(", firelogEventType=");
        sb2.append(i);
        sb2.append("}");
        return sb2.toString();
    }

    public final int zza() {
        return this.zzc;
    }

    public final String zzb() {
        return this.zza;
    }

    public final boolean zzc() {
        return this.zzb;
    }
}
