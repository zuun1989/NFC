package com.google.android.gms.internal.mlkit_common;

import I6.d;
import com.google.android.gms.common.internal.Preconditions;
import java.io.UnsupportedEncodingException;

public final class zzsk implements zzry {
    private final zzmw zza;
    private zzqt zzb = new zzqt();

    private zzsk(zzmw zzmw, int i) {
        this.zza = zzmw;
        zzsv.zza();
    }

    public static zzry zzf(zzmw zzmw) {
        return new zzsk(zzmw, 0);
    }

    public static zzry zzg() {
        return new zzsk(new zzmw(), 0);
    }

    public final zzry zza(zzmv zzmv) {
        this.zza.zzf(zzmv);
        return this;
    }

    public final zzry zzb(zznc zznc) {
        this.zza.zzi(zznc);
        return this;
    }

    public final zzry zzc(zzqt zzqt) {
        this.zzb = zzqt;
        return this;
    }

    public final String zzd() {
        String zzk;
        zzqv zzf = this.zza.zzk().zzf();
        if (zzf == null || (zzk = zzf.zzk()) == null || zzk.isEmpty()) {
            return "NA";
        }
        return (String) Preconditions.checkNotNull(zzf.zzk());
    }

    public final byte[] zze(int i, boolean z) {
        boolean z2;
        int i2 = i ^ 1;
        zzqt zzqt = this.zzb;
        if (1 != i2) {
            z2 = false;
        } else {
            z2 = true;
        }
        zzqt.zzf(Boolean.valueOf(z2));
        this.zzb.zze(Boolean.FALSE);
        this.zza.zzj(this.zzb.zzm());
        try {
            zzsv.zza();
            if (i == 0) {
                return new d().i(zzkr.zza).j(true).h().encode(this.zza.zzk()).getBytes("utf-8");
            }
            zzmy zzk = this.zza.zzk();
            zzbg zzbg = new zzbg();
            zzkr.zza.configure(zzbg);
            return zzbg.zza().zza(zzk);
        } catch (UnsupportedEncodingException e) {
            throw new UnsupportedOperationException("Failed to covert logging to UTF-8 byte array", e);
        }
    }
}
