package com.google.android.gms.internal.p002firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzana  reason: invalid package */
final class zzana implements zzaml {
    private final zzamn zza;
    private final String zzb;
    private final Object[] zzc;
    private final int zzd;

    public zzana(zzamn zzamn, String str, Object[] objArr) {
        this.zza = zzamn;
        this.zzb = str;
        this.zzc = objArr;
        char charAt = str.charAt(0);
        if (charAt < 55296) {
            this.zzd = charAt;
            return;
        }
        char c = charAt & 8191;
        int i = 13;
        int i2 = 1;
        while (true) {
            int i3 = i2 + 1;
            char charAt2 = str.charAt(i2);
            if (charAt2 >= 55296) {
                c |= (charAt2 & 8191) << i;
                i += 13;
                i2 = i3;
            } else {
                this.zzd = c | (charAt2 << i);
                return;
            }
        }
    }

    public final zzamn zza() {
        return this.zza;
    }

    public final zzamz zzb() {
        int i = this.zzd;
        if ((i & 1) != 0) {
            return zzamz.PROTO2;
        }
        if ((i & 4) == 4) {
            return zzamz.EDITIONS;
        }
        return zzamz.PROTO3;
    }

    public final boolean zzc() {
        if ((this.zzd & 2) == 2) {
            return true;
        }
        return false;
    }

    public final String zzd() {
        return this.zzb;
    }

    public final Object[] zze() {
        return this.zzc;
    }
}
