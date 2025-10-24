package com.google.android.gms.internal.measurement;

public final class zzig extends zzmf implements zznn {
    /* access modifiers changed from: private */
    public static final zzig zzf;
    private int zzb;
    private int zzd = 1;
    private zzmo zze = zzmf.zzcv();

    static {
        zzig zzig = new zzig();
        zzf = zzig;
        zzmf.zzcp(zzig.class, zzig);
    }

    private zzig() {
    }

    public static zzie zza() {
        return (zzie) zzf.zzck();
    }

    public final /* synthetic */ void zzb(zzhu zzhu) {
        zzhu.getClass();
        zzmo zzmo = this.zze;
        if (!zzmo.zza()) {
            this.zze = zzmf.zzcw(zzmo);
        }
        this.zze.add(zzhu);
    }

    public final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzmf.zzcq(zzf, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001᠌\u0000\u0002\u001b", new Object[]{"zzb", "zzd", zzif.zza, "zze", zzhu.class});
        } else if (i2 == 3) {
            return new zzig();
        } else {
            if (i2 == 4) {
                return new zzie((byte[]) null);
            }
            if (i2 == 5) {
                return zzf;
            }
            throw null;
        }
    }
}
