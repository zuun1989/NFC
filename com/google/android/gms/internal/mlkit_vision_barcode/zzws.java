package com.google.android.gms.internal.mlkit_vision_barcode;

import I6.d;
import com.google.android.gms.common.internal.Preconditions;
import java.io.UnsupportedEncodingException;

public final class zzws implements zzwe {
    private final zzrd zza;
    private zzvb zzb = new zzvb();
    private final int zzc;

    private zzws(zzrd zzrd, int i) {
        this.zza = zzrd;
        zzxb.zza();
        this.zzc = i;
    }

    public static zzwe zzf(zzrd zzrd) {
        return new zzws(zzrd, 0);
    }

    public static zzwe zzg(zzrd zzrd, int i) {
        return new zzws(zzrd, 1);
    }

    public final int zza() {
        return this.zzc;
    }

    public final zzwe zzb(zzrc zzrc) {
        this.zza.zzf(zzrc);
        return this;
    }

    public final zzwe zzc(zzvb zzvb) {
        this.zzb = zzvb;
        return this;
    }

    public final String zzd() {
        zzvd zzg = this.zza.zzk().zzg();
        if (zzg == null || zzba.zzc(zzg.zzk())) {
            return "NA";
        }
        return (String) Preconditions.checkNotNull(zzg.zzk());
    }

    public final byte[] zze(int i, boolean z) {
        boolean z2;
        int i2 = i ^ 1;
        zzvb zzvb = this.zzb;
        if (1 != i2) {
            z2 = false;
        } else {
            z2 = true;
        }
        zzvb.zzf(Boolean.valueOf(z2));
        this.zzb.zze(Boolean.FALSE);
        this.zza.zzj(this.zzb.zzm());
        try {
            zzxb.zza();
            if (i == 0) {
                return new d().i(zzox.zza).j(true).h().encode(this.zza.zzk()).getBytes("utf-8");
            }
            zzrf zzk = this.zza.zzk();
            zzfi zzfi = new zzfi();
            zzox.zza.configure(zzfi);
            return zzfi.zza().zza(zzk);
        } catch (UnsupportedEncodingException e) {
            throw new UnsupportedOperationException("Failed to covert logging to UTF-8 byte array", e);
        }
    }
}
