package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.common.internal.Objects;

public final class zzjp {
    private final zzjn zza;
    private final Integer zzb;
    private final Integer zzc = null;
    private final Boolean zzd = null;

    public /* synthetic */ zzjp(zzjm zzjm, zzjo zzjo) {
        this.zza = zzjm.zza;
        this.zzb = zzjm.zzb;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzjp)) {
            return false;
        }
        zzjp zzjp = (zzjp) obj;
        if (!Objects.equal(this.zza, zzjp.zza) || !Objects.equal(this.zzb, zzjp.zzb) || !Objects.equal((Object) null, (Object) null) || !Objects.equal((Object) null, (Object) null)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, this.zzb, null, null);
    }

    @zzcu(zza = 1)
    public final zzjn zza() {
        return this.zza;
    }

    @zzcu(zza = 2)
    public final Integer zzb() {
        return this.zzb;
    }
}
