package com.fis.ekyc.nfc.build_in.eidparser;

import com.fis.ekyc.nfc.build_in.utils.IOUtils;
import com.fis.ekyc.nfc.build_in.utils.StringUtil;
import java.io.IOException;
import java.io.InputStream;

public class DG13FilePersonal {
    private static final String CCCD_NUMBER_TAG = "0113";
    private static final String CMND_NUMBER_TAG = "0F13";
    private static final String DATE_EXPIRATION_TAG = "02010C0C";
    private static final String DATE_OF_BIRTH_TAG = "300F02010313";
    private static final String DATE_RANGE_TAG = "0B13";
    private static final String DISTRICT_TAG = "080C";
    private static final int FATHER_NAME_TAG_LEN = 16;
    private static final String GENDER_TAG = "040C";
    private static final int HUSBAND_WIFE_NAME_TAG_LEN = 16;
    private static final String IDENTIFY_CHARACTER_TAG = "0A0C";
    private static final int MOTHER_NAME_TAG_LEN = 6;
    private static final String NAME_PERSONAL_TAG = "020C";
    private static final String NATIONALITY_TAG = "050C";
    private static final String NATION_TAG = "060C";
    private static final String PERMANENT_ADDRESS_TAG = "090C";
    private static final String RELATIVE_END_TAG = "30323934";
    private static final String RELATIVE_START_TAG = "02010C0C";
    private static final String RELIGION_TAG = "070C";
    private String allHex;
    private int countFatherName;
    private int countMotherName;
    private String fatherNameHex;
    private String motherNameHex;

