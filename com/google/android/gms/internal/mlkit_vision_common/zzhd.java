package com.google.android.gms.internal.mlkit_vision_common;

import G6.d;
import G6.e;
import G6.f;
import java.io.IOException;

final class zzhd implements e {
    static final zzhd zza = new zzhd();
    private static final d zzb;
    private static final d zzc;
    private static final d zzd;

    static {
        d.b a = d.a("numSamples");
        zzae zzae = new zzae();
        zzae.zza(1);
        zzb = a.b(zzae.zzb()).a();
        d.b a2 = d.a("errorCode");
        zzae zzae2 = new zzae();
        zzae2.zza(2);
        zzc = a2.b(zzae2.zzb()).a();
        d.b a3 = d.a("metricResults");
        zzae zzae3 = new zzae();
        zzae3.zza(3);
        zzd = a3.b(zzae3.zzb()).a();
    }

    private zzhd() {
    }

    public final /* bridge */ /* synthetic */ void encode(Object obj, Object obj2) throws IOException {
        zzlr zzlr = (zzlr) obj;
        f fVar = (f) obj2;
        throw null;
    }
}
