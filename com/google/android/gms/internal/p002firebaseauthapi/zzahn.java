package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.internal.Preconditions;
import j6.e;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzahn  reason: invalid package */
public final class zzahn implements zzafb {
    private String zza;
    private String zzb;
    private String zzc;
    private String zzd;
    private e zze;
    private String zzf;
    private String zzg;

    public zzahn(int i) {
        this.zza = zza(i);
    }

    public static zzahn zza(e eVar, String str, String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(eVar);
        return new zzahn(7, eVar, (String) null, str2, str, (String) null, (String) null);
    }

    public final e zzb() {
        return this.zze;
    }

    public final zzahn zzc(String str) {
        this.zzf = str;
        return this;
    }

    public final zzahn zzd(String str) {
        this.zzd = Preconditions.checkNotEmpty(str);
        return this;
    }

    public final zzahn zzb(String str) {
        this.zzb = Preconditions.checkNotEmpty(str);
        return this;
    }

    public final String zzc() {
        return this.zzb;
    }

    public final String zzd() {
        return this.zzd;
    }

    private zzahn(int i, e eVar, String str, String str2, String str3, String str4, String str5) {
        this.zza = zza(7);
        this.zze = (e) Preconditions.checkNotNull(eVar);
        this.zzb = null;
        this.zzc = str2;
        this.zzd = str3;
        this.zzf = null;
        this.zzg = null;
    }

    public final zzahn zza(e eVar) {
        this.zze = (e) Preconditions.checkNotNull(eVar);
        return this;
    }

    public final zzahn zza(String str) {
        this.zzg = str;
        return this;
    }

    private static String zza(int i) {
        if (i == 1) {
            return "PASSWORD_RESET";
        }
        if (i == 4) {
            return "VERIFY_EMAIL";
        }
        if (i == 6) {
            return "EMAIL_SIGNIN";
        }
        if (i != 7) {
            return "REQUEST_TYPE_UNSET_ENUM_VALUE";
        }
        return "VERIFY_AND_CHANGE_EMAIL";
    }

    public final String zza() throws JSONException {
        int i = 1;
        JSONObject jSONObject = new JSONObject();
        String str = this.zza;
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1452371317:
                if (str.equals("PASSWORD_RESET")) {
                    c = 0;
                    break;
                }
                break;
            case -1341836234:
                if (str.equals("VERIFY_EMAIL")) {
                    c = 1;
                    break;
                }
                break;
            case -1099157829:
                if (str.equals("VERIFY_AND_CHANGE_EMAIL")) {
                    c = 2;
                    break;
                }
                break;
            case 870738373:
                if (str.equals("EMAIL_SIGNIN")) {
                    c = 3;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                break;
            case 1:
                i = 4;
                break;
            case 2:
                i = 7;
                break;
            case 3:
                i = 6;
                break;
            default:
                i = 0;
                break;
        }
        jSONObject.put("requestType", i);
        String str2 = this.zzb;
        if (str2 != null) {
            jSONObject.put(Scopes.EMAIL, str2);
        }
        String str3 = this.zzc;
        if (str3 != null) {
            jSONObject.put("newEmail", str3);
        }
        String str4 = this.zzd;
        if (str4 != null) {
            jSONObject.put("idToken", str4);
        }
        e eVar = this.zze;
        if (eVar != null) {
            jSONObject.put("androidInstallApp", eVar.L1());
            jSONObject.put("canHandleCodeInApp", this.zze.K1());
            if (this.zze.Q1() != null) {
                jSONObject.put("continueUrl", this.zze.Q1());
            }
            if (this.zze.O1() != null) {
                jSONObject.put("iosBundleId", this.zze.O1());
            }
            if (this.zze.zzd() != null) {
                jSONObject.put("iosAppStoreId", this.zze.zzd());
            }
            if (this.zze.N1() != null) {
                jSONObject.put("androidPackageName", this.zze.N1());
            }
            if (this.zze.M1() != null) {
                jSONObject.put("androidMinimumVersion", this.zze.M1());
            }
            if (this.zze.zzc() != null) {
                jSONObject.put("dynamicLinkDomain", this.zze.zzc());
            }
            if (this.zze.P1() != null) {
                jSONObject.put("linkDomain", this.zze.P1());
            }
        }
        String str5 = this.zzf;
        if (str5 != null) {
            jSONObject.put("tenantId", str5);
        }
        String str6 = this.zzg;
        if (str6 != null) {
            zzajl.zza(jSONObject, "captchaResp", str6);
        } else {
            zzajl.zza(jSONObject);
        }
        return jSONObject.toString();
    }
}
