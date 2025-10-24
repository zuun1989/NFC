package com.fis.ekyc.nfc.build_in.eidparser.protocol;

import com.fis.ekyc.nfc.build_in.eidparser.Util;
import com.fis.ekyc.nfc.build_in.eidparser.WrappedAPDUEvent;
import com.fis.ekyc.nfc.build_in.scuba.smartcards.APDUEvent;
import com.fis.ekyc.nfc.build_in.scuba.smartcards.APDUListener;
import com.fis.ekyc.nfc.build_in.scuba.smartcards.APDUWrapper;
import com.fis.ekyc.nfc.build_in.scuba.smartcards.CardService;
import com.fis.ekyc.nfc.build_in.scuba.smartcards.CardServiceException;
import com.fis.ekyc.nfc.build_in.scuba.smartcards.CommandAPDU;
import com.fis.ekyc.nfc.build_in.scuba.smartcards.ISO7816;
import com.fis.ekyc.nfc.build_in.scuba.smartcards.ResponseAPDU;
import com.fis.ekyc.nfc.build_in.scuba.util.Hex;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SecureMessagingAPDUSender {
    private static final Logger LOGGER = Logger.getLogger("com.fis.ekyc.sdk.nfc.build_in..jmrtd.protocol");
    private int apduCount = 0;
    private CardService service;

    public SecureMessagingAPDUSender(CardService cardService) {
        this.service = cardService;
    }

    private byte[] continueSendingUsingResponseChaining(APDUWrapper aPDUWrapper, short s, byte[] bArr) throws CardServiceException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            if ((65280 & s) != 24832) {
                break;
            }
            try {
                byteArrayOutputStream.write(bArr);
                short s2 = s & 255;
                if (s2 <= 0) {
                    break;
                }
                ResponseAPDU transmit = transmit(aPDUWrapper, new CommandAPDU(0, -64, 0, 0, (int) s2));
                byte[] data = transmit.getData();
                s = (short) transmit.getSW();
                bArr = data;
            } catch (IOException e) {
                throw new CardServiceException("Could not write to stream", e, s);
            } catch (Throwable th) {
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e2) {
                    LOGGER.log(Level.FINE, "Error closing stream", e2);
                }
                throw th;
            }
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        try {
            byteArrayOutputStream.close();
        } catch (IOException e3) {
            LOGGER.log(Level.FINE, "Error closing stream", e3);
        }
        return byteArray;
    }

    private List<ResponseAPDU> sendUsingCommandChaining(CommandAPDU commandAPDU, int i) throws CardServiceException {
        int i2;
        List<byte[]> partition = Util.partition(i, commandAPDU.getData());
        ArrayList arrayList = new ArrayList(partition.size());
        int i3 = 0;
        for (byte[] next : partition) {
            boolean z = true;
            i3++;
            if (i3 < partition.size()) {
                z = false;
            }
            int cla = commandAPDU.getCLA();
            if (!z) {
                i2 = cla | 16;
            } else {
                i2 = cla;
            }
            arrayList.add(this.service.transmit(new CommandAPDU(i2, commandAPDU.getINS(), commandAPDU.getP1(), commandAPDU.getP2(), next, commandAPDU.getNe())));
        }
        return arrayList;
    }

    public void addAPDUListener(APDUListener aPDUListener) {
        this.service.addAPDUListener(aPDUListener);
    }

    public boolean isExtendedAPDULengthSupported() {
        return this.service.isExtendedAPDULengthSupported();
    }

    public void notifyExchangedAPDU(APDUEvent aPDUEvent) {
        Collection<APDUListener> aPDUListeners = this.service.getAPDUListeners();
        if (aPDUListeners != null && !aPDUListeners.isEmpty()) {
            for (APDUListener exchangedAPDU : aPDUListeners) {
                exchangedAPDU.exchangedAPDU(aPDUEvent);
            }
        }
    }

    public void removeAPDUListener(APDUListener aPDUListener) {
        this.service.removeAPDUListener(aPDUListener);
    }

    public ResponseAPDU transmit(APDUWrapper aPDUWrapper, CommandAPDU commandAPDU) throws CardServiceException {
        CommandAPDU commandAPDU2;
        if (aPDUWrapper != null) {
            commandAPDU2 = aPDUWrapper.wrap(commandAPDU);
        } else {
            commandAPDU2 = commandAPDU;
        }
        ResponseAPDU transmit = this.service.transmit(commandAPDU2);
        short sw = (short) transmit.getSW();
        if (aPDUWrapper == null) {
            int i = this.apduCount + 1;
            this.apduCount = i;
            notifyExchangedAPDU(new APDUEvent(this, "PLAIN", i, commandAPDU2, transmit));
            return transmit;
        } else if ((sw & ISO7816.SW_WRONG_LENGTH) != 26368) {
            try {
                if (transmit.getBytes().length > 2) {
                    ResponseAPDU unwrap = aPDUWrapper.unwrap(transmit);
                    String type = aPDUWrapper.getType();
                    int i2 = this.apduCount + 1;
                    this.apduCount = i2;
                    notifyExchangedAPDU(new WrappedAPDUEvent(this, type, i2, commandAPDU, unwrap, commandAPDU2, transmit));
                    return unwrap;
                }
                throw new CardServiceException("Exception during transmission of wrapped APDU, C=" + Hex.bytesToHexString(commandAPDU.getBytes()), (int) sw);
            } catch (CardServiceException e) {
                throw e;
            } catch (Exception e2) {
                throw new CardServiceException("Exception during transmission of wrapped APDU, C=" + Hex.bytesToHexString(commandAPDU.getBytes()), e2, sw);
            } catch (Throwable th) {
                String type2 = aPDUWrapper.getType();
                int i3 = this.apduCount + 1;
                this.apduCount = i3;
                notifyExchangedAPDU(new WrappedAPDUEvent(this, type2, i3, commandAPDU, transmit, commandAPDU2, transmit));
                throw th;
            }
        } else {
            String type3 = aPDUWrapper.getType();
            int i4 = this.apduCount + 1;
            this.apduCount = i4;
            notifyExchangedAPDU(new WrappedAPDUEvent(this, type3, i4, commandAPDU, transmit, commandAPDU2, transmit));
            return transmit;
        }
    }
}
