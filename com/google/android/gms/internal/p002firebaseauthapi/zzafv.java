package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.internal.Preconditions;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import org.json.JSONException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzafv  reason: invalid package */
public final class zzafv {
    private static final boolean zza(int i) {
        return i >= 200 && i < 300;
    }

    private static void zza(HttpURLConnection httpURLConnection, zzafw<?> zzafw, Type type) {
        InputStream inputStream;
        BufferedReader bufferedReader;
        try {
            int responseCode = httpURLConnection.getResponseCode();
            if (zza(responseCode)) {
                inputStream = httpURLConnection.getInputStream();
            } else {
                inputStream = httpURLConnection.getErrorStream();
            }
            StringBuilder sb2 = new StringBuilder();
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                sb2.append(readLine);
            }
            bufferedReader.close();
            String sb3 = sb2.toString();
            if (!zza(responseCode)) {
                zzafw.zza((String) zzaey.zza(sb3, String.class));
            } else {
                zzafw.zza((zzafa) zzaey.zza(sb3, type));
            }
            httpURLConnection.disconnect();
            return;
        } catch (SocketTimeoutException unused) {
            zzafw.zza("TIMEOUT");
            httpURLConnection.disconnect();
            return;
        } catch (IOException e) {
            e = e;
            try {
                zzafw.zza(e.getMessage());
                httpURLConnection.disconnect();
                return;
            } catch (Throwable th) {
                httpURLConnection.disconnect();
                throw th;
            }
        } catch (zzaco e2) {
            e = e2;
            zzafw.zza(e.getMessage());
            httpURLConnection.disconnect();
            return;
        } catch (Throwable th2) {
            th.addSuppressed(th2);
        }
        throw th;
    }

    public static void zza(String str, zzafw<?> zzafw, Type type, zzaff zzaff) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setConnectTimeout(60000);
            zzaff.zza((URLConnection) httpURLConnection);
            zza(httpURLConnection, zzafw, type);
        } catch (SocketTimeoutException unused) {
            zzafw.zza("TIMEOUT");
        } catch (UnknownHostException unused2) {
            zzafw.zza("<<Network Error>>");
        } catch (IOException e) {
            zzafw.zza(e.getMessage());
        }
    }

    public static void zza(String str, zzafb zzafb, zzafw<?> zzafw, Type type, zzaff zzaff) {
        BufferedOutputStream bufferedOutputStream;
        try {
            Preconditions.checkNotNull(zzafb);
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setDoOutput(true);
            byte[] bytes = zzafb.zza().getBytes(Charset.defaultCharset());
            httpURLConnection.setFixedLengthStreamingMode(bytes.length);
            httpURLConnection.setRequestProperty("Content-Type", "application/json");
            httpURLConnection.setConnectTimeout(60000);
            zzaff.zza((URLConnection) httpURLConnection);
            bufferedOutputStream = new BufferedOutputStream(httpURLConnection.getOutputStream(), bytes.length);
            bufferedOutputStream.write(bytes, 0, bytes.length);
            bufferedOutputStream.close();
            zza(httpURLConnection, zzafw, type);
            return;
        } catch (SocketTimeoutException unused) {
            zzafw.zza("TIMEOUT");
            return;
        } catch (UnknownHostException unused2) {
            zzafw.zza("<<Network Error>>");
            return;
        } catch (IOException | NullPointerException | JSONException e) {
            zzafw.zza(e.getMessage());
            return;
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }
}
