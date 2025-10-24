package com.fis.ekyc.nfc.build_in.eidparser.lds;

import com.fis.ekyc.nfc.build_in.eidparser.cbeff.BiometricDataBlock;
import com.fis.ekyc.nfc.build_in.scuba.tlv.TLVOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class CBEFFDataGroup<R extends BiometricDataBlock> extends DataGroup {
    protected static final Logger LOGGER = Logger.getLogger("com.fis.ekyc.sdk.nfc.build_in..jmrtd");
    private static final long serialVersionUID = 2702959939408371946L;
    private Random random;
    private List<R> subRecords;

    public CBEFFDataGroup(int i, List<R> list) {
        super(i);
        addAll(list);
        this.random = new SecureRandom();
    }

    public void add(R r) {
        if (this.subRecords == null) {
            this.subRecords = new ArrayList();
        }
        this.subRecords.add(r);
    }

    public void addAll(List<R> list) {
        if (this.subRecords == null) {
            this.subRecords = new ArrayList();
        }
        this.subRecords.addAll(list);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CBEFFDataGroup)) {
            return false;
        }
        try {
            List subRecords2 = getSubRecords();
            List subRecords3 = ((CBEFFDataGroup) obj).getSubRecords();
            int size = subRecords2.size();
            if (size != subRecords3.size()) {
                return false;
            }
            for (int i = 0; i < size; i++) {
                BiometricDataBlock biometricDataBlock = (BiometricDataBlock) subRecords2.get(i);
                BiometricDataBlock biometricDataBlock2 = (BiometricDataBlock) subRecords3.get(i);
                if (biometricDataBlock == null) {
                    if (biometricDataBlock2 != null) {
                        return false;
                    }
                } else if (!biometricDataBlock.equals(biometricDataBlock2)) {
                    return false;
                }
            }
            return true;
        } catch (ClassCastException e) {
            LOGGER.log(Level.WARNING, "Wrong class", e);
            return false;
        }
    }

    public List<R> getSubRecords() {
        if (this.subRecords == null) {
            this.subRecords = new ArrayList();
        }
        return new ArrayList(this.subRecords);
    }

    public int hashCode() {
        int i = 1234567891;
        for (BiometricDataBlock biometricDataBlock : getSubRecords()) {
            if (biometricDataBlock == null) {
                i = (i * 3) + 5;
            } else {
                i = ((i + biometricDataBlock.hashCode()) * 5) + 7;
            }
        }
        return (i * 7) + 11;
    }

    public void remove(int i) {
        if (this.subRecords == null) {
            this.subRecords = new ArrayList();
        }
        this.subRecords.remove(i);
    }

    public String toString() {
        String str;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("CBEFFDataGroup [");
        List<R> list = this.subRecords;
        if (list == null) {
            sb2.append("null");
        } else {
            boolean z = true;
            for (R r : list) {
                if (!z) {
                    sb2.append(", ");
                } else {
                    z = false;
                }
                if (r == null) {
                    str = "null";
                } else {
                    str = r.toString();
                }
                sb2.append(str);
            }
        }
        sb2.append(']');
        return sb2.toString();
    }

    public void writeOptionalRandomData(OutputStream outputStream) throws IOException {
        TLVOutputStream tLVOutputStream;
        if (this.subRecords.isEmpty()) {
            if (outputStream instanceof TLVOutputStream) {
                tLVOutputStream = (TLVOutputStream) outputStream;
            } else {
                tLVOutputStream = new TLVOutputStream(outputStream);
            }
            tLVOutputStream.writeTag(83);
            byte[] bArr = new byte[8];
            this.random.nextBytes(bArr);
            tLVOutputStream.writeValue(bArr);
        }
    }

    public CBEFFDataGroup(int i, InputStream inputStream) throws IOException {
        super(i, inputStream);
        this.random = new Random();
    }
}
