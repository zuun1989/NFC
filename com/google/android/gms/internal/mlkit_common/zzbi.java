package com.google.android.gms.internal.mlkit_common;

import G6.c;
import G6.d;
import G6.h;
import java.io.IOException;

final class zzbi implements h {
    private boolean zza = false;
    private boolean zzb = false;
    private d zzc;
    private final zzbe zzd;

    public zzbi(zzbe zzbe) {
        this.zzd = zzbe;
    }

    private final void zzb() {
        if (!this.zza) {
            this.zza = true;
            return;
        }
        throw new c("Cannot encode a second value in the ValueEncoderContext");
    }

    public final h add(double d) throws IOException {
        zzb();
        this.zzd.zza(this.zzc, d, this.zzb);
        return this;
    }

    public final void zza(d dVar, boolean z) {
        this.zza = false;
        this.zzc = dVar;
        this.zzb = z;
    }

    public final h add(float f) throws IOException {
        zzb();
        this.zzd.zzb(this.zzc, f, this.zzb);
        return this;
    }

    public final h add(int i) throws IOException {
        zzb();
        this.zzd.zzd(this.zzc, i, this.zzb);
        return this;
    }

    public final h add(long j) throws IOException {
        zzb();
        this.zzd.zze(this.zzc, j, this.zzb);
        return this;
    }

    public final h add(String str) throws IOException {
        zzb();
        this.zzd.zzc(this.zzc, str, this.zzb);
        return this;
    }

    public final h add(boolean z) throws IOException {
        zzb();
        this.zzd.zzd(this.zzc, z ? 1 : 0, this.zzb);
        return this;
    }

    public final h add(byte[] bArr) throws IOException {
        zzb();
        this.zzd.zzc(this.zzc, bArr, this.zzb);
        return this;
    }
}
