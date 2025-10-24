package com.google.android.gms.internal.p002firebaseauthapi;

import android.util.Log;
import java.io.UnsupportedEncodingException;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzahx  reason: invalid package */
public final class zzahx {
    private Long zza;
    private Long zzb;

    public static zzahx zza(String str) throws UnsupportedEncodingException {
        try {
            zzahx zzahx = new zzahx();
            JSONObject jSONObject = new JSONObject(str);
            jSONObject.optString("iss");
            jSONObject.optString("aud");
            jSONObject.optString("sub");
            zzahx.zza = Long.valueOf(jSONObject.optLong("iat"));
            zzahx.zzb = Long.valueOf(jSONObject.optLong("exp"));
            jSONObject.optBoolean("is_anonymous");
            return zzahx;
        } catch (JSONException e) {
            if (Log.isLoggable("JwtToken", 3)) {
                String valueOf = String.valueOf(e);
                Log.d("JwtToken", "Failed to read JwtToken from JSONObject. " + valueOf);
            }
            String valueOf2 = String.valueOf(e);
            throw new UnsupportedEncodingException("Failed to read JwtToken from JSONObject. " + valueOf2);
        }
    }

    public final Long zzb() {
        return this.zza;
    }

    public final Long zza() {
        return this.zzb;
    }
}
