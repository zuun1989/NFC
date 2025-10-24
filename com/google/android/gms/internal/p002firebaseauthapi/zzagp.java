package com.google.android.gms.internal.p002firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzagp  reason: invalid package */
final class zzagp extends zzaif {
    private final String zza;
    private final String zzb;
    private final String zzc;
    private final zzahh zzd;
    private final String zze;

    public final boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzaif) {
            zzaif zzaif = (zzaif) obj;
            if (!this.zza.equals(zzaif.zzd()) || ((str = this.zzb) != null ? !str.equals(zzaif.zze()) : zzaif.zze() != null) || !this.zzc.equals(zzaif.zzf()) || !this.zzd.equals(zzaif.zzb()) || !this.zze.equals(zzaif.zzc())) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i;
        int hashCode = (this.zza.hashCode() ^ 1000003) * 1000003;
        String str = this.zzb;
        if (str == null) {
            i = 0;
        } else {
            i = str.hashCode();
        }
        return ((((((hashCode ^ i) * 1000003) ^ this.zzc.hashCode()) * 1000003) ^ this.zzd.hashCode()) * 1000003) ^ this.zze.hashCode();
    }

    public final String toString() {
        String str = this.zza;
        String str2 = this.zzb;
        String str3 = this.zzc;
        String valueOf = String.valueOf(this.zzd);
        String str4 = this.zze;
        return "RevokeTokenRequest{providerId=" + str + ", tenantId=" + str2 + ", token=" + str3 + ", tokenType=" + valueOf + ", idToken=" + str4 + "}";
    }

    public final zzahh zzb() {
        return this.zzd;
    }

    public final String zzc() {
        return this.zze;
    }

    public final String zzd() {
        return this.zza;
    }

    public final String zze() {
        return this.zzb;
    }

    public final String zzf() {
        return this.zzc;
    }

    private zzagp(String str, String str2, String str3, zzahh zzahh, String str4) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = zzahh;
        this.zze = str4;
    }
}
