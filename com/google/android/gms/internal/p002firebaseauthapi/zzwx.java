package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzalg;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzwx  reason: invalid package */
public final class zzwx extends zzalg<zzwx, zza> implements zzamp {
    /* access modifiers changed from: private */
    public static final zzwx zzc;
    private static volatile zzamw<zzwx> zzd;
    private int zze;
    /* access modifiers changed from: private */
    public int zzf;
    private zzwr zzg;
    private zzajw zzh = zzajw.zza;

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzwx$zza */
    public static final class zza extends zzalg.zzb<zzwx, zza> implements zzamp {
        public final zza zza(zzwr zzwr) {
            zzg();
            zzwx.zza((zzwx) this.zza, zzwr);
            return this;
        }

        private zza() {
            super(zzwx.zzc);
        }

        public final zza zza(zzajw zzajw) {
            zzg();
            zzwx.zza((zzwx) this.zza, zzajw);
            return this;
        }

        public final zza zza(int i) {
            zzg();
            ((zzwx) this.zza).zzf = 0;
            return this;
        }
    }

    static {
        zzwx zzwx = new zzwx();
        zzc = zzwx;
        zzalg.zza(zzwx.class, zzwx);
    }

    private zzwx() {
    }

    public static zza zzc() {
        return (zza) zzc.zzm();
    }

    public static zzwx zze() {
        return zzc;
    }

    public static zzamw<zzwx> zzg() {
        return (zzamw) zzc.zza(zzalg.zze.zzg, (Object) null, (Object) null);
    }

    public final int zza() {
        return this.zzf;
    }

    public final zzwr zzb() {
        zzwr zzwr = this.zzg;
        if (zzwr == null) {
            return zzwr.zzf();
        }
        return zzwr;
    }

    public final zzajw zzf() {
        return this.zzh;
    }

    public static zzwx zza(zzajw zzajw, zzakv zzakv) throws zzalm {
        return (zzwx) zzalg.zza(zzc, zzajw, zzakv);
    }

    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzww.zza[i - 1]) {
            case 1:
                return new zzwx();
            case 2:
                return new zza();
            case 3:
                return zzalg.zza((zzamn) zzc, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000\u0003\n", new Object[]{"zze", "zzf", "zzg", "zzh"});
            case 4:
                return zzc;
            case 5:
                zzamw<zzwx> zzamw = zzd;
                if (zzamw == null) {
                    synchronized (zzwx.class) {
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

    public static /* synthetic */ void zza(zzwx zzwx, zzwr zzwr) {
        zzwr.getClass();
        zzwx.zzg = zzwr;
        zzwx.zze |= 1;
    }

    public static /* synthetic */ void zza(zzwx zzwx, zzajw zzajw) {
        zzajw.getClass();
        zzwx.zzh = zzajw;
    }
}
