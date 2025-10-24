package com.google.android.gms.internal.mlkit_vision_barcode;

import com.google.android.gms.common.internal.Objects;

public final class zzvz {
    private final zzcs zza;

    public /* synthetic */ zzvz(zzvx zzvx, zzvy zzvy) {
        this.zza = zzvx.zza;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzvz)) {
            return false;
        }
        return Objects.equal(this.zza, ((zzvz) obj).zza);
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza);
    }

    @zzfe(zza = 1)
    public final zzcs zza() {
        return this.zza;
    }
}
