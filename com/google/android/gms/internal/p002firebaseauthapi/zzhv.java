package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzix;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import javax.crypto.AEADBadTagException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzhv  reason: invalid package */
abstract class zzhv {
    private static final zzix.zza zza = zzix.zza.ALGORITHM_NOT_FIPS;
    private final zzht zzb;
    private final zzht zzc;

    public zzhv(byte[] bArr) throws GeneralSecurityException {
        if (zza.zza()) {
            this.zzb = zza(bArr, 1);
            this.zzc = zza(bArr, 0);
            return;
        }
        throw new GeneralSecurityException("Can not use ChaCha20Poly1305 in FIPS-mode.");
    }

    public abstract zzht zza(byte[] bArr, int i) throws InvalidKeyException;

    public void zza(ByteBuffer byteBuffer, byte[] bArr, byte[] bArr2, byte[] bArr3) throws GeneralSecurityException {
        if (byteBuffer.remaining() >= bArr2.length + 16) {
            int position = byteBuffer.position();
            this.zzb.zza(byteBuffer, bArr, bArr2);
            byteBuffer.position(position);
            byteBuffer.limit(byteBuffer.limit() - 16);
            if (bArr3 == null) {
                bArr3 = new byte[0];
            }
            byte[] zza2 = zzib.zza(zza(bArr), zza(bArr3, byteBuffer));
            byteBuffer.limit(byteBuffer.limit() + 16);
            byteBuffer.put(zza2);
            return;
        }
        throw new IllegalArgumentException("Given ByteBuffer output is too small");
    }

    public byte[] zza(ByteBuffer byteBuffer, byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (byteBuffer.remaining() >= 16) {
            int position = byteBuffer.position();
            byte[] bArr3 = new byte[16];
            byteBuffer.position(byteBuffer.limit() - 16);
            byteBuffer.get(bArr3);
            byteBuffer.position(position);
            byteBuffer.limit(byteBuffer.limit() - 16);
            if (bArr2 == null) {
                bArr2 = new byte[0];
            }
            try {
                if (MessageDigest.isEqual(zzib.zza(zza(bArr), zza(bArr2, byteBuffer)), bArr3)) {
                    byteBuffer.position(position);
                    return this.zzb.zza(bArr, byteBuffer);
                }
                throw new GeneralSecurityException("invalid MAC");
            } catch (GeneralSecurityException e) {
                throw new AEADBadTagException(e.toString());
            }
        } else {
            throw new GeneralSecurityException("ciphertext too short");
        }
    }

    public byte[] zza(byte[] bArr, byte[] bArr2, byte[] bArr3) throws GeneralSecurityException {
        return zza(ByteBuffer.wrap(bArr2), bArr, bArr3);
    }

    private final byte[] zza(byte[] bArr) throws GeneralSecurityException {
        byte[] bArr2 = new byte[32];
        this.zzc.zza(bArr, 0).get(bArr2);
        return bArr2;
    }

    private static byte[] zza(byte[] bArr, ByteBuffer byteBuffer) {
        int length = bArr.length % 16 == 0 ? bArr.length : (bArr.length + 16) - (bArr.length % 16);
        int remaining = byteBuffer.remaining();
        int i = remaining % 16;
        int i2 = (i == 0 ? remaining : (remaining + 16) - i) + length;
        ByteBuffer order = ByteBuffer.allocate(i2 + 16).order(ByteOrder.LITTLE_ENDIAN);
        order.put(bArr);
        order.position(length);
        order.put(byteBuffer);
        order.position(i2);
        order.putLong((long) bArr.length);
        order.putLong((long) remaining);
        return order.array();
    }
}
