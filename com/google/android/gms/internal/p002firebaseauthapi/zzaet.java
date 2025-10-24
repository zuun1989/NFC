package com.google.android.gms.internal.p002firebaseauthapi;

import X6.b;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.logging.Logger;
import java.net.HttpURLConnection;
import java.net.URL;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaet  reason: invalid package */
public interface zzaet {
    public static final Logger zza = new Logger("FirebaseAuth", "GetAuthDomainTaskResponseHandler");

    Context zza();

    Uri.Builder zza(Intent intent, String str, String str2);

    String zza(String str);

    HttpURLConnection zza(URL url);

    void zza(Uri uri, String str, b bVar);

    void zza(String str, Status status);
}
