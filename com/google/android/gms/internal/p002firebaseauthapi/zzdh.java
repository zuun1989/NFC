package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzdk;
import com.google.android.gms.internal.p002firebaseauthapi.zzix;
import com.google.android.gms.internal.p002firebaseauthapi.zzxa;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzdh  reason: invalid package */
public final class zzdh {
    private static final zzpr<zzdd, zzaz> zza;
    private static final zzbk<zzaz> zzb;
    private static final zzow<zzdk> zzc = new zzdj();
    private static final zzou<zzdk> zzd = new zzdi();
    private static final zzix.zza zze = zzix.zza.ALGORITHM_REQUIRES_BORINGCRYPTO;

    static {
        Class<zzaz> cls = zzaz.class;
        zza = zzpr.zza(new zzdg(), zzdd.class, cls);
        zzb = zzoc.zza("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey", cls, zzxa.zza.SYMMETRIC, zzti.zzf());
    }

    public static zzdd zza(zzdk zzdk, Integer num) throws GeneralSecurityException {
        if (zzdk.zzb() == 16 || zzdk.zzb() == 32) {
            return zzdd.zze().zza(zzdk).zza(num).zza(zzaan.zza(zzdk.zzb())).zzb(zzaan.zza(zzdk.zzc())).zza();
        }
        throw new GeneralSecurityException("AES key size must be 16 or 32 bytes");
    }

    public static String zza() {
        return "type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey";
    }

    public static void zza(boolean z) throws GeneralSecurityException {
        zzix.zza zza2 = zze;
        if (zza2.zza()) {
            zzgi.zza();
            zzoz.zza().zza(zza);
            zzpa zza3 = zzpa.zza();
            HashMap hashMap = new HashMap();
            hashMap.put("AES128_CTR_HMAC_SHA256", zzfl.zze);
            zzdk.zza zzc2 = zzdk.zzf().zza(16).zzb(32).zzd(16).zzc(16);
            zzdk.zzc zzc3 = zzdk.zzc.zzc;
            zzdk.zza zza4 = zzc2.zza(zzc3);
            zzdk.zzb zzb2 = zzdk.zzb.zzc;
            hashMap.put("AES128_CTR_HMAC_SHA256_RAW", zza4.zza(zzb2).zza());
            hashMap.put("AES256_CTR_HMAC_SHA256", zzfl.zzf);
            hashMap.put("AES256_CTR_HMAC_SHA256_RAW", zzdk.zzf().zza(32).zzb(32).zzd(32).zzc(16).zza(zzc3).zza(zzb2).zza());
            zza3.zza(Collections.unmodifiableMap(hashMap));
            Class<zzdk> cls = zzdk.class;
            zzot.zza().zza(zzc, cls);
            zzos.zza().zza(zzd, cls);
            zznt.zza().zza(zzb, zza2, true);
            return;
        }
        throw new GeneralSecurityException("Can not use AES-CTR-HMAC in FIPS-mode, as BoringCrypto module is not available.");
    }
}
