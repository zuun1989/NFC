package com.google.android.gms.internal.mlkit_vision_face;

import G6.d;
import G6.e;
import G6.f;
import java.io.IOException;

final class zzhx implements e {
    static final zzhx zza = new zzhx();
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
        zzcq zzcq = new zzcq();
        zzcq.zza(1);
        zzb = a.b(zzcq.zzb()).a();
        d.b a2 = d.a("appVersion");
        zzcq zzcq2 = new zzcq();
        zzcq2.zza(2);
        zzc = a2.b(zzcq2.zzb()).a();
        d.b a3 = d.a("firebaseProjectId");
        zzcq zzcq3 = new zzcq();
        zzcq3.zza(3);
        zzd = a3.b(zzcq3.zzb()).a();
        d.b a4 = d.a("mlSdkVersion");
        zzcq zzcq4 = new zzcq();
        zzcq4.zza(4);
        zze = a4.b(zzcq4.zzb()).a();
        d.b a6 = d.a("tfliteSchemaVersion");
        zzcq zzcq5 = new zzcq();
        zzcq5.zza(5);
        zzf = a6.b(zzcq5.zzb()).a();
        d.b a7 = d.a("gcmSenderId");
        zzcq zzcq6 = new zzcq();
        zzcq6.zza(6);
        zzg = a7.b(zzcq6.zzb()).a();
        d.b a8 = d.a("apiKey");
        zzcq zzcq7 = new zzcq();
        zzcq7.zza(7);
        zzh = a8.b(zzcq7.zzb()).a();
        d.b a9 = d.a("languages");
        zzcq zzcq8 = new zzcq();
        zzcq8.zza(8);
        zzi = a9.b(zzcq8.zzb()).a();
        d.b a10 = d.a("mlSdkInstanceId");
        zzcq zzcq9 = new zzcq();
        zzcq9.zza(9);
        zzj = a10.b(zzcq9.zzb()).a();
        d.b a11 = d.a("isClearcutClient");
        zzcq zzcq10 = new zzcq();
        zzcq10.zza(10);
        zzk = a11.b(zzcq10.zzb()).a();
        d.b a12 = d.a("isStandaloneMlkit");
        zzcq zzcq11 = new zzcq();
        zzcq11.zza(11);
        zzl = a12.b(zzcq11.zzb()).a();
        d.b a13 = d.a("isJsonLogging");
        zzcq zzcq12 = new zzcq();
        zzcq12.zza(12);
        zzm = a13.b(zzcq12.zzb()).a();
        d.b a14 = d.a("buildLevel");
        zzcq zzcq13 = new zzcq();
        zzcq13.zza(13);
        zzn = a14.b(zzcq13.zzb()).a();
        d.b a15 = d.a("optionalModuleVersion");
        zzcq zzcq14 = new zzcq();
        zzcq14.zza(14);
        zzo = a15.b(zzcq14.zzb()).a();
    }

    private zzhx() {
    }

    public final /* bridge */ /* synthetic */ void encode(Object obj, Object obj2) throws IOException {
        zzlt zzlt = (zzlt) obj;
        f fVar = (f) obj2;
        fVar.add(zzb, zzlt.zzg());
        fVar.add(zzc, zzlt.zzh());
        fVar.add(zzd, (Object) null);
        fVar.add(zze, zzlt.zzj());
        fVar.add(zzf, zzlt.zzk());
        fVar.add(zzg, (Object) null);
        fVar.add(zzh, (Object) null);
        fVar.add(zzi, zzlt.zza());
        fVar.add(zzj, zzlt.zzi());
        fVar.add(zzk, zzlt.zzb());
        fVar.add(zzl, zzlt.zzd());
        fVar.add(zzm, zzlt.zzc());
        fVar.add(zzn, zzlt.zze());
        fVar.add(zzo, zzlt.zzf());
    }
}
