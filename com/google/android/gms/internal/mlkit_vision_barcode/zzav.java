package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.Arrays;

public final class zzav {
    private final String zza;
    private final zzat zzb;
    private zzat zzc;

    public /* synthetic */ zzav(String str, zzau zzau) {
        zzat zzat = new zzat();
        this.zzb = zzat;
        this.zzc = zzat;
        str.getClass();
        this.zza = str;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder(32);
        sb2.append(this.zza);
        sb2.append('{');
        zzat zzat = this.zzb.zzb;
        String str = "";
        while (zzat != null) {
            Object obj = zzat.zza;
            sb2.append(str);
            if (obj == null || !obj.getClass().isArray()) {
                sb2.append(obj);
            } else {
                String deepToString = Arrays.deepToString(new Object[]{obj});
                sb2.append(deepToString, 1, deepToString.length() - 1);
            }
            zzat = zzat.zzb;
            str = ", ";
        }
        sb2.append('}');
        return sb2.toString();
    }

    public final zzav zza(Object obj) {
        zzat zzat = new zzat();
        this.zzc.zzb = zzat;
        this.zzc = zzat;
        zzat.zza = obj;
        return this;
    }
}
