package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzalg;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zztc  reason: invalid package */
public final class zztc extends zzalg<zztc, zza> implements zzamp {
    /* access modifiers changed from: private */
    public static final zztc zzc;
    private static volatile zzamw<zztc> zzd;
    private int zze;
    /* access modifiers changed from: private */
    public int zzf;
    private zztf zzg;

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zztc$zza */
    public static final class zza extends zzalg.zzb<zztc, zza> implements zzamp {
        public final zza zza(int i) {
            zzg();
            ((zztc) this.zza).zzf = i;
            return this;
        }

        private zza() {
            super(zztc.zzc);
        }

        public final zza zza(zztf zztf) {
            zzg();
            zztc.zza((zztc) this.zza, zztf);
            return this;
        }
    }

    static {
        zztc zztc = new zztc();
        zzc = zztc;
        zzalg.zza(zztc.class, zztc);
    }

    private zztc() {
    }

    public static zza zzb() {
        return (zza) zzc.zzm();
    }

    public final int zza() {
        return this.zzf;
    }

    public final zztf zzd() {
        zztf zztf = this.zzg;
        if (zztf == null) {
            return zztf.zzd();
        }
        return zztf;
    }

    public static zztc zza(zzajw zzajw, zzakv zzakv) throws zzalm {
        return (zztc) zzalg.zza(zzc, zzajw, zzakv);
    }

    public final Object zza(int i, Object obj, Object obj2) {
        switch (zztb.zza[i - 1]) {
            case 1:
                return new zztc();
            case 2:
                return new zza();
            case 3:
                return zzalg.zza((zzamn) zzc, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000", new Object[]{"zze", "zzf", "zzg"});
            case 4:
                return zzc;
            case 5:
                zzamw<zztc> zzamw = zzd;
                if (zzamw == null) {
                    synchronized (zztc.class) {
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

    public static /* synthetic */ void zza(zztc zztc, zztf zztf) {
        zztf.getClass();
        zztc.zzg = zztf;
        zztc.zze |= 1;
    }
}
