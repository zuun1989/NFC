package com.fis.ekyc.nfc.build_in.eidparser.protocol;

import com.fis.ekyc.nfc.build_in.eidparser.APDULevelEACCACapable;
import com.fis.ekyc.nfc.build_in.scuba.smartcards.APDUWrapper;
import com.fis.ekyc.nfc.build_in.scuba.smartcards.CardService;
import com.fis.ekyc.nfc.build_in.scuba.smartcards.CardServiceException;
import com.fis.ekyc.nfc.build_in.scuba.smartcards.CommandAPDU;
import com.fis.ekyc.nfc.build_in.scuba.smartcards.ResponseAPDU;
import com.fis.ekyc.nfc.build_in.scuba.tlv.TLVUtil;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EACCAAPDUSender implements APDULevelEACCACapable {
    private static final byte INS_BSI_GENERAL_AUTHENTICATE = -122;
    private static final Logger LOGGER = Logger.getLogger("com.fis.ekyc.sdk.nfc.build_in..jmrtd.protocol");
    private SecureMessagingAPDUSender secureMessagingSender;

    public EACCAAPDUSender(CardService cardService) {
        this.secureMessagingSender = new SecureMessagingAPDUSender(cardService);
    }

    public synchronized byte[] sendGeneralAuthenticate(APDUWrapper aPDUWrapper, byte[] bArr, boolean z) throws CardServiceException {
        return sendGeneralAuthenticate(aPDUWrapper, bArr, 256, z);
    }

    public synchronized void sendMSEKAT(APDUWrapper aPDUWrapper, byte[] bArr, byte[] bArr2) throws CardServiceException {
        int i;
        try {
            int length = bArr.length;
            if (bArr2 != null) {
                i = bArr2.length;
            } else {
                i = 0;
            }
            byte[] bArr3 = new byte[(length + i)];
            System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
            if (bArr2 != null) {
                System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
            }
            short sw = (short) this.secureMessagingSender.transmit(aPDUWrapper, new CommandAPDU(0, 34, 65, 166, bArr3)).getSW();
            if (sw != -28672) {
                throw new CardServiceException("Sending MSE KAT failed", (int) sw);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0062 A[Catch:{ IOException -> 0x002f }] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0064 A[Catch:{ IOException -> 0x002f }] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x006d A[DONT_GENERATE] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x006f A[SYNTHETIC, Splitter:B:24:0x006f] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void sendMSESetATIntAuth(com.fis.ekyc.nfc.build_in.scuba.smartcards.APDUWrapper r7, java.lang.String r8, java.math.BigInteger r9) throws com.fis.ekyc.nfc.build_in.scuba.smartcards.CardServiceException {
        /*
            r6 = this;
            monitor-enter(r6)
            r3 = 65
            r4 = 164(0xa4, float:2.3E-43)
            if (r9 == 0) goto L_0x004d
            java.math.BigInteger r0 = java.math.BigInteger.ZERO     // Catch:{ all -> 0x002d }
            int r0 = r9.compareTo(r0)     // Catch:{ all -> 0x002d }
            if (r0 >= 0) goto L_0x0010
            goto L_0x004d
        L_0x0010:
            byte[] r8 = com.fis.ekyc.nfc.build_in.eidparser.Util.toOIDBytes(r8)     // Catch:{ all -> 0x002d }
            byte[] r9 = com.fis.ekyc.nfc.build_in.eidparser.Util.i2os(r9)     // Catch:{ all -> 0x002d }
            r0 = 132(0x84, float:1.85E-43)
            byte[] r9 = com.fis.ekyc.nfc.build_in.scuba.tlv.TLVUtil.wrapDO(r0, r9)     // Catch:{ all -> 0x002d }
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream     // Catch:{ all -> 0x002d }
            r0.<init>()     // Catch:{ all -> 0x002d }
            r0.write(r8)     // Catch:{ IOException -> 0x002f }
            r0.write(r9)     // Catch:{ IOException -> 0x002f }
            r0.close()     // Catch:{ IOException -> 0x002f }
            goto L_0x0039
        L_0x002d:
            r7 = move-exception
            goto L_0x0077
        L_0x002f:
            r8 = move-exception
            java.util.logging.Logger r9 = LOGGER     // Catch:{ all -> 0x002d }
            java.util.logging.Level r1 = java.util.logging.Level.WARNING     // Catch:{ all -> 0x002d }
            java.lang.String r2 = "Exception"
            r9.log(r1, r2, r8)     // Catch:{ all -> 0x002d }
        L_0x0039:
            com.fis.ekyc.nfc.build_in.scuba.smartcards.CommandAPDU r8 = new com.fis.ekyc.nfc.build_in.scuba.smartcards.CommandAPDU     // Catch:{ all -> 0x002d }
            byte[] r5 = r0.toByteArray()     // Catch:{ all -> 0x002d }
            r1 = 0
            r2 = 34
            r0 = r8
            r0.<init>((int) r1, (int) r2, (int) r3, (int) r4, (byte[]) r5)     // Catch:{ all -> 0x002d }
            com.fis.ekyc.nfc.build_in.eidparser.protocol.SecureMessagingAPDUSender r9 = r6.secureMessagingSender     // Catch:{ all -> 0x002d }
            com.fis.ekyc.nfc.build_in.scuba.smartcards.ResponseAPDU r7 = r9.transmit(r7, r8)     // Catch:{ all -> 0x002d }
            goto L_0x0060
        L_0x004d:
            com.fis.ekyc.nfc.build_in.scuba.smartcards.CommandAPDU r9 = new com.fis.ekyc.nfc.build_in.scuba.smartcards.CommandAPDU     // Catch:{ all -> 0x002d }
            byte[] r5 = com.fis.ekyc.nfc.build_in.eidparser.Util.toOIDBytes(r8)     // Catch:{ all -> 0x002d }
            r1 = 0
            r2 = 34
            r0 = r9
            r0.<init>((int) r1, (int) r2, (int) r3, (int) r4, (byte[]) r5)     // Catch:{ all -> 0x002d }
            com.fis.ekyc.nfc.build_in.eidparser.protocol.SecureMessagingAPDUSender r8 = r6.secureMessagingSender     // Catch:{ all -> 0x002d }
            com.fis.ekyc.nfc.build_in.scuba.smartcards.ResponseAPDU r7 = r8.transmit(r7, r9)     // Catch:{ all -> 0x002d }
        L_0x0060:
            if (r7 != 0) goto L_0x0064
            r7 = -1
            goto L_0x0069
        L_0x0064:
            int r7 = r7.getSW()     // Catch:{ all -> 0x002d }
            short r7 = (short) r7
        L_0x0069:
            r8 = -28672(0xffffffffffff9000, float:NaN)
            if (r7 != r8) goto L_0x006f
            monitor-exit(r6)
            return
        L_0x006f:
            com.fis.ekyc.nfc.build_in.scuba.smartcards.CardServiceException r8 = new com.fis.ekyc.nfc.build_in.scuba.smartcards.CardServiceException     // Catch:{ all -> 0x002d }
            java.lang.String r9 = "Sending MSE AT failed"
            r8.<init>((java.lang.String) r9, (int) r7)     // Catch:{ all -> 0x002d }
            throw r8     // Catch:{ all -> 0x002d }
        L_0x0077:
            monitor-exit(r6)     // Catch:{ all -> 0x002d }
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fis.ekyc.nfc.build_in.eidparser.protocol.EACCAAPDUSender.sendMSESetATIntAuth(com.fis.ekyc.nfc.build_in.scuba.smartcards.APDUWrapper, java.lang.String, java.math.BigInteger):void");
    }

    public synchronized byte[] sendGeneralAuthenticate(APDUWrapper aPDUWrapper, byte[] bArr, int i, boolean z) throws CardServiceException {
        byte[] data;
        try {
            byte[] wrapDO = TLVUtil.wrapDO(124, bArr);
            ResponseAPDU transmit = this.secureMessagingSender.transmit(aPDUWrapper, new CommandAPDU(z ? 0 : 16, -122, 0, 0, wrapDO, i));
            short sw = (short) transmit.getSW();
            if (sw == 26368) {
                transmit = this.secureMessagingSender.transmit(aPDUWrapper, new CommandAPDU(z ? 0 : 16, -122, 0, 0, wrapDO, 256));
            }
            if (sw == -28672) {
                data = transmit.getData();
                data = TLVUtil.unwrapDO(124, data);
            } else {
                throw new CardServiceException("Sending general authenticate failed", (int) sw);
            }
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Could not unwrap response to GENERAL AUTHENTICATE", e);
        } catch (Throwable th) {
            throw th;
        }
        return data;
    }
}
