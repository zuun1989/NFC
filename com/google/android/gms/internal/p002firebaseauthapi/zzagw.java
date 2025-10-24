package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzagw  reason: invalid package */
public class zzagw implements zzafa<zzagw> {
    private static final String zza = "zzagw";
    private List<String> zzb;

    public zzagw() {
        zzaix.zza();
    }

    /* access modifiers changed from: private */
    /* renamed from: zzb */
    public final zzagw zza(String str) throws zzaco {
        try {
            JSONObject jSONObject = new JSONObject(str);
            jSONObject.optString("authUri", (String) null);
            jSONObject.optBoolean("registered", false);
            jSONObject.optString("providerId", (String) null);
            jSONObject.optBoolean("forExistingProvider", false);
            if (!jSONObject.has("allProviders")) {
                zzaix.zza();
            } else {
                new zzaix(1, zzajl.zza(jSONObject.optJSONArray("allProviders")));
            }
            this.zzb = zzajl.zza(jSONObject.optJSONArray("signinMethods"));
            return this;
        } catch (JSONException e) {
            e = e;
            throw zzajl.zza(e, zza, str);
        } catch (NullPointerException e2) {
            e = e2;
            throw zzajl.zza(e, zza, str);
        }
    }

    public final List<String> zza() {
        return this.zzb;
    }
}
