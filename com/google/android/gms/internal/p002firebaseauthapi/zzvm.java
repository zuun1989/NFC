package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzalg;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzvm  reason: invalid package */
public final class zzvm extends zzalg<zzvm, zza> implements zzamp {
    /* access modifiers changed from: private */
    public static final zzvm zzc;
    private static volatile zzamw<zzvm> zzd;
    private int zze;
    /* access modifiers changed from: private */
    public int zzf;
    private zzvp zzg;
    private zzajw zzh = zzajw.zza;

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzvm$zza */
    public static final class zza extends zzalg.zzb<zzvm, zza> implements zzamp {
        public final zza zza(zzajw zzajw) {
            zzg();
            zzvm.zza((zzvm) this.zza, zzajw);
            return this;
        }

        private zza() {
            super(zzvm.zzc);
        }

        public final zza zza(zzvp zzvp) {
            zzg();
            zzvm.zza((zzvm) this.zza, zzvp);
            return this;
        }

        public final zza zza(int i) {
            zzg();
            ((zzvm) this.zza).zzf = 0;
            return this;
        }
    }

    static {
        zzvm zzvm = new zzvm();
        zzc = zzvm;
        zzalg.zza(zzvm.class, zzvm);
    }

    private zzvm() {
    }

    public static zza zzb() {
        return (zza) zzc.zzm();
    }

    public static zzamw<zzvm> zzf() {
        return (zzamw) zzc.zza(zzalg.zze.zzg, (Object) null, (Object) null);
    }

    public final int zza() {
        return this.zzf;
    }

    public final zzvp zzd() {
        zzvp zzvp = this.zzg;
        if (zzvp == null) {
            return zzvp.zze();
        }
        return zzvp;
    }

    public final zzajw zze() {
        return this.zzh;
    }

    public static zzvm zza(zzajw zzajw, zzakv zzakv) throws zzalm {
        return (zzvm) zzalg.zza(zzc, zzajw, zzakv);
    }

    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzvo.zza[i - 1]) {
            case 1:
                return new zzvm();
            case 2:
                return new zza();
            case 3:
                return zzalg.zza((zzamn) zzc, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000\u0003\n", new Object[]{"zze", "zzf", "zzg", "zzh"});
            case 4:
                return zzc;
            case 5:
                zzamw<zzvm> zzamw = zzd;
                if (zzamw == null) {
                    synchronized (zzvm.class) {
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

    public static /* synthetic */ void zza(zzvm zzvm, zzajw zzajw) {
        zzajw.getClass();
        zzvm.zzh = zzajw;
    }

    public static /* synthetic */ void zza(zzvm zzvm, zzvp zzvp) {
        zzvp.getClass();
        zzvm.zzg = zzvp;
        zzvm.zze |= 1;
    }
}
