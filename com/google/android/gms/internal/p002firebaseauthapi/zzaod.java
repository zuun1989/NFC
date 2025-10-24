package com.google.android.gms.internal.p002firebaseauthapi;

import com.fis.ekyc.nfc.build_in.eidparser.IdCardService;
import com.fis.ekyc.nfc.build_in.scuba.smartcards.ISO7816;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaod  reason: invalid package */
final class zzaod {
    private static boolean zza(byte b) {
        return b > -65;
    }

    public static /* synthetic */ void zza(byte b, byte b2, byte b3, byte b4, char[] cArr, int i) {
        if (zza(b2) || (((b << 28) + (b2 + ISO7816.INS_MANAGE_CHANNEL)) >> 30) != 0 || zza(b3) || zza(b4)) {
            throw zzalm.zzd();
        }
        byte b5 = ((b & 7) << 18) | ((b2 & 63) << IdCardService.SFI_DG12) | ((b3 & 63) << 6) | (b4 & 63);
        cArr[i] = (char) ((b5 >>> 10) + 55232);
        cArr[i + 1] = (char) ((b5 & 1023) + 56320);
    }

    public static /* synthetic */ void zza(byte b, char[] cArr, int i) {
        cArr[i] = (char) b;
    }

    public static /* synthetic */ void zza(byte b, byte b2, byte b3, char[] cArr, int i) {
        if (zza(b2) || ((b == -32 && b2 < -96) || ((b == -19 && b2 >= -96) || zza(b3)))) {
            throw zzalm.zzd();
        }
        cArr[i] = (char) (((b & IdCardService.SFI_DG15) << IdCardService.SFI_DG12) | ((b2 & 63) << 6) | (b3 & 63));
    }

    public static /* synthetic */ void zza(byte b, byte b2, char[] cArr, int i) {
        if (b < -62 || zza(b2)) {
            throw zzalm.zzd();
        }
        cArr[i] = (char) (((b & 31) << 6) | (b2 & 63));
    }
}
