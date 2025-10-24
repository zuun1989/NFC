package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzalg;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzuy  reason: invalid package */
public final class zzuy extends zzalg<zzuy, zza> implements zzamp {
    /* access modifiers changed from: private */
    public static final zzuy zzc;
    private static volatile zzamw<zzuy> zzd;
    private int zze;
    private zzajw zzf = zzajw.zza;

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzuy$zza */
    public static final class zza extends zzalg.zzb<zzuy, zza> implements zzamp {
        public final zza zza(zzajw zzajw) {
            zzg();
            zzuy.zza((zzuy) this.zza, zzajw);
            return this;
        }

        private zza() {
            super(zzuy.zzc);
        }
    }

    static {
        zzuy zzuy = new zzuy();
        zzc = zzuy;
        zzalg.zza(zzuy.class, zzuy);
    }

    private zzuy() {
    }

    public static zza zzb() {
        return (zza) zzc.zzm();
    }

    public static zzamw<zzuy> zze() {
        return (zzamw) zzc.zza(zzalg.zze.zzg, (Object) null, (Object) null);
    }

    public final int zza() {
        return this.zze;
    }

    public final zzajw zzd() {
        return this.zzf;
    }

    public static zzuy zza(zzajw zzajw, zzakv zzakv) throws zzalm {
        return (zzuy) zzalg.zza(zzc, zzajw, zzakv);
    }

    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzux.zza[i - 1]) {
            case 1:
                return new zzuy();
            case 2:
                return new zza();
            case 3:
                return zzalg.zza((zzamn) zzc, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\n", new Object[]{"zze", "zzf"});
            case 4:
                return zzc;
            case 5:
                zzamw<zzuy> zzamw = zzd;
                if (zzamw == null) {
                    synchronized (zzuy.class) {
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

    public static /* synthetic */ void zza(zzuy zzuy, zzajw zzajw) {
        zzajw.getClass();
        zzuy.zzf = zzajw;
    }
}
