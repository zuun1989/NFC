package com.google.android.gms.internal.mlkit_vision_face;

import L4.c;
import L4.d;
import L4.i;
import L4.j;
import M4.a;
import O4.u;
import X6.b;
import android.content.Context;
import l6.w;

public final class zznh implements zzmy {
    private b zza;
    private final b zzb;
    private final zzmq zzc;

    public zznh(Context context, zzmq zzmq) {
        this.zzc = zzmq;
        a aVar = a.g;
        u.f(context);
        j g = u.c().g(aVar);
        if (aVar.a().contains(c.b("json"))) {
            this.zza = new w(new zznf(g));
        }
        this.zzb = new w(new zzng(g));
    }

    public static d zzb(zzmq zzmq, zznc zznc) {
        int zza2 = zzmq.zza();
        if (zznc.zza() != 0) {
            return d.f(zznc.zzc(zza2, false));
        }
        return d.h(zznc.zzc(zza2, false));
    }

    public final void zza(zznc zznc) {
        if (this.zzc.zza() == 0) {
            b bVar = this.zza;
            if (bVar != null) {
                ((i) bVar.get()).b(zzb(this.zzc, zznc));
                return;
            }
            return;
        }
        ((i) this.zzb.get()).b(zzb(this.zzc, zznc));
    }
}
