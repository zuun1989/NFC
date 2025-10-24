package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.internal.Preconditions;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzagv  reason: invalid package */
public final class zzagv implements zzafb {
    private String zza;

    public zzagv(String str) {
        this.zza = Preconditions.checkNotEmpty(str);
    }

    public final String zza() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("idToken", this.zza);
        return jSONObject.toString();
    }
}
