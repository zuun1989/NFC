package com.fis.ekyc.nfc.build_in.mrz.records;

import com.fis.ekyc.nfc.build_in.mrz.MrzParser;
import com.fis.ekyc.nfc.build_in.mrz.MrzRange;
import com.fis.ekyc.nfc.build_in.mrz.MrzRecord;
import com.fis.ekyc.nfc.build_in.mrz.types.MrzFormat;

public class SlovakId2_34 extends MrzRecord {
    private static final long serialVersionUID = 1;
    public String optional;

    public SlovakId2_34() {
        super(MrzFormat.SLOVAK_ID_234);
    }

    public void fromMrz(String str) {
        boolean z;
        super.fromMrz(str);
        MrzParser mrzParser = new MrzParser(str);
        boolean z2 = false;
        setName(mrzParser.parseName(new MrzRange(5, 34, 0)));
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
        if (mrzParser.checkDigit(27, 1, new MrzRange(21, 27, 1), "expiration date") && this.expirationDate.isDateValid()) {
            z2 = true;
        }
        this.validExpirationDate = z2;
        this.optional = mrzParser.parseString(new MrzRange(28, 34, 1));
    }

    public String toMrz() {
        return this.code1 + this.code2 + MrzParser.toMrz(this.issuingCountry, 3) + MrzParser.nameToMrz(this.surname, this.givenNames, 29) + 10 + MrzParser.toMrz(this.documentNumber, 9) + MrzParser.computeCheckDigitChar(MrzParser.toMrz(this.documentNumber, 9)) + MrzParser.toMrz(this.nationality, 3) + this.dateOfBirth.toMrz() + MrzParser.computeCheckDigitChar(this.dateOfBirth.toMrz()) + this.sex.mrz + this.expirationDate.toMrz() + MrzParser.computeCheckDigitChar(this.expirationDate.toMrz()) + MrzParser.toMrz(this.optional, 6) + 10;
    }

    public String toString() {
        return "SlovakId2x34{" + super.toString() + ", optional=" + this.optional + '}';
    }
}
