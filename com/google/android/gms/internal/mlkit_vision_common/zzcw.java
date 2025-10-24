package com.google.android.gms.internal.mlkit_vision_common;

import G6.d;
import G6.e;
import G6.f;
import java.io.IOException;

final class zzcw implements e {
    static final zzcw zza = new zzcw();
    private static final d zzb;
    private static final d zzc;
    private static final d zzd;
    private static final d zze;

    static {
        d.b a = d.a("remoteModelOptions");
        zzae zzae = new zzae();
        zzae.zza(1);
        zzb = a.b(zzae.zzb()).a();
        d.b a2 = d.a("localModelOptions");
        zzae zzae2 = new zzae();
        zzae2.zza(2);
        zzc = a2.b(zzae2.zzb()).a();
        d.b a3 = d.a("errorCodes");
        zzae zzae3 = new zzae();
        zzae3.zza(3);
        zzd = a3.b(zzae3.zzb()).a();
        d.b a4 = d.a("modelInitializationMs");
        zzae zzae4 = new zzae();
        zzae4.zza(4);
        zze = a4.b(zzae4.zzb()).a();
    }

    private zzcw() {
    }

    public final /* bridge */ /* synthetic */ void encode(Object obj, Object obj2) throws IOException {
        zzbs zzbs = (zzbs) obj;
        f fVar = (f) obj2;
        throw null;
    }
}
