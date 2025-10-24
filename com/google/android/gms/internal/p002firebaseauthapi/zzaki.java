package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.api.Api;
import java.io.IOException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaki  reason: invalid package */
public abstract class zzaki {
    private static volatile int zzd = 100;
    int zza;
    int zzb;
    zzakm zzc;
    private int zze;
    private int zzf;

    public static int zza(int i) {
        return (-(i & 1)) ^ (i >>> 1);
    }

    public abstract double zza() throws IOException;

    public abstract float zzb() throws IOException;

    public abstract int zzb(int i) throws zzalm;

    public abstract int zzc();

    public abstract void zzc(int i) throws zzalm;

    public abstract int zzd() throws IOException;

    public abstract void zzd(int i);

    public abstract int zze() throws IOException;

    public abstract boolean zze(int i) throws IOException;

    public abstract int zzf() throws IOException;

    public abstract int zzg() throws IOException;

    public abstract int zzh() throws IOException;

    public abstract int zzi() throws IOException;

    public abstract int zzj() throws IOException;

    public abstract long zzk() throws IOException;

    public abstract long zzl() throws IOException;

    public abstract long zzm() throws IOException;

    public abstract long zzn() throws IOException;

    public abstract long zzo() throws IOException;

    public abstract long zzp() throws IOException;

    public abstract zzajw zzq() throws IOException;

    public abstract String zzr() throws IOException;

    public abstract String zzs() throws IOException;

    public final void zzt() throws zzalm {
        if (this.zza + this.zze >= this.zzf) {
            throw zzalm.zzh();
        }
    }

    public final void zzu() throws zzalm {
        if (this.zze == 0) {
            zzc(0);
        }
    }

    public final void zzv() throws IOException {
        int zzi;
        do {
            zzi = zzi();
            if (zzi != 0) {
                zzt();
                this.zze++;
                this.zze--;
            } else {
                return;
            }
        } while (zze(zzi));
    }

    public abstract boolean zzw() throws IOException;

    public abstract boolean zzx() throws IOException;

    private zzaki() {
        this.zzf = zzd;
        this.zzb = Api.BaseClientBuilder.API_PRIORITY_OTHER;
    }

    public static long zza(long j) {
        return (-(j & 1)) ^ (j >>> 1);
    }

    public static zzaki zza(byte[] bArr, int i, int i2, boolean z) {
        zzakl zzakl = new zzakl(bArr, i, i2, z);
        try {
            zzakl.zzb(i2);
            return zzakl;
        } catch (zzalm e) {
            throw new IllegalArgumentException(e);
        }
    }
}
