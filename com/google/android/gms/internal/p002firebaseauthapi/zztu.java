package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzalg;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zztu  reason: invalid package */
public final class zztu extends zzalg<zztu, zza> implements zzamp {
    /* access modifiers changed from: private */
    public static final zztu zzc;
    private static volatile zzamw<zztu> zzd;
    /* access modifiers changed from: private */
    public int zze;

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zztu$zza */
    public static final class zza extends zzalg.zzb<zztu, zza> implements zzamp {
        public final zza zza(int i) {
            zzg();
            ((zztu) this.zza).zze = i;
            return this;
        }

        private zza() {
            super(zztu.zzc);
        }
    }

    static {
        zztu zztu = new zztu();
        zzc = zztu;
        zzalg.zza(zztu.class, zztu);
    }

    private zztu() {
    }

    public static zza zzb() {
        return (zza) zzc.zzm();
    }

    public static zztu zzd() {
        return zzc;
    }

    public final int zza() {
        return this.zze;
    }

    public final Object zza(int i, Object obj, Object obj2) {
        switch (zztt.zza[i - 1]) {
            case 1:
                return new zztu();
            case 2:
                return new zza();
            case 3:
                return zzalg.zza((zzamn) zzc, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u000b", new Object[]{"zze"});
            case 4:
                return zzc;
            case 5:
                zzamw<zztu> zzamw = zzd;
                if (zzamw == null) {
                    synchronized (zztu.class) {
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
