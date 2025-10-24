package com.google.android.gms.internal.measurement;

import android.net.Uri;
import w0.a;

public final class zzkb {
    public static final /* synthetic */ int zza = 0;
    private static final a zzb = new a();

    public static synchronized Uri zza(String str) {
        synchronized (zzkb.class) {
            a aVar = zzb;
            Uri uri = (Uri) aVar.get("com.google.android.gms.measurement");
            if (uri != null) {
                return uri;
            }
            Uri parse = Uri.parse("content://com.google.android.gms.phenotype/".concat(String.valueOf(Uri.encode("com.google.android.gms.measurement"))));
            aVar.put("com.google.android.gms.measurement", parse);
            return parse;
        }
    }
}
