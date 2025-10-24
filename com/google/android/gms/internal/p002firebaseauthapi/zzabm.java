package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Objects;
import k6.r;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzabm  reason: invalid package */
final class zzabm implements zzafw<zzahw> {
    final /* synthetic */ zzaas zza;
    private final /* synthetic */ zzajc zzb;
    private final /* synthetic */ zzaem zzc;

    public zzabm(zzaas zzaas, zzajc zzajc, zzaem zzaem) {
        this.zzb = zzajc;
        this.zzc = zzaem;
        Objects.requireNonNull(zzaas);
        this.zza = zzaas;
    }

    public final void zza(String str) {
        this.zzc.zza(r.a(str));
    }

    public final /* synthetic */ void zza(Object obj) {
        this.zzb.zzb(true);
        this.zzb.zza(((zzahw) obj).zzc());
        this.zza.zza.zza(this.zzb, (zzafw<zzaje>) new zzabp(this, this.zzc, this));
    }
}
