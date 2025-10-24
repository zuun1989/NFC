package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzalg;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzup  reason: invalid package */
public final class zzup extends zzalg<zzup, zza> implements zzamp {
    /* access modifiers changed from: private */
    public static final zzup zzc;
    private static volatile zzamw<zzup> zzd;
    /* access modifiers changed from: private */
    public int zze;
    private int zzf;

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzup$zza */
    public static final class zza extends zzalg.zzb<zzup, zza> implements zzamp {
        public final zza zza(int i) {
            zzg();
            ((zzup) this.zza).zze = i;
            return this;
        }

        private zza() {
            super(zzup.zzc);
        }
    }

    static {
        zzup zzup = new zzup();
        zzc = zzup;
        zzalg.zza(zzup.class, zzup);
    }

    private zzup() {
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

    public static zzup zza(zzajw zzajw, zzakv zzakv) throws zzalm {
        return (zzup) zzalg.zza(zzc, zzajw, zzakv);
    }

    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzuo.zza[i - 1]) {
            case 1:
                return new zzup();
            case 2:
                return new zza();
            case 3:
                return zzalg.zza((zzamn) zzc, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\u000b", new Object[]{"zzf", "zze"});
            case 4:
                return zzc;
            case 5:
                zzamw<zzup> zzamw = zzd;
                if (zzamw == null) {
                    synchronized (zzup.class) {
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
