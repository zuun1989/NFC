package com.google.android.gms.internal.mlkit_vision_face;

import G6.d;
import G6.e;
import G6.f;
import java.io.IOException;

final class zzhh implements e {
    static final zzhh zza = new zzhh();
    private static final d zzb;
    private static final d zzc;
    private static final d zzd;
    private static final d zze;
    private static final d zzf;

    static {
        d.b a = d.a("detectorOptions");
        zzcq zzcq = new zzcq();
        zzcq.zza(1);
        zzb = a.b(zzcq.zzb()).a();
        d.b a2 = d.a("errorCode");
        zzcq zzcq2 = new zzcq();
        zzcq2.zza(2);
        zzc = a2.b(zzcq2.zzb()).a();
        d.b a3 = d.a("totalInitializationMs");
        zzcq zzcq3 = new zzcq();
        zzcq3.zza(3);
        zzd = a3.b(zzcq3.zzb()).a();
        d.b a4 = d.a("loggingInitializationMs");
        zzcq zzcq4 = new zzcq();
        zzcq4.zza(4);
        zze = a4.b(zzcq4.zzb()).a();
        d.b a6 = d.a("otherErrors");
        zzcq zzcq5 = new zzcq();
        zzcq5.zza(5);
        zzf = a6.b(zzcq5.zzb()).a();
    }

    private zzhh() {
    }

    public final /* bridge */ /* synthetic */ void encode(Object obj, Object obj2) throws IOException {
        zzlf zzlf = (zzlf) obj;
        f fVar = (f) obj2;
        throw null;
    }
}
