package com.google.android.gms.internal.p002firebaseauthapi;

import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzajl  reason: invalid package */
public final class zzajl {
    public static zzaco zza(Exception exc, String str, String str2) {
        String message = exc.getMessage();
        Log.e(str, "Failed to parse " + str + " for string [" + str2 + "] with exception: " + message);
        return new zzaco("Failed to parse " + str + " for string [" + str2 + "]", exc);
    }

    public static List<String> zza(JSONArray jSONArray) throws JSONException {
        ArrayList arrayList = new ArrayList();
        if (!(jSONArray == null || jSONArray.length() == 0)) {
            for (int i = 0; i < jSONArray.length(); i++) {
                arrayList.add(jSONArray.getString(i));
            }
        }
        return arrayList;
    }

    public static void zza(JSONObject jSONObject) throws JSONException {
        jSONObject.put("clientType", "CLIENT_TYPE_ANDROID");
    }

    public static void zza(JSONObject jSONObject, String str, String str2) throws JSONException {
        jSONObject.put(str, str2);
        jSONObject.put("recaptchaVersion", "RECAPTCHA_ENTERPRISE");
        jSONObject.put("clientType", "CLIENT_TYPE_ANDROID");
    }
}
