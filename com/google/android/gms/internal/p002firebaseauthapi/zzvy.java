package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzalg;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzvy  reason: invalid package */
public final class zzvy extends zzalg<zzvy, zza> implements zzamp {
    /* access modifiers changed from: private */
    public static final zzvy zzc;
    private static volatile zzamw<zzvy> zzd;
    private int zze;
    private zzajw zzf = zzajw.zza;
    private zzxn zzg;

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzvy$zza */
    public static final class zza extends zzalg.zzb<zzvy, zza> implements zzamp {
        public final zza zza() {
            zzg();
            zzvy.zza((zzvy) this.zza);
            return this;
        }

        private zza() {
            super(zzvy.zzc);
        }

        public final zza zza(zzajw zzajw) {
            zzg();
            zzvy.zza((zzvy) this.zza, zzajw);
            return this;
        }

        public final zza zza(zzxn zzxn) {
            zzg();
            zzvy.zza((zzvy) this.zza, zzxn);
            return this;
        }
    }

    static {
        zzvy zzvy = new zzvy();
        zzc = zzvy;
        zzalg.zza(zzvy.class, zzvy);
    }

    private zzvy() {
    }

    public static zza zza() {
        return (zza) zzc.zzm();
    }

    public final zzajw zzc() {
        return this.zzf;
    }

    public static zzvy zza(InputStream inputStream, zzakv zzakv) throws IOException {
        return (zzvy) zzalg.zza(zzc, inputStream, zzakv);
    }

    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzvx.zza[i - 1]) {
            case 1:
                return new zzvy();
            case 2:
                return new zza();
            case 3:
                return zzalg.zza((zzamn) zzc, "\u0000\u0002\u0000\u0001\u0002\u0003\u0002\u0000\u0000\u0000\u0002\n\u0003ဉ\u0000", new Object[]{"zze", "zzf", "zzg"});
            case 4:
                return zzc;
            case 5:
                zzamw<zzvy> zzamw = zzd;
                if (zzamw == null) {
                    synchronized (zzvy.class) {
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

    public static /* synthetic */ void zza(zzvy zzvy) {
        zzvy.zzg = null;
        zzvy.zze &= -2;
    }

    public static /* synthetic */ void zza(zzvy zzvy, zzajw zzajw) {
        zzajw.getClass();
        zzvy.zzf = zzajw;
    }

    public static /* synthetic */ void zza(zzvy zzvy, zzxn zzxn) {
        zzxn.getClass();
        zzvy.zzg = zzxn;
        zzvy.zze |= 1;
    }
}
