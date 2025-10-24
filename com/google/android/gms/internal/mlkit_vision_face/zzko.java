package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.common.api.Api;

public final class zzko {
    /* access modifiers changed from: private */
    public zzjt zza;
    /* access modifiers changed from: private */
    public zzjp zzb;
    /* access modifiers changed from: private */
    public zzjl zzc;
    /* access modifiers changed from: private */
    public Integer zzd;
    /* access modifiers changed from: private */
    public Integer zze;

    public final zzko zzd(Integer num) {
        this.zzd = Integer.valueOf(num.intValue() & Api.BaseClientBuilder.API_PRIORITY_OTHER);
        return this;
    }

    public final zzko zze(zzjl zzjl) {
        this.zzc = zzjl;
        return this;
    }

    public final zzko zzf(zzjp zzjp) {
        this.zzb = zzjp;
        return this;
    }

    public final zzko zzg(zzjt zzjt) {
        this.zza = zzjt;
        return this;
    }

    public final zzko zzh(Integer num) {
        this.zze = Integer.valueOf(num.intValue() & Api.BaseClientBuilder.API_PRIORITY_OTHER);
        return this;
    }

    public final zzkq zzi() {
        return new zzkq(this, (zzkp) null);
    }
}
