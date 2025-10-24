package com.google.android.gms.internal.mlkit_vision_common;

import G6.d;
import G6.e;
import G6.f;
import java.io.IOException;

final class zzgf implements e {
    static final zzgf zza = new zzgf();
    private static final d zzb;
    private static final d zzc;
    private static final d zzd;

    static {
        d.b a = d.a("detectorMode");
        zzae zzae = new zzae();
        zzae.zza(1);
        zzb = a.b(zzae.zzb()).a();
        d.b a2 = d.a("streamModeSmoothingRatio");
        zzae zzae2 = new zzae();
        zzae2.zza(2);
        zzc = a2.b(zzae2.zzb()).a();
        d.b a3 = d.a("rawSizeMaskEnabled");
        zzae zzae3 = new zzae();
        zzae3.zza(3);
        zzd = a3.b(zzae3.zzb()).a();
    }

    private zzgf() {
    }

    public final /* bridge */ /* synthetic */ void encode(Object obj, Object obj2) throws IOException {
        zzkn zzkn = (zzkn) obj;
        f fVar = (f) obj2;
        throw null;
    }
}
