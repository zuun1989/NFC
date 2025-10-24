package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.common.api.Api;

public final class zzdj {
    /* access modifiers changed from: private */
    public zzka zza;
    /* access modifiers changed from: private */
    public Boolean zzb;
    /* access modifiers changed from: private */
    public zzjl zzc;
    /* access modifiers changed from: private */
    public Integer zzd;
    /* access modifiers changed from: private */
    public Integer zze;

    public final zzdj zza(Integer num) {
        this.zzd = Integer.valueOf(num.intValue() & Api.BaseClientBuilder.API_PRIORITY_OTHER);
        return this;
    }

    public final zzdj zzb(zzjl zzjl) {
        this.zzc = zzjl;
        return this;
    }

    public final zzdj zzc(zzka zzka) {
        this.zza = zzka;
        return this;
    }

    public final zzdj zzd(Boolean bool) {
        this.zzb = bool;
        return this;
    }

    public final zzdj zze(Integer num) {
        this.zze = Integer.valueOf(num.intValue() & Api.BaseClientBuilder.API_PRIORITY_OTHER);
        return this;
    }

    public final zzdl zzf() {
        return new zzdl(this, (zzdk) null);
    }
}
