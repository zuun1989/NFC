package com.google.android.gms.internal.fido;

import java.util.Arrays;

public final class zzam {
    private final String zza;
    private final zzak zzb;
    private zzak zzc;

    public /* synthetic */ zzam(String str, zzal zzal) {
        zzak zzak = new zzak((zzaj) null);
        this.zzb = zzak;
        this.zzc = zzak;
        str.getClass();
        this.zza = str;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder(32);
        sb2.append(this.zza);
        sb2.append('{');
        zzak zzak = this.zzb.zzc;
        String str = "";
        while (zzak != null) {
            Object obj = zzak.zzb;
            sb2.append(str);
            String str2 = zzak.zza;
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
            zzak = zzak.zzc;
            str = ", ";
        }
        sb2.append('}');
        return sb2.toString();
    }

    public final zzam zza(String str, int i) {
        String valueOf = String.valueOf(i);
        zzai zzai = new zzai((zzah) null);
        this.zzc.zzc = zzai;
        this.zzc = zzai;
        zzai.zzb = valueOf;
        zzai.zza = "errorCode";
        return this;
    }

    public final zzam zzb(String str, Object obj) {
        zzak zzak = new zzak((zzaj) null);
        this.zzc.zzc = zzak;
        this.zzc = zzak;
        zzak.zzb = obj;
        zzak.zza = str;
        return this;
    }
}