    public DG13FilePersonal(InputStream inputStream) throws IOException {
        this.allHex = StringUtil.bytesToHex(IOUtils.toByteArray(inputStream));
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(22:0|1|2|3|4|(1:6)(1:9)|10|11|(1:13)(1:16)|17|18|(1:20)(1:22)|23|24|(1:28)|30|31|32|33|34|35|36) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:34:0x0106 */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:30:0x00f0=Splitter:B:30:0x00f0, B:49:0x0194=Splitter:B:49:0x0194, B:34:0x0106=Splitter:B:34:0x0106} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.fis.ekyc.nfc.build_in.eidparser.IDCardDetail readContent() {
        /*
            r11 = this;
            java.lang.String r0 = "02010C0C"
            java.lang.String r1 = "DG13File.readContent()"
            java.lang.String r2 = "0F13"
            java.lang.String r3 = ""
            com.fis.ekyc.nfc.build_in.eidparser.IDCardDetail r4 = new com.fis.ekyc.nfc.build_in.eidparser.IDCardDetail     // Catch:{ Exception -> 0x010a }
            r4.<init>()     // Catch:{ Exception -> 0x010a }
            java.lang.String r5 = r11.allHex     // Catch:{ Exception -> 0x010a }
            java.lang.String r6 = "0113"
            java.lang.String r5 = r11.readObject(r5, r6)     // Catch:{ Exception -> 0x010a }
            r4.setCitizenPid(r5)     // Catch:{ Exception -> 0x010a }
            java.lang.String r5 = r11.allHex     // Catch:{ Exception -> 0x010a }
            java.lang.String r6 = "020C"
            java.lang.String r5 = r11.readObject(r5, r6)     // Catch:{ Exception -> 0x010a }
            r4.setFullName(r5)     // Catch:{ Exception -> 0x010a }
            java.lang.String r5 = r11.allHex     // Catch:{ Exception -> 0x010a }
            java.lang.String r6 = "300F02010313"
            java.lang.String r5 = r11.readObject(r5, r6)     // Catch:{ Exception -> 0x010a }
            r4.setBirthDate(r5)     // Catch:{ Exception -> 0x010a }
            java.lang.String r5 = r11.allHex     // Catch:{ Exception -> 0x010a }
            java.lang.String r6 = "040C"
            java.lang.String r5 = r11.readObject(r5, r6)     // Catch:{ Exception -> 0x010a }
            r4.setGender(r5)     // Catch:{ Exception -> 0x010a }
            java.lang.String r5 = r11.allHex     // Catch:{ Exception -> 0x010a }
            java.lang.String r6 = "050C"
            java.lang.String r5 = r11.readObject(r5, r6)     // Catch:{ Exception -> 0x010a }
            r4.setNationality(r5)     // Catch:{ Exception -> 0x010a }
            java.lang.String r5 = r11.allHex     // Catch:{ Exception -> 0x010a }
            java.lang.String r6 = "060C"
            java.lang.String r5 = r11.readObject(r5, r6)     // Catch:{ Exception -> 0x010a }
            r4.setEthnic(r5)     // Catch:{ Exception -> 0x010a }
            java.lang.String r5 = r11.allHex     // Catch:{ Exception -> 0x010a }
            java.lang.String r6 = "070C"
            java.lang.String r5 = r11.readObject(r5, r6)     // Catch:{ Exception -> 0x010a }
            r4.setReligion(r5)     // Catch:{ Exception -> 0x010a }
            java.lang.String r5 = r11.allHex     // Catch:{ Exception -> 0x010a }
            java.lang.String r6 = "080C"
            java.lang.String r5 = r11.readObject(r5, r6)     // Catch:{ Exception -> 0x010a }
            r4.setHomeTown(r5)     // Catch:{ Exception -> 0x010a }
            java.lang.String r5 = r11.allHex     // Catch:{ Exception -> 0x010a }
            java.lang.String r6 = "090C"
            java.lang.String r5 = r11.readObject(r5, r6)     // Catch:{ Exception -> 0x010a }
            r4.setRegPlaceAddress(r5)     // Catch:{ Exception -> 0x010a }
            java.lang.String r5 = r11.allHex     // Catch:{ Exception -> 0x010a }
            java.lang.String r6 = "0A0C"
            java.lang.String r5 = r11.readObject(r5, r6)     // Catch:{ Exception -> 0x010a }
            r4.setIdentifyCharacteristics(r5)     // Catch:{ Exception -> 0x010a }
            java.lang.String r5 = r11.allHex     // Catch:{ Exception -> 0x010a }
            java.lang.String r6 = "0B13"
            java.lang.String r5 = r11.readObject(r5, r6)     // Catch:{ Exception -> 0x010a }
            r4.setDateProvide(r5)     // Catch:{ Exception -> 0x010a }
            java.lang.String r5 = r11.allHex     // Catch:{ Exception -> 0x010a }
            java.lang.String r5 = r11.readObject(r5, r0)     // Catch:{ Exception -> 0x010a }
            r4.setOutOfDate(r5)     // Catch:{ Exception -> 0x010a }
            java.lang.String r5 = r11.allHex     // Catch:{ Exception -> 0x00b6 }
            java.lang.String r6 = "30323934"
            java.lang.String r0 = r11.readRelative(r5, r0, r6)     // Catch:{ Exception -> 0x00b6 }
            java.lang.String r0 = com.fis.ekyc.nfc.build_in.utils.StringUtil.hexToUTF8(r0)     // Catch:{ Exception -> 0x00b6 }
            java.lang.String r0 = r11.replaceSpecialUTF8(r0)     // Catch:{ Exception -> 0x00b6 }
            java.io.PrintStream r5 = java.lang.System.out     // Catch:{ Exception -> 0x00b6 }
            r5.println(r0)     // Catch:{ Exception -> 0x00b6 }
            java.lang.String r5 = "0"
            java.lang.String[] r0 = r0.split(r5)     // Catch:{ Exception -> 0x00b6 }
            int r5 = r0.length     // Catch:{ Exception -> 0x00b6 }
            r6 = 2
            if (r5 < r6) goto L_0x00ba
            r5 = 1
            r5 = r0[r5]     // Catch:{ Exception -> 0x00b6 }
            java.lang.String r5 = r11.replaceSpecialUTF8(r5)     // Catch:{ Exception -> 0x00b6 }
            goto L_0x00bb
        L_0x00b6:
            r0 = move-exception
            r6 = r3
            goto L_0x0194
        L_0x00ba:
            r5 = r3
        L_0x00bb:
            int r7 = r0.length     // Catch:{ Exception -> 0x00c6 }
            r8 = 3
            if (r7 < r8) goto L_0x00ca
            r6 = r0[r6]     // Catch:{ Exception -> 0x00c6 }
            java.lang.String r6 = r11.replaceSpecialUTF8(r6)     // Catch:{ Exception -> 0x00c6 }
            goto L_0x00cb
        L_0x00c6:
            r0 = move-exception
            r6 = r3
            goto L_0x0168
        L_0x00ca:
            r6 = r3
        L_0x00cb:
            int r7 = r0.length     // Catch:{ Exception -> 0x00d6 }
            r9 = 4
            if (r7 < r9) goto L_0x00d8
            r7 = r0[r8]     // Catch:{ Exception -> 0x00d6 }
            java.lang.String r7 = r11.replaceSpecialUTF8(r7)     // Catch:{ Exception -> 0x00d6 }
            goto L_0x00d9
        L_0x00d6:
            r0 = move-exception
            goto L_0x013b
        L_0x00d8:
            r7 = r3
        L_0x00d9:
            int r8 = r0.length     // Catch:{ Exception -> 0x00ee }
            r10 = 5
            if (r8 < r10) goto L_0x00f0
            java.lang.String r8 = r7.trim()     // Catch:{ Exception -> 0x00ee }
            boolean r8 = r8.equals(r3)     // Catch:{ Exception -> 0x00ee }
            if (r8 == 0) goto L_0x00f0
            r0 = r0[r9]     // Catch:{ Exception -> 0x00ee }
            java.lang.String r7 = r11.replaceSpecialUTF8(r0)     // Catch:{ Exception -> 0x00ee }
            goto L_0x00f0
        L_0x00ee:
            r0 = move-exception
            goto L_0x010d
        L_0x00f0:
            r4.setFatherName(r5)     // Catch:{ Exception -> 0x010a }
            r4.setMotherName(r6)     // Catch:{ Exception -> 0x010a }
            r4.setWifeName(r7)     // Catch:{ Exception -> 0x010a }
            r4.setHusBandName(r7)     // Catch:{ Exception -> 0x010a }
            java.lang.String r0 = r11.allHex     // Catch:{ Exception -> 0x0106 }
            java.lang.String r0 = r11.readObject(r0, r2)     // Catch:{ Exception -> 0x0106 }
            r4.setOldIdentify(r0)     // Catch:{ Exception -> 0x0106 }
            goto L_0x0109
        L_0x0106:
            r4.setOldIdentify(r3)     // Catch:{ Exception -> 0x010a }
        L_0x0109:
            return r4
        L_0x010a:
            r0 = move-exception
            goto L_0x01c0
        L_0x010d:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0139 }
            r8.<init>()     // Catch:{ Exception -> 0x0139 }
            r8.append(r3)     // Catch:{ Exception -> 0x0139 }
            java.lang.String r0 = r0.getMessage()     // Catch:{ Exception -> 0x0139 }
            r8.append(r0)     // Catch:{ Exception -> 0x0139 }
            java.lang.String r0 = r8.toString()     // Catch:{ Exception -> 0x0139 }
            android.util.Log.w(r1, r0)     // Catch:{ Exception -> 0x0139 }
            r4.setFatherName(r5)     // Catch:{ Exception -> 0x0139 }
            r4.setMotherName(r6)     // Catch:{ Exception -> 0x0139 }
            r4.setWifeName(r7)     // Catch:{ Exception -> 0x0139 }
            r4.setHusBandName(r7)     // Catch:{ Exception -> 0x0139 }
            java.lang.String r0 = r11.allHex     // Catch:{ Exception -> 0x0139 }
            java.lang.String r0 = r11.readObject(r0, r2)     // Catch:{ Exception -> 0x0139 }
            r4.setOldIdentify(r0)     // Catch:{ Exception -> 0x0139 }
            return r4
        L_0x0139:
            r0 = move-exception
            goto L_0x0194
        L_0x013b:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0167 }
            r7.<init>()     // Catch:{ Exception -> 0x0167 }
            java.lang.String r0 = r0.getMessage()     // Catch:{ Exception -> 0x0167 }
            r7.append(r0)     // Catch:{ Exception -> 0x0167 }
            r7.append(r3)     // Catch:{ Exception -> 0x0167 }
            java.lang.String r0 = r7.toString()     // Catch:{ Exception -> 0x0167 }
            android.util.Log.w(r1, r0)     // Catch:{ Exception -> 0x0167 }
            r4.setFatherName(r5)     // Catch:{ Exception -> 0x0167 }
            r4.setMotherName(r6)     // Catch:{ Exception -> 0x0167 }
            r4.setWifeName(r3)     // Catch:{ Exception -> 0x0167 }
            r4.setHusBandName(r3)     // Catch:{ Exception -> 0x0167 }
            java.lang.String r0 = r11.allHex     // Catch:{ Exception -> 0x0167 }
            java.lang.String r0 = r11.readObject(r0, r2)     // Catch:{ Exception -> 0x0167 }
            r4.setOldIdentify(r0)     // Catch:{ Exception -> 0x0167 }
            return r4
        L_0x0167:
            r0 = move-exception
        L_0x0168:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0139 }
            r7.<init>()     // Catch:{ Exception -> 0x0139 }
            r7.append(r3)     // Catch:{ Exception -> 0x0139 }
            java.lang.String r0 = r0.getMessage()     // Catch:{ Exception -> 0x0139 }
            r7.append(r0)     // Catch:{ Exception -> 0x0139 }
            java.lang.String r0 = r7.toString()     // Catch:{ Exception -> 0x0139 }
            android.util.Log.w(r1, r0)     // Catch:{ Exception -> 0x0139 }
            r4.setFatherName(r5)     // Catch:{ Exception -> 0x0139 }
            r4.setMotherName(r6)     // Catch:{ Exception -> 0x0139 }
            r4.setWifeName(r6)     // Catch:{ Exception -> 0x0139 }
            r4.setHusBandName(r6)     // Catch:{ Exception -> 0x0139 }
            java.lang.String r0 = r11.allHex     // Catch:{ Exception -> 0x0139 }
            java.lang.String r0 = r11.readObject(r0, r2)     // Catch:{ Exception -> 0x0139 }
            r4.setOldIdentify(r0)     // Catch:{ Exception -> 0x0139 }
            return r4
        L_0x0194:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x010a }
            r5.<init>()     // Catch:{ Exception -> 0x010a }
            r5.append(r3)     // Catch:{ Exception -> 0x010a }
            java.lang.String r0 = r0.getMessage()     // Catch:{ Exception -> 0x010a }
            r5.append(r0)     // Catch:{ Exception -> 0x010a }
            java.lang.String r0 = r5.toString()     // Catch:{ Exception -> 0x010a }
            android.util.Log.w(r1, r0)     // Catch:{ Exception -> 0x010a }
            r4.setFatherName(r3)     // Catch:{ Exception -> 0x010a }
            r4.setMotherName(r6)     // Catch:{ Exception -> 0x010a }
            r4.setWifeName(r6)     // Catch:{ Exception -> 0x010a }
            r4.setHusBandName(r6)     // Catch:{ Exception -> 0x010a }
            java.lang.String r0 = r11.allHex     // Catch:{ Exception -> 0x010a }
            java.lang.String r0 = r11.readObject(r0, r2)     // Catch:{ Exception -> 0x010a }
            r4.setOldIdentify(r0)     // Catch:{ Exception -> 0x010a }
            return r4
        L_0x01c0:
            java.lang.Class<com.fis.ekyc.nfc.build_in.eidparser.DG13FilePersonal> r1 = com.fis.ekyc.nfc.build_in.eidparser.DG13FilePersonal.class
            java.lang.String r1 = r1.getName()
            java.util.logging.Logger r1 = java.util.logging.Logger.getLogger(r1)
            java.util.logging.Level r2 = java.util.logging.Level.SEVERE
            r3 = 0
            r1.log(r2, r3, r0)
            com.fis.ekyc.nfc.build_in.eidparser.IDCardDetail r0 = new com.fis.ekyc.nfc.build_in.eidparser.IDCardDetail
            r0.<init>()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fis.ekyc.nfc.build_in.eidparser.DG13FilePersonal.readContent():com.fis.ekyc.nfc.build_in.eidparser.IDCardDetail");
    }

    public String readFatherName(String str, int i, String str2) throws Exception {
        if (str.length() == 0 || str2.length() == 0 || i <= 0 || !str.contains(str2)) {
            return null;
        }
        int parseInt = Integer.parseInt(StringUtil.cutTLVString(str, str2), 16) * 2;
        int indexOf = str.indexOf(str.substring(StringUtil.indexOfTagWithLength(str, str2), StringUtil.indexOfTagWithLength(str, str2) + parseInt)) + parseInt + i;
        int i2 = indexOf + 2;
        int parseInt2 = Integer.parseInt(str.substring(indexOf, i2), 16);
        this.countFatherName = parseInt2;
        String substring = str.substring(i2, (parseInt2 * 2) + i2);
        this.fatherNameHex = substring;
        return StringUtil.hexToUTF8(substring);
    }

    public String readHusbandAndWifeName(String str, int i, String str2) throws Exception {
        if (str2.length() <= 2) {
            str2 = this.fatherNameHex;
            i = 54;
        }
        int indexOf = str.indexOf(str2) + (this.countMotherName * 2) + i;
        int i2 = indexOf + 2;
        return StringUtil.hexToUTF8(str.substring(i2, (Integer.parseInt(str.substring(indexOf, i2), 16) * 2) + i2));
    }

    public String readMotherName(String str, int i, String str2) throws Exception {
        int indexOf = str.indexOf(str2) + (this.countFatherName * 2) + i;
        int i2 = indexOf + 2;
        int parseInt = Integer.parseInt(str.substring(indexOf, i2), 16);
        this.countMotherName = parseInt;
        String substring = str.substring(i2, (parseInt * 2) + i2);
        this.motherNameHex = substring;
        if (substring == null || substring.length() <= 2) {
            return null;
        }
        return StringUtil.hexToUTF8(this.motherNameHex);
    }

    public String readObject(String str, String str2) throws Exception {
        if (str.length() == 0 || str2.length() == 0 || !str.contains(str2)) {
            return null;
        }
        return StringUtil.hexToUTF8(str.substring(StringUtil.indexOfTagWithLength(str, str2), StringUtil.indexOfTagWithLength(str, str2) + (Integer.parseInt(StringUtil.cutTLVString(str, str2), 16) * 2)));
    }

    public String readRelative(String str, String str2, String str3) throws Exception {
        if (str.length() == 0 || str2.length() == 0 || str3.length() == 0 || !str.contains(str2) || !str.contains(str3)) {
            return null;
        }
        String[] split = str.substring(str.indexOf(str2), str.indexOf(str3)).split("0201");
        return split[2] + "0201" + split[3];
    }

    public String replaceSpecialUTF8(String str) {
        for (char valueOf : str.toCharArray()) {
            String valueOf2 = String.valueOf(valueOf);
            if ("0123456789qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNMăâđêôơưàảãạáằẳẵặắầẩẫậấèẻẽẹéềểễệếìỉĩịíòỏõọóồổỗộốờởỡợớùủũụúừửữựứỳỷỹỵýĂÂĐÊÔƠƯÀẢÃẠÁẰẲẴẶẮẦẨẪẬẤÈẺẼẸÉỀỂỄỆẾÌỈĨỊÍÒỎÕỌÓỒỔỖỘỐỜỞỠỢỚÙỦŨỤÚỪỬỮỰỨỲỶỸỴÝ'/,.\":;() ".indexOf(valueOf2) == -1) {
                str = str.replace(valueOf2, "");
            }
        }
        return str;
    }

    public DG13FilePersonal() {
    }

    public DG13FilePersonal(byte[] bArr) throws IOException {
        this.allHex = StringUtil.bytesToHex(bArr);
    }
}
