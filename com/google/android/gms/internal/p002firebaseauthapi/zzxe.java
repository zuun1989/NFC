package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzalg;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzxe  reason: invalid package */
public final class zzxe extends zzalg<zzxe, zza> implements zzamp {
    /* access modifiers changed from: private */
    public static final zzxe zzc;
    private static volatile zzamw<zzxe> zzd;
    private String zze = "";
    private zzajw zzf = zzajw.zza;
    /* access modifiers changed from: private */
    public int zzg;

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzxe$zza */
    public static final class zza extends zzalg.zzb<zzxe, zza> implements zzamp {
        public final zza zza(zzyc zzyc) {
            zzg();
            ((zzxe) this.zza).zzg = zzyc.zza();
            return this;
        }

        private zza() {
            super(zzxe.zzc);
        }

        public final zza zza(String str) {
            zzg();
            zzxe.zza((zzxe) this.zza, str);
            return this;
        }

        public final zza zza(zzajw zzajw) {
            zzg();
            zzxe.zza((zzxe) this.zza, zzajw);
            return this;
        }
    }

    static {
        zzxe zzxe = new zzxe();
        zzc = zzxe;
        zzalg.zza(zzxe.class, zzxe);
    }

    private zzxe() {
    }

    public static zza zza() {
        return (zza) zzc.zzm();
    }

    public static zzxe zzc() {
        return zzc;
    }

    public final zzyc zzd() {
        zzyc zza2 = zzyc.zza(this.zzg);
        if (zza2 == null) {
            return zzyc.UNRECOGNIZED;
        }
        return zza2;
    }

    public final zzajw zze() {
        return this.zzf;
    }

    public final String zzf() {
        return this.zze;
    }

    public static zza zza(zzxe zzxe) {
        return (zza) zzc.zzm().zza(zzxe);
    }

    public static zzxe zza(byte[] bArr, zzakv zzakv) throws zzalm {
        return (zzxe) zzalg.zza(zzc, bArr, zzakv);
    }

    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzxd.zza[i - 1]) {
            case 1:
                return new zzxe();
            case 2:
                return new zza();
            case 3:
                return zzalg.zza((zzamn) zzc, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002\n\u0003\f", new Object[]{"zze", "zzf", "zzg"});
            case 4:
                return zzc;
            case 5:
                zzamw<zzxe> zzamw = zzd;
                if (zzamw == null) {
                    synchronized (zzxe.class) {
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

    public static /* synthetic */ void zza(zzxe zzxe, String str) {
        str.getClass();
        zzxe.zze = str;
    }

    public static /* synthetic */ void zza(zzxe zzxe, zzajw zzajw) {
        zzajw.getClass();
        zzxe.zzf = zzajw;
    }
}
