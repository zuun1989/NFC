package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzalg;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzwd  reason: invalid package */
public final class zzwd extends zzalg<zzwd, zza> implements zzamp {
    /* access modifiers changed from: private */
    public static final zzwd zzc;
    private static volatile zzamw<zzwd> zzd;
    private int zze;
    private zzwg zzf;
    /* access modifiers changed from: private */
    public int zzg;
    private int zzh;

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzwd$zza */
    public static final class zza extends zzalg.zzb<zzwd, zza> implements zzamp {
        public final zza zza(int i) {
            zzg();
            ((zzwd) this.zza).zzg = i;
            return this;
        }

        private zza() {
            super(zzwd.zzc);
        }

        public final zza zza(zzwg zzwg) {
            zzg();
            zzwd.zza((zzwd) this.zza, zzwg);
            return this;
        }
    }

    static {
        zzwd zzwd = new zzwd();
        zzc = zzwd;
        zzalg.zza(zzwd.class, zzwd);
    }

    private zzwd() {
    }

    public static zza zzc() {
        return (zza) zzc.zzm();
    }

    public static zzwd zze() {
        return zzc;
    }

    public final int zza() {
        return this.zzg;
    }

    public final int zzb() {
        return this.zzh;
    }

    public final zzwg zzf() {
        zzwg zzwg = this.zzf;
        if (zzwg == null) {
            return zzwg.zze();
        }
        return zzwg;
    }

    public static zzwd zza(zzajw zzajw, zzakv zzakv) throws zzalm {
        return (zzwd) zzalg.zza(zzc, zzajw, zzakv);
    }

    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzwf.zza[i - 1]) {
            case 1:
                return new zzwd();
            case 2:
                return new zza();
            case 3:
                return zzalg.zza((zzamn) zzc, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002\u000b\u0003\u000b", new Object[]{"zze", "zzf", "zzg", "zzh"});
            case 4:
                return zzc;
            case 5:
                zzamw<zzwd> zzamw = zzd;
                if (zzamw == null) {
                    synchronized (zzwd.class) {
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

    public static /* synthetic */ void zza(zzwd zzwd, zzwg zzwg) {
        zzwg.getClass();
        zzwd.zzf = zzwg;
        zzwd.zze |= 1;
    }
}
