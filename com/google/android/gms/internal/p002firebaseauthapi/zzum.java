package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzalg;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzum  reason: invalid package */
public final class zzum extends zzalg<zzum, zza> implements zzamp {
    /* access modifiers changed from: private */
    public static final zzum zzc;
    private static volatile zzamw<zzum> zzd;
    private int zze;
    private zzajw zzf = zzajw.zza;

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzum$zza */
    public static final class zza extends zzalg.zzb<zzum, zza> implements zzamp {
        public final zza zza(zzajw zzajw) {
            zzg();
            zzum.zza((zzum) this.zza, zzajw);
            return this;
        }

        private zza() {
            super(zzum.zzc);
        }
    }

    static {
        zzum zzum = new zzum();
        zzc = zzum;
        zzalg.zza(zzum.class, zzum);
    }

    private zzum() {
    }

    public static zza zzb() {
        return (zza) zzc.zzm();
    }

    public static zzamw<zzum> zze() {
        return (zzamw) zzc.zza(zzalg.zze.zzg, (Object) null, (Object) null);
    }

    public final int zza() {
        return this.zze;
    }

    public final zzajw zzd() {
        return this.zzf;
    }

    public static zzum zza(zzajw zzajw, zzakv zzakv) throws zzalm {
        return (zzum) zzalg.zza(zzc, zzajw, zzakv);
    }

    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzul.zza[i - 1]) {
            case 1:
                return new zzum();
            case 2:
                return new zza();
            case 3:
                return zzalg.zza((zzamn) zzc, "\u0000\u0002\u0000\u0000\u0001\u0003\u0002\u0000\u0000\u0000\u0001\u000b\u0003\n", new Object[]{"zze", "zzf"});
            case 4:
                return zzc;
            case 5:
                zzamw<zzum> zzamw = zzd;
                if (zzamw == null) {
                    synchronized (zzum.class) {
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

    public static /* synthetic */ void zza(zzum zzum, zzajw zzajw) {
        zzajw.getClass();
        zzum.zzf = zzajw;
    }
}
