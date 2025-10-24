package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzalg;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zztf  reason: invalid package */
public final class zztf extends zzalg<zztf, zza> implements zzamp {
    /* access modifiers changed from: private */
    public static final zztf zzc;
    private static volatile zzamw<zztf> zzd;
    /* access modifiers changed from: private */
    public int zze;

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zztf$zza */
    public static final class zza extends zzalg.zzb<zztf, zza> implements zzamp {
        public final zza zza(int i) {
            zzg();
            ((zztf) this.zza).zze = i;
            return this;
        }

        private zza() {
            super(zztf.zzc);
        }
    }

    static {
        zztf zztf = new zztf();
        zzc = zztf;
        zzalg.zza(zztf.class, zztf);
    }

    private zztf() {
    }

    public static zza zzb() {
        return (zza) zzc.zzm();
    }

    public static zztf zzd() {
        return zzc;
    }

    public final int zza() {
        return this.zze;
    }

    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzte.zza[i - 1]) {
            case 1:
                return new zztf();
            case 2:
                return new zza();
            case 3:
                return zzalg.zza((zzamn) zzc, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u000b", new Object[]{"zze"});
            case 4:
                return zzc;
            case 5:
                zzamw<zztf> zzamw = zzd;
                if (zzamw == null) {
                    synchronized (zztf.class) {
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
