package com.google.android.gms.internal.p002firebaseauthapi;

import java.io.IOException;
import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzcm  reason: invalid package */
public final class zzcm {
    public static zzce zza(byte[] bArr) throws GeneralSecurityException {
        try {
            zzxe zza = zzxe.zza(bArr, zzakv.zza());
            zzpc zza2 = zzpc.zza();
            zzqd zza3 = zzqd.zza(zza);
            if (!zza2.zzc(zza3)) {
                return new zzoh(zza3);
            }
            return zza2.zza(zza3);
        } catch (IOException e) {
            throw new GeneralSecurityException("Failed to parse proto", e);
        }
    }

    public static byte[] zza(zzce zzce) throws GeneralSecurityException {
        if (zzce instanceof zzoh) {
            return ((zzoh) zzce).zzb().zza().zzk();
        }
        return ((zzqd) zzpc.zza().zza(zzce, zzqd.class)).zza().zzk();
    }
}
