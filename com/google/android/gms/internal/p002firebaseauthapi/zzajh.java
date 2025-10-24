package com.google.android.gms.internal.p002firebaseauthapi;

import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzajh  reason: invalid package */
public final class zzajh implements zzafb {
    private String zza;
    private String zzb;
    private String zzc;
    private String zzd;
    private String zze;
    private boolean zzf;

    private zzajh() {
    }

    public static zzajh zza(String str, String str2, boolean z) {
        zzajh zzajh = new zzajh();
        zzajh.zzb = Preconditions.checkNotEmpty(str);
        zzajh.zzc = Preconditions.checkNotEmpty(str2);
        zzajh.zzf = z;
        return zzajh;
    }

    public static zzajh zzb(String str, String str2, boolean z) {
        zzajh zzajh = new zzajh();
        zzajh.zza = Preconditions.checkNotEmpty(str);
        zzajh.zzd = Preconditions.checkNotEmpty(str2);
        zzajh.zzf = z;
        return zzajh;
    }

    public final String zza() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (!TextUtils.isEmpty(this.zzd)) {
            jSONObject.put("phoneNumber", this.zza);
            jSONObject.put("temporaryProof", this.zzd);
        } else {
            jSONObject.put("sessionInfo", this.zzb);
            jSONObject.put("code", this.zzc);
        }
        String str = this.zze;
        if (str != null) {
            jSONObject.put("idToken", str);
        }
        if (!this.zzf) {
            jSONObject.put("operation", 2);
        }
        return jSONObject.toString();
    }

    public final void zza(String str) {
        this.zze = str;
    }
}
