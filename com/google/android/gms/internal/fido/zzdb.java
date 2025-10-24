package com.google.android.gms.internal.fido;

import com.google.android.gms.common.api.Api;

final class zzdb extends zzdd {
    private final byte[] zzb;
    private int zzc;
    private int zzd;
    private int zze = Api.BaseClientBuilder.API_PRIORITY_OTHER;

    public /* synthetic */ zzdb(byte[] bArr, int i, int i2, boolean z, zzda zzda) {
        super((zzdc) null);
        this.zzb = bArr;
        this.zzc = 0;
    }

    public final int zza(int i) throws zzdf {
        int i2 = this.zze;
        this.zze = 0;
        int i3 = this.zzc + this.zzd;
        this.zzc = i3;
        if (i3 > 0) {
            this.zzd = i3;
            this.zzc = 0;
        } else {
            this.zzd = 0;
        }
        return i2;
    }
}
