package com.google.android.gms.internal.mlkit_vision_face;

import G6.d;
import G6.e;
import G6.f;
import java.io.IOException;

final class zzhp implements e {
    static final zzhp zza = new zzhp();
    private static final d zzb;
    private static final d zzc;
    private static final d zzd;

    static {
        d.b a = d.a("languageOption");
        zzcq zzcq = new zzcq();
        zzcq.zza(3);
        zzb = a.b(zzcq.zzb()).a();
        d.b a2 = d.a("isUsingLegacyApi");
        zzcq zzcq2 = new zzcq();
        zzcq2.zza(4);
        zzc = a2.b(zzcq2.zzb()).a();
        d.b a3 = d.a("sdkVersion");
        zzcq zzcq3 = new zzcq();
        zzcq3.zza(5);
        zzd = a3.b(zzcq3.zzb()).a();
    }

    private zzhp() {
    }

    public final /* bridge */ /* synthetic */ void encode(Object obj, Object obj2) throws IOException {
        zzln zzln = (zzln) obj;
        f fVar = (f) obj2;
        throw null;
    }
}
