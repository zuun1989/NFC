package com.fis.ekyc.nfc.build_in.eidparser.protocol;

import com.fis.ekyc.nfc.build_in.eidparser.APDULevelEACTACapable;
import com.fis.ekyc.nfc.build_in.scuba.smartcards.APDUWrapper;
import com.fis.ekyc.nfc.build_in.scuba.smartcards.CardService;
import com.fis.ekyc.nfc.build_in.scuba.smartcards.CardServiceException;
import com.fis.ekyc.nfc.build_in.scuba.smartcards.CommandAPDU;

public class EACTAAPDUSender implements APDULevelEACTACapable {
    private SecureMessagingAPDUSender secureMessagingSender;

    public EACTAAPDUSender(CardService cardService) {
        this.secureMessagingSender = new SecureMessagingAPDUSender(cardService);
    }

    public synchronized byte[] sendGetChallenge(APDUWrapper aPDUWrapper) throws CardServiceException {
        return this.secureMessagingSender.transmit(aPDUWrapper, new CommandAPDU(0, -124, 0, 0, 8)).getData();
    }

    public synchronized void sendMSESetATExtAuth(APDUWrapper aPDUWrapper, byte[] bArr) throws CardServiceException {
        short sw = (short) this.secureMessagingSender.transmit(aPDUWrapper, new CommandAPDU(0, 34, 129, 164, bArr)).getSW();
        if (sw != -28672) {
            throw new CardServiceException("Sending MSE AT failed", (int) sw);
        }
    }

    public synchronized void sendMSESetDST(APDUWrapper aPDUWrapper, byte[] bArr) throws CardServiceException {
        short sw = (short) this.secureMessagingSender.transmit(aPDUWrapper, new CommandAPDU(0, 34, 129, 182, bArr)).getSW();
        if (sw != -28672) {
            throw new CardServiceException("Sending MSE Set DST failed", (int) sw);
        }
    }

    public synchronized void sendMutualAuthenticate(APDUWrapper aPDUWrapper, byte[] bArr) throws CardServiceException {
        short sw = (short) this.secureMessagingSender.transmit(aPDUWrapper, new CommandAPDU(0, -126, 0, 0, bArr)).getSW();
        if (sw != -28672) {
            throw new CardServiceException("Sending External Authenticate failed.", (int) sw);
        }
    }

    public synchronized void sendPSOExtendedLengthMode(APDUWrapper aPDUWrapper, byte[] bArr, byte[] bArr2) throws CardServiceException {
        byte[] bArr3 = new byte[(bArr.length + bArr2.length)];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
        short sw = (short) this.secureMessagingSender.transmit(aPDUWrapper, new CommandAPDU(0, 42, 0, 190, bArr3)).getSW();
        if (sw != -28672) {
            throw new CardServiceException("Sending PSO failed", (int) sw);
        }
    }
}
