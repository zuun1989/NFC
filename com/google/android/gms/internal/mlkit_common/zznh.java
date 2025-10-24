package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.common.internal.Objects;

public final class zznh {
    private final String zza;
    private final String zzb = null;
    private final zznf zzc;
    private final String zzd;
    private final String zze;
    private final zzne zzf;
    private final Long zzg;
    private final Boolean zzh;
    private final Boolean zzi;

    public /* synthetic */ zznh(zznd zznd, zzng zzng) {
        this.zza = zznd.zza;
        this.zzc = zznd.zzb;
        this.zzd = null;
        this.zze = zznd.zzc;
        this.zzf = zznd.zzd;
        this.zzg = null;
        this.zzh = null;
        this.zzi = null;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zznh)) {
            return false;
        }
        zznh zznh = (zznh) obj;
        if (!Objects.equal(this.zza, zznh.zza) || !Objects.equal((Object) null, (Object) null) || !Objects.equal(this.zzc, zznh.zzc) || !Objects.equal((Object) null, (Object) null) || !Objects.equal(this.zze, zznh.zze) || !Objects.equal(this.zzf, zznh.zzf) || !Objects.equal((Object) null, (Object) null) || !Objects.equal((Object) null, (Object) null) || !Objects.equal((Object) null, (Object) null)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, null, this.zzc, null, this.zze, this.zzf, null, null, null);
    }

    @zzbc(zza = 6)
    public final zzne zza() {
        return this.zzf;
    }

    @zzbc(zza = 3)
    public final zznf zzb() {
        return this.zzc;
    }

    @zzbc(zza = 5)
    public final String zzc() {
        return this.zze;
    }

    @zzbc(zza = 1)
    public final String zzd() {
        return this.zza;
    }
}
