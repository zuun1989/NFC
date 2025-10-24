package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzalg;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzug  reason: invalid package */
public final class zzug extends zzalg<zzug, zza> implements zzamp {
    /* access modifiers changed from: private */
    public static final zzug zzc;
    private static volatile zzamw<zzug> zzd;
    private int zze;
    private zzajw zzf = zzajw.zza;

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzug$zza */
    public static final class zza extends zzalg.zzb<zzug, zza> implements zzamp {
        public final zza zza(zzajw zzajw) {
            zzg();
            zzug.zza((zzug) this.zza, zzajw);
            return this;
        }

        private zza() {
            super(zzug.zzc);
        }
    }

    static {
        zzug zzug = new zzug();
        zzc = zzug;
        zzalg.zza(zzug.class, zzug);
    }

    private zzug() {
    }

    public static zza zzb() {
        return (zza) zzc.zzm();
    }

    public static zzamw<zzug> zze() {
        return (zzamw) zzc.zza(zzalg.zze.zzg, (Object) null, (Object) null);
    }

    public final int zza() {
        return this.zze;
    }

    public final zzajw zzd() {
        return this.zzf;
    }

    public static zzug zza(zzajw zzajw, zzakv zzakv) throws zzalm {
        return (zzug) zzalg.zza(zzc, zzajw, zzakv);
    }

    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzuf.zza[i - 1]) {
            case 1:
                return new zzug();
            case 2:
                return new zza();
            case 3:
                return zzalg.zza((zzamn) zzc, "\u0000\u0002\u0000\u0000\u0001\u0003\u0002\u0000\u0000\u0000\u0001\u000b\u0003\n", new Object[]{"zze", "zzf"});
            case 4:
                return zzc;
            case 5:
                zzamw<zzug> zzamw = zzd;
                if (zzamw == null) {
                    synchronized (zzug.class) {
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

    public static /* synthetic */ void zza(zzug zzug, zzajw zzajw) {
        zzajw.getClass();
        zzug.zzf = zzajw;
    }
}
