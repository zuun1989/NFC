package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzalg;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzvg  reason: invalid package */
public final class zzvg extends zzalg<zzvg, zza> implements zzamp {
    /* access modifiers changed from: private */
    public static final zzvg zzc;
    private static volatile zzamw<zzvg> zzd;
    private int zze;
    private zzvj zzf;

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzvg$zza */
    public static final class zza extends zzalg.zzb<zzvg, zza> implements zzamp {
        public final zza zza(zzvj zzvj) {
            zzg();
            zzvg.zza((zzvg) this.zza, zzvj);
            return this;
        }

        private zza() {
            super(zzvg.zzc);
        }
    }

    static {
        zzvg zzvg = new zzvg();
        zzc = zzvg;
        zzalg.zza(zzvg.class, zzvg);
    }

    private zzvg() {
    }

    public static zza zza() {
        return (zza) zzc.zzm();
    }

    public final zzvj zzc() {
        zzvj zzvj = this.zzf;
        if (zzvj == null) {
            return zzvj.zze();
        }
        return zzvj;
    }

    public static zzvg zza(zzajw zzajw, zzakv zzakv) throws zzalm {
        return (zzvg) zzalg.zza(zzc, zzajw, zzakv);
    }

    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzvi.zza[i - 1]) {
            case 1:
                return new zzvg();
            case 2:
                return new zza();
            case 3:
                return zzalg.zza((zzamn) zzc, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"zze", "zzf"});
            case 4:
                return zzc;
            case 5:
                zzamw<zzvg> zzamw = zzd;
                if (zzamw == null) {
                    synchronized (zzvg.class) {
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

    public static /* synthetic */ void zza(zzvg zzvg, zzvj zzvj) {
        zzvj.getClass();
        zzvg.zzf = zzvj;
        zzvg.zze |= 1;
    }
}
