package com.google.android.gms.internal.mlkit_vision_barcode;

import G6.e;
import G6.g;
import H6.b;
import java.util.HashMap;
import java.util.Map;

public final class zzfi implements b {
    public static final /* synthetic */ int zza = 0;
    private static final e zzb = new zzfh();
    private final Map zzc = new HashMap();
    private final Map zzd = new HashMap();
    private final e zze = zzb;

    public final /* bridge */ /* synthetic */ b registerEncoder(Class cls, e eVar) {
        this.zzc.put(cls, eVar);
        this.zzd.remove(cls);
        return this;
    }

    public final zzfj zza() {
        return new zzfj(new HashMap(this.zzc), new HashMap(this.zzd), this.zze);
    }

    public final /* bridge */ /* synthetic */ b registerEncoder(Class cls, g gVar) {
        this.zzd.put(cls, gVar);
        this.zzc.remove(cls);
        return this;
    }
}
