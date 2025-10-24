package com.google.android.gms.internal.p002firebaseauthapi;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import k6.z0;
import org.json.JSONException;
import org.json.JSONObject;

@SafeParcelable.Class(creator = "VerifyAssertionRequestCreator")
@SafeParcelable.Reserved({1})
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzajc  reason: invalid package */
public final class zzajc extends AbstractSafeParcelable implements zzafb {
    public static final Parcelable.Creator<zzajc> CREATOR = new zzajb();
    @SafeParcelable.Field(getter = "getRequestUri", id = 2)
    private String zza;
    @SafeParcelable.Field(getter = "getCurrentIdToken", id = 3)
    private String zzb;
    @SafeParcelable.Field(getter = "getIdToken", id = 4)
    private String zzc;
    @SafeParcelable.Field(getter = "getAccessToken", id = 5)
    private String zzd;
    @SafeParcelable.Field(getter = "getProviderId", id = 6)
    private String zze;
    @SafeParcelable.Field(getter = "getEmail", id = 7)
    private String zzf;
    @SafeParcelable.Field(getter = "getPostBody", id = 8)
    private String zzg;
    @SafeParcelable.Field(getter = "getOauthTokenSecret", id = 9)
    private String zzh;
    @SafeParcelable.Field(getter = "getReturnSecureToken", id = 10)
    private boolean zzi;
    @SafeParcelable.Field(getter = "getAutoCreate", id = 11)
    private boolean zzj;
    @SafeParcelable.Field(getter = "getAuthCode", id = 12)
    private String zzk;
    @SafeParcelable.Field(getter = "getSessionId", id = 13)
    private String zzl;
    @SafeParcelable.Field(getter = "getIdpResponseUrl", id = 14)
    private String zzm;
    @SafeParcelable.Field(getter = "getTenantId", id = 15)
    private String zzn;
    @SafeParcelable.Field(getter = "getReturnIdpCredential", id = 16)
    private boolean zzo;
    @SafeParcelable.Field(getter = "getPendingToken", id = 17)
    private String zzp;

    public zzajc() {
        this.zzi = true;
        this.zzj = true;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zza, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzb, false);
        SafeParcelWriter.writeString(parcel, 4, this.zzc, false);
        SafeParcelWriter.writeString(parcel, 5, this.zzd, false);
        SafeParcelWriter.writeString(parcel, 6, this.zze, false);
        SafeParcelWriter.writeString(parcel, 7, this.zzf, false);
        SafeParcelWriter.writeString(parcel, 8, this.zzg, false);
        SafeParcelWriter.writeString(parcel, 9, this.zzh, false);
        SafeParcelWriter.writeBoolean(parcel, 10, this.zzi);
        SafeParcelWriter.writeBoolean(parcel, 11, this.zzj);
        SafeParcelWriter.writeString(parcel, 12, this.zzk, false);
        SafeParcelWriter.writeString(parcel, 13, this.zzl, false);
        SafeParcelWriter.writeString(parcel, 14, this.zzm, false);
        SafeParcelWriter.writeString(parcel, 15, this.zzn, false);
        SafeParcelWriter.writeBoolean(parcel, 16, this.zzo);
        SafeParcelWriter.writeString(parcel, 17, this.zzp, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final zzajc zza(boolean z) {
        this.zzj = false;
        return this;
    }

    public final zzajc zzb(boolean z) {
        this.zzo = true;
        return this;
    }

    public final zzajc zzc(boolean z) {
        this.zzi = true;
        return this;
    }

    public final zzajc zza(String str) {
        this.zzb = Preconditions.checkNotEmpty(str);
        return this;
    }

    public final zzajc zzb(String str) {
        this.zzn = str;
        return this;
    }

    public final String zza() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("autoCreate", this.zzj);
        jSONObject.put("returnSecureToken", this.zzi);
        String str = this.zzb;
        if (str != null) {
            jSONObject.put("idToken", str);
        }
        String str2 = this.zzg;
        if (str2 != null) {
            jSONObject.put("postBody", str2);
        }
        String str3 = this.zzn;
        if (str3 != null) {
            jSONObject.put("tenantId", str3);
        }
        String str4 = this.zzp;
        if (str4 != null) {
            jSONObject.put("pendingToken", str4);
        }
        if (!TextUtils.isEmpty(this.zzl)) {
            jSONObject.put("sessionId", this.zzl);
        }
        if (!TextUtils.isEmpty(this.zzm)) {
            jSONObject.put("requestUri", this.zzm);
        } else {
            String str5 = this.zza;
            if (str5 != null) {
                jSONObject.put("requestUri", str5);
            }
        }
        jSONObject.put("returnIdpCredential", this.zzo);
        return jSONObject.toString();
    }

