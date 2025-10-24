package com.google.android.gms.internal.p002firebaseauthapi;

import j6.z0;
import java.util.Objects;
import k6.r;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzabw  reason: invalid package */
final class zzabw implements zzafw<zzagz> {
    private final /* synthetic */ zzaem zza;
    private final /* synthetic */ zzabx zzb;

    public zzabw(zzabx zzabx, zzaem zzaem) {
        this.zza = zzaem;
        Objects.requireNonNull(zzabx);
        this.zzb = zzabx;
    }

    public final void zza(String str) {
        this.zza.zza(r.a(str));
    }

    public final /* synthetic */ void zza(Object obj) {
        zzagz zzagz = (zzagz) obj;
        this.zzb.zza.zza(new zzahw(zzagz.zzb(), zzagz.zza(), Long.valueOf(zzahy.zza(zzagz.zza())), "Bearer"), (String) null, (String) null, Boolean.FALSE, (z0) null, this.zza, this);
    }
}
