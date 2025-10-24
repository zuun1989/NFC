package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Objects;
import k6.r;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzabo  reason: invalid package */
final class zzabo implements zzafw<zzahw> {
    private final /* synthetic */ zzaem zza;
    private final /* synthetic */ zzaas zzb;

    public zzabo(zzaas zzaas, zzaem zzaem) {
        this.zza = zzaem;
        Objects.requireNonNull(zzaas);
        this.zzb = zzaas;
    }

    public final void zza(String str) {
        this.zza.zza(r.a(str));
    }

    public final /* synthetic */ void zza(Object obj) {
        zzahw zzahw = (zzahw) obj;
        zzaim zzaim = new zzaim();
        zzaim.zzd(zzahw.zzc()).zzc((String) null).zzf((String) null);
        zzaas.zza(this.zzb, this.zza, zzahw, zzaim, (zzaft) this);
    }
}
