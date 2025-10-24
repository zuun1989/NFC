package com.google.android.gms.internal.p002firebaseauthapi;

import android.text.TextUtils;
import com.google.android.gms.common.Scopes;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzagx  reason: invalid package */
public class zzagx implements zzafa<zzagx> {
    private static final String zza = "zzagx";
    private String zzb;
    private String zzc;
    private boolean zzd;
    private long zze;
    private List<zzahz> zzf;
    private String zzg;

    /* access modifiers changed from: private */
    /* renamed from: zzb */
    public final zzagx zza(String str) throws zzaco {
        try {
            JSONObject jSONObject = new JSONObject(str);
            jSONObject.optString("localId", (String) null);
            jSONObject.optString(Scopes.EMAIL, (String) null);
            this.zzb = jSONObject.optString("idToken", (String) null);
            this.zzc = jSONObject.optString("refreshToken", (String) null);
            this.zzd = jSONObject.optBoolean("isNewUser", false);
            this.zze = jSONObject.optLong("expiresIn", 0);
            this.zzf = zzahz.zza(jSONObject.optJSONArray("mfaInfo"));
            this.zzg = jSONObject.optString("mfaPendingCredential", (String) null);
            return this;
        } catch (NullPointerException | JSONException e) {
            throw zzajl.zza(e, zza, str);
        }
    }

    public final long zza() {
        return this.zze;
    }

    public final String zzc() {
        return this.zzg;
    }

    public final String zzd() {
        return this.zzc;
    }

    public final List<zzahz> zze() {
        return this.zzf;
    }

    public final boolean zzf() {
        if (!TextUtils.isEmpty(this.zzg)) {
            return true;
        }
        return false;
    }

    public final boolean zzg() {
        return this.zzd;
    }

    public final String zzb() {
        return this.zzb;
    }
}
