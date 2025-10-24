package com.google.android.gms.internal.measurement;

import android.util.Log;

final class zzke extends zzkm {
    public zzke(zzkg zzkg, String str, Double d, boolean z) {
        super(zzkg, "measurement.test.double_flag", d, true, (byte[]) null);
    }

    public final /* synthetic */ Object zza(Object obj) {
        if (obj instanceof Double) {
            return (Double) obj;
        }
        if (obj instanceof Float) {
            return Double.valueOf(((Float) obj).doubleValue());
        }
        if (obj instanceof String) {
            try {
                return Double.valueOf(Double.parseDouble((String) obj));
            } catch (NumberFormatException unused) {
            }
        }
        String str = this.zzb;
        String obj2 = obj.toString();
        StringBuilder sb2 = new StringBuilder(str.length() + 27 + obj2.length());
        sb2.append("Invalid double value for ");
        sb2.append(str);
        sb2.append(": ");
        sb2.append(obj2);
        Log.e("PhenotypeFlag", sb2.toString());
        return null;
    }
}
