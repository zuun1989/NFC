package com.google.android.gms.internal.mlkit_common;

import G6.d;
import G6.e;
import G6.f;
import java.io.IOException;

final class zzgs implements e {
    static final zzgs zza = new zzgs();
    private static final d zzb;
    private static final d zzc;
    private static final d zzd;
    private static final d zze;

    static {
        d.b a = d.a("modelInfo");
        zzay zzay = new zzay();
        zzay.zza(1);
        zzb = a.b(zzay.zzb()).a();
        d.b a2 = d.a("initialDownloadConditions");
        zzay zzay2 = new zzay();
        zzay2.zza(2);
        zzc = a2.b(zzay2.zzb()).a();
        d.b a3 = d.a("updateDownloadConditions");
        zzay zzay3 = new zzay();
        zzay3.zza(3);
        zzd = a3.b(zzay3.zzb()).a();
        d.b a4 = d.a("isModelUpdateEnabled");
        zzay zzay4 = new zzay();
        zzay4.zza(4);
        zze = a4.b(zzay4.zzb()).a();
    }

    private zzgs() {
    }

    public final /* bridge */ /* synthetic */ void encode(Object obj, Object obj2) throws IOException {
        f fVar = (f) obj2;
        fVar.add(zzb, ((zznl) obj).zza());
        fVar.add(zzc, (Object) null);
        fVar.add(zzd, (Object) null);
        fVar.add(zze, (Object) null);
    }
}