    public zzajc(z0 z0Var, String str) {
        Preconditions.checkNotNull(z0Var);
        this.zzl = Preconditions.checkNotEmpty(z0Var.d());
        this.zzm = Preconditions.checkNotEmpty(str);
        this.zze = Preconditions.checkNotEmpty(z0Var.c());
        this.zzi = true;
        this.zzg = "providerId=" + this.zze;
    }

    public zzajc(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        this.zza = "http://localhost";
        this.zzc = str;
        this.zzd = str2;
        this.zzh = str5;
        this.zzk = str6;
        this.zzn = str7;
        this.zzp = str8;
        this.zzi = true;
        if (!TextUtils.isEmpty(str) || !TextUtils.isEmpty(this.zzd) || !TextUtils.isEmpty(this.zzk)) {
            this.zze = Preconditions.checkNotEmpty(str3);
            this.zzf = null;
            StringBuilder sb2 = new StringBuilder();
            if (!TextUtils.isEmpty(this.zzc)) {
                sb2.append("id_token=");
                sb2.append(this.zzc);
                sb2.append("&");
            }
            if (!TextUtils.isEmpty(this.zzd)) {
                sb2.append("access_token=");
                sb2.append(this.zzd);
                sb2.append("&");
            }
            if (!TextUtils.isEmpty(this.zzf)) {
                sb2.append("identifier=");
                sb2.append(this.zzf);
                sb2.append("&");
            }
            if (!TextUtils.isEmpty(this.zzh)) {
                sb2.append("oauth_token_secret=");
                sb2.append(this.zzh);
                sb2.append("&");
            }
            if (!TextUtils.isEmpty(this.zzk)) {
                sb2.append("code=");
                sb2.append(this.zzk);
                sb2.append("&");
            }
            if (!TextUtils.isEmpty(str9)) {
                sb2.append("nonce=");
                sb2.append(str9);
                sb2.append("&");
            }
            sb2.append("providerId=");
            sb2.append(this.zze);
            this.zzg = sb2.toString();
            this.zzj = true;
            return;
        }
        throw new IllegalArgumentException("idToken, accessToken and authCode cannot all be null");
    }

    @SafeParcelable.Constructor
    public zzajc(@SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) String str2, @SafeParcelable.Param(id = 4) String str3, @SafeParcelable.Param(id = 5) String str4, @SafeParcelable.Param(id = 6) String str5, @SafeParcelable.Param(id = 7) String str6, @SafeParcelable.Param(id = 8) String str7, @SafeParcelable.Param(id = 9) String str8, @SafeParcelable.Param(id = 10) boolean z, @SafeParcelable.Param(id = 11) boolean z2, @SafeParcelable.Param(id = 12) String str9, @SafeParcelable.Param(id = 13) String str10, @SafeParcelable.Param(id = 14) String str11, @SafeParcelable.Param(id = 15) String str12, @SafeParcelable.Param(id = 16) boolean z3, @SafeParcelable.Param(id = 17) String str13) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = str4;
        this.zze = str5;
        this.zzf = str6;
        this.zzg = str7;
        this.zzh = str8;
        this.zzi = z;
        this.zzj = z2;
        this.zzk = str9;
        this.zzl = str10;
        this.zzm = str11;
        this.zzn = str12;
        this.zzo = z3;
        this.zzp = str13;
    }
}
