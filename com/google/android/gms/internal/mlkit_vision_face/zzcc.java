package com.google.android.gms.internal.mlkit_vision_face;

final class zzcc extends zzbn {
    static final zzbn zza = new zzcc(new Object[0], 0);
    final transient Object[] zzb;
    private final transient int zzc;

    public zzcc(Object[] objArr, int i) {
        this.zzb = objArr;
        this.zzc = i;
    }

    public final Object get(int i) {
        zzab.zza(i, this.zzc, "index");
        Object obj = this.zzb[i];
        obj.getClass();
        return obj;
    }

    public final int size() {
        return this.zzc;
    }

    public final int zza(Object[] objArr, int i) {
        System.arraycopy(this.zzb, 0, objArr, 0, this.zzc);
        return this.zzc;
    }

    public final int zzb() {
        return this.zzc;
    }

    public final int zzc() {
        return 0;
    }

    public final Object[] zze() {
        return this.zzb;
    }
}
