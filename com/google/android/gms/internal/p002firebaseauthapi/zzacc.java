package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.List;
import java.util.Objects;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzacc  reason: invalid package */
final class zzacc implements zzafw<zzahm> {
    private final /* synthetic */ zzafw zza;
    private final /* synthetic */ zzaem zzb;
    private final /* synthetic */ zzahw zzc;

    public zzacc(zzacd zzacd, zzafw zzafw, zzaem zzaem, zzahw zzahw) {
        this.zza = zzafw;
        this.zzb = zzaem;
        this.zzc = zzahw;
        Objects.requireNonNull(zzacd);
    }

    public final void zza(String str) {
        this.zza.zza(str);
    }

    public final /* synthetic */ void zza(Object obj) {
        List<zzahl> zza2 = ((zzahm) obj).zza();
        if (zza2 == null || zza2.isEmpty()) {
            this.zza.zza("No users");
        } else {
            this.zzb.zza(this.zzc, zza2.get(0));
        }
    }
}
