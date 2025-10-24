package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzbm  reason: invalid package */
public final class zzbm {
    private final zzce zza;

    private zzbm(zzce zzce) {
        this.zza = zzce;
    }

    public static zzbm zza(zzce zzce) throws GeneralSecurityException {
        return new zzbm(zzce);
    }

    private final zzxe zzb() {
        try {
            zzce zzce = this.zza;
            if (zzce instanceof zzoh) {
                return ((zzoh) zzce).zzb().zza();
            }
            return ((zzqd) zzpc.zza().zza(this.zza, zzqd.class)).zza();
        } catch (GeneralSecurityException e) {
            String valueOf = String.valueOf(this.zza);
            throw new zzqo("Parsing parameters failed in getProto(). You probably want to call some Tink register function for " + valueOf, e);
        }
    }

    public final zzce zza() throws GeneralSecurityException {
        zzce zzce = this.zza;
        if (zzce != null) {
            return zzce;
        }
        return zzcm.zza(zzb().zzk());
    }
}
