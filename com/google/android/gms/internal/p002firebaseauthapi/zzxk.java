package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzalg;
import com.google.android.gms.internal.p002firebaseauthapi.zzxa;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzxk  reason: invalid package */
public final class zzxk extends zzalg<zzxk, zzb> implements zzamp {
    /* access modifiers changed from: private */
    public static final zzxk zzc;
    private static volatile zzamw<zzxk> zzd;
    /* access modifiers changed from: private */
    public int zze;
    private zzaln<zza> zzf = zzalg.zzp();

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzxk$zza */
    public static final class zza extends zzalg<zza, C0017zza> implements zzamp {
        /* access modifiers changed from: private */
        public static final zza zzc;
        private static volatile zzamw<zza> zzd;
        private int zze;
        private zzxa zzf;
        /* access modifiers changed from: private */
        public int zzg;
        /* access modifiers changed from: private */
        public int zzh;
        /* access modifiers changed from: private */
        public int zzi;

        /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzxk$zza$zza  reason: collision with other inner class name */
        public static final class C0017zza extends zzalg.zzb<zza, C0017zza> implements zzamp {
            public final C0017zza zza(zzxa.zzb zzb) {
                zzg();
                zza.zza((zza) this.zza, (zzxa) ((zzalg) zzb.zze()));
                return this;
            }

            private C0017zza() {
                super(zza.zzc);
            }

            public final C0017zza zza(zzxa zzxa) {
                zzg();
                zza.zza((zza) this.zza, zzxa);
                return this;
            }

            public final C0017zza zza(int i) {
                zzg();
                ((zza) this.zza).zzh = i;
                return this;
            }

            public final C0017zza zza(zzyc zzyc) {
                zzg();
                ((zza) this.zza).zzi = zzyc.zza();
                return this;
            }

            public final C0017zza zza(zzxb zzxb) {
                zzg();
                ((zza) this.zza).zzg = zzxb.zza();
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

        public static C0017zza zzd() {
            return (C0017zza) zzc.zzm();
        }

        public final int zza() {
            return this.zzh;
        }

        public final zzxa zzb() {
            zzxa zzxa = this.zzf;
            if (zzxa == null) {
                return zzxa.zzd();
            }
            return zzxa;
        }

        public final zzxb zzc() {
            zzxb zza = zzxb.zza(this.zzg);
            if (zza == null) {
                return zzxb.UNRECOGNIZED;
            }
            return zza;
        }

        public final zzyc zzf() {
            zzyc zza = zzyc.zza(this.zzi);
            if (zza == null) {
                return zzyc.UNRECOGNIZED;
            }
            return zza;
        }

        public final boolean zzg() {
            if ((this.zze & 1) != 0) {
                return true;
            }
            return false;
        }

        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzxj.zza[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C0017zza();
                case 3:
                    return zzalg.zza((zzamn) zzc, "\u0000\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002\f\u0003\u000b\u0004\f", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi"});
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

        public static /* synthetic */ void zza(zza zza, zzxa zzxa) {
            zzxa.getClass();
            zza.zzf = zzxa;
            zza.zze |= 1;
        }
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzxk$zzb */
    public static final class zzb extends zzalg.zzb<zzxk, zzb> implements zzamp {
        public final zzb zza(zza zza) {
            zzg();
            zzxk.zza((zzxk) this.zza, zza);
            return this;
        }

        private zzb() {
            super(zzxk.zzc);
        }

        public final zzb zza(int i) {
            zzg();
            ((zzxk) this.zza).zze = i;
            return this;
        }
    }

    static {
        zzxk zzxk = new zzxk();
        zzc = zzxk;
        zzalg.zza(zzxk.class, zzxk);
    }

    private zzxk() {
    }

    public static zzb zzc() {
        return (zzb) zzc.zzm();
    }

    public final int zza() {
        return this.zzf.size();
    }

    public final int zzb() {
        return this.zze;
    }

    public final List<zza> zze() {
        return this.zzf;
    }

    public final zza zza(int i) {
        return this.zzf.get(i);
    }

    public static zzxk zza(InputStream inputStream, zzakv zzakv) throws IOException {
        return (zzxk) zzalg.zza(zzc, inputStream, zzakv);
    }

    public static zzxk zza(byte[] bArr, zzakv zzakv) throws zzalm {
        return (zzxk) zzalg.zza(zzc, bArr, zzakv);
    }

    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzxj.zza[i - 1]) {
            case 1:
                return new zzxk();
            case 2:
                return new zzb();
            case 3:
                return zzalg.zza((zzamn) zzc, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u000b\u0002\u001b", new Object[]{"zze", "zzf", zza.class});
            case 4:
                return zzc;
            case 5:
                zzamw<zzxk> zzamw = zzd;
                if (zzamw == null) {
                    synchronized (zzxk.class) {
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

    public static /* synthetic */ void zza(zzxk zzxk, zza zza2) {
        zza2.getClass();
        zzaln<zza> zzaln = zzxk.zzf;
        if (!zzaln.zzc()) {
            zzxk.zzf = zzalg.zza(zzaln);
        }
        zzxk.zzf.add(zza2);
    }
}
