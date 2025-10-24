package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzalg;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zztr  reason: invalid package */
public final class zztr extends zzalg<zztr, zza> implements zzamp {
    /* access modifiers changed from: private */
    public static final zztr zzc;
    private static volatile zzamw<zztr> zzd;
    private int zze;
    private zztu zzf;
    /* access modifiers changed from: private */
    public int zzg;

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zztr$zza */
    public static final class zza extends zzalg.zzb<zztr, zza> implements zzamp {
        public final zza zza(int i) {
            zzg();
            ((zztr) this.zza).zzg = i;
            return this;
        }

        private zza() {
            super(zztr.zzc);
        }

        public final zza zza(zztu zztu) {
            zzg();
            zztr.zza((zztr) this.zza, zztu);
            return this;
        }
    }

    static {
        zztr zztr = new zztr();
        zzc = zztr;
        zzalg.zza(zztr.class, zztr);
    }

    private zztr() {
    }

    public static zza zzb() {
        return (zza) zzc.zzm();
    }

    public static zztr zzd() {
        return zzc;
    }

    public final int zza() {
        return this.zzg;
    }

    public final zztu zze() {
        zztu zztu = this.zzf;
        if (zztu == null) {
            return zztu.zzd();
        }
        return zztu;
    }

    public final Object zza(int i, Object obj, Object obj2) {
        switch (zztq.zza[i - 1]) {
            case 1:
                return new zztr();
            case 2:
                return new zza();
            case 3:
                return zzalg.zza((zzamn) zzc, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002\u000b", new Object[]{"zze", "zzf", "zzg"});
            case 4:
                return zzc;
            case 5:
                zzamw<zztr> zzamw = zzd;
                if (zzamw == null) {
                    synchronized (zztr.class) {
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

    public static /* synthetic */ void zza(zztr zztr, zztu zztu) {
        zztu.getClass();
        zztr.zzf = zztu;
        zztr.zze |= 1;
    }
}
