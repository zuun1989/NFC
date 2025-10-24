package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.internal.Preconditions;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzahk  reason: invalid package */
public final class zzahk implements zzafb {
    private String zza = zzahi.REFRESH_TOKEN.toString();
    private String zzb;

    public zzahk(String str) {
        this.zzb = Preconditions.checkNotEmpty(str);
    }

    public final String zza() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("grantType", this.zza);
        jSONObject.put("refreshToken", this.zzb);
        return jSONObject.toString();
    }
}
