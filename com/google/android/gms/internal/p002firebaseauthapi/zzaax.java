package com.google.android.gms.internal.p002firebaseauthapi;

import j6.z0;
import java.util.Objects;
import k6.r;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaax  reason: invalid package */
final class zzaax implements zzafw<zzaji> {
    private final /* synthetic */ zzaem zza;
    private final /* synthetic */ zzaas zzb;

    public zzaax(zzaas zzaas, zzaem zzaem) {
        this.zza = zzaem;
        Objects.requireNonNull(zzaas);
        this.zzb = zzaas;
    }

    public final void zza(String str) {
        this.zza.zza(r.a(str));
    }

    public final /* synthetic */ void zza(Object obj) {
        zzaji zzaji = (zzaji) obj;
        if (zzaji.zzf()) {
            this.zza.zza(new zzaat(zzaji.zzc(), zzaji.zze(), (z0) null));
            return;
        }
        this.zzb.zza(new zzahw(zzaji.zzd(), zzaji.zzb(), Long.valueOf(zzaji.zza()), "Bearer"), (String) null, (String) null, Boolean.FALSE, (z0) null, this.zza, this);
    }
}
