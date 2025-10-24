package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzalg;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzyq  reason: invalid package */
public final class zzyq extends zzalg<zzyq, zza> implements zzamp {
    /* access modifiers changed from: private */
    public static final zzyq zzc;
    private static volatile zzamw<zzyq> zzd;
    private int zze;

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzyq$zza */
    public static final class zza extends zzalg.zzb<zzyq, zza> implements zzamp {
        private zza() {
            super(zzyq.zzc);
        }
    }

    static {
        zzyq zzyq = new zzyq();
        zzc = zzyq;
        zzalg.zza(zzyq.class, zzyq);
    }

    private zzyq() {
    }

    public static zzyq zzc() {
        return zzc;
    }

    public final int zza() {
        return this.zze;
    }

    public static zzyq zza(zzajw zzajw, zzakv zzakv) throws zzalm {
        return (zzyq) zzalg.zza(zzc, zzajw, zzakv);
    }

    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzys.zza[i - 1]) {
            case 1:
                return new zzyq();
            case 2:
                return new zza();
            case 3:
                return zzalg.zza((zzamn) zzc, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u000b", new Object[]{"zze"});
            case 4:
                return zzc;
            case 5:
                zzamw<zzyq> zzamw = zzd;
                if (zzamw == null) {
                    synchronized (zzyq.class) {
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
