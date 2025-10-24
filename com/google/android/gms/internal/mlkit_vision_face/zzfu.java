package com.google.android.gms.internal.mlkit_vision_face;

import G6.d;
import G6.e;
import G6.f;
import java.io.IOException;

final class zzfu implements e {
    static final zzfu zza = new zzfu();
    private static final d zzb;
    private static final d zzc;
    private static final d zzd;
    private static final d zze;
    private static final d zzf;
    private static final d zzg;

    static {
        d.b a = d.a("maxMs");
        zzcq zzcq = new zzcq();
        zzcq.zza(1);
        zzb = a.b(zzcq.zzb()).a();
        d.b a2 = d.a("minMs");
        zzcq zzcq2 = new zzcq();
        zzcq2.zza(2);
        zzc = a2.b(zzcq2.zzb()).a();
        d.b a3 = d.a("avgMs");
        zzcq zzcq3 = new zzcq();
        zzcq3.zza(3);
        zzd = a3.b(zzcq3.zzb()).a();
        d.b a4 = d.a("firstQuartileMs");
        zzcq zzcq4 = new zzcq();
        zzcq4.zza(4);
        zze = a4.b(zzcq4.zzb()).a();
        d.b a6 = d.a("medianMs");
        zzcq zzcq5 = new zzcq();
        zzcq5.zza(5);
        zzf = a6.b(zzcq5.zzb()).a();
        d.b a7 = d.a("thirdQuartileMs");
        zzcq zzcq6 = new zzcq();
        zzcq6.zza(6);
        zzg = a7.b(zzcq6.zzb()).a();
    }

    private zzfu() {
    }

    public final /* bridge */ /* synthetic */ void encode(Object obj, Object obj2) throws IOException {
        zzjd zzjd = (zzjd) obj;
        f fVar = (f) obj2;
        fVar.add(zzb, zzjd.zzc());
        fVar.add(zzc, zzjd.zze());
        fVar.add(zzd, zzjd.zza());
        fVar.add(zze, zzjd.zzb());
        fVar.add(zzf, zzjd.zzd());
        fVar.add(zzg, zzjd.zzf());
    }
}
