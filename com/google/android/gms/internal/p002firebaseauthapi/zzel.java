package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzem;
import com.google.android.gms.internal.p002firebaseauthapi.zzix;
import com.google.android.gms.internal.p002firebaseauthapi.zzxa;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzel  reason: invalid package */
public final class zzel {
    private static final zzpr<zzei, zzaz> zza;
    private static final zzou<zzem> zzb = new zzen();
    private static final zzbk<zzaz> zzc;

    static {
        Class<zzaz> cls = zzaz.class;
        zza = zzpr.zza(new zzek(), zzei.class, cls);
        zzc = zzoc.zza("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key", cls, zzxa.zza.SYMMETRIC, zzuy.zze());
    }

    public static /* synthetic */ zzaz zza(zzei zzei) {
        if (zzhk.zzb()) {
            return zzhk.zza(zzei);
        }
        return zzzb.zza(zzei);
    }

    public static zzei zza(zzem zzem, Integer num) throws GeneralSecurityException {
        return zzei.zza(zzem.zzb(), zzaan.zza(32), num);
    }

    public static String zza() {
        return "type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key";
    }

    public static void zza(boolean z) throws GeneralSecurityException {
        if (zzix.zza.ALGORITHM_NOT_FIPS.zza()) {
            zzhm.zza();
            zzoz.zza().zza(zza);
            zzos.zza().zza(zzb, zzem.class);
            zzpa zza2 = zzpa.zza();
            HashMap hashMap = new HashMap();
            hashMap.put("CHACHA20_POLY1305", zzem.zza(zzem.zza.zza));
            hashMap.put("CHACHA20_POLY1305_RAW", zzem.zza(zzem.zza.zzc));
            zza2.zza(Collections.unmodifiableMap(hashMap));
            zznt.zza().zza(zzc, true);
            return;
        }
        throw new GeneralSecurityException("Registering ChaCha20Poly1305 is not supported in FIPS mode");
    }
}
