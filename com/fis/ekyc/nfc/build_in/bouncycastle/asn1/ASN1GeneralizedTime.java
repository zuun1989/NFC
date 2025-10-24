package com.fis.ekyc.nfc.build_in.bouncycastle.asn1;

import com.fis.ekyc.nfc.build_in.bouncycastle.util.Arrays;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.Strings;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.SimpleTimeZone;
import java.util.TimeZone;

public class ASN1GeneralizedTime extends ASN1Primitive {
    protected byte[] time;

    public ASN1GeneralizedTime(String str) {
        this.time = Strings.toByteArray(str);
        try {
            getDate();
        } catch (ParseException e) {
            throw new IllegalArgumentException("invalid date string: " + e.getMessage());
        }
    }

    private SimpleDateFormat calculateGMTDateFormat() {
        SimpleDateFormat simpleDateFormat;
        if (hasFractionalSeconds()) {
            simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss.SSSz");
        } else if (hasSeconds()) {
            simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmssz");
        } else if (hasMinutes()) {
            simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmz");
        } else {
            simpleDateFormat = new SimpleDateFormat("yyyyMMddHHz");
        }
        simpleDateFormat.setTimeZone(new SimpleTimeZone(0, "Z"));
        return simpleDateFormat;
    }

    private String calculateGMTOffset(String str) {
        String str2;
        int i;
        TimeZone timeZone = TimeZone.getDefault();
        int rawOffset = timeZone.getRawOffset();
        if (rawOffset < 0) {
            rawOffset = -rawOffset;
            str2 = "-";
        } else {
            str2 = "+";
        }
        int i2 = rawOffset / 3600000;
        int i3 = (rawOffset - (3600000 * i2)) / 60000;
        try {
            if (timeZone.useDaylightTime()) {
                if (hasFractionalSeconds()) {
                    str = pruneFractionalSeconds(str);
                }
                SimpleDateFormat calculateGMTDateFormat = calculateGMTDateFormat();
                if (timeZone.inDaylightTime(calculateGMTDateFormat.parse(str + "GMT" + str2 + convert(i2) + ":" + convert(i3)))) {
                    if (str2.equals("+")) {
                        i = 1;
                    } else {
                        i = -1;
                    }
                    i2 += i;
                }
            }
        } catch (ParseException unused) {
        }
        return "GMT" + str2 + convert(i2) + ":" + convert(i3);
    }

    private String convert(int i) {
        if (i >= 10) {
            return Integer.toString(i);
        }
        return "0" + i;
    }

    public static ASN1GeneralizedTime getInstance(Object obj) {
        if (obj == null || (obj instanceof ASN1GeneralizedTime)) {
            return (ASN1GeneralizedTime) obj;
        }
        if (obj instanceof byte[]) {
            try {
                return (ASN1GeneralizedTime) ASN1Primitive.fromByteArray((byte[]) obj);
            } catch (Exception e) {
                throw new IllegalArgumentException("encoding error in getInstance: " + e.toString());
            }
        } else {
            throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
        }
    }

    private boolean isDigit(int i) {
        byte b;
        byte[] bArr = this.time;
        if (bArr.length <= i || (b = bArr[i]) < 48 || b > 57) {
            return false;
        }
        return true;
    }

    private String pruneFractionalSeconds(String str) {
        String substring = str.substring(14);
        int i = 1;
        while (i < substring.length() && '0' <= (r4 = substring.charAt(i)) && r4 <= '9') {
            i++;
        }
        int i2 = i - 1;
        if (i2 > 3) {
            return str.substring(0, 14) + (substring.substring(0, 4) + substring.substring(i));
        } else if (i2 == 1) {
            return str.substring(0, 14) + (substring.substring(0, i) + "00" + substring.substring(i));
        } else if (i2 != 2) {
            return str;
        } else {
            return str.substring(0, 14) + (substring.substring(0, i) + "0" + substring.substring(i));
        }
    }

    public boolean asn1Equals(ASN1Primitive aSN1Primitive) {
        if (!(aSN1Primitive instanceof ASN1GeneralizedTime)) {
            return false;
        }
        return Arrays.areEqual(this.time, ((ASN1GeneralizedTime) aSN1Primitive).time);
    }

    public void encode(ASN1OutputStream aSN1OutputStream, boolean z) throws IOException {
        aSN1OutputStream.writeEncoded(z, 24, this.time);
    }

    public int encodedLength() {
        int length = this.time.length;
        return StreamUtil.calculateBodyLength(length) + 1 + length;
    }

