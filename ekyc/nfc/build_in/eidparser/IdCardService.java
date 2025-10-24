package com.fis.ekyc.nfc.build_in.eidparser;

import com.fis.ekyc.nfc.build_in.eidparser.cert.CVCPrincipal;
import com.fis.ekyc.nfc.build_in.eidparser.cert.CardVerifiableCertificate;
import com.fis.ekyc.nfc.build_in.eidparser.protocol.AAAPDUSender;
import com.fis.ekyc.nfc.build_in.eidparser.protocol.AAProtocol;
import com.fis.ekyc.nfc.build_in.eidparser.protocol.AAResult;
import com.fis.ekyc.nfc.build_in.eidparser.protocol.BACAPDUSender;
import com.fis.ekyc.nfc.build_in.eidparser.protocol.BACProtocol;
import com.fis.ekyc.nfc.build_in.eidparser.protocol.BACResult;
import com.fis.ekyc.nfc.build_in.eidparser.protocol.EACCAAPDUSender;
import com.fis.ekyc.nfc.build_in.eidparser.protocol.EACCAProtocol;
import com.fis.ekyc.nfc.build_in.eidparser.protocol.EACCAResult;
import com.fis.ekyc.nfc.build_in.eidparser.protocol.EACTAAPDUSender;
import com.fis.ekyc.nfc.build_in.eidparser.protocol.EACTAProtocol;
import com.fis.ekyc.nfc.build_in.eidparser.protocol.EACTAResult;
import com.fis.ekyc.nfc.build_in.eidparser.protocol.PACEAPDUSender;
import com.fis.ekyc.nfc.build_in.eidparser.protocol.PACEProtocol;
import com.fis.ekyc.nfc.build_in.eidparser.protocol.PACEResult;
import com.fis.ekyc.nfc.build_in.eidparser.protocol.ReadBinaryAPDUSender;
import com.fis.ekyc.nfc.build_in.eidparser.protocol.SecureMessagingWrapper;
import com.fis.ekyc.nfc.build_in.scuba.smartcards.APDUEvent;
import com.fis.ekyc.nfc.build_in.scuba.smartcards.APDUListener;
import com.fis.ekyc.nfc.build_in.scuba.smartcards.APDUWrapper;
import com.fis.ekyc.nfc.build_in.scuba.smartcards.CardFileInputStream;
import com.fis.ekyc.nfc.build_in.scuba.smartcards.CardService;
import com.fis.ekyc.nfc.build_in.scuba.smartcards.CardServiceException;
import com.fis.ekyc.nfc.build_in.scuba.smartcards.CommandAPDU;
import com.fis.ekyc.nfc.build_in.scuba.smartcards.ISOFileInfo;
import com.fis.ekyc.nfc.build_in.scuba.smartcards.ResponseAPDU;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Collection;
import java.util.List;
import java.util.logging.Logger;
import javax.crypto.SecretKey;

public class IdCardService extends AbstractMRTDCardService {
    protected static final byte[] APPLET_AID = {ISOFileInfo.A0, 0, 0, 2, 71, 16, 1};
    public static final byte CAN_PACE_KEY_REFERENCE = 2;
    public static final int DEFAULT_MAX_BLOCKSIZE = 223;
    public static final short EF_CARD_ACCESS = 284;
    public static final short EF_CARD_SECURITY = 285;
    public static final short EF_COM = 286;
    public static final short EF_CVCA = 284;
    public static final short EF_DG1 = 257;
    public static final short EF_DG10 = 266;
    public static final short EF_DG11 = 267;
    public static final short EF_DG12 = 268;
    public static final short EF_DG13 = 269;
    public static final short EF_DG14 = 270;
    public static final short EF_DG15 = 271;
    public static final short EF_DG16 = 272;
    public static final short EF_DG2 = 258;
    public static final short EF_DG3 = 259;
    public static final short EF_DG4 = 260;
    public static final short EF_DG5 = 261;
    public static final short EF_DG6 = 262;
    public static final short EF_DG7 = 263;
    public static final short EF_DG8 = 264;
    public static final short EF_DG9 = 265;
    public static final short EF_SOD = 285;
    public static final int EXTENDED_MAX_TRANCEIVE_LENGTH = 65536;
    private static final Logger LOGGER = Logger.getLogger("com.htc.sdk.jmrtd");
    public static final byte MRZ_PACE_KEY_REFERENCE = 1;
    public static final int NORMAL_MAX_TRANCEIVE_LENGTH = 256;
    public static final byte NO_PACE_KEY_REFERENCE = 0;
    public static final byte PIN_PACE_KEY_REFERENCE = 3;
    public static final byte PUK_PACE_KEY_REFERENCE = 4;
    public static final byte SFI_CARD_ACCESS = 28;
    public static final byte SFI_CARD_SECURITY = 29;
    public static final byte SFI_COM = 30;
    public static final byte SFI_CVCA = 28;
    public static final byte SFI_DG1 = 1;
    public static final byte SFI_DG10 = 10;
    public static final byte SFI_DG11 = 11;
    public static final byte SFI_DG12 = 12;
    public static final byte SFI_DG13 = 13;
    public static final byte SFI_DG14 = 14;
    public static final byte SFI_DG15 = 15;
    public static final byte SFI_DG16 = 16;
    public static final byte SFI_DG2 = 2;
    public static final byte SFI_DG3 = 3;
    public static final byte SFI_DG4 = 4;
    public static final byte SFI_DG5 = 5;
    public static final byte SFI_DG6 = 6;
    public static final byte SFI_DG7 = 7;
    public static final byte SFI_DG8 = 8;
    public static final byte SFI_DG9 = 9;
    public static final byte SFI_SOD = 29;
    private final AAAPDUSender aaSender;
    private final DefaultFileSystem appletFileSystem;
    private final BACAPDUSender bacSender;
    private final EACCAAPDUSender eacCASender;
    private final EACTAAPDUSender eacTASender;
    private boolean isAppletSelected;
    private boolean isOpen;
    private final int maxBlockSize;
    private final int maxTranceiveLengthForPACEProtocol;
    private final int maxTranceiveLengthForSecureMessaging;
    private final PACEAPDUSender paceSender;
    private final ReadBinaryAPDUSender readBinarySender;
    private final DefaultFileSystem rootFileSystem;
    private final CardService service;
    private final boolean shouldCheckMAC;
    private SecureMessagingWrapper wrapper;

