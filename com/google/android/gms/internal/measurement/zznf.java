package com.google.android.gms.internal.measurement;

import java.io.IOException;

public final class zznf {
    private final zzne zza;

    private zznf(zzot zzot, Object obj, zzot zzot2, Object obj2) {
        this.zza = new zzne(zzot, "", zzot2, "");
    }

    public static zznf zza(zzot zzot, Object obj, zzot zzot2, Object obj2) {
        return new zznf(zzot, "", zzot2, "");
    }

    public static void zzb(zzlm zzlm, zzne zzne, Object obj, Object obj2) throws IOException {
        zzlw.zzf(zzlm, zzne.zza, 1, obj);
        zzlw.zzf(zzlm, zzne.zzc, 2, obj2);
    }

    public static int zzc(zzne zzne, Object obj, Object obj2) {
        return zzlw.zzh(zzne.zza, 1, obj) + zzlw.zzh(zzne.zzc, 2, obj2);
    }

    public final int zzd(int i, Object obj, Object obj2) {
        zzne zzne = this.zza;
        int zzz = zzlm.zzz(i << 3);
        int zzc = zzc(zzne, obj, obj2);
        return zzz + zzlm.zzz(zzc) + zzc;
    }

    public final zzne zze() {
        return this.zza;
    }
}
