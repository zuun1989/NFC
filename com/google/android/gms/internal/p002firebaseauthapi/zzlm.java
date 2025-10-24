package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzlm  reason: invalid package */
public final class zzlm {
    /* access modifiers changed from: private */
    public static final byte[] zza = new byte[0];

    public static zzlq zza(zzke zzke) throws GeneralSecurityException {
        zzce zzb = zzke.zzb();
        if (zzb instanceof zzdz) {
            return new zzlo((zzdz) zzb);
        }
        if (zzb instanceof zzdk) {
            return new zzlp((zzdk) zzb);
        }
        if (zzb instanceof zzjh) {
            return new zzlr((zzjh) zzb);
        }
        String valueOf = String.valueOf(zzb);
        throw new GeneralSecurityException("Unsupported DEM parameters: " + valueOf);
    }
}
