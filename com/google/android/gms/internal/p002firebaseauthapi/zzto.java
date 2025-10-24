package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzalg;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzto  reason: invalid package */
public final class zzto extends zzalg<zzto, zza> implements zzamp {
    /* access modifiers changed from: private */
    public static final zzto zzc;
    private static volatile zzamw<zzto> zzd;
    private int zze;
    private int zzf;
    private zztu zzg;
    private zzajw zzh = zzajw.zza;

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzto$zza */
    public static final class zza extends zzalg.zzb<zzto, zza> implements zzamp {
        public final zza zza(zzajw zzajw) {
            zzg();
            zzto.zza((zzto) this.zza, zzajw);
            return this;
        }

        private zza() {
            super(zzto.zzc);
        }

        public final zza zza(zztu zztu) {
            zzg();
            zzto.zza((zzto) this.zza, zztu);
            return this;
        }
    }

    static {
        zzto zzto = new zzto();
        zzc = zzto;
        zzalg.zza(zzto.class, zzto);
    }

    private zzto() {
    }

    public static zza zzb() {
        return (zza) zzc.zzm();
    }

    public static zzto zzd() {
        return zzc;
    }

    public final int zza() {
        return this.zzf;
    }

    public final zztu zze() {
        zztu zztu = this.zzg;
        if (zztu == null) {
            return zztu.zzd();
        }
        return zztu;
    }

    public final zzajw zzf() {
        return this.zzh;
    }

    public final Object zza(int i, Object obj, Object obj2) {
        switch (zztn.zza[i - 1]) {
            case 1:
                return new zzto();
            case 2:
                return new zza();
            case 3:
                return zzalg.zza((zzamn) zzc, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000\u0003\n", new Object[]{"zze", "zzf", "zzg", "zzh"});
            case 4:
                return zzc;
            case 5:
                zzamw<zzto> zzamw = zzd;
                if (zzamw == null) {
                    synchronized (zzto.class) {
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

    public static /* synthetic */ void zza(zzto zzto, zzajw zzajw) {
        zzajw.getClass();
        zzto.zzh = zzajw;
    }

    public static /* synthetic */ void zza(zzto zzto, zztu zztu) {
        zztu.getClass();
        zzto.zzg = zztu;
        zzto.zze |= 1;
    }
}
