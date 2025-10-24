package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

public final class zzil extends zzeh implements zzfn {
    /* access modifiers changed from: private */
    public static final zzil zzb;
    private int zzd;
    private boolean zze;
    private boolean zzf;

    static {
        zzil zzil = new zzil();
        zzb = zzil;
        zzeh.zzV(zzil.class, zzil);
    }

    private zzil() {
    }

    public final Object zzg(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzeh.zzS(zzb, "\u0001\u0002\u0000\u0001\u0005\u0006\u0002\u0000\u0000\u0000\u0005ဇ\u0000\u0006ဇ\u0001", new Object[]{"zzd", "zze", "zzf"});
        } else if (i2 == 3) {
            return new zzil();
        } else {
            if (i2 == 4) {
                return new zzik((zzhi) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
