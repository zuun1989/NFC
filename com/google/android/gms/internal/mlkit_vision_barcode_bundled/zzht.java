package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

public final class zzht extends zzeh implements zzfn {
    /* access modifiers changed from: private */
    public static final zzht zzb;
    private int zzd;
    private String zze = "";
    private int zzf = 1;
    private boolean zzg;
    private int zzh;

    static {
        zzht zzht = new zzht();
        zzb = zzht;
        zzeh.zzV(zzht.class, zzht);
    }

    private zzht() {
    }

    public final Object zzg(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzeh.zzS(zzb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဈ\u0000\u0002᠌\u0001\u0003ဇ\u0002\u0004င\u0003", new Object[]{"zzd", "zze", "zzf", zzhs.zza, "zzg", "zzh"});
        } else if (i2 == 3) {
            return new zzht();
        } else {
            if (i2 == 4) {
                return new zzhr((zzhi) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
