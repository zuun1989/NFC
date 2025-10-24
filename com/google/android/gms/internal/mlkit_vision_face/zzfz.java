package com.google.android.gms.internal.mlkit_vision_face;

import G6.d;
import G6.e;
import G6.f;
import java.io.IOException;

final class zzfz implements e {
    static final zzfz zza = new zzfz();
    private static final d zzb;
    private static final d zzc;
    private static final d zzd;
    private static final d zze;

    static {
        d.b a = d.a("imageFormat");
        zzcq zzcq = new zzcq();
        zzcq.zza(1);
        zzb = a.b(zzcq.zzb()).a();
        d.b a2 = d.a("originalImageSize");
        zzcq zzcq2 = new zzcq();
        zzcq2.zza(2);
        zzc = a2.b(zzcq2.zzb()).a();
        d.b a3 = d.a("compressedImageSize");
        zzcq zzcq3 = new zzcq();
        zzcq3.zza(3);
        zzd = a3.b(zzcq3.zzb()).a();
        d.b a4 = d.a("isOdmlImage");
        zzcq zzcq4 = new zzcq();
        zzcq4.zza(4);
        zze = a4.b(zzcq4.zzb()).a();
    }

    private zzfz() {
    }

    public final /* bridge */ /* synthetic */ void encode(Object obj, Object obj2) throws IOException {
        zzjp zzjp = (zzjp) obj;
        f fVar = (f) obj2;
        fVar.add(zzb, zzjp.zza());
        fVar.add(zzc, zzjp.zzb());
        fVar.add(zzd, (Object) null);
        fVar.add(zze, (Object) null);
    }
}
