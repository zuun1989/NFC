package com.google.android.gms.internal.mlkit_vision_common;

import L4.c;
import L4.d;
import L4.i;
import L4.j;
import M4.a;
import O4.u;
import X6.b;
import android.content.Context;
import l6.w;

public final class zzmp implements zzmc {
    private b zza;
    private final b zzb;
    private final zzme zzc;

    public zzmp(Context context, zzme zzme) {
        this.zzc = zzme;
        a aVar = a.g;
        u.f(context);
        j g = u.c().g(aVar);
        if (aVar.a().contains(c.b("json"))) {
            this.zza = new w(new zzmm(g));
        }
        this.zzb = new w(new zzmn(g));
    }

    public static d zzb(zzme zzme, zzmb zzmb) {
        return d.h(zzmb.zzd(zzme.zza(), false));
    }

    public final void zza(zzmb zzmb) {
        if (this.zzc.zza() == 0) {
            b bVar = this.zza;
            if (bVar != null) {
                ((i) bVar.get()).b(zzb(this.zzc, zzmb));
                return;
            }
            return;
        }
        ((i) this.zzb.get()).b(zzb(this.zzc, zzmb));
    }
}
