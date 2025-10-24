package com.google.android.gms.internal.p002firebaseauthapi;

import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaif  reason: invalid package */
public abstract class zzaif implements zzafb {
    public static zzaii zzg() {
        return new zzags();
    }

    public final String zza() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("idToken", zzc());
        jSONObject.put("token", zzf());
        jSONObject.put("providerId", zzd());
        jSONObject.put("tokenType", zzb().toString());
        jSONObject.put("tenantId", zze());
        return jSONObject.toString();
    }

    public abstract zzahh zzb();

    public abstract String zzc();

    public abstract String zzd();

    public abstract String zze();

    public abstract String zzf();
}
