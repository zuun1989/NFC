package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzalg;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzwr  reason: invalid package */
public final class zzwr extends zzalg<zzwr, zza> implements zzamp {
    /* access modifiers changed from: private */
    public static final zzwr zzc;
    private static volatile zzamw<zzwr> zzd;
    /* access modifiers changed from: private */
    public int zze;
    /* access modifiers changed from: private */
    public int zzf;
    /* access modifiers changed from: private */
    public int zzg;

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzwr$zza */
    public static final class zza extends zzalg.zzb<zzwr, zza> implements zzamp {
        public final zza zza(zzwj zzwj) {
            zzg();
            ((zzwr) this.zza).zzg = zzwj.zza();
            return this;
        }

        private zza() {
            super(zzwr.zzc);
        }

        public final zza zza(zzwm zzwm) {
            zzg();
            ((zzwr) this.zza).zzf = zzwm.zza();
            return this;
        }

        public final zza zza(zzwl zzwl) {
            zzg();
            ((zzwr) this.zza).zze = zzwl.zza();
            return this;
        }
    }

    static {
        zzwr zzwr = new zzwr();
        zzc = zzwr;
        zzalg.zza(zzwr.class, zzwr);
    }

    private zzwr() {
    }

    public static zza zzd() {
        return (zza) zzc.zzm();
    }

    public static zzwr zzf() {
        return zzc;
    }

    public final zzwj zza() {
        zzwj zza2 = zzwj.zza(this.zzg);
        return zza2 == null ? zzwj.UNRECOGNIZED : zza2;
    }

    public final zzwm zzb() {
        zzwm zza2 = zzwm.zza(this.zzf);
        if (zza2 == null) {
            return zzwm.UNRECOGNIZED;
        }
        return zza2;
    }

    public final zzwl zzc() {
        zzwl zza2 = zzwl.zza(this.zze);
        if (zza2 == null) {
            return zzwl.UNRECOGNIZED;
        }
        return zza2;
    }

    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzwq.zza[i - 1]) {
            case 1:
                return new zzwr();
            case 2:
                return new zza();
            case 3:
                return zzalg.zza((zzamn) zzc, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\f\u0002\f\u0003\f", new Object[]{"zze", "zzf", "zzg"});
            case 4:
                return zzc;
            case 5:
                zzamw<zzwr> zzamw = zzd;
                if (zzamw == null) {
                    synchronized (zzwr.class) {
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
