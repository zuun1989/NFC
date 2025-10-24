package com.google.android.gms.internal.mlkit_vision_barcode;

import G6.d;
import G6.e;
import G6.f;
import java.io.IOException;

final class zzka implements e {
    static final zzka zza = new zzka();
    private static final d zzb;
    private static final d zzc;
    private static final d zzd;
    private static final d zze;
    private static final d zzf;
    private static final d zzg;

    static {
        d.b a = d.a("maxMs");
        zzfa zzfa = new zzfa();
        zzfa.zza(1);
        zzb = a.b(zzfa.zzb()).a();
        d.b a2 = d.a("minMs");
        zzfa zzfa2 = new zzfa();
        zzfa2.zza(2);
        zzc = a2.b(zzfa2.zzb()).a();
        d.b a3 = d.a("avgMs");
        zzfa zzfa3 = new zzfa();
        zzfa3.zza(3);
        zzd = a3.b(zzfa3.zzb()).a();
        d.b a4 = d.a("firstQuartileMs");
        zzfa zzfa4 = new zzfa();
        zzfa4.zza(4);
        zze = a4.b(zzfa4.zzb()).a();
        d.b a6 = d.a("medianMs");
        zzfa zzfa5 = new zzfa();
        zzfa5.zza(5);
        zzf = a6.b(zzfa5.zzb()).a();
        d.b a7 = d.a("thirdQuartileMs");
        zzfa zzfa6 = new zzfa();
        zzfa6.zza(6);
        zzg = a7.b(zzfa6.zzb()).a();
    }

    private zzka() {
    }

    public final /* bridge */ /* synthetic */ void encode(Object obj, Object obj2) throws IOException {
        zzqd zzqd = (zzqd) obj;
        f fVar = (f) obj2;
        fVar.add(zzb, zzqd.zzc());
        fVar.add(zzc, zzqd.zze());
        fVar.add(zzd, zzqd.zza());
        fVar.add(zze, zzqd.zzb());
        fVar.add(zzf, zzqd.zzd());
        fVar.add(zzg, zzqd.zzf());
    }
}
