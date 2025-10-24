package com.google.android.gms.internal.p002firebaseauthapi;

import j6.z0;
import java.util.Objects;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzabl  reason: invalid package */
final class zzabl implements zzafw<zzaiq> {
    private final /* synthetic */ zzaem zza;
    private final /* synthetic */ zzaft zzb;
    private final /* synthetic */ zzaas zzc;

    public zzabl(zzaas zzaas, zzaem zzaem, zzaft zzaft) {
        this.zza = zzaem;
        this.zzb = zzaft;
        Objects.requireNonNull(zzaas);
        this.zzc = zzaas;
    }

    public final void zza(String str) {
        this.zzb.zza(str);
    }

    public final /* synthetic */ void zza(Object obj) {
        zzaiq zzaiq = (zzaiq) obj;
        this.zzc.zza(new zzahw(zzaiq.zzc(), zzaiq.zzb(), Long.valueOf(zzaiq.zza()), "Bearer"), (String) null, "password", Boolean.FALSE, (z0) null, this.zza, this);
    }
}
