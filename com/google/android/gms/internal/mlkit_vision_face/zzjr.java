package com.google.android.gms.internal.mlkit_vision_face;

public final class zzjr {
    /* access modifiers changed from: private */
    public Long zza;
    /* access modifiers changed from: private */
    public zzka zzb;
    /* access modifiers changed from: private */
    public Boolean zzc;
    /* access modifiers changed from: private */
    public Boolean zzd;
    /* access modifiers changed from: private */
    public Boolean zze;

    public final zzjr zza(Boolean bool) {
        this.zzd = bool;
        return this;
    }

    public final zzjr zzb(Boolean bool) {
        this.zze = bool;
        return this;
    }

    public final zzjr zzc(Long l) {
        this.zza = Long.valueOf(l.longValue() & Long.MAX_VALUE);
        return this;
    }

    public final zzjr zzd(zzka zzka) {
        this.zzb = zzka;
        return this;
    }

    public final zzjr zze(Boolean bool) {
        this.zzc = bool;
        return this;
    }

    public final zzjt zzf() {
        return new zzjt(this, (zzjs) null);
    }
}
