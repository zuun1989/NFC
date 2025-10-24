package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

public final class zzjv extends zzed implements zzfn {
    /* access modifiers changed from: private */
    public static final zzjv zzd;
    private byte zze = 2;

    static {
        zzjv zzjv = new zzjv();
        zzd = zzjv;
        zzeh.zzV(zzjv.class, zzjv);
    }

    private zzjv() {
    }

    public static zzjv zzf() {
        return zzd;
    }

    public final Object zzg(int i, Object obj, Object obj2) {
        byte b;
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zze);
        }
        if (i2 == 2) {
            return zzeh.zzS(zzd, "\u0003\u0000", (Object[]) null);
        }
        if (i2 == 3) {
            return new zzjv();
        }
        if (i2 == 4) {
            return new zzju((zzjt) null);
        }
        if (i2 == 5) {
            return zzd;
        }
        if (obj == null) {
            b = 0;
        } else {
            b = 1;
        }
        this.zze = b;
        return null;
    }
}
