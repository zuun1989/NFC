package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzalg;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzvs  reason: invalid package */
public final class zzvs extends zzalg<zzvs, zza> implements zzamp {
    /* access modifiers changed from: private */
    public static final zzvs zzc;
    private static volatile zzamw<zzvs> zzd;
    /* access modifiers changed from: private */
    public int zze;
    /* access modifiers changed from: private */
    public int zzf;
    private zzajw zzg = zzajw.zza;

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzvs$zza */
    public static final class zza extends zzalg.zzb<zzvs, zza> implements zzamp {
        public final zza zza(zzvv zzvv) {
            zzg();
            ((zzvs) this.zza).zze = zzvv.zza();
            return this;
        }

        private zza() {
            super(zzvs.zzc);
        }

        public final zza zza(zzwb zzwb) {
            zzg();
            ((zzvs) this.zza).zzf = zzwb.zza();
            return this;
        }

        public final zza zza(zzajw zzajw) {
            zzg();
            zzvs.zza((zzvs) this.zza, zzajw);
            return this;
        }
    }

    static {
        zzvs zzvs = new zzvs();
        zzc = zzvs;
        zzalg.zza(zzvs.class, zzvs);
    }

    private zzvs() {
    }

    public static zza zza() {
        return (zza) zzc.zzm();
    }

    public static zzvs zzc() {
        return zzc;
    }

    public final zzvv zzd() {
        zzvv zza2 = zzvv.zza(this.zze);
        if (zza2 == null) {
            return zzvv.UNRECOGNIZED;
        }
        return zza2;
    }

    public final zzwb zze() {
        zzwb zza2 = zzwb.zza(this.zzf);
        if (zza2 == null) {
            return zzwb.UNRECOGNIZED;
        }
        return zza2;
    }

    public final zzajw zzf() {
        return this.zzg;
    }

    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzvu.zza[i - 1]) {
            case 1:
                return new zzvs();
            case 2:
                return new zza();
            case 3:
                return zzalg.zza((zzamn) zzc, "\u0000\u0003\u0000\u0000\u0001\u000b\u0003\u0000\u0000\u0000\u0001\f\u0002\f\u000b\n", new Object[]{"zze", "zzf", "zzg"});
            case 4:
                return zzc;
            case 5:
                zzamw<zzvs> zzamw = zzd;
                if (zzamw == null) {
                    synchronized (zzvs.class) {
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

    public static /* synthetic */ void zza(zzvs zzvs, zzajw zzajw) {
        zzajw.getClass();
        zzvs.zzg = zzajw;
    }
}
