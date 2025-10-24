package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Objects;
import k6.r;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzabu  reason: invalid package */
final class zzabu implements zzafw<zzais> {
    private final /* synthetic */ zzaip zza;
    private final /* synthetic */ zzaem zzb;

    public zzabu(zzaas zzaas, zzaip zzaip, zzaem zzaem) {
        this.zza = zzaip;
        this.zzb = zzaem;
        Objects.requireNonNull(zzaas);
    }

    public final void zza(String str) {
        this.zzb.zza(r.a(str));
    }

    public final /* synthetic */ void zza(Object obj) {
        zzais zzais = (zzais) obj;
        zzaip zzaip = this.zza;
        if (zzaip instanceof zzait) {
            this.zzb.zzb(zzais.zza());
        } else if (zzaip instanceof zzaiv) {
            this.zzb.zza(zzais);
        } else {
            String name = this.zza.getClass().getName();
            throw new IllegalArgumentException("startMfaEnrollmentRequest must be an instance of either StartPhoneMfaEnrollmentRequest or StartTotpMfaEnrollmentRequest but was " + name + ".");
        }
    }
}
