package com.google.android.gms.internal.mlkit_vision_face;

import G6.d;
import G6.e;
import G6.f;
import java.io.IOException;

final class zzgv implements e {
    static final zzgv zza = new zzgv();
    private static final d zzb;

    static {
        d.b a = d.a("errorCode");
        zzcq zzcq = new zzcq();
        zzcq.zza(1);
        zzb = a.b(zzcq.zzb()).a();
    }

    private zzgv() {
    }

    public final /* bridge */ /* synthetic */ void encode(Object obj, Object obj2) throws IOException {
        ((f) obj2).add(zzb, ((zzkt) obj).zza());
    }
}
