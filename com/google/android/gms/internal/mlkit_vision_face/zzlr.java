package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.common.api.Api;

public final class zzlr {
    /* access modifiers changed from: private */
    public String zza;
    /* access modifiers changed from: private */
    public String zzb;
    /* access modifiers changed from: private */
    public String zzc;
    /* access modifiers changed from: private */
    public String zzd;
    /* access modifiers changed from: private */
    public zzbn zze;
    /* access modifiers changed from: private */
    public String zzf;
    /* access modifiers changed from: private */
    public Boolean zzg;
    /* access modifiers changed from: private */
    public Boolean zzh;
    /* access modifiers changed from: private */
    public Boolean zzi;
    /* access modifiers changed from: private */
    public Integer zzj;
    /* access modifiers changed from: private */
    public Integer zzk;

    public final zzlr zzb(String str) {
        this.zza = str;
        return this;
    }

    public final zzlr zzc(String str) {
        this.zzb = str;
        return this;
    }

    public final zzlr zzd(Integer num) {
        this.zzj = Integer.valueOf(num.intValue() & Api.BaseClientBuilder.API_PRIORITY_OTHER);
        return this;
    }

    public final zzlr zze(Boolean bool) {
        this.zzg = bool;
        return this;
    }

    public final zzlr zzf(Boolean bool) {
        this.zzi = bool;
        return this;
    }

    public final zzlr zzg(Boolean bool) {
        this.zzh = bool;
        return this;
    }

    public final zzlr zzh(zzbn zzbn) {
        this.zze = zzbn;
        return this;
    }

    public final zzlr zzi(String str) {
        this.zzf = str;
        return this;
    }

    public final zzlr zzj(String str) {
        this.zzc = str;
        return this;
    }

    public final zzlr zzk(Integer num) {
        this.zzk = num;
        return this;
    }

    public final zzlr zzl(String str) {
        this.zzd = str;
        return this;
    }

    public final zzlt zzm() {
        return new zzlt(this, (zzls) null);
    }
}
