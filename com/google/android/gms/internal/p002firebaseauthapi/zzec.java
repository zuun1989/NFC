package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzeg;
import com.google.android.gms.internal.p002firebaseauthapi.zzix;
import com.google.android.gms.internal.p002firebaseauthapi.zzxa;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzec  reason: invalid package */
public final class zzec {
    private static final zzpr<zzeb, zzaz> zza;
    private static final zzou<zzeg> zzb = new zzee();
    private static final zzow<zzeg> zzc = new zzeh();
    private static final zzbk<zzaz> zzd;

    static {
        Class<zzaz> cls = zzaz.class;
        zza = zzpr.zza(new zzef(), zzeb.class, cls);
        zzd = zzoc.zza("type.googleapis.com/google.crypto.tink.AesGcmSivKey", cls, zzxa.zza.SYMMETRIC, zzum.zze());
    }

    public static void zza(boolean z) throws GeneralSecurityException {
        if (zzix.zza.ALGORITHM_NOT_FIPS.zza()) {
            zzhe.zza();
            zzpa zza2 = zzpa.zza();
            HashMap hashMap = new HashMap();
            zzeg.zzb zza3 = zzeg.zzc().zza(16);
            zzeg.zza zza4 = zzeg.zza.zza;
            hashMap.put("AES128_GCM_SIV", zza3.zza(zza4).zza());
            zzeg.zzb zza5 = zzeg.zzc().zza(16);
            zzeg.zza zza6 = zzeg.zza.zzc;
            hashMap.put("AES128_GCM_SIV_RAW", zza5.zza(zza6).zza());
            hashMap.put("AES256_GCM_SIV", zzeg.zzc().zza(32).zza(zza4).zza());
            hashMap.put("AES256_GCM_SIV_RAW", zzeg.zzc().zza(32).zza(zza6).zza());
            zza2.zza(Collections.unmodifiableMap(hashMap));
            Class<zzeg> cls = zzeg.class;
            zzot.zza().zza(zzc, cls);
            zzos.zza().zza(zzb, cls);
            zzoz.zza().zza(zza);
            zznt.zza().zza(zzd, true);
            return;
        }
        throw new GeneralSecurityException("Registering AES GCM SIV is not supported in FIPS mode");
    }
}