    public IdCardService(CardService cardService, int i, int i2, boolean z, boolean z2) {
        this(cardService, 256, i, i2, z, z2);
    }

    public void addAPDUListener(APDUListener aPDUListener) {
        this.service.addAPDUListener(aPDUListener);
    }

    public void close() {
        try {
            this.service.close();
            this.wrapper = null;
        } finally {
            this.isOpen = false;
        }
    }

    public AAResult doAA(PublicKey publicKey, String str, String str2, byte[] bArr) throws CardServiceException {
        return new AAProtocol(this.aaSender, getWrapper()).doAA(publicKey, str, str2, bArr);
    }

    public synchronized BACResult doBAC(SecretKey secretKey, SecretKey secretKey2) throws CardServiceException, GeneralSecurityException {
        BACResult doBAC;
        doBAC = new BACProtocol(this.bacSender, this.maxTranceiveLengthForSecureMessaging, this.shouldCheckMAC).doBAC(secretKey, secretKey2);
        SecureMessagingWrapper wrapper2 = doBAC.getWrapper();
        this.wrapper = wrapper2;
        this.appletFileSystem.setWrapper(wrapper2);
        return doBAC;
    }

    public synchronized EACCAResult doEACCA(BigInteger bigInteger, String str, String str2, PublicKey publicKey) throws CardServiceException {
        EACCAResult doCA;
        doCA = new EACCAProtocol(this.eacCASender, getWrapper(), this.maxTranceiveLengthForSecureMessaging, this.shouldCheckMAC).doCA(bigInteger, str, str2, publicKey);
        SecureMessagingWrapper wrapper2 = doCA.getWrapper();
        this.wrapper = wrapper2;
        this.appletFileSystem.setWrapper(wrapper2);
        return doCA;
    }

    public synchronized EACTAResult doEACTA(CVCPrincipal cVCPrincipal, List<CardVerifiableCertificate> list, PrivateKey privateKey, String str, EACCAResult eACCAResult, String str2) throws CardServiceException {
        return new EACTAProtocol(this.eacTASender, getWrapper()).doEACTA(cVCPrincipal, list, privateKey, str, eACCAResult, str2);
    }

    public synchronized PACEResult doPACE(AccessKeySpec accessKeySpec, String str, AlgorithmParameterSpec algorithmParameterSpec, BigInteger bigInteger) throws CardServiceException {
        PACEResult doPACE;
        doPACE = new PACEProtocol(this.paceSender, this.wrapper, this.maxTranceiveLengthForPACEProtocol, this.maxTranceiveLengthForSecureMessaging, this.shouldCheckMAC).doPACE(accessKeySpec, str, algorithmParameterSpec, bigInteger);
        SecureMessagingWrapper wrapper2 = doPACE.getWrapper();
        this.wrapper = wrapper2;
        this.appletFileSystem.setWrapper(wrapper2);
        return doPACE;
    }

    public Collection<APDUListener> getAPDUListeners() {
        return this.service.getAPDUListeners();
    }

    public byte[] getATR() throws CardServiceException {
        return this.service.getATR();
    }

    @Deprecated
    public synchronized CardFileInputStream getInputStream(short s) throws CardServiceException {
        return getInputStream(s, this.maxBlockSize);
    }

    public int getMaxReadBinaryLength() {
        DefaultFileSystem defaultFileSystem = this.appletFileSystem;
        if (defaultFileSystem == null) {
            return 256;
        }
        return defaultFileSystem.getMaxReadBinaryLength();
    }

