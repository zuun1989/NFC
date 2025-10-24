package com.fis.ekyc.nfc.build_in.eidparser.protocol;

import com.fis.ekyc.nfc.build_in.eidparser.APDULevelBACCapable;
import com.fis.ekyc.nfc.build_in.eidparser.Util;
import com.fis.ekyc.nfc.build_in.scuba.smartcards.APDUWrapper;
import com.fis.ekyc.nfc.build_in.scuba.smartcards.CardService;
import com.fis.ekyc.nfc.build_in.scuba.smartcards.CardServiceException;
import com.fis.ekyc.nfc.build_in.scuba.smartcards.CommandAPDU;
import com.fis.ekyc.nfc.build_in.scuba.smartcards.ResponseAPDU;
import java.security.GeneralSecurityException;
import java.security.Provider;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.spec.IvParameterSpec;

public class BACAPDUSender implements APDULevelBACCapable {
    private static final Provider BC_PROVIDER = Util.getBouncyCastleProvider();
    private static final IvParameterSpec ZERO_IV_PARAM_SPEC = new IvParameterSpec(new byte[]{0, 0, 0, 0, 0, 0, 0, 0});
    private Cipher cipher;
    private Mac mac;
    private CardService service;

    public BACAPDUSender(CardService cardService) {
        this.service = cardService;
        try {
            this.mac = Mac.getInstance("ISO9797Alg3Mac", BC_PROVIDER);
            this.cipher = Util.getCipher("DESede/CBC/NoPadding");
        } catch (GeneralSecurityException e) {
            throw new IllegalStateException("Unexpected security exception during initialization", e);
        }
    }

