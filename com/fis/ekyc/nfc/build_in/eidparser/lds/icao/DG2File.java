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
import com.fis.ekyc.nfc.build_in.eidparser.lds.iso19794.FaceInfo;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

public class DG2File extends CBEFFDataGroup<FaceInfo> {
    private static final ISO781611Decoder DECODER = new ISO781611Decoder(new BiometricDataBlockDecoder<FaceInfo>() {
        public FaceInfo decode(InputStream inputStream, StandardBiometricHeader standardBiometricHeader, int i, int i2) throws IOException {
            return new FaceInfo(standardBiometricHeader, inputStream);
        }
    });
    private static final ISO781611Encoder<FaceInfo> ENCODER = new ISO781611Encoder<>(new BiometricDataBlockEncoder<FaceInfo>() {
        public void encode(FaceInfo faceInfo, OutputStream outputStream) throws IOException {
            faceInfo.writeObject(outputStream);
        }
    });
    private static final long serialVersionUID = 414300652684010416L;

    public DG2File(List<FaceInfo> list) {
        super((int) LDSFile.EF_DG2_TAG, list);
    }

    public void addFaceInfo(FaceInfo faceInfo) {
        add(faceInfo);
    }

    public List<FaceInfo> getFaceInfos() {
        return getSubRecords();
    }

    public void readContent(InputStream inputStream) throws IOException {
        for (CBEFFInfo next : DECODER.decode(inputStream).getSubRecords()) {
            if (next instanceof SimpleCBEFFInfo) {
                BiometricDataBlock biometricDataBlock = ((SimpleCBEFFInfo) next).getBiometricDataBlock();
                if (biometricDataBlock instanceof FaceInfo) {
                    add((FaceInfo) biometricDataBlock);
                } else {
                    throw new IOException("Was expecting a FaceInfo, found " + biometricDataBlock.getClass().getSimpleName());
                }
            } else {
                throw new IOException("Was expecting a SimpleCBEFFInfo, found " + next.getClass().getSimpleName());
            }
        }
    }

    public void removeFaceInfo(int i) {
        remove(i);
    }

    public String toString() {
        return "DG2File [" + super.toString() + "]";
    }

    public void writeContent(OutputStream outputStream) throws IOException {
        ComplexCBEFFInfo complexCBEFFInfo = new ComplexCBEFFInfo();
        for (FaceInfo simpleCBEFFInfo : getSubRecords()) {
            complexCBEFFInfo.add(new SimpleCBEFFInfo(simpleCBEFFInfo));
        }
        ENCODER.encode(complexCBEFFInfo, outputStream);
    }

    public DG2File(InputStream inputStream) throws IOException {
        super((int) LDSFile.EF_DG2_TAG, inputStream);
    }
}
