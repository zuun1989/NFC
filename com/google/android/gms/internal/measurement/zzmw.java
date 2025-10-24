package com.google.android.gms.internal.measurement;

public class zzmw {
    protected volatile zznm zza;
    private volatile zzlh zzb;
    private volatile boolean zzc;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzmw)) {
            return false;
        }
        zzmw zzmw = (zzmw) obj;
        zznm zznm = this.zza;
        zznm zznm2 = zzmw.zza;
        if (zznm == null && zznm2 == null) {
            return zzc().equals(zzmw.zzc());
        }
        if (zznm != null && zznm2 != null) {
            return zznm.equals(zznm2);
        }
        if (zznm != null) {
            zzmw.zzd(zznm.zzcE());
            return zznm.equals(zzmw.zza);
        }
        zzd(zznm2.zzcE());
        return this.zza.equals(zznm2);
    }

    public int hashCode() {
        return 1;
    }

    public final zznm zza(zznm zznm) {
        zznm zznm2 = this.zza;
        this.zzb = null;
        this.zza = zznm;
        return zznm2;
    }

    public final int zzb() {
        if (this.zzb != null) {
            return ((zzlg) this.zzb).zza.length;
        }
        if (this.zza != null) {
            return this.zza.zzcn();
        }
        return 0;
    }

    public final zzlh zzc() {
        if (this.zzb != null) {
            return this.zzb;
        }
        synchronized (this) {
            try {
                if (this.zzb != null) {
                    zzlh zzlh = this.zzb;
                    return zzlh;
                }
                if (this.zza == null) {
                    this.zzb = zzlh.zzb;
                } else {
                    this.zzb = this.zza.zzcb();
                }
                zzlh zzlh2 = this.zzb;
                return zzlh2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void zzd(zznm zznm) {
        if (this.zza == null) {
            synchronized (this) {
                if (this.zza == null) {
                    try {
                        this.zza = zznm;
                        this.zzb = zzlh.zzb;
                    } catch (zzmr unused) {
                        this.zzc = true;
                        this.zza = zznm;
                        this.zzb = zzlh.zzb;
                    }
                }
            }
        }
    }
}
