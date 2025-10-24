package com.fis.ekyc.nfc.build_in.mrz.records;

import com.fis.ekyc.nfc.build_in.mrz.MrzParser;
import com.fis.ekyc.nfc.build_in.mrz.MrzRange;
import com.fis.ekyc.nfc.build_in.mrz.MrzRecord;
import com.fis.ekyc.nfc.build_in.mrz.types.MrzFormat;

public class MrtdTd1 extends MrzRecord {
    private static final long serialVersionUID = 1;
    public String optional;
    public String optional2;

    public MrtdTd1() {
        super(MrzFormat.MRTD_TD1);
    }

    public void fromMrz(String str) {
        boolean z;
        boolean z2;
        super.fromMrz(str);
        MrzParser mrzParser = new MrzParser(str);
        this.documentNumber = mrzParser.parseString(new MrzRange(5, 14, 0));
        this.validDocumentNumber = mrzParser.checkDigit(14, 0, new MrzRange(5, 14, 0), "document number");
        this.optional = mrzParser.parseString(new MrzRange(15, 30, 0));
        this.dateOfBirth = mrzParser.parseDate(new MrzRange(0, 6, 1));
        if (!mrzParser.checkDigit(6, 1, new MrzRange(0, 6, 1), "date of birth") || !this.dateOfBirth.isDateValid()) {
            z = false;
        } else {
            z = true;
        }
        this.validDateOfBirth = z;
        this.sex = mrzParser.parseSex(7, 1);
        this.expirationDate = mrzParser.parseDate(new MrzRange(8, 14, 1));
        if (!mrzParser.checkDigit(14, 1, new MrzRange(8, 14, 1), "expiration date") || !this.expirationDate.isDateValid()) {
            z2 = false;
        } else {
            z2 = true;
        }
        this.validExpirationDate = z2;
        this.nationality = mrzParser.parseString(new MrzRange(15, 18, 1));
        this.optional2 = mrzParser.parseString(new MrzRange(18, 29, 1));
        this.validComposite = mrzParser.checkDigit(29, 1, mrzParser.rawValue(new MrzRange(5, 30, 0), new MrzRange(0, 7, 1), new MrzRange(8, 15, 1), new MrzRange(18, 29, 1)), "mrz");
        setName(mrzParser.parseName(new MrzRange(0, 30, 2)));
    }

    public String toMrz() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.code1);
        sb2.append(this.code2);
        sb2.append(MrzParser.toMrz(this.issuingCountry, 3));
        String str = MrzParser.toMrz(this.documentNumber, 9) + MrzParser.computeCheckDigitChar(MrzParser.toMrz(this.documentNumber, 9)) + MrzParser.toMrz(this.optional, 15);
        sb2.append(str);
        sb2.append(10);
        String str2 = this.dateOfBirth.toMrz() + MrzParser.computeCheckDigitChar(this.dateOfBirth.toMrz());
        sb2.append(str2);
        sb2.append(this.sex.mrz);
        String str3 = this.expirationDate.toMrz() + MrzParser.computeCheckDigitChar(this.expirationDate.toMrz());
        sb2.append(str3);
        sb2.append(MrzParser.toMrz(this.nationality, 3));
        sb2.append(MrzParser.toMrz(this.optional2, 11));
        sb2.append(MrzParser.computeCheckDigitChar(str + str2 + str3 + MrzParser.toMrz(this.optional2, 11)));
        sb2.append(10);
        sb2.append(MrzParser.nameToMrz(this.surname, this.givenNames, 30));
        sb2.append(10);
        return sb2.toString();
    }

    public String toString() {
        return "MRTD-TD1{" + super.toString() + ", optional=" + this.optional + ", optional2=" + this.optional2 + '}';
    }
}
