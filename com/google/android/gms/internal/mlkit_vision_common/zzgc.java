package com.google.android.gms.internal.mlkit_vision_common;

import G6.d;
import G6.e;
import G6.f;
import java.io.IOException;

final class zzgc implements e {
    static final zzgc zza = new zzgc();
    private static final d zzb;
    private static final d zzc;
    private static final d zzd;
    private static final d zze;
    private static final d zzf;
    private static final d zzg;

    static {
        d.b a = d.a("inferenceCommonLogEvent");
        zzae zzae = new zzae();
        zzae.zza(1);
        zzb = a.b(zzae.zzb()).a();
        d.b a2 = d.a("imageInfo");
        zzae zzae2 = new zzae();
        zzae2.zza(2);
        zzc = a2.b(zzae2.zzb()).a();
        d.b a3 = d.a("detectorOptions");
        zzae zzae3 = new zzae();
        zzae3.zza(3);
        zzd = a3.b(zzae3.zzb()).a();
        d.b a4 = d.a("loadDurationMs");
        zzae zzae4 = new zzae();
        zzae4.zza(4);
        zze = a4.b(zzae4.zzb()).a();
        d.b a6 = d.a("sessionDurationMs");
        zzae zzae5 = new zzae();
        zzae5.zza(5);
        zzf = a6.b(zzae5.zzb()).a();
        d.b a7 = d.a("sessionTotalInferenceDurationMs");
        zzae zzae6 = new zzae();
        zzae6.zza(6);
        zzg = a7.b(zzae6.zzb()).a();
    }

    private zzgc() {
    }

    public final /* bridge */ /* synthetic */ void encode(Object obj, Object obj2) throws IOException {
        zzkk zzkk = (zzkk) obj;
        f fVar = (f) obj2;
        throw null;
    }
}
