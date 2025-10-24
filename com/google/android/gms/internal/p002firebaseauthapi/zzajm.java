package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.util.Strings;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzajm  reason: invalid package */
public class zzajm implements zzafa<zzajm> {
    private static final String zza = "zzajm";
    private String zzb;
    private String zzc;

    /* access modifiers changed from: private */
    /* renamed from: zzb */
    public final zzajm zza(String str) throws zzaco {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.zzb = Strings.emptyToNull(jSONObject.optString("idToken"));
            this.zzc = Strings.emptyToNull(jSONObject.optString("refreshToken"));
            return this;
        } catch (NullPointerException | JSONException e) {
            throw zzajl.zza(e, zza, str);
        }
    }

    public final String zza() {
        return this.zzb;
    }

    public final String zzb() {
        return this.zzc;
    }
}
