package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzalg;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzxt  reason: invalid package */
public final class zzxt extends zzalg<zzxt, zza> implements zzamp {
    /* access modifiers changed from: private */
    public static final zzxt zzc;
    private static volatile zzamw<zzxt> zzd;
    private String zze = "";

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzxt$zza */
    public static final class zza extends zzalg.zzb<zzxt, zza> implements zzamp {
        public final zza zza(String str) {
            zzg();
            zzxt.zza((zzxt) this.zza, str);
            return this;
        }

        private zza() {
            super(zzxt.zzc);
        }
    }

    static {
        zzxt zzxt = new zzxt();
        zzc = zzxt;
        zzalg.zza(zzxt.class, zzxt);
    }

    private zzxt() {
    }

    public static zza zza() {
        return (zza) zzc.zzm();
    }

    public static zzxt zzc() {
        return zzc;
    }

    public final String zzd() {
        return this.zze;
    }

    public static zzxt zza(zzajw zzajw, zzakv zzakv) throws zzalm {
        return (zzxt) zzalg.zza(zzc, zzajw, zzakv);
    }

    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzxs.zza[i - 1]) {
            case 1:
                return new zzxt();
            case 2:
                return new zza();
            case 3:
                return zzalg.zza((zzamn) zzc, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"zze"});
            case 4:
                return zzc;
            case 5:
                zzamw<zzxt> zzamw = zzd;
                if (zzamw == null) {
                    synchronized (zzxt.class) {
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

    public static /* synthetic */ void zza(zzxt zzxt, String str) {
        str.getClass();
        zzxt.zze = str;
    }
}
