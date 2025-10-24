package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.util.Strings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaib  reason: invalid package */
public final class zzaib {
    private List<zzaic> zza;

    public zzaib() {
        this.zza = new ArrayList();
    }

    public static zzaib zza(JSONArray jSONArray) throws JSONException {
        zzaic zzaic;
        if (jSONArray == null || jSONArray.length() == 0) {
            return new zzaib(new ArrayList());
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            if (jSONObject == null) {
                zzaic = new zzaic();
            } else {
                zzaic = new zzaic(Strings.emptyToNull(jSONObject.optString("federatedId")), Strings.emptyToNull(jSONObject.optString("displayName")), Strings.emptyToNull(jSONObject.optString("photoUrl")), Strings.emptyToNull(jSONObject.optString("providerId")), (String) null, Strings.emptyToNull(jSONObject.optString("phoneNumber")), Strings.emptyToNull(jSONObject.optString(Scopes.EMAIL)));
            }
            arrayList.add(zzaic);
        }
        return new zzaib(arrayList);
    }

    private zzaib(List<zzaic> list) {
        if (!list.isEmpty()) {
            this.zza = Collections.unmodifiableList(list);
        } else {
            this.zza = Collections.emptyList();
        }
    }

    public final List<zzaic> zza() {
        return this.zza;
    }
}