    public synchronized byte[] sendGetChallenge() throws CardServiceException {
        return sendGetChallenge((APDUWrapper) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0029 A[Catch:{ GeneralSecurityException -> 0x001d, all -> 0x001a }] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0139 A[Catch:{ GeneralSecurityException -> 0x001d, all -> 0x001a }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized byte[] sendMutualAuth(byte[] r20, byte[] r21, byte[] r22, javax.crypto.SecretKey r23, javax.crypto.SecretKey r24) throws com.fis.ekyc.nfc.build_in.scuba.smartcards.CardServiceException {
        /*
            r19 = this;
            r1 = r19
            r0 = r20
            r2 = r21
            r3 = r22
            r4 = r23
            r5 = r24
            monitor-enter(r19)
            if (r0 == 0) goto L_0x0141
            int r6 = r0.length     // Catch:{ GeneralSecurityException -> 0x001d }
            r7 = 8
            if (r6 != r7) goto L_0x0141
            if (r2 == 0) goto L_0x0020
            int r6 = r2.length     // Catch:{ GeneralSecurityException -> 0x001d }
            if (r6 == r7) goto L_0x0022
            goto L_0x0020
        L_0x001a:
            r0 = move-exception
            goto L_0x0151
        L_0x001d:
            r0 = move-exception
            goto L_0x0149
        L_0x0020:
            byte[] r2 = new byte[r7]     // Catch:{ GeneralSecurityException -> 0x001d }
        L_0x0022:
            if (r3 == 0) goto L_0x0139
            int r6 = r3.length     // Catch:{ GeneralSecurityException -> 0x001d }
            r8 = 16
            if (r6 != r8) goto L_0x0139
            if (r4 == 0) goto L_0x0131
            if (r5 == 0) goto L_0x0129
            javax.crypto.Cipher r6 = r1.cipher     // Catch:{ GeneralSecurityException -> 0x001d }
            javax.crypto.spec.IvParameterSpec r9 = ZERO_IV_PARAM_SPEC     // Catch:{ GeneralSecurityException -> 0x001d }
            r10 = 1
            r6.init(r10, r4, r9)     // Catch:{ GeneralSecurityException -> 0x001d }
            r6 = 32
            byte[] r10 = new byte[r6]     // Catch:{ GeneralSecurityException -> 0x001d }
            r11 = 0
            java.lang.System.arraycopy(r0, r11, r10, r11, r7)     // Catch:{ GeneralSecurityException -> 0x001d }
            java.lang.System.arraycopy(r2, r11, r10, r7, r7)     // Catch:{ GeneralSecurityException -> 0x001d }
            java.lang.System.arraycopy(r3, r11, r10, r8, r8)     // Catch:{ GeneralSecurityException -> 0x001d }
            javax.crypto.Cipher r0 = r1.cipher     // Catch:{ GeneralSecurityException -> 0x001d }
            byte[] r0 = r0.doFinal(r10)     // Catch:{ GeneralSecurityException -> 0x001d }
            int r2 = r0.length     // Catch:{ GeneralSecurityException -> 0x001d }
            if (r2 != r6) goto L_0x0111
            javax.crypto.Mac r2 = r1.mac     // Catch:{ GeneralSecurityException -> 0x001d }
            r2.init(r5)     // Catch:{ GeneralSecurityException -> 0x001d }
            javax.crypto.Mac r2 = r1.mac     // Catch:{ GeneralSecurityException -> 0x001d }
            byte[] r3 = com.fis.ekyc.nfc.build_in.eidparser.Util.pad(r0, r7)     // Catch:{ GeneralSecurityException -> 0x001d }
            byte[] r2 = r2.doFinal(r3)     // Catch:{ GeneralSecurityException -> 0x001d }
            int r3 = r2.length     // Catch:{ GeneralSecurityException -> 0x001d }
            if (r3 != r7) goto L_0x0109
            r3 = 40
            byte[] r3 = new byte[r3]     // Catch:{ GeneralSecurityException -> 0x001d }
            java.lang.System.arraycopy(r0, r11, r3, r11, r6)     // Catch:{ GeneralSecurityException -> 0x001d }
            java.lang.System.arraycopy(r2, r11, r3, r6, r7)     // Catch:{ GeneralSecurityException -> 0x001d }
            com.fis.ekyc.nfc.build_in.scuba.smartcards.CommandAPDU r0 = new com.fis.ekyc.nfc.build_in.scuba.smartcards.CommandAPDU     // Catch:{ GeneralSecurityException -> 0x001d }
            r13 = 0
            r14 = -126(0xffffffffffffff82, float:NaN)
            r2 = 0
            r5 = 0
            r18 = 40
            r12 = r0
            r15 = r2
            r16 = r5
            r17 = r3
            r12.<init>(r13, r14, r15, r16, r17, r18)     // Catch:{ GeneralSecurityException -> 0x001d }
            com.fis.ekyc.nfc.build_in.scuba.smartcards.CardService r7 = r1.service     // Catch:{ GeneralSecurityException -> 0x001d }
            com.fis.ekyc.nfc.build_in.scuba.smartcards.ResponseAPDU r0 = r7.transmit(r0)     // Catch:{ GeneralSecurityException -> 0x001d }
            if (r0 == 0) goto L_0x0101
            byte[] r7 = r0.getBytes()     // Catch:{ GeneralSecurityException -> 0x001d }
            int r0 = r0.getSW()     // Catch:{ GeneralSecurityException -> 0x001d }
            short r0 = (short) r0     // Catch:{ GeneralSecurityException -> 0x001d }
            if (r7 == 0) goto L_0x00f9
            r8 = -28672(0xffffffffffff9000, float:NaN)
            if (r0 == r8) goto L_0x00b0
            com.fis.ekyc.nfc.build_in.scuba.smartcards.CommandAPDU r0 = new com.fis.ekyc.nfc.build_in.scuba.smartcards.CommandAPDU     // Catch:{ GeneralSecurityException -> 0x001d }
            r13 = 0
            r14 = -126(0xffffffffffffff82, float:NaN)
            r18 = 0
            r12 = r0
            r15 = r2
            r16 = r5
            r17 = r3
            r12.<init>(r13, r14, r15, r16, r17, r18)     // Catch:{ GeneralSecurityException -> 0x001d }
            com.fis.ekyc.nfc.build_in.scuba.smartcards.CardService r2 = r1.service     // Catch:{ GeneralSecurityException -> 0x001d }
            com.fis.ekyc.nfc.build_in.scuba.smartcards.ResponseAPDU r0 = r2.transmit(r0)     // Catch:{ GeneralSecurityException -> 0x001d }
            byte[] r7 = r0.getBytes()     // Catch:{ GeneralSecurityException -> 0x001d }
            int r0 = r0.getSW()     // Catch:{ GeneralSecurityException -> 0x001d }
            short r0 = (short) r0     // Catch:{ GeneralSecurityException -> 0x001d }
        L_0x00b0:
            int r2 = r7.length     // Catch:{ GeneralSecurityException -> 0x001d }
            r3 = 42
            if (r2 != r3) goto L_0x00e1
            javax.crypto.Cipher r2 = r1.cipher     // Catch:{ GeneralSecurityException -> 0x001d }
            r3 = 2
            r2.init(r3, r4, r9)     // Catch:{ GeneralSecurityException -> 0x001d }
            javax.crypto.Cipher r2 = r1.cipher     // Catch:{ GeneralSecurityException -> 0x001d }
            int r3 = r7.length     // Catch:{ GeneralSecurityException -> 0x001d }
            int r3 = r3 + -10
            byte[] r2 = r2.doFinal(r7, r11, r3)     // Catch:{ GeneralSecurityException -> 0x001d }
            int r3 = r2.length     // Catch:{ GeneralSecurityException -> 0x001d }
            if (r3 != r6) goto L_0x00c9
            monitor-exit(r19)
            return r2
        L_0x00c9:
            com.fis.ekyc.nfc.build_in.scuba.smartcards.CardServiceException r3 = new com.fis.ekyc.nfc.build_in.scuba.smartcards.CardServiceException     // Catch:{ GeneralSecurityException -> 0x001d }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ GeneralSecurityException -> 0x001d }
            r4.<init>()     // Catch:{ GeneralSecurityException -> 0x001d }
            java.lang.String r5 = "Cryptogram wrong length, was expecting 32, found "
            r4.append(r5)     // Catch:{ GeneralSecurityException -> 0x001d }
            int r2 = r2.length     // Catch:{ GeneralSecurityException -> 0x001d }
            r4.append(r2)     // Catch:{ GeneralSecurityException -> 0x001d }
            java.lang.String r2 = r4.toString()     // Catch:{ GeneralSecurityException -> 0x001d }
            r3.<init>((java.lang.String) r2, (int) r0)     // Catch:{ GeneralSecurityException -> 0x001d }
            throw r3     // Catch:{ GeneralSecurityException -> 0x001d }
        L_0x00e1:
            com.fis.ekyc.nfc.build_in.eidparser.CardServiceProtocolException r2 = new com.fis.ekyc.nfc.build_in.eidparser.CardServiceProtocolException     // Catch:{ GeneralSecurityException -> 0x001d }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ GeneralSecurityException -> 0x001d }
            r3.<init>()     // Catch:{ GeneralSecurityException -> 0x001d }
            java.lang.String r4 = "Mutual authentication failed: expected length: 40 + 2, actual length: "
            r3.append(r4)     // Catch:{ GeneralSecurityException -> 0x001d }
            int r4 = r7.length     // Catch:{ GeneralSecurityException -> 0x001d }
            r3.append(r4)     // Catch:{ GeneralSecurityException -> 0x001d }
            java.lang.String r3 = r3.toString()     // Catch:{ GeneralSecurityException -> 0x001d }
            r2.<init>((java.lang.String) r3, (int) r11, (int) r0)     // Catch:{ GeneralSecurityException -> 0x001d }
            throw r2     // Catch:{ GeneralSecurityException -> 0x001d }
        L_0x00f9:
            com.fis.ekyc.nfc.build_in.scuba.smartcards.CardServiceException r2 = new com.fis.ekyc.nfc.build_in.scuba.smartcards.CardServiceException     // Catch:{ GeneralSecurityException -> 0x001d }
            java.lang.String r3 = "Mutual authentication failed, received empty data in response APDU"
            r2.<init>((java.lang.String) r3, (int) r0)     // Catch:{ GeneralSecurityException -> 0x001d }
            throw r2     // Catch:{ GeneralSecurityException -> 0x001d }
        L_0x0101:
            com.fis.ekyc.nfc.build_in.scuba.smartcards.CardServiceException r0 = new com.fis.ekyc.nfc.build_in.scuba.smartcards.CardServiceException     // Catch:{ GeneralSecurityException -> 0x001d }
            java.lang.String r2 = "Mutual authentication failed, received null response APDU"
            r0.<init>(r2)     // Catch:{ GeneralSecurityException -> 0x001d }
            throw r0     // Catch:{ GeneralSecurityException -> 0x001d }
        L_0x0109:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ GeneralSecurityException -> 0x001d }
            java.lang.String r2 = "MAC wrong length"
            r0.<init>(r2)     // Catch:{ GeneralSecurityException -> 0x001d }
            throw r0     // Catch:{ GeneralSecurityException -> 0x001d }
        L_0x0111:
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException     // Catch:{ GeneralSecurityException -> 0x001d }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ GeneralSecurityException -> 0x001d }
            r3.<init>()     // Catch:{ GeneralSecurityException -> 0x001d }
            java.lang.String r4 = "Cryptogram wrong length "
            r3.append(r4)     // Catch:{ GeneralSecurityException -> 0x001d }
            int r0 = r0.length     // Catch:{ GeneralSecurityException -> 0x001d }
            r3.append(r0)     // Catch:{ GeneralSecurityException -> 0x001d }
            java.lang.String r0 = r3.toString()     // Catch:{ GeneralSecurityException -> 0x001d }
            r2.<init>(r0)     // Catch:{ GeneralSecurityException -> 0x001d }
            throw r2     // Catch:{ GeneralSecurityException -> 0x001d }
        L_0x0129:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ GeneralSecurityException -> 0x001d }
            java.lang.String r2 = "kMac == null"
            r0.<init>(r2)     // Catch:{ GeneralSecurityException -> 0x001d }
            throw r0     // Catch:{ GeneralSecurityException -> 0x001d }
        L_0x0131:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ GeneralSecurityException -> 0x001d }
            java.lang.String r2 = "kEnc == null"
            r0.<init>(r2)     // Catch:{ GeneralSecurityException -> 0x001d }
            throw r0     // Catch:{ GeneralSecurityException -> 0x001d }
        L_0x0139:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ GeneralSecurityException -> 0x001d }
            java.lang.String r2 = "kIFD wrong length"
            r0.<init>(r2)     // Catch:{ GeneralSecurityException -> 0x001d }
            throw r0     // Catch:{ GeneralSecurityException -> 0x001d }
        L_0x0141:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ GeneralSecurityException -> 0x001d }
            java.lang.String r2 = "rndIFD wrong length"
            r0.<init>(r2)     // Catch:{ GeneralSecurityException -> 0x001d }
            throw r0     // Catch:{ GeneralSecurityException -> 0x001d }
        L_0x0149:
            com.fis.ekyc.nfc.build_in.scuba.smartcards.CardServiceException r2 = new com.fis.ekyc.nfc.build_in.scuba.smartcards.CardServiceException     // Catch:{ all -> 0x001a }
            java.lang.String r3 = "Security exception during mutual auth"
            r2.<init>((java.lang.String) r3, (java.lang.Throwable) r0)     // Catch:{ all -> 0x001a }
            throw r2     // Catch:{ all -> 0x001a }
        L_0x0151:
            monitor-exit(r19)     // Catch:{ all -> 0x001a }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fis.ekyc.nfc.build_in.eidparser.protocol.BACAPDUSender.sendMutualAuth(byte[], byte[], byte[], javax.crypto.SecretKey, javax.crypto.SecretKey):byte[]");
    }

    public synchronized byte[] sendGetChallenge(APDUWrapper aPDUWrapper) throws CardServiceException {
        byte[] data;
        ResponseAPDU transmit = this.service.transmit(new CommandAPDU(0, -124, 0, 0, 8));
        data = transmit.getData();
        if (data == null || data.length != 8) {
            throw new CardServiceException("Get challenge failed", transmit.getSW());
        }
        return data;
    }
}
