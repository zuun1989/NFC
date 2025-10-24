package com.google.android.gms.internal.p002firebaseauthapi;

import j6.d0;
import java.util.Objects;
import k6.r;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzacl  reason: invalid package */
final class zzacl implements zzafw<zzahw> {
    private final /* synthetic */ d0 zza;
    private final /* synthetic */ zzaem zzb;
    private final /* synthetic */ zzaas zzc;

    public zzacl(zzaas zzaas, d0 d0Var, zzaem zzaem) {
        this.zza = d0Var;
        this.zzb = zzaem;
        Objects.requireNonNull(zzaas);
        this.zzc = zzaas;
    }

    public final void zza(String str) {
        this.zzb.zza(r.a(str));
    }

    public final /* synthetic */ void zza(Object obj) {
        zzahw zzahw = (zzahw) obj;
        zzaim zzaim = new zzaim();
        zzaim.zzd(zzahw.zzc());
        if (this.zza.zzb() || this.zza.getDisplayName() != null) {
            zzaim.zzb(this.zza.getDisplayName());
        }
        if (this.zza.zzc() || this.zza.K1() != null) {
            zzaim.zzg(this.zza.zza());
        }
        zzaas.zza(this.zzc, this.zzb, zzahw, zzaim, (zzaft) this);
    }
}
