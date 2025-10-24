package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzalg;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzwg  reason: invalid package */
public final class zzwg extends zzalg<zzwg, zza> implements zzamp {
    /* access modifiers changed from: private */
    public static final zzwg zzc;
    private static volatile zzamw<zzwg> zzd;
    /* access modifiers changed from: private */
    public int zze;
    /* access modifiers changed from: private */
    public int zzf;

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzwg$zza */
    public static final class zza extends zzalg.zzb<zzwg, zza> implements zzamp {
        public final zza zza(zzwb zzwb) {
            zzg();
            ((zzwg) this.zza).zze = zzwb.zza();
            return this;
        }

        private zza() {
            super(zzwg.zzc);
        }

        public final zza zza(int i) {
            zzg();
            ((zzwg) this.zza).zzf = i;
            return this;
        }
    }

    static {
        zzwg zzwg = new zzwg();
        zzc = zzwg;
        zzalg.zza(zzwg.class, zzwg);
    }

    private zzwg() {
    }

    public static zza zzc() {
        return (zza) zzc.zzm();
    }

    public static zzwg zze() {
        return zzc;
    }

    public final int zza() {
        return this.zzf;
    }

    public final zzwb zzb() {
        zzwb zza2 = zzwb.zza(this.zze);
        if (zza2 == null) {
            return zzwb.UNRECOGNIZED;
        }
        return zza2;
    }

    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzwi.zza[i - 1]) {
            case 1:
                return new zzwg();
            case 2:
                return new zza();
            case 3:
                return zzalg.zza((zzamn) zzc, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\f\u0002\u000b", new Object[]{"zze", "zzf"});
            case 4:
                return zzc;
            case 5:
                zzamw<zzwg> zzamw = zzd;
                if (zzamw == null) {
                    synchronized (zzwg.class) {
                        try {
                            zzamw = zzd;
                            if (zzamw == null) {
                                zzamw = new zzalg.zza<>(zzc);
                                zzd = zzamw;
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                }
                return zzamw;
            case 6:
                return (byte) 1;
            default:
                throw null;
        }
    }
}
