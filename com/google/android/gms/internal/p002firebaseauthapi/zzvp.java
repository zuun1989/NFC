package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzalg;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzvp  reason: invalid package */
public final class zzvp extends zzalg<zzvp, zza> implements zzamp {
    /* access modifiers changed from: private */
    public static final zzvp zzc;
    private static volatile zzamw<zzvp> zzd;
    private int zze;
    /* access modifiers changed from: private */
    public int zzf;
    private zzvj zzg;
    private zzajw zzh;
    private zzajw zzi;

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzvp$zza */
    public static final class zza extends zzalg.zzb<zzvp, zza> implements zzamp {
        public final zza zza(zzvj zzvj) {
            zzg();
            zzvp.zza((zzvp) this.zza, zzvj);
            return this;
        }

        public final zza zzb(zzajw zzajw) {
            zzg();
            zzvp.zzb((zzvp) this.zza, zzajw);
            return this;
        }

        private zza() {
            super(zzvp.zzc);
        }

        public final zza zza(int i) {
            zzg();
            ((zzvp) this.zza).zzf = 0;
            return this;
        }

        public final zza zza(zzajw zzajw) {
            zzg();
            zzvp.zza((zzvp) this.zza, zzajw);
            return this;
        }
    }

    static {
        zzvp zzvp = new zzvp();
        zzc = zzvp;
        zzalg.zza(zzvp.class, zzvp);
    }

    private zzvp() {
        zzajw zzajw = zzajw.zza;
        this.zzh = zzajw;
        this.zzi = zzajw;
    }

    public static zza zzc() {
        return (zza) zzc.zzm();
    }

    public static zzvp zze() {
        return zzc;
    }

    public static zzamw<zzvp> zzh() {
        return (zzamw) zzc.zza(zzalg.zze.zzg, (Object) null, (Object) null);
    }

    public final int zza() {
        return this.zzf;
    }

    public final zzvj zzb() {
        zzvj zzvj = this.zzg;
        return zzvj == null ? zzvj.zze() : zzvj;
    }

    public final zzajw zzf() {
        return this.zzh;
    }

    public final zzajw zzg() {
        return this.zzi;
    }

    public static zzvp zza(zzajw zzajw, zzakv zzakv) throws zzalm {
        return (zzvp) zzalg.zza(zzc, zzajw, zzakv);
    }

    public static /* synthetic */ void zzb(zzvp zzvp, zzajw zzajw) {
        zzajw.getClass();
        zzvp.zzi = zzajw;
    }

    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzvr.zza[i - 1]) {
            case 1:
                return new zzvp();
            case 2:
                return new zza();
            case 3:
                return zzalg.zza((zzamn) zzc, "\u0000\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000\u0003\n\u0004\n", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi"});
            case 4:
                return zzc;
            case 5:
                zzamw<zzvp> zzamw = zzd;
                if (zzamw == null) {
                    synchronized (zzvp.class) {
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

    public static /* synthetic */ void zza(zzvp zzvp, zzvj zzvj) {
        zzvj.getClass();
        zzvp.zzg = zzvj;
        zzvp.zze |= 1;
    }

    public static /* synthetic */ void zza(zzvp zzvp, zzajw zzajw) {
        zzajw.getClass();
        zzvp.zzh = zzajw;
    }
}
