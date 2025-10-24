package com.google.android.gms.internal.p002firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzalv  reason: invalid package */
public class zzalv {
    private volatile zzamn zza;
    private volatile zzajw zzb;
    private volatile boolean zzc;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzalv)) {
            return false;
        }
        zzalv zzalv = (zzalv) obj;
        zzamn zzamn = this.zza;
        zzamn zzamn2 = zzalv.zza;
        if (zzamn == null && zzamn2 == null) {
            return zzb().equals(zzalv.zzb());
        }
        if (zzamn != null && zzamn2 != null) {
            return zzamn.equals(zzamn2);
        }
        if (zzamn != null) {
            return zzamn.equals(zzalv.zzb(zzamn.zzs()));
        }
        return zzb(zzamn2.zzs()).equals(zzamn2);
    }

    public int hashCode() {
        return 1;
    }

    public final int zza() {
        if (this.zzb != null) {
            return this.zzb.zzb();
        }
        if (this.zza != null) {
            return this.zza.zzl();
        }
        return 0;
    }

    public final zzajw zzb() {
        if (this.zzb != null) {
            return this.zzb;
        }
        synchronized (this) {
            try {
                if (this.zzb != null) {
                    zzajw zzajw = this.zzb;
                    return zzajw;
                }
                if (this.zza == null) {
                    this.zzb = zzajw.zza;
                } else {
                    this.zzb = this.zza.zzj();
                }
                zzajw zzajw2 = this.zzb;
                return zzajw2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final zzamn zza(zzamn zzamn) {
        zzamn zzamn2 = this.zza;
        this.zzb = null;
        this.zza = zzamn;
        return zzamn2;
    }

    private final zzamn zzb(zzamn zzamn) {
        if (this.zza == null) {
            synchronized (this) {
                if (this.zza == null) {
                    try {
                        this.zza = zzamn;
                        this.zzb = zzajw.zza;
                    } catch (zzalm unused) {
                        this.zzc = true;
                        this.zza = zzamn;
                        this.zzb = zzajw.zza;
                    }
                }
            }
        }
        return this.zza;
    }
}
