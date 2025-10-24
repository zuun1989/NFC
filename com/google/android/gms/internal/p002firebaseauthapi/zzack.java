package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Objects;
import k6.r;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzack  reason: invalid package */
final class zzack implements zzafw<zzahw> {
    private final /* synthetic */ String zza;
    private final /* synthetic */ zzaem zzb;
    private final /* synthetic */ zzaas zzc;

    public zzack(zzaas zzaas, String str, zzaem zzaem) {
        this.zza = str;
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
        zzaim.zzd(zzahw.zzc()).zzc(this.zza);
        zzaas.zza(this.zzc, this.zzb, zzahw, zzaim, (zzaft) this);
    }
}
