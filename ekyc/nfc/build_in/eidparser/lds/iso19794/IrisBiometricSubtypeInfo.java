package com.fis.ekyc.nfc.build_in.eidparser.lds.iso19794;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.digests.Blake2xsDigest;
import com.fis.ekyc.nfc.build_in.eidparser.lds.AbstractListInfo;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

public class IrisBiometricSubtypeInfo extends AbstractListInfo<IrisImageInfo> {
    public static final int EYE_LEFT = 2;
    public static final int EYE_RIGHT = 1;
    public static final int EYE_UNDEF = 0;
    private static final long serialVersionUID = -6588640634764878039L;
    private int biometricSubtype;
    private int imageFormat;

    public IrisBiometricSubtypeInfo(int i, int i2, List<IrisImageInfo> list) {
        this.biometricSubtype = i;
        this.imageFormat = i2;
        addAll(list);
    }

    private static String biometricSubtypeToString(int i) {
        if (i == 0) {
            return "Undefined";
        }
        if (i == 1) {
            return "Right eye";
        }
        if (i == 2) {
            return "Left eye";
        }
        throw new NumberFormatException("Unknown biometric subtype: " + Integer.toHexString(i));
    }

    public void addIrisImageInfo(IrisImageInfo irisImageInfo) {
        add(irisImageInfo);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj) || getClass() != obj.getClass()) {
            return false;
        }
        IrisBiometricSubtypeInfo irisBiometricSubtypeInfo = (IrisBiometricSubtypeInfo) obj;
        if (this.biometricSubtype == irisBiometricSubtypeInfo.biometricSubtype && this.imageFormat == irisBiometricSubtypeInfo.imageFormat) {
            return true;
        }
        return false;
    }

    public int getBiometricSubtype() {
        return this.biometricSubtype;
    }

    public int getImageFormat() {
        return this.imageFormat;
    }

    public List<IrisImageInfo> getIrisImageInfos() {
        return getSubRecords();
    }

    public long getRecordLength() {
        long j = 3;
        for (IrisImageInfo recordLength : getSubRecords()) {
            j += recordLength.getRecordLength();
        }
        return j;
    }

    public int hashCode() {
        return (((super.hashCode() * 31) + this.biometricSubtype) * 31) + this.imageFormat;
    }

    public void readObject(InputStream inputStream) throws IOException {
        DataInputStream dataInputStream;
        if (inputStream instanceof DataInputStream) {
            dataInputStream = (DataInputStream) inputStream;
        } else {
            dataInputStream = new DataInputStream(inputStream);
        }
        this.biometricSubtype = dataInputStream.readUnsignedByte();
        int readUnsignedShort = dataInputStream.readUnsignedShort();
        for (int i = 0; i < readUnsignedShort; i++) {
            IrisImageInfo irisImageInfo = new IrisImageInfo(inputStream, this.imageFormat);
            irisImageInfo.getRecordLength();
            add(irisImageInfo);
        }
    }

    public void removeIrisImageInfo(int i) {
        remove(i);
    }

    public String toString() {
        List subRecords = getSubRecords();
        return "IrisBiometricSubtypeInfo [biometric subtype: " + biometricSubtypeToString(this.biometricSubtype) + ", imageCount = " + subRecords.size() + "]";
    }

    public void writeObject(OutputStream outputStream) throws IOException {
        DataOutputStream dataOutputStream;
        if (outputStream instanceof DataOutputStream) {
            dataOutputStream = (DataOutputStream) outputStream;
        } else {
            dataOutputStream = new DataOutputStream(outputStream);
        }
        dataOutputStream.writeByte(this.biometricSubtype & 255);
        List<IrisImageInfo> subRecords = getSubRecords();
        dataOutputStream.writeShort(subRecords.size() & Blake2xsDigest.UNKNOWN_DIGEST_LENGTH);
        for (IrisImageInfo writeObject : subRecords) {
            writeObject.writeObject(dataOutputStream);
        }
    }

    public IrisBiometricSubtypeInfo(InputStream inputStream, int i) throws IOException {
        this.imageFormat = i;
        readObject(inputStream);
    }
}
