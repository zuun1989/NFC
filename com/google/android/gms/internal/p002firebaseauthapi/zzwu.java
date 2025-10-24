package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzalg;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzwu  reason: invalid package */
public final class zzwu extends zzalg<zzwu, zza> implements zzamp {
    /* access modifiers changed from: private */
    public static final zzwu zzc;
    private static volatile zzamw<zzwu> zzd;
    private int zze;
    /* access modifiers changed from: private */
    public int zzf;
    private zzwx zzg;
    private zzajw zzh = zzajw.zza;

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzwu$zza */
    public static final class zza extends zzalg.zzb<zzwu, zza> implements zzamp {
        public final zza zza(zzajw zzajw) {
            zzg();
            zzwu.zza((zzwu) this.zza, zzajw);
            return this;
        }

        private zza() {
            super(zzwu.zzc);
        }

        public final zza zza(zzwx zzwx) {
            zzg();
            zzwu.zza((zzwu) this.zza, zzwx);
            return this;
        }

        public final zza zza(int i) {
            zzg();
            ((zzwu) this.zza).zzf = 0;
            return this;
        }
    }

    static {
        zzwu zzwu = new zzwu();
        zzc = zzwu;
        zzalg.zza(zzwu.class, zzwu);
    }

    private zzwu() {
    }

    public static zza zzb() {
        return (zza) zzc.zzm();
    }

    public static zzamw<zzwu> zzf() {
        return (zzamw) zzc.zza(zzalg.zze.zzg, (Object) null, (Object) null);
    }

    public final int zza() {
        return this.zzf;
    }

    public final zzwx zzd() {
        zzwx zzwx = this.zzg;
        if (zzwx == null) {
            return zzwx.zze();
        }
        return zzwx;
    }

    public final zzajw zze() {
        return this.zzh;
    }

    public static zzwu zza(zzajw zzajw, zzakv zzakv) throws zzalm {
        return (zzwu) zzalg.zza(zzc, zzajw, zzakv);
    }

    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzwt.zza[i - 1]) {
            case 1:
                return new zzwu();
            case 2:
                return new zza();
            case 3:
                return zzalg.zza((zzamn) zzc, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000\u0003\n", new Object[]{"zze", "zzf", "zzg", "zzh"});
            case 4:
                return zzc;
            case 5:
                zzamw<zzwu> zzamw = zzd;
                if (zzamw == null) {
                    synchronized (zzwu.class) {
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

    public static /* synthetic */ void zza(zzwu zzwu, zzajw zzajw) {
        zzajw.getClass();
        zzwu.zzh = zzajw;
    }

    public static /* synthetic */ void zza(zzwu zzwu, zzwx zzwx) {
        zzwx.getClass();
        zzwu.zzg = zzwx;
        zzwu.zze |= 1;
    }
}
