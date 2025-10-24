package com.google.android.gms.internal.mlkit_vision_common;

import G6.d;
import G6.e;
import G6.f;
import java.io.IOException;

final class zzej implements e {
    static final zzej zza = new zzej();
    private static final d zzb;
    private static final d zzc;
    private static final d zzd;
    private static final d zze;
    private static final d zzf;
    private static final d zzg;
    private static final d zzh;

    static {
        d.b a = d.a("durationMs");
        zzae zzae = new zzae();
        zzae.zza(1);
        zzb = a.b(zzae.zzb()).a();
        d.b a2 = d.a("imageSource");
        zzae zzae2 = new zzae();
        zzae2.zza(2);
        zzc = a2.b(zzae2.zzb()).a();
        d.b a3 = d.a("imageFormat");
        zzae zzae3 = new zzae();
        zzae3.zza(3);
        zzd = a3.b(zzae3.zzb()).a();
        d.b a4 = d.a("imageByteSize");
        zzae zzae4 = new zzae();
        zzae4.zza(4);
        zze = a4.b(zzae4.zzb()).a();
        d.b a6 = d.a("imageWidth");
        zzae zzae5 = new zzae();
        zzae5.zza(5);
        zzf = a6.b(zzae5.zzb()).a();
        d.b a7 = d.a("imageHeight");
        zzae zzae6 = new zzae();
        zzae6.zza(6);
        zzg = a7.b(zzae6.zzb()).a();
        d.b a8 = d.a("rotationDegrees");
        zzae zzae7 = new zzae();
        zzae7.zza(7);
        zzh = a8.b(zzae7.zzb()).a();
    }

    private zzej() {
    }

    public final /* bridge */ /* synthetic */ void encode(Object obj, Object obj2) throws IOException {
        zziq zziq = (zziq) obj;
        f fVar = (f) obj2;
        fVar.add(zzb, zziq.zzg());
        fVar.add(zzc, zziq.zzb());
        fVar.add(zzd, zziq.zza());
        fVar.add(zze, zziq.zzc());
        fVar.add(zzf, zziq.zze());
        fVar.add(zzg, zziq.zzd());
        fVar.add(zzh, zziq.zzf());
    }
}
