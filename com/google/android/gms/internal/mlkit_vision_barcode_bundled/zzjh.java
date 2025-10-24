package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

public final class zzjh extends zzeh implements zzfn {
    /* access modifiers changed from: private */
    public static final zzjh zzb;
    private int zzd;
    private String zze = "";
    private String zzf = "";

    static {
        zzjh zzjh = new zzjh();
        zzb = zzjh;
        zzeh.zzV(zzjh.class, zzjh);
    }

    private zzjh() {
    }

    public final Object zzg(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzeh.zzS(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001", new Object[]{"zzd", "zze", "zzf"});
        } else if (i2 == 3) {
            return new zzjh();
        } else {
            if (i2 == 4) {
                return new zzjg((zzhi) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
