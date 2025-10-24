package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.List;
import java.util.Objects;
import k6.r;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzabq  reason: invalid package */
final class zzabq implements zzafw<zzahm> {
    private final /* synthetic */ zzafw zza;
    private final /* synthetic */ zzahw zzb;
    private final /* synthetic */ String zzc;
    private final /* synthetic */ zzaem zzd;
    private final /* synthetic */ zzabr zze;

    public zzabq(zzabr zzabr, zzafw zzafw, zzahw zzahw, String str, zzaem zzaem) {
        this.zza = zzafw;
        this.zzb = zzahw;
        this.zzc = str;
        this.zzd = zzaem;
        Objects.requireNonNull(zzabr);
        this.zze = zzabr;
    }

    public final void zza(String str) {
        this.zzd.zza(r.a(str));
    }

    public final /* synthetic */ void zza(Object obj) {
        List<zzahl> zza2 = ((zzahm) obj).zza();
        if (zza2 == null || zza2.isEmpty()) {
            this.zza.zza("No users.");
            return;
        }
        zzaim zzaim = new zzaim();
        zzaim.zzd(this.zzb.zzc()).zza(this.zzc);
        zzaas.zza(this.zze.zza, this.zzd, this.zzb, zza2.get(0), zzaim, (zzaft) this.zza);
    }
}
