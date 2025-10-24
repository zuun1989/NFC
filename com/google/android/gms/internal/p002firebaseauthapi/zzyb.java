package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzalg;

@Deprecated
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzyb  reason: invalid package */
public final class zzyb extends zzalg<zzyb, zza> implements zzamp {
    /* access modifiers changed from: private */
    public static final zzyb zzc;
    private static volatile zzamw<zzyb> zzd;
    private String zze = "";
    private zzaln<zzxh> zzf = zzalg.zzp();

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzyb$zza */
    public static final class zza extends zzalg.zzb<zzyb, zza> implements zzamp {
        private zza() {
            super(zzyb.zzc);
        }
    }

    static {
        zzyb zzyb = new zzyb();
        zzc = zzyb;
        zzalg.zza(zzyb.class, zzyb);
    }

    private zzyb() {
    }

    public static zzyb zzb() {
        return zzc;
    }

    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzyd.zza[i - 1]) {
            case 1:
                return new zzyb();
            case 2:
                return new zza();
            case 3:
                return zzalg.zza((zzamn) zzc, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001Ȉ\u0002\u001b", new Object[]{"zze", "zzf", zzxh.class});
            case 4:
                return zzc;
            case 5:
                zzamw<zzyb> zzamw = zzd;
                if (zzamw == null) {
                    synchronized (zzyb.class) {
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
