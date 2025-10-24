package com.google.android.gms.internal.p002firebaseauthapi;

import android.text.TextUtils;
import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzagu  reason: invalid package */
public class zzagu implements zzafa<zzagu> {
    private static final String zza = "com.google.android.gms.internal.firebase-auth-api.zzagu";
    private String zzb;

    /* access modifiers changed from: private */
    /* renamed from: zzb */
    public final zzagu zza(String str) throws zzaco {
        try {
            JSONObject jSONObject = new JSONObject(new JSONObject(str).getString("error"));
            jSONObject.getInt("code");
            this.zzb = jSONObject.getString("message");
            return this;
        } catch (NullPointerException | JSONException e) {
            String str2 = zza;
            String message = e.getMessage();
            Log.e(str2, "Failed to parse error for string [" + str + "] with exception: " + message);
            throw new zzaco("Failed to parse error for string [" + str + "]", e);
        }
    }

    public final String zza() {
        return this.zzb;
    }

    public final boolean zzb() {
        return !TextUtils.isEmpty(this.zzb);
    }
}
