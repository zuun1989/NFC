package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzalg;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzxn  reason: invalid package */
public final class zzxn extends zzalg<zzxn, zzb> implements zzamp {
    /* access modifiers changed from: private */
    public static final zzxn zzc;
    private static volatile zzamw<zzxn> zzd;
    /* access modifiers changed from: private */
    public int zze;
    private zzaln<zza> zzf = zzalg.zzp();

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzxn$zza */
    public static final class zza extends zzalg<zza, C0018zza> implements zzamp {
        /* access modifiers changed from: private */
        public static final zza zzc;
        private static volatile zzamw<zza> zzd;
        private String zze = "";
        /* access modifiers changed from: private */
        public int zzf;
        /* access modifiers changed from: private */
        public int zzg;
        /* access modifiers changed from: private */
        public int zzh;

        /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzxn$zza$zza  reason: collision with other inner class name */
        public static final class C0018zza extends zzalg.zzb<zza, C0018zza> implements zzamp {
            public final C0018zza zza(int i) {
                zzg();
                ((zza) this.zza).zzg = i;
                return this;
            }

            private C0018zza() {
                super(zza.zzc);
            }

            public final C0018zza zza(zzyc zzyc) {
                zzg();
                ((zza) this.zza).zzh = zzyc.zza();
                return this;
            }

            public final C0018zza zza(zzxb zzxb) {
                zzg();
                ((zza) this.zza).zzf = zzxb.zza();
                return this;
            }

            public final C0018zza zza(String str) {
                zzg();
                zza.zza((zza) this.zza, str);
                return this;
            }
        }

        static {
            zza zza = new zza();
            zzc = zza;
            zzalg.zza(zza.class, zza);
        }

        private zza() {
        }

        public static C0018zza zza() {
            return (C0018zza) zzc.zzm();
        }

        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzxm.zza[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C0018zza();
                case 3:
                    return zzalg.zza((zzamn) zzc, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001Ȉ\u0002\f\u0003\u000b\u0004\f", new Object[]{"zze", "zzf", "zzg", "zzh"});
                case 4:
                    return zzc;
                case 5:
                    zzamw<zza> zzamw = zzd;
                    if (zzamw == null) {
                        synchronized (zza.class) {
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

        public static /* synthetic */ void zza(zza zza, String str) {
            str.getClass();
            zza.zze = str;
        }
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzxn$zzb */
    public static final class zzb extends zzalg.zzb<zzxn, zzb> implements zzamp {
        public final zzb zza(zza zza) {
            zzg();
            zzxn.zza((zzxn) this.zza, zza);
            return this;
        }

        private zzb() {
            super(zzxn.zzc);
        }

        public final zzb zza(int i) {
            zzg();
            ((zzxn) this.zza).zze = i;
            return this;
        }
    }

    static {
        zzxn zzxn = new zzxn();
        zzc = zzxn;
        zzalg.zza(zzxn.class, zzxn);
    }

    private zzxn() {
    }

    public static zzb zza() {
        return (zzb) zzc.zzm();
    }

    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzxm.zza[i - 1]) {
            case 1:
                return new zzxn();
            case 2:
                return new zzb();
            case 3:
                return zzalg.zza((zzamn) zzc, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u000b\u0002\u001b", new Object[]{"zze", "zzf", zza.class});
            case 4:
                return zzc;
            case 5:
                zzamw<zzxn> zzamw = zzd;
                if (zzamw == null) {
                    synchronized (zzxn.class) {
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

    public static /* synthetic */ void zza(zzxn zzxn, zza zza2) {
        zza2.getClass();
        zzaln<zza> zzaln = zzxn.zzf;
        if (!zzaln.zzc()) {
            zzxn.zzf = zzalg.zza(zzaln);
        }
        zzxn.zzf.add(zza2);
    }
}
