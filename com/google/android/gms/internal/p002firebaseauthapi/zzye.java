package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzalg;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzye  reason: invalid package */
public final class zzye extends zzalg<zzye, zza> implements zzamp {
    /* access modifiers changed from: private */
    public static final zzye zzc;
    private static volatile zzamw<zzye> zzd;
    private int zze;
    private int zzf;
    private zzyk zzg;
    private zzajw zzh = zzajw.zza;

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzye$zza */
    public static final class zza extends zzalg.zzb<zzye, zza> implements zzamp {
        public final zza zza(zzajw zzajw) {
            zzg();
            zzye.zza((zzye) this.zza, zzajw);
            return this;
        }

        private zza() {
            super(zzye.zzc);
        }

        public final zza zza(zzyk zzyk) {
            zzg();
            zzye.zza((zzye) this.zza, zzyk);
            return this;
        }
    }

    static {
        zzye zzye = new zzye();
        zzc = zzye;
        zzalg.zza(zzye.class, zzye);
    }

    private zzye() {
    }

    public static zza zzb() {
        return (zza) zzc.zzm();
    }

    public final int zza() {
        return this.zzf;
    }

    public final zzyk zzd() {
        zzyk zzyk = this.zzg;
        if (zzyk == null) {
            return zzyk.zzd();
        }
        return zzyk;
    }

    public final zzajw zze() {
        return this.zzh;
    }

    public static zzye zza(zzajw zzajw, zzakv zzakv) throws zzalm {
        return (zzye) zzalg.zza(zzc, zzajw, zzakv);
    }

    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzyg.zza[i - 1]) {
            case 1:
                return new zzye();
            case 2:
                return new zza();
            case 3:
                return zzalg.zza((zzamn) zzc, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000\u0003\n", new Object[]{"zze", "zzf", "zzg", "zzh"});
            case 4:
                return zzc;
            case 5:
                zzamw<zzye> zzamw = zzd;
                if (zzamw == null) {
                    synchronized (zzye.class) {
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

    public static /* synthetic */ void zza(zzye zzye, zzajw zzajw) {
        zzajw.getClass();
        zzye.zzh = zzajw;
    }

    public static /* synthetic */ void zza(zzye zzye, zzyk zzyk) {
        zzyk.getClass();
        zzye.zzg = zzyk;
        zzye.zze |= 1;
    }
}
