package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzalg;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzwo  reason: invalid package */
public final class zzwo extends zzalg<zzwo, zza> implements zzamp {
    /* access modifiers changed from: private */
    public static final zzwo zzc;
    private static volatile zzamw<zzwo> zzd;
    private int zze;
    private zzwr zzf;

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzwo$zza */
    public static final class zza extends zzalg.zzb<zzwo, zza> implements zzamp {
        public final zza zza(zzwr zzwr) {
            zzg();
            zzwo.zza((zzwo) this.zza, zzwr);
            return this;
        }

        private zza() {
            super(zzwo.zzc);
        }
    }

    static {
        zzwo zzwo = new zzwo();
        zzc = zzwo;
        zzalg.zza(zzwo.class, zzwo);
    }

    private zzwo() {
    }

    public static zza zza() {
        return (zza) zzc.zzm();
    }

    public final zzwr zzc() {
        zzwr zzwr = this.zzf;
        if (zzwr == null) {
            return zzwr.zzf();
        }
        return zzwr;
    }

    public static zzwo zza(zzajw zzajw, zzakv zzakv) throws zzalm {
        return (zzwo) zzalg.zza(zzc, zzajw, zzakv);
    }

    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzwn.zza[i - 1]) {
            case 1:
                return new zzwo();
            case 2:
                return new zza();
            case 3:
                return zzalg.zza((zzamn) zzc, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"zze", "zzf"});
            case 4:
                return zzc;
            case 5:
                zzamw<zzwo> zzamw = zzd;
                if (zzamw == null) {
                    synchronized (zzwo.class) {
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

    public static /* synthetic */ void zza(zzwo zzwo, zzwr zzwr) {
        zzwr.getClass();
        zzwo.zzf = zzwr;
        zzwo.zze |= 1;
    }
}
