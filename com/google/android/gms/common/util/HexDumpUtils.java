package com.google.android.gms.common.util;

import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public final class HexDumpUtils {
    @KeepForSdk
    public static String dump(byte[] bArr, int i, int i2, boolean z) {
        int length;
        int i3;
        if (bArr == null || (length = bArr.length) == 0 || i < 0 || i2 <= 0 || i + i2 > length) {
            return null;
        }
        if (z) {
            i3 = 75;
        } else {
            i3 = 57;
        }
        StringBuilder sb2 = new StringBuilder(i3 * ((i2 + 15) / 16));
        int i4 = i2;
        int i5 = 0;
        int i6 = 0;
        while (i4 > 0) {
            if (i5 == 0) {
                if (i2 < 65536) {
                    sb2.append(String.format("%04X:", new Object[]{Integer.valueOf(i)}));
                } else {
                    sb2.append(String.format("%08X:", new Object[]{Integer.valueOf(i)}));
                }
                i6 = i;
            } else if (i5 == 8) {
                sb2.append(" -");
            }
            sb2.append(String.format(" %02X", new Object[]{Integer.valueOf(bArr[i] & 255)}));
            i4--;
            i5++;
            if (z && (i5 == 16 || i4 == 0)) {
                int i7 = 16 - i5;
                if (i7 > 0) {
                    for (int i8 = 0; i8 < i7; i8++) {
                        sb2.append("   ");
                    }
                }
                if (i7 >= 8) {
                    sb2.append("  ");
                }
                sb2.append("  ");
                for (int i9 = 0; i9 < i5; i9++) {
                    char c = (char) bArr[i6 + i9];
                    if (c < ' ' || c > '~') {
                        c = '.';
                    }
                    sb2.append(c);
                }
            }
            if (i5 == 16 || i4 == 0) {
                sb2.append(10);
                i5 = 0;
            }
            i++;
        }
        return sb2.toString();
    }
}
