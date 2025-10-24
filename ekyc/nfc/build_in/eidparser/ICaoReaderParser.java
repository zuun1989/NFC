package com.fis.ekyc.nfc.build_in.eidparser;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;
import androidx.lifecycle.u;
import com.fis.ekyc.nfc.build_in.eidparser.lds.ChipAuthenticationPublicKeyInfo;
import com.fis.ekyc.nfc.build_in.eidparser.lds.SODFile;
import com.fis.ekyc.nfc.build_in.eidparser.lds.SecurityInfo;
import com.fis.ekyc.nfc.build_in.eidparser.lds.icao.DG14File;
import com.fis.ekyc.nfc.build_in.eidparser.lds.icao.DG15File;
import com.fis.ekyc.nfc.build_in.model.CardResult;
import com.fis.ekyc.nfc.build_in.model.CheckingCode;
import com.fis.ekyc.nfc.build_in.model.ResultCode;
import com.fis.ekyc.nfc.build_in.scuba.smartcards.CardService;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.PublicKey;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;

public class ICaoReaderParser {
    private static final String TAG = "ICaoReaderParser";
    String BAC = "BAC";
    String PACE = "PACE";
    private CardService _card = null;
    private String _cccdId = "";
    private DG15File _dgPublicKeyFile = null;
    private DG14File _dgSecurityInfoFile = null;
    private CardResult _result = null;
    private IdCardService _service = null;
    private SODFile _sodFile = null;
    private Activity activity;
    private String birthDate = "";
    private String expiredDate = "";
    private IDCardDetail personalData = null;
    private u processLiveData;

