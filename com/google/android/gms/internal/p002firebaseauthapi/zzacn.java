package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Objects;
import k6.r;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzacn  reason: invalid package */
final class zzacn implements zzafw<zzahw> {
    private final /* synthetic */ String zza;
    private final /* synthetic */ zzaem zzb;
    private final /* synthetic */ zzaas zzc;

    public zzacn(zzaas zzaas, String str, zzaem zzaem) {
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
        String zzc2 = zzahw.zzc();
        zzaim zzaim = new zzaim();
        zzaim.zzd(zzc2).zzf(this.zza);
        zzaas.zza(this.zzc, this.zzb, zzahw, zzaim, (zzaft) this);
    }
}
