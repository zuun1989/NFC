package com.google.android.gms.internal.clearcut;

import com.fis.ekyc.nfc.build_in.scuba.smartcards.ISO7816;
import java.nio.ByteBuffer;

final class zzfh extends zzfg {
    public final int zzb(int i, byte[] bArr, int i2, int i3) {
        while (r10 < i3 && bArr[r10] >= 0) {
            i2 = r10 + 1;
        }
        if (r10 >= i3) {
            return 0;
        }
        while (r10 < i3) {
            int i4 = r10 + 1;
            byte b = bArr[r10];
            if (b >= 0) {
                r10 = i4;
            } else if (b < -32) {
                if (i4 >= i3) {
                    return b;
                }
                if (b >= -62) {
                    r10 += 2;
                    if (bArr[i4] > -65) {
                    }
                }
                return -1;
            } else if (b < -16) {
                if (i4 >= i3 - 1) {
                    return zzff.zzf(bArr, i4, i3);
                }
                int i5 = r10 + 2;
                byte b2 = bArr[i4];
                if (b2 <= -65 && ((b != -32 || b2 >= -96) && (b != -19 || b2 < -96))) {
                    r10 += 3;
                    if (bArr[i5] > -65) {
                    }
                }
                return -1;
            } else if (i4 >= i3 - 2) {
                return zzff.zzf(bArr, i4, i3);
            } else {
                int i6 = r10 + 2;
                byte b3 = bArr[i4];
                if (b3 <= -65 && (((b << 28) + (b3 + ISO7816.INS_MANAGE_CHANNEL)) >> 30) == 0) {
                    int i7 = r10 + 3;
                    if (bArr[i6] <= -65) {
                        r10 += 4;
                        if (bArr[i7] > -65) {
                        }
                    }
                }
                return -1;
            }
        }
        return 0;
    }

    public final int zzb(CharSequence charSequence, byte[] bArr, int i, int i2) {
        int i3;
        int i4;
        char charAt;
        int length = charSequence.length();
        int i5 = i2 + i;
        int i6 = 0;
        while (i6 < length && (i4 = i6 + i) < i5 && (charAt = charSequence.charAt(i6)) < 128) {
            bArr[i4] = (byte) charAt;
            i6++;
        }
        if (i6 == length) {
            return i + length;
        }
        int i7 = i + i6;
        while (i6 < length) {
            char charAt2 = charSequence.charAt(i6);
            if (charAt2 < 128 && i7 < i5) {
                bArr[i7] = (byte) charAt2;
                i7++;
            } else if (charAt2 < 2048 && i7 <= i5 - 2) {
                int i8 = i7 + 1;
                bArr[i7] = (byte) ((charAt2 >>> 6) | 960);
                i7 += 2;
                bArr[i8] = (byte) ((charAt2 & '?') | 128);
            } else if ((charAt2 < 55296 || 57343 < charAt2) && i7 <= i5 - 3) {
                bArr[i7] = (byte) ((charAt2 >>> 12) | 480);
                int i9 = i7 + 2;
                bArr[i7 + 1] = (byte) (((charAt2 >>> 6) & 63) | 128);
                i7 += 3;
                bArr[i9] = (byte) ((charAt2 & '?') | 128);
            } else if (i7 <= i5 - 4) {
                int i10 = i6 + 1;
                if (i10 != charSequence.length()) {
                    char charAt3 = charSequence.charAt(i10);
                    if (Character.isSurrogatePair(charAt2, charAt3)) {
                        int codePoint = Character.toCodePoint(charAt2, charAt3);
                        bArr[i7] = (byte) ((codePoint >>> 18) | 240);
                        bArr[i7 + 1] = (byte) (((codePoint >>> 12) & 63) | 128);
                        int i11 = i7 + 3;
                        bArr[i7 + 2] = (byte) (((codePoint >>> 6) & 63) | 128);
                        i7 += 4;
                        bArr[i11] = (byte) ((codePoint & 63) | 128);
                        i6 = i10;
                    } else {
                        i6 = i10;
                    }
                }
                throw new zzfi(i6 - 1, length);
            } else if (55296 > charAt2 || charAt2 > 57343 || ((i3 = i6 + 1) != charSequence.length() && Character.isSurrogatePair(charAt2, charSequence.charAt(i3)))) {
                StringBuilder sb2 = new StringBuilder(37);
                sb2.append("Failed writing ");
                sb2.append(charAt2);
                sb2.append(" at index ");
                sb2.append(i7);
                throw new ArrayIndexOutOfBoundsException(sb2.toString());
            } else {
                throw new zzfi(i6, length);
            }
            i6++;
        }
        return i7;
    }

    public final void zzb(CharSequence charSequence, ByteBuffer byteBuffer) {
        zzfg.zzc(charSequence, byteBuffer);
    }
}
