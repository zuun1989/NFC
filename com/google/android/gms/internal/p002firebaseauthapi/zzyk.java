package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzalg;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzyk  reason: invalid package */
public final class zzyk extends zzalg<zzyk, zza> implements zzamp {
    /* access modifiers changed from: private */
    public static final zzyk zzc;
    private static volatile zzamw<zzyk> zzd;
    /* access modifiers changed from: private */
    public int zze;

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzyk$zza */
    public static final class zza extends zzalg.zzb<zzyk, zza> implements zzamp {
        public final zza zza(int i) {
            zzg();
            ((zzyk) this.zza).zze = i;
            return this;
        }

        private zza() {
            super(zzyk.zzc);
        }
    }

    static {
        zzyk zzyk = new zzyk();
        zzc = zzyk;
        zzalg.zza(zzyk.class, zzyk);
    }

    private zzyk() {
    }

    public static zza zzb() {
        return (zza) zzc.zzm();
    }

    public static zzyk zzd() {
        return zzc;
    }

    public final int zza() {
        return this.zze;
    }

    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzym.zza[i - 1]) {
            case 1:
                return new zzyk();
            case 2:
                return new zza();
            case 3:
                return zzalg.zza((zzamn) zzc, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u000b", new Object[]{"zze"});
            case 4:
                return zzc;
            case 5:
                zzamw<zzyk> zzamw = zzd;
                if (zzamw == null) {
                    synchronized (zzyk.class) {
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
