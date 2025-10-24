package com.fis.ekyc.nfc.build_in.eidparser;

import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.jcajce.spec.McElieceCCA2KeyGenParameterSpec;
import com.fis.ekyc.nfc.build_in.mrz.MrzParser;
import java.security.GeneralSecurityException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BACKey implements BACKeySpec {
    private static final String SDF = "yyMMdd";
    private static final long serialVersionUID = -1059774581180524710L;
    private String dateOfBirth;
    private String dateOfExpiry;
    private String documentNumber;

    public BACKey() {
    }

    public boolean equals(Object obj) {
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        BACKey bACKey = (BACKey) obj;
        if (!this.documentNumber.equals(bACKey.documentNumber) || !this.dateOfBirth.equals(bACKey.dateOfBirth) || !this.dateOfExpiry.equals(bACKey.dateOfExpiry)) {
            return false;
        }
        return true;
    }

    public String getAlgorithm() {
        return "BAC";
    }

    public String getDateOfBirth() {
        return this.dateOfBirth;
    }

    public String getDateOfExpiry() {
        return this.dateOfExpiry;
    }

    public String getDocumentNumber() {
        return this.documentNumber;
    }

    public byte[] getKey() {
        try {
            return Util.computeKeySeed(this.documentNumber, this.dateOfBirth, this.dateOfExpiry, McElieceCCA2KeyGenParameterSpec.SHA1, true);
        } catch (GeneralSecurityException e) {
            throw new IllegalArgumentException("Unexpected exception", e);
        }
    }

    public int hashCode() {
        int i;
        int i2;
        String str = this.documentNumber;
        int i3 = 0;
        if (str == null) {
            i = 0;
        } else {
            i = str.hashCode();
        }
        int i4 = (305 + i) * 61;
        String str2 = this.dateOfBirth;
        if (str2 == null) {
            i2 = 0;
        } else {
            i2 = str2.hashCode();
        }
        int i5 = (i4 + i2) * 61;
        String str3 = this.dateOfExpiry;
        if (str3 != null) {
            i3 = str3.hashCode();
        }
        return i5 + i3;
    }

    public void setDateOfBirth(String str) {
        this.dateOfBirth = str;
    }

    public void setDateOfExpiry(String str) {
        this.dateOfExpiry = str;
    }

    public void setDocumentNumber(String str) {
        this.documentNumber = str;
    }

    public String toString() {
        return this.documentNumber + ", " + this.dateOfBirth + ", " + this.dateOfExpiry;
    }

    public BACKey(String str, Date date, Date date2) {
        this(str, toString(date), toString(date2));
    }

    private static synchronized String toString(Date date) {
        String format;
        synchronized (BACKey.class) {
            format = new SimpleDateFormat(SDF).format(date);
        }
        return format;
    }

    public BACKey(String str, String str2, String str3) {
        if (str == null) {
            throw new IllegalArgumentException("Illegal document number");
        } else if (str2 == null || str2.length() != 6) {
            throw new IllegalArgumentException("Illegal date: " + str2);
        } else if (str3 == null || str3.length() != 6) {
            throw new IllegalArgumentException("Illegal date: " + str3);
        } else {
            StringBuilder sb2 = new StringBuilder(str);
            while (sb2.length() < 9) {
                sb2.append(MrzParser.FILLER);
            }
            this.documentNumber = sb2.toString().trim();
            this.dateOfBirth = str2;
            this.dateOfExpiry = str3;
        }
    }
}
