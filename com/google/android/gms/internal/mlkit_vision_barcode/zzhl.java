package com.google.android.gms.internal.mlkit_vision_barcode;

import G6.d;
import G6.e;
import G6.f;
import java.io.IOException;

final class zzhl implements e {
    static final zzhl zza = new zzhl();
    private static final d zzb;
    private static final d zzc;
    private static final d zzd;
    private static final d zze;
    private static final d zzf;
    private static final d zzg;
    private static final d zzh;

    static {
        d.b a = d.a("errorCode");
        zzfa zzfa = new zzfa();
        zzfa.zza(1);
        zzb = a.b(zzfa.zzb()).a();
        d.b a2 = d.a("hasResult");
        zzfa zzfa2 = new zzfa();
        zzfa2.zza(2);
        zzc = a2.b(zzfa2.zzb()).a();
        d.b a3 = d.a("isColdCall");
        zzfa zzfa3 = new zzfa();
        zzfa3.zza(3);
        zzd = a3.b(zzfa3.zzb()).a();
        d.b a4 = d.a("imageInfo");
        zzfa zzfa4 = new zzfa();
        zzfa4.zza(4);
        zze = a4.b(zzfa4.zzb()).a();
        d.b a6 = d.a("options");
        zzfa zzfa5 = new zzfa();
        zzfa5.zza(5);
        zzf = a6.b(zzfa5.zzb()).a();
        d.b a7 = d.a("detectedBarcodeFormats");
        zzfa zzfa6 = new zzfa();
        zzfa6.zza(6);
        zzg = a7.b(zzfa6.zzb()).a();
        d.b a8 = d.a("detectedBarcodeValueTypes");
        zzfa zzfa7 = new zzfa();
        zzfa7.zza(7);
        zzh = a8.b(zzfa7.zzb()).a();
    }

    private zzhl() {
    }

    public final /* bridge */ /* synthetic */ void encode(Object obj, Object obj2) throws IOException {
        zzft zzft = (zzft) obj;
        f fVar = (f) obj2;
        fVar.add(zzb, zzft.zzc());
        fVar.add(zzc, (Object) null);
        fVar.add(zzd, zzft.zze());
        fVar.add(zze, (Object) null);
        fVar.add(zzf, zzft.zzd());
        fVar.add(zzg, zzft.zza());
        fVar.add(zzh, zzft.zzb());
    }
}
