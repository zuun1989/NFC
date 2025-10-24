package com.google.android.gms.internal.p002firebaseauthapi;

import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaiw  reason: invalid package */
public final class zzaiw extends zzais {
    private static final String zza = "zzaiw";
    private String zzb;

    /* access modifiers changed from: private */
    /* renamed from: zzc */
    public final zzaiw zzb(String str) throws zzaco {
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("phoneSessionInfo");
            if (optJSONObject != null) {
                this.zzb = zzac.zza(optJSONObject.optString("sessionInfo"));
            }
            return this;
        } catch (NullPointerException | JSONException e) {
            throw zzajl.zza(e, zza, str);
        }
    }

    public final /* synthetic */ zzafa zza(String str) throws zzaco {
        return (zzaiw) zza(str);
    }

    public final String zza() {
        return this.zzb;
    }
}
