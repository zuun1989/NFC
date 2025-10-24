package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.util.Strings;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaiq  reason: invalid package */
public class zzaiq implements zzafa<zzaiq> {
    private static final String zza = "zzaiq";
    private String zzb;
    private String zzc;
    private long zzd;

    /* access modifiers changed from: private */
    /* renamed from: zzb */
    public final zzaiq zza(String str) throws zzaco {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.zzb = Strings.emptyToNull(jSONObject.optString("idToken", (String) null));
            Strings.emptyToNull(jSONObject.optString("displayName", (String) null));
            Strings.emptyToNull(jSONObject.optString(Scopes.EMAIL, (String) null));
            this.zzc = Strings.emptyToNull(jSONObject.optString("refreshToken", (String) null));
            this.zzd = jSONObject.optLong("expiresIn", 0);
            return this;
        } catch (NullPointerException | JSONException e) {
            throw zzajl.zza(e, zza, str);
        }
    }

    public final long zza() {
        return this.zzd;
    }

    public final String zzc() {
        return this.zzc;
    }

    public final String zzb() {
        return this.zzb;
    }
}
