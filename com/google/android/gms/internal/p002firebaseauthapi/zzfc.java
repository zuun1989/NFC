package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzfe;
import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzfc  reason: invalid package */
public final class zzfc extends zzcv {
    private final zzfe zza;
    private final zzaam zzb;
    private final Integer zzc;

    private zzfc(zzfe zzfe, zzaam zzaam, Integer num) {
        this.zza = zzfe;
        this.zzb = zzaam;
        this.zzc = num;
    }

    public final /* synthetic */ zzce zza() {
        return (zzfe) zza();
    }

    public final Integer zzb() {
        return this.zzc;
    }

    public final /* synthetic */ zzcx zzc() {
        return this.zza;
    }

    public final zzaam zzd() {
        return this.zzb;
    }

    public static zzfc zza(zzfe zzfe, Integer num) throws GeneralSecurityException {
        zzaam zzaam;
        if (zzfe.zzc() == zzfe.zzb.zzb) {
            if (num == null) {
                zzaam = zzpd.zza;
            } else {
                throw new GeneralSecurityException("For given Variant NO_PREFIX the value of idRequirement must be null");
            }
        } else if (zzfe.zzc() != zzfe.zzb.zza) {
            String valueOf = String.valueOf(zzfe.zzc());
            throw new GeneralSecurityException("Unknown Variant: " + valueOf);
        } else if (num != null) {
            zzaam = zzpd.zzb(num.intValue());
        } else {
            throw new GeneralSecurityException("For given Variant TINK the value of idRequirement must be non-null");
        }
        return new zzfc(zzfe, zzaam, num);
    }
}
