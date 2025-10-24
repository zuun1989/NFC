package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.common.internal.Objects;

public final class zzjl {
    private final zzji zza;
    private final zzjg zzb;
    private final zzjj zzc;
    private final zzjh zzd;
    private final Boolean zze;
    private final Float zzf;

    public /* synthetic */ zzjl(zzjf zzjf, zzjk zzjk) {
        this.zza = zzjf.zza;
        this.zzb = zzjf.zzb;
        this.zzc = zzjf.zzc;
        this.zzd = zzjf.zzd;
        this.zze = zzjf.zze;
        this.zzf = zzjf.zzf;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzjl)) {
            return false;
        }
        zzjl zzjl = (zzjl) obj;
        if (!Objects.equal(this.zza, zzjl.zza) || !Objects.equal(this.zzb, zzjl.zzb) || !Objects.equal(this.zzc, zzjl.zzc) || !Objects.equal(this.zzd, zzjl.zzd) || !Objects.equal(this.zze, zzjl.zze) || !Objects.equal(this.zzf, zzjl.zzf)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf);
    }

    @zzcu(zza = 2)
    public final zzjg zza() {
        return this.zzb;
    }

    @zzcu(zza = 4)
    public final zzjh zzb() {
        return this.zzd;
    }

    @zzcu(zza = 1)
    public final zzji zzc() {
        return this.zza;
    }

    @zzcu(zza = 3)
    public final zzjj zzd() {
        return this.zzc;
    }

    @zzcu(zza = 5)
    public final Boolean zze() {
        return this.zze;
    }

    @zzcu(zza = 6)
    public final Float zzf() {
        return this.zzf;
    }
}
