package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzix;
import com.google.android.gms.internal.p002firebaseauthapi.zzqw;
import com.google.android.gms.internal.p002firebaseauthapi.zzxa;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzqt  reason: invalid package */
public final class zzqt {
    private static final zzou<zzqw> zza = new zzqs();
    private static final zzpr<zzqp, zzqz> zzb;
    private static final zzpr<zzqp, zzcb> zzc;
    private static final zzbk<zzcb> zzd;

    static {
        Class<zzqp> cls = zzqp.class;
        zzb = zzpr.zza(new zzqv(), cls, zzqz.class);
        Class<zzcb> cls2 = zzcb.class;
        zzc = zzpr.zza(new zzqu(), cls, cls2);
        zzd = zzoc.zza("type.googleapis.com/google.crypto.tink.AesCmacKey", cls2, zzxa.zza.SYMMETRIC, zzsz.zzf());
    }

    public static void zza(boolean z) throws GeneralSecurityException {
        if (zzix.zza.ALGORITHM_NOT_FIPS.zza()) {
            zzry.zza();
            zzos.zza().zza(zza, zzqw.class);
            zzoz.zza().zza(zzb);
            zzoz.zza().zza(zzc);
            zzpa zza2 = zzpa.zza();
            HashMap hashMap = new HashMap();
            zzqw zzqw = zzrs.zzc;
            hashMap.put("AES_CMAC", zzqw);
            hashMap.put("AES256_CMAC", zzqw);
            hashMap.put("AES256_CMAC_RAW", zzqw.zzd().zza(32).zzb(16).zza(zzqw.zzb.zzd).zza());
            zza2.zza(Collections.unmodifiableMap(hashMap));
            zznt.zza().zza(zzd, true);
            return;
        }
        throw new GeneralSecurityException("Registering AES CMAC is not supported in FIPS mode");
    }

    /* access modifiers changed from: private */
    public static void zza(zzqw zzqw) throws GeneralSecurityException {
        if (zzqw.zzc() != 32) {
            throw new GeneralSecurityException("AesCmacKey size wrong, must be 32 bytes");
        }
    }
}
