package com.fis.ekyc.nfc.build_in.eidparser.lds.icao;

import com.fis.ekyc.nfc.build_in.eidparser.lds.DataGroup;
import com.fis.ekyc.nfc.build_in.scuba.tlv.TLVInputStream;
import com.fis.ekyc.nfc.build_in.scuba.tlv.TLVOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class DG1File extends DataGroup {
    private static final short MRZ_INFO_TAG = 24351;
    private static final long serialVersionUID = 5091606125728809058L;
    private MRZInfo mrzInfo;

    public DG1File(MRZInfo mRZInfo) {
        super(97);
        this.mrzInfo = mRZInfo;
    }

    public boolean equals(Object obj) {
        if (obj != null && obj.getClass().equals(getClass())) {
            return this.mrzInfo.equals(((DG1File) obj).mrzInfo);
        }
        return false;
    }

    public MRZInfo getMRZInfo() {
        return this.mrzInfo;
    }

    public int hashCode() {
        return (this.mrzInfo.hashCode() * 3) + 57;
    }

    public void readContent(InputStream inputStream) throws IOException {
        TLVInputStream tLVInputStream;
        if (inputStream instanceof TLVInputStream) {
            tLVInputStream = (TLVInputStream) inputStream;
        } else {
            tLVInputStream = new TLVInputStream(inputStream);
        }
        tLVInputStream.skipToTag(24351);
        this.mrzInfo = new MRZInfo(tLVInputStream, tLVInputStream.readLength());
    }

    public String toString() {
        return "DG1File " + this.mrzInfo.toString().replaceAll("\n", "").trim();
    }

    public void writeContent(OutputStream outputStream) throws IOException {
        TLVOutputStream tLVOutputStream;
        if (outputStream instanceof TLVOutputStream) {
            tLVOutputStream = (TLVOutputStream) outputStream;
        } else {
            tLVOutputStream = new TLVOutputStream(outputStream);
        }
        tLVOutputStream.writeTag(24351);
        tLVOutputStream.writeValue(this.mrzInfo.getEncoded());
    }

    public DG1File(InputStream inputStream) throws IOException {
        super(97, inputStream);
    }
}
