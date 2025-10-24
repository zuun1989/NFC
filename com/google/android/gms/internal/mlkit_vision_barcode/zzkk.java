package com.google.android.gms.internal.mlkit_vision_barcode;

import G6.d;
import G6.e;
import G6.f;
import java.io.IOException;

final class zzkk implements e {
    static final zzkk zza = new zzkk();
    private static final d zzb;
    private static final d zzc;
    private static final d zzd;
    private static final d zze;
    private static final d zzf;
    private static final d zzg;
    private static final d zzh;
    private static final d zzi;
    private static final d zzj;
    private static final d zzk;

    static {
        d.b a = d.a("durationMs");
        zzfa zzfa = new zzfa();
        zzfa.zza(1);
        zzb = a.b(zzfa.zzb()).a();
        d.b a2 = d.a("errorCode");
        zzfa zzfa2 = new zzfa();
        zzfa2.zza(2);
        zzc = a2.b(zzfa2.zzb()).a();
        d.b a3 = d.a("isColdCall");
        zzfa zzfa3 = new zzfa();
        zzfa3.zza(3);
        zzd = a3.b(zzfa3.zzb()).a();
        d.b a4 = d.a("autoManageModelOnBackground");
        zzfa zzfa4 = new zzfa();
        zzfa4.zza(4);
        zze = a4.b(zzfa4.zzb()).a();
        d.b a6 = d.a("autoManageModelOnLowMemory");
        zzfa zzfa5 = new zzfa();
        zzfa5.zza(5);
        zzf = a6.b(zzfa5.zzb()).a();
        d.b a7 = d.a("isNnApiEnabled");
        zzfa zzfa6 = new zzfa();
        zzfa6.zza(6);
        zzg = a7.b(zzfa6.zzb()).a();
        d.b a8 = d.a("eventsCount");
        zzfa zzfa7 = new zzfa();
        zzfa7.zza(7);
        zzh = a8.b(zzfa7.zzb()).a();
        d.b a9 = d.a("otherErrors");
        zzfa zzfa8 = new zzfa();
        zzfa8.zza(8);
        zzi = a9.b(zzfa8.zzb()).a();
        d.b a10 = d.a("remoteConfigValueForAcceleration");
        zzfa zzfa9 = new zzfa();
        zzfa9.zza(9);
        zzj = a10.b(zzfa9.zzb()).a();
        d.b a11 = d.a("isAccelerated");
        zzfa zzfa10 = new zzfa();
        zzfa10.zza(10);
        zzk = a11.b(zzfa10.zzb()).a();
    }

    private zzkk() {
    }

    public final /* bridge */ /* synthetic */ void encode(Object obj, Object obj2) throws IOException {
        zzqq zzqq = (zzqq) obj;
        f fVar = (f) obj2;
        fVar.add(zzb, zzqq.zze());
        fVar.add(zzc, zzqq.zza());
        fVar.add(zzd, zzqq.zzd());
        fVar.add(zze, zzqq.zzb());
        fVar.add(zzf, zzqq.zzc());
        fVar.add(zzg, (Object) null);
        fVar.add(zzh, (Object) null);
        fVar.add(zzi, (Object) null);
        fVar.add(zzj, (Object) null);
        fVar.add(zzk, (Object) null);
    }
}
