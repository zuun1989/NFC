package com.fis.ekyc.nfc.build_in.eidparser.protocol;

import com.fis.ekyc.nfc.build_in.eidparser.APDULevelReadBinaryCapable;
import com.fis.ekyc.nfc.build_in.eidparser.IdCardService;
import com.fis.ekyc.nfc.build_in.scuba.smartcards.APDUWrapper;
import com.fis.ekyc.nfc.build_in.scuba.smartcards.CardService;
import com.fis.ekyc.nfc.build_in.scuba.smartcards.CardServiceException;
import com.fis.ekyc.nfc.build_in.scuba.smartcards.CommandAPDU;
import com.fis.ekyc.nfc.build_in.scuba.smartcards.ISO7816;
import com.fis.ekyc.nfc.build_in.scuba.smartcards.ISOFileInfo;
import com.fis.ekyc.nfc.build_in.scuba.smartcards.ResponseAPDU;
import com.fis.ekyc.nfc.build_in.scuba.util.Hex;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReadBinaryAPDUSender implements APDULevelReadBinaryCapable {
    private static final Logger LOGGER = Logger.getLogger("com.fis.ekyc.sdk.nfc.build_in..jmrtd.protocol");
    private SecureMessagingAPDUSender secureMessagingSender;
    private CardService service;

    public ReadBinaryAPDUSender(CardService cardService) {
        this.service = cardService;
        this.secureMessagingSender = new SecureMessagingAPDUSender(cardService);
    }

    private static void checkStatusWordAfterFileOperation(CommandAPDU commandAPDU, ResponseAPDU responseAPDU) throws CardServiceException {
        if (responseAPDU != null) {
            byte[] data = responseAPDU.getData();
            short sw = (short) responseAPDU.getSW();
            String str = "CAPDU = " + Hex.bytesToHexString(commandAPDU.getBytes()) + ", RAPDU = " + Hex.bytesToHexString(responseAPDU.getBytes());
            if ((sw & ISO7816.SW_WRONG_LENGTH) == 26368 && (data == null || data.length == 0)) {
                throw new CardServiceException("Wrong length, " + str, (int) sw);
            } else if (sw == -28672) {
            } else {
                if (sw != 25218) {
                    if (sw != 27010) {
                        if (sw == 27266) {
                            throw new CardServiceException("File not found, " + str, (int) sw);
                        } else if (!(sw == 27013 || sw == 27014)) {
                            throw new CardServiceException("Error occured, " + str, (int) sw);
                        }
                    }
                    throw new CardServiceException("Access to file denied, " + str, (int) sw);
                } else if (data == null || data.length == 0) {
                    throw new CardServiceException("End of file, " + str, (int) sw);
                }
            }
        } else {
            throw new CardServiceException("No response APDU");
        }
    }

    private static byte[] getResponseData(ResponseAPDU responseAPDU, boolean z) throws CardServiceException {
        int i;
        if (responseAPDU == null) {
            return null;
        }
        byte[] data = responseAPDU.getData();
        if (data == null) {
            throw new CardServiceException("Malformed read binary long response data");
        } else if (!z) {
            return data;
        } else {
            if (data[0] == 83) {
                byte b = data[1];
                if (((byte) (b & ISOFileInfo.DATA_BYTES1)) == Byte.MIN_VALUE) {
                    i = (b & IdCardService.SFI_DG15) + 1;
                } else {
                    i = 1;
                }
                int i2 = i + 1;
                int length = data.length - i2;
                byte[] bArr = new byte[length];
                System.arraycopy(data, i2, bArr, 0, length);
                return bArr;
            }
            throw new CardServiceException("Malformed read binary long response data");
        }
    }

    public synchronized byte[] sendReadBinary(APDUWrapper aPDUWrapper, int i, int i2, int i3, boolean z, boolean z2) throws CardServiceException {
        CommandAPDU commandAPDU;
        int i4;
        CommandAPDU commandAPDU2;
        int i5;
        int i6 = i2;
        int i7 = i3;
        boolean z3 = z2;
        synchronized (this) {
            ResponseAPDU responseAPDU = null;
            if (i7 == 0) {
                return null;
            }
            byte b = (byte) ((65280 & i6) >> 8);
            byte b2 = (byte) (i6 & 255);
            if (z3) {
                if (i7 < 128) {
                    i5 = i7 + 2;
                } else if (i7 < 256) {
                    i5 = i7 + 3;
                } else {
                    i5 = i7;
                }
                if (i5 > 256) {
                    i5 = 256;
                }
                try {
                    commandAPDU = new CommandAPDU(0, -79, 0, 0, new byte[]{84, 2, b, b2}, i5);
                    i7 = i5;
                } catch (CardServiceException e) {
                    if (!this.service.isConnectionLost(e)) {
                        LOGGER.log(Level.FINE, "Exception during READ BINARY", e);
                        i4 = e.getSW();
                    } else {
                        throw e;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            } else {
                if (z) {
                    commandAPDU2 = new CommandAPDU(0, -80, (int) (byte) i, (int) b2, i3);
                } else {
                    commandAPDU2 = new CommandAPDU(0, -80, (int) b, (int) b2, i3);
                }
                commandAPDU = commandAPDU2;
            }
            responseAPDU = this.secureMessagingSender.transmit(aPDUWrapper, commandAPDU);
            i4 = responseAPDU.getSW();
            short s = (short) i4;
            byte[] responseData = getResponseData(responseAPDU, z3);
            if (responseData == null || responseData.length == 0) {
                LOGGER.warning("Empty response data: response APDU bytes = " + Arrays.toString(responseData) + ", le = " + i7 + ", sw = " + Integer.toHexString(s));
            }
            checkStatusWordAfterFileOperation(commandAPDU, responseAPDU);
            return responseData;
        }
    }

    public synchronized void sendSelectApplet(APDUWrapper aPDUWrapper, byte[] bArr) throws CardServiceException {
        if (bArr != null) {
            CommandAPDU commandAPDU = new CommandAPDU(0, -92, 4, 12, bArr);
            checkStatusWordAfterFileOperation(commandAPDU, this.secureMessagingSender.transmit(aPDUWrapper, commandAPDU));
        } else {
            throw new IllegalArgumentException("AID cannot be null");
        }
    }

    public synchronized void sendSelectFile(APDUWrapper aPDUWrapper, short s) throws CardServiceException {
        CommandAPDU commandAPDU = new CommandAPDU(0, -92, 2, 12, new byte[]{(byte) ((s >> 8) & 255), (byte) (s & 255)}, 0);
        ResponseAPDU transmit = this.secureMessagingSender.transmit(aPDUWrapper, commandAPDU);
        if (transmit != null) {
            checkStatusWordAfterFileOperation(commandAPDU, transmit);
        }
    }

    public synchronized void sendSelectMF() throws CardServiceException {
        CommandAPDU commandAPDU = new CommandAPDU(0, -92, 0, 12, new byte[]{63, 0});
        checkStatusWordAfterFileOperation(commandAPDU, this.secureMessagingSender.transmit((APDUWrapper) null, commandAPDU));
    }
}
