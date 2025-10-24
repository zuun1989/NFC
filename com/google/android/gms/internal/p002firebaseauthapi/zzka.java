package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzdk;
import com.google.android.gms.internal.p002firebaseauthapi.zzdz;
import com.google.android.gms.internal.p002firebaseauthapi.zzix;
import com.google.android.gms.internal.p002firebaseauthapi.zzke;
import com.google.android.gms.internal.p002firebaseauthapi.zzxa;
import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECParameterSpec;
import java.util.Collections;
import java.util.HashMap;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzka  reason: invalid package */
public final class zzka {
    private static final zzpr<zzkh, zzbg> zza;
    private static final zzpr<zzkg, zzbf> zzb;
    private static final zzcg<zzbg> zzc;
    private static final zzbk<zzbf> zzd;
    private static final zzou<zzke> zze = new zzkb();

    static {
        Class<zzbg> cls = zzbg.class;
        zza = zzpr.zza(new zzjz(), zzkh.class, cls);
        Class<zzbf> cls2 = zzbf.class;
        zzb = zzpr.zza(new zzkc(), zzkg.class, cls2);
        zzc = zzoc.zza("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey", cls, zzvm.zzf());
        zzd = zzoc.zza("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPublicKey", cls2, zzxa.zza.ASYMMETRIC_PUBLIC, zzvp.zzh());
    }

    public static /* synthetic */ zzkh zza(zzke zzke, Integer num) {
        ECParameterSpec eCParameterSpec;
        zzke.zza zzd2 = zzke.zzd();
        if (zzd2 == zzke.zza.zza) {
            eCParameterSpec = zzni.zza;
        } else if (zzd2 == zzke.zza.zzb) {
            eCParameterSpec = zzni.zzb;
        } else if (zzd2 == zzke.zza.zzc) {
            eCParameterSpec = zzni.zzc;
        } else {
            String valueOf = String.valueOf(zzd2);
            throw new GeneralSecurityException("Unsupported curve type: " + valueOf);
        }
        KeyPair zza2 = zzzi.zza(eCParameterSpec);
        return zzkh.zza(zzkg.zza(zzke, ((ECPublicKey) zza2.getPublic()).getW(), num), zzaal.zza(((ECPrivateKey) zza2.getPrivate()).getS(), zzbi.zza()));
    }

    public static String zza() {
        return "type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey";
    }

    public static void zza(boolean z) throws GeneralSecurityException {
        if (zzix.zza.ALGORITHM_NOT_FIPS.zza()) {
            zzlt.zza();
            zzpa zza2 = zzpa.zza();
            HashMap hashMap = new HashMap();
            zzke.zzb zzc2 = zzke.zzc();
            zzke.zza zza3 = zzke.zza.zza;
            zzke.zzb zza4 = zzc2.zza(zza3);
            zzke.zzd zzd2 = zzke.zzd.zzc;
            zzke.zzb zza5 = zza4.zza(zzd2);
            zzke.zzc zzc3 = zzke.zzc.zzb;
            zzke.zzb zza6 = zza5.zza(zzc3);
            zzke.zze zze2 = zzke.zze.zza;
            zzke.zzb zza7 = zza6.zza(zze2);
            zzdz.zza zzc4 = zzdz.zze().zza(12).zzb(16).zzc(16);
            zzdz.zzb zzb2 = zzdz.zzb.zzc;
            hashMap.put("ECIES_P256_HKDF_HMAC_SHA256_AES128_GCM", zza7.zza((zzce) zzc4.zza(zzb2).zza()).zza());
            zzke.zzb zza8 = zzke.zzc().zza(zza3).zza(zzd2).zza(zzc3);
            zzke.zze zze3 = zzke.zze.zzc;
            hashMap.put("ECIES_P256_HKDF_HMAC_SHA256_AES128_GCM_RAW", zza8.zza(zze3).zza((zzce) zzdz.zze().zza(12).zzb(16).zzc(16).zza(zzb2).zza()).zza());
            zzke.zzb zza9 = zzke.zzc().zza(zza3).zza(zzd2);
            zzke.zzc zzc5 = zzke.zzc.zza;
            hashMap.put("ECIES_P256_COMPRESSED_HKDF_HMAC_SHA256_AES128_GCM", zza9.zza(zzc5).zza(zze2).zza((zzce) zzdz.zze().zza(12).zzb(16).zzc(16).zza(zzb2).zza()).zza());
            hashMap.put("ECIES_P256_COMPRESSED_HKDF_HMAC_SHA256_AES128_GCM_RAW", zzke.zzc().zza(zza3).zza(zzd2).zza(zzc5).zza(zze3).zza((zzce) zzdz.zze().zza(12).zzb(16).zzc(16).zza(zzb2).zza()).zza());
            hashMap.put("ECIES_P256_HKDF_HMAC_SHA256_AES128_GCM_COMPRESSED_WITHOUT_PREFIX", zzke.zzc().zza(zza3).zza(zzd2).zza(zzc5).zza(zze3).zza((zzce) zzdz.zze().zza(12).zzb(16).zzc(16).zza(zzb2).zza()).zza());
            zzke.zzb zza10 = zzke.zzc().zza(zza3).zza(zzd2).zza(zzc3).zza(zze2);
            zzdk.zza zzc6 = zzdk.zzf().zza(16).zzb(32).zzd(16).zzc(16);
            zzdk.zzc zzc7 = zzdk.zzc.zzc;
            zzdk.zza zza11 = zzc6.zza(zzc7);
            zzdk.zzb zzb3 = zzdk.zzb.zzc;
            hashMap.put("ECIES_P256_HKDF_HMAC_SHA256_AES128_CTR_HMAC_SHA256", zza10.zza((zzce) zza11.zza(zzb3).zza()).zza());
            hashMap.put("ECIES_P256_HKDF_HMAC_SHA256_AES128_CTR_HMAC_SHA256_RAW", zzke.zzc().zza(zza3).zza(zzd2).zza(zzc3).zza(zze3).zza((zzce) zzdk.zzf().zza(16).zzb(32).zzd(16).zzc(16).zza(zzc7).zza(zzb3).zza()).zza());
            hashMap.put("ECIES_P256_COMPRESSED_HKDF_HMAC_SHA256_AES128_CTR_HMAC_SHA256", zzke.zzc().zza(zza3).zza(zzd2).zza(zzc5).zza(zze2).zza((zzce) zzdk.zzf().zza(16).zzb(32).zzd(16).zzc(16).zza(zzc7).zza(zzb3).zza()).zza());
            hashMap.put("ECIES_P256_COMPRESSED_HKDF_HMAC_SHA256_AES128_CTR_HMAC_SHA256_RAW", zzke.zzc().zza(zza3).zza(zzd2).zza(zzc5).zza(zze3).zza((zzce) zzdk.zzf().zza(16).zzb(32).zzd(16).zzc(16).zza(zzc7).zza(zzb3).zza()).zza());
            zza2.zza(Collections.unmodifiableMap(hashMap));
            zzoz.zza().zza(zza);
            zzoz.zza().zza(zzb);
            zzos.zza().zza(zze, zzke.class);
            zznt.zza().zza(zzc, true);
            zznt.zza().zza(zzd, false);
            return;
        }
        throw new GeneralSecurityException("Registering ECIES Hybrid Encryption is not supported in FIPS mode");
    }
}
