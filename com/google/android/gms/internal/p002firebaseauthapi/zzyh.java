package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzalg;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzyh  reason: invalid package */
public final class zzyh extends zzalg<zzyh, zza> implements zzamp {
    /* access modifiers changed from: private */
    public static final zzyh zzc;
    private static volatile zzamw<zzyh> zzd;
    private int zze;
    private int zzf;
    private zzyk zzg;

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzyh$zza */
    public static final class zza extends zzalg.zzb<zzyh, zza> implements zzamp {
        public final zza zza(zzyk zzyk) {
            zzg();
            zzyh.zza((zzyh) this.zza, zzyk);
            return this;
        }

        private zza() {
            super(zzyh.zzc);
        }
    }

    static {
        zzyh zzyh = new zzyh();
        zzc = zzyh;
        zzalg.zza(zzyh.class, zzyh);
    }

    private zzyh() {
    }

    public static zza zzb() {
        return (zza) zzc.zzm();
    }

    public final int zza() {
        return this.zzf;
    }

    public final zzyk zzd() {
        zzyk zzyk = this.zzg;
        if (zzyk == null) {
            return zzyk.zzd();
        }
        return zzyk;
    }

    public static zzyh zza(zzajw zzajw, zzakv zzakv) throws zzalm {
        return (zzyh) zzalg.zza(zzc, zzajw, zzakv);
    }

    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzyj.zza[i - 1]) {
            case 1:
                return new zzyh();
            case 2:
                return new zza();
            case 3:
                return zzalg.zza((zzamn) zzc, "\u0000\u0002\u0000\u0001\u0001\u0003\u0002\u0000\u0000\u0000\u0001\u000b\u0003ဉ\u0000", new Object[]{"zze", "zzf", "zzg"});
            case 4:
                return zzc;
            case 5:
                zzamw<zzyh> zzamw = zzd;
                if (zzamw == null) {
                    synchronized (zzyh.class) {
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

    public static /* synthetic */ void zza(zzyh zzyh, zzyk zzyk) {
        zzyk.getClass();
        zzyh.zzg = zzyk;
        zzyh.zze |= 1;
    }
}
