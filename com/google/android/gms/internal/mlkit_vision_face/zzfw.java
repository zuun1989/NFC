package com.google.android.gms.internal.mlkit_vision_face;

import G6.d;
import G6.e;
import G6.f;
import java.io.IOException;

final class zzfw implements e {
    static final zzfw zza = new zzfw();
    private static final d zzb;
    private static final d zzc;
    private static final d zzd;
    private static final d zze;
    private static final d zzf;
    private static final d zzg;

    static {
        d.b a = d.a("landmarkMode");
        zzcq zzcq = new zzcq();
        zzcq.zza(1);
        zzb = a.b(zzcq.zzb()).a();
        d.b a2 = d.a("classificationMode");
        zzcq zzcq2 = new zzcq();
        zzcq2.zza(2);
        zzc = a2.b(zzcq2.zzb()).a();
        d.b a3 = d.a("performanceMode");
        zzcq zzcq3 = new zzcq();
        zzcq3.zza(3);
        zzd = a3.b(zzcq3.zzb()).a();
        d.b a4 = d.a("contourMode");
        zzcq zzcq4 = new zzcq();
        zzcq4.zza(4);
        zze = a4.b(zzcq4.zzb()).a();
        d.b a6 = d.a("isTrackingEnabled");
        zzcq zzcq5 = new zzcq();
        zzcq5.zza(5);
        zzf = a6.b(zzcq5.zzb()).a();
        d.b a7 = d.a("minFaceSize");
        zzcq zzcq6 = new zzcq();
        zzcq6.zza(6);
        zzg = a7.b(zzcq6.zzb()).a();
    }

    private zzfw() {
    }

    public final /* bridge */ /* synthetic */ void encode(Object obj, Object obj2) throws IOException {
        zzjl zzjl = (zzjl) obj;
        f fVar = (f) obj2;
        fVar.add(zzb, zzjl.zzc());
        fVar.add(zzc, zzjl.zza());
        fVar.add(zzd, zzjl.zzd());
        fVar.add(zze, zzjl.zzb());
        fVar.add(zzf, zzjl.zze());
        fVar.add(zzg, zzjl.zzf());
    }
}
