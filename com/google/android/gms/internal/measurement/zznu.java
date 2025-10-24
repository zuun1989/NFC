package com.google.android.gms.internal.measurement;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

final class zznu {
    public static final /* synthetic */ int zza = 0;
    private static final zznu zzb = new zznu();
    private final zzny zzc = new zznd();
    private final ConcurrentMap zzd = new ConcurrentHashMap();

    private zznu() {
    }

    public static zznu zza() {
        return zzb;
    }

    public final zznx zzb(Class cls) {
        zzmp.zza(cls, "messageType");
        ConcurrentMap concurrentMap = this.zzd;
        zznx zznx = (zznx) concurrentMap.get(cls);
        if (zznx == null) {
            zznx = this.zzc.zza(cls);
            zzmp.zza(cls, "messageType");
            zznx zznx2 = (zznx) concurrentMap.putIfAbsent(cls, zznx);
            if (zznx2 != null) {
                return zznx2;
            }
        }
        return zznx;
    }
}
