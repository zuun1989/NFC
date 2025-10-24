package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.logging.Logger;
import j6.f;
import j6.j;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzagy  reason: invalid package */
public class zzagy implements zzafb {
    private static final String zza = "zzagy";
    private final String zzb;
    private final String zzc;
    private final j zzd;
    private final String zze;
    private final String zzf;

    static {
        new Logger(zzagy.class.getSimpleName(), new String[0]);
    }

    public zzagy(j jVar, String str, String str2) {
        this.zzd = (j) Preconditions.checkNotNull(jVar);
        this.zzb = Preconditions.checkNotEmpty(jVar.zzc());
        this.zzc = Preconditions.checkNotEmpty(jVar.zze());
        this.zze = str;
        this.zzf = str2;
    }

    public final String zza() throws JSONException {
        String str;
        f c = f.c(this.zzc);
        String str2 = null;
        if (c != null) {
            str = c.a();
        } else {
            str = null;
        }
        if (c != null) {
            str2 = c.d();
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(Scopes.EMAIL, this.zzb);
        if (str != null) {
            jSONObject.put("oobCode", str);
        }
        if (str2 != null) {
            jSONObject.put("tenantId", str2);
        }
        String str3 = this.zze;
        if (str3 != null) {
            jSONObject.put("idToken", str3);
        }
        String str4 = this.zzf;
        if (str4 != null) {
            zzajl.zza(jSONObject, "captchaResp", str4);
        } else {
            zzajl.zza(jSONObject);
        }
        return jSONObject.toString();
    }

    public final j zzb() {
        return this.zzd;
    }

    public final String zzc() {
        return this.zzf;
    }
}
