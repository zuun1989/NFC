package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzalg;

@Deprecated
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzxh  reason: invalid package */
public final class zzxh extends zzalg<zzxh, zza> implements zzamp {
    /* access modifiers changed from: private */
    public static final zzxh zzc;
    private static volatile zzamw<zzxh> zzd;
    private String zze = "";
    private String zzf = "";
    private int zzg;
    private boolean zzh;
    private String zzi = "";

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzxh$zza */
    public static final class zza extends zzalg.zzb<zzxh, zza> implements zzamp {
        private zza() {
            super(zzxh.zzc);
        }
    }

    static {
        zzxh zzxh = new zzxh();
        zzc = zzxh;
        zzalg.zza(zzxh.class, zzxh);
    }

    private zzxh() {
    }

    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzxg.zza[i - 1]) {
            case 1:
                return new zzxh();
            case 2:
                return new zza();
            case 3:
                return zzalg.zza((zzamn) zzc, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003\u000b\u0004\u0007\u0005Ȉ", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi"});
            case 4:
                return zzc;
            case 5:
                zzamw<zzxh> zzamw = zzd;
                if (zzamw == null) {
                    synchronized (zzxh.class) {
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
