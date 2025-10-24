package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Objects;
import k6.r;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzabt  reason: invalid package */
final class zzabt implements zzafw<zzahw> {
    final /* synthetic */ zzaas zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ String zzc;
    private final /* synthetic */ zzaem zzd;

    public zzabt(zzaas zzaas, String str, String str2, zzaem zzaem) {
        this.zzb = str;
        this.zzc = str2;
        this.zzd = zzaem;
        Objects.requireNonNull(zzaas);
        this.zza = zzaas;
    }

    public final void zza(String str) {
        this.zzd.zza(r.a(str));
    }

    public final /* synthetic */ void zza(Object obj) {
        this.zza.zza.zza(new zzajj(((zzahw) obj).zzc(), this.zzb, this.zzc), (zzafw<zzajm>) new zzabs(this, this.zzd));
    }
}
