package com.google.android.gms.internal.mlkit_vision_face;

import G6.d;
import G6.e;
import G6.f;
import java.io.IOException;

final class zzgb implements e {
    static final zzgb zza = new zzgb();
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
        zzcq zzcq = new zzcq();
        zzcq.zza(1);
        zzb = a.b(zzcq.zzb()).a();
        d.b a2 = d.a("errorCode");
        zzcq zzcq2 = new zzcq();
        zzcq2.zza(2);
        zzc = a2.b(zzcq2.zzb()).a();
        d.b a3 = d.a("isColdCall");
        zzcq zzcq3 = new zzcq();
        zzcq3.zza(3);
        zzd = a3.b(zzcq3.zzb()).a();
        d.b a4 = d.a("autoManageModelOnBackground");
        zzcq zzcq4 = new zzcq();
        zzcq4.zza(4);
        zze = a4.b(zzcq4.zzb()).a();
        d.b a6 = d.a("autoManageModelOnLowMemory");
        zzcq zzcq5 = new zzcq();
        zzcq5.zza(5);
        zzf = a6.b(zzcq5.zzb()).a();
        d.b a7 = d.a("isNnApiEnabled");
        zzcq zzcq6 = new zzcq();
        zzcq6.zza(6);
        zzg = a7.b(zzcq6.zzb()).a();
        d.b a8 = d.a("eventsCount");
        zzcq zzcq7 = new zzcq();
        zzcq7.zza(7);
        zzh = a8.b(zzcq7.zzb()).a();
        d.b a9 = d.a("otherErrors");
        zzcq zzcq8 = new zzcq();
        zzcq8.zza(8);
        zzi = a9.b(zzcq8.zzb()).a();
        d.b a10 = d.a("remoteConfigValueForAcceleration");
        zzcq zzcq9 = new zzcq();
        zzcq9.zza(9);
        zzj = a10.b(zzcq9.zzb()).a();
        d.b a11 = d.a("isAccelerated");
        zzcq zzcq10 = new zzcq();
        zzcq10.zza(10);
        zzk = a11.b(zzcq10.zzb()).a();
    }

    private zzgb() {
    }

    public final /* bridge */ /* synthetic */ void encode(Object obj, Object obj2) throws IOException {
        zzjt zzjt = (zzjt) obj;
        f fVar = (f) obj2;
        fVar.add(zzb, zzjt.zze());
        fVar.add(zzc, zzjt.zza());
        fVar.add(zzd, zzjt.zzd());
        fVar.add(zze, zzjt.zzb());
        fVar.add(zzf, zzjt.zzc());
        fVar.add(zzg, (Object) null);
        fVar.add(zzh, (Object) null);
        fVar.add(zzi, (Object) null);
        fVar.add(zzj, (Object) null);
        fVar.add(zzk, (Object) null);
    }
}
