package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzix;
import com.google.android.gms.internal.p002firebaseauthapi.zzrj;
import com.google.android.gms.internal.p002firebaseauthapi.zzxa;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzrd  reason: invalid package */
public final class zzrd {
    private static final zzpr<zzrc, zzqz> zza;
    private static final zzpr<zzrc, zzcb> zzb;
    private static final zzbk<zzcb> zzc;
    private static final zzow<zzrj> zzd = new zzri();
    private static final zzou<zzrj> zze = new zzrh();
    private static final zzix.zza zzf = zzix.zza.ALGORITHM_REQUIRES_BORINGCRYPTO;

    static {
        Class<zzrc> cls = zzrc.class;
        zza = zzpr.zza(new zzrg(), cls, zzqz.class);
        Class<zzcb> cls2 = zzcb.class;
        zzb = zzpr.zza(new zzrf(), cls, cls2);
        zzc = zzoc.zza("type.googleapis.com/google.crypto.tink.HmacKey", cls2, zzxa.zza.SYMMETRIC, zzwa.zzg());
    }

    public static zzrc zza(zzrj zzrj, Integer num) throws GeneralSecurityException {
        return zzrc.zzc().zza(zzrj).zza(zzaan.zza(zzrj.zzc())).zza(num).zza();
    }

    public static void zza(boolean z) throws GeneralSecurityException {
        zzix.zza zza2 = zzf;
        if (zza2.zza()) {
            zzsi.zza();
            zzoz.zza().zza(zza);
            zzoz.zza().zza(zzb);
            zzpa zza3 = zzpa.zza();
            HashMap hashMap = new HashMap();
            hashMap.put("HMAC_SHA256_128BITTAG", zzrs.zza);
            zzrj.zza zzb2 = zzrj.zzd().zza(32).zzb(16);
            zzrj.zzb zzb3 = zzrj.zzb.zzd;
            zzrj.zza zza4 = zzb2.zza(zzb3);
            zzrj.zzc zzc2 = zzrj.zzc.zzc;
            hashMap.put("HMAC_SHA256_128BITTAG_RAW", zza4.zza(zzc2).zza());
            zzrj.zza zzb4 = zzrj.zzd().zza(32).zzb(32);
            zzrj.zzb zzb5 = zzrj.zzb.zza;
            hashMap.put("HMAC_SHA256_256BITTAG", zzb4.zza(zzb5).zza(zzc2).zza());
            hashMap.put("HMAC_SHA256_256BITTAG_RAW", zzrj.zzd().zza(32).zzb(32).zza(zzb3).zza(zzc2).zza());
            zzrj.zza zza5 = zzrj.zzd().zza(64).zzb(16).zza(zzb5);
            zzrj.zzc zzc3 = zzrj.zzc.zze;
            hashMap.put("HMAC_SHA512_128BITTAG", zza5.zza(zzc3).zza());
            hashMap.put("HMAC_SHA512_128BITTAG_RAW", zzrj.zzd().zza(64).zzb(16).zza(zzb3).zza(zzc3).zza());
            hashMap.put("HMAC_SHA512_256BITTAG", zzrj.zzd().zza(64).zzb(32).zza(zzb5).zza(zzc3).zza());
            hashMap.put("HMAC_SHA512_256BITTAG_RAW", zzrj.zzd().zza(64).zzb(32).zza(zzb3).zza(zzc3).zza());
            hashMap.put("HMAC_SHA512_512BITTAG", zzrs.zzb);
            hashMap.put("HMAC_SHA512_512BITTAG_RAW", zzrj.zzd().zza(64).zzb(64).zza(zzb3).zza(zzc3).zza());
            zza3.zza(Collections.unmodifiableMap(hashMap));
            Class<zzrj> cls = zzrj.class;
            zzos.zza().zza(zze, cls);
            zzot.zza().zza(zzd, cls);
            zznt.zza().zza(zzc, zza2, true);
            return;
        }
        throw new GeneralSecurityException("Can not use HMAC in FIPS-mode, as BoringCrypto module is not available.");
    }
}
