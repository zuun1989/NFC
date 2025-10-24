package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.List;
import java.util.Objects;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaay  reason: invalid package */
final class zzaay implements zzafw<zzahm> {
    private final /* synthetic */ zzaft zza;
    private final /* synthetic */ zzaem zzb;
    private final /* synthetic */ zzahw zzc;
    private final /* synthetic */ zzaim zzd;
    private final /* synthetic */ zzaas zze;

    public zzaay(zzaas zzaas, zzaft zzaft, zzaem zzaem, zzahw zzahw, zzaim zzaim) {
        this.zza = zzaft;
        this.zzb = zzaem;
        this.zzc = zzahw;
        this.zzd = zzaim;
        Objects.requireNonNull(zzaas);
        this.zze = zzaas;
    }

    public final void zza(String str) {
        this.zza.zza(str);
    }

    public final /* synthetic */ void zza(Object obj) {
        List<zzahl> zza2 = ((zzahm) obj).zza();
        if (zza2 == null || zza2.isEmpty()) {
            this.zza.zza("No users");
        } else {
            zzaas.zza(this.zze, this.zzb, this.zzc, zza2.get(0), this.zzd, this.zza);
        }
    }
}
