package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzalg;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzus  reason: invalid package */
public final class zzus extends zzalg<zzus, zza> implements zzamp {
    /* access modifiers changed from: private */
    public static final zzus zzc;
    private static volatile zzamw<zzus> zzd;
    private int zze;
    private zzajw zzf = zzajw.zza;

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzus$zza */
    public static final class zza extends zzalg.zzb<zzus, zza> implements zzamp {
        public final zza zza(zzajw zzajw) {
            zzg();
            zzus.zza((zzus) this.zza, zzajw);
            return this;
        }

        private zza() {
            super(zzus.zzc);
        }
    }

    static {
        zzus zzus = new zzus();
        zzc = zzus;
        zzalg.zza(zzus.class, zzus);
    }

    private zzus() {
    }

    public static zza zzb() {
        return (zza) zzc.zzm();
    }

    public static zzamw<zzus> zze() {
        return (zzamw) zzc.zza(zzalg.zze.zzg, (Object) null, (Object) null);
    }

    public final int zza() {
        return this.zze;
    }

    public final zzajw zzd() {
        return this.zzf;
    }

    public static zzus zza(zzajw zzajw, zzakv zzakv) throws zzalm {
        return (zzus) zzalg.zza(zzc, zzajw, zzakv);
    }

    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzur.zza[i - 1]) {
            case 1:
                return new zzus();
            case 2:
                return new zza();
            case 3:
                return zzalg.zza((zzamn) zzc, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\n", new Object[]{"zze", "zzf"});
            case 4:
                return zzc;
            case 5:
                zzamw<zzus> zzamw = zzd;
                if (zzamw == null) {
                    synchronized (zzus.class) {
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

    public static /* synthetic */ void zza(zzus zzus, zzajw zzajw) {
        zzajw.getClass();
        zzus.zzf = zzajw;
    }
}
