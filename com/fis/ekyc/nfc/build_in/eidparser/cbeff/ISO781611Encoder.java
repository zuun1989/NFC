package com.fis.ekyc.nfc.build_in.eidparser.cbeff;

import com.fis.ekyc.nfc.build_in.eidparser.cbeff.BiometricDataBlock;
import com.fis.ekyc.nfc.build_in.scuba.tlv.TLVOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ISO781611Encoder<B extends BiometricDataBlock> implements ISO781611 {
    private BiometricDataBlockEncoder<B> bdbEncoder;

    public ISO781611Encoder(BiometricDataBlockEncoder<B> biometricDataBlockEncoder) {
        this.bdbEncoder = biometricDataBlockEncoder;
    }

    private void writeBHT(TLVOutputStream tLVOutputStream, int i, SimpleCBEFFInfo<B> simpleCBEFFInfo) throws IOException {
        tLVOutputStream.writeTag(161);
        for (Map.Entry next : simpleCBEFFInfo.getBiometricDataBlock().getStandardBiometricHeader().getElements().entrySet()) {
            tLVOutputStream.writeTag(((Integer) next.getKey()).intValue());
            tLVOutputStream.writeValue((byte[]) next.getValue());
        }
        tLVOutputStream.writeValueEnd();
    }

    private void writeBIT(TLVOutputStream tLVOutputStream, int i, SimpleCBEFFInfo<B> simpleCBEFFInfo) throws IOException {
        tLVOutputStream.writeTag(ISO781611.BIOMETRIC_INFORMATION_TEMPLATE_TAG);
        writeBHT(tLVOutputStream, i, simpleCBEFFInfo);
        writeBiometricDataBlock(tLVOutputStream, simpleCBEFFInfo.getBiometricDataBlock());
        tLVOutputStream.writeValueEnd();
    }

    private void writeBITGroup(List<CBEFFInfo> list, OutputStream outputStream) throws IOException {
        TLVOutputStream tLVOutputStream;
        if (outputStream instanceof TLVOutputStream) {
            tLVOutputStream = (TLVOutputStream) outputStream;
        } else {
            tLVOutputStream = new TLVOutputStream(outputStream);
        }
        tLVOutputStream.writeTag(ISO781611.BIOMETRIC_INFORMATION_GROUP_TEMPLATE_TAG);
        tLVOutputStream.writeTag(2);
        int size = list.size();
        tLVOutputStream.writeValue(new byte[]{(byte) size});
        for (int i = 0; i < size; i++) {
            writeBIT(tLVOutputStream, i, (SimpleCBEFFInfo) list.get(i));
        }
        tLVOutputStream.writeValueEnd();
    }

    private void writeBiometricDataBlock(TLVOutputStream tLVOutputStream, B b) throws IOException {
        tLVOutputStream.writeTag(ISO781611.BIOMETRIC_DATA_BLOCK_TAG);
        this.bdbEncoder.encode(b, tLVOutputStream);
        tLVOutputStream.writeValueEnd();
    }

    public void encode(CBEFFInfo cBEFFInfo, OutputStream outputStream) throws IOException {
        if (cBEFFInfo instanceof SimpleCBEFFInfo) {
            writeBITGroup(Arrays.asList(new CBEFFInfo[]{cBEFFInfo}), outputStream);
        } else if (cBEFFInfo instanceof ComplexCBEFFInfo) {
            writeBITGroup(((ComplexCBEFFInfo) cBEFFInfo).getSubRecords(), outputStream);
        }
    }
}
