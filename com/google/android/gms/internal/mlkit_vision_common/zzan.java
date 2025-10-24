package com.google.android.gms.internal.mlkit_vision_common;

import G6.e;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Map;

public final class zzan {
    private final Map zza;
    private final Map zzb;
    private final e zzc;

    public zzan(Map map, Map map2, e eVar) {
        this.zza = map;
        this.zzb = map2;
        this.zzc = eVar;
    }

    public final byte[] zza(Object obj) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            new zzak(byteArrayOutputStream, this.zza, this.zzb, this.zzc).zzf(obj);
        } catch (IOException unused) {
        }
        return byteArrayOutputStream.toByteArray();
    }
}
