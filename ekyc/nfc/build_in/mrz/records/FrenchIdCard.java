package com.fis.ekyc.nfc.build_in.mrz.records;

import com.fis.ekyc.nfc.build_in.mrz.MrzParser;
import com.fis.ekyc.nfc.build_in.mrz.MrzRange;
import com.fis.ekyc.nfc.build_in.mrz.MrzRecord;
import com.fis.ekyc.nfc.build_in.mrz.types.MrzDocumentCode;
import com.fis.ekyc.nfc.build_in.mrz.types.MrzFormat;

public class FrenchIdCard extends MrzRecord {
    private static final long serialVersionUID = 1;
    public String optional;

    public FrenchIdCard() {
        super(MrzFormat.FRENCH_ID);
        this.code = MrzDocumentCode.TypeI;
        this.code1 = 'I';
        this.code2 = 'D';
    }

    public void fromMrz(String str) {
        boolean z;
        super.fromMrz(str);
        MrzParser mrzParser = new MrzParser(str);
        String[] strArr = {"", ""};
        strArr[0] = mrzParser.parseString(new MrzRange(5, 30, 0));
        strArr[1] = mrzParser.parseString(new MrzRange(13, 27, 1));
        setName(strArr);
        this.nationality = mrzParser.parseString(new MrzRange(2, 5, 0));
        this.optional = mrzParser.parseString(new MrzRange(30, 36, 0));
        this.documentNumber = mrzParser.parseString(new MrzRange(0, 12, 1));
        this.validDocumentNumber = mrzParser.checkDigit(12, 1, new MrzRange(0, 12, 1), "document number");
        this.dateOfBirth = mrzParser.parseDate(new MrzRange(27, 33, 1));
        if (!mrzParser.checkDigit(33, 1, new MrzRange(27, 33, 1), "date of birth") || !this.dateOfBirth.isDateValid()) {
            z = false;
        } else {
            z = true;
        }
        this.validDateOfBirth = z;
        this.sex = mrzParser.parseSex(34, 1);
        this.validComposite = mrzParser.checkDigit(35, 1, str.toString().replace("\n", "").substring(0, 71), "final checksum");
    }

    public String toMrz() {
        StringBuilder sb2 = new StringBuilder("IDFRA");
        sb2.append(MrzParser.toMrz(this.surname, 25));
        sb2.append(MrzParser.toMrz(this.optional, 6));
        sb2.append(10);
        sb2.append(MrzParser.toMrz(this.documentNumber, 12));
        sb2.append(MrzParser.computeCheckDigitChar(MrzParser.toMrz(this.documentNumber, 12)));
        sb2.append(MrzParser.toMrz(this.givenNames, 14));
        sb2.append(this.dateOfBirth.toMrz());
        sb2.append(MrzParser.computeCheckDigitChar(this.dateOfBirth.toMrz()));
        sb2.append(this.sex.mrz);
        sb2.append(MrzParser.computeCheckDigitChar(sb2.toString().replace("\n", "")));
        sb2.append(10);
        return sb2.toString();
    }

    public String toString() {
        return "FrenchIdCard{" + super.toString() + ", optional=" + this.optional + '}';
    }
}
