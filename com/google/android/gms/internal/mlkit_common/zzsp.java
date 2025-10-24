package com.google.android.gms.internal.mlkit_common;

import L4.c;
import L4.d;
import L4.i;
import L4.j;
import M4.a;
import O4.u;
import X6.b;
import android.content.Context;
import l6.w;

public final class zzsp implements zzrz {
    private b zza;
    private final b zzb;
    private final zzsb zzc;

    public zzsp(Context context, zzsb zzsb) {
        this.zzc = zzsb;
        a aVar = a.g;
        u.f(context);
        j g = u.c().g(aVar);
        if (aVar.a().contains(c.b("json"))) {
            this.zza = new w(new zzsm(g));
        }
        this.zzb = new w(new zzsn(g));
    }

    public static d zzb(zzsb zzsb, zzry zzry) {
        return d.h(zzry.zze(zzsb.zza(), false));
    }

    public final void zza(zzry zzry) {
        if (this.zzc.zza() == 0) {
            b bVar = this.zza;
            if (bVar != null) {
                ((i) bVar.get()).b(zzb(this.zzc, zzry));
                return;
            }
            return;
        }
        ((i) this.zzb.get()).b(zzb(this.zzc, zzry));
    }
}
