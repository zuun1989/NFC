package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzfy  reason: invalid package */
public final class zzfy {
    private static final zzou<zzfz> zza = new zzfx();
    private static final zzpr<zzfv, zzaz> zzb = zzpr.zza(new zzga(), zzfv.class, zzaz.class);

    public static void zza(boolean z) throws GeneralSecurityException {
        zzid.zza();
        zzpa zza2 = zzpa.zza();
        HashMap hashMap = new HashMap();
        hashMap.put("XAES_256_GCM_192_BIT_NONCE", zzfl.zzg);
        hashMap.put("XAES_256_GCM_192_BIT_NONCE_NO_PREFIX", zzfl.zzh);
        hashMap.put("XAES_256_GCM_160_BIT_NONCE_NO_PREFIX", zzfl.zzi);
        hashMap.put("X_AES_GCM_8_BYTE_SALT_NO_PREFIX", zzfl.zzj);
        zza2.zza(Collections.unmodifiableMap(hashMap));
        zzoz.zza().zza(zzb);
        zzos.zza().zza(zza, zzfz.class);
    }
}
