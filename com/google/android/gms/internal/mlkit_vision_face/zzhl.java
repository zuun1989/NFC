package com.google.android.gms.internal.mlkit_vision_face;

import G6.d;
import G6.e;
import G6.f;
import java.io.IOException;

final class zzhl implements e {
    static final zzhl zza = new zzhl();
    private static final d zzb;
    private static final d zzc;
    private static final d zzd;

    static {
        d.b a = d.a("detectorMode");
        zzcq zzcq = new zzcq();
        zzcq.zza(1);
        zzb = a.b(zzcq.zzb()).a();
        d.b a2 = d.a("streamModeSmoothingRatio");
        zzcq zzcq2 = new zzcq();
        zzcq2.zza(2);
        zzc = a2.b(zzcq2.zzb()).a();
        d.b a3 = d.a("rawSizeMaskEnabled");
        zzcq zzcq3 = new zzcq();
        zzcq3.zza(3);
        zzd = a3.b(zzcq3.zzb()).a();
    }

    private zzhl() {
    }

    public final /* bridge */ /* synthetic */ void encode(Object obj, Object obj2) throws IOException {
        zzlj zzlj = (zzlj) obj;
        f fVar = (f) obj2;
        throw null;
    }
}
