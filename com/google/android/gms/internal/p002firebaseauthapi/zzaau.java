package com.google.android.gms.internal.p002firebaseauthapi;

import j6.z0;
import java.util.Objects;
import k6.r;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaau  reason: invalid package */
final class zzaau implements zzafw<zzaiq> {
    private final /* synthetic */ zzaem zza;
    private final /* synthetic */ zzaas zzb;

    public zzaau(zzaas zzaas, zzaem zzaem) {
        this.zza = zzaem;
        Objects.requireNonNull(zzaas);
        this.zzb = zzaas;
    }

    public final void zza(String str) {
        this.zza.zza(r.a(str));
    }

    public final /* synthetic */ void zza(Object obj) {
        zzaiq zzaiq = (zzaiq) obj;
        this.zzb.zza(new zzahw(zzaiq.zzc(), zzaiq.zzb(), Long.valueOf(zzaiq.zza()), "Bearer"), (String) null, (String) null, Boolean.TRUE, (z0) null, this.zza, this);
    }
}
