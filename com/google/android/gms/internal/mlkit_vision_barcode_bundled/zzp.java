package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

public final class zzp extends zzeh implements zzfn {
    /* access modifiers changed from: private */
    public static final zzp zzb;
    private int zzd;
    private zzen zze = zzeh.zzO();
    private zzem zzf = zzeh.zzM();
    private boolean zzg = true;
    private String zzh = "";
    private String zzi = "";
    private zzjv zzj;
    private byte zzk = 2;

    static {
        zzp zzp = new zzp();
        zzb = zzp;
        zzeh.zzV(zzp.class, zzp);
    }

    private zzp() {
    }

    public final Object zzg(int i, Object obj, Object obj2) {
        byte b;
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzk);
        }
        if (i2 == 2) {
            return zzeh.zzS(zzb, "\u0001\u0006\u0000\u0001\u0001\u000f\u0006\u0000\u0002\u0001\u0001\u0016\u0002\u0013\u0003ဇ\u0000\u0004ဈ\u0001\u0005ဈ\u0002\u000fᐉ\u0003", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj"});
        } else if (i2 == 3) {
            return new zzp();
        } else {
            if (i2 == 4) {
                return new zzo((zzn) null);
            }
            if (i2 == 5) {
                return zzb;
            }
            if (obj == null) {
                b = 0;
            } else {
                b = 1;
            }
            this.zzk = b;
            return null;
        }
    }
}
