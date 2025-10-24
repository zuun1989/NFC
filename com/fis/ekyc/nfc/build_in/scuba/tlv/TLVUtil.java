package com.fis.ekyc.nfc.build_in.scuba.tlv;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.eac.CertificateHolderAuthorization;
import com.fis.ekyc.nfc.build_in.scuba.smartcards.ISO7816;
import com.fis.ekyc.nfc.build_in.scuba.smartcards.ISOFileInfo;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TLVUtil implements ASN1Constants {
    private static final Logger LOGGER = Logger.getLogger("com.fis.ekyc.nfc.build_in.scuba.tlv");

    private TLVUtil() {
    }

    public static byte[] getLengthAsBytes(int i) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        if (i < 128) {
            byteArrayOutputStream.write(i);
        } else {
            int log = log(i, 256);
            byteArrayOutputStream.write(log | 128);
            for (int i2 = 0; i2 < log; i2++) {
                int i3 = ((log - i2) - 1) * 8;
                byteArrayOutputStream.write(((255 << i3) & i) >> i3);
            }
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static int getLengthLength(int i) {
        return getLengthAsBytes(i).length;
    }

    public static byte[] getTagAsBytes(int i) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int log = ((int) (Math.log((double) i) / Math.log(256.0d))) + 1;
        for (int i2 = 0; i2 < log; i2++) {
            int i3 = ((log - i2) - 1) * 8;
            byteArrayOutputStream.write(((255 << i3) & i) >> i3);
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        int tagClass = getTagClass(i);
        if (tagClass == 1) {
            byteArray[0] = (byte) (byteArray[0] | 64);
        } else if (tagClass == 2) {
            byteArray[0] = (byte) (byteArray[0] | ISOFileInfo.DATA_BYTES1);
        } else if (tagClass == 3) {
            byteArray[0] = (byte) (byteArray[0] | ISO7816.INS_GET_RESPONSE);
        }
        if (!isPrimitive(i)) {
            byteArray[0] = (byte) (byteArray[0] | ISO7816.INS_VERIFY);
        }
        return byteArray;
    }

    public static int getTagClass(int i) {
        int i2 = 3;
        while (i2 >= 0 && ((255 << (i2 * 8)) & i) == 0) {
            i2--;
        }
        int i3 = i2 * 8;
        int i4 = ((i & (255 << i3)) >> i3) & CertificateHolderAuthorization.CVCA;
        if (i4 == 0) {
            return 0;
        }
        if (i4 != 64) {
            return i4 != 128 ? 3 : 2;
        }
        return 1;
    }

    public static int getTagLength(int i) {
        return getTagAsBytes(i).length;
    }

    public static boolean isPrimitive(int i) {
        int i2 = 3;
        while (i2 >= 0 && ((255 << (i2 * 8)) & i) == 0) {
            i2--;
        }
        int i3 = i2 * 8;
        return (((i & (255 << i3)) >> i3) & 32) == 0;
    }

    private static int log(int i, int i2) {
        int i3 = 0;
        while (i > 0) {
            i /= i2;
            i3++;
        }
        return i3;
    }

    public static byte[] unwrapDO(int i, byte[] bArr) {
        if (bArr == null || bArr.length < 2) {
            throw new IllegalArgumentException("Wrapped data is null or length < 2");
        }
        TLVInputStream tLVInputStream = new TLVInputStream(new ByteArrayInputStream(bArr));
        try {
            int readTag = tLVInputStream.readTag();
            if (readTag == i) {
                int readLength = tLVInputStream.readLength();
                byte[] bArr2 = new byte[readLength];
                System.arraycopy(tLVInputStream.readValue(), 0, bArr2, 0, readLength);
                try {
                    tLVInputStream.close();
                } catch (IOException e) {
                    LOGGER.log(Level.FINE, "Error closing stream", e);
                }
                return bArr2;
            }
            throw new IllegalArgumentException("Expected tag " + Integer.toHexString(i) + ", found tag " + Integer.toHexString(readTag));
        } catch (IOException e2) {
            throw new IllegalStateException("Error reading from stream", e2);
        } catch (Throwable th) {
            try {
                tLVInputStream.close();
            } catch (IOException e3) {
                LOGGER.log(Level.FINE, "Error closing stream", e3);
            }
            throw th;
        }
    }

    public static byte[] wrapDO(int i, byte[] bArr) {
        if (bArr != null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                TLVOutputStream tLVOutputStream = new TLVOutputStream(byteArrayOutputStream);
                tLVOutputStream.writeTag(i);
                tLVOutputStream.writeValue(bArr);
                tLVOutputStream.flush();
                tLVOutputStream.close();
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e) {
                    LOGGER.log(Level.FINE, "Error closing stream", e);
                }
                return byteArray;
            } catch (IOException e2) {
                throw new IllegalStateException("Error writing stream", e2);
            } catch (Throwable th) {
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e3) {
                    LOGGER.log(Level.FINE, "Error closing stream", e3);
                }
                throw th;
            }
        } else {
            throw new IllegalArgumentException("Data to wrap is null");
        }
    }
}
