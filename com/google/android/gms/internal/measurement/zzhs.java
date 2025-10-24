package com.google.android.gms.internal.measurement;

import java.util.List;

public final class zzhs extends zzmf implements zznn {
    /* access modifiers changed from: private */
    public static final zzhs zzj;
    private int zzb;
    private zzmo zzd = zzmf.zzcv();
    private String zze = "";
    private long zzf;
    private long zzg;
    private int zzh;
    private long zzi;

    static {
        zzhs zzhs = new zzhs();
        zzj = zzhs;
        zzmf.zzcp(zzhs.class, zzhs);
    }

    private zzhs() {
    }

    public static zzhr zzk() {
        return (zzhr) zzj.zzck();
    }

    private final void zzw() {
        zzmo zzmo = this.zzd;
        if (!zzmo.zza()) {
            this.zzd = zzmf.zzcw(zzmo);
        }
    }

    public final List zza() {
        return this.zzd;
    }

    public final int zzb() {
        return this.zzd.size();
    }

    public final zzhw zzc(int i) {
        return (zzhw) this.zzd.get(i);
    }

    public final String zzd() {
        return this.zze;
    }

    public final boolean zze() {
        return (this.zzb & 2) != 0;
    }

    public final long zzf() {
        return this.zzf;
    }

    public final boolean zzg() {
        return (this.zzb & 4) != 0;
    }

    public final long zzh() {
        return this.zzg;
    }

    public final boolean zzi() {
        return (this.zzb & 8) != 0;
    }

    public final int zzj() {
        return this.zzh;
    }

    public final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzmf.zzcq(zzj, "\u0004\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0000\u0001\u001b\u0002ဈ\u0000\u0003ဂ\u0001\u0004ဂ\u0002\u0005င\u0003\u0006ဂ\u0004", new Object[]{"zzb", "zzd", zzhw.class, "zze", "zzf", "zzg", "zzh", "zzi"});
        } else if (i2 == 3) {
            return new zzhs();
        } else {
            if (i2 == 4) {
                return new zzhr((byte[]) null);
            }
            if (i2 == 5) {
                return zzj;
            }
            throw null;
        }
    }

    public final /* synthetic */ void zzm(int i, zzhw zzhw) {
        zzhw.getClass();
        zzw();
        this.zzd.set(i, zzhw);
    }

    public final /* synthetic */ void zzn(zzhw zzhw) {
        zzhw.getClass();
        zzw();
        this.zzd.add(zzhw);
    }

    public final /* synthetic */ void zzo(Iterable iterable) {
        zzw();
        zzks.zzce(iterable, this.zzd);
    }

    public final /* synthetic */ void zzp() {
        this.zzd = zzmf.zzcv();
    }

    public final /* synthetic */ void zzq(int i) {
        zzw();
        this.zzd.remove(i);
    }

    public final /* synthetic */ void zzr(String str) {
        str.getClass();
        this.zzb |= 1;
        this.zze = str;
    }

    public final /* synthetic */ void zzs(long j) {
        this.zzb |= 2;
        this.zzf = j;
    }

    public final /* synthetic */ void zzt(long j) {
        this.zzb |= 4;
        this.zzg = j;
    }

    public final /* synthetic */ void zzu(long j) {
        this.zzb |= 16;
        this.zzi = j;
    }
}
