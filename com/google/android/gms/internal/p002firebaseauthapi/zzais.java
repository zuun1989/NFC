package com.google.android.gms.internal.p002firebaseauthapi;

import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzais  reason: invalid package */
public class zzais implements zzafa<zzais> {
    private static final String zza = "zzais";

    public String zza() {
        return null;
    }

    /* renamed from: zzb */
    public zzais zza(String str) throws zzaco {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.optJSONObject("phoneSessionInfo") != null) {
                return (zzaiw) ((zzais) new zzaiw().zza(str));
            }
            if (jSONObject.optJSONObject("totpSessionInfo") != null) {
                return (zzaiy) ((zzais) new zzaiy().zza(str));
            }
            throw new IllegalArgumentException("Missing phoneSessionInfo or totpSessionInfo.");
        } catch (JSONException e) {
            e = e;
            throw zzajl.zza(e, zza, str);
        } catch (NullPointerException e2) {
            e = e2;
            throw zzajl.zza(e, zza, str);
        }
    }
}
