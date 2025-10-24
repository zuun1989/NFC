package com.google.android.gms.internal.p002firebaseauthapi;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzia  reason: invalid package */
public final class zzia extends zzhv {
    public zzia(byte[] bArr) throws GeneralSecurityException {
        super(bArr);
    }

    public final zzht zza(byte[] bArr, int i) throws InvalidKeyException {
        return new zzhx(bArr, i);
    }

    public final /* bridge */ /* synthetic */ void zza(ByteBuffer byteBuffer, byte[] bArr, byte[] bArr2, byte[] bArr3) throws GeneralSecurityException {
        super.zza(byteBuffer, bArr, bArr2, bArr3);
    }

    public final /* bridge */ /* synthetic */ byte[] zza(ByteBuffer byteBuffer, byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        return super.zza(byteBuffer, bArr, bArr2);
    }

    public final /* bridge */ /* synthetic */ byte[] zza(byte[] bArr, byte[] bArr2, byte[] bArr3) throws GeneralSecurityException {
        return super.zza(bArr, bArr2, bArr3);
    }
}
