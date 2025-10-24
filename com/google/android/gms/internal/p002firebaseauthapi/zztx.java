package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzalg;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zztx  reason: invalid package */
public final class zztx extends zzalg<zztx, zza> implements zzamp {
    /* access modifiers changed from: private */
    public static final zztx zzc;
    private static volatile zzamw<zztx> zzd;
    private int zze;
    private int zzf;
    private zzud zzg;
    private zzajw zzh = zzajw.zza;

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zztx$zza */
    public static final class zza extends zzalg.zzb<zztx, zza> implements zzamp {
        public final zza zza(zzajw zzajw) {
            zzg();
            zztx.zza((zztx) this.zza, zzajw);
            return this;
        }

        private zza() {
            super(zztx.zzc);
        }

        public final zza zza(zzud zzud) {
            zzg();
            zztx.zza((zztx) this.zza, zzud);
            return this;
        }
    }

    static {
        zztx zztx = new zztx();
        zzc = zztx;
        zzalg.zza(zztx.class, zztx);
    }

    private zztx() {
    }

    public static zza zzb() {
        return (zza) zzc.zzm();
    }

    public static zzamw<zztx> zzf() {
        return (zzamw) zzc.zza(zzalg.zze.zzg, (Object) null, (Object) null);
    }

    public final int zza() {
        return this.zzf;
    }

    public final zzud zzd() {
        zzud zzud = this.zzg;
        if (zzud == null) {
            return zzud.zzd();
        }
        return zzud;
    }

    public final zzajw zze() {
        return this.zzh;
    }

    public static zztx zza(zzajw zzajw, zzakv zzakv) throws zzalm {
        return (zztx) zzalg.zza(zzc, zzajw, zzakv);
    }

    public final Object zza(int i, Object obj, Object obj2) {
        switch (zztw.zza[i - 1]) {
            case 1:
                return new zztx();
            case 2:
                return new zza();
            case 3:
                return zzalg.zza((zzamn) zzc, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000\u0003\n", new Object[]{"zze", "zzf", "zzg", "zzh"});
            case 4:
                return zzc;
            case 5:
                zzamw<zztx> zzamw = zzd;
                if (zzamw == null) {
                    synchronized (zztx.class) {
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

    public static /* synthetic */ void zza(zztx zztx, zzajw zzajw) {
        zzajw.getClass();
        zztx.zzh = zzajw;
    }

    public static /* synthetic */ void zza(zztx zztx, zzud zzud) {
        zzud.getClass();
        zztx.zzg = zzud;
        zztx.zze |= 1;
    }
}
