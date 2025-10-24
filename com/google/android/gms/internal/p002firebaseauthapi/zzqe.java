package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzxa;
import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzqe  reason: invalid package */
public final class zzqe implements zzqi {
    private final String zza;
    private final zzaam zzb;
    private final zzajw zzc;
    private final zzxa.zza zzd;
    private final zzyc zze;
    private final Integer zzf;

    private zzqe(String str, zzaam zzaam, zzajw zzajw, zzxa.zza zza2, zzyc zzyc, Integer num) {
        this.zza = str;
        this.zzb = zzaam;
        this.zzc = zzajw;
        this.zzd = zza2;
        this.zze = zzyc;
        this.zzf = num;
    }

    public static zzqe zza(String str, zzajw zzajw, zzxa.zza zza2, zzyc zzyc, Integer num) throws GeneralSecurityException {
        if (zzyc == zzyc.RAW) {
            if (num != null) {
                throw new GeneralSecurityException("Keys with output prefix type raw should not have an id requirement.");
            }
        } else if (num == null) {
            throw new GeneralSecurityException("Keys with output prefix type different from raw should have an id requirement.");
        }
        return new zzqe(str, zzqq.zza(str), zzajw, zza2, zzyc, num);
    }

    public final zzaam zzb() {
        return this.zzb;
    }

    public final zzyc zzc() {
        return this.zze;
    }

    public final zzajw zzd() {
        return this.zzc;
    }

    public final Integer zze() {
        return this.zzf;
    }

    public final String zzf() {
        return this.zza;
    }

    public final zzxa.zza zza() {
        return this.zzd;
    }
}
