package com.google.android.gms.internal.auth;

import android.net.Uri;
import w0.k;

public final class zzci {
    private final k zza;

    public zzci(k kVar) {
        this.zza = kVar;
    }

    public final String zza(Uri uri, String str, String str2, String str3) {
        if (uri == null) {
            return null;
        }
        k kVar = (k) this.zza.get(uri.toString());
        if (kVar == null) {
            return null;
        }
        return (String) kVar.get("".concat(String.valueOf(str3)));
    }
}
