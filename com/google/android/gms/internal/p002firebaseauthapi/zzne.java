package com.google.android.gms.internal.p002firebaseauthapi;

import android.util.Log;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.ProviderException;
import javax.crypto.BadPaddingException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzne  reason: invalid package */
public final class zzne implements zzaz {
    private static final String zza = "zzne";
    private final zzaz zzb;

    public zzne(String str) throws GeneralSecurityException, IOException {
        this.zzb = zznc.zza(str);
    }

    private static void zza() {
        try {
            Thread.sleep((long) ((int) (Math.random() * 100.0d)));
        } catch (InterruptedException unused) {
        }
    }

    public final byte[] zzb(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        try {
            return this.zzb.zzb(bArr, bArr2);
        } catch (GeneralSecurityException | ProviderException e) {
            Log.w(zza, "encountered a potentially transient KeyStore error, will wait and retry", e);
            zza();
            return this.zzb.zzb(bArr, bArr2);
        }
    }

    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        try {
            return this.zzb.zza(bArr, bArr2);
        } catch (BadPaddingException e) {
            throw e;
        } catch (GeneralSecurityException | ProviderException e2) {
            Log.w(zza, "encountered a potentially transient KeyStore error, will wait and retry", e2);
            zza();
            return this.zzb.zza(bArr, bArr2);
        }
    }
}
