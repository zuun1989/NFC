package com.google.android.gms.internal.mlkit_vision_barcode;

import G6.d;
import G6.e;
import G6.f;
import java.io.IOException;

final class zzlf implements e {
    static final zzlf zza = new zzlf();
    private static final d zzb;
    private static final d zzc;
    private static final d zzd;
    private static final d zze;
    private static final d zzf;

    static {
        d.b a = d.a("inferenceCommonLogEvent");
        zzfa zzfa = new zzfa();
        zzfa.zza(1);
        zzb = a.b(zzfa.zzb()).a();
        d.b a2 = d.a("options");
        zzfa zzfa2 = new zzfa();
        zzfa2.zza(2);
        zzc = a2.b(zzfa2.zzb()).a();
        d.b a3 = d.a("detectedBarcodeFormats");
        zzfa zzfa3 = new zzfa();
        zzfa3.zza(3);
        zzd = a3.b(zzfa3.zzb()).a();
        d.b a4 = d.a("detectedBarcodeValueTypes");
        zzfa zzfa4 = new zzfa();
        zzfa4.zza(4);
        zze = a4.b(zzfa4.zzb()).a();
        d.b a6 = d.a("imageInfo");
        zzfa zzfa5 = new zzfa();
        zzfa5.zza(5);
        zzf = a6.b(zzfa5.zzb()).a();
    }

    private zzlf() {
    }

    public final /* bridge */ /* synthetic */ void encode(Object obj, Object obj2) throws IOException {
        zzrr zzrr = (zzrr) obj;
        f fVar = (f) obj2;
        fVar.add(zzb, zzrr.zzd());
        fVar.add(zzc, zzrr.zze());
        fVar.add(zzd, zzrr.zza());
        fVar.add(zze, zzrr.zzb());
        fVar.add(zzf, zzrr.zzc());
    }
}
