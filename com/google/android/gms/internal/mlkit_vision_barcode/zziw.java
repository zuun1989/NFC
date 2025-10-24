package com.google.android.gms.internal.mlkit_vision_barcode;

import G6.d;
import G6.e;
import G6.f;
import java.io.IOException;

final class zziw implements e {
    static final zziw zza = new zziw();
    private static final d zzb;

    static {
        d.b a = d.a("format");
        zzfa zzfa = new zzfa();
        zzfa.zza(1);
        zzb = a.b(zzfa.zzb()).a();
    }

    private zziw() {
    }

    public final /* bridge */ /* synthetic */ void encode(Object obj, Object obj2) throws IOException {
        ((f) obj2).add(zzb, ((zzvz) obj).zza());
    }
}
