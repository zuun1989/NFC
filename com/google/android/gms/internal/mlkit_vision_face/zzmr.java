package com.google.android.gms.internal.mlkit_vision_face;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;

public final class zzmr implements zzmy {
    final List zza;

    public zzmr(Context context, zzmq zzmq) {
        ArrayList arrayList = new ArrayList();
        this.zza = arrayList;
        if (zzmq.zzc()) {
            arrayList.add(new zznh(context, zzmq));
        }
    }

    public final void zza(zznc zznc) {
        for (zzmy zza2 : this.zza) {
            zza2.zza(zznc);
        }
    }
}
