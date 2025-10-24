package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzalg;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zztl  reason: invalid package */
public final class zztl extends zzalg<zztl, zza> implements zzamp {
    /* access modifiers changed from: private */
    public static final zztl zzc;
    private static volatile zzamw<zztl> zzd;
    private int zze;
    private zztr zzf;
    private zzwd zzg;

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zztl$zza */
    public static final class zza extends zzalg.zzb<zztl, zza> implements zzamp {
        public final zza zza(zztr zztr) {
            zzg();
            zztl.zza((zztl) this.zza, zztr);
            return this;
        }

        private zza() {
            super(zztl.zzc);
        }

        public final zza zza(zzwd zzwd) {
            zzg();
            zztl.zza((zztl) this.zza, zzwd);
            return this;
        }
    }

    static {
        zztl zztl = new zztl();
        zzc = zztl;
        zzalg.zza(zztl.class, zztl);
    }

    private zztl() {
    }

    public static zza zza() {
        return (zza) zzc.zzm();
    }

    public final zztr zzc() {
        zztr zztr = this.zzf;
        if (zztr == null) {
            return zztr.zzd();
        }
        return zztr;
    }

    public final zzwd zzd() {
        zzwd zzwd = this.zzg;
        if (zzwd == null) {
            return zzwd.zze();
        }
        return zzwd;
    }

    public static zztl zza(zzajw zzajw, zzakv zzakv) throws zzalm {
        return (zztl) zzalg.zza(zzc, zzajw, zzakv);
    }

    public final Object zza(int i, Object obj, Object obj2) {
        switch (zztk.zza[i - 1]) {
            case 1:
                return new zztl();
            case 2:
                return new zza();
            case 3:
                return zzalg.zza((zzamn) zzc, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001", new Object[]{"zze", "zzf", "zzg"});
            case 4:
                return zzc;
            case 5:
                zzamw<zztl> zzamw = zzd;
                if (zzamw == null) {
                    synchronized (zztl.class) {
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

    public static /* synthetic */ void zza(zztl zztl, zztr zztr) {
        zztr.getClass();
        zztl.zzf = zztr;
        zztl.zze |= 1;
    }

    public static /* synthetic */ void zza(zztl zztl, zzwd zzwd) {
        zzwd.getClass();
        zztl.zzg = zzwd;
        zztl.zze |= 2;
    }
}
