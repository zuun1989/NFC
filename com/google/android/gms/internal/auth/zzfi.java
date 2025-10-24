package com.google.android.gms.internal.auth;

final class zzfi extends zzfk {
    public /* synthetic */ zzfi(zzfh zzfh) {
        super((zzfj) null);
    }

    public final void zza(Object obj, long j) {
        ((zzey) zzhi.zzf(obj, j)).zzb();
    }

    public final void zzb(Object obj, Object obj2, long j) {
        zzey zzey = (zzey) zzhi.zzf(obj, j);
        zzey zzey2 = (zzey) zzhi.zzf(obj2, j);
        int size = zzey.size();
        int size2 = zzey2.size();
        if (size > 0 && size2 > 0) {
            if (!zzey.zzc()) {
                zzey = zzey.zzd(size2 + size);
            }
            zzey.addAll(zzey2);
        }
        if (size > 0) {
            zzey2 = zzey;
        }
        zzhi.zzp(obj, j, zzey2);
    }

    private zzfi() {
        super((zzfj) null);
    }
}
