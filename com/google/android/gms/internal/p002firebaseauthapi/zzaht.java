package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Strings;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaht  reason: invalid package */
public class zzaht implements zzafa<zzaht> {
    private static final String zza = "zzaht";
    private String zzb;
    private zzah<zzaie> zzc;

    /* access modifiers changed from: private */
    /* renamed from: zzd */
    public final zzaht zza(String str) throws zzaco {
        zzah<zzaie> zzah;
        zzaie zzaie;
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.zzb = Strings.emptyToNull(jSONObject.optString("recaptchaKey"));
            if (jSONObject.has("recaptchaEnforcementState")) {
                JSONArray optJSONArray = jSONObject.optJSONArray("recaptchaEnforcementState");
                if (optJSONArray != null) {
                    if (optJSONArray.length() != 0) {
                        zzak zzf = zzah.zzf();
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                            if (jSONObject2 == null) {
                                zzaie = zzaie.zza((String) null, (String) null);
                            } else {
                                zzaie = zzaie.zza(Strings.emptyToNull(jSONObject2.optString("provider")), Strings.emptyToNull(jSONObject2.optString("enforcementState")));
                            }
                            zzf.zza(zzaie);
                        }
                        zzah = zzf.zza();
                        this.zzc = zzah;
                    }
                }
                zzah = zzah.zzg();
                this.zzc = zzah;
            }
            return this;
        } catch (JSONException e) {
            e = e;
            throw zzajl.zza(e, zza, str);
        } catch (NullPointerException e2) {
            e = e2;
            throw zzajl.zza(e, zza, str);
        }
    }

    public final String zzb(String str) {
        Preconditions.checkNotEmpty(str);
        zzah<zzaie> zzah = this.zzc;
        if (zzah != null && !zzah.isEmpty()) {
            zzah<zzaie> zzah2 = this.zzc;
            int size = zzah2.size();
            int i = 0;
            while (i < size) {
                zzaie zzaie = zzah2.get(i);
                i++;
                zzaie zzaie2 = zzaie;
                String zza2 = zzaie2.zza();
                String zzb2 = zzaie2.zzb();
                if (zza2 != null && zzb2 != null && zzb2.equals(str)) {
                    return zzaie2.zza();
                }
            }
        }
        return null;
    }

    public final boolean zzc(String str) {
        String zzb2 = zzb(str);
        if (zzb2 == null) {
            return false;
        }
        if (zzb2.equals("ENFORCE") || zzb2.equals("AUDIT")) {
            return true;
        }
        return false;
    }

    public final String zza() {
        return this.zzb;
    }
}
