package com.fis.ekyc.nfc.build_in.mrz.types;

import com.google.android.gms.dynamite.descriptors.com.google.mlkit.dynamite.barcode.ModuleDescriptor;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class MrzDate implements Serializable, Comparable<MrzDate> {
    private static final SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");
    private static final long serialVersionUID = 1;
    public final int day;
    private final boolean isValidDate;
    public final int month;
    private final String mrz;
    public final int year;

    public MrzDate(int i, int i2, int i3) {
        this.year = i;
        this.month = i2;
        this.day = i3;
        this.isValidDate = check();
        this.mrz = null;
    }

    private boolean check() {
        int i;
        int i2;
        int i3 = this.year;
        if (i3 < 0 || i3 > 99 || (i = this.month) < 1 || i > 12 || (i2 = this.day) < 1 || i2 > 31) {
            return false;
        }
        return true;
    }

    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        MrzDate mrzDate = (MrzDate) obj;
        if (this.year == mrzDate.year && this.month == mrzDate.month && this.day == mrzDate.day) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((((77 + this.year) * 11) + this.month) * 11) + this.day;
    }

    public boolean isDateValid() {
        return this.isValidDate;
    }

    public String toMrz() {
        String str = this.mrz;
        if (str != null) {
            return str;
        }
        return String.format("%02d%02d%02d", new Object[]{Integer.valueOf(this.year), Integer.valueOf(this.month), Integer.valueOf(this.day)});
    }

    public String toString() {
        try {
            return outputFormat.format(new SimpleDateFormat("yyMMdd").parse(this.mrz));
        } catch (ParseException e) {
            e.printStackTrace();
            return "";
        }
    }

    public int compareTo(MrzDate mrzDate) {
        return Integer.valueOf((this.year * ModuleDescriptor.MODULE_VERSION) + (this.month * 100) + this.day).compareTo(Integer.valueOf((mrzDate.year * ModuleDescriptor.MODULE_VERSION) + (mrzDate.month * 100) + mrzDate.day));
    }

    public MrzDate(int i, int i2, int i3, String str) {
        this.year = i;
        this.month = i2;
        this.day = i3;
        this.isValidDate = check();
        this.mrz = str;
    }
}
