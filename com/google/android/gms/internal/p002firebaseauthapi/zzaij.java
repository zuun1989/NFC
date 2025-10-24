package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.util.Strings;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaij  reason: invalid package */
public class zzaij implements zzafa<zzaij> {
    private static final String zza = "zzaij";
    private String zzb;

    /* access modifiers changed from: private */
    /* renamed from: zzb */
    public final zzaij zza(String str) throws zzaco {
        try {
            this.zzb = Strings.emptyToNull(new JSONObject(str).optString("sessionInfo", (String) null));
            return this;
        } catch (NullPointerException | JSONException e) {
            throw zzajl.zza(e, zza, str);
        }
    }

    public final String zza() {
        return this.zzb;
    }
}
