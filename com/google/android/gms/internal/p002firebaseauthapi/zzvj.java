package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzalg;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzvj  reason: invalid package */
public final class zzvj extends zzalg<zzvj, zza> implements zzamp {
    /* access modifiers changed from: private */
    public static final zzvj zzc;
    private static volatile zzamw<zzvj> zzd;
    private int zze;
    private zzvs zzf;
    private zzvd zzg;
    /* access modifiers changed from: private */
    public int zzh;

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzvj$zza */
    public static final class zza extends zzalg.zzb<zzvj, zza> implements zzamp {
        public final zza zza(zzvd zzvd) {
            zzg();
            zzvj.zza((zzvj) this.zza, zzvd);
            return this;
        }

        private zza() {
            super(zzvj.zzc);
        }

        public final zza zza(zzve zzve) {
            zzg();
            ((zzvj) this.zza).zzh = zzve.zza();
            return this;
        }

        public final zza zza(zzvs zzvs) {
            zzg();
            zzvj.zza((zzvj) this.zza, zzvs);
            return this;
        }
    }

    static {
        zzvj zzvj = new zzvj();
        zzc = zzvj;
        zzalg.zza(zzvj.class, zzvj);
    }

    private zzvj() {
    }

    public static zza zzc() {
        return (zza) zzc.zzm();
    }

    public static zzvj zze() {
        return zzc;
    }

    public final zzve zza() {
        zzve zza2 = zzve.zza(this.zzh);
        return zza2 == null ? zzve.UNRECOGNIZED : zza2;
    }

    public final zzvd zzb() {
        zzvd zzvd = this.zzg;
        if (zzvd == null) {
            return zzvd.zzc();
        }
        return zzvd;
    }

    public final zzvs zzf() {
        zzvs zzvs = this.zzf;
        if (zzvs == null) {
            return zzvs.zzc();
        }
        return zzvs;
    }

    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzvl.zza[i - 1]) {
            case 1:
                return new zzvj();
            case 2:
                return new zza();
            case 3:
                return zzalg.zza((zzamn) zzc, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003\f", new Object[]{"zze", "zzf", "zzg", "zzh"});
            case 4:
                return zzc;
            case 5:
                zzamw<zzvj> zzamw = zzd;
                if (zzamw == null) {
                    synchronized (zzvj.class) {
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

    public static /* synthetic */ void zza(zzvj zzvj, zzvd zzvd) {
        zzvd.getClass();
        zzvj.zzg = zzvd;
        zzvj.zze |= 2;
    }

    public static /* synthetic */ void zza(zzvj zzvj, zzvs zzvs) {
        zzvs.getClass();
        zzvj.zzf = zzvs;
        zzvj.zze |= 1;
    }
}
