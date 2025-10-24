package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzalg;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzud  reason: invalid package */
public final class zzud extends zzalg<zzud, zza> implements zzamp {
    /* access modifiers changed from: private */
    public static final zzud zzc;
    private static volatile zzamw<zzud> zzd;
    /* access modifiers changed from: private */
    public int zze;

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzud$zza */
    public static final class zza extends zzalg.zzb<zzud, zza> implements zzamp {
        public final zza zza(int i) {
            zzg();
            ((zzud) this.zza).zze = i;
            return this;
        }

        private zza() {
            super(zzud.zzc);
        }
    }

    static {
        zzud zzud = new zzud();
        zzc = zzud;
        zzalg.zza(zzud.class, zzud);
    }

    private zzud() {
    }

    public static zza zzb() {
        return (zza) zzc.zzm();
    }

    public static zzud zzd() {
        return zzc;
    }

    public final int zza() {
        return this.zze;
    }

    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzuc.zza[i - 1]) {
            case 1:
                return new zzud();
            case 2:
                return new zza();
            case 3:
                return zzalg.zza((zzamn) zzc, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u000b", new Object[]{"zze"});
            case 4:
                return zzc;
            case 5:
                zzamw<zzud> zzamw = zzd;
                if (zzamw == null) {
                    synchronized (zzud.class) {
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
