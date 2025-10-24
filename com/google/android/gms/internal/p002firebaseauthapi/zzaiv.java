package com.google.android.gms.internal.p002firebaseauthapi;

import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaiv  reason: invalid package */
public final class zzaiv implements zzaip {
    private final String zza;
    private final String zzb;

    private zzaiv(String str, String str2) {
        this.zza = Preconditions.checkNotEmpty(str);
        this.zzb = str2;
    }

    public static zzaiv zza(String str, String str2) {
        return new zzaiv(str, str2);
    }

    public final String zza() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("idToken", this.zza);
        if (!TextUtils.isEmpty(this.zzb)) {
            jSONObject.put("tenantId", this.zzb);
        }
        jSONObject.put("totpEnrollmentInfo", new JSONObject());
        return jSONObject.toString();
    }
}
