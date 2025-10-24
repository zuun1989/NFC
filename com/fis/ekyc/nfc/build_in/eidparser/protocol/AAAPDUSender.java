package com.fis.ekyc.nfc.build_in.eidparser.protocol;

import com.fis.ekyc.nfc.build_in.eidparser.APDULevelAACapable;
import com.fis.ekyc.nfc.build_in.scuba.smartcards.CardService;
import java.util.logging.Logger;

public class AAAPDUSender implements APDULevelAACapable {
    private static final Logger LOGGER = Logger.getLogger("com.fis.ekyc.sdk.nfc.build_in..jmrtd.protocol");
    private SecureMessagingAPDUSender secureMessagingSender;

    public AAAPDUSender(CardService cardService) {
        this.secureMessagingSender = new SecureMessagingAPDUSender(cardService);
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0052 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00a6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized byte[] sendInternalAuthenticate(com.fis.ekyc.nfc.build_in.scuba.smartcards.APDUWrapper r12, byte[] r13) throws com.fis.ekyc.nfc.build_in.scuba.smartcards.CardServiceException {
        /*
            r11 = this;
            monitor-enter(r11)
            if (r13 == 0) goto L_0x00da
            int r0 = r13.length     // Catch:{ all -> 0x0022 }
            r1 = 8
            if (r0 != r1) goto L_0x00da
            com.fis.ekyc.nfc.build_in.scuba.smartcards.CommandAPDU r0 = new com.fis.ekyc.nfc.build_in.scuba.smartcards.CommandAPDU     // Catch:{ all -> 0x0022 }
            r6 = 0
            r8 = 256(0x100, float:3.59E-43)
            r3 = 0
            r4 = -120(0xffffffffffffff88, float:NaN)
            r5 = 0
            r2 = r0
            r7 = r13
            r2.<init>(r3, r4, r5, r6, r7, r8)     // Catch:{ all -> 0x0022 }
            r1 = 0
            com.fis.ekyc.nfc.build_in.eidparser.protocol.SecureMessagingAPDUSender r2 = r11.secureMessagingSender     // Catch:{ CardServiceException -> 0x0027 }
            com.fis.ekyc.nfc.build_in.scuba.smartcards.ResponseAPDU r2 = r2.transmit(r12, r0)     // Catch:{ CardServiceException -> 0x0027 }
            int r0 = r2.getSW()     // Catch:{ CardServiceException -> 0x0025 }
            goto L_0x004d
        L_0x0022:
            r12 = move-exception
            goto L_0x00e2
        L_0x0025:
            r3 = move-exception
            goto L_0x0029
        L_0x0027:
            r3 = move-exception
            r2 = r1
        L_0x0029:
            java.util.logging.Logger r4 = LOGGER     // Catch:{ all -> 0x0022 }
            java.util.logging.Level r5 = java.util.logging.Level.INFO     // Catch:{ all -> 0x0022 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0022 }
            r6.<init>()     // Catch:{ all -> 0x0022 }
            java.lang.String r7 = "Exception during transmission of command APDU = "
            r6.append(r7)     // Catch:{ all -> 0x0022 }
            byte[] r0 = r0.getBytes()     // Catch:{ all -> 0x0022 }
            java.lang.String r0 = com.fis.ekyc.nfc.build_in.scuba.util.Hex.bytesToHexString(r0)     // Catch:{ all -> 0x0022 }
            r6.append(r0)     // Catch:{ all -> 0x0022 }
            java.lang.String r0 = r6.toString()     // Catch:{ all -> 0x0022 }
            r4.log(r5, r0, r3)     // Catch:{ all -> 0x0022 }
            int r0 = r3.getSW()     // Catch:{ all -> 0x0022 }
        L_0x004d:
            short r0 = (short) r0     // Catch:{ all -> 0x0022 }
            r3 = -28672(0xffffffffffff9000, float:NaN)
            if (r0 != r3) goto L_0x005a
            if (r2 == 0) goto L_0x005a
            byte[] r12 = r2.getData()     // Catch:{ all -> 0x0022 }
            monitor-exit(r11)
            return r12
        L_0x005a:
            r3 = 65280(0xff00, float:9.1477E-41)
            r3 = r3 & r0
            r4 = 24832(0x6100, float:3.4797E-41)
            if (r3 != r4) goto L_0x00a6
            if (r2 != 0) goto L_0x0066
            r2 = r1
            goto L_0x006a
        L_0x0066:
            byte[] r2 = r2.getData()     // Catch:{ all -> 0x0022 }
        L_0x006a:
            com.fis.ekyc.nfc.build_in.scuba.smartcards.CommandAPDU r10 = new com.fis.ekyc.nfc.build_in.scuba.smartcards.CommandAPDU     // Catch:{ all -> 0x0022 }
            r7 = 0
            r9 = 65536(0x10000, float:9.18355E-41)
            r4 = 0
            r5 = -120(0xffffffffffffff88, float:NaN)
            r6 = 0
            r3 = r10
            r8 = r13
            r3.<init>(r4, r5, r6, r7, r8, r9)     // Catch:{ all -> 0x0022 }
            com.fis.ekyc.nfc.build_in.eidparser.protocol.SecureMessagingAPDUSender r13 = r11.secureMessagingSender     // Catch:{ all -> 0x0022 }
            com.fis.ekyc.nfc.build_in.scuba.smartcards.ResponseAPDU r12 = r13.transmit(r12, r10)     // Catch:{ all -> 0x0022 }
            if (r12 != 0) goto L_0x0081
            goto L_0x0085
        L_0x0081:
            byte[] r1 = r12.getData()     // Catch:{ all -> 0x0022 }
        L_0x0085:
            if (r2 != 0) goto L_0x0092
            if (r1 == 0) goto L_0x008a
            goto L_0x0092
        L_0x008a:
            com.fis.ekyc.nfc.build_in.scuba.smartcards.CardServiceException r12 = new com.fis.ekyc.nfc.build_in.scuba.smartcards.CardServiceException     // Catch:{ all -> 0x0022 }
            java.lang.String r13 = "Internal Authenticate failed"
            r12.<init>((java.lang.String) r13, (int) r0)     // Catch:{ all -> 0x0022 }
            throw r12     // Catch:{ all -> 0x0022 }
        L_0x0092:
            if (r2 == 0) goto L_0x0098
            if (r1 != 0) goto L_0x0098
            monitor-exit(r11)
            return r2
        L_0x0098:
            if (r2 != 0) goto L_0x009e
            if (r1 == 0) goto L_0x009e
            monitor-exit(r11)
            return r1
        L_0x009e:
            int r12 = r2.length     // Catch:{ all -> 0x0022 }
            int r13 = r1.length     // Catch:{ all -> 0x0022 }
            if (r12 <= r13) goto L_0x00a4
            monitor-exit(r11)
            return r2
        L_0x00a4:
            monitor-exit(r11)
            return r1
        L_0x00a6:
            if (r2 == 0) goto L_0x00d2
            byte[] r12 = r2.getData()     // Catch:{ all -> 0x0022 }
            if (r12 == 0) goto L_0x00d2
            java.util.logging.Logger r12 = LOGGER     // Catch:{ all -> 0x0022 }
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ all -> 0x0022 }
            r13.<init>()     // Catch:{ all -> 0x0022 }
            java.lang.String r1 = "Internal Authenticate may not have succeeded, got status word "
            r13.append(r1)     // Catch:{ all -> 0x0022 }
            r1 = 65535(0xffff, float:9.1834E-41)
            r0 = r0 & r1
            java.lang.String r0 = java.lang.Integer.toHexString(r0)     // Catch:{ all -> 0x0022 }
            r13.append(r0)     // Catch:{ all -> 0x0022 }
            java.lang.String r13 = r13.toString()     // Catch:{ all -> 0x0022 }
            r12.warning(r13)     // Catch:{ all -> 0x0022 }
            byte[] r12 = r2.getData()     // Catch:{ all -> 0x0022 }
            monitor-exit(r11)
            return r12
        L_0x00d2:
            com.fis.ekyc.nfc.build_in.scuba.smartcards.CardServiceException r12 = new com.fis.ekyc.nfc.build_in.scuba.smartcards.CardServiceException     // Catch:{ all -> 0x0022 }
            java.lang.String r13 = "Internal Authenticate failed"
            r12.<init>((java.lang.String) r13, (int) r0)     // Catch:{ all -> 0x0022 }
            throw r12     // Catch:{ all -> 0x0022 }
        L_0x00da:
            java.lang.IllegalArgumentException r12 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x0022 }
            java.lang.String r13 = "rndIFD wrong length"
            r12.<init>(r13)     // Catch:{ all -> 0x0022 }
            throw r12     // Catch:{ all -> 0x0022 }
        L_0x00e2:
            monitor-exit(r11)     // Catch:{ all -> 0x0022 }
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fis.ekyc.nfc.build_in.eidparser.protocol.AAAPDUSender.sendInternalAuthenticate(com.fis.ekyc.nfc.build_in.scuba.smartcards.APDUWrapper, byte[]):byte[]");
    }
}
