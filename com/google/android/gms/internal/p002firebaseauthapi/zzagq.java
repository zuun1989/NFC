package com.google.android.gms.internal.p002firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzagq  reason: invalid package */
final class zzagq extends zzaie {
    private final String zza;
    private final String zzb;

    public zzagq(String str, String str2) {
        this.zza = str;
        this.zzb = str2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzaie) {
            zzaie zzaie = (zzaie) obj;
            String str = this.zza;
            if (str != null ? str.equals(zzaie.zzb()) : zzaie.zzb() == null) {
                String str2 = this.zzb;
                if (str2 != null ? !str2.equals(zzaie.zza()) : zzaie.zza() != null) {
                    return false;
                }
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i;
        String str = this.zza;
        int i2 = 0;
        if (str == null) {
            i = 0;
        } else {
            i = str.hashCode();
        }
        int i3 = (i ^ 1000003) * 1000003;
        String str2 = this.zzb;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return i3 ^ i2;
    }

    public final String toString() {
        String str = this.zza;
        String str2 = this.zzb;
        return "RecaptchaEnforcementState{provider=" + str + ", enforcementState=" + str2 + "}";
    }

    public final String zza() {
        return this.zzb;
    }

    public final String zzb() {
        return this.zza;
    }
}
