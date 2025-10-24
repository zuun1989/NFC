package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.util.Strings;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzail  reason: invalid package */
public class zzail implements zzafa<zzail> {
    private static final String zza = "zzail";
    private String zzb;
    private zzaib zzc;
    private String zzd;
    private String zze;
    private long zzf;

    /* access modifiers changed from: private */
    /* renamed from: zzb */
    public final zzail zza(String str) throws zzaco {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.zzb = Strings.emptyToNull(jSONObject.optString(Scopes.EMAIL));
            Strings.emptyToNull(jSONObject.optString("passwordHash"));
            jSONObject.optBoolean("emailVerified", false);
            Strings.emptyToNull(jSONObject.optString("displayName"));
            Strings.emptyToNull(jSONObject.optString("photoUrl"));
            this.zzc = zzaib.zza(jSONObject.optJSONArray("providerUserInfo"));
            this.zzd = Strings.emptyToNull(jSONObject.optString("idToken"));
            this.zze = Strings.emptyToNull(jSONObject.optString("refreshToken"));
            this.zzf = jSONObject.optLong("expiresIn", 0);
            return this;
        } catch (NullPointerException | JSONException e) {
            throw zzajl.zza(e, zza, str);
        }
    }

    public final long zza() {
        return this.zzf;
    }

    public final String zzc() {
        return this.zzd;
    }

    public final String zzd() {
        return this.zze;
    }

    public final List<zzaic> zze() {
        zzaib zzaib = this.zzc;
        if (zzaib != null) {
            return zzaib.zza();
        }
        return null;
    }

    public final String zzb() {
        return this.zzb;
    }
}
