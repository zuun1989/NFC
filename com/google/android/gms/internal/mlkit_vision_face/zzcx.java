package com.google.android.gms.internal.mlkit_vision_face;

import G6.c;
import G6.e;
import G6.f;

public final /* synthetic */ class zzcx implements e {
    public static final /* synthetic */ zzcx zza = new zzcx();

    private /* synthetic */ zzcx() {
    }

    public final void encode(Object obj, Object obj2) {
        String str;
        f fVar = (f) obj2;
        int i = zzcy.zza;
        String valueOf = String.valueOf(obj.getClass().getCanonicalName());
        if (valueOf.length() != 0) {
            str = "Couldn't find encoder for type ".concat(valueOf);
        } else {
            str = new String("Couldn't find encoder for type ");
        }
        throw new c(str);
    }
}
