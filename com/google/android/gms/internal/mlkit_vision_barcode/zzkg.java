package com.google.android.gms.internal.mlkit_vision_barcode;

import G6.d;
import G6.e;
import G6.f;
import java.io.IOException;

final class zzkg implements e {
    static final zzkg zza = new zzkg();
    private static final d zzb;
    private static final d zzc;
    private static final d zzd;
    private static final d zze;

    static {
        d.b a = d.a("imageFormat");
        zzfa zzfa = new zzfa();
        zzfa.zza(1);
        zzb = a.b(zzfa.zzb()).a();
        d.b a2 = d.a("originalImageSize");
        zzfa zzfa2 = new zzfa();
        zzfa2.zza(2);
        zzc = a2.b(zzfa2.zzb()).a();
        d.b a3 = d.a("compressedImageSize");
        zzfa zzfa3 = new zzfa();
        zzfa3.zza(3);
        zzd = a3.b(zzfa3.zzb()).a();
        d.b a4 = d.a("isOdmlImage");
        zzfa zzfa4 = new zzfa();
        zzfa4.zza(4);
        zze = a4.b(zzfa4.zzb()).a();
    }

    private zzkg() {
    }

    public final /* bridge */ /* synthetic */ void encode(Object obj, Object obj2) throws IOException {
        zzqk zzqk = (zzqk) obj;
        f fVar = (f) obj2;
        fVar.add(zzb, zzqk.zza());
        fVar.add(zzc, zzqk.zzb());
        fVar.add(zzd, (Object) null);
        fVar.add(zze, (Object) null);
    }
}
