package com.google.android.gms.internal.mlkit_vision_common;

import G6.d;
import G6.e;
import G6.f;
import java.io.IOException;

final class zzgu implements e {
    static final zzgu zza = new zzgu();
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
        zzae zzae = new zzae();
        zzae.zza(1);
        zzb = a.b(zzae.zzb()).a();
        d.b a2 = d.a("appVersion");
        zzae zzae2 = new zzae();
        zzae2.zza(2);
        zzc = a2.b(zzae2.zzb()).a();
        d.b a3 = d.a("firebaseProjectId");
        zzae zzae3 = new zzae();
        zzae3.zza(3);
        zzd = a3.b(zzae3.zzb()).a();
        d.b a4 = d.a("mlSdkVersion");
        zzae zzae4 = new zzae();
        zzae4.zza(4);
        zze = a4.b(zzae4.zzb()).a();
        d.b a6 = d.a("tfliteSchemaVersion");
        zzae zzae5 = new zzae();
        zzae5.zza(5);
        zzf = a6.b(zzae5.zzb()).a();
        d.b a7 = d.a("gcmSenderId");
        zzae zzae6 = new zzae();
        zzae6.zza(6);
        zzg = a7.b(zzae6.zzb()).a();
        d.b a8 = d.a("apiKey");
        zzae zzae7 = new zzae();
        zzae7.zza(7);
        zzh = a8.b(zzae7.zzb()).a();
        d.b a9 = d.a("languages");
        zzae zzae8 = new zzae();
        zzae8.zza(8);
        zzi = a9.b(zzae8.zzb()).a();
        d.b a10 = d.a("mlSdkInstanceId");
        zzae zzae9 = new zzae();
        zzae9.zza(9);
        zzj = a10.b(zzae9.zzb()).a();
        d.b a11 = d.a("isClearcutClient");
        zzae zzae10 = new zzae();
        zzae10.zza(10);
        zzk = a11.b(zzae10.zzb()).a();
        d.b a12 = d.a("isStandaloneMlkit");
        zzae zzae11 = new zzae();
        zzae11.zza(11);
        zzl = a12.b(zzae11.zzb()).a();
        d.b a13 = d.a("isJsonLogging");
        zzae zzae12 = new zzae();
        zzae12.zza(12);
        zzm = a13.b(zzae12.zzb()).a();
        d.b a14 = d.a("buildLevel");
        zzae zzae13 = new zzae();
        zzae13.zza(13);
        zzn = a14.b(zzae13.zzb()).a();
        d.b a15 = d.a("optionalModuleVersion");
        zzae zzae14 = new zzae();
        zzae14.zza(14);
        zzo = a15.b(zzae14.zzb()).a();
    }

    private zzgu() {
    }

    public final /* bridge */ /* synthetic */ void encode(Object obj, Object obj2) throws IOException {
        zzla zzla = (zzla) obj;
        f fVar = (f) obj2;
        fVar.add(zzb, zzla.zzg());
        fVar.add(zzc, zzla.zzh());
        fVar.add(zzd, (Object) null);
        fVar.add(zze, zzla.zzj());
        fVar.add(zzf, zzla.zzk());
        fVar.add(zzg, (Object) null);
        fVar.add(zzh, (Object) null);
        fVar.add(zzi, zzla.zza());
        fVar.add(zzj, zzla.zzi());
        fVar.add(zzk, zzla.zzb());
        fVar.add(zzl, zzla.zzd());
        fVar.add(zzm, zzla.zzc());
        fVar.add(zzn, zzla.zze());
        fVar.add(zzo, zzla.zzf());
    }
}
