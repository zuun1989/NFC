package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Objects;
import k6.r;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzabr  reason: invalid package */
final class zzabr implements zzafw<zzahw> {
    final /* synthetic */ zzaas zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ zzaem zzc;

    public zzabr(zzaas zzaas, String str, zzaem zzaem) {
        this.zzb = str;
        this.zzc = zzaem;
        Objects.requireNonNull(zzaas);
        this.zza = zzaas;
    }

    public final void zza(String str) {
        this.zzc.zza(r.a(str));
    }

    public final /* synthetic */ void zza(Object obj) {
        zzahw zzahw = (zzahw) obj;
        this.zza.zza.zza(new zzahj(zzahw.zzc()), (zzafw<zzahm>) new zzabq(this, this, zzahw, this.zzb, this.zzc));
    }
}
