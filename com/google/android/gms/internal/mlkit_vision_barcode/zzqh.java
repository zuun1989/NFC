package com.google.android.gms.internal.mlkit_vision_barcode;

import com.google.android.gms.common.api.Api;

public final class zzqh {
    /* access modifiers changed from: private */
    public zzqi zza;
    /* access modifiers changed from: private */
    public Integer zzb;

    public final zzqh zza(zzqi zzqi) {
        this.zza = zzqi;
        return this;
    }

    public final zzqh zzb(Integer num) {
        this.zzb = Integer.valueOf(num.intValue() & Api.BaseClientBuilder.API_PRIORITY_OTHER);
        return this;
    }

    public final zzqk zzd() {
        return new zzqk(this, (zzqj) null);
    }
}
