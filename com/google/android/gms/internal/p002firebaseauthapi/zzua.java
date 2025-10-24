package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzalg;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzua  reason: invalid package */
public final class zzua extends zzalg<zzua, zza> implements zzamp {
    /* access modifiers changed from: private */
    public static final zzua zzc;
    private static volatile zzamw<zzua> zzd;
    private int zze;
    private zzud zzf;
    /* access modifiers changed from: private */
    public int zzg;

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzua$zza */
    public static final class zza extends zzalg.zzb<zzua, zza> implements zzamp {
        public final zza zza(int i) {
            zzg();
            ((zzua) this.zza).zzg = i;
            return this;
        }

        private zza() {
            super(zzua.zzc);
        }

        public final zza zza(zzud zzud) {
            zzg();
            zzua.zza((zzua) this.zza, zzud);
            return this;
        }
    }

    static {
        zzua zzua = new zzua();
        zzc = zzua;
        zzalg.zza(zzua.class, zzua);
    }

    private zzua() {
    }

    public static zza zzb() {
        return (zza) zzc.zzm();
    }

    public final int zza() {
        return this.zzg;
    }

    public final zzud zzd() {
        zzud zzud = this.zzf;
        if (zzud == null) {
            return zzud.zzd();
        }
        return zzud;
    }

    public static zzua zza(zzajw zzajw, zzakv zzakv) throws zzalm {
        return (zzua) zzalg.zza(zzc, zzajw, zzakv);
    }

    public final Object zza(int i, Object obj, Object obj2) {
        switch (zztz.zza[i - 1]) {
            case 1:
                return new zzua();
            case 2:
                return new zza();
            case 3:
                return zzalg.zza((zzamn) zzc, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002\u000b", new Object[]{"zze", "zzf", "zzg"});
            case 4:
                return zzc;
            case 5:
                zzamw<zzua> zzamw = zzd;
                if (zzamw == null) {
                    synchronized (zzua.class) {
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

    public static /* synthetic */ void zza(zzua zzua, zzud zzud) {
        zzud.getClass();
        zzua.zzf = zzud;
        zzua.zze |= 1;
    }
}
