package com.google.android.gms.internal.p002firebaseauthapi;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzht  reason: invalid package */
abstract class zzht {
    int[] zza;
    private final int zzb;

    public zzht(byte[] bArr, int i) throws InvalidKeyException {
        if (bArr.length == 32) {
            this.zza = zzhs.zza(bArr);
            this.zzb = i;
            return;
        }
        throw new InvalidKeyException("The key length in bytes must be 32.");
    }

    public abstract int zza();

    public final ByteBuffer zza(byte[] bArr, int i) {
        int[] zza2 = zza(zzhs.zza(bArr), i);
        int[] iArr = (int[]) zza2.clone();
        zzhs.zza(iArr);
        for (int i2 = 0; i2 < zza2.length; i2++) {
            zza2[i2] = zza2[i2] + iArr[i2];
        }
        ByteBuffer order = ByteBuffer.allocate(64).order(ByteOrder.LITTLE_ENDIAN);
        order.asIntBuffer().put(zza2, 0, 16);
        return order;
    }

    public abstract int[] zza(int[] iArr, int i);

    public void zza(ByteBuffer byteBuffer, byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (byteBuffer.remaining() >= bArr2.length) {
            zza(bArr, byteBuffer, ByteBuffer.wrap(bArr2));
            return;
        }
        throw new IllegalArgumentException("Given ByteBuffer output is too small");
    }

    private final void zza(byte[] bArr, ByteBuffer byteBuffer, ByteBuffer byteBuffer2) throws GeneralSecurityException {
        if (bArr.length == zza()) {
            int remaining = byteBuffer2.remaining();
            int i = remaining / 64;
            int i2 = i + 1;
            for (int i3 = 0; i3 < i2; i3++) {
                ByteBuffer zza2 = zza(bArr, this.zzb + i3);
                if (i3 == i) {
                    zzzc.zza(byteBuffer, byteBuffer2, zza2, remaining % 64);
                } else {
                    zzzc.zza(byteBuffer, byteBuffer2, zza2, 64);
                }
            }
            return;
        }
        int zza3 = zza();
        throw new GeneralSecurityException("The nonce length (in bytes) must be " + zza3);
    }

    public byte[] zza(byte[] bArr, ByteBuffer byteBuffer) throws GeneralSecurityException {
        ByteBuffer allocate = ByteBuffer.allocate(byteBuffer.remaining());
        zza(bArr, allocate, byteBuffer);
        return allocate.array();
    }
}
