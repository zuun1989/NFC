package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.util.Strings;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaiu  reason: invalid package */
public class zzaiu implements zzafa<zzaiu> {
    private static final String zza = "zzaiu";
    private String zzb;

    /* access modifiers changed from: private */
    /* renamed from: zzb */
    public final zzaiu zza(String str) throws zzaco {
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("phoneResponseInfo");
            if (optJSONObject != null) {
                this.zzb = Strings.emptyToNull(optJSONObject.optString("sessionInfo"));
            }
            return this;
        } catch (NullPointerException | JSONException e) {
            throw zzajl.zza(e, zza, str);
        }
    }

    public final String zza() {
        return this.zzb;
    }
}
