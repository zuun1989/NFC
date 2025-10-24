package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzalg;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzuv  reason: invalid package */
public final class zzuv extends zzalg<zzuv, zza> implements zzamp {
    /* access modifiers changed from: private */
    public static final zzuv zzc;
    private static volatile zzamw<zzuv> zzd;
    /* access modifiers changed from: private */
    public int zze;
    private int zzf;

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzuv$zza */
    public static final class zza extends zzalg.zzb<zzuv, zza> implements zzamp {
        public final zza zza(int i) {
            zzg();
            ((zzuv) this.zza).zze = i;
            return this;
        }

        private zza() {
            super(zzuv.zzc);
        }
    }

    static {
        zzuv zzuv = new zzuv();
        zzc = zzuv;
        zzalg.zza(zzuv.class, zzuv);
    }

    private zzuv() {
    }

    public static zza zzc() {
        return (zza) zzc.zzm();
    }

    public final int zza() {
        return this.zze;
    }

    public final int zzb() {
        return this.zzf;
    }

    public static zzuv zza(zzajw zzajw, zzakv zzakv) throws zzalm {
        return (zzuv) zzalg.zza(zzc, zzajw, zzakv);
    }

    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzuu.zza[i - 1]) {
            case 1:
                return new zzuv();
            case 2:
                return new zza();
            case 3:
                return zzalg.zza((zzamn) zzc, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\u000b", new Object[]{"zze", "zzf"});
            case 4:
                return zzc;
            case 5:
                zzamw<zzuv> zzamw = zzd;
                if (zzamw == null) {
                    synchronized (zzuv.class) {
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
}
