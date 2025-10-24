package com.google.android.gms.internal.p002firebaseauthapi;

import android.text.TextUtils;
import j6.z0;
import java.util.Objects;
import k6.r;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzabs  reason: invalid package */
final class zzabs implements zzafw<zzajm> {
    private final /* synthetic */ zzaem zza;
    private final /* synthetic */ zzabt zzb;

    public zzabs(zzabt zzabt, zzaem zzaem) {
        this.zza = zzaem;
        Objects.requireNonNull(zzabt);
        this.zzb = zzabt;
    }

    public final void zza(String str) {
        this.zza.zza(r.a(str));
    }

    public final /* synthetic */ void zza(Object obj) {
        zzajm zzajm = (zzajm) obj;
        if (TextUtils.isEmpty(zzajm.zza()) || TextUtils.isEmpty(zzajm.zzb())) {
            this.zza.zza(r.a("INTERNAL_SUCCESS_SIGN_OUT"));
            return;
        }
        this.zzb.zza.zza(new zzahw(zzajm.zzb(), zzajm.zza(), Long.valueOf(zzahy.zza(zzajm.zza())), "Bearer"), (String) null, (String) null, Boolean.FALSE, (z0) null, this.zza, this);
    }
}
