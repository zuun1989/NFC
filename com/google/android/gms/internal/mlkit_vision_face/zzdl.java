package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.common.internal.Objects;

public final class zzdl {
    private final zzka zza;
    private final Boolean zzb;
    private final zzjp zzc = null;
    private final zzjl zzd;
    private final Integer zze;
    private final Integer zzf;

    public /* synthetic */ zzdl(zzdj zzdj, zzdk zzdk) {
        this.zza = zzdj.zza;
        this.zzb = zzdj.zzb;
        this.zzd = zzdj.zzc;
        this.zze = zzdj.zzd;
        this.zzf = zzdj.zze;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzdl)) {
            return false;
        }
        zzdl zzdl = (zzdl) obj;
        if (!Objects.equal(this.zza, zzdl.zza) || !Objects.equal(this.zzb, zzdl.zzb) || !Objects.equal((Object) null, (Object) null) || !Objects.equal(this.zzd, zzdl.zzd) || !Objects.equal(this.zze, zzdl.zze) || !Objects.equal(this.zzf, zzdl.zzf)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, this.zzb, null, this.zzd, this.zze, this.zzf);
    }

    @zzcu(zza = 4)
    public final zzjl zza() {
        return this.zzd;
    }

    @zzcu(zza = 1)
    public final zzka zzb() {
        return this.zza;
    }

    @zzcu(zza = 2)
    public final Boolean zzc() {
        return this.zzb;
    }

    @zzcu(zza = 5)
    public final Integer zzd() {
        return this.zze;
    }

    @zzcu(zza = 6)
    public final Integer zze() {
        return this.zzf;
    }
}
