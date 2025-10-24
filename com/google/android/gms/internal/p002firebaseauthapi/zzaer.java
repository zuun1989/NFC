package com.google.android.gms.internal.p002firebaseauthapi;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.text.TextUtils;
import b6.g;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.logging.Logger;
import com.google.firebase.auth.FirebaseAuth;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import k6.r;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaer  reason: invalid package */
public final class zzaer extends AsyncTask<Void, Void, zzaeq> {
    private static final Logger zza = new Logger("FirebaseAuth", "GetAuthDomainTask");
    private final String zzb;
    private final String zzc;
    private final WeakReference<zzaet> zzd;
    private final Uri.Builder zze;
    private final String zzf;
    private final g zzg;

    public zzaer(String str, String str2, Intent intent, g gVar, zzaet zzaet) {
        this.zzb = Preconditions.checkNotEmpty(str);
        this.zzg = (g) Preconditions.checkNotNull(gVar);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(intent);
        String checkNotEmpty = Preconditions.checkNotEmpty(intent.getStringExtra("com.google.firebase.auth.KEY_API_KEY"));
        Uri.Builder buildUpon = Uri.parse(zzaet.zza(checkNotEmpty)).buildUpon();
        buildUpon.appendPath("getProjectConfig").appendQueryParameter("key", checkNotEmpty).appendQueryParameter("androidPackageName", str).appendQueryParameter("sha1Cert", (String) Preconditions.checkNotNull(str2));
        this.zzc = buildUpon.build().toString();
        this.zzd = new WeakReference<>(zzaet);
        this.zze = zzaet.zza(intent, str, str2);
        this.zzf = intent.getStringExtra("com.google.firebase.auth.KEY_CUSTOM_AUTH_DOMAIN");
    }

    /* access modifiers changed from: private */
    /* renamed from: zza */
    public final zzaeq doInBackground(Void... voidArr) {
        try {
            URL url = new URL(this.zzc);
            zzaet zzaet = this.zzd.get();
            HttpURLConnection zza2 = zzaet.zza(url);
            zza2.addRequestProperty("Content-Type", "application/json; charset=UTF-8");
            zza2.setConnectTimeout(60000);
            new zzaff(zzaet.zza(), this.zzg, zzafd.zza().zzb()).zza((URLConnection) zza2);
            int responseCode = zza2.getResponseCode();
            if (responseCode != 200) {
                String zza3 = zza(zza2);
                zza.e(String.format("Error getting project config. Failed with %s %s", new Object[]{zza3, Integer.valueOf(responseCode)}), new Object[0]);
                return zzaeq.zzb(zza3);
            }
            zzahr zzahr = new zzahr();
            zzahr.zza(new String(zza(zza2.getInputStream(), 128)));
            if (TextUtils.isEmpty(this.zzf)) {
                for (String next : zzahr.zza()) {
                    if (zza(next)) {
                        return zzaeq.zza(next);
                    }
                }
                return null;
            } else if (!zzahr.zza().contains(this.zzf)) {
                return zzaeq.zzb("UNAUTHORIZED_DOMAIN");
            } else {
                return zzaeq.zza(this.zzf);
            }
        } catch (IOException e) {
            Logger logger = zza;
            String message = e.getMessage();
            logger.e("IOException occurred: " + message, new Object[0]);
            return null;
        } catch (NullPointerException e2) {
            Logger logger2 = zza;
            String message2 = e2.getMessage();
            logger2.e("Null pointer encountered: " + message2, new Object[0]);
            return null;
        } catch (zzaco e3) {
            Logger logger3 = zza;
            String message3 = e3.getMessage();
            logger3.e("ConversionException encountered: " + message3, new Object[0]);
            return null;
        }
    }

    public final /* synthetic */ void onCancelled(Object obj) {
        zzaeq zzaeq = (zzaeq) obj;
        onPostExecute((zzaeq) null);
    }

    private static String zza(HttpURLConnection httpURLConnection) throws zzaco {
        try {
            if (httpURLConnection.getResponseCode() < 400) {
                return null;
            }
            InputStream errorStream = httpURLConnection.getErrorStream();
            if (errorStream != null) {
                return (String) zzaey.zza(new String(zza(errorStream, 128)), String.class);
            }
            return "WEB_INTERNAL_ERROR:" + "Could not retrieve the authDomain for this project but did not receive an error response from the network request. Please try again.";
        } catch (IOException e) {
            Logger logger = zza;
            String valueOf = String.valueOf(e);
            logger.w("Error parsing error message from response body in getErrorMessageFromBody. " + valueOf, new Object[0]);
            return null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: zza */
    public final void onPostExecute(zzaeq zzaeq) {
        String str;
        String str2;
        Uri.Builder builder;
        zzaet zzaet = this.zzd.get();
        if (zzaeq != null) {
            str2 = zzaeq.zza();
            str = zzaeq.zzb();
        } else {
            str2 = null;
            str = null;
        }
        if (zzaet == null) {
            zza.e("An error has occurred: the handler reference has returned null.", new Object[0]);
        } else if (TextUtils.isEmpty(str2) || (builder = this.zze) == null) {
            zzaet.zza(this.zzb, r.a(str));
        } else {
            builder.authority(str2);
            zzaet.zza(this.zze.build(), this.zzb, FirebaseAuth.getInstance(this.zzg).t0());
        }
    }

    private static boolean zza(String str) {
        try {
            String host = new URI("https://" + str).getHost();
            if (host == null || (!host.endsWith("firebaseapp.com") && !host.endsWith("web.app"))) {
                return false;
            }
            return true;
        } catch (URISyntaxException e) {
            Logger logger = zza;
            String message = e.getMessage();
            logger.e("Error parsing URL for auth domain check: " + str + ". " + message, new Object[0]);
        }
    }

    private static byte[] zza(InputStream inputStream, int i) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byte[] bArr = new byte[128];
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.close();
                    return byteArray;
                }
            }
        } catch (Throwable th) {
            byteArrayOutputStream.close();
            throw th;
        }
    }
}
