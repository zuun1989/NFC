package com.google.android.gms.internal.mlkit_common;

import G6.d;
import G6.e;
import G6.f;
import java.io.IOException;

final class zzgr implements e {
    static final zzgr zza = new zzgr();
    private static final d zzb;
    private static final d zzc;
    private static final d zzd;
    private static final d zze;
    private static final d zzf;
    private static final d zzg;
    private static final d zzh;
    private static final d zzi;
    private static final d zzj;

    static {
        d.b a = d.a("name");
        zzay zzay = new zzay();
        zzay.zza(1);
        zzb = a.b(zzay.zzb()).a();
        d.b a2 = d.a("version");
        zzay zzay2 = new zzay();
        zzay2.zza(2);
        zzc = a2.b(zzay2.zzb()).a();
        d.b a3 = d.a("source");
        zzay zzay3 = new zzay();
        zzay3.zza(3);
        zzd = a3.b(zzay3.zzb()).a();
        d.b a4 = d.a("uri");
        zzay zzay4 = new zzay();
        zzay4.zza(4);
        zze = a4.b(zzay4.zzb()).a();
        d.b a6 = d.a("hash");
        zzay zzay5 = new zzay();
        zzay5.zza(5);
        zzf = a6.b(zzay5.zzb()).a();
        d.b a7 = d.a("modelType");
        zzay zzay6 = new zzay();
        zzay6.zza(6);
        zzg = a7.b(zzay6.zzb()).a();
        d.b a8 = d.a("size");
        zzay zzay7 = new zzay();
        zzay7.zza(7);
        zzh = a8.b(zzay7.zzb()).a();
        d.b a9 = d.a("hasLabelMap");
        zzay zzay8 = new zzay();
        zzay8.zza(8);
        zzi = a9.b(zzay8.zzb()).a();
        d.b a10 = d.a("isManifestModel");
        zzay zzay9 = new zzay();
        zzay9.zza(9);
        zzj = a10.b(zzay9.zzb()).a();
    }

    private zzgr() {
    }

    public final /* bridge */ /* synthetic */ void encode(Object obj, Object obj2) throws IOException {
        zznh zznh = (zznh) obj;
        f fVar = (f) obj2;
        fVar.add(zzb, zznh.zzd());
        fVar.add(zzc, (Object) null);
        fVar.add(zzd, zznh.zzb());
        fVar.add(zze, (Object) null);
        fVar.add(zzf, zznh.zzc());
        fVar.add(zzg, zznh.zza());
        fVar.add(zzh, (Object) null);
        fVar.add(zzi, (Object) null);
        fVar.add(zzj, (Object) null);
    }
}
