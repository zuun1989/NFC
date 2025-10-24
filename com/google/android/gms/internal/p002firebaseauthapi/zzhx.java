package com.google.android.gms.internal.p002firebaseauthapi;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzhx  reason: invalid package */
public final class zzhx extends zzht {
    public zzhx(byte[] bArr, int i) throws InvalidKeyException {
        super(bArr, i);
    }

    public final int zza() {
        return 24;
    }

    public final /* bridge */ /* synthetic */ void zza(ByteBuffer byteBuffer, byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        super.zza(byteBuffer, bArr, bArr2);
    }

    public final /* bridge */ /* synthetic */ byte[] zza(byte[] bArr, ByteBuffer byteBuffer) throws GeneralSecurityException {
        return super.zza(bArr, byteBuffer);
    }

    public final int[] zza(int[] iArr, int i) {
        if (iArr.length == 6) {
            int[] iArr2 = new int[16];
            zzhs.zza(iArr2, zzhs.zzb(this.zza, iArr));
            iArr2[12] = i;
            iArr2[13] = 0;
            iArr2[14] = iArr[4];
            iArr2[15] = iArr[5];
            return iArr2;
        }
        throw new IllegalArgumentException(String.format("XChaCha20 uses 192-bit nonces, but got a %d-bit nonce", new Object[]{Integer.valueOf(iArr.length << 5)}));
    }
}
