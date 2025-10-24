package com.google.android.gms.internal.p002firebaseauthapi;

import j6.z0;
import java.util.Objects;
import k6.r;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzabz  reason: invalid package */
final class zzabz implements zzafw<zzahb> {
    private final /* synthetic */ zzaem zza;
    private final /* synthetic */ zzaas zzb;

    public zzabz(zzaas zzaas, zzaem zzaem) {
        this.zza = zzaem;
        Objects.requireNonNull(zzaas);
        this.zzb = zzaas;
    }

    public final void zza(String str) {
        this.zza.zza(r.a(str));
    }

    public final /* synthetic */ void zza(Object obj) {
        zzahb zzahb = (zzahb) obj;
        this.zzb.zza(new zzahw(zzahb.zzb(), zzahb.zza(), Long.valueOf(zzahy.zza(zzahb.zza())), "Bearer"), (String) null, (String) null, Boolean.FALSE, (z0) null, this.zza, this);
    }
}
