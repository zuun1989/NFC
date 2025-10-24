package com.google.android.gms.internal.clearcut;

import java.io.IOException;

final class zzez extends zzex<zzey, zzey> {
    public final /* synthetic */ void zza(Object obj, int i, long j) {
        ((zzey) obj).zzb(i << 3, Long.valueOf(j));
    }

    public final void zzc(Object obj) {
        ((zzcg) obj).zzjp.zzv();
    }

    public final /* synthetic */ Object zzdz() {
        return zzey.zzeb();
    }

    public final /* synthetic */ void zze(Object obj, Object obj2) {
        zza(obj, (zzey) obj2);
    }

    public final /* synthetic */ void zzf(Object obj, Object obj2) {
        zza(obj, (zzey) obj2);
    }

    public final /* synthetic */ Object zzg(Object obj, Object obj2) {
        zzey zzey = (zzey) obj;
        zzey zzey2 = (zzey) obj2;
        return zzey2.equals(zzey.zzea()) ? zzey : zzey.zza(zzey, zzey2);
    }

    public final /* synthetic */ int zzm(Object obj) {
        return ((zzey) obj).zzas();
    }

    public final /* synthetic */ Object zzq(Object obj) {
        return ((zzcg) obj).zzjp;
    }

    public final /* synthetic */ int zzr(Object obj) {
        return ((zzey) obj).zzec();
    }

    public final /* synthetic */ void zza(Object obj, int i, zzbb zzbb) {
        ((zzey) obj).zzb((i << 3) | 2, zzbb);
    }

    public final /* synthetic */ void zzc(Object obj, zzfr zzfr) throws IOException {
        ((zzey) obj).zza(zzfr);
    }

    private static void zza(Object obj, zzey zzey) {
        ((zzcg) obj).zzjp = zzey;
    }

    public final /* synthetic */ void zza(Object obj, zzfr zzfr) throws IOException {
        ((zzey) obj).zzb(zzfr);
    }
}
