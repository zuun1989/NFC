package com.google.android.gms.internal.mlkit_vision_common;

import I6.d;
import com.google.android.gms.common.internal.Preconditions;
import java.io.UnsupportedEncodingException;

public final class zzmk implements zzmb {
    private final zziw zza;
    private zzky zzb = new zzky();

    private zzmk(zziw zziw, int i) {
        this.zza = zziw;
        zzmw.zza();
    }

    public static zzmb zze(zziw zziw) {
        return new zzmk(zziw, 0);
    }

    public final zzmb zza(zziv zziv) {
        this.zza.zzc(zziv);
        return this;
    }

    public final zzmb zzb(zzky zzky) {
        this.zzb = zzky;
        return this;
    }

    public final String zzc() {
        zzla zzc = this.zza.zzf().zzc();
        if (zzc == null || zzg.zzb(zzc.zzk())) {
            return "NA";
        }
        return (String) Preconditions.checkNotNull(zzc.zzk());
    }

    public final byte[] zzd(int i, boolean z) {
        boolean z2;
        int i2 = i ^ 1;
        zzky zzky = this.zzb;
        if (1 != i2) {
            z2 = false;
        } else {
            z2 = true;
        }
        zzky.zzf(Boolean.valueOf(z2));
        this.zzb.zze(Boolean.FALSE);
        this.zza.zze(this.zzb.zzm());
        try {
            zzmw.zza();
            if (i == 0) {
                return new d().i(zzhe.zza).j(true).h().encode(this.zza.zzf()).getBytes("utf-8");
            }
            zziy zzf = this.zza.zzf();
            zzam zzam = new zzam();
            zzhe.zza.configure(zzam);
            return zzam.zza().zza(zzf);
        } catch (UnsupportedEncodingException e) {
            throw new UnsupportedOperationException("Failed to covert logging to UTF-8 byte array", e);
        }
    }
}
