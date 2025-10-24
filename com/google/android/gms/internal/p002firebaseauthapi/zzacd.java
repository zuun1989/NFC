package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Objects;
import k6.r;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzacd  reason: invalid package */
final class zzacd implements zzafw<zzahw> {
    private final /* synthetic */ zzaem zza;
    private final /* synthetic */ zzaas zzb;

    public zzacd(zzaas zzaas, zzaem zzaem) {
        this.zza = zzaem;
        Objects.requireNonNull(zzaas);
        this.zzb = zzaas;
    }

    public final void zza(String str) {
        this.zza.zza(r.a(str));
    }

    public final /* synthetic */ void zza(Object obj) {
        zzahw zzahw = (zzahw) obj;
        this.zzb.zza.zza(new zzahj(zzahw.zzc()), (zzafw<zzahm>) new zzacc(this, this, this.zza, zzahw));
    }
}
