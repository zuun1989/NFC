package com.google.android.gms.internal.p002firebaseauthapi;

import android.text.TextUtils;
import com.google.android.gms.common.api.Status;
import j6.O;
import j6.z0;
import java.util.Objects;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzabn  reason: invalid package */
final class zzabn implements zzafw<zzajk> {
    private final /* synthetic */ zzaem zza;
    private final /* synthetic */ zzafw zzb;
    private final /* synthetic */ zzabk zzc;

    public zzabn(zzabk zzabk, zzaem zzaem, zzafw zzafw) {
        this.zza = zzaem;
        this.zzb = zzafw;
        Objects.requireNonNull(zzabk);
        this.zzc = zzabk;
    }

    public final void zza(String str) {
        this.zzb.zza(str);
    }

    public final /* synthetic */ void zza(Object obj) {
        zzajk zzajk = (zzajk) obj;
        if (!TextUtils.isEmpty(zzajk.zze())) {
            this.zza.zza(new Status(17025), O.Q1(zzajk.zzc(), zzajk.zze()));
            return;
        }
        this.zzc.zza.zza(new zzahw(zzajk.zzd(), zzajk.zzb(), Long.valueOf(zzajk.zza()), "Bearer"), (String) null, "phone", Boolean.valueOf(zzajk.zzf()), (z0) null, this.zza, this.zzb);
    }
}
