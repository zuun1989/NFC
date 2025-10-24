package com.fis.ekyc.nfc.build_in.eidparser.lds.iso19794;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.cmc.BodyPartID;
import com.fis.ekyc.nfc.build_in.eidparser.cbeff.BiometricDataBlock;
import com.fis.ekyc.nfc.build_in.eidparser.cbeff.ISO781611;
import com.fis.ekyc.nfc.build_in.eidparser.cbeff.StandardBiometricHeader;
import com.fis.ekyc.nfc.build_in.eidparser.lds.AbstractListInfo;
import com.fis.ekyc.nfc.build_in.eidparser.lds.iso19794.FaceImageInfo;
import com.fis.ekyc.nfc.build_in.scuba.data.Gender;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FaceInfo extends AbstractListInfo<FaceImageInfo> implements BiometricDataBlock {
    private static final int FORMAT_IDENTIFIER = 1178682112;
    private static final int FORMAT_OWNER_VALUE = 257;
    private static final int FORMAT_TYPE_VALUE = 8;
    private static final Logger LOGGER = Logger.getLogger("com.fis.ekyc.sdk.nfc.build_in..jmrtd");
    private static final int VERSION_NUMBER = 808529920;
    private static final long serialVersionUID = -6053206262773400725L;
    private StandardBiometricHeader sbh;

    public FaceInfo(List<FaceImageInfo> list) {
        this((StandardBiometricHeader) null, list);
    }

    public void addFaceImageInfo(FaceImageInfo faceImageInfo) {
        add(faceImageInfo);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj) || getClass() != obj.getClass()) {
            return false;
        }
        FaceInfo faceInfo = (FaceInfo) obj;
        StandardBiometricHeader standardBiometricHeader = this.sbh;
        if (standardBiometricHeader != null) {
            StandardBiometricHeader standardBiometricHeader2 = faceInfo.sbh;
            if (standardBiometricHeader == standardBiometricHeader2 || standardBiometricHeader.equals(standardBiometricHeader2)) {
                return true;
            }
            return false;
        } else if (faceInfo.sbh == null) {
            return true;
        } else {
            return false;
        }
    }

    public List<FaceImageInfo> getFaceImageInfos() {
        return getSubRecords();
    }

    public StandardBiometricHeader getStandardBiometricHeader() {
        if (this.sbh == null) {
            TreeMap treeMap = new TreeMap();
            treeMap.put(129, new byte[]{2});
            treeMap.put(Integer.valueOf(ISO781611.BIOMETRIC_SUBTYPE_TAG), new byte[]{0});
            treeMap.put(135, new byte[]{1, 1});
            treeMap.put(Integer.valueOf(ISO781611.FORMAT_TYPE_TAG), new byte[]{0, 8});
            this.sbh = new StandardBiometricHeader(treeMap);
        }
        return this.sbh;
    }

    public int hashCode() {
        int i;
        int hashCode = super.hashCode() * 31;
        StandardBiometricHeader standardBiometricHeader = this.sbh;
        if (standardBiometricHeader == null) {
            i = 0;
        } else {
            i = standardBiometricHeader.hashCode();
        }
        return hashCode + i;
    }

    public void readObject(InputStream inputStream) throws IOException {
        DataInputStream dataInputStream;
        InputStream inputStream2 = inputStream;
        if (inputStream2 instanceof DataInputStream) {
            dataInputStream = (DataInputStream) inputStream2;
        } else {
            dataInputStream = new DataInputStream(inputStream2);
        }
        int readInt = dataInputStream.readInt();
        if (readInt != FORMAT_IDENTIFIER) {
            LOGGER.log(Level.WARNING, "'FAC' marker expected! Found " + Integer.toHexString(readInt));
            if (readInt == 12) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
                dataOutputStream.writeInt(readInt);
                short readShort = dataInputStream.readShort();
                dataOutputStream.writeShort(readShort);
                int i = 0;
                while (i < readShort) {
                    byte[] bArr = new byte[2048];
                    int read = dataInputStream.read(bArr);
                    if (read < 0) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr);
                    i += read;
                }
                ByteArrayInputStream byteArrayInputStream = r4;
                ByteArrayInputStream byteArrayInputStream2 = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
                add(new FaceImageInfo(Gender.UNKNOWN, FaceImageInfo.EyeColor.UNSPECIFIED, 0, 0, 0, new int[]{0, 0, 0}, new int[]{0, 0, 0}, 1, 0, 0, 0, 0, new FaceImageInfo.FeaturePoint[0], 0, 0, byteArrayInputStream, readShort, 1));
                return;
            }
        }
        int readInt2 = dataInputStream.readInt();
        if (readInt2 == VERSION_NUMBER) {
            long readInt3 = (((long) dataInputStream.readInt()) & BodyPartID.bodyIdMax) - 14;
            int readUnsignedShort = dataInputStream.readUnsignedShort();
            long j = 0;
            for (int i2 = 0; i2 < readUnsignedShort; i2++) {
                FaceImageInfo faceImageInfo = new FaceImageInfo(inputStream2);
                j += faceImageInfo.getRecordLength();
                add(faceImageInfo);
            }
            if (readInt3 != j) {
                LOGGER.warning("ConstructedDataLength and dataLength differ: dataLength = " + readInt3 + ", constructedDataLength = " + j);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("'010' version number expected! Found " + Integer.toHexString(readInt2));
    }

    public void removeFaceImageInfo(int i) {
        remove(i);
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("FaceInfo [");
        for (FaceImageInfo faceImageInfo : getSubRecords()) {
            sb2.append(faceImageInfo.toString());
        }
        sb2.append("]");
        return sb2.toString();
    }

    public void writeObject(OutputStream outputStream) throws IOException {
        DataOutputStream dataOutputStream;
        List<FaceImageInfo> subRecords = getSubRecords();
        long j = 0;
        for (FaceImageInfo recordLength : subRecords) {
            j += recordLength.getRecordLength();
        }
        long j2 = ((long) 14) + j;
        if (outputStream instanceof DataOutputStream) {
            dataOutputStream = (DataOutputStream) outputStream;
        } else {
            dataOutputStream = new DataOutputStream(outputStream);
        }
        dataOutputStream.writeInt(FORMAT_IDENTIFIER);
        dataOutputStream.writeInt(VERSION_NUMBER);
        dataOutputStream.writeInt((int) (BodyPartID.bodyIdMax & j2));
        dataOutputStream.writeShort(subRecords.size());
        for (FaceImageInfo writeObject : subRecords) {
            writeObject.writeObject(dataOutputStream);
        }
    }

    public FaceInfo(StandardBiometricHeader standardBiometricHeader, List<FaceImageInfo> list) {
        this.sbh = standardBiometricHeader;
        addAll(list);
    }

    public FaceInfo(InputStream inputStream) throws IOException {
        this((StandardBiometricHeader) null, inputStream);
    }

    public FaceInfo(StandardBiometricHeader standardBiometricHeader, InputStream inputStream) throws IOException {
        this.sbh = standardBiometricHeader;
        readObject(inputStream);
    }
}
