package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzalg;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzwa  reason: invalid package */
public final class zzwa extends zzalg<zzwa, zza> implements zzamp {
    /* access modifiers changed from: private */
    public static final zzwa zzc;
    private static volatile zzamw<zzwa> zzd;
    private int zze;
    private int zzf;
    private zzwg zzg;
    private zzajw zzh = zzajw.zza;

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzwa$zza */
    public static final class zza extends zzalg.zzb<zzwa, zza> implements zzamp {
        public final zza zza(zzajw zzajw) {
            zzg();
            zzwa.zza((zzwa) this.zza, zzajw);
            return this;
        }

        private zza() {
            super(zzwa.zzc);
        }

        public final zza zza(zzwg zzwg) {
            zzg();
            zzwa.zza((zzwa) this.zza, zzwg);
            return this;
        }
    }

    static {
        zzwa zzwa = new zzwa();
        zzc = zzwa;
        zzalg.zza(zzwa.class, zzwa);
    }

    private zzwa() {
    }

    public static zza zzb() {
        return (zza) zzc.zzm();
    }

    public static zzwa zzd() {
        return zzc;
    }

    public static zzamw<zzwa> zzg() {
        return (zzamw) zzc.zza(zzalg.zze.zzg, (Object) null, (Object) null);
    }

    public final int zza() {
        return this.zzf;
    }

    public final zzwg zze() {
        zzwg zzwg = this.zzg;
        if (zzwg == null) {
            return zzwg.zze();
        }
        return zzwg;
    }

    public final zzajw zzf() {
        return this.zzh;
    }

    public static zzwa zza(zzajw zzajw, zzakv zzakv) throws zzalm {
        return (zzwa) zzalg.zza(zzc, zzajw, zzakv);
    }

    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzwc.zza[i - 1]) {
            case 1:
                return new zzwa();
            case 2:
                return new zza();
            case 3:
                return zzalg.zza((zzamn) zzc, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000\u0003\n", new Object[]{"zze", "zzf", "zzg", "zzh"});
            case 4:
                return zzc;
            case 5:
                zzamw<zzwa> zzamw = zzd;
                if (zzamw == null) {
                    synchronized (zzwa.class) {
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

    public static /* synthetic */ void zza(zzwa zzwa, zzajw zzajw) {
        zzajw.getClass();
        zzwa.zzh = zzajw;
    }

    public static /* synthetic */ void zza(zzwa zzwa, zzwg zzwg) {
        zzwg.getClass();
        zzwa.zzg = zzwg;
        zzwa.zze |= 1;
    }
}
