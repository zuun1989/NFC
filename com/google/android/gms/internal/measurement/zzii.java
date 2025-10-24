package com.google.android.gms.internal.measurement;

import java.util.List;

public final class zzii extends zzmf implements zznn {
    /* access modifiers changed from: private */
    public static final zzii zzg;
    private zzmn zzb = zzmf.zzct();
    private zzmn zzd = zzmf.zzct();
    private zzmo zze = zzmf.zzcv();
    private zzmo zzf = zzmf.zzcv();

    static {
        zzii zzii = new zzii();
        zzg = zzii;
        zzmf.zzcp(zzii.class, zzii);
    }

    private zzii() {
    }

    public static zzih zzi() {
        return (zzih) zzg.zzck();
    }

    public static zzii zzj() {
        return zzg;
    }

    public final List zza() {
        return this.zzb;
    }

    public final int zzb() {
        return this.zzb.size();
    }

    public final List zzc() {
        return this.zzd;
    }

    public final int zzd() {
        return this.zzd.size();
    }

    public final List zze() {
        return this.zze;
    }

    public final int zzf() {
        return this.zze.size();
    }

    public final List zzg() {
        return this.zzf;
    }

    public final int zzh() {
        return this.zzf.size();
    }

    public final /* synthetic */ void zzk(Iterable iterable) {
        zzmn zzmn = this.zzb;
        if (!zzmn.zza()) {
            this.zzb = zzmf.zzcu(zzmn);
        }
        zzks.zzce(iterable, this.zzb);
    }

    public final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzmf.zzcq(zzg, "\u0004\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0004\u0000\u0001\u0015\u0002\u0015\u0003\u001b\u0004\u001b", new Object[]{"zzb", "zzd", "zze", zzhq.class, "zzf", zzik.class});
        } else if (i2 == 3) {
            return new zzii();
        } else {
            if (i2 == 4) {
                return new zzih((byte[]) null);
            }
            if (i2 == 5) {
                return zzg;
            }
            throw null;
        }
    }

    public final /* synthetic */ void zzm() {
        this.zzb = zzmf.zzct();
    }

    public final /* synthetic */ void zzn(Iterable iterable) {
        zzmn zzmn = this.zzd;
        if (!zzmn.zza()) {
            this.zzd = zzmf.zzcu(zzmn);
        }
        zzks.zzce(iterable, this.zzd);
    }

    public final /* synthetic */ void zzo() {
        this.zzd = zzmf.zzct();
    }

    public final /* synthetic */ void zzp(Iterable iterable) {
        zzmo zzmo = this.zze;
        if (!zzmo.zza()) {
            this.zze = zzmf.zzcw(zzmo);
        }
        zzks.zzce(iterable, this.zze);
    }

    public final /* synthetic */ void zzq() {
        this.zze = zzmf.zzcv();
    }

    public final /* synthetic */ void zzr(Iterable iterable) {
        zzmo zzmo = this.zzf;
        if (!zzmo.zza()) {
            this.zzf = zzmf.zzcw(zzmo);
        }
        zzks.zzce(iterable, this.zzf);
    }

    public final /* synthetic */ void zzs() {
        this.zzf = zzmf.zzcv();
    }
}
