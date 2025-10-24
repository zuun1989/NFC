package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Objects;
import k6.r;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzacf  reason: invalid package */
final class zzacf implements zzafw<zzahw> {
    private final /* synthetic */ zzaem zza;
    private final /* synthetic */ zzaas zzb;

    public zzacf(zzaas zzaas, zzaem zzaem) {
        this.zza = zzaem;
        Objects.requireNonNull(zzaas);
        this.zzb = zzaas;
    }

    public final void zza(String str) {
        this.zza.zza(r.a(str));
    }

    public final /* synthetic */ void zza(Object obj) {
        this.zzb.zza.zza(new zzagv(((zzahw) obj).zzc()), (zzafw<Void>) new zzace(this, this.zza, this));
    }
}
