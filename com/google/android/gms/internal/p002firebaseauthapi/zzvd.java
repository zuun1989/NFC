package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzalg;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzvd  reason: invalid package */
public final class zzvd extends zzalg<zzvd, zza> implements zzamp {
    /* access modifiers changed from: private */
    public static final zzvd zzc;
    private static volatile zzamw<zzvd> zzd;
    private int zze;
    private zzxe zzf;

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzvd$zza */
    public static final class zza extends zzalg.zzb<zzvd, zza> implements zzamp {
        public final zza zza(zzxe zzxe) {
            zzg();
            zzvd.zza((zzvd) this.zza, zzxe);
            return this;
        }

        private zza() {
            super(zzvd.zzc);
        }
    }

    static {
        zzvd zzvd = new zzvd();
        zzc = zzvd;
        zzalg.zza(zzvd.class, zzvd);
    }

    private zzvd() {
    }

    public static zza zza() {
        return (zza) zzc.zzm();
    }

    public static zzvd zzc() {
        return zzc;
    }

    public final zzxe zzd() {
        zzxe zzxe = this.zzf;
        if (zzxe == null) {
            return zzxe.zzc();
        }
        return zzxe;
    }

    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzvf.zza[i - 1]) {
            case 1:
                return new zzvd();
            case 2:
                return new zza();
            case 3:
                return zzalg.zza((zzamn) zzc, "\u0000\u0001\u0000\u0001\u0002\u0002\u0001\u0000\u0000\u0000\u0002ဉ\u0000", new Object[]{"zze", "zzf"});
            case 4:
                return zzc;
            case 5:
                zzamw<zzvd> zzamw = zzd;
                if (zzamw == null) {
                    synchronized (zzvd.class) {
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

    public static /* synthetic */ void zza(zzvd zzvd, zzxe zzxe) {
        zzxe.getClass();
        zzvd.zzf = zzxe;
        zzvd.zze |= 1;
    }
}