    /* JADX WARNING: Removed duplicated region for block: B:25:0x00aa A[Catch:{ CardServiceException -> 0x0030, NoSuchAlgorithmException -> 0x002d }] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00cc A[Catch:{ CardServiceException -> 0x0030, NoSuchAlgorithmException -> 0x002d }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.fis.ekyc.nfc.build_in.model.ResultCode activeAuthentication() {
        /*
            r9 = this;
            long r0 = r9.getCurrent()
            java.lang.String r2 = TAG     // Catch:{ CardServiceException -> 0x0030, NoSuchAlgorithmException -> 0x002d }
            java.lang.String r3 = "Start Active Authentication..."
            android.util.Log.d(r2, r3)     // Catch:{ CardServiceException -> 0x0030, NoSuchAlgorithmException -> 0x002d }
            com.fis.ekyc.nfc.build_in.eidparser.lds.icao.DG15File r2 = r9._dgPublicKeyFile     // Catch:{ CardServiceException -> 0x0030, NoSuchAlgorithmException -> 0x002d }
            java.security.PublicKey r4 = r2.getPublicKey()     // Catch:{ CardServiceException -> 0x0030, NoSuchAlgorithmException -> 0x002d }
            java.lang.String r2 = r4.getAlgorithm()     // Catch:{ CardServiceException -> 0x0030, NoSuchAlgorithmException -> 0x002d }
            java.lang.String r3 = "SHA1"
            java.lang.String r5 = "SHA1WithRSA/ISO9796-2"
            java.lang.String r6 = "EC"
            boolean r6 = r6.equals(r2)     // Catch:{ CardServiceException -> 0x0030, NoSuchAlgorithmException -> 0x002d }
            if (r6 != 0) goto L_0x0033
            java.lang.String r6 = "ECDSA"
            boolean r2 = r6.equals(r2)     // Catch:{ CardServiceException -> 0x0030, NoSuchAlgorithmException -> 0x002d }
            if (r2 == 0) goto L_0x002a
            goto L_0x0033
        L_0x002a:
            r6 = r5
        L_0x002b:
            r5 = r3
            goto L_0x007c
        L_0x002d:
            r0 = move-exception
            goto L_0x00f2
        L_0x0030:
            r0 = move-exception
            goto L_0x00f2
        L_0x0033:
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ CardServiceException -> 0x0030, NoSuchAlgorithmException -> 0x002d }
            r2.<init>()     // Catch:{ CardServiceException -> 0x0030, NoSuchAlgorithmException -> 0x002d }
            com.fis.ekyc.nfc.build_in.eidparser.lds.icao.DG14File r3 = r9._dgSecurityInfoFile     // Catch:{ CardServiceException -> 0x0030, NoSuchAlgorithmException -> 0x002d }
            java.util.Collection r3 = r3.getSecurityInfos()     // Catch:{ CardServiceException -> 0x0030, NoSuchAlgorithmException -> 0x002d }
            java.util.Iterator r3 = r3.iterator()     // Catch:{ CardServiceException -> 0x0030, NoSuchAlgorithmException -> 0x002d }
        L_0x0042:
            boolean r5 = r3.hasNext()     // Catch:{ CardServiceException -> 0x0030, NoSuchAlgorithmException -> 0x002d }
            if (r5 != 0) goto L_0x00e1
            int r3 = r2.size()     // Catch:{ CardServiceException -> 0x0030, NoSuchAlgorithmException -> 0x002d }
            r5 = 1
            if (r3 >= r5) goto L_0x005e
            java.lang.String r0 = TAG     // Catch:{ CardServiceException -> 0x0030, NoSuchAlgorithmException -> 0x002d }
            java.lang.String r1 = "Not found active authentication info in EF.DG14"
            android.util.Log.e(r0, r1)     // Catch:{ CardServiceException -> 0x0030, NoSuchAlgorithmException -> 0x002d }
            com.fis.ekyc.nfc.build_in.model.CardResult r0 = r9._result     // Catch:{ CardServiceException -> 0x0030, NoSuchAlgorithmException -> 0x002d }
            com.fis.ekyc.nfc.build_in.model.ResultCode r1 = com.fis.ekyc.nfc.build_in.model.ResultCode.SUCCESS_WITH_WARNING     // Catch:{ CardServiceException -> 0x0030, NoSuchAlgorithmException -> 0x002d }
            r0.setCode(r1)     // Catch:{ CardServiceException -> 0x0030, NoSuchAlgorithmException -> 0x002d }
            return r1
        L_0x005e:
            if (r3 <= r5) goto L_0x0067
            java.lang.String r3 = TAG     // Catch:{ CardServiceException -> 0x0030, NoSuchAlgorithmException -> 0x002d }
            java.lang.String r5 = "Found activeAuthenticationInfoCount in EF.DG14, expected 1."
            android.util.Log.d(r3, r5)     // Catch:{ CardServiceException -> 0x0030, NoSuchAlgorithmException -> 0x002d }
        L_0x0067:
            r3 = 0
            java.lang.Object r2 = r2.get(r3)     // Catch:{ CardServiceException -> 0x0030, NoSuchAlgorithmException -> 0x002d }
            com.fis.ekyc.nfc.build_in.eidparser.lds.ActiveAuthenticationInfo r2 = (com.fis.ekyc.nfc.build_in.eidparser.lds.ActiveAuthenticationInfo) r2     // Catch:{ CardServiceException -> 0x0030, NoSuchAlgorithmException -> 0x002d }
            java.lang.String r2 = r2.getSignatureAlgorithmOID()     // Catch:{ CardServiceException -> 0x0030, NoSuchAlgorithmException -> 0x002d }
            java.lang.String r2 = com.fis.ekyc.nfc.build_in.eidparser.lds.ActiveAuthenticationInfo.lookupMnemonicByOID(r2)     // Catch:{ CardServiceException -> 0x0030, NoSuchAlgorithmException -> 0x002d }
            java.lang.String r3 = com.fis.ekyc.nfc.build_in.eidparser.Util.inferDigestAlgorithmFromSignatureAlgorithm(r2)     // Catch:{ CardServiceException -> 0x0030, NoSuchAlgorithmException -> 0x002d }
            r6 = r2
            goto L_0x002b
        L_0x007c:
            r2 = 8
            byte[] r7 = new byte[r2]     // Catch:{ CardServiceException -> 0x0030, NoSuchAlgorithmException -> 0x002d }
            java.security.SecureRandom r2 = new java.security.SecureRandom     // Catch:{ CardServiceException -> 0x0030, NoSuchAlgorithmException -> 0x002d }
            r2.<init>()     // Catch:{ CardServiceException -> 0x0030, NoSuchAlgorithmException -> 0x002d }
            r2.nextBytes(r7)     // Catch:{ CardServiceException -> 0x0030, NoSuchAlgorithmException -> 0x002d }
            com.fis.ekyc.nfc.build_in.eidparser.IdCardService r2 = r9._service     // Catch:{ CardServiceException -> 0x0030, NoSuchAlgorithmException -> 0x002d }
            com.fis.ekyc.nfc.build_in.eidparser.lds.SODFile r3 = r9._sodFile     // Catch:{ CardServiceException -> 0x0030, NoSuchAlgorithmException -> 0x002d }
            java.lang.String r3 = r3.getDigestAlgorithm()     // Catch:{ CardServiceException -> 0x0030, NoSuchAlgorithmException -> 0x002d }
            com.fis.ekyc.nfc.build_in.eidparser.lds.SODFile r8 = r9._sodFile     // Catch:{ CardServiceException -> 0x0030, NoSuchAlgorithmException -> 0x002d }
            java.lang.String r8 = r8.getSignerInfoDigestAlgorithm()     // Catch:{ CardServiceException -> 0x0030, NoSuchAlgorithmException -> 0x002d }
            com.fis.ekyc.nfc.build_in.eidparser.protocol.AAResult r2 = r2.doAA(r4, r3, r8, r7)     // Catch:{ CardServiceException -> 0x0030, NoSuchAlgorithmException -> 0x002d }
            com.fis.ekyc.nfc.build_in.model.CardResult r3 = r9._result     // Catch:{ CardServiceException -> 0x0030, NoSuchAlgorithmException -> 0x002d }
            r3.setAaResult(r2)     // Catch:{ CardServiceException -> 0x0030, NoSuchAlgorithmException -> 0x002d }
            byte[] r8 = r2.getResponse()     // Catch:{ CardServiceException -> 0x0030, NoSuchAlgorithmException -> 0x002d }
            r3 = r9
            boolean r2 = r3.verifyAA(r4, r5, r6, r7, r8)     // Catch:{ CardServiceException -> 0x0030, NoSuchAlgorithmException -> 0x002d }
            if (r2 == 0) goto L_0x00cc
            androidx.lifecycle.u r2 = r9.processLiveData     // Catch:{ CardServiceException -> 0x0030, NoSuchAlgorithmException -> 0x002d }
            java.lang.String r3 = "Active Authentication: %s millis"
            long r4 = r9.getCurrent()     // Catch:{ CardServiceException -> 0x0030, NoSuchAlgorithmException -> 0x002d }
            long r4 = r4 - r0
            java.lang.Long r0 = java.lang.Long.valueOf(r4)     // Catch:{ CardServiceException -> 0x0030, NoSuchAlgorithmException -> 0x002d }
            java.lang.Object[] r0 = new java.lang.Object[]{r0}     // Catch:{ CardServiceException -> 0x0030, NoSuchAlgorithmException -> 0x002d }
            java.lang.String r0 = java.lang.String.format(r3, r0)     // Catch:{ CardServiceException -> 0x0030, NoSuchAlgorithmException -> 0x002d }
            r2.m(r0)     // Catch:{ CardServiceException -> 0x0030, NoSuchAlgorithmException -> 0x002d }
            java.lang.String r0 = TAG     // Catch:{ CardServiceException -> 0x0030, NoSuchAlgorithmException -> 0x002d }
            java.lang.String r1 = "Active Authentication: succeeded"
            android.util.Log.d(r0, r1)     // Catch:{ CardServiceException -> 0x0030, NoSuchAlgorithmException -> 0x002d }
            com.fis.ekyc.nfc.build_in.model.ResultCode r0 = com.fis.ekyc.nfc.build_in.model.ResultCode.SUCCESS     // Catch:{ CardServiceException -> 0x0030, NoSuchAlgorithmException -> 0x002d }
            return r0
        L_0x00cc:
            java.lang.String r0 = TAG     // Catch:{ CardServiceException -> 0x0030, NoSuchAlgorithmException -> 0x002d }
            java.lang.String r1 = "Active Authentication: Failed"
            android.util.Log.d(r0, r1)     // Catch:{ CardServiceException -> 0x0030, NoSuchAlgorithmException -> 0x002d }
            com.fis.ekyc.nfc.build_in.model.CardResult r0 = r9._result
            com.fis.ekyc.nfc.build_in.model.ResultCode r1 = com.fis.ekyc.nfc.build_in.model.ResultCode.SUCCESS_WITH_WARNING
            r0.setCode(r1)
            com.fis.ekyc.nfc.build_in.model.CardResult r0 = r9._result
            com.fis.ekyc.nfc.build_in.model.ResultCode r0 = r0.getCode()
            return r0
        L_0x00e1:
            java.lang.Object r5 = r3.next()     // Catch:{ CardServiceException -> 0x0030, NoSuchAlgorithmException -> 0x002d }
            com.fis.ekyc.nfc.build_in.eidparser.lds.SecurityInfo r5 = (com.fis.ekyc.nfc.build_in.eidparser.lds.SecurityInfo) r5     // Catch:{ CardServiceException -> 0x0030, NoSuchAlgorithmException -> 0x002d }
            boolean r6 = r5 instanceof com.fis.ekyc.nfc.build_in.eidparser.lds.ActiveAuthenticationInfo     // Catch:{ CardServiceException -> 0x0030, NoSuchAlgorithmException -> 0x002d }
            if (r6 == 0) goto L_0x0042
            com.fis.ekyc.nfc.build_in.eidparser.lds.ActiveAuthenticationInfo r5 = (com.fis.ekyc.nfc.build_in.eidparser.lds.ActiveAuthenticationInfo) r5     // Catch:{ CardServiceException -> 0x0030, NoSuchAlgorithmException -> 0x002d }
            r2.add(r5)     // Catch:{ CardServiceException -> 0x0030, NoSuchAlgorithmException -> 0x002d }
            goto L_0x0042
        L_0x00f2:
            java.lang.String r1 = TAG
            java.lang.String r2 = "Error"
            android.util.Log.e(r1, r2, r0)
            com.fis.ekyc.nfc.build_in.model.CardResult r0 = r9._result
            com.fis.ekyc.nfc.build_in.model.ResultCode r1 = com.fis.ekyc.nfc.build_in.model.ResultCode.CARD_LOST_CONNECTION
            r0.setCode(r1)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fis.ekyc.nfc.build_in.eidparser.ICaoReaderParser.activeAuthentication():com.fis.ekyc.nfc.build_in.model.ResultCode");
    }

    private ResultCode chipAuthentication() {
        long current = getCurrent();
        try {
            Log.d(TAG, "Start Chip Authentication...");
            for (SecurityInfo next : this._dgSecurityInfoFile.getSecurityInfos()) {
                if (next instanceof ChipAuthenticationPublicKeyInfo) {
                    ChipAuthenticationPublicKeyInfo chipAuthenticationPublicKeyInfo = (ChipAuthenticationPublicKeyInfo) next;
                    BigInteger keyId = chipAuthenticationPublicKeyInfo.getKeyId();
                    PublicKey subjectPublicKey = chipAuthenticationPublicKeyInfo.getSubjectPublicKey();
                    this._result.setEaccaResult(this._service.doEACCA(keyId, SecurityInfo.ID_CA_ECDH_AES_CBC_CMAC_256, chipAuthenticationPublicKeyInfo.getObjectIdentifier(), subjectPublicKey));
                    this.processLiveData.m(String.format("Chip Authentication: %s millis", new Object[]{Long.valueOf(getCurrent() - current)}));
                    this.personalData.setChipAuth(true);
                    return ResultCode.SUCCESS;
                }
            }
            System.out.println("Chip Authentication: Failed");
            CardResult cardResult = this._result;
            ResultCode resultCode = ResultCode.SUCCESS_WITH_WARNING;
            cardResult.setCode(resultCode);
            return resultCode;
        } catch (Exception e) {
            Log.e(TAG, "Error", e);
            CardResult cardResult2 = this._result;
            ResultCode resultCode2 = ResultCode.CARD_LOST_CONNECTION;
            cardResult2.setCode(resultCode2);
            return resultCode2;
        }
    }

    private void closeALl() {
        try {
            IdCardService idCardService = this._service;
            if (idCardService != null) {
                idCardService.close();
            }
        } catch (Exception e) {
            String str = TAG;
            Log.d(str, "Exception: " + e.getMessage());
        }
        try {
            CardService cardService = this._card;
            if (cardService != null) {
                cardService.close();
            }
        } catch (Exception e2) {
            String str2 = TAG;
            Log.d(str2, "Exception: " + e2.getMessage());
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0086 A[Catch:{ Exception -> 0x0061 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.fis.ekyc.nfc.build_in.model.ResultCode ecapod() {
        /*
            r9 = this;
            long r0 = r9.getCurrent()     // Catch:{ Exception -> 0x0061 }
            java.lang.String r2 = TAG     // Catch:{ Exception -> 0x0061 }
            java.lang.String r3 = "Start Pace...!"
            android.util.Log.d(r2, r3)     // Catch:{ Exception -> 0x0061 }
            androidx.lifecycle.u r2 = r9.processLiveData     // Catch:{ Exception -> 0x0061 }
            java.lang.String r3 = "Start Pace..."
            r2.m(r3)     // Catch:{ Exception -> 0x0061 }
            com.fis.ekyc.nfc.build_in.eidparser.lds.CardAccessFile r2 = new com.fis.ekyc.nfc.build_in.eidparser.lds.CardAccessFile     // Catch:{ Exception -> 0x0061 }
            com.fis.ekyc.nfc.build_in.eidparser.IdCardService r3 = r9._service     // Catch:{ Exception -> 0x0061 }
            r4 = 284(0x11c, float:3.98E-43)
            com.fis.ekyc.nfc.build_in.scuba.smartcards.CardFileInputStream r3 = r3.getInputStream(r4)     // Catch:{ Exception -> 0x0061 }
            r2.<init>((java.io.InputStream) r3)     // Catch:{ Exception -> 0x0061 }
            androidx.lifecycle.u r3 = r9.processLiveData     // Catch:{ Exception -> 0x0061 }
            java.lang.String r4 = "Get Security Info..."
            r3.m(r4)     // Catch:{ Exception -> 0x0061 }
            java.util.Collection r2 = r2.getSecurityInfos()     // Catch:{ Exception -> 0x0061 }
            java.lang.String r3 = r9.birthDate     // Catch:{ Exception -> 0x0061 }
            boolean r3 = r3.isEmpty()     // Catch:{ Exception -> 0x0061 }
            if (r3 != 0) goto L_0x0064
            java.lang.String r3 = r9.expiredDate     // Catch:{ Exception -> 0x0061 }
            boolean r3 = r3.isEmpty()     // Catch:{ Exception -> 0x0061 }
            if (r3 == 0) goto L_0x003b
            goto L_0x0064
        L_0x003b:
            java.lang.String r3 = r9.BAC     // Catch:{ Exception -> 0x0061 }
            java.text.SimpleDateFormat r4 = new java.text.SimpleDateFormat     // Catch:{ Exception -> 0x0061 }
            java.lang.String r5 = "yyMMdd"
            java.util.Locale r6 = java.util.Locale.getDefault()     // Catch:{ Exception -> 0x0061 }
            r4.<init>(r5, r6)     // Catch:{ Exception -> 0x0061 }
            java.lang.String r5 = r9.birthDate     // Catch:{ Exception -> 0x0061 }
            java.util.Date r5 = r4.parse(r5)     // Catch:{ Exception -> 0x0061 }
            java.lang.String r6 = r9.expiredDate     // Catch:{ Exception -> 0x0061 }
            java.util.Date r4 = r4.parse(r6)     // Catch:{ Exception -> 0x0061 }
            com.fis.ekyc.nfc.build_in.eidparser.BACKey r6 = new com.fis.ekyc.nfc.build_in.eidparser.BACKey     // Catch:{ Exception -> 0x0061 }
            java.lang.String r7 = r9._cccdId     // Catch:{ Exception -> 0x0061 }
            r8 = 3
            java.lang.String r7 = r7.substring(r8)     // Catch:{ Exception -> 0x0061 }
            r6.<init>((java.lang.String) r7, (java.util.Date) r5, (java.util.Date) r4)     // Catch:{ Exception -> 0x0061 }
            goto L_0x007c
        L_0x0061:
            r0 = move-exception
            goto L_0x0125
        L_0x0064:
            java.lang.String r3 = r9.PACE     // Catch:{ Exception -> 0x0061 }
            java.lang.String r4 = r9._cccdId     // Catch:{ Exception -> 0x0061 }
            int r4 = r4.length()     // Catch:{ Exception -> 0x0061 }
            int r4 = r4 + -6
            java.lang.String r5 = r9._cccdId     // Catch:{ Exception -> 0x0061 }
            java.lang.String r4 = r5.substring(r4)     // Catch:{ Exception -> 0x0061 }
            java.lang.String r4 = r4.trim()     // Catch:{ Exception -> 0x0061 }
            com.fis.ekyc.nfc.build_in.eidparser.PACEKeySpec r6 = com.fis.ekyc.nfc.build_in.eidparser.PACEKeySpec.createCANKey(r4)     // Catch:{ Exception -> 0x0061 }
        L_0x007c:
            java.util.Iterator r2 = r2.iterator()     // Catch:{ Exception -> 0x0061 }
        L_0x0080:
            boolean r4 = r2.hasNext()     // Catch:{ Exception -> 0x0061 }
            if (r4 == 0) goto L_0x0119
            java.lang.Object r4 = r2.next()     // Catch:{ Exception -> 0x0061 }
            com.fis.ekyc.nfc.build_in.eidparser.lds.SecurityInfo r4 = (com.fis.ekyc.nfc.build_in.eidparser.lds.SecurityInfo) r4     // Catch:{ Exception -> 0x0061 }
            boolean r5 = r4 instanceof com.fis.ekyc.nfc.build_in.eidparser.lds.PACEInfo     // Catch:{ Exception -> 0x0061 }
            if (r5 == 0) goto L_0x0080
            androidx.lifecycle.u r2 = r9.processLiveData     // Catch:{ Exception -> 0x0061 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0061 }
            r5.<init>()     // Catch:{ Exception -> 0x0061 }
            java.lang.String r7 = "Do "
            r5.append(r7)     // Catch:{ Exception -> 0x0061 }
            r5.append(r3)     // Catch:{ Exception -> 0x0061 }
            java.lang.String r7 = "..."
            r5.append(r7)     // Catch:{ Exception -> 0x0061 }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x0061 }
            r2.m(r5)     // Catch:{ Exception -> 0x0061 }
            com.fis.ekyc.nfc.build_in.eidparser.lds.PACEInfo r4 = (com.fis.ekyc.nfc.build_in.eidparser.lds.PACEInfo) r4     // Catch:{ Exception -> 0x0061 }
            com.fis.ekyc.nfc.build_in.eidparser.IdCardService r2 = r9._service     // Catch:{ CardServiceException -> 0x00c0 }
            java.lang.String r5 = r4.getObjectIdentifier()     // Catch:{ CardServiceException -> 0x00c0 }
            java.math.BigInteger r4 = r4.getParameterId()     // Catch:{ CardServiceException -> 0x00c0 }
            java.security.spec.AlgorithmParameterSpec r4 = com.fis.ekyc.nfc.build_in.eidparser.lds.PACEInfo.toParameterSpec((java.math.BigInteger) r4)     // Catch:{ CardServiceException -> 0x00c0 }
            r7 = 0
            r2.doPACE(r6, r5, r4, r7)     // Catch:{ CardServiceException -> 0x00c0 }
            goto L_0x00db
        L_0x00c0:
            r2 = move-exception
            java.lang.String r4 = TAG     // Catch:{ Exception -> 0x0061 }
            android.util.Log.w(r4, r2)     // Catch:{ Exception -> 0x0061 }
            int r4 = r2.getSW()     // Catch:{ Exception -> 0x0061 }
            r5 = 25344(0x6300, float:3.5515E-41)
            if (r4 != r5) goto L_0x00d1
            com.fis.ekyc.nfc.build_in.model.ResultCode r0 = com.fis.ekyc.nfc.build_in.model.ResultCode.WRONG_CITIZEN_ID_CARD     // Catch:{ Exception -> 0x0061 }
            return r0
        L_0x00d1:
            int r2 = r2.getSW()     // Catch:{ Exception -> 0x0061 }
            r4 = -1
            if (r2 != r4) goto L_0x00db
            com.fis.ekyc.nfc.build_in.model.ResultCode r0 = com.fis.ekyc.nfc.build_in.model.ResultCode.CARD_LOST_CONNECTION     // Catch:{ Exception -> 0x0061 }
            return r0
        L_0x00db:
            java.lang.String r2 = TAG     // Catch:{ Exception -> 0x0061 }
            java.lang.String r4 = "ecap successful!"
            android.util.Log.w(r2, r4)     // Catch:{ Exception -> 0x0061 }
            androidx.lifecycle.u r2 = r9.processLiveData     // Catch:{ Exception -> 0x0061 }
            java.lang.String r4 = "ECAP successful!"
            r2.m(r4)     // Catch:{ Exception -> 0x0061 }
            androidx.lifecycle.u r2 = r9.processLiveData     // Catch:{ Exception -> 0x0061 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0061 }
            r4.<init>()     // Catch:{ Exception -> 0x0061 }
            r4.append(r3)     // Catch:{ Exception -> 0x0061 }
            java.lang.String r3 = " total: %s millis"
            r4.append(r3)     // Catch:{ Exception -> 0x0061 }
            java.lang.String r3 = r4.toString()     // Catch:{ Exception -> 0x0061 }
            long r4 = r9.getCurrent()     // Catch:{ Exception -> 0x0061 }
            long r4 = r4 - r0
            java.lang.Long r0 = java.lang.Long.valueOf(r4)     // Catch:{ Exception -> 0x0061 }
            java.lang.Object[] r0 = new java.lang.Object[]{r0}     // Catch:{ Exception -> 0x0061 }
            java.lang.String r0 = java.lang.String.format(r3, r0)     // Catch:{ Exception -> 0x0061 }
            r2.m(r0)     // Catch:{ Exception -> 0x0061 }
            com.fis.ekyc.nfc.build_in.eidparser.IdCardService r0 = r9._service     // Catch:{ Exception -> 0x0061 }
            r1 = 1
            r0.sendSelectApplet(r1)     // Catch:{ Exception -> 0x0061 }
            com.fis.ekyc.nfc.build_in.model.ResultCode r0 = com.fis.ekyc.nfc.build_in.model.ResultCode.SUCCESS     // Catch:{ Exception -> 0x0061 }
            return r0
        L_0x0119:
            java.lang.String r0 = TAG
            com.fis.ekyc.nfc.build_in.model.ResultCode r1 = com.fis.ekyc.nfc.build_in.model.ResultCode.WRONG_CITIZEN_ID_CARD
            java.lang.String r2 = r1.toString()
            android.util.Log.w(r0, r2)
            return r1
        L_0x0125:
            boolean r1 = r0 instanceof com.fis.ekyc.nfc.build_in.scuba.smartcards.CardServiceException
            if (r1 == 0) goto L_0x0137
            r1 = r0
            com.fis.ekyc.nfc.build_in.scuba.smartcards.CardServiceException r1 = (com.fis.ekyc.nfc.build_in.scuba.smartcards.CardServiceException) r1
            int r1 = r1.getSW()
            r2 = 27270(0x6a86, float:3.8213E-41)
            if (r1 != r2) goto L_0x0137
            com.fis.ekyc.nfc.build_in.model.ResultCode r0 = com.fis.ekyc.nfc.build_in.model.ResultCode.CARD_INCORRECT
            return r0
        L_0x0137:
            java.lang.String r1 = TAG
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            com.fis.ekyc.nfc.build_in.model.ResultCode r3 = com.fis.ekyc.nfc.build_in.model.ResultCode.CARD_LOST_CONNECTION
            r2.append(r3)
            java.lang.String r4 = " "
            r2.append(r4)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            android.util.Log.w(r1, r0)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fis.ekyc.nfc.build_in.eidparser.ICaoReaderParser.ecapod():com.fis.ekyc.nfc.build_in.model.ResultCode");
    }

    private long getCurrent() {
        return Calendar.getInstance().getTimeInMillis();
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x00e2 A[Catch:{ Exception -> 0x004a }] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00f3 A[Catch:{ Exception -> 0x004a }] */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0282 A[Catch:{ Exception -> 0x004a }] */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0294 A[Catch:{ Exception -> 0x004a }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.fis.ekyc.nfc.build_in.model.ResultCode spuorGataDllAdaer() {
        /*
            r25 = this;
            r1 = r25
            java.lang.String r2 = "Error"
            com.fis.ekyc.nfc.build_in.model.CardResult r0 = r1._result     // Catch:{ Exception -> 0x004a }
            com.fis.ekyc.nfc.build_in.model.ResultCode r3 = com.fis.ekyc.nfc.build_in.model.ResultCode.SUCCESS     // Catch:{ Exception -> 0x004a }
            r0.setCode(r3)     // Catch:{ Exception -> 0x004a }
            com.fis.ekyc.nfc.build_in.eidparser.IdCardService r0 = r1._service     // Catch:{ Exception -> 0x004a }
            r3 = 285(0x11d, float:4.0E-43)
            com.fis.ekyc.nfc.build_in.scuba.smartcards.CardFileInputStream r0 = r0.getInputStream(r3)     // Catch:{ Exception -> 0x004a }
            com.fis.ekyc.nfc.build_in.eidparser.lds.SODFile r3 = new com.fis.ekyc.nfc.build_in.eidparser.lds.SODFile     // Catch:{ Exception -> 0x004a }
            r3.<init>(r0)     // Catch:{ Exception -> 0x004a }
            r1._sodFile = r3     // Catch:{ Exception -> 0x004a }
            w4.b$a r0 = w4.C0061b.a     // Catch:{ Exception -> 0x004a }
            boolean r3 = r0.q()     // Catch:{ Exception -> 0x004a }
            java.lang.String r4 = "Get DG1: %s millis"
            java.lang.String r5 = "Get DG13: %s millis"
            java.lang.String r7 = "Get DG14: %s millis"
            java.lang.String r9 = "Get DG15: %s millis"
            java.lang.String r11 = "Cannot read Data Groupd: %d, ignore!"
            r12 = 3
            java.lang.String r14 = "Found hash of Data Group: "
            java.lang.String r15 = "Get SOD: %s millis"
            java.lang.String r13 = "Ignore DataGroup 3 (Is FingerPrint - cannot read)!"
            if (r3 == 0) goto L_0x01e1
            androidx.lifecycle.u r3 = r1.processLiveData     // Catch:{ Exception -> 0x004a }
            java.lang.String r10 = "Loading Cache data!"
            r3.m(r10)     // Catch:{ Exception -> 0x004a }
            byte[] r3 = r0.f()     // Catch:{ Exception -> 0x004a }
            if (r3 == 0) goto L_0x004d
            com.fis.ekyc.nfc.build_in.model.CardResult r3 = r1._result     // Catch:{ Exception -> 0x004a }
            byte[] r10 = r0.f()     // Catch:{ Exception -> 0x004a }
            r3.setSOD(r10)     // Catch:{ Exception -> 0x004a }
            goto L_0x0073
        L_0x004a:
            r0 = move-exception
            goto L_0x03b2
        L_0x004d:
            long r18 = r25.getCurrent()     // Catch:{ Exception -> 0x004a }
            com.fis.ekyc.nfc.build_in.model.CardResult r3 = r1._result     // Catch:{ Exception -> 0x004a }
            com.fis.ekyc.nfc.build_in.eidparser.lds.SODFile r10 = r1._sodFile     // Catch:{ Exception -> 0x004a }
            byte[] r10 = r10.getEncoded()     // Catch:{ Exception -> 0x004a }
            r3.setSOD(r10)     // Catch:{ Exception -> 0x004a }
            androidx.lifecycle.u r3 = r1.processLiveData     // Catch:{ Exception -> 0x004a }
            long r20 = r25.getCurrent()     // Catch:{ Exception -> 0x004a }
            long r20 = r20 - r18
            java.lang.Long r10 = java.lang.Long.valueOf(r20)     // Catch:{ Exception -> 0x004a }
            java.lang.Object[] r10 = new java.lang.Object[]{r10}     // Catch:{ Exception -> 0x004a }
            java.lang.String r10 = java.lang.String.format(r15, r10)     // Catch:{ Exception -> 0x004a }
            r3.m(r10)     // Catch:{ Exception -> 0x004a }
        L_0x0073:
            com.fis.ekyc.nfc.build_in.model.CardResult r3 = r1._result     // Catch:{ Exception -> 0x004a }
            byte[] r3 = r3.getSOD()     // Catch:{ Exception -> 0x004a }
            android.app.Activity r10 = r1.activity     // Catch:{ Exception -> 0x004a }
            r0.z(r3, r10)     // Catch:{ Exception -> 0x004a }
            com.fis.ekyc.nfc.build_in.eidparser.lds.SODFile r0 = r1._sodFile     // Catch:{ Exception -> 0x004a }
            java.util.Map r3 = r0.getDataGroupHashes()     // Catch:{ Exception -> 0x004a }
            java.util.Set r0 = r3.keySet()     // Catch:{ Exception -> 0x004a }
            java.util.Iterator r10 = r0.iterator()     // Catch:{ Exception -> 0x004a }
        L_0x008c:
            boolean r0 = r10.hasNext()     // Catch:{ Exception -> 0x004a }
            if (r0 == 0) goto L_0x03be
            java.lang.Object r0 = r10.next()     // Catch:{ Exception -> 0x004a }
            r15 = r0
            java.lang.Integer r15 = (java.lang.Integer) r15     // Catch:{ Exception -> 0x004a }
            java.lang.Object r0 = r3.get(r15)     // Catch:{ Exception -> 0x004a }
            byte[] r0 = (byte[]) r0     // Catch:{ Exception -> 0x004a }
            int r0 = r0.length     // Catch:{ Exception -> 0x004a }
            if (r0 <= 0) goto L_0x00ef
            java.lang.String r0 = TAG     // Catch:{ Exception -> 0x004a }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x004a }
            r6.<init>()     // Catch:{ Exception -> 0x004a }
            r6.append(r14)     // Catch:{ Exception -> 0x004a }
            r6.append(r15)     // Catch:{ Exception -> 0x004a }
            java.lang.String r8 = "; "
            r6.append(r8)     // Catch:{ Exception -> 0x004a }
            java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x004a }
            android.util.Log.d(r0, r6)     // Catch:{ Exception -> 0x004a }
            int r6 = r15.intValue()     // Catch:{ Exception -> 0x00cf }
            if (r6 == r12) goto L_0x00d1
            com.fis.ekyc.nfc.build_in.eidparser.IdCardService r0 = r1._service     // Catch:{ Exception -> 0x00cf }
            int r6 = r15.intValue()     // Catch:{ Exception -> 0x00cf }
            int r6 = r6 + 256
            short r6 = (short) r6     // Catch:{ Exception -> 0x00cf }
            com.fis.ekyc.nfc.build_in.scuba.smartcards.CardFileInputStream r0 = r0.getInputStream(r6)     // Catch:{ Exception -> 0x00cf }
            goto L_0x00e0
        L_0x00cf:
            r0 = move-exception
            goto L_0x00da
        L_0x00d1:
            androidx.lifecycle.u r6 = r1.processLiveData     // Catch:{ Exception -> 0x00cf }
            r6.m(r13)     // Catch:{ Exception -> 0x00cf }
            android.util.Log.w(r0, r13)     // Catch:{ Exception -> 0x00cf }
            goto L_0x00df
        L_0x00da:
            java.lang.String r6 = TAG     // Catch:{ Exception -> 0x004a }
            android.util.Log.e(r6, r2, r0)     // Catch:{ Exception -> 0x004a }
        L_0x00df:
            r0 = 0
        L_0x00e0:
            if (r0 != 0) goto L_0x00f3
            java.lang.String r0 = TAG     // Catch:{ Exception -> 0x004a }
            java.lang.Object[] r6 = new java.lang.Object[]{r15}     // Catch:{ Exception -> 0x004a }
            java.lang.String r6 = java.lang.String.format(r11, r6)     // Catch:{ Exception -> 0x004a }
            android.util.Log.w(r0, r6)     // Catch:{ Exception -> 0x004a }
        L_0x00ef:
            r24 = r13
            goto L_0x01dc
        L_0x00f3:
            long r20 = r25.getCurrent()     // Catch:{ Exception -> 0x004a }
            int r6 = r15.intValue()     // Catch:{ Exception -> 0x004a }
            r8 = 1
            if (r6 == r8) goto L_0x01b1
            r8 = 2
            if (r6 == r8) goto L_0x015c
            switch(r6) {
                case 13: goto L_0x0159;
                case 14: goto L_0x012f;
                case 15: goto L_0x0105;
                default: goto L_0x0104;
            }     // Catch:{ Exception -> 0x004a }
        L_0x0104:
            goto L_0x00ef
        L_0x0105:
            com.fis.ekyc.nfc.build_in.eidparser.lds.icao.DG15File r6 = new com.fis.ekyc.nfc.build_in.eidparser.lds.icao.DG15File     // Catch:{ Exception -> 0x004a }
            r6.<init>((java.io.InputStream) r0)     // Catch:{ Exception -> 0x004a }
            r1._dgPublicKeyFile = r6     // Catch:{ Exception -> 0x004a }
            byte[] r0 = r6.getEncoded()     // Catch:{ Exception -> 0x004a }
            com.fis.ekyc.nfc.build_in.model.CardResult r6 = r1._result     // Catch:{ Exception -> 0x004a }
            r8 = 15
            r6.setDG(r8, r0)     // Catch:{ Exception -> 0x004a }
            androidx.lifecycle.u r0 = r1.processLiveData     // Catch:{ Exception -> 0x004a }
            long r22 = r25.getCurrent()     // Catch:{ Exception -> 0x004a }
            long r22 = r22 - r20
            java.lang.Long r6 = java.lang.Long.valueOf(r22)     // Catch:{ Exception -> 0x004a }
            java.lang.Object[] r6 = new java.lang.Object[]{r6}     // Catch:{ Exception -> 0x004a }
            java.lang.String r6 = java.lang.String.format(r9, r6)     // Catch:{ Exception -> 0x004a }
            r0.m(r6)     // Catch:{ Exception -> 0x004a }
            goto L_0x00ef
        L_0x012f:
            com.fis.ekyc.nfc.build_in.eidparser.lds.icao.DG14File r6 = new com.fis.ekyc.nfc.build_in.eidparser.lds.icao.DG14File     // Catch:{ Exception -> 0x004a }
            r6.<init>((java.io.InputStream) r0)     // Catch:{ Exception -> 0x004a }
            r1._dgSecurityInfoFile = r6     // Catch:{ Exception -> 0x004a }
            byte[] r0 = r6.getEncoded()     // Catch:{ Exception -> 0x004a }
            com.fis.ekyc.nfc.build_in.model.CardResult r6 = r1._result     // Catch:{ Exception -> 0x004a }
            r8 = 14
            r6.setDG(r8, r0)     // Catch:{ Exception -> 0x004a }
            androidx.lifecycle.u r0 = r1.processLiveData     // Catch:{ Exception -> 0x004a }
            long r22 = r25.getCurrent()     // Catch:{ Exception -> 0x004a }
            long r22 = r22 - r20
            java.lang.Long r6 = java.lang.Long.valueOf(r22)     // Catch:{ Exception -> 0x004a }
            java.lang.Object[] r6 = new java.lang.Object[]{r6}     // Catch:{ Exception -> 0x004a }
            java.lang.String r6 = java.lang.String.format(r7, r6)     // Catch:{ Exception -> 0x004a }
            r0.m(r6)     // Catch:{ Exception -> 0x004a }
            goto L_0x00ef
        L_0x0159:
            r24 = r13
            goto L_0x017b
        L_0x015c:
            w4.b$a r6 = w4.C0061b.a     // Catch:{ Exception -> 0x004a }
            byte[] r6 = r6.c()     // Catch:{ Exception -> 0x004a }
            if (r6 != 0) goto L_0x0168
            byte[] r6 = w4.C0060a.a(r0)     // Catch:{ Exception -> 0x004a }
        L_0x0168:
            com.fis.ekyc.nfc.build_in.model.CardResult r8 = r1._result     // Catch:{ Exception -> 0x004a }
            r15 = 2
            r8.setDG(r15, r6)     // Catch:{ Exception -> 0x004a }
            com.fis.ekyc.nfc.build_in.model.CardResult r6 = r1._result     // Catch:{ Exception -> 0x004a }
            long r22 = r25.getCurrent()     // Catch:{ Exception -> 0x004a }
            r24 = r13
            long r12 = r22 - r20
            r6.setReadDG2Time(r12)     // Catch:{ Exception -> 0x004a }
        L_0x017b:
            w4.b$a r6 = w4.C0061b.a     // Catch:{ Exception -> 0x004a }
            byte[] r6 = r6.b()     // Catch:{ Exception -> 0x004a }
            if (r6 != 0) goto L_0x0187
            byte[] r6 = w4.C0060a.a(r0)     // Catch:{ Exception -> 0x004a }
        L_0x0187:
            com.fis.ekyc.nfc.build_in.model.CardResult r0 = r1._result     // Catch:{ Exception -> 0x004a }
            r12 = 13
            r0.setDG(r12, r6)     // Catch:{ Exception -> 0x004a }
            com.fis.ekyc.nfc.build_in.eidparser.DG13FilePersonal r0 = new com.fis.ekyc.nfc.build_in.eidparser.DG13FilePersonal     // Catch:{ Exception -> 0x004a }
            r0.<init>((byte[]) r6)     // Catch:{ Exception -> 0x004a }
            com.fis.ekyc.nfc.build_in.eidparser.IDCardDetail r0 = r0.readContent()     // Catch:{ Exception -> 0x004a }
            r1.personalData = r0     // Catch:{ Exception -> 0x004a }
            androidx.lifecycle.u r0 = r1.processLiveData     // Catch:{ Exception -> 0x004a }
            long r12 = r25.getCurrent()     // Catch:{ Exception -> 0x004a }
            long r12 = r12 - r20
            java.lang.Long r6 = java.lang.Long.valueOf(r12)     // Catch:{ Exception -> 0x004a }
            java.lang.Object[] r6 = new java.lang.Object[]{r6}     // Catch:{ Exception -> 0x004a }
            java.lang.String r6 = java.lang.String.format(r5, r6)     // Catch:{ Exception -> 0x004a }
            r0.m(r6)     // Catch:{ Exception -> 0x004a }
            goto L_0x01dc
        L_0x01b1:
            r24 = r13
            w4.b$a r6 = w4.C0061b.a     // Catch:{ Exception -> 0x004a }
            byte[] r6 = r6.a()     // Catch:{ Exception -> 0x004a }
            if (r6 != 0) goto L_0x01bf
            byte[] r6 = w4.C0060a.a(r0)     // Catch:{ Exception -> 0x004a }
        L_0x01bf:
            com.fis.ekyc.nfc.build_in.model.CardResult r0 = r1._result     // Catch:{ Exception -> 0x004a }
            r12 = 1
            r0.setDG(r12, r6)     // Catch:{ Exception -> 0x004a }
            androidx.lifecycle.u r0 = r1.processLiveData     // Catch:{ Exception -> 0x004a }
            long r12 = r25.getCurrent()     // Catch:{ Exception -> 0x004a }
            long r12 = r12 - r20
            java.lang.Long r6 = java.lang.Long.valueOf(r12)     // Catch:{ Exception -> 0x004a }
            java.lang.Object[] r6 = new java.lang.Object[]{r6}     // Catch:{ Exception -> 0x004a }
            java.lang.String r6 = java.lang.String.format(r4, r6)     // Catch:{ Exception -> 0x004a }
            r0.m(r6)     // Catch:{ Exception -> 0x004a }
        L_0x01dc:
            r13 = r24
            r12 = 3
            goto L_0x008c
        L_0x01e1:
            r24 = r13
            long r12 = r25.getCurrent()     // Catch:{ Exception -> 0x004a }
            com.fis.ekyc.nfc.build_in.model.CardResult r3 = r1._result     // Catch:{ Exception -> 0x004a }
            com.fis.ekyc.nfc.build_in.eidparser.lds.SODFile r6 = r1._sodFile     // Catch:{ Exception -> 0x004a }
            byte[] r6 = r6.getEncoded()     // Catch:{ Exception -> 0x004a }
            r3.setSOD(r6)     // Catch:{ Exception -> 0x004a }
            androidx.lifecycle.u r3 = r1.processLiveData     // Catch:{ Exception -> 0x004a }
            long r20 = r25.getCurrent()     // Catch:{ Exception -> 0x004a }
            long r20 = r20 - r12
            java.lang.Long r6 = java.lang.Long.valueOf(r20)     // Catch:{ Exception -> 0x004a }
            java.lang.Object[] r6 = new java.lang.Object[]{r6}     // Catch:{ Exception -> 0x004a }
            java.lang.String r6 = java.lang.String.format(r15, r6)     // Catch:{ Exception -> 0x004a }
            r3.m(r6)     // Catch:{ Exception -> 0x004a }
            com.fis.ekyc.nfc.build_in.model.CardResult r3 = r1._result     // Catch:{ Exception -> 0x004a }
            byte[] r3 = r3.getSOD()     // Catch:{ Exception -> 0x004a }
            android.app.Activity r6 = r1.activity     // Catch:{ Exception -> 0x004a }
            r0.z(r3, r6)     // Catch:{ Exception -> 0x004a }
            com.fis.ekyc.nfc.build_in.eidparser.lds.SODFile r0 = r1._sodFile     // Catch:{ Exception -> 0x004a }
            java.util.Map r3 = r0.getDataGroupHashes()     // Catch:{ Exception -> 0x004a }
            java.util.Set r0 = r3.keySet()     // Catch:{ Exception -> 0x004a }
            java.util.Iterator r6 = r0.iterator()     // Catch:{ Exception -> 0x004a }
        L_0x0222:
            boolean r0 = r6.hasNext()     // Catch:{ Exception -> 0x004a }
            if (r0 == 0) goto L_0x03be
            java.lang.Object r0 = r6.next()     // Catch:{ Exception -> 0x004a }
            r10 = r0
            java.lang.Integer r10 = (java.lang.Integer) r10     // Catch:{ Exception -> 0x004a }
            java.lang.Object r0 = r3.get(r10)     // Catch:{ Exception -> 0x004a }
            byte[] r0 = (byte[]) r0     // Catch:{ Exception -> 0x004a }
            int r0 = r0.length     // Catch:{ Exception -> 0x004a }
            if (r0 <= 0) goto L_0x03a8
            java.lang.String r0 = TAG     // Catch:{ Exception -> 0x004a }
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x004a }
            r12.<init>()     // Catch:{ Exception -> 0x004a }
            r12.append(r14)     // Catch:{ Exception -> 0x004a }
            r12.append(r10)     // Catch:{ Exception -> 0x004a }
            java.lang.String r12 = r12.toString()     // Catch:{ Exception -> 0x004a }
            android.util.Log.d(r0, r12)     // Catch:{ Exception -> 0x004a }
            int r12 = r10.intValue()     // Catch:{ Exception -> 0x0276 }
            r8 = 3
            if (r12 == r8) goto L_0x0267
            com.fis.ekyc.nfc.build_in.eidparser.IdCardService r0 = r1._service     // Catch:{ Exception -> 0x0263 }
            int r12 = r10.intValue()     // Catch:{ Exception -> 0x0263 }
            int r12 = r12 + 256
            short r12 = (short) r12     // Catch:{ Exception -> 0x0263 }
            com.fis.ekyc.nfc.build_in.scuba.smartcards.CardFileInputStream r0 = r0.getInputStream(r12)     // Catch:{ Exception -> 0x0263 }
            r12 = r24
            goto L_0x0280
        L_0x0263:
            r0 = move-exception
            r12 = r24
            goto L_0x027a
        L_0x0267:
            r12 = r24
            android.util.Log.w(r0, r12)     // Catch:{ Exception -> 0x0274 }
            androidx.lifecycle.u r0 = r1.processLiveData     // Catch:{ Exception -> 0x0274 }
            java.lang.String r13 = "Ignore DataGroup 3"
            r0.m(r13)     // Catch:{ Exception -> 0x0274 }
            goto L_0x027f
        L_0x0274:
            r0 = move-exception
            goto L_0x027a
        L_0x0276:
            r0 = move-exception
            r12 = r24
            r8 = 3
        L_0x027a:
            java.lang.String r13 = TAG     // Catch:{ Exception -> 0x004a }
            android.util.Log.e(r13, r2, r0)     // Catch:{ Exception -> 0x004a }
        L_0x027f:
            r0 = 0
        L_0x0280:
            if (r0 != 0) goto L_0x0294
            java.lang.String r0 = TAG     // Catch:{ Exception -> 0x004a }
            java.lang.Object[] r10 = new java.lang.Object[]{r10}     // Catch:{ Exception -> 0x004a }
            java.lang.String r10 = java.lang.String.format(r11, r10)     // Catch:{ Exception -> 0x004a }
            android.util.Log.w(r0, r10)     // Catch:{ Exception -> 0x004a }
        L_0x028f:
            r10 = r14
        L_0x0290:
            r14 = 1
            r15 = 2
            goto L_0x03ad
        L_0x0294:
            java.lang.String r13 = TAG     // Catch:{ Exception -> 0x004a }
            java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x004a }
            r15.<init>()     // Catch:{ Exception -> 0x004a }
            java.lang.String r8 = "Reading Data Group: "
            r15.append(r8)     // Catch:{ Exception -> 0x004a }
            r15.append(r10)     // Catch:{ Exception -> 0x004a }
            java.lang.String r8 = r15.toString()     // Catch:{ Exception -> 0x004a }
            android.util.Log.d(r13, r8)     // Catch:{ Exception -> 0x004a }
            long r21 = r25.getCurrent()     // Catch:{ Exception -> 0x004a }
            int r8 = r10.intValue()     // Catch:{ Exception -> 0x004a }
            r10 = 1
            if (r8 == r10) goto L_0x037b
            r10 = 2
            if (r8 == r10) goto L_0x0324
            switch(r8) {
                case 13: goto L_0x0321;
                case 14: goto L_0x02ed;
                case 15: goto L_0x02bc;
                default: goto L_0x02bb;
            }     // Catch:{ Exception -> 0x004a }
        L_0x02bb:
            goto L_0x028f
        L_0x02bc:
            com.fis.ekyc.nfc.build_in.eidparser.lds.icao.DG15File r8 = new com.fis.ekyc.nfc.build_in.eidparser.lds.icao.DG15File     // Catch:{ Exception -> 0x004a }
            r8.<init>((java.io.InputStream) r0)     // Catch:{ Exception -> 0x004a }
            r1._dgPublicKeyFile = r8     // Catch:{ Exception -> 0x004a }
            byte[] r0 = r8.getEncoded()     // Catch:{ Exception -> 0x004a }
            w4.b$a r8 = w4.C0061b.a     // Catch:{ Exception -> 0x004a }
            android.app.Activity r10 = r1.activity     // Catch:{ Exception -> 0x004a }
            r8.v(r0, r10)     // Catch:{ Exception -> 0x004a }
            com.fis.ekyc.nfc.build_in.model.CardResult r8 = r1._result     // Catch:{ Exception -> 0x004a }
            r10 = 15
            r8.setDG(r10, r0)     // Catch:{ Exception -> 0x004a }
            androidx.lifecycle.u r0 = r1.processLiveData     // Catch:{ Exception -> 0x004a }
            long r23 = r25.getCurrent()     // Catch:{ Exception -> 0x004a }
            long r23 = r23 - r21
            java.lang.Long r8 = java.lang.Long.valueOf(r23)     // Catch:{ Exception -> 0x004a }
            java.lang.Object[] r8 = new java.lang.Object[]{r8}     // Catch:{ Exception -> 0x004a }
            java.lang.String r8 = java.lang.String.format(r9, r8)     // Catch:{ Exception -> 0x004a }
            r0.m(r8)     // Catch:{ Exception -> 0x004a }
            goto L_0x028f
        L_0x02ed:
            r10 = 15
            com.fis.ekyc.nfc.build_in.eidparser.lds.icao.DG14File r8 = new com.fis.ekyc.nfc.build_in.eidparser.lds.icao.DG14File     // Catch:{ Exception -> 0x004a }
            r8.<init>((java.io.InputStream) r0)     // Catch:{ Exception -> 0x004a }
            r1._dgSecurityInfoFile = r8     // Catch:{ Exception -> 0x004a }
            byte[] r0 = r8.getEncoded()     // Catch:{ Exception -> 0x004a }
            com.fis.ekyc.nfc.build_in.model.CardResult r8 = r1._result     // Catch:{ Exception -> 0x004a }
            r13 = 14
            r8.setDG(r13, r0)     // Catch:{ Exception -> 0x004a }
            w4.b$a r8 = w4.C0061b.a     // Catch:{ Exception -> 0x004a }
            android.app.Activity r15 = r1.activity     // Catch:{ Exception -> 0x004a }
            r8.u(r0, r15)     // Catch:{ Exception -> 0x004a }
            androidx.lifecycle.u r0 = r1.processLiveData     // Catch:{ Exception -> 0x004a }
            long r16 = r25.getCurrent()     // Catch:{ Exception -> 0x004a }
            long r16 = r16 - r21
            java.lang.Long r8 = java.lang.Long.valueOf(r16)     // Catch:{ Exception -> 0x004a }
            java.lang.Object[] r8 = new java.lang.Object[]{r8}     // Catch:{ Exception -> 0x004a }
            java.lang.String r8 = java.lang.String.format(r7, r8)     // Catch:{ Exception -> 0x004a }
            r0.m(r8)     // Catch:{ Exception -> 0x004a }
            goto L_0x028f
        L_0x0321:
            r10 = r14
            r15 = 2
            goto L_0x0345
        L_0x0324:
            r10 = 15
            r13 = 14
            byte[] r8 = w4.C0060a.a(r0)     // Catch:{ Exception -> 0x004a }
            w4.b$a r15 = w4.C0061b.a     // Catch:{ Exception -> 0x004a }
            android.app.Activity r10 = r1.activity     // Catch:{ Exception -> 0x004a }
            r15.w(r8, r10)     // Catch:{ Exception -> 0x004a }
            com.fis.ekyc.nfc.build_in.model.CardResult r10 = r1._result     // Catch:{ Exception -> 0x004a }
            r15 = 2
            r10.setDG(r15, r8)     // Catch:{ Exception -> 0x004a }
            com.fis.ekyc.nfc.build_in.model.CardResult r8 = r1._result     // Catch:{ Exception -> 0x004a }
            long r23 = r25.getCurrent()     // Catch:{ Exception -> 0x004a }
            r10 = r14
            long r13 = r23 - r21
            r8.setReadDG2Time(r13)     // Catch:{ Exception -> 0x004a }
        L_0x0345:
            byte[] r0 = w4.C0060a.a(r0)     // Catch:{ Exception -> 0x004a }
            w4.b$a r8 = w4.C0061b.a     // Catch:{ Exception -> 0x004a }
            android.app.Activity r13 = r1.activity     // Catch:{ Exception -> 0x004a }
            r8.t(r0, r13)     // Catch:{ Exception -> 0x004a }
            com.fis.ekyc.nfc.build_in.model.CardResult r8 = r1._result     // Catch:{ Exception -> 0x004a }
            r13 = 13
            r8.setDG(r13, r0)     // Catch:{ Exception -> 0x004a }
            com.fis.ekyc.nfc.build_in.eidparser.DG13FilePersonal r8 = new com.fis.ekyc.nfc.build_in.eidparser.DG13FilePersonal     // Catch:{ Exception -> 0x004a }
            r8.<init>((byte[]) r0)     // Catch:{ Exception -> 0x004a }
            com.fis.ekyc.nfc.build_in.eidparser.IDCardDetail r0 = r8.readContent()     // Catch:{ Exception -> 0x004a }
            r1.personalData = r0     // Catch:{ Exception -> 0x004a }
            androidx.lifecycle.u r0 = r1.processLiveData     // Catch:{ Exception -> 0x004a }
            long r23 = r25.getCurrent()     // Catch:{ Exception -> 0x004a }
            long r23 = r23 - r21
            java.lang.Long r8 = java.lang.Long.valueOf(r23)     // Catch:{ Exception -> 0x004a }
            java.lang.Object[] r8 = new java.lang.Object[]{r8}     // Catch:{ Exception -> 0x004a }
            java.lang.String r8 = java.lang.String.format(r5, r8)     // Catch:{ Exception -> 0x004a }
            r0.m(r8)     // Catch:{ Exception -> 0x004a }
            r14 = 1
            goto L_0x03ad
        L_0x037b:
            r10 = r14
            r13 = 13
            r15 = 2
            byte[] r0 = w4.C0060a.a(r0)     // Catch:{ Exception -> 0x004a }
            com.fis.ekyc.nfc.build_in.model.CardResult r8 = r1._result     // Catch:{ Exception -> 0x004a }
            r14 = 1
            r8.setDG(r14, r0)     // Catch:{ Exception -> 0x004a }
            w4.b$a r8 = w4.C0061b.a     // Catch:{ Exception -> 0x004a }
            android.app.Activity r13 = r1.activity     // Catch:{ Exception -> 0x004a }
            r8.s(r0, r13)     // Catch:{ Exception -> 0x004a }
            androidx.lifecycle.u r0 = r1.processLiveData     // Catch:{ Exception -> 0x004a }
            long r18 = r25.getCurrent()     // Catch:{ Exception -> 0x004a }
            long r18 = r18 - r21
            java.lang.Long r8 = java.lang.Long.valueOf(r18)     // Catch:{ Exception -> 0x004a }
            java.lang.Object[] r8 = new java.lang.Object[]{r8}     // Catch:{ Exception -> 0x004a }
            java.lang.String r8 = java.lang.String.format(r4, r8)     // Catch:{ Exception -> 0x004a }
            r0.m(r8)     // Catch:{ Exception -> 0x004a }
            goto L_0x03ad
        L_0x03a8:
            r10 = r14
            r12 = r24
            goto L_0x0290
        L_0x03ad:
            r14 = r10
            r24 = r12
            goto L_0x0222
        L_0x03b2:
            java.lang.String r3 = TAG
            android.util.Log.e(r3, r2, r0)
            com.fis.ekyc.nfc.build_in.model.CardResult r0 = r1._result
            com.fis.ekyc.nfc.build_in.model.ResultCode r2 = com.fis.ekyc.nfc.build_in.model.ResultCode.CARD_LOST_CONNECTION
            r0.setCode(r2)
        L_0x03be:
            com.fis.ekyc.nfc.build_in.model.CardResult r0 = r1._result
            com.fis.ekyc.nfc.build_in.model.ResultCode r0 = r0.getCode()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fis.ekyc.nfc.build_in.eidparser.ICaoReaderParser.spuorGataDllAdaer():com.fis.ekyc.nfc.build_in.model.ResultCode");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:37|38|39) */
    /* JADX WARNING: Code restructure failed: missing block: B:38:?, code lost:
        android.util.Log.e(TAG, "Unexpected exception during AA signature verification with ECDSA");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0168, code lost:
        return false;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x0161 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean verifyAA(java.security.PublicKey r9, java.lang.String r10, java.lang.String r11, byte[] r12, byte[] r13) {
        /*
            r8 = this;
            r0 = 2
            r1 = 0
            long r2 = r8.getCurrent()
            java.lang.String r4 = r9.getAlgorithm()     // Catch:{ Exception -> 0x0071 }
            java.lang.String r5 = "RSA"
            boolean r5 = r5.equals(r4)     // Catch:{ Exception -> 0x0071 }
            if (r5 == 0) goto L_0x0089
            java.lang.String r2 = TAG     // Catch:{ Exception -> 0x0071 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0071 }
            r3.<init>()     // Catch:{ Exception -> 0x0071 }
            java.lang.String r4 = "Unexpected algorithms for RSA AA: digest algorithm = "
            r3.append(r4)     // Catch:{ Exception -> 0x0071 }
            r3.append(r10)     // Catch:{ Exception -> 0x0071 }
            java.lang.String r4 = ", signature algorithm = "
            r3.append(r4)     // Catch:{ Exception -> 0x0071 }
            r3.append(r11)     // Catch:{ Exception -> 0x0071 }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x0071 }
            android.util.Log.w(r2, r3)     // Catch:{ Exception -> 0x0071 }
            java.security.MessageDigest r10 = java.security.MessageDigest.getInstance(r10)     // Catch:{ Exception -> 0x0071 }
            java.security.Provider r3 = com.fis.ekyc.nfc.build_in.eidparser.ext.JMRTDSecurityProvider.getSpongyCastleProvider()     // Catch:{ Exception -> 0x0071 }
            java.security.Signature r11 = java.security.Signature.getInstance(r11, r3)     // Catch:{ Exception -> 0x0071 }
            java.security.interfaces.RSAPublicKey r9 = (java.security.interfaces.RSAPublicKey) r9     // Catch:{ Exception -> 0x0071 }
            java.lang.String r3 = "RSA/NONE/NoPadding"
            javax.crypto.Cipher r3 = javax.crypto.Cipher.getInstance(r3)     // Catch:{ Exception -> 0x0071 }
            r3.init(r0, r9)     // Catch:{ Exception -> 0x0071 }
            r11.initVerify(r9)     // Catch:{ Exception -> 0x0071 }
            int r9 = r10.getDigestLength()     // Catch:{ Exception -> 0x0071 }
            r10 = 20
            if (r9 == r10) goto L_0x0053
            return r1
        L_0x0053:
            byte[] r10 = r3.doFinal(r13)     // Catch:{ Exception -> 0x0071 }
            byte[] r9 = com.fis.ekyc.nfc.build_in.eidparser.Util.recoverMessage(r9, r10)     // Catch:{ Exception -> 0x0071 }
            r11.update(r9)     // Catch:{ Exception -> 0x0071 }
            r11.update(r12)     // Catch:{ Exception -> 0x0071 }
            boolean r9 = r11.verify(r13)     // Catch:{ Exception -> 0x0071 }
            if (r9 == 0) goto L_0x0074
            com.fis.ekyc.nfc.build_in.model.CardResult r10 = r8._result     // Catch:{ Exception -> 0x0071 }
            java.lang.String r11 = android.util.Base64.encodeToString(r12, r0)     // Catch:{ Exception -> 0x0071 }
            r10.setChallengeBase64(r11)     // Catch:{ Exception -> 0x0071 }
            goto L_0x0074
        L_0x0071:
            r9 = move-exception
            goto L_0x0169
        L_0x0074:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0071 }
            r10.<init>()     // Catch:{ Exception -> 0x0071 }
            java.lang.String r11 = "Verify Active Auth: "
            r10.append(r11)     // Catch:{ Exception -> 0x0071 }
            r10.append(r9)     // Catch:{ Exception -> 0x0071 }
            java.lang.String r10 = r10.toString()     // Catch:{ Exception -> 0x0071 }
            android.util.Log.e(r2, r10)     // Catch:{ Exception -> 0x0071 }
            return r9
        L_0x0089:
            java.lang.String r5 = "EC"
            boolean r5 = r5.equals(r4)     // Catch:{ Exception -> 0x0071 }
            if (r5 != 0) goto L_0x00b0
            java.lang.String r5 = "ECDSA"
            boolean r4 = r5.equals(r4)     // Catch:{ Exception -> 0x0071 }
            if (r4 != 0) goto L_0x00b0
            java.lang.String r10 = TAG     // Catch:{ Exception -> 0x0071 }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0071 }
            r11.<init>()     // Catch:{ Exception -> 0x0071 }
            java.lang.String r12 = "Unsupported AA public key type "
            r11.append(r12)     // Catch:{ Exception -> 0x0071 }
            r11.append(r9)     // Catch:{ Exception -> 0x0071 }
            java.lang.String r9 = r11.toString()     // Catch:{ Exception -> 0x0071 }
            android.util.Log.e(r10, r9)     // Catch:{ Exception -> 0x0071 }
            return r1
        L_0x00b0:
            java.lang.String r4 = "SHA256withECDSA"
            java.security.Provider r5 = com.fis.ekyc.nfc.build_in.eidparser.ext.JMRTDSecurityProvider.getSpongyCastleProvider()     // Catch:{ Exception -> 0x0071 }
            java.security.Signature r4 = java.security.Signature.getInstance(r4, r5)     // Catch:{ Exception -> 0x0071 }
            java.lang.String r5 = "SHA-256"
            java.security.MessageDigest r5 = java.security.MessageDigest.getInstance(r5)     // Catch:{ Exception -> 0x0071 }
            java.security.interfaces.ECPublicKey r9 = (java.security.interfaces.ECPublicKey) r9     // Catch:{ Exception -> 0x0071 }
            if (r4 == 0) goto L_0x00d0
            if (r11 == 0) goto L_0x00ea
            java.lang.String r6 = r4.getAlgorithm()     // Catch:{ Exception -> 0x0071 }
            boolean r6 = r11.equals(r6)     // Catch:{ Exception -> 0x0071 }
            if (r6 != 0) goto L_0x00ea
        L_0x00d0:
            java.lang.String r4 = TAG     // Catch:{ Exception -> 0x0071 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0071 }
            r6.<init>()     // Catch:{ Exception -> 0x0071 }
            java.lang.String r7 = "Re-initializing ecdsaAASignature with signature algorithm "
            r6.append(r7)     // Catch:{ Exception -> 0x0071 }
            r6.append(r11)     // Catch:{ Exception -> 0x0071 }
            java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x0071 }
            android.util.Log.w(r4, r6)     // Catch:{ Exception -> 0x0071 }
            java.security.Signature r4 = java.security.Signature.getInstance(r11)     // Catch:{ Exception -> 0x0071 }
        L_0x00ea:
            if (r10 == 0) goto L_0x010f
            java.lang.String r11 = r5.getAlgorithm()     // Catch:{ Exception -> 0x0071 }
            boolean r11 = r10.equals(r11)     // Catch:{ Exception -> 0x0071 }
            if (r11 != 0) goto L_0x010f
            java.lang.String r11 = TAG     // Catch:{ Exception -> 0x0071 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0071 }
            r5.<init>()     // Catch:{ Exception -> 0x0071 }
            java.lang.String r6 = "Re-initializing ecdsaAADigest with digest algorithm "
            r5.append(r6)     // Catch:{ Exception -> 0x0071 }
            r5.append(r10)     // Catch:{ Exception -> 0x0071 }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x0071 }
            android.util.Log.w(r11, r5)     // Catch:{ Exception -> 0x0071 }
            java.security.MessageDigest.getInstance(r10)     // Catch:{ Exception -> 0x0071 }
        L_0x010f:
            r4.initVerify(r9)     // Catch:{ Exception -> 0x0071 }
            int r9 = r13.length     // Catch:{ Exception -> 0x0071 }
            int r9 = r9 % r0
            if (r9 == 0) goto L_0x011d
            java.lang.String r9 = TAG     // Catch:{ Exception -> 0x0071 }
            java.lang.String r10 = "Active Authentication response is not of even length"
            android.util.Log.w(r9, r10)     // Catch:{ Exception -> 0x0071 }
        L_0x011d:
            int r9 = r13.length     // Catch:{ Exception -> 0x0071 }
            int r9 = r9 / r0
            java.math.BigInteger r10 = com.fis.ekyc.nfc.build_in.eidparser.Util.os2i(r13, r1, r9)     // Catch:{ Exception -> 0x0071 }
            java.math.BigInteger r9 = com.fis.ekyc.nfc.build_in.eidparser.Util.os2i(r13, r9, r9)     // Catch:{ Exception -> 0x0071 }
            r4.update(r12)     // Catch:{ Exception -> 0x0071 }
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERSequence r11 = new com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERSequence     // Catch:{ IOException -> 0x0161 }
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Integer r12 = new com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Integer     // Catch:{ IOException -> 0x0161 }
            r12.<init>((java.math.BigInteger) r10)     // Catch:{ IOException -> 0x0161 }
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Integer r10 = new com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Integer     // Catch:{ IOException -> 0x0161 }
            r10.<init>((java.math.BigInteger) r9)     // Catch:{ IOException -> 0x0161 }
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Encodable[] r9 = new com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Encodable[r0]     // Catch:{ IOException -> 0x0161 }
            r9[r1] = r12     // Catch:{ IOException -> 0x0161 }
            r12 = 1
            r9[r12] = r10     // Catch:{ IOException -> 0x0161 }
            r11.<init>((com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Encodable[]) r9)     // Catch:{ IOException -> 0x0161 }
            androidx.lifecycle.u r9 = r8.processLiveData     // Catch:{ IOException -> 0x0161 }
            java.lang.String r10 = "Verify Active Authentication: %s millis"
            long r12 = r8.getCurrent()     // Catch:{ IOException -> 0x0161 }
            long r12 = r12 - r2
            java.lang.Long r12 = java.lang.Long.valueOf(r12)     // Catch:{ IOException -> 0x0161 }
            java.lang.Object[] r12 = new java.lang.Object[]{r12}     // Catch:{ IOException -> 0x0161 }
            java.lang.String r10 = java.lang.String.format(r10, r12)     // Catch:{ IOException -> 0x0161 }
            r9.m(r10)     // Catch:{ IOException -> 0x0161 }
            byte[] r9 = r11.getEncoded()     // Catch:{ IOException -> 0x0161 }
            boolean r9 = r4.verify(r9)     // Catch:{ IOException -> 0x0161 }
            return r9
        L_0x0161:
            java.lang.String r9 = TAG     // Catch:{ Exception -> 0x0071 }
            java.lang.String r10 = "Unexpected exception during AA signature verification with ECDSA"
            android.util.Log.e(r9, r10)     // Catch:{ Exception -> 0x0071 }
            return r1
        L_0x0169:
            java.lang.String r10 = TAG
            java.lang.String r11 = "Error"
            android.util.Log.e(r10, r11, r9)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fis.ekyc.nfc.build_in.eidparser.ICaoReaderParser.verifyAA(java.security.PublicKey, java.lang.String, java.lang.String, byte[], byte[]):boolean");
    }

    public boolean hashCheck(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5) {
        try {
            MessageDigest instance = MessageDigest.getInstance(this._sodFile.getDigestAlgorithm());
            Map<Integer, byte[]> dataGroupHashes = this._sodFile.getDataGroupHashes();
            if (Arrays.equals(instance.digest(bArr), dataGroupHashes.get(1)) && Arrays.equals(instance.digest(bArr2), dataGroupHashes.get(2)) && Arrays.equals(instance.digest(bArr3), dataGroupHashes.get(13)) && Arrays.equals(instance.digest(bArr4), dataGroupHashes.get(14))) {
                return Arrays.equals(instance.digest(bArr5), dataGroupHashes.get(15));
            }
            return false;
        } catch (Exception e) {
            Log.e("Has Check", "There is an error", e);
            return false;
        }
    }

    public CardResult readData(CardService cardService, String str, String str2, String str3, boolean z, boolean z2, boolean z3, u uVar, Activity activity2) {
        this.activity = activity2;
        this.birthDate = str2;
        this.expiredDate = str3;
        return readData(cardService, str, z, z2, z3, uVar);
    }

    public CardResult readData(CardService cardService, String str, boolean z, boolean z2, boolean z3, u uVar) {
        u uVar2 = uVar;
        this._result = new CardResult();
        this.processLiveData = uVar2;
        if (TextUtils.isEmpty(str) || str.length() != 12) {
            this._result.setCode(ResultCode.WRONG_CITIZEN_ID_CARD);
            return this._result;
        }
        try {
            String str2 = TAG;
            Log.d(str2, "Open card service...");
            long current = getCurrent();
            cardService.open();
            this._card = cardService;
            uVar2.m(String.format("Open card service: %s millis", new Object[]{Long.valueOf(getCurrent() - current)}));
            Log.d(str2, String.format("Open card service: %s millis", new Object[]{Long.valueOf(getCurrent() - current)}));
            try {
                long current2 = getCurrent();
                Log.d(str2, "Open passport service...");
                IdCardService idCardService = new IdCardService(cardService, 256, 65536, false, false);
                idCardService.open();
                this._service = idCardService;
                uVar2.m(String.format("Open passport service: %s millis", new Object[]{Long.valueOf(getCurrent() - current2)}));
                Log.d(str2, String.format("Open passport service: %s millis", new Object[]{Long.valueOf(getCurrent() - current2)}));
                this._cccdId = str;
                this._result.setCode(ecapod());
                ResultCode code = this._result.getCode();
                ResultCode resultCode = ResultCode.SUCCESS;
                if (code != resultCode) {
                    closeALl();
                    return this._result;
                }
                if (spuorGataDllAdaer() == resultCode) {
                    if (z2) {
                        if (chipAuthentication() != resultCode) {
                            this._result.setChipCheck(CheckingCode.FAILED);
                        } else {
                            this._result.setChipCheck(CheckingCode.PASS);
                        }
                    }
                    if (z3) {
                        if (activeAuthentication() != resultCode) {
                            this._result.setActiveCheck(CheckingCode.FAILED);
                        } else {
                            this._result.setActiveCheck(CheckingCode.PASS);
                        }
                    }
                    if (z) {
                        this.personalData.setHash_check(hashCheck(this._result.getDG(1), this._result.getDG(2), this._result.getDG(13), this._result.getDG(14), this._result.getDG(15)));
                    }
                    this._result.setPersonalDetail(this.personalData);
                    closeALl();
                }
                return this._result;
            } catch (Exception e) {
                this._result.setCode(ResultCode.CARD_NOT_FOUND);
                closeALl();
                String str3 = TAG;
                Log.d(str3, "Exception: " + e.getMessage());
                return this._result;
            }
        } catch (Exception e2) {
            this._result.setCode(ResultCode.CANNOT_OPEN_DEVICE);
            String str4 = TAG;
            Log.d(str4, "Exception: " + e2.getMessage());
            return this._result;
        }
    }
}
