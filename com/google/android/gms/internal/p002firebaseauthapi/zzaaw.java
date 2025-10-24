package com.google.android.gms.internal.p002firebaseauthapi;

import j6.j;
import java.util.Objects;
import k6.r;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaaw  reason: invalid package */
final class zzaaw implements zzafw<zzahw> {
    private final /* synthetic */ j zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ zzaem zzc;
    private final /* synthetic */ zzaas zzd;

    public zzaaw(zzaas zzaas, j jVar, String str, zzaem zzaem) {
        this.zza = jVar;
        this.zzb = str;
        this.zzc = zzaem;
        Objects.requireNonNull(zzaas);
        this.zzd = zzaas;
    }

    public final void zza(String str) {
        this.zzc.zza(r.a(str));
    }

    public final /* synthetic */ void zza(Object obj) {
        this.zzd.zza(new zzagy(this.zza, ((zzahw) obj).zzc(), this.zzb), this.zzc);
    }
}
