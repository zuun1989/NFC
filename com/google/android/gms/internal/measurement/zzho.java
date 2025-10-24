package com.google.android.gms.internal.measurement;

import java.util.List;

public final class zzho extends zzmf implements zznn {
    /* access modifiers changed from: private */
    public static final zzho zzd;
    private zzmo zzb = zzmf.zzcv();

    static {
        zzho zzho = new zzho();
        zzd = zzho;
        zzmf.zzcp(zzho.class, zzho);
    }

    private zzho() {
    }

    public static zzhh zzb() {
        return (zzhh) zzd.zzck();
    }

    public static zzho zzc() {
        return zzd;
    }

    public final List zza() {
        return this.zzb;
    }

    public final /* synthetic */ void zzd(Iterable iterable) {
        zzmo zzmo = this.zzb;
        if (!zzmo.zza()) {
            this.zzb = zzmf.zzcw(zzmo);
        }
        zzks.zzce(iterable, this.zzb);
    }

    public final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzmf.zzcq(zzd, "\u0004\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzb", zzhl.class});
        } else if (i2 == 3) {
            return new zzho();
        } else {
            if (i2 == 4) {
                return new zzhh((byte[]) null);
            }
            if (i2 == 5) {
                return zzd;
            }
            throw null;
        }
    }
}
