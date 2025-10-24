package com.google.android.gms.internal.mlkit_vision_barcode;

import G6.d;
import G6.e;
import G6.f;
import java.io.IOException;

final class zzoe implements e {
    static final zzoe zza = new zzoe();
    private static final d zzb;
    private static final d zzc;
    private static final d zzd;
    private static final d zze;
    private static final d zzf;
    private static final d zzg;

    static {
        d.b a = d.a("appName");
        zzfa zzfa = new zzfa();
        zzfa.zza(1);
        zzb = a.b(zzfa.zzb()).a();
        d.b a2 = d.a("sessionId");
        zzfa zzfa2 = new zzfa();
        zzfa2.zza(2);
        zzc = a2.b(zzfa2.zzb()).a();
        d.b a3 = d.a("startZoomLevel");
        zzfa zzfa3 = new zzfa();
        zzfa3.zza(3);
        zzd = a3.b(zzfa3.zzb()).a();
        d.b a4 = d.a("endZoomLevel");
        zzfa zzfa4 = new zzfa();
        zzfa4.zza(4);
        zze = a4.b(zzfa4.zzb()).a();
        d.b a6 = d.a("durationMs");
        zzfa zzfa5 = new zzfa();
        zzfa5.zza(5);
        zzf = a6.b(zzfa5.zzb()).a();
        d.b a7 = d.a("predictedArea");
        zzfa zzfa6 = new zzfa();
        zzfa6.zza(6);
        zzg = a7.b(zzfa6.zzb()).a();
    }

    private zzoe() {
    }

    public final /* bridge */ /* synthetic */ void encode(Object obj, Object obj2) throws IOException {
        zzut zzut = (zzut) obj;
        f fVar = (f) obj2;
        fVar.add(zzb, zzut.zze());
        fVar.add(zzc, zzut.zzf());
        fVar.add(zzd, zzut.zzc());
        fVar.add(zze, zzut.zzb());
        fVar.add(zzf, zzut.zzd());
        fVar.add(zzg, zzut.zza());
    }
}
