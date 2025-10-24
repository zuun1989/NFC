package com.google.android.gms.internal.p002firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzbr  reason: invalid package */
public final class zzbr implements zzod {
    /* access modifiers changed from: private */
    public static final zzbt zza = new zzbu();
    /* access modifiers changed from: private */
    public final zzbh zzb;
    /* access modifiers changed from: private */
    public final zzxb zzc;
    private final zzbj zzd;
    /* access modifiers changed from: private */
    public final int zze;
    /* access modifiers changed from: private */
    public final boolean zzf;
    /* access modifiers changed from: private */
    public final boolean zzg;
    private final zzbt zzh;

    private zzbr(zzbh zzbh, zzxb zzxb, int i, boolean z, boolean z2, zzbt zzbt) {
        zzbj zzbj;
        this.zzb = zzbh;
        this.zzc = zzxb;
        int i2 = zzbn.zza[zzxb.ordinal()];
        if (i2 == 1) {
            zzbj = zzbj.zza;
        } else if (i2 != 2) {
            zzbj = zzbj.zzb;
        } else {
            zzbj = zzbj.zzc;
        }
        this.zzd = zzbj;
        this.zze = i;
        this.zzf = z;
        this.zzg = z2;
        this.zzh = zzbt;
    }

    public static /* synthetic */ void zzd(zzbr zzbr) {
    }

    public final int zza() {
        return this.zze;
    }

    public final zzbh zzb() {
        this.zzh.zza(this);
        return this.zzb;
    }

    public final zzbj zzc() {
        return this.zzd;
    }

    public final boolean zze() {
        return this.zzf;
    }
}
