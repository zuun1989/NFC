package com.google.android.gms.internal.mlkit_vision_common;

final class zzma extends zzme {
    private final String zza;
    private final boolean zzb;
    private final int zzc;

    public /* synthetic */ zzma(String str, boolean z, int i, zzlz zzlz) {
        this.zza = str;
        this.zzb = z;
        this.zzc = i;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzme) {
            zzme zzme = (zzme) obj;
            if (this.zza.equals(zzme.zzb()) && this.zzb == zzme.zzc() && this.zzc == zzme.zza()) {
                return true;
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        int i;
        int hashCode = this.zza.hashCode() ^ 1000003;
        if (true != this.zzb) {
            i = 1237;
        } else {
            i = 1231;
        }
        return (((hashCode * 1000003) ^ i) * 1000003) ^ this.zzc;
    }

    public final String toString() {
        String str = this.zza;
        boolean z = this.zzb;
        int i = this.zzc;
        return "MLKitLoggingOptions{libraryName=" + str + ", enableFirelog=" + z + ", firelogEventType=" + i + "}";
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
