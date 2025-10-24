package com.google.android.gms.internal.p002firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzags  reason: invalid package */
final class zzags extends zzaii {
    private String zza;
    private String zzb;
    private String zzc;
    private zzahh zzd;
    private String zze;

    public final zzaii zza(String str) {
        if (str != null) {
            this.zze = str;
            return this;
        }
        throw new NullPointerException("Null idToken");
    }

    public final zzaii zzb(String str) {
        if (str != null) {
            this.zza = str;
            return this;
        }
        throw new NullPointerException("Null providerId");
    }

    public final zzaii zzc(String str) {
        this.zzb = str;
        return this;
    }

    public final zzaii zzd(String str) {
        if (str != null) {
            this.zzc = str;
            return this;
        }
        throw new NullPointerException("Null token");
    }

    public final zzaii zza(zzahh zzahh) {
        if (zzahh != null) {
            this.zzd = zzahh;
            return this;
        }
        throw new NullPointerException("Null tokenType");
    }

    public final zzaif zza() {
        String str;
        zzahh zzahh;
        String str2;
        String str3 = this.zza;
        if (str3 != null && (str = this.zzc) != null && (zzahh = this.zzd) != null && (str2 = this.zze) != null) {
            return new zzagp(str3, this.zzb, str, zzahh, str2);
        }
        StringBuilder sb2 = new StringBuilder();
        if (this.zza == null) {
            sb2.append(" providerId");
        }
        if (this.zzc == null) {
            sb2.append(" token");
        }
        if (this.zzd == null) {
            sb2.append(" tokenType");
        }
        if (this.zze == null) {
            sb2.append(" idToken");
        }
        String valueOf = String.valueOf(sb2);
        throw new IllegalStateException("Missing required properties:" + valueOf);
    }
}
