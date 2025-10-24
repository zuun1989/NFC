package com.google.android.gms.internal.mlkit_vision_barcode;

import L4.c;
import L4.d;
import L4.i;
import L4.j;
import M4.a;
import O4.u;
import X6.b;
import android.content.Context;
import l6.w;

public final class zzwx implements zzwf {
    private b zza;
    private final b zzb;
    private final zzwh zzc;

    public zzwx(Context context, zzwh zzwh) {
        this.zzc = zzwh;
        a aVar = a.g;
        u.f(context);
        j g = u.c().g(aVar);
        if (aVar.a().contains(c.b("json"))) {
            this.zza = new w(new zzwu(g));
        }
        this.zzb = new w(new zzwv(g));
    }

    public static d zzb(zzwh zzwh, zzwe zzwe) {
        int zza2 = zzwh.zza();
        if (zzwe.zza() != 0) {
            return d.f(zzwe.zze(zza2, false));
        }
        return d.h(zzwe.zze(zza2, false));
    }

    public final void zza(zzwe zzwe) {
        if (this.zzc.zza() == 0) {
            b bVar = this.zza;
            if (bVar != null) {
                ((i) bVar.get()).b(zzb(this.zzc, zzwe));
                return;
            }
            return;
        }
        ((i) this.zzb.get()).b(zzb(this.zzc, zzwe));
    }
}
