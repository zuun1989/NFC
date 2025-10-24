package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzalg;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzti  reason: invalid package */
public final class zzti extends zzalg<zzti, zza> implements zzamp {
    /* access modifiers changed from: private */
    public static final zzti zzc;
    private static volatile zzamw<zzti> zzd;
    private int zze;
    private int zzf;
    private zzto zzg;
    private zzwa zzh;

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzti$zza */
    public static final class zza extends zzalg.zzb<zzti, zza> implements zzamp {
        public final zza zza(zzto zzto) {
            zzg();
            zzti.zza((zzti) this.zza, zzto);
            return this;
        }

        private zza() {
            super(zzti.zzc);
        }

        public final zza zza(zzwa zzwa) {
            zzg();
            zzti.zza((zzti) this.zza, zzwa);
            return this;
        }
    }

    static {
        zzti zzti = new zzti();
        zzc = zzti;
        zzalg.zza(zzti.class, zzti);
    }

    private zzti() {
    }

    public static zza zzb() {
        return (zza) zzc.zzm();
    }

    public static zzamw<zzti> zzf() {
        return (zzamw) zzc.zza(zzalg.zze.zzg, (Object) null, (Object) null);
    }

    public final int zza() {
        return this.zzf;
    }

    public final zzto zzd() {
        zzto zzto = this.zzg;
        if (zzto == null) {
            return zzto.zzd();
        }
        return zzto;
    }

    public final zzwa zze() {
        zzwa zzwa = this.zzh;
        if (zzwa == null) {
            return zzwa.zzd();
        }
        return zzwa;
    }

    public static zzti zza(zzajw zzajw, zzakv zzakv) throws zzalm {
        return (zzti) zzalg.zza(zzc, zzajw, zzakv);
    }

    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzth.zza[i - 1]) {
            case 1:
                return new zzti();
            case 2:
                return new zza();
            case 3:
                return zzalg.zza((zzamn) zzc, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000\u0003ဉ\u0001", new Object[]{"zze", "zzf", "zzg", "zzh"});
            case 4:
                return zzc;
            case 5:
                zzamw<zzti> zzamw = zzd;
                if (zzamw == null) {
                    synchronized (zzti.class) {
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

    public static /* synthetic */ void zza(zzti zzti, zzto zzto) {
        zzto.getClass();
        zzti.zzg = zzto;
        zzti.zze |= 1;
    }

    public static /* synthetic */ void zza(zzti zzti, zzwa zzwa) {
        zzwa.getClass();
        zzti.zzh = zzwa;
        zzti.zze |= 2;
    }
}
