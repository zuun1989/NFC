package com.google.android.gms.internal.measurement;

import android.net.Uri;
import w0.k;

public final class zzjt {
    private final k zza;

    public zzjt(k kVar) {
        this.zza = kVar;
    }

    public final String zza(Uri uri, String str, String str2, String str3) {
        k kVar;
        if (uri != null) {
            kVar = (k) this.zza.get(uri.toString());
        } else {
            kVar = null;
        }
        if (kVar == null) {
            return null;
        }
        return (String) kVar.get("".concat(str3));
    }
}
