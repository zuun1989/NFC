package com.google.android.gms.internal.p002firebaseauthapi;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Strings;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzahz  reason: invalid package */
public final class zzahz {
    private final String zza;
    private final String zzb;
    private final String zzc;
    private final long zzd;
    private final zzaja zze;

    private zzahz(String str, String str2, String str3, long j, zzaja zzaja) {
        if (TextUtils.isEmpty(str) || zzaja == null) {
            this.zza = str;
            this.zzb = Preconditions.checkNotEmpty(str2);
            this.zzc = str3;
            this.zzd = j;
            this.zze = zzaja;
            return;
        }
        Log.e("MfaInfo", "Cannot have both MFA phone_info and totp_info");
        throw new IllegalArgumentException("Cannot have both MFA phone_info and totp_info");
    }

    private static long zza(String str) {
        try {
            return zzaop.zza(zzaop.zza(str));
        } catch (ParseException e) {
            Log.w("MfaInfo", "Could not parse timestamp as ISOString. Invalid ISOString \"" + str + "\"", e);
            return 0;
        }
    }

    public final zzaja zzb() {
        return this.zze;
    }

    public final String zzc() {
        return this.zzc;
    }

    public final String zzd() {
        return this.zzb;
    }

    public final String zze() {
        return this.zza;
    }

    public final long zza() {
        return this.zzd;
    }

    public static zzahz zza(JSONObject jSONObject) {
        zzahz zzahz = new zzahz(Strings.emptyToNull(jSONObject.optString("phoneInfo")), Strings.emptyToNull(jSONObject.optString("mfaEnrollmentId")), Strings.emptyToNull(jSONObject.optString("displayName")), zza(jSONObject.optString("enrolledAt", "")), jSONObject.opt("totpInfo") != null ? new zzaja() : null);
        jSONObject.optString("unobfuscatedPhoneInfo");
        return zzahz;
    }

    public static List<zzahz> zza(JSONArray jSONArray) throws JSONException {
        if (jSONArray == null || jSONArray.length() == 0) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(zza(jSONArray.getJSONObject(i)));
        }
        return arrayList;
    }
}
