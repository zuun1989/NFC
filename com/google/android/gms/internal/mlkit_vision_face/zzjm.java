package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.common.api.Api;

public final class zzjm {
    /* access modifiers changed from: private */
    public zzjn zza;
    /* access modifiers changed from: private */
    public Integer zzb;

    public final zzjm zza(zzjn zzjn) {
        this.zza = zzjn;
        return this;
    }

    public final zzjm zzb(Integer num) {
        this.zzb = Integer.valueOf(num.intValue() & Api.BaseClientBuilder.API_PRIORITY_OTHER);
        return this;
    }

    public final zzjp zzd() {
        return new zzjp(this, (zzjo) null);
    }
}