    public int getMaxTranceiveLength() {
        return this.maxTranceiveLengthForSecureMessaging;
    }

    public SecureMessagingWrapper getWrapper() {
        SecureMessagingWrapper secureMessagingWrapper = (SecureMessagingWrapper) this.appletFileSystem.getWrapper();
        if (secureMessagingWrapper != null && secureMessagingWrapper.getSendSequenceCounter() > this.wrapper.getSendSequenceCounter()) {
            this.wrapper = secureMessagingWrapper;
        }
        return this.wrapper;
    }

    public boolean isConnectionLost(Exception exc) {
        return this.service.isConnectionLost(exc);
    }

    public boolean isOpen() {
        return this.isOpen;
    }

    public void notifyExchangedAPDU(APDUEvent aPDUEvent) {
        Collection<APDUListener> aPDUListeners = getAPDUListeners();
        if (aPDUListeners != null && !aPDUListeners.isEmpty()) {
            for (APDUListener exchangedAPDU : aPDUListeners) {
                exchangedAPDU.exchangedAPDU(aPDUEvent);
            }
        }
    }

    public void open() throws CardServiceException {
        if (!isOpen()) {
            synchronized (this) {
                this.service.open();
                this.isOpen = true;
            }
        }
    }

    public void removeAPDUListener(APDUListener aPDUListener) {
        this.service.removeAPDUListener(aPDUListener);
    }

    public void sendSelectApplet(boolean z) throws CardServiceException {
        if (this.isAppletSelected) {
            LOGGER.info("Re-selecting ICAO applet");
        }
        if (z) {
            this.readBinarySender.sendSelectApplet(this.wrapper, APPLET_AID);
        } else {
            this.readBinarySender.sendSelectApplet((APDUWrapper) null, APPLET_AID);
        }
        this.isAppletSelected = true;
    }

    public void sendSelectMF() throws CardServiceException {
        this.readBinarySender.sendSelectMF();
        this.wrapper = null;
    }

    public boolean shouldCheckMAC() {
        return this.shouldCheckMAC;
    }

    public ResponseAPDU transmit(CommandAPDU commandAPDU) throws CardServiceException {
        return this.service.transmit(commandAPDU);
    }

    public IdCardService(CardService cardService, int i, int i2, int i3, boolean z, boolean z2) {
        this.service = cardService;
        this.bacSender = new BACAPDUSender(cardService);
        this.paceSender = new PACEAPDUSender(cardService);
        this.aaSender = new AAAPDUSender(cardService);
        this.eacCASender = new EACCAAPDUSender(cardService);
        this.eacTASender = new EACTAAPDUSender(cardService);
        ReadBinaryAPDUSender readBinaryAPDUSender = new ReadBinaryAPDUSender(cardService);
        this.readBinarySender = readBinaryAPDUSender;
        this.maxTranceiveLengthForPACEProtocol = i;
        this.maxTranceiveLengthForSecureMessaging = i2;
        this.maxBlockSize = i3;
        this.shouldCheckMAC = z2;
        this.isAppletSelected = false;
        this.isOpen = false;
        this.rootFileSystem = new DefaultFileSystem(readBinaryAPDUSender, false);
        this.appletFileSystem = new DefaultFileSystem(readBinaryAPDUSender, z);
    }

    public synchronized EACTAResult doEACTA(CVCPrincipal cVCPrincipal, List<CardVerifiableCertificate> list, PrivateKey privateKey, String str, EACCAResult eACCAResult, PACEResult pACEResult) throws CardServiceException {
        return new EACTAProtocol(this.eacTASender, getWrapper()).doTA(cVCPrincipal, list, privateKey, str, eACCAResult, pACEResult);
    }

    public synchronized CardFileInputStream getInputStream(short s, int i) throws CardServiceException {
        CardFileInputStream cardFileInputStream;
        CardFileInputStream cardFileInputStream2;
        try {
            if (!this.isAppletSelected) {
                synchronized (this.rootFileSystem) {
                    this.rootFileSystem.selectFile(s);
                    cardFileInputStream2 = new CardFileInputStream(i, this.rootFileSystem);
                }
                return cardFileInputStream2;
            }
            synchronized (this.appletFileSystem) {
                this.appletFileSystem.selectFile(s);
                cardFileInputStream = new CardFileInputStream(i, this.appletFileSystem);
            }
            return cardFileInputStream;
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized BACResult doBAC(AccessKeySpec accessKeySpec) throws CardServiceException {
        BACResult doBAC;
        if (accessKeySpec instanceof BACKeySpec) {
            doBAC = new BACProtocol(this.bacSender, this.maxTranceiveLengthForSecureMessaging, this.shouldCheckMAC).doBAC(accessKeySpec);
            SecureMessagingWrapper wrapper2 = doBAC.getWrapper();
            this.wrapper = wrapper2;
            this.appletFileSystem.setWrapper(wrapper2);
        } else {
            throw new IllegalArgumentException("Unsupported key type");
        }
        return doBAC;
    }
}
