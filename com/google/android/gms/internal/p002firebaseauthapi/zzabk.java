package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Objects;
import k6.r;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzabk  reason: invalid package */
final class zzabk implements zzafw<zzahw> {
    final /* synthetic */ zzaas zza;
    private final /* synthetic */ zzajh zzb;
    private final /* synthetic */ zzaem zzc;

    public zzabk(zzaas zzaas, zzajh zzajh, zzaem zzaem) {
        this.zzb = zzajh;
        this.zzc = zzaem;
        Objects.requireNonNull(zzaas);
        this.zza = zzaas;
    }

    public final void zza(String str) {
        this.zzc.zza(r.a(str));
    }

    public final /* synthetic */ void zza(Object obj) {
        this.zzb.zza(((zzahw) obj).zzc());
        this.zza.zza.zza(this.zzb, (zzafw<zzajk>) new zzabn(this, this.zzc, this));
    }
}
