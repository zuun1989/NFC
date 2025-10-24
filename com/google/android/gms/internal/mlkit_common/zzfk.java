package com.google.android.gms.internal.mlkit_common;

import G6.d;
import G6.e;
import G6.f;
import java.io.IOException;

final class zzfk implements e {
    static final zzfk zza = new zzfk();
    private static final d zzb;
    private static final d zzc;
    private static final d zzd;

    static {
        d.b a = d.a("modelType");
        zzay zzay = new zzay();
        zzay.zza(1);
        zzb = a.b(zzay.zzb()).a();
        d.b a2 = d.a("isSuccessful");
        zzay zzay2 = new zzay();
        zzay2.zza(2);
        zzc = a2.b(zzay2.zzb()).a();
        d.b a3 = d.a("modelName");
        zzay zzay3 = new zzay();
        zzay3.zza(3);
        zzd = a3.b(zzay3.zzb()).a();
    }

    private zzfk() {
    }

    public final /* bridge */ /* synthetic */ void encode(Object obj, Object obj2) throws IOException {
        zzlo zzlo = (zzlo) obj;
        f fVar = (f) obj2;
        fVar.add(zzb, zzlo.zza());
        fVar.add(zzc, zzlo.zzb());
        fVar.add(zzd, (Object) null);
    }
}
