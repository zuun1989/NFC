package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.util.Strings;
import j6.q0;
import j6.z0;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzahm  reason: invalid package */
public class zzahm implements zzafa<zzahm> {
    private static final String zza = "zzahm";
    private zzaho zzb;

    /* access modifiers changed from: private */
    /* renamed from: zzb */
    public final zzahm zza(String str) throws zzaco {
        zzaho zzaho;
        int i;
        zzahl zzahl;
        String str2 = str;
        try {
            JSONObject jSONObject = new JSONObject(str2);
            if (!jSONObject.has("users")) {
                zzaho = new zzaho();
            } else {
                JSONArray optJSONArray = jSONObject.optJSONArray("users");
                if (optJSONArray != null) {
                    if (optJSONArray.length() != 0) {
                        ArrayList arrayList = new ArrayList(optJSONArray.length());
                        boolean z = false;
                        int i2 = 0;
                        while (i2 < optJSONArray.length()) {
                            JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                            if (jSONObject2 == null) {
                                zzahl = new zzahl();
                                i = i2;
                            } else {
                                i = i2;
                                zzahl = new zzahl(Strings.emptyToNull(jSONObject2.optString("localId", (String) null)), Strings.emptyToNull(jSONObject2.optString(Scopes.EMAIL, (String) null)), jSONObject2.optBoolean("emailVerified", z), Strings.emptyToNull(jSONObject2.optString("displayName", (String) null)), Strings.emptyToNull(jSONObject2.optString("photoUrl", (String) null)), zzaib.zza(jSONObject2.optJSONArray("providerUserInfo")), Strings.emptyToNull(jSONObject2.optString("rawPassword", (String) null)), Strings.emptyToNull(jSONObject2.optString("phoneNumber", (String) null)), jSONObject2.optLong("createdAt", 0), jSONObject2.optLong("lastLoginAt", 0), false, (z0) null, zzahz.zza(jSONObject2.optJSONArray("mfaInfo")), q0.K1(jSONObject2.optJSONArray("passkeyInfo")));
                            }
                            arrayList.add(zzahl);
                            i2 = i + 1;
                            z = false;
                        }
                        zzaho = new zzaho(arrayList);
                    }
                }
                zzaho = new zzaho(new ArrayList());
            }
            this.zzb = zzaho;
            return this;
        } catch (JSONException e) {
            e = e;
            throw zzajl.zza(e, zza, str2);
        } catch (NullPointerException e2) {
            e = e2;
            throw zzajl.zza(e, zza, str2);
        }
    }

    public final List<zzahl> zza() {
        return this.zzb.zza();
    }
}
