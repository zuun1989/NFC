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
import com.fis.ekyc.nfc.build_in.eidparser.lds.LDSFile;
import com.fis.ekyc.nfc.build_in.eidparser.lds.iso19794.IrisInfo;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

public class DG4File extends CBEFFDataGroup<IrisInfo> {
    private static final ISO781611Decoder DECODER = new ISO781611Decoder(new BiometricDataBlockDecoder<IrisInfo>() {
        public IrisInfo decode(InputStream inputStream, StandardBiometricHeader standardBiometricHeader, int i, int i2) throws IOException {
            return new IrisInfo(standardBiometricHeader, inputStream);
        }
    });
    private static final ISO781611Encoder<IrisInfo> ENCODER = new ISO781611Encoder<>(new BiometricDataBlockEncoder<IrisInfo>() {
        public void encode(IrisInfo irisInfo, OutputStream outputStream) throws IOException {
            irisInfo.writeObject(outputStream);
        }
    });
    private static final long serialVersionUID = -1290365855823447586L;
    private boolean shouldAddRandomDataIfEmpty;

    public DG4File(List<IrisInfo> list) {
        this(list, true);
    }

    public void addIrisInfo(IrisInfo irisInfo) {
        add(irisInfo);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj) || getClass() != obj.getClass()) {
            return false;
        }
        if (this.shouldAddRandomDataIfEmpty == ((DG4File) obj).shouldAddRandomDataIfEmpty) {
            return true;
        }
        return false;
    }

    public List<IrisInfo> getIrisInfos() {
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
                if (biometricDataBlock instanceof IrisInfo) {
                    add((IrisInfo) biometricDataBlock);
                } else {
                    throw new IOException("Was expecting an IrisInfo, found " + biometricDataBlock.getClass().getSimpleName());
                }
            } else {
                throw new IOException("Was expecting a SimpleCBEFFInfo, found " + next.getClass().getSimpleName());
            }
        }
    }

    public void removeIrisInfo(int i) {
        remove(i);
    }

    public String toString() {
        return "DG4File [" + super.toString() + "]";
    }

    public void writeContent(OutputStream outputStream) throws IOException {
        ComplexCBEFFInfo complexCBEFFInfo = new ComplexCBEFFInfo();
        for (IrisInfo simpleCBEFFInfo : getSubRecords()) {
            complexCBEFFInfo.add(new SimpleCBEFFInfo(simpleCBEFFInfo));
        }
        ENCODER.encode(complexCBEFFInfo, outputStream);
        if (this.shouldAddRandomDataIfEmpty) {
            writeOptionalRandomData(outputStream);
        }
    }

    public DG4File(List<IrisInfo> list, boolean z) {
        super((int) LDSFile.EF_DG4_TAG, list);
        this.shouldAddRandomDataIfEmpty = z;
    }

    public DG4File(InputStream inputStream) throws IOException {
        super((int) LDSFile.EF_DG4_TAG, inputStream);
    }
}
