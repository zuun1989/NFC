package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Objects;
import k6.r;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzabv  reason: invalid package */
final class zzabv implements zzafw<zzaje> {
    private final /* synthetic */ zzaem zza;
    private final /* synthetic */ zzaas zzb;

    public zzabv(zzaas zzaas, zzaem zzaem) {
        this.zza = zzaem;
        Objects.requireNonNull(zzaas);
        this.zzb = zzaas;
    }

    public final void zza(String str) {
        this.zza.zza(r.a(str));
    }

    public final /* synthetic */ void zza(Object obj) {
        zzaje zzaje = (zzaje) obj;
        if (!zzaje.zzl()) {
            zzaas.zza(this.zzb, zzaje, this.zza, (zzaft) this);
        } else {
            this.zza.zza(new zzaat(zzaje.zzf(), zzaje.zzk(), zzaje.zzb()));
        }
    }
}
