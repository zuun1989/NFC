package com.google.android.gms.internal.mlkit_vision_face;

import G6.d;
import G6.e;
import G6.f;
import java.io.IOException;

final class zzhb implements e {
    static final zzhb zza = new zzhb();
    private static final d zzb;
    private static final d zzc;

    static {
        d.b a = d.a("confidence");
        zzcq zzcq = new zzcq();
        zzcq.zza(1);
        zzb = a.b(zzcq.zzb()).a();
        d.b a2 = d.a("languageCode");
        zzcq zzcq2 = new zzcq();
        zzcq2.zza(2);
        zzc = a2.b(zzcq2.zzb()).a();
    }

    private zzhb() {
    }

    public final /* bridge */ /* synthetic */ void encode(Object obj, Object obj2) throws IOException {
        zzky zzky = (zzky) obj;
        f fVar = (f) obj2;
        throw null;
    }
}
