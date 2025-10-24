package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.api.Api;

final class zzli extends zzlj {
    private int zzb = 0;
    private int zzc;
    private int zzd = Api.BaseClientBuilder.API_PRIORITY_OTHER;

    public /* synthetic */ zzli(byte[] bArr, int i, int i2, boolean z, byte[] bArr2) {
        super((byte[]) null);
    }

    public final int zza(int i) throws zzmr {
        int i2 = this.zzd;
        this.zzd = 0;
        int i3 = this.zzb + this.zzc;
        this.zzb = i3;
        if (i3 > 0) {
            this.zzc = i3;
            this.zzb = 0;
        } else {
            this.zzc = 0;
        }
        return i2;
    }
}
