package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Objects;
import k6.r;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzabi  reason: invalid package */
final class zzabi implements zzafw<zzahw> {
    private final /* synthetic */ String zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ String zzc;
    private final /* synthetic */ String zzd;
    private final /* synthetic */ zzaem zze;
    private final /* synthetic */ zzaas zzf;

    public zzabi(zzaas zzaas, String str, String str2, String str3, String str4, zzaem zzaem) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = str4;
        this.zze = zzaem;
        Objects.requireNonNull(zzaas);
        this.zzf = zzaas;
    }

    public final void zza(String str) {
        this.zze.zza(r.a(str));
    }

    public final /* synthetic */ void zza(Object obj) {
        zzaas.zza(this.zzf, this.zze, new zzain(this.zza, this.zzb, (String) null, this.zzc, this.zzd, ((zzahw) obj).zzc()), (zzaft) this);
    }
}
