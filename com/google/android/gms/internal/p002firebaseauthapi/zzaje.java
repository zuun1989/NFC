package com.google.android.gms.internal.p002firebaseauthapi;

import android.text.TextUtils;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.util.Strings;
import j6.z0;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaje  reason: invalid package */
public class zzaje implements zzafa<zzaje> {
    private static final String zza = "zzaje";
    private boolean zzb;
    private String zzc;
    private String zzd;
    private long zze;
    private String zzf;
    private String zzg;
    private String zzh;
    private boolean zzi;
    private String zzj;
    private String zzk;
    private String zzl;
    private String zzm;
    private String zzn;
    private String zzo;
    private List<zzahz> zzp;
    private String zzq;

    public final long zza() {
        return this.zze;
    }

    public final z0 zzb() {
        if (!TextUtils.isEmpty(this.zzj) || !TextUtils.isEmpty(this.zzk)) {
            return z0.R1(this.zzg, this.zzk, this.zzj, this.zzn, this.zzl);
        }
        return null;
    }

    public final String zzc() {
        return this.zzf;
    }

    public final String zzd() {
        return this.zzm;
    }

    public final String zze() {
        return this.zzc;
    }

    public final String zzf() {
        return this.zzq;
    }

    public final String zzg() {
        return this.zzg;
    }

    public final String zzh() {
        return this.zzh;
    }

    public final String zzi() {
        return this.zzd;
    }

    public final String zzj() {
        return this.zzo;
    }

    public final List<zzahz> zzk() {
        return this.zzp;
    }

    public final boolean zzl() {
        if (!TextUtils.isEmpty(this.zzq)) {
            return true;
        }
        return false;
    }

    public final boolean zzm() {
        return this.zzb;
    }

    public final boolean zzn() {
        return this.zzi;
    }

    public final boolean zzo() {
        if (this.zzb || !TextUtils.isEmpty(this.zzm)) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: zzb */
    public final zzaje zza(String str) throws zzaco {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.zzb = jSONObject.optBoolean("needConfirmation", false);
            jSONObject.optBoolean("needEmail", false);
            this.zzc = Strings.emptyToNull(jSONObject.optString("idToken", (String) null));
            this.zzd = Strings.emptyToNull(jSONObject.optString("refreshToken", (String) null));
            this.zze = jSONObject.optLong("expiresIn", 0);
            Strings.emptyToNull(jSONObject.optString("localId", (String) null));
            this.zzf = Strings.emptyToNull(jSONObject.optString(Scopes.EMAIL, (String) null));
            Strings.emptyToNull(jSONObject.optString("displayName", (String) null));
            Strings.emptyToNull(jSONObject.optString("photoUrl", (String) null));
            this.zzg = Strings.emptyToNull(jSONObject.optString("providerId", (String) null));
            this.zzh = Strings.emptyToNull(jSONObject.optString("rawUserInfo", (String) null));
            this.zzi = jSONObject.optBoolean("isNewUser", false);
            this.zzj = jSONObject.optString("oauthAccessToken", (String) null);
            this.zzk = jSONObject.optString("oauthIdToken", (String) null);
            this.zzm = Strings.emptyToNull(jSONObject.optString("errorMessage", (String) null));
            this.zzn = Strings.emptyToNull(jSONObject.optString("pendingToken", (String) null));
            this.zzo = Strings.emptyToNull(jSONObject.optString("tenantId", (String) null));
            this.zzp = zzahz.zza(jSONObject.optJSONArray("mfaInfo"));
            this.zzq = Strings.emptyToNull(jSONObject.optString("mfaPendingCredential", (String) null));
            this.zzl = Strings.emptyToNull(jSONObject.optString("oauthTokenSecret", (String) null));
            return this;
        } catch (NullPointerException | JSONException e) {
            throw zzajl.zza(e, zza, str);
        }
    }
}