    public Date getDate() throws ParseException {
        SimpleDateFormat simpleDateFormat;
        SimpleDateFormat simpleDateFormat2;
        String fromByteArray = Strings.fromByteArray(this.time);
        if (fromByteArray.endsWith("Z")) {
            if (hasFractionalSeconds()) {
                simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss.SSS'Z'");
            } else if (hasSeconds()) {
                simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss'Z'");
            } else if (hasMinutes()) {
                simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmm'Z'");
            } else {
                simpleDateFormat = new SimpleDateFormat("yyyyMMddHH'Z'");
            }
            simpleDateFormat.setTimeZone(new SimpleTimeZone(0, "Z"));
        } else if (fromByteArray.indexOf(45) > 0 || fromByteArray.indexOf(43) > 0) {
            fromByteArray = getTime();
            simpleDateFormat = calculateGMTDateFormat();
        } else {
            if (hasFractionalSeconds()) {
                simpleDateFormat2 = new SimpleDateFormat("yyyyMMddHHmmss.SSS");
            } else if (hasSeconds()) {
                simpleDateFormat2 = new SimpleDateFormat("yyyyMMddHHmmss");
            } else if (hasMinutes()) {
                simpleDateFormat2 = new SimpleDateFormat("yyyyMMddHHmm");
            } else {
                simpleDateFormat2 = new SimpleDateFormat("yyyyMMddHH");
            }
            simpleDateFormat = simpleDateFormat2;
            simpleDateFormat.setTimeZone(new SimpleTimeZone(0, TimeZone.getDefault().getID()));
        }
        if (hasFractionalSeconds()) {
            fromByteArray = pruneFractionalSeconds(fromByteArray);
        }
        return DateUtil.epochAdjust(simpleDateFormat.parse(fromByteArray));
    }

    public String getTime() {
        String fromByteArray = Strings.fromByteArray(this.time);
        if (fromByteArray.charAt(fromByteArray.length() - 1) == 'Z') {
            return fromByteArray.substring(0, fromByteArray.length() - 1) + "GMT+00:00";
        }
        int length = fromByteArray.length();
        char charAt = fromByteArray.charAt(length - 6);
        if ((charAt == '-' || charAt == '+') && fromByteArray.indexOf("GMT") == length - 9) {
            return fromByteArray;
        }
        int length2 = fromByteArray.length();
        int i = length2 - 5;
        char charAt2 = fromByteArray.charAt(i);
        if (charAt2 == '-' || charAt2 == '+') {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(fromByteArray.substring(0, i));
            sb2.append("GMT");
            int i2 = length2 - 2;
            sb2.append(fromByteArray.substring(i, i2));
            sb2.append(":");
            sb2.append(fromByteArray.substring(i2));
            return sb2.toString();
        }
        int length3 = fromByteArray.length() - 3;
        char charAt3 = fromByteArray.charAt(length3);
        if (charAt3 == '-' || charAt3 == '+') {
            return fromByteArray.substring(0, length3) + "GMT" + fromByteArray.substring(length3) + ":00";
        }
        return fromByteArray + calculateGMTOffset(fromByteArray);
    }

    public String getTimeString() {
        return Strings.fromByteArray(this.time);
    }

    public boolean hasFractionalSeconds() {
        int i = 0;
        while (true) {
            byte[] bArr = this.time;
            if (i == bArr.length) {
                return false;
            }
            if (bArr[i] == 46 && i == 14) {
                return true;
            }
            i++;
        }
    }

    public boolean hasMinutes() {
        if (!isDigit(10) || !isDigit(11)) {
            return false;
        }
        return true;
    }

    public boolean hasSeconds() {
        if (!isDigit(12) || !isDigit(13)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Arrays.hashCode(this.time);
    }

    public boolean isConstructed() {
        return false;
    }

    public ASN1Primitive toDERObject() {
        return new DERGeneralizedTime(this.time);
    }

    public ASN1Primitive toDLObject() {
        return new DERGeneralizedTime(this.time);
    }

    public ASN1GeneralizedTime(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss'Z'", DateUtil.EN_Locale);
        simpleDateFormat.setTimeZone(new SimpleTimeZone(0, "Z"));
        this.time = Strings.toByteArray(simpleDateFormat.format(date));
    }

    public static ASN1GeneralizedTime getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        ASN1Primitive object = aSN1TaggedObject.getObject();
        if (z || (object instanceof ASN1GeneralizedTime)) {
            return getInstance(object);
        }
        return new ASN1GeneralizedTime(ASN1OctetString.getInstance(object).getOctets());
    }

    public ASN1GeneralizedTime(Date date, Locale locale) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss'Z'", locale);
        simpleDateFormat.setTimeZone(new SimpleTimeZone(0, "Z"));
        this.time = Strings.toByteArray(simpleDateFormat.format(date));
    }

    public ASN1GeneralizedTime(byte[] bArr) {
        if (bArr.length >= 4) {
            this.time = bArr;
            if (!isDigit(0) || !isDigit(1) || !isDigit(2) || !isDigit(3)) {
                throw new IllegalArgumentException("illegal characters in GeneralizedTime string");
            }
            return;
        }
        throw new IllegalArgumentException("GeneralizedTime string too short");
    }
}
