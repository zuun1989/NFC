package com.google.android.gms.internal.p002firebaseauthapi;

import j6.z0;
import java.util.Objects;
import k6.r;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaaz  reason: invalid package */
final class zzaaz implements zzafw<zzagx> {
    private final /* synthetic */ zzaem zza;
    private final /* synthetic */ zzaas zzb;

    public zzaaz(zzaas zzaas, zzaem zzaem) {
        this.zza = zzaem;
        Objects.requireNonNull(zzaas);
        this.zzb = zzaas;
    }

    public final void zza(String str) {
        this.zza.zza(r.a(str));
    }

    public final /* synthetic */ void zza(Object obj) {
        zzagx zzagx = (zzagx) obj;
        if (zzagx.zzf()) {
            this.zza.zza(new zzaat(zzagx.zzc(), zzagx.zze(), (z0) null));
            return;
        }
        this.zzb.zza(new zzahw(zzagx.zzd(), zzagx.zzb(), Long.valueOf(zzagx.zza()), "Bearer"), (String) null, (String) null, Boolean.valueOf(zzagx.zzg()), (z0) null, this.zza, this);
    }
}
