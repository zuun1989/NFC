package com.google.android.gms.internal.measurement;

import android.util.Log;

final class zzkc extends zzkm {
    public zzkc(zzkg zzkg, String str, Long l, boolean z) {
        super(zzkg, str, l, true, (byte[]) null);
    }

    public final /* synthetic */ Object zza(Object obj) {
        if (obj instanceof Long) {
            return (Long) obj;
        }
        if (obj instanceof String) {
            try {
                return Long.valueOf(Long.parseLong((String) obj));
            } catch (NumberFormatException unused) {
            }
        }
        String str = this.zzb;
        String obj2 = obj.toString();
        StringBuilder sb2 = new StringBuilder(str.length() + 25 + obj2.length());
        sb2.append("Invalid long value for ");
        sb2.append(str);
        sb2.append(": ");
        sb2.append(obj2);
        Log.e("PhenotypeFlag", sb2.toString());
        return null;
    }
}
