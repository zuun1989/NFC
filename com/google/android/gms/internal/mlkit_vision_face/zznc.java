package com.google.android.gms.internal.mlkit_vision_face;

import I6.d;
import com.google.android.gms.common.internal.Preconditions;
import java.io.UnsupportedEncodingException;

public final class zznc {
    private final zzkc zza;
    private zzlr zzb = new zzlr();
    private final int zzc;

    private zznc(zzkc zzkc, int i) {
        this.zza = zzkc;
        zznl.zza();
        this.zzc = i;
    }

    public static zznc zzd(zzkc zzkc) {
        return new zznc(zzkc, 0);
    }

    public static zznc zze(zzkc zzkc, int i) {
        return new zznc(zzkc, 1);
    }

    public final int zza() {
        return this.zzc;
    }

    public final String zzb() {
        zzlt zzf = this.zza.zzj().zzf();
        if (zzf == null || zzac.zzb(zzf.zzk())) {
            return "NA";
        }
        return (String) Preconditions.checkNotNull(zzf.zzk());
    }

    public final byte[] zzc(int i, boolean z) {
        boolean z2;
        zzlr zzlr = this.zzb;
        if (1 != (i ^ 1)) {
            z2 = false;
        } else {
            z2 = true;
        }
        zzlr.zzf(Boolean.valueOf(z2));
        this.zzb.zze(Boolean.FALSE);
        this.zza.zzi(this.zzb.zzm());
        try {
            zznl.zza();
            if (i == 0) {
                return new d().i(zzif.zza).j(true).h().encode(this.zza.zzj()).getBytes("utf-8");
            }
            zzke zzj = this.zza.zzj();
            zzcy zzcy = new zzcy();
            zzif.zza.configure(zzcy);
            return zzcy.zza().zza(zzj);
        } catch (UnsupportedEncodingException e) {
            throw new UnsupportedOperationException("Failed to covert logging to UTF-8 byte array", e);
        }
    }

    public final zznc zzf(zzkb zzkb) {
        this.zza.zzf(zzkb);
        return this;
    }

    public final zznc zzg(zzlr zzlr) {
        this.zzb = zzlr;
        return this;
    }
}
