package com.google.android.gms.internal.mlkit_common;

import G6.d;
import G6.e;
import G6.f;
import java.io.IOException;

final class zzkh implements e {
    static final zzkh zza = new zzkh();
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
    private static final d zzl;
    private static final d zzm;
    private static final d zzn;
    private static final d zzo;

    static {
        d.b a = d.a("appId");
        zzay zzay = new zzay();
        zzay.zza(1);
        zzb = a.b(zzay.zzb()).a();
        d.b a2 = d.a("appVersion");
        zzay zzay2 = new zzay();
        zzay2.zza(2);
        zzc = a2.b(zzay2.zzb()).a();
        d.b a3 = d.a("firebaseProjectId");
        zzay zzay3 = new zzay();
        zzay3.zza(3);
        zzd = a3.b(zzay3.zzb()).a();
        d.b a4 = d.a("mlSdkVersion");
        zzay zzay4 = new zzay();
        zzay4.zza(4);
        zze = a4.b(zzay4.zzb()).a();
        d.b a6 = d.a("tfliteSchemaVersion");
        zzay zzay5 = new zzay();
        zzay5.zza(5);
        zzf = a6.b(zzay5.zzb()).a();
        d.b a7 = d.a("gcmSenderId");
        zzay zzay6 = new zzay();
        zzay6.zza(6);
        zzg = a7.b(zzay6.zzb()).a();
        d.b a8 = d.a("apiKey");
        zzay zzay7 = new zzay();
        zzay7.zza(7);
        zzh = a8.b(zzay7.zzb()).a();
        d.b a9 = d.a("languages");
        zzay zzay8 = new zzay();
        zzay8.zza(8);
        zzi = a9.b(zzay8.zzb()).a();
        d.b a10 = d.a("mlSdkInstanceId");
        zzay zzay9 = new zzay();
        zzay9.zza(9);
        zzj = a10.b(zzay9.zzb()).a();
        d.b a11 = d.a("isClearcutClient");
        zzay zzay10 = new zzay();
        zzay10.zza(10);
        zzk = a11.b(zzay10.zzb()).a();
        d.b a12 = d.a("isStandaloneMlkit");
        zzay zzay11 = new zzay();
        zzay11.zza(11);
        zzl = a12.b(zzay11.zzb()).a();
        d.b a13 = d.a("isJsonLogging");
        zzay zzay12 = new zzay();
        zzay12.zza(12);
        zzm = a13.b(zzay12.zzb()).a();
        d.b a14 = d.a("buildLevel");
        zzay zzay13 = new zzay();
        zzay13.zza(13);
        zzn = a14.b(zzay13.zzb()).a();
        d.b a15 = d.a("optionalModuleVersion");
        zzay zzay14 = new zzay();
        zzay14.zza(14);
        zzo = a15.b(zzay14.zzb()).a();
    }

    private zzkh() {
    }

    public final /* bridge */ /* synthetic */ void encode(Object obj, Object obj2) throws IOException {
        zzqv zzqv = (zzqv) obj;
        f fVar = (f) obj2;
        fVar.add(zzb, zzqv.zzg());
        fVar.add(zzc, zzqv.zzh());
        fVar.add(zzd, (Object) null);
        fVar.add(zze, zzqv.zzj());
        fVar.add(zzf, zzqv.zzk());
        fVar.add(zzg, (Object) null);
        fVar.add(zzh, (Object) null);
        fVar.add(zzi, zzqv.zza());
        fVar.add(zzj, zzqv.zzi());
        fVar.add(zzk, zzqv.zzb());
        fVar.add(zzl, zzqv.zzd());
        fVar.add(zzm, zzqv.zzc());
        fVar.add(zzn, zzqv.zze());
        fVar.add(zzo, zzqv.zzf());
    }
}
