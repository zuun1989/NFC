package com.google.android.gms.internal.mlkit_vision_face;

final class zzcp implements zzcu {
    private final int zza;
    private final zzct zzb;

    public zzcp(int i, zzct zzct) {
        this.zza = i;
        this.zzb = zzct;
    }

    public final Class annotationType() {
        return zzcu.class;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzcu)) {
            return false;
        }
        zzcu zzcu = (zzcu) obj;
        if (this.zza != zzcu.zza() || !this.zzb.equals(zzcu.zzb())) {
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

    public final zzct zzb() {
        return this.zzb;
    }
}
