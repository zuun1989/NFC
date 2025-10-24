package com.fis.ekyc.nfc.build_in.eidparser.lds.icao;

import com.fis.ekyc.nfc.build_in.eidparser.cbeff.BiometricDataBlock;
import com.fis.ekyc.nfc.build_in.eidparser.cbeff.BiometricDataBlockDecoder;
import com.fis.ekyc.nfc.build_in.eidparser.cbeff.BiometricDataBlockEncoder;
import com.fis.ekyc.nfc.build_in.eidparser.cbeff.CBEFFInfo;
import com.fis.ekyc.nfc.build_in.eidparser.cbeff.ComplexCBEFFInfo;
import com.fis.ekyc.nfc.build_in.eidparser.cbeff.ISO781611Decoder;
import com.fis.ekyc.nfc.build_in.eidparser.cbeff.ISO781611Encoder;
import com.fis.ekyc.nfc.build_in.eidparser.cbeff.SimpleCBEFFInfo;
import com.fis.ekyc.nfc.build_in.eidparser.cbeff.StandardBiometricHeader;
import com.fis.ekyc.nfc.build_in.eidparser.lds.CBEFFDataGroup;
import com.fis.ekyc.nfc.build_in.eidparser.lds.iso19794.FingerInfo;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

public class DG3File extends CBEFFDataGroup<FingerInfo> {
    private static final ISO781611Decoder DECODER = new ISO781611Decoder(new BiometricDataBlockDecoder<FingerInfo>() {
        public FingerInfo decode(InputStream inputStream, StandardBiometricHeader standardBiometricHeader, int i, int i2) throws IOException {
            return new FingerInfo(standardBiometricHeader, inputStream);
        }
    });
    private static final ISO781611Encoder<FingerInfo> ENCODER = new ISO781611Encoder<>(new BiometricDataBlockEncoder<FingerInfo>() {
        public void encode(FingerInfo fingerInfo, OutputStream outputStream) throws IOException {
            fingerInfo.writeObject(outputStream);
        }
    });
    private static final long serialVersionUID = -1037522331623814528L;
    private boolean shouldAddRandomDataIfEmpty;

    public DG3File(List<FingerInfo> list) {
        this(list, true);
    }

    public void addFingerInfo(FingerInfo fingerInfo) {
        add(fingerInfo);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj) || getClass() != obj.getClass()) {
            return false;
        }
        if (this.shouldAddRandomDataIfEmpty == ((DG3File) obj).shouldAddRandomDataIfEmpty) {
            return true;
        }
        return false;
    }

    public List<FingerInfo> getFingerInfos() {
        return getSubRecords();
    }

    public int hashCode() {
        int i;
        int hashCode = super.hashCode() * 31;
        if (this.shouldAddRandomDataIfEmpty) {
            i = 1231;
        } else {
            i = 1237;
        }
        return hashCode + i;
    }

    public void readContent(InputStream inputStream) throws IOException {
        for (CBEFFInfo next : DECODER.decode(inputStream).getSubRecords()) {
            if (next instanceof SimpleCBEFFInfo) {
                BiometricDataBlock biometricDataBlock = ((SimpleCBEFFInfo) next).getBiometricDataBlock();
                if (biometricDataBlock instanceof FingerInfo) {
                    add((FingerInfo) biometricDataBlock);
                } else {
                    throw new IOException("Was expecting a FingerInfo, found " + biometricDataBlock.getClass().getSimpleName());
                }
            } else {
                throw new IOException("Was expecting a SimpleCBEFFInfo, found " + next.getClass().getSimpleName());
            }
        }
    }

    public void removeFingerInfo(int i) {
        remove(i);
    }

    public String toString() {
        return "DG3File [" + super.toString() + "]";
    }

    public void writeContent(OutputStream outputStream) throws IOException {
        ComplexCBEFFInfo complexCBEFFInfo = new ComplexCBEFFInfo();
        for (FingerInfo simpleCBEFFInfo : getSubRecords()) {
            complexCBEFFInfo.add(new SimpleCBEFFInfo(simpleCBEFFInfo));
        }
        ENCODER.encode(complexCBEFFInfo, outputStream);
        if (this.shouldAddRandomDataIfEmpty) {
            writeOptionalRandomData(outputStream);
        }
    }

    public DG3File(List<FingerInfo> list, boolean z) {
        super(99, list);
        this.shouldAddRandomDataIfEmpty = z;
    }

    public DG3File(InputStream inputStream) throws IOException {
        super(99, inputStream);
    }
}
