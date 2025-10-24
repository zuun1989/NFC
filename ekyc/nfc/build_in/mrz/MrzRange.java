package com.fis.ekyc.nfc.build_in.mrz;

import java.io.Serializable;

public class MrzRange implements Serializable {
    private static final long serialVersionUID = 1;
    public final int column;
    public final int columnTo;
    public final int row;

    public MrzRange(int i, int i2, int i3) {
        if (i <= i2) {
            this.column = i;
            this.columnTo = i2;
            this.row = i3;
            return;
        }
        throw new IllegalArgumentException("Parameter column: invalid value " + i + ": must be less than " + i2);
    }

    public int length() {
        return this.columnTo - this.column;
    }

    public String toString() {
        return "" + this.column + "-" + this.columnTo + "," + this.row;
    }
}
