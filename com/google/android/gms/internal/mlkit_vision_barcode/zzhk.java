package com.google.android.gms.internal.mlkit_vision_barcode;

import G6.d;
import G6.e;
import G6.f;
import java.io.IOException;

final class zzhk implements e {
    static final zzhk zza = new zzhk();
    private static final d zzb;
    private static final d zzc;
    private static final d zzd;

    static {
        d.b a = d.a("logEventKey");
        zzfa zzfa = new zzfa();
        zzfa.zza(1);
        zzb = a.b(zzfa.zzb()).a();
        d.b a2 = d.a("eventCount");
        zzfa zzfa2 = new zzfa();
        zzfa2.zza(2);
        zzc = a2.b(zzfa2.zzb()).a();
        d.b a3 = d.a("inferenceDurationStats");
        zzfa zzfa3 = new zzfa();
        zzfa3.zza(3);
        zzd = a3.b(zzfa3.zzb()).a();
    }

    private zzhk() {
    }

    public final /* bridge */ /* synthetic */ void encode(Object obj, Object obj2) throws IOException {
        zzfv zzfv = (zzfv) obj;
        f fVar = (f) obj2;
        fVar.add(zzb, zzfv.zza());
        fVar.add(zzc, zzfv.zzc());
        fVar.add(zzd, zzfv.zzb());
    }
}
