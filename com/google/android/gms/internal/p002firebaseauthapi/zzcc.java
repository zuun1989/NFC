package com.google.android.gms.internal.p002firebaseauthapi;

import java.io.IOException;
import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzcc  reason: invalid package */
public final class zzcc {
    public static zzbl zza(zzby zzby, zzck zzck) throws GeneralSecurityException, IOException {
        if (zzck != null) {
            return zzbl.zza(zzby.zzb());
        }
        throw new NullPointerException("SecretKeyAccess cannot be null");
    }

    public static void zza(zzbl zzbl, zzbx zzbx, zzck zzck) throws IOException {
        if (zzck != null) {
            zzbx.zza(zzbl.zzd());
            return;
        }
        throw new NullPointerException("SecretKeyAccess cannot be null");
    }
}
