package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Objects;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzoh  reason: invalid package */
public final class zzoh extends zzce {
    private final zzqd zza;

    public zzoh(zzqd zzqd) {
        this.zza = zzqd;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzoh)) {
            return false;
        }
        zzqd zzqd = ((zzoh) obj).zza;
        if (!this.zza.zza().zzd().equals(zzqd.zza().zzd()) || !this.zza.zza().zzf().equals(zzqd.zza().zzf()) || !this.zza.zza().zze().equals(zzqd.zza().zze())) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Objects.hash(new Object[]{this.zza.zza(), this.zza.zzb()});
    }

    public final String toString() {
        String str;
        String zzf = this.zza.zza().zzf();
        int i = zzok.zza[this.zza.zza().zzd().ordinal()];
        if (i == 1) {
            str = "TINK";
        } else if (i == 2) {
            str = "LEGACY";
        } else if (i == 3) {
            str = "RAW";
        } else if (i != 4) {
            str = "UNKNOWN";
        } else {
            str = "CRUNCHY";
        }
        return String.format("(typeUrl=%s, outputPrefixType=%s)", new Object[]{zzf, str});
    }

    public final boolean zza() {
        if (this.zza.zza().zzd() != zzyc.RAW) {
            return true;
        }
        return false;
    }

    public final zzqd zzb() {
        return this.zza;
    }
}
