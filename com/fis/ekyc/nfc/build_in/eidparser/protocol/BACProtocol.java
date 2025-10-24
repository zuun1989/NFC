package com.fis.ekyc.nfc.build_in.eidparser.protocol;

import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.jcajce.spec.McElieceCCA2KeyGenParameterSpec;
import com.fis.ekyc.nfc.build_in.eidparser.APDULevelBACCapable;
import com.fis.ekyc.nfc.build_in.eidparser.AccessKeySpec;
import com.fis.ekyc.nfc.build_in.eidparser.BACKeySpec;
import com.fis.ekyc.nfc.build_in.eidparser.CardServiceProtocolException;
import com.fis.ekyc.nfc.build_in.eidparser.Util;
import com.fis.ekyc.nfc.build_in.mrz.MrzParser;
import com.fis.ekyc.nfc.build_in.scuba.smartcards.CardServiceException;
import java.security.GeneralSecurityException;
import java.security.SecureRandom;
import java.util.Random;
import javax.crypto.SecretKey;

public class BACProtocol {
    private int maxTranceiveLength;
    private Random random = new SecureRandom();
    private APDULevelBACCapable service;
    private boolean shouldCheckMAC;

    public BACProtocol(APDULevelBACCapable aPDULevelBACCapable, int i, boolean z) {
        this.service = aPDULevelBACCapable;
        this.maxTranceiveLength = i;
        this.shouldCheckMAC = z;
    }

    public static byte[] computeKeySeedForBAC(BACKeySpec bACKeySpec) throws GeneralSecurityException {
        String documentNumber = bACKeySpec.getDocumentNumber();
        String dateOfBirth = bACKeySpec.getDateOfBirth();
        String dateOfExpiry = bACKeySpec.getDateOfExpiry();
        if (dateOfBirth == null || dateOfBirth.length() != 6) {
            throw new IllegalArgumentException("Wrong date format used for date of birth. Expected yyMMdd, found " + dateOfBirth);
        } else if (dateOfExpiry == null || dateOfExpiry.length() != 6) {
            throw new IllegalArgumentException("Wrong date format used for date of expiry. Expected yyMMdd, found " + dateOfExpiry);
        } else if (documentNumber != null) {
            return computeKeySeedForBAC(fixDocumentNumber(documentNumber), dateOfBirth, dateOfExpiry);
        } else {
            throw new IllegalArgumentException("Wrong document number. Found " + documentNumber);
        }
    }

    public static long computeSendSequenceCounter(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr.length != 8 || bArr2 == null || bArr2.length != 8) {
            throw new IllegalStateException("Wrong length input");
        }
        long j = 0;
        for (int i = 4; i < 8; i++) {
            j = (j << 8) + ((long) (bArr[i] & 255));
        }
        for (int i2 = 4; i2 < 8; i2++) {
            j = (j << 8) + ((long) (bArr2[i2] & 255));
        }
        return j;
    }

    private SecureMessagingWrapper doBACStep(SecretKey secretKey, SecretKey secretKey2) throws CardServiceException, GeneralSecurityException {
        try {
            byte[] sendGetChallenge = this.service.sendGetChallenge();
            byte[] bArr = new byte[8];
            this.random.nextBytes(bArr);
            byte[] bArr2 = new byte[16];
            this.random.nextBytes(bArr2);
            try {
                byte[] bArr3 = new byte[16];
                System.arraycopy(this.service.sendMutualAuth(bArr, sendGetChallenge, bArr2, secretKey, secretKey2), 16, bArr3, 0, 16);
                byte[] bArr4 = new byte[16];
                for (int i = 0; i < 16; i++) {
                    bArr4[i] = (byte) ((bArr2[i] & 255) ^ (bArr3[i] & 255));
                }
                SecretKey deriveKey = Util.deriveKey(bArr4, 1);
                SecretKey deriveKey2 = Util.deriveKey(bArr4, 2);
                long computeSendSequenceCounter = computeSendSequenceCounter(sendGetChallenge, bArr);
                return new DESedeSecureMessagingWrapper(deriveKey, deriveKey2, this.maxTranceiveLength, this.shouldCheckMAC, computeSendSequenceCounter);
            } catch (Exception e) {
                throw new CardServiceProtocolException("BAC failed in MUTUAL AUTH", 2, (Throwable) e);
            }
        } catch (Exception e2) {
            throw new CardServiceProtocolException("BAC failed in GET CHALLENGE", 1, (Throwable) e2);
        }
    }

    private static String fixDocumentNumber(String str) {
        String str2;
        if (str == null) {
            str2 = "";
        } else {
            str2 = str.replace(MrzParser.FILLER, ' ').trim().replace(' ', MrzParser.FILLER);
        }
        StringBuilder sb2 = new StringBuilder(str2);
        while (sb2.length() < 9) {
            sb2.append(MrzParser.FILLER);
        }
        return sb2.toString();
    }

    public BACResult doBAC(AccessKeySpec accessKeySpec) throws CardServiceException {
        try {
            byte[] key = accessKeySpec.getKey();
            return new BACResult(accessKeySpec, doBACStep(Util.deriveKey(key, 1), Util.deriveKey(key, 2)));
        } catch (GeneralSecurityException e) {
            throw new CardServiceException("Error during BAC", (Throwable) e);
        }
    }

    public BACResult doBAC(SecretKey secretKey, SecretKey secretKey2) throws CardServiceException, GeneralSecurityException {
        return new BACResult(doBACStep(secretKey, secretKey2));
    }

    private static byte[] computeKeySeedForBAC(String str, String str2, String str3) throws GeneralSecurityException {
        return Util.computeKeySeed(str, str2, str3, McElieceCCA2KeyGenParameterSpec.SHA1, true);
    }
}
