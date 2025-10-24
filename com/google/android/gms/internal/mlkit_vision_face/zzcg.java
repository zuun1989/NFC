package com.google.android.gms.internal.mlkit_vision_face;

final class zzcg extends zzbn {
    private final transient Object[] zza;
    private final transient int zzb;
    private final transient int zzc;

    public zzcg(Object[] objArr, int i, int i2) {
        this.zza = objArr;
        this.zzb = i;
        this.zzc = i2;
    }

    public final Object get(int i) {
        zzab.zza(i, this.zzc, "index");
        Object obj = this.zza[i + i + this.zzb];
        obj.getClass();
        return obj;
    }

    public final int size() {
        return this.zzc;
    }
}
