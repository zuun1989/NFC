package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Objects;
import k6.r;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzabx  reason: invalid package */
final class zzabx implements zzafw<zzahw> {
    final /* synthetic */ zzaas zza;
    private final /* synthetic */ zzaha zzb;
    private final /* synthetic */ zzaem zzc;

    public zzabx(zzaas zzaas, zzaha zzaha, zzaem zzaem) {
        this.zzb = zzaha;
        this.zzc = zzaem;
        Objects.requireNonNull(zzaas);
        this.zza = zzaas;
    }

    public final void zza(String str) {
        this.zzc.zza(r.a(str));
    }

    public final /* synthetic */ void zza(Object obj) {
        this.zzb.zza(((zzahw) obj).zzc());
        this.zza.zza.zza(this.zzb, (zzafw<zzagz>) new zzabw(this, this.zzc));
    }
}
