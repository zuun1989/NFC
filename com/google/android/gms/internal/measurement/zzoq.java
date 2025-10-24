package com.google.android.gms.internal.measurement;

import com.fis.ekyc.nfc.build_in.eidparser.IdCardService;
import com.fis.ekyc.nfc.build_in.scuba.smartcards.ISO7816;

final class zzoq {
    public static /* synthetic */ boolean zza(byte b) {
        return b >= 0;
    }

    public static /* synthetic */ void zzb(byte b, byte b2, char[] cArr, int i) {
        if (b < -62 || zze(b2)) {
            throw new zzmr("Protocol message had invalid UTF-8.");
        }
        cArr[i] = (char) (((b & 31) << 6) | (b2 & 63));
    }

    public static /* synthetic */ void zzc(byte b, byte b2, byte b3, char[] cArr, int i) {
        if (!zze(b2)) {
            if (b == -32) {
                if (b2 >= -96) {
                    b = -32;
                }
            }
            if (b == -19) {
                if (b2 < -96) {
                    b = -19;
                }
            }
            if (!zze(b3)) {
                cArr[i] = (char) (((b & IdCardService.SFI_DG15) << IdCardService.SFI_DG12) | ((b2 & 63) << 6) | (b3 & 63));
                return;
            }
        }
        throw new zzmr("Protocol message had invalid UTF-8.");
    }

    public static /* synthetic */ void zzd(byte b, byte b2, byte b3, byte b4, char[] cArr, int i) {
        if (zze(b2) || (((b << 28) + (b2 + ISO7816.INS_MANAGE_CHANNEL)) >> 30) != 0 || zze(b3) || zze(b4)) {
            throw new zzmr("Protocol message had invalid UTF-8.");
        }
        byte b5 = ((b & 7) << 18) | ((b2 & 63) << IdCardService.SFI_DG12) | ((b3 & 63) << 6) | (b4 & 63);
        cArr[i] = (char) ((b5 >>> 10) + 55232);
        cArr[i + 1] = (char) ((b5 & 1023) + 56320);
    }

    private static boolean zze(byte b) {
        return b > -65;
    }
}
