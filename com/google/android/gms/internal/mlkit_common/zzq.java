package com.google.android.gms.internal.mlkit_common;

import java.util.Arrays;

public final class zzq {
    private final String zza;
    private final zzo zzb;
    private zzo zzc;

    public /* synthetic */ zzq(String str, zzp zzp) {
        zzo zzo = new zzo();
        this.zzb = zzo;
        this.zzc = zzo;
        str.getClass();
        this.zza = str;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder(32);
        sb2.append(this.zza);
        sb2.append('{');
        zzo zzo = this.zzb.zzc;
        String str = "";
        while (zzo != null) {
            Object obj = zzo.zzb;
            sb2.append(str);
            String str2 = zzo.zza;
            if (str2 != null) {
                sb2.append(str2);
                sb2.append('=');
            }
            if (obj == null || !obj.getClass().isArray()) {
                sb2.append(obj);
            } else {
                String deepToString = Arrays.deepToString(new Object[]{obj});
                sb2.append(deepToString, 1, deepToString.length() - 1);
            }
            zzo = zzo.zzc;
            str = ", ";
        }
        sb2.append('}');
        return sb2.toString();
    }

    public final zzq zza(String str, Object obj) {
        zzo zzo = new zzo();
        this.zzc.zzc = zzo;
        this.zzc = zzo;
        zzo.zzb = obj;
        zzo.zza = str;
        return this;
    }

    public final zzq zzb(String str, boolean z) {
        String valueOf = String.valueOf(z);
        zzn zzn = new zzn((zzm) null);
        this.zzc.zzc = zzn;
        this.zzc = zzn;
        zzn.zzb = valueOf;
        zzn.zza = "isManifestFile";
        return this;
    }
}
