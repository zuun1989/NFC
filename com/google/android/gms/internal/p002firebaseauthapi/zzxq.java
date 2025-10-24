package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzalg;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzxq  reason: invalid package */
public final class zzxq extends zzalg<zzxq, zza> implements zzamp {
    /* access modifiers changed from: private */
    public static final zzxq zzc;
    private static volatile zzamw<zzxq> zzd;
    private int zze;
    private int zzf;
    private zzxt zzg;

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzxq$zza */
    public static final class zza extends zzalg.zzb<zzxq, zza> implements zzamp {
        public final zza zza(zzxt zzxt) {
            zzg();
            zzxq.zza((zzxq) this.zza, zzxt);
            return this;
        }

        private zza() {
            super(zzxq.zzc);
        }
    }

    static {
        zzxq zzxq = new zzxq();
        zzc = zzxq;
        zzalg.zza(zzxq.class, zzxq);
    }

    private zzxq() {
    }

    public static zza zzb() {
        return (zza) zzc.zzm();
    }

    public static zzamw<zzxq> zze() {
        return (zzamw) zzc.zza(zzalg.zze.zzg, (Object) null, (Object) null);
    }

    public final int zza() {
        return this.zzf;
    }

    public final zzxt zzd() {
        zzxt zzxt = this.zzg;
        if (zzxt == null) {
            return zzxt.zzc();
        }
        return zzxt;
    }

    public static zzxq zza(zzajw zzajw, zzakv zzakv) throws zzalm {
        return (zzxq) zzalg.zza(zzc, zzajw, zzakv);
    }

    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzxp.zza[i - 1]) {
            case 1:
                return new zzxq();
            case 2:
                return new zza();
            case 3:
                return zzalg.zza((zzamn) zzc, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000", new Object[]{"zze", "zzf", "zzg"});
            case 4:
                return zzc;
            case 5:
                zzamw<zzxq> zzamw = zzd;
                if (zzamw == null) {
                    synchronized (zzxq.class) {
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

    public static /* synthetic */ void zza(zzxq zzxq, zzxt zzxt) {
        zzxt.getClass();
        zzxq.zzg = zzxt;
        zzxq.zze |= 1;
    }
}
