package com.google.android.gms.internal.p002firebaseauthapi;

import j6.z0;
import java.util.Objects;
import k6.r;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzabe  reason: invalid package */
final class zzabe implements zzafw<zzajg> {
    private final /* synthetic */ zzaem zza;
    private final /* synthetic */ zzaas zzb;

    public zzabe(zzaas zzaas, zzaem zzaem) {
        this.zza = zzaem;
        Objects.requireNonNull(zzaas);
        this.zzb = zzaas;
    }

    public final void zza(String str) {
        this.zza.zza(r.a(str));
    }

    public final /* synthetic */ void zza(Object obj) {
        zzajg zzajg = (zzajg) obj;
        this.zzb.zza(new zzahw(zzajg.zzc(), zzajg.zzb(), Long.valueOf(zzajg.zza()), "Bearer"), (String) null, (String) null, Boolean.valueOf(zzajg.zzd()), (z0) null, this.zza, this);
    }
}
