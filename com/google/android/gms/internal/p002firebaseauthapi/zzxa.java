package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzalg;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzxa  reason: invalid package */
public final class zzxa extends zzalg<zzxa, zzb> implements zzamp {
    /* access modifiers changed from: private */
    public static final zzxa zzc;
    private static volatile zzamw<zzxa> zzd;
    private String zze = "";
    private zzajw zzf = zzajw.zza;
    /* access modifiers changed from: private */
    public int zzg;

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzxa$zzb */
    public static final class zzb extends zzalg.zzb<zzxa, zzb> implements zzamp {
        public final zzb zza(zza zza) {
            zzg();
            ((zzxa) this.zza).zzg = zza.zza();
            return this;
        }

        private zzb() {
            super(zzxa.zzc);
        }

        public final zzb zza(String str) {
            zzg();
            zzxa.zza((zzxa) this.zza, str);
            return this;
        }

        public final zzb zza(zzajw zzajw) {
            zzg();
            zzxa.zza((zzxa) this.zza, zzajw);
            return this;
        }
    }

    static {
        zzxa zzxa = new zzxa();
        zzc = zzxa;
        zzalg.zza(zzxa.class, zzxa);
    }

    private zzxa() {
    }

    public static zzb zza() {
        return (zzb) zzc.zzm();
    }

    public static zzxa zzd() {
        return zzc;
    }

    public final zza zzb() {
        zza zza2 = zza.zza(this.zzg);
        if (zza2 == null) {
            return zza.UNRECOGNIZED;
        }
        return zza2;
    }

    public final zzajw zze() {
        return this.zzf;
    }

    public final String zzf() {
        return this.zze;
    }

    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzwz.zza[i - 1]) {
            case 1:
                return new zzxa();
            case 2:
                return new zzb();
            case 3:
                return zzalg.zza((zzamn) zzc, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002\n\u0003\f", new Object[]{"zze", "zzf", "zzg"});
            case 4:
                return zzc;
            case 5:
                zzamw<zzxa> zzamw = zzd;
                if (zzamw == null) {
                    synchronized (zzxa.class) {
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

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzxa$zza */
    public enum zza implements zzall {
        UNKNOWN_KEYMATERIAL(0),
        SYMMETRIC(1),
        ASYMMETRIC_PRIVATE(2),
        ASYMMETRIC_PUBLIC(3),
        REMOTE(4),
        UNRECOGNIZED(-1);
        
        private final int zzh;

        private zza(int i) {
            this.zzh = i;
        }

        public final String toString() {
            StringBuilder sb2 = new StringBuilder("<");
            sb2.append(zza.class.getName());
            sb2.append('@');
            sb2.append(Integer.toHexString(System.identityHashCode(this)));
            if (this != UNRECOGNIZED) {
                sb2.append(" number=");
                sb2.append(zza());
            }
            sb2.append(" name=");
            sb2.append(name());
            sb2.append('>');
            return sb2.toString();
        }

        public final int zza() {
            if (this != UNRECOGNIZED) {
                return this.zzh;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        public static zza zza(int i) {
            if (i == 0) {
                return UNKNOWN_KEYMATERIAL;
            }
            if (i == 1) {
                return SYMMETRIC;
            }
            if (i == 2) {
                return ASYMMETRIC_PRIVATE;
            }
            if (i == 3) {
                return ASYMMETRIC_PUBLIC;
            }
            if (i != 4) {
                return null;
            }
            return REMOTE;
        }
    }

    public static /* synthetic */ void zza(zzxa zzxa, String str) {
        str.getClass();
        zzxa.zze = str;
    }

    public static /* synthetic */ void zza(zzxa zzxa, zzajw zzajw) {
        zzajw.getClass();
        zzxa.zzf = zzajw;
    }
}
