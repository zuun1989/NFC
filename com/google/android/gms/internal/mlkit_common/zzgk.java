package com.google.android.gms.internal.mlkit_common;

import G6.d;
import G6.e;
import G6.f;
import java.io.IOException;

final class zzgk implements e {
    static final zzgk zza = new zzgk();
    private static final d zzb;

    static {
        d.b a = d.a("api");
        zzay zzay = new zzay();
        zzay.zza(1);
        zzb = a.b(zzay.zzb()).a();
    }

    private zzgk() {
    }

    public final /* bridge */ /* synthetic */ void encode(Object obj, Object obj2) throws IOException {
        ((f) obj2).add(zzb, ((zzmp) obj).zza());
    }
}
