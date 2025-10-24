package com.fis.ekyc.nfc.build_in.mrz;

import com.fis.ekyc.nfc.build_in.mrz.types.MrzDate;
import com.fis.ekyc.nfc.build_in.mrz.types.MrzDocumentCode;
import com.fis.ekyc.nfc.build_in.mrz.types.MrzFormat;
import com.fis.ekyc.nfc.build_in.mrz.types.MrzSex;
import java.io.Serializable;

public abstract class MrzRecord implements Serializable {
    public MrzDocumentCode code;
    public char code1;
    public char code2;
    public MrzDate dateOfBirth;
    public String documentNumber;
    public MrzDate expirationDate;
    public final MrzFormat format;
    public String givenNames;
    public String issuingCountry;
    public String nationality;
    public MrzSex sex;
    public String surname;
    public boolean validComposite = true;
    public boolean validDateOfBirth = true;
    public boolean validDocumentNumber = true;
    public boolean validExpirationDate = true;

    public MrzRecord(MrzFormat mrzFormat) {
        this.format = mrzFormat;
    }

    public void fromMrz(String str) throws MrzParseException {
        if (this.format == MrzFormat.get(str)) {
            this.code = MrzDocumentCode.parse(str);
            this.code1 = str.charAt(0);
            this.code2 = str.charAt(1);
            this.issuingCountry = new MrzParser(str).parseString(new MrzRange(2, 5, 0));
            return;
        }
        throw new MrzParseException("invalid format: " + MrzFormat.get(str), str, new MrzRange(0, 0, 0), this.format);
    }

    public final void setName(String[] strArr) {
        this.surname = strArr[0];
        this.givenNames = strArr[1];
    }

    public abstract String toMrz();

    public String toString() {
        return "MrzRecord{code=" + this.code + "[" + this.code1 + this.code2 + "], issuingCountry=" + this.issuingCountry + ", documentNumber=" + this.documentNumber + ", surname=" + this.surname + ", givenNames=" + this.givenNames + ", dateOfBirth=" + this.dateOfBirth + ", sex=" + this.sex + ", expirationDate=" + this.expirationDate + ", nationality=" + this.nationality + '}';
    }
}
