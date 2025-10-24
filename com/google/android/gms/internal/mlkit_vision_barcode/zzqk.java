package com.google.android.gms.internal.mlkit_vision_barcode;

import com.google.android.gms.common.internal.Objects;

public final class zzqk {
    private final zzqi zza;
    private final Integer zzb;
    private final Integer zzc = null;
    private final Boolean zzd = null;

    public /* synthetic */ zzqk(zzqh zzqh, zzqj zzqj) {
        this.zza = zzqh.zza;
        this.zzb = zzqh.zzb;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzqk)) {
            return false;
        }
        zzqk zzqk = (zzqk) obj;
        if (!Objects.equal(this.zza, zzqk.zza) || !Objects.equal(this.zzb, zzqk.zzb) || !Objects.equal((Object) null, (Object) null) || !Objects.equal((Object) null, (Object) null)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, this.zzb, null, null);
    }

    @zzfe(zza = 1)
    public final zzqi zza() {
        return this.zza;
    }

    @zzfe(zza = 2)
    public final Integer zzb() {
        return this.zzb;
    }
}
