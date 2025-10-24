package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.util.Strings;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzahs  reason: invalid package */
public class zzahs implements zzafa<zzahs> {
    private static final String zza = "zzahs";
    private String zzb;

    public zzahs() {
    }

    /* access modifiers changed from: private */
    /* renamed from: zzb */
    public final zzahs zza(String str) throws zzaco {
        try {
            this.zzb = Strings.emptyToNull(new JSONObject(str).optString("producerProjectNumber"));
            return this;
        } catch (NullPointerException | JSONException e) {
            throw zzajl.zza(e, zza, str);
        }
    }

    public zzahs(String str) {
        this.zzb = str;
    }

    public final String zza() {
        return this.zzb;
    }
}
