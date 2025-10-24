package com.fis.ekyc.nfc.build_in.eidparser.protocol;

import com.fis.ekyc.nfc.build_in.eidparser.APDULevelPACECapable;
import com.fis.ekyc.nfc.build_in.eidparser.Util;
import com.fis.ekyc.nfc.build_in.eidparser.cbeff.ISO781611;
import com.fis.ekyc.nfc.build_in.scuba.smartcards.APDUWrapper;
import com.fis.ekyc.nfc.build_in.scuba.smartcards.CardService;
import com.fis.ekyc.nfc.build_in.scuba.smartcards.CardServiceException;
import com.fis.ekyc.nfc.build_in.scuba.smartcards.CommandAPDU;
import com.fis.ekyc.nfc.build_in.scuba.smartcards.ResponseAPDU;
import com.fis.ekyc.nfc.build_in.scuba.tlv.TLVUtil;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PACEAPDUSender implements APDULevelPACECapable {
    public static final byte CAN_PACE_KEY_REFERENCE = 2;
    private static final byte INS_PACE_GENERAL_AUTHENTICATE = -122;
    private static final Logger LOGGER = Logger.getLogger("com.fis.ekyc.sdk.nfc.build_in..jmrtd.protocol");
    public static final byte MRZ_PACE_KEY_REFERENCE = 1;
    public static final byte NO_PACE_KEY_REFERENCE = 0;
    public static final byte PIN_PACE_KEY_REFERENCE = 3;
    public static final byte PUK_PACE_KEY_REFERENCE = 4;
    private SecureMessagingAPDUSender secureMessagingSender;

    public PACEAPDUSender(CardService cardService) {
        this.secureMessagingSender = new SecureMessagingAPDUSender(cardService);
    }

    public synchronized byte[] sendGeneralAuthenticate(APDUWrapper aPDUWrapper, byte[] bArr, int i, boolean z) throws CardServiceException {
        int i2;
        ResponseAPDU transmit;
        byte[] wrapDO = TLVUtil.wrapDO(124, bArr);
        if (z) {
            i2 = 0;
        } else {
            i2 = 16;
        }
        transmit = this.secureMessagingSender.transmit(aPDUWrapper, new CommandAPDU(i2, -122, 0, 0, wrapDO, i));
        short sw = (short) transmit.getSW();
        if (sw == -28672) {
        } else {
            throw new CardServiceException("Sending general authenticate failed", (int) sw);
        }
        return TLVUtil.unwrapDO(124, transmit.getData());
    }

    public synchronized void sendMSESetATMutualAuth(APDUWrapper aPDUWrapper, String str, int i, byte[] bArr) throws CardServiceException {
        if (str != null) {
            try {
                byte[] oIDBytes = Util.toOIDBytes(str);
                if (!(i == 1 || i == 2 || i == 3)) {
                    if (i != 4) {
                        throw new IllegalArgumentException("Unsupported key type reference (MRZ, CAN, etc), found " + i);
                    }
                }
                byte[] wrapDO = TLVUtil.wrapDO(ISO781611.CREATION_DATE_AND_TIME_TAG, new byte[]{(byte) i});
                if (bArr != null) {
                    bArr = TLVUtil.wrapDO(132, bArr);
                }
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byteArrayOutputStream.write(oIDBytes);
                byteArrayOutputStream.write(wrapDO);
                if (bArr != null) {
                    byteArrayOutputStream.write(bArr);
                }
                short sw = (short) this.secureMessagingSender.transmit(aPDUWrapper, new CommandAPDU(0, 34, 193, 164, byteArrayOutputStream.toByteArray())).getSW();
                if (sw != -28672) {
                    throw new CardServiceException("Sending MSE AT failed", (int) sw);
                }
            } catch (IOException e) {
                LOGGER.log(Level.WARNING, "Error while copying data", e);
                throw new IllegalStateException("Error while copying data");
            } catch (Throwable th) {
                throw th;
            }
        } else {
            throw new IllegalArgumentException("OID cannot be null");
        }
    }
}
