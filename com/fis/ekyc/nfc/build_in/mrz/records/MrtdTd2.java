package com.fis.ekyc.nfc.build_in.mrz.records;

import com.fis.ekyc.nfc.build_in.mrz.MrzParser;
import com.fis.ekyc.nfc.build_in.mrz.MrzRange;
import com.fis.ekyc.nfc.build_in.mrz.MrzRecord;
import com.fis.ekyc.nfc.build_in.mrz.types.MrzFormat;

public class MrtdTd2 extends MrzRecord {
    private static final long serialVersionUID = 1;
    public String optional;

    public MrtdTd2() {
        super(MrzFormat.MRTD_TD2);
    }

    public void fromMrz(String str) {
        boolean z;
        boolean z2;
        super.fromMrz(str);
        MrzParser mrzParser = new MrzParser(str);
        setName(mrzParser.parseName(new MrzRange(5, 36, 0)));
        this.documentNumber = mrzParser.parseString(new MrzRange(0, 9, 1));
        this.validDocumentNumber = mrzParser.checkDigit(9, 1, new MrzRange(0, 9, 1), "document number");
        this.nationality = mrzParser.parseString(new MrzRange(10, 13, 1));
        this.dateOfBirth = mrzParser.parseDate(new MrzRange(13, 19, 1));
        if (!mrzParser.checkDigit(19, 1, new MrzRange(13, 19, 1), "date of birth") || !this.dateOfBirth.isDateValid()) {
            z = false;
        } else {
            z = true;
        }
        this.validDateOfBirth = z;
        this.sex = mrzParser.parseSex(20, 1);
        this.expirationDate = mrzParser.parseDate(new MrzRange(21, 27, 1));
        if (!mrzParser.checkDigit(27, 1, new MrzRange(21, 27, 1), "expiration date") || !this.expirationDate.isDateValid()) {
            z2 = false;
        } else {
            z2 = true;
        }
        this.validExpirationDate = z2;
        this.optional = mrzParser.parseString(new MrzRange(28, 35, 1));
        this.validComposite = mrzParser.checkDigit(35, 1, mrzParser.rawValue(new MrzRange(0, 10, 1), new MrzRange(13, 20, 1), new MrzRange(21, 35, 1)), "mrz");
    }

    public String toMrz() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.code1);
        sb2.append(this.code2);
        sb2.append(MrzParser.toMrz(this.issuingCountry, 3));
        sb2.append(MrzParser.nameToMrz(this.surname, this.givenNames, 31));
        sb2.append(10);
        String str = MrzParser.toMrz(this.documentNumber, 9) + MrzParser.computeCheckDigitChar(MrzParser.toMrz(this.documentNumber, 9));
        sb2.append(str);
        sb2.append(MrzParser.toMrz(this.nationality, 3));
        String str2 = this.dateOfBirth.toMrz() + MrzParser.computeCheckDigitChar(this.dateOfBirth.toMrz());
        sb2.append(str2);
        sb2.append(this.sex.mrz);
        String str3 = this.expirationDate.toMrz() + MrzParser.computeCheckDigitChar(this.expirationDate.toMrz());
        sb2.append(str3);
        sb2.append(MrzParser.toMrz(this.optional, 7));
        sb2.append(MrzParser.computeCheckDigitChar(str + str2 + str3 + MrzParser.toMrz(this.optional, 7)));
        sb2.append(10);
        return sb2.toString();
    }

    public String toString() {
        return "MRTD-TD2{" + super.toString() + ", optional=" + this.optional + '}';
    }
}
