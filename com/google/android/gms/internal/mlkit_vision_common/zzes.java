package com.google.android.gms.internal.mlkit_vision_common;

import G6.d;
import G6.e;
import G6.f;
import java.io.IOException;

final class zzes implements e {
    static final zzes zza = new zzes();
    private static final d zzb;
    private static final d zzc;
    private static final d zzd;
    private static final d zze;

    static {
        d.b a = d.a("isChargingRequired");
        zzae zzae = new zzae();
        zzae.zza(1);
        zzb = a.b(zzae.zzb()).a();
        d.b a2 = d.a("isWifiRequired");
        zzae zzae2 = new zzae();
        zzae2.zza(2);
        zzc = a2.b(zzae2.zzb()).a();
        d.b a3 = d.a("isDeviceIdleRequired");
        zzae zzae3 = new zzae();
        zzae3.zza(3);
        zzd = a3.b(zzae3.zzb()).a();
        d.b a4 = d.a("canDownloadInBackground");
        zzae zzae4 = new zzae();
        zzae4.zza(4);
        zze = a4.b(zzae4.zzb()).a();
    }

    private zzes() {
    }

    public final /* bridge */ /* synthetic */ void encode(Object obj, Object obj2) throws IOException {
        zzjb zzjb = (zzjb) obj;
        f fVar = (f) obj2;
        throw null;
    }
}
