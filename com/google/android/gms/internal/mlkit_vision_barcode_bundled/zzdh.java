package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import com.google.android.gms.common.api.Api;

final class zzdh extends zzdj {
    private int zzb = 0;
    private int zzc;
    private int zzd = Api.BaseClientBuilder.API_PRIORITY_OTHER;

    public /* synthetic */ zzdh(byte[] bArr, int i, int i2, boolean z, zzdg zzdg) {
        super((zzdi) null);
    }

    public final int zza(int i) throws zzer {
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
