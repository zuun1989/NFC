package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzix;
import com.google.android.gms.internal.p002firebaseauthapi.zzjh;
import com.google.android.gms.internal.p002firebaseauthapi.zzxa;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Collections;
import java.util.HashMap;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzje  reason: invalid package */
public final class zzje {
    private static final zzpr<zzja, zzbd> zza;
    private static final zzbk<zzbd> zzb;
    private static final zzow<zzjh> zzc = new zzjg();
    private static final zzou<zzjh> zzd = new zzjf();

    static {
        Class<zzbd> cls = zzbd.class;
        zza = zzpr.zza(new zzjd(), zzja.class, cls);
        zzb = zzoc.zza("type.googleapis.com/google.crypto.tink.AesSivKey", cls, zzxa.zza.SYMMETRIC, zzus.zze());
    }

    public static zzja zza(zzjh zzjh, Integer num) throws GeneralSecurityException {
        zza(zzjh);
        return zzja.zzc().zza(zzjh).zza(num).zza(zzaan.zza(zzjh.zzb())).zza();
    }

    public static void zza(boolean z) throws GeneralSecurityException {
        if (zzix.zza.ALGORITHM_NOT_FIPS.zza()) {
            zzjr.zza();
            zzoz.zza().zza(zza);
            zzpa zza2 = zzpa.zza();
            HashMap hashMap = new HashMap();
            hashMap.put("AES256_SIV", zzjp.zza);
            hashMap.put("AES256_SIV_RAW", zzjh.zzc().zza(64).zza(zzjh.zzb.zzc).zza());
            zza2.zza(Collections.unmodifiableMap(hashMap));
            Class<zzjh> cls = zzjh.class;
            zzot.zza().zza(zzc, cls);
            zzos.zza().zza(zzd, cls);
            zznt.zza().zza(zzb, true);
            return;
        }
        throw new GeneralSecurityException("Registering AES SIV is not supported in FIPS mode");
    }

    /* access modifiers changed from: private */
    public static void zza(zzjh zzjh) throws GeneralSecurityException {
        if (zzjh.zzb() != 64) {
            int zzb2 = zzjh.zzb();
            throw new InvalidAlgorithmParameterException("invalid key size: " + zzb2 + ". Valid keys must have 64 bytes.");
        }
    }
}
