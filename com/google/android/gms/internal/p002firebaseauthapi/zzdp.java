package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzdq;
import com.google.android.gms.internal.p002firebaseauthapi.zzix;
import com.google.android.gms.internal.p002firebaseauthapi.zzxa;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzdp  reason: invalid package */
public final class zzdp {
    private static final zzpr<zzdl, zzaz> zza;
    private static final zzbk<zzaz> zzb;
    private static final zzou<zzdq> zzc = new zzdr();

    static {
        Class<zzaz> cls = zzaz.class;
        zza = zzpr.zza(new zzdo(), zzdl.class, cls);
        zzb = zzoc.zza("type.googleapis.com/google.crypto.tink.AesEaxKey", cls, zzxa.zza.SYMMETRIC, zztx.zzf());
    }

    public static /* synthetic */ zzdl zza(zzdq zzdq, Integer num) {
        if (zzdq.zzc() != 24) {
            return zzdl.zze().zza(zzdq).zza(num).zza(zzaan.zza(zzdq.zzc())).zza();
        }
        throw new GeneralSecurityException("192 bit AES GCM Parameters are not valid");
    }

    public static String zza() {
        return "type.googleapis.com/google.crypto.tink.AesEaxKey";
    }

    public static void zza(boolean z) throws GeneralSecurityException {
        if (zzix.zza.ALGORITHM_NOT_FIPS.zza()) {
            zzgo.zza();
            zzoz.zza().zza(zza);
            zzpa zza2 = zzpa.zza();
            HashMap hashMap = new HashMap();
            hashMap.put("AES128_EAX", zzfl.zzc);
            zzdq.zzb zzc2 = zzdq.zze().zza(16).zzb(16).zzc(16);
            zzdq.zza zza3 = zzdq.zza.zzc;
            hashMap.put("AES128_EAX_RAW", zzc2.zza(zza3).zza());
            hashMap.put("AES256_EAX", zzfl.zzd);
            hashMap.put("AES256_EAX_RAW", zzdq.zze().zza(16).zzb(32).zzc(16).zza(zza3).zza());
            zza2.zza(Collections.unmodifiableMap(hashMap));
            zzos.zza().zza(zzc, zzdq.class);
            zznt.zza().zza(zzb, true);
            return;
        }
        throw new GeneralSecurityException("Registering AES EAX is not supported in FIPS mode");
    }
}
