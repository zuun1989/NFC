package com.google.android.gms.internal.p002firebaseauthapi;

import j6.z0;
import java.util.Objects;
import k6.r;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzabj  reason: invalid package */
final class zzabj implements zzafw<zzajk> {
    private final /* synthetic */ zzaem zza;
    private final /* synthetic */ zzaas zzb;

    public zzabj(zzaas zzaas, zzaem zzaem) {
        this.zza = zzaem;
        Objects.requireNonNull(zzaas);
        this.zzb = zzaas;
    }

    public final void zza(String str) {
        this.zza.zza(r.a(str));
    }

    public final /* synthetic */ void zza(Object obj) {
        zzajk zzajk = (zzajk) obj;
        this.zzb.zza(new zzahw(zzajk.zzd(), zzajk.zzb(), Long.valueOf(zzajk.zza()), "Bearer"), (String) null, (String) null, Boolean.valueOf(zzajk.zzf()), (z0) null, this.zza, this);
    }
}
