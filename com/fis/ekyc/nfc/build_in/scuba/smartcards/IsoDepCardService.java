package com.fis.ekyc.nfc.build_in.scuba.smartcards;

import android.nfc.Tag;
import android.nfc.tech.IsoDep;
import android.nfc.tech.NfcA;
import android.nfc.tech.NfcB;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class IsoDepCardService extends CardService {
    private static final Logger LOGGER = Logger.getLogger("com.fis.ekyc.nfc.build_in.scuba");
    private int apduCount = 0;
    private IsoDep isoDep;

    public IsoDepCardService(IsoDep isoDep2) {
        this.isoDep = isoDep2;
    }

    public void close() {
        try {
            this.isoDep.close();
            this.state = 0;
        } catch (IOException unused) {
        }
    }

    public byte[] getATR() {
        Tag tag;
        IsoDep isoDep2 = this.isoDep;
        if (isoDep2 == null || (tag = isoDep2.getTag()) == null) {
            return null;
        }
        if (NfcA.get(tag) != null) {
            return this.isoDep.getHistoricalBytes();
        }
        if (NfcB.get(tag) != null) {
            return this.isoDep.getHiLayerResponse();
        }
        return this.isoDep.getHistoricalBytes();
    }

    public boolean isConnectionLost(Exception exc) {
        if (exc == null) {
            return false;
        }
        if (exc.getClass().getName().contains("TagLostException")) {
            return true;
        }
        String message = exc.getMessage();
        if (message == null) {
            message = "";
        }
        return message.toLowerCase().contains("tag was lost");
    }

    public boolean isExtendedAPDULengthSupported() {
        return this.isoDep.isExtendedLengthApduSupported();
    }

    public boolean isOpen() {
        if (this.isoDep.isConnected()) {
            this.state = 1;
            return true;
        }
        this.state = 0;
        return false;
    }

    public void open() throws CardServiceException {
        if (!isOpen()) {
            try {
                this.isoDep.connect();
                if (this.isoDep.isConnected()) {
                    this.state = 1;
                    return;
                }
                throw new CardServiceException("Failed to connect");
            } catch (IOException e) {
                LOGGER.log(Level.WARNING, "Failed to connect", e);
                throw new CardServiceException(e.toString());
            }
        }
    }

    public ResponseAPDU transmit(CommandAPDU commandAPDU) throws CardServiceException {
        try {
            if (this.isoDep.isConnected()) {
                byte[] transceive = this.isoDep.transceive(commandAPDU.getBytes());
                if (transceive == null || transceive.length < 2) {
                    throw new CardServiceException("Failed response");
                }
                ResponseAPDU responseAPDU = new ResponseAPDU(transceive);
                int i = this.apduCount + 1;
                this.apduCount = i;
                notifyExchangedAPDU(new APDUEvent(this, "ISODep", i, commandAPDU, responseAPDU));
                return responseAPDU;
            }
            throw new CardServiceException("Not connected");
        } catch (IOException e) {
            throw new CardServiceException(e.getMessage());
        } catch (Exception e2) {
            throw new CardServiceException(e2.getMessage());
        }
    }
}
