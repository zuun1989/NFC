package com.google.android.gms.internal.p002firebaseauthapi;

import com.fis.ekyc.nfc.build_in.eidparser.lds.iso19794.IrisImageInfo;
import com.fis.ekyc.nfc.build_in.scuba.smartcards.ISOFileInfo;
import java.util.Arrays;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzse  reason: invalid package */
public final class zzse {
    public static byte[] zza(byte[] bArr) {
        if (bArr.length < 16) {
            byte[] copyOf = Arrays.copyOf(bArr, 16);
            copyOf[bArr.length] = ISOFileInfo.DATA_BYTES1;
            return copyOf;
        }
        throw new IllegalArgumentException("x must be smaller than a block.");
    }

    public static byte[] zzb(byte[] bArr) {
        if (bArr.length == 16) {
            byte[] bArr2 = new byte[16];
            for (int i = 0; i < 16; i++) {
                byte b = (byte) ((bArr[i] << 1) & IrisImageInfo.IMAGE_QUAL_UNDEF);
                bArr2[i] = b;
                if (i < 15) {
                    bArr2[i] = (byte) (((byte) ((bArr[i + 1] >> 7) & 1)) | b);
                }
            }
            bArr2[15] = (byte) (((byte) ((bArr[0] >> 7) & 135)) ^ bArr2[15]);
            return bArr2;
        }
        throw new IllegalArgumentException("value must be a block.");
    }
}
