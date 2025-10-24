package com.google.android.gms.internal.mlkit_vision_common;

final class zzad implements zzai {
    private final int zza;
    private final zzah zzb;

    public zzad(int i, zzah zzah) {
        this.zza = i;
        this.zzb = zzah;
    }

    public final Class annotationType() {
        return zzai.class;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzai)) {
            return false;
        }
        zzai zzai = (zzai) obj;
        if (this.zza != zzai.zza() || !this.zzb.equals(zzai.zzb())) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return (this.zza ^ 14552422) + (this.zzb.hashCode() ^ 2041407134);
    }

    public final String toString() {
        return "@com.google.firebase.encoders.proto.Protobuf" + "(tag=" + this.zza + "intEncoding=" + this.zzb + ')';
    }

    public final int zza() {
        return this.zza;
    }

    public final zzah zzb() {
        return this.zzb;
    }
}
