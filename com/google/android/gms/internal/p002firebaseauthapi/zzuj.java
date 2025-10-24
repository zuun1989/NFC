package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzalg;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzuj  reason: invalid package */
public final class zzuj extends zzalg<zzuj, zza> implements zzamp {
    /* access modifiers changed from: private */
    public static final zzuj zzc;
    private static volatile zzamw<zzuj> zzd;
    /* access modifiers changed from: private */
    public int zze;
    private int zzf;

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzuj$zza */
    public static final class zza extends zzalg.zzb<zzuj, zza> implements zzamp {
        public final zza zza(int i) {
            zzg();
            ((zzuj) this.zza).zze = i;
            return this;
        }

        private zza() {
            super(zzuj.zzc);
        }
    }

    static {
        zzuj zzuj = new zzuj();
        zzc = zzuj;
        zzalg.zza(zzuj.class, zzuj);
    }

    private zzuj() {
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

    public static zzuj zza(zzajw zzajw, zzakv zzakv) throws zzalm {
        return (zzuj) zzalg.zza(zzc, zzajw, zzakv);
    }

    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzui.zza[i - 1]) {
            case 1:
                return new zzuj();
            case 2:
                return new zza();
            case 3:
                return zzalg.zza((zzamn) zzc, "\u0000\u0002\u0000\u0000\u0002\u0003\u0002\u0000\u0000\u0000\u0002\u000b\u0003\u000b", new Object[]{"zze", "zzf"});
            case 4:
                return zzc;
            case 5:
                zzamw<zzuj> zzamw = zzd;
                if (zzamw == null) {
                    synchronized (zzuj.class) {
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
