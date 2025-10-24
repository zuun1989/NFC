package com.google.android.gms.internal.mlkit_vision_barcode;

import G6.d;
import G6.e;
import G6.f;
import java.io.IOException;

final class zzon implements e {
    static final zzon zza = new zzon();
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
        zzfa zzfa = new zzfa();
        zzfa.zza(1);
        zzb = a.b(zzfa.zzb()).a();
        d.b a2 = d.a("appVersion");
        zzfa zzfa2 = new zzfa();
        zzfa2.zza(2);
        zzc = a2.b(zzfa2.zzb()).a();
        d.b a3 = d.a("firebaseProjectId");
        zzfa zzfa3 = new zzfa();
        zzfa3.zza(3);
        zzd = a3.b(zzfa3.zzb()).a();
        d.b a4 = d.a("mlSdkVersion");
        zzfa zzfa4 = new zzfa();
        zzfa4.zza(4);
        zze = a4.b(zzfa4.zzb()).a();
        d.b a6 = d.a("tfliteSchemaVersion");
        zzfa zzfa5 = new zzfa();
        zzfa5.zza(5);
        zzf = a6.b(zzfa5.zzb()).a();
        d.b a7 = d.a("gcmSenderId");
        zzfa zzfa6 = new zzfa();
        zzfa6.zza(6);
        zzg = a7.b(zzfa6.zzb()).a();
        d.b a8 = d.a("apiKey");
        zzfa zzfa7 = new zzfa();
        zzfa7.zza(7);
        zzh = a8.b(zzfa7.zzb()).a();
        d.b a9 = d.a("languages");
        zzfa zzfa8 = new zzfa();
        zzfa8.zza(8);
        zzi = a9.b(zzfa8.zzb()).a();
        d.b a10 = d.a("mlSdkInstanceId");
        zzfa zzfa9 = new zzfa();
        zzfa9.zza(9);
        zzj = a10.b(zzfa9.zzb()).a();
        d.b a11 = d.a("isClearcutClient");
        zzfa zzfa10 = new zzfa();
        zzfa10.zza(10);
        zzk = a11.b(zzfa10.zzb()).a();
        d.b a12 = d.a("isStandaloneMlkit");
        zzfa zzfa11 = new zzfa();
        zzfa11.zza(11);
        zzl = a12.b(zzfa11.zzb()).a();
        d.b a13 = d.a("isJsonLogging");
        zzfa zzfa12 = new zzfa();
        zzfa12.zza(12);
        zzm = a13.b(zzfa12.zzb()).a();
        d.b a14 = d.a("buildLevel");
        zzfa zzfa13 = new zzfa();
        zzfa13.zza(13);
        zzn = a14.b(zzfa13.zzb()).a();
        d.b a15 = d.a("optionalModuleVersion");
        zzfa zzfa14 = new zzfa();
        zzfa14.zza(14);
        zzo = a15.b(zzfa14.zzb()).a();
    }

    private zzon() {
    }

    public final /* bridge */ /* synthetic */ void encode(Object obj, Object obj2) throws IOException {
        zzvd zzvd = (zzvd) obj;
        f fVar = (f) obj2;
        fVar.add(zzb, zzvd.zzg());
        fVar.add(zzc, zzvd.zzh());
        fVar.add(zzd, (Object) null);
        fVar.add(zze, zzvd.zzj());
        fVar.add(zzf, zzvd.zzk());
        fVar.add(zzg, (Object) null);
        fVar.add(zzh, (Object) null);
        fVar.add(zzi, zzvd.zza());
        fVar.add(zzj, zzvd.zzi());
        fVar.add(zzk, zzvd.zzb());
        fVar.add(zzl, zzvd.zzd());
        fVar.add(zzm, zzvd.zzc());
        fVar.add(zzn, zzvd.zze());
        fVar.add(zzo, zzvd.zzf());
    }
}
