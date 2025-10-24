package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzalg;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzsz  reason: invalid package */
public final class zzsz extends zzalg<zzsz, zza> implements zzamp {
    /* access modifiers changed from: private */
    public static final zzsz zzc;
    private static volatile zzamw<zzsz> zzd;
    private int zze;
    private int zzf;
    private zzajw zzg = zzajw.zza;
    private zztf zzh;

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzsz$zza */
    public static final class zza extends zzalg.zzb<zzsz, zza> implements zzamp {
        public final zza zza(zzajw zzajw) {
            zzg();
            zzsz.zza((zzsz) this.zza, zzajw);
            return this;
        }

        private zza() {
            super(zzsz.zzc);
        }

        public final zza zza(zztf zztf) {
            zzg();
            zzsz.zza((zzsz) this.zza, zztf);
            return this;
        }
    }

    static {
        zzsz zzsz = new zzsz();
        zzc = zzsz;
        zzalg.zza(zzsz.class, zzsz);
    }

    private zzsz() {
    }

    public static zza zzb() {
        return (zza) zzc.zzm();
    }

    public static zzamw<zzsz> zzf() {
        return (zzamw) zzc.zza(zzalg.zze.zzg, (Object) null, (Object) null);
    }

    public final int zza() {
        return this.zzf;
    }

    public final zztf zzd() {
        zztf zztf = this.zzh;
        if (zztf == null) {
            return zztf.zzd();
        }
        return zztf;
    }

    public final zzajw zze() {
        return this.zzg;
    }

    public static zzsz zza(zzajw zzajw, zzakv zzakv) throws zzalm {
        return (zzsz) zzalg.zza(zzc, zzajw, zzakv);
    }

    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzsy.zza[i - 1]) {
            case 1:
                return new zzsz();
            case 2:
                return new zza();
            case 3:
                return zzalg.zza((zzamn) zzc, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\n\u0003ဉ\u0000", new Object[]{"zze", "zzf", "zzg", "zzh"});
            case 4:
                return zzc;
            case 5:
                zzamw<zzsz> zzamw = zzd;
                if (zzamw == null) {
                    synchronized (zzsz.class) {
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

    public static /* synthetic */ void zza(zzsz zzsz, zzajw zzajw) {
        zzajw.getClass();
        zzsz.zzg = zzajw;
    }

    public static /* synthetic */ void zza(zzsz zzsz, zztf zztf) {
        zztf.getClass();
        zzsz.zzh = zztf;
        zzsz.zze |= 1;
    }
}
