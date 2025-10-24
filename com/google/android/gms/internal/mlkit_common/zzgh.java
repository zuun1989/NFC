package com.google.android.gms.internal.mlkit_common;

import G6.d;
import G6.e;
import G6.f;
import java.io.IOException;

final class zzgh implements e {
    static final zzgh zza = new zzgh();
    private static final d zzb;
    private static final d zzc;
    private static final d zzd;

    static {
        d.b a = d.a("modelType");
        zzay zzay = new zzay();
        zzay.zza(1);
        zzb = a.b(zzay.zzb()).a();
        d.b a2 = d.a("isDownloaded");
        zzay zzay2 = new zzay();
        zzay2.zza(2);
        zzc = a2.b(zzay2.zzb()).a();
        d.b a3 = d.a("modelName");
        zzay zzay3 = new zzay();
        zzay3.zza(3);
        zzd = a3.b(zzay3.zzb()).a();
    }

    private zzgh() {
    }

    public final /* bridge */ /* synthetic */ void encode(Object obj, Object obj2) throws IOException {
        zzmj zzmj = (zzmj) obj;
        f fVar = (f) obj2;
        fVar.add(zzb, zzmj.zza());
        fVar.add(zzc, zzmj.zzb());
        fVar.add(zzd, (Object) null);
    }
}
