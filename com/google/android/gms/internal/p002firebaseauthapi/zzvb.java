package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzalg;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzvb  reason: invalid package */
public final class zzvb extends zzalg<zzvb, zza> implements zzamp {
    /* access modifiers changed from: private */
    public static final zzvb zzc;
    private static volatile zzamw<zzvb> zzd;

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzvb$zza */
    public static final class zza extends zzalg.zzb<zzvb, zza> implements zzamp {
        private zza() {
            super(zzvb.zzc);
        }
    }

    static {
        zzvb zzvb = new zzvb();
        zzc = zzvb;
        zzalg.zza(zzvb.class, zzvb);
    }

    private zzvb() {
    }

    public static zzvb zzb() {
        return zzc;
    }

    public static zzvb zza(zzajw zzajw, zzakv zzakv) throws zzalm {
        return (zzvb) zzalg.zza(zzc, zzajw, zzakv);
    }

    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzva.zza[i - 1]) {
            case 1:
                return new zzvb();
            case 2:
                return new zza();
            case 3:
                return zzalg.zza((zzamn) zzc, "\u0000\u0000", (Object[]) null);
            case 4:
                return zzc;
            case 5:
                zzamw<zzvb> zzamw = zzd;
                if (zzamw == null) {
                    synchronized (zzvb.class) {
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
