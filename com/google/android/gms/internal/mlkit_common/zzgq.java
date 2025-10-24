package com.google.android.gms.internal.mlkit_common;

import G6.d;
import G6.e;
import G6.f;
import java.io.IOException;

final class zzgq implements e {
    static final zzgq zza = new zzgq();
    private static final d zzb;
    private static final d zzc;
    private static final d zzd;
    private static final d zze;
    private static final d zzf;
    private static final d zzg;
    private static final d zzh;

    static {
        d.b a = d.a("options");
        zzay zzay = new zzay();
        zzay.zza(1);
        zzb = a.b(zzay.zzb()).a();
        d.b a2 = d.a("roughDownloadDurationMs");
        zzay zzay2 = new zzay();
        zzay2.zza(2);
        zzc = a2.b(zzay2.zzb()).a();
        d.b a3 = d.a("errorCode");
        zzay zzay3 = new zzay();
        zzay3.zza(3);
        zzd = a3.b(zzay3.zzb()).a();
        d.b a4 = d.a("exactDownloadDurationMs");
        zzay zzay4 = new zzay();
        zzay4.zza(4);
        zze = a4.b(zzay4.zzb()).a();
        d.b a6 = d.a("downloadStatus");
        zzay zzay5 = new zzay();
        zzay5.zza(5);
        zzf = a6.b(zzay5.zzb()).a();
        d.b a7 = d.a("downloadFailureStatus");
        zzay zzay6 = new zzay();
        zzay6.zza(6);
        zzg = a7.b(zzay6.zzb()).a();
        d.b a8 = d.a("mddDownloadErrorCodes");
        zzay zzay7 = new zzay();
        zzay7.zza(7);
        zzh = a8.b(zzay7.zzb()).a();
    }

    private zzgq() {
    }

    public final /* bridge */ /* synthetic */ void encode(Object obj, Object obj2) throws IOException {
        zznc zznc = (zznc) obj;
        f fVar = (f) obj2;
        fVar.add(zzb, zznc.zzc());
        fVar.add(zzc, zznc.zzf());
        fVar.add(zzd, zznc.zza());
        fVar.add(zze, zznc.zze());
        fVar.add(zzf, zznc.zzb());
        fVar.add(zzg, zznc.zzd());
        fVar.add(zzh, (Object) null);
    }
}
