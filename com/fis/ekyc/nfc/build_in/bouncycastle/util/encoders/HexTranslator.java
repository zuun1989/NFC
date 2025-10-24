package com.fis.ekyc.nfc.build_in.bouncycastle.util.encoders;

import com.fis.ekyc.nfc.build_in.eidparser.IdCardService;
import com.fis.ekyc.nfc.build_in.scuba.smartcards.ISO7816;
import com.fis.ekyc.nfc.build_in.scuba.smartcards.ISOFileInfo;

public class HexTranslator implements Translator {
    private static final byte[] hexTable = {ISO7816.INS_DECREASE, 49, ISO7816.INS_INCREASE, 51, ISO7816.INS_DECREASE_STAMPED, 53, 54, 55, 56, 57, 97, ISOFileInfo.FCP_BYTE, 99, ISOFileInfo.FMD_BYTE, 101, 102};

    public int decode(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        int i4 = i2 / 2;
        for (int i5 = 0; i5 < i4; i5++) {
            int i6 = (i5 * 2) + i;
            byte b = bArr[i6];
            byte b2 = bArr[i6 + 1];
            if (b < 97) {
                bArr2[i3] = (byte) ((b + ISO7816.INS_WRITE_BINARY) << 4);
            } else {
                bArr2[i3] = (byte) ((b - 87) << 4);
            }
            if (b2 < 97) {
                bArr2[i3] = (byte) (bArr2[i3] + ((byte) (b2 + ISO7816.INS_WRITE_BINARY)));
            } else {
                bArr2[i3] = (byte) (bArr2[i3] + ((byte) (b2 - 87)));
            }
            i3++;
        }
        return i4;
    }

    public int encode(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        int i4 = 0;
        int i5 = 0;
        while (i4 < i2) {
            int i6 = i3 + i5;
            byte[] bArr3 = hexTable;
            bArr2[i6] = bArr3[(bArr[i] >> 4) & 15];
            bArr2[i6 + 1] = bArr3[bArr[i] & IdCardService.SFI_DG15];
            i++;
            i4++;
            i5 += 2;
        }
        return i2 * 2;
    }

    public int getDecodedBlockSize() {
        return 1;
    }

    public int getEncodedBlockSize() {
        return 2;
    }
}
