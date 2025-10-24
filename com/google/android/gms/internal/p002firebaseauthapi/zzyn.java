package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzalg;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzyn  reason: invalid package */
public final class zzyn extends zzalg<zzyn, zza> implements zzamp {
    /* access modifiers changed from: private */
    public static final zzyn zzc;
    private static volatile zzamw<zzyn> zzd;
    private int zze;
    private zzajw zzf = zzajw.zza;

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzyn$zza */
    public static final class zza extends zzalg.zzb<zzyn, zza> implements zzamp {
        public final zza zza(zzajw zzajw) {
            zzg();
            zzyn.zza((zzyn) this.zza, zzajw);
            return this;
        }

        private zza() {
            super(zzyn.zzc);
        }
    }

    static {
        zzyn zzyn = new zzyn();
        zzc = zzyn;
        zzalg.zza(zzyn.class, zzyn);
    }

    private zzyn() {
    }

    public static zza zzb() {
        return (zza) zzc.zzm();
    }

    public static zzamw<zzyn> zze() {
        return (zzamw) zzc.zza(zzalg.zze.zzg, (Object) null, (Object) null);
    }

    public final int zza() {
        return this.zze;
    }

    public final zzajw zzd() {
        return this.zzf;
    }

    public static zzyn zza(zzajw zzajw, zzakv zzakv) throws zzalm {
        return (zzyn) zzalg.zza(zzc, zzajw, zzakv);
    }

    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzyp.zza[i - 1]) {
            case 1:
                return new zzyn();
            case 2:
                return new zza();
            case 3:
                return zzalg.zza((zzamn) zzc, "\u0000\u0002\u0000\u0000\u0001\u0003\u0002\u0000\u0000\u0000\u0001\u000b\u0003\n", new Object[]{"zze", "zzf"});
            case 4:
                return zzc;
            case 5:
                zzamw<zzyn> zzamw = zzd;
                if (zzamw == null) {
                    synchronized (zzyn.class) {
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

    public static /* synthetic */ void zza(zzyn zzyn, zzajw zzajw) {
        zzajw.getClass();
        zzyn.zzf = zzajw;
    }
}
