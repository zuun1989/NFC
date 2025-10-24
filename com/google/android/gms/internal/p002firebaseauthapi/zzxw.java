package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzalg;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzxw  reason: invalid package */
public final class zzxw extends zzalg<zzxw, zza> implements zzamp {
    /* access modifiers changed from: private */
    public static final zzxw zzc;
    private static volatile zzamw<zzxw> zzd;
    private int zze;
    private int zzf;
    private zzxz zzg;

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzxw$zza */
    public static final class zza extends zzalg.zzb<zzxw, zza> implements zzamp {
        public final zza zza(zzxz zzxz) {
            zzg();
            zzxw.zza((zzxw) this.zza, zzxz);
            return this;
        }

        private zza() {
            super(zzxw.zzc);
        }
    }

    static {
        zzxw zzxw = new zzxw();
        zzc = zzxw;
        zzalg.zza(zzxw.class, zzxw);
    }

    private zzxw() {
    }

    public static zza zzb() {
        return (zza) zzc.zzm();
    }

    public static zzamw<zzxw> zze() {
        return (zzamw) zzc.zza(zzalg.zze.zzg, (Object) null, (Object) null);
    }

    public final int zza() {
        return this.zzf;
    }

    public final zzxz zzd() {
        zzxz zzxz = this.zzg;
        if (zzxz == null) {
            return zzxz.zzd();
        }
        return zzxz;
    }

    public static zzxw zza(zzajw zzajw, zzakv zzakv) throws zzalm {
        return (zzxw) zzalg.zza(zzc, zzajw, zzakv);
    }

    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzxv.zza[i - 1]) {
            case 1:
                return new zzxw();
            case 2:
                return new zza();
            case 3:
                return zzalg.zza((zzamn) zzc, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000", new Object[]{"zze", "zzf", "zzg"});
            case 4:
                return zzc;
            case 5:
                zzamw<zzxw> zzamw = zzd;
                if (zzamw == null) {
                    synchronized (zzxw.class) {
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

    public static /* synthetic */ void zza(zzxw zzxw, zzxz zzxz) {
        zzxz.getClass();
        zzxw.zzg = zzxz;
        zzxw.zze |= 1;
    }
}
