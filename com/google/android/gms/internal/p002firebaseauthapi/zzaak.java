package com.google.android.gms.internal.p002firebaseauthapi;

import com.fis.ekyc.nfc.build_in.scuba.smartcards.ISOFileInfo;
import java.security.InvalidKeyException;
import java.util.Arrays;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaak  reason: invalid package */
public final class zzaak {
    public static byte[] zza(byte[] bArr, byte[] bArr2) throws InvalidKeyException {
        if (bArr.length == 32) {
            long[] jArr = new long[11];
            byte[] copyOf = Arrays.copyOf(bArr, 32);
            copyOf[0] = (byte) (copyOf[0] & 248);
            byte b = (byte) (copyOf[31] & Byte.MAX_VALUE);
            copyOf[31] = b;
            copyOf[31] = (byte) (b | 64);
            zznj.zza(jArr, copyOf, bArr2);
            return zznp.zzc(jArr);
        }
        throw new InvalidKeyException("Private key must have 32 bytes.");
    }

    public static byte[] zza() {
        byte[] zza = zzqg.zza(32);
        zza[0] = (byte) (zza[0] | 7);
        byte b = (byte) (zza[31] & 63);
        zza[31] = b;
        zza[31] = (byte) (b | ISOFileInfo.DATA_BYTES1);
        return zza;
    }

    public static byte[] zza(byte[] bArr) throws InvalidKeyException {
        if (bArr.length == 32) {
            byte[] bArr2 = new byte[32];
            bArr2[0] = 9;
            return zza(bArr, bArr2);
        }
        throw new InvalidKeyException("Private key must have 32 bytes.");
    }
}
