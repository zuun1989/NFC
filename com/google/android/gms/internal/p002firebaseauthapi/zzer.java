package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzix;
import com.google.android.gms.internal.p002firebaseauthapi.zzxa;
import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzer  reason: invalid package */
public final class zzer {
    private static final zzbk<zzaz> zza;
    private static final zzou<zzfe> zzb = new zzeu();
    private static final zzpr<zzfc, zzaz> zzc;

    static {
        Class<zzaz> cls = zzaz.class;
        zza = zzoc.zza("type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey", cls, zzxa.zza.SYMMETRIC, zzxw.zze());
        zzc = zzpr.zza(new zzet(), zzfc.class, cls);
    }

    public static void zza(boolean z) throws GeneralSecurityException {
        if (zzix.zza.ALGORITHM_NOT_FIPS.zza()) {
            zzff.zza();
            zzos.zza().zza(zzb, zzfe.class);
            zzoz.zza().zza(zzc);
            zznt.zza().zza(zza, true);
            return;
        }
        throw new GeneralSecurityException("Registering KMS Envelope AEAD is not supported in FIPS mode");
    }
}
