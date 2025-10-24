package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzalg;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzxz  reason: invalid package */
public final class zzxz extends zzalg<zzxz, zza> implements zzamp {
    /* access modifiers changed from: private */
    public static final zzxz zzc;
    private static volatile zzamw<zzxz> zzd;
    private int zze;
    private String zzf = "";
    private zzxe zzg;

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzxz$zza */
    public static final class zza extends zzalg.zzb<zzxz, zza> implements zzamp {
        public final zza zza(zzxe zzxe) {
            zzg();
            zzxz.zza((zzxz) this.zza, zzxe);
            return this;
        }

        private zza() {
            super(zzxz.zzc);
        }

        public final zza zza(String str) {
            zzg();
            zzxz.zza((zzxz) this.zza, str);
            return this;
        }
    }

    static {
        zzxz zzxz = new zzxz();
        zzc = zzxz;
        zzalg.zza(zzxz.class, zzxz);
    }

    private zzxz() {
    }

    public static zza zzb() {
        return (zza) zzc.zzm();
    }

    public static zzxz zzd() {
        return zzc;
    }

    public final zzxe zza() {
        zzxe zzxe = this.zzg;
        return zzxe == null ? zzxe.zzc() : zzxe;
    }

    public final String zze() {
        return this.zzf;
    }

    public static zzxz zza(zzajw zzajw, zzakv zzakv) throws zzalm {
        return (zzxz) zzalg.zza(zzc, zzajw, zzakv);
    }

    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzxy.zza[i - 1]) {
            case 1:
                return new zzxz();
            case 2:
                return new zza();
            case 3:
                return zzalg.zza((zzamn) zzc, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002ဉ\u0000", new Object[]{"zze", "zzf", "zzg"});
            case 4:
                return zzc;
            case 5:
                zzamw<zzxz> zzamw = zzd;
                if (zzamw == null) {
                    synchronized (zzxz.class) {
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

    public static /* synthetic */ void zza(zzxz zzxz, zzxe zzxe) {
        zzxe.getClass();
        zzxz.zzg = zzxe;
        zzxz.zze |= 1;
    }

    public static /* synthetic */ void zza(zzxz zzxz, String str) {
        str.getClass();
        zzxz.zzf = str;
    }
}
