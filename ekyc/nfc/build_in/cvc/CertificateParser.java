package com.fis.ekyc.nfc.build_in.cvc;

import com.fis.ekyc.nfc.build_in.cvc.exception.ConstructionException;
import com.fis.ekyc.nfc.build_in.cvc.exception.ParseException;
import java.io.DataInputStream;
import java.io.IOException;

public final class CertificateParser {

    /* renamed from: com.fis.ekyc.nfc.build_in.cvc.CertificateParser$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$fis$ekyc$nfc$build_in$cvc$CVCTagEnum;

        static {
            int[] iArr = new int[CVCTagEnum.values().length];
            $SwitchMap$com$fis$ekyc$nfc$build_in$cvc$CVCTagEnum = iArr;
            try {
                iArr[CVCTagEnum.DISCRETIONARY_DATA_TEMPLATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    private CertificateParser() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x001b A[Catch:{ IOException -> 0x0013 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.fis.ekyc.nfc.build_in.cvc.CVCObject decode(byte[] r2, com.fis.ekyc.nfc.build_in.cvc.CVCTagEnum r3) throws com.fis.ekyc.nfc.build_in.cvc.exception.ParseException, com.fis.ekyc.nfc.build_in.cvc.exception.ConstructionException {
        /*
            r0 = 0
            java.io.ByteArrayInputStream r1 = new java.io.ByteArrayInputStream     // Catch:{ all -> 0x0018 }
            r1.<init>(r2)     // Catch:{ all -> 0x0018 }
            java.io.DataInputStream r2 = new java.io.DataInputStream     // Catch:{ all -> 0x0015 }
            r2.<init>(r1)     // Catch:{ all -> 0x0015 }
            com.fis.ekyc.nfc.build_in.cvc.CVCObject r2 = decode(r2, r3, r0)     // Catch:{ all -> 0x0015 }
            r1.close()     // Catch:{ IOException -> 0x0013 }
            return r2
        L_0x0013:
            r2 = move-exception
            goto L_0x001f
        L_0x0015:
            r2 = move-exception
            r0 = r1
            goto L_0x0019
        L_0x0018:
            r2 = move-exception
        L_0x0019:
            if (r0 == 0) goto L_0x001e
            r0.close()     // Catch:{ IOException -> 0x0013 }
        L_0x001e:
            throw r2     // Catch:{ IOException -> 0x0013 }
        L_0x001f:
            com.fis.ekyc.nfc.build_in.cvc.exception.ParseException r3 = new com.fis.ekyc.nfc.build_in.cvc.exception.ParseException
            r3.<init>((java.lang.Throwable) r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fis.ekyc.nfc.build_in.cvc.CertificateParser.decode(byte[], com.fis.ekyc.nfc.build_in.cvc.CVCTagEnum):com.fis.ekyc.nfc.build_in.cvc.CVCObject");
    }

    private static int decodeTag(DataInputStream dataInputStream) throws IOException {
        int readUnsignedByte = dataInputStream.readUnsignedByte();
        if ((readUnsignedByte & 31) != 31) {
            return readUnsignedByte;
        }
        return (readUnsignedByte << 8) + dataInputStream.readByte();
    }

    private static CVCTagEnum findTagFromValue(int i) throws ParseException {
        CVCTagEnum cVCTagEnum;
        CVCTagEnum[] values = CVCTagEnum.values();
        int length = values.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                cVCTagEnum = null;
                break;
            }
            cVCTagEnum = values[i2];
            if (cVCTagEnum.getValue() == i) {
                break;
            }
            i2++;
        }
        if (cVCTagEnum != null) {
            return cVCTagEnum;
        }
        throw new ParseException("Unknown CVC tag value " + Integer.toHexString(i));
    }

    public static CVCObject parseCVCObject(byte[] bArr) throws ParseException, ConstructionException {
        return decode(bArr, (CVCTagEnum) null);
    }

    public static CVCertificate parseCertificate(byte[] bArr) throws ParseException, ConstructionException {
        return (CVCertificate) decode(bArr, CVCTagEnum.CV_CERTIFICATE);
    }

    private static CVCObject decode(DataInputStream dataInputStream, CVCTagEnum cVCTagEnum, CVCTagEnum cVCTagEnum2) throws IOException, ConstructionException, ParseException {
        CVCTagEnum cVCTagEnum3;
        CVCTagEnum findTagFromValue = findTagFromValue(decodeTag(dataInputStream));
        if (cVCTagEnum == null || findTagFromValue == cVCTagEnum) {
            if (cVCTagEnum2 == null || findTagFromValue.getValue() != cVCTagEnum2.getValue()) {
                cVCTagEnum2 = findTagFromValue;
            }
            int decodeLength = CVCObject.decodeLength(dataInputStream);
            if (cVCTagEnum2.isSequence()) {
                int available = dataInputStream.available() - decodeLength;
                AbstractSequence createSequence = SequenceFactory.createSequence(cVCTagEnum2);
                while (dataInputStream.available() > available) {
                    if (AnonymousClass1.$SwitchMap$com$fis$ekyc$nfc$build_in$cvc$CVCTagEnum[cVCTagEnum2.ordinal()] != 1) {
                        cVCTagEnum3 = null;
                    } else {
                        cVCTagEnum3 = CVCTagEnum.ARBITRARY_DATA;
                    }
                    createSequence.addSubfield(decode(dataInputStream, (CVCTagEnum) null, cVCTagEnum3));
                }
                return createSequence instanceof GenericPublicKeyField ? KeyFactory.createInstance((GenericPublicKeyField) createSequence) : createSequence;
            }
            byte[] bArr = new byte[decodeLength];
            dataInputStream.read(bArr, 0, decodeLength);
            return FieldFactory.decodeField(cVCTagEnum2, bArr);
        }
        throw new ParseException("Expected first tag " + cVCTagEnum + " but found " + findTagFromValue);
    }
}
