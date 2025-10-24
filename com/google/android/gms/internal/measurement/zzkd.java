package com.google.android.gms.internal.measurement;

import android.util.Log;

final class zzkd extends zzkm {
    public zzkd(zzkg zzkg, String str, Boolean bool, boolean z) {
        super(zzkg, str, bool, true, (byte[]) null);
    }

    public final /* synthetic */ Object zza(Object obj) {
        if (obj instanceof Boolean) {
            return (Boolean) obj;
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (zzjg.zzc.matcher(str).matches()) {
                return Boolean.TRUE;
            }
            if (zzjg.zzd.matcher(str).matches()) {
                return Boolean.FALSE;
            }
        }
        String str2 = this.zzb;
        String obj2 = obj.toString();
        StringBuilder sb2 = new StringBuilder(str2.length() + 28 + obj2.length());
        sb2.append("Invalid boolean value for ");
        sb2.append(str2);
        sb2.append(": ");
        sb2.append(obj2);
        Log.e("PhenotypeFlag", sb2.toString());
        return null;
    }
}
