package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzalg;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzant  reason: invalid package */
public final class zzant extends zzalg<zzant, zza> implements zzamp {
    /* access modifiers changed from: private */
    public static final zzant zzc;
    private static volatile zzamw<zzant> zzd;
    /* access modifiers changed from: private */
    public long zze;
    /* access modifiers changed from: private */
    public int zzf;

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzant$zza */
    public static final class zza extends zzalg.zzb<zzant, zza> implements zzamp {
        public final zza zza(int i) {
            if (!this.zza.zzw()) {
                zzh();
            }
            ((zzant) this.zza).zzf = i;
            return this;
        }

        private zza() {
            super(zzant.zzc);
        }

        public final zza zza(long j) {
            if (!this.zza.zzw()) {
                zzh();
            }
            ((zzant) this.zza).zze = j;
            return this;
        }
    }

    static {
        zzant zzant = new zzant();
        zzc = zzant;
        zzalg.zza(zzant.class, zzant);
    }

    private zzant() {
    }

    public static zza zzc() {
        return (zza) zzc.zzm();
    }

    public final int zza() {
        return this.zzf;
    }

    public final long zzb() {
        return this.zze;
    }

    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzans.zza[i - 1]) {
            case 1:
                return new zzant();
            case 2:
                return new zza();
            case 3:
                return zzalg.zza((zzamn) zzc, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0002\u0002\u0004", new Object[]{"zze", "zzf"});
            case 4:
                return zzc;
            case 5:
                zzamw<zzant> zzamw = zzd;
                if (zzamw == null) {
                    synchronized (zzant.class) {
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
