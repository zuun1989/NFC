package com.google.android.gms.internal.p002firebaseauthapi;

import android.text.TextUtils;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.util.Strings;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaji  reason: invalid package */
public class zzaji implements zzafa<zzaji> {
    private static final String zza = "zzaji";
    private String zzb;
    private String zzc;
    private long zzd;
    private List<zzahz> zze;
    private String zzf;

    /* access modifiers changed from: private */
    /* renamed from: zzb */
    public final zzaji zza(String str) throws zzaco {
        try {
            JSONObject jSONObject = new JSONObject(str);
            Strings.emptyToNull(jSONObject.optString("localId", (String) null));
            Strings.emptyToNull(jSONObject.optString(Scopes.EMAIL, (String) null));
            Strings.emptyToNull(jSONObject.optString("displayName", (String) null));
            this.zzb = Strings.emptyToNull(jSONObject.optString("idToken", (String) null));
            Strings.emptyToNull(jSONObject.optString("photoUrl", (String) null));
            this.zzc = Strings.emptyToNull(jSONObject.optString("refreshToken", (String) null));
            this.zzd = jSONObject.optLong("expiresIn", 0);
            this.zze = zzahz.zza(jSONObject.optJSONArray("mfaInfo"));
            this.zzf = jSONObject.optString("mfaPendingCredential", (String) null);
            return this;
        } catch (NullPointerException | JSONException e) {
            throw zzajl.zza(e, zza, str);
        }
    }

    public final long zza() {
        return this.zzd;
    }

    public final String zzc() {
        return this.zzf;
    }

    public final String zzd() {
        return this.zzc;
    }

    public final List<zzahz> zze() {
        return this.zze;
    }

    public final boolean zzf() {
        if (!TextUtils.isEmpty(this.zzf)) {
            return true;
        }
        return false;
    }

    public final String zzb() {
        return this.zzb;
    }
}
