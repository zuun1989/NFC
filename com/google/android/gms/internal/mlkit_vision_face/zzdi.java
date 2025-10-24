package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.common.api.Api;

public final class zzdi {
    /* access modifiers changed from: private */
    public zzdl zza;
    /* access modifiers changed from: private */
    public Integer zzb;
    /* access modifiers changed from: private */
    public zzjd zzc;

    public final zzdi zza(Integer num) {
        this.zzb = Integer.valueOf(num.intValue() & Api.BaseClientBuilder.API_PRIORITY_OTHER);
        return this;
    }

    public final zzdi zzb(zzjd zzjd) {
        this.zzc = zzjd;
        return this;
    }

    public final zzdi zzc(zzdl zzdl) {
        this.zza = zzdl;
        return this;
    }

    public final zzdn zze() {
        return new zzdn(this, (zzdm) null);
    }
}
