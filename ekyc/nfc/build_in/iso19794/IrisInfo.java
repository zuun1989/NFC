package com.fis.ekyc.nfc.build_in.eidparser.lds.iso19794;

import com.fis.ekyc.nfc.build_in.eidparser.cbeff.BiometricDataBlock;
import com.fis.ekyc.nfc.build_in.eidparser.cbeff.ISO781611;
import com.fis.ekyc.nfc.build_in.eidparser.cbeff.StandardBiometricHeader;
import com.fis.ekyc.nfc.build_in.eidparser.lds.AbstractListInfo;
import com.fis.ekyc.nfc.build_in.eidparser.lds.LDSFile;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;
import java.util.logging.Logger;

public class IrisInfo extends AbstractListInfo<IrisBiometricSubtypeInfo> implements BiometricDataBlock {
    public static final int CAPTURE_DEVICE_UNDEF = 0;
    private static final int FORMAT_IDENTIFIER = 1229541888;
    private static final int FORMAT_OWNER_VALUE = 257;
    private static final int FORMAT_TYPE_VALUE = 9;
    public static final int IMAGEFORMAT_MONO_JPEG = 6;
    public static final int IMAGEFORMAT_MONO_JPEG2000 = 14;
    public static final int IMAGEFORMAT_MONO_JPEG_LS = 10;
    public static final int IMAGEFORMAT_MONO_RAW = 2;
    public static final int IMAGEFORMAT_RGB_JPEG = 8;
    public static final int IMAGEFORMAT_RGB_JPEG2000 = 16;
    public static final int IMAGEFORMAT_RGB_JPEG_LS = 12;
    public static final int IMAGEFORMAT_RGB_RAW = 4;
    public static final int INTENSITY_DEPTH_UNDEF = 0;
    public static final int IRBNDY_PROCESSED = 1;
    public static final int IRBNDY_UNDEF = 0;
    public static final int IROCC_PROCESSED = 1;
    public static final int IROCC_UNDEF = 0;
    public static final int IROCC_ZEROFILL = 0;
    public static final int IROC_UNITFILL = 1;
    private static final Logger LOGGER = Logger.getLogger("com.fis.ekyc.sdk.nfc.build_in..jmrtd");
    public static final int ORIENTATION_BASE = 1;
    public static final int ORIENTATION_FLIPPED = 2;
    public static final int ORIENTATION_UNDEF = 0;
    public static final int SCAN_TYPE_CORRECTED = 4;
    public static final int SCAN_TYPE_INTERLACE_FIELD = 3;
    public static final int SCAN_TYPE_INTERLACE_FRAME = 2;
    public static final int SCAN_TYPE_PROGRESSIVE = 1;
    public static final int SCAN_TYPE_UNDEF = 0;
    public static final int TRANS_STD = 1;
    public static final int TRANS_UNDEF = 0;
    private static final int VERSION_NUMBER = 808529920;
    private static final long serialVersionUID = -3415309711643815511L;
    private int boundaryExtraction;
    private int captureDeviceId;
    private byte[] deviceUniqueId;
    private int horizontalOrientation;
    private int imageFormat;
    private int imageTransformation;
    private int intensityDepth;
    private int irisDiameter;
    private int irisOcclusion;
    private int occlusionFilling;
    private int rawImageHeight;
    private int rawImageWidth;
    private long recordLength;
    private StandardBiometricHeader sbh;
    private int scanType;
    private int verticalOrientation;

    public IrisInfo(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, byte[] bArr, List<IrisBiometricSubtypeInfo> list) {
        this((StandardBiometricHeader) null, i, i2, i3, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13, bArr, list);
    }

    private int getBiometricSubtype() {
        for (IrisBiometricSubtypeInfo biometricSubtype : getSubRecords()) {
            biometricSubtype.getBiometricSubtype();
        }
        return 0;
    }

    public void addIrisBiometricSubtypeInfo(IrisBiometricSubtypeInfo irisBiometricSubtypeInfo) {
        add(irisBiometricSubtypeInfo);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj) || getClass() != obj.getClass()) {
            return false;
        }
        IrisInfo irisInfo = (IrisInfo) obj;
        StandardBiometricHeader standardBiometricHeader = this.sbh;
        if (standardBiometricHeader == null) {
            if (irisInfo.sbh != null) {
                return false;
            }
        } else if (!standardBiometricHeader.equals(irisInfo.sbh)) {
            return false;
        }
        if (this.boundaryExtraction != irisInfo.boundaryExtraction || this.captureDeviceId != irisInfo.captureDeviceId || !Arrays.equals(this.deviceUniqueId, irisInfo.deviceUniqueId) || this.horizontalOrientation != irisInfo.horizontalOrientation || this.imageFormat != irisInfo.imageFormat || this.imageTransformation != irisInfo.imageTransformation || this.intensityDepth != irisInfo.intensityDepth || this.irisDiameter != irisInfo.irisDiameter || this.irisOcclusion != irisInfo.irisOcclusion || this.occlusionFilling != irisInfo.occlusionFilling || this.rawImageHeight != irisInfo.rawImageHeight || this.rawImageWidth != irisInfo.rawImageWidth || this.recordLength != irisInfo.recordLength || this.scanType != irisInfo.scanType) {
            return false;
        }
        if (this.verticalOrientation == irisInfo.verticalOrientation) {
            return true;
        }
        return false;
    }

    public int getBoundaryExtraction() {
        return this.boundaryExtraction;
    }

    public int getCaptureDeviceId() {
        return this.captureDeviceId;
    }

    public byte[] getDeviceUniqueId() {
        return this.deviceUniqueId;
    }

    public int getHorizontalOrientation() {
        return this.horizontalOrientation;
    }

    public int getImageFormat() {
        return this.imageFormat;
    }

    public int getImageTransformation() {
        return this.imageTransformation;
    }

    public int getIntensityDepth() {
        return this.intensityDepth;
    }

    public List<IrisBiometricSubtypeInfo> getIrisBiometricSubtypeInfos() {
        return getSubRecords();
    }

    public int getIrisDiameter() {
        return this.irisDiameter;
    }

    public int getIrisOcclusion() {
        return this.irisOcclusion;
    }

    public int getOcclusionFilling() {
        return this.occlusionFilling;
    }

    public int getRawImageHeight() {
        return this.rawImageHeight;
    }

    public int getRawImageWidth() {
        return this.rawImageWidth;
    }

    public int getScanType() {
        return this.scanType;
    }

    public StandardBiometricHeader getStandardBiometricHeader() {
        if (this.sbh == null) {
            byte[] bArr = {(byte) getBiometricSubtype()};
            TreeMap treeMap = new TreeMap();
            treeMap.put(129, new byte[]{8});
            treeMap.put(Integer.valueOf(ISO781611.BIOMETRIC_SUBTYPE_TAG), bArr);
            treeMap.put(135, new byte[]{1, 1});
            treeMap.put(Integer.valueOf(ISO781611.FORMAT_TYPE_TAG), new byte[]{0, 9});
            this.sbh = new StandardBiometricHeader(treeMap);
        }
        return this.sbh;
    }

    public int getVerticalOrientation() {
        return this.verticalOrientation;
    }

    public int hashCode() {
        int i;
        long j = this.recordLength;
        int hashCode = ((((((((((((((((((((((((((super.hashCode() * 31) + this.boundaryExtraction) * 31) + this.captureDeviceId) * 31) + Arrays.hashCode(this.deviceUniqueId)) * 31) + this.horizontalOrientation) * 31) + this.imageFormat) * 31) + this.imageTransformation) * 31) + this.intensityDepth) * 31) + this.irisDiameter) * 31) + this.irisOcclusion) * 31) + this.occlusionFilling) * 31) + this.rawImageHeight) * 31) + this.rawImageWidth) * 31) + ((int) (j ^ (j >>> 32)))) * 31;
        StandardBiometricHeader standardBiometricHeader = this.sbh;
        if (standardBiometricHeader == null) {
            i = 0;
        } else {
            i = standardBiometricHeader.hashCode();
        }
        return ((((hashCode + i) * 31) + this.scanType) * 31) + this.verticalOrientation;
    }

    public void readObject(InputStream inputStream) throws IOException {
        DataInputStream dataInputStream;
        if (inputStream instanceof DataInputStream) {
            dataInputStream = (DataInputStream) inputStream;
        } else {
            dataInputStream = new DataInputStream(inputStream);
        }
        int readInt = dataInputStream.readInt();
        if (readInt == FORMAT_IDENTIFIER) {
            int readInt2 = dataInputStream.readInt();
            if (readInt2 == VERSION_NUMBER) {
                long readInt3 = (long) dataInputStream.readInt();
                this.recordLength = readInt3;
                long j = readInt3 - 45;
                this.captureDeviceId = dataInputStream.readUnsignedShort();
                int readUnsignedByte = dataInputStream.readUnsignedByte();
                int readUnsignedShort = dataInputStream.readUnsignedShort();
                if (((long) readUnsignedShort) == 45) {
                    int readUnsignedShort2 = dataInputStream.readUnsignedShort();
                    this.horizontalOrientation = readUnsignedShort2 & 3;
                    this.verticalOrientation = (readUnsignedShort2 & 12) >> 2;
                    this.scanType = (readUnsignedShort2 & LDSFile.EF_DG16_TAG) >> 4;
                    this.irisOcclusion = (readUnsignedShort2 & 128) >> 7;
                    this.occlusionFilling = (readUnsignedShort2 & 256) >> 8;
                    this.boundaryExtraction = (readUnsignedShort2 & 512) >> 9;
                    this.irisDiameter = dataInputStream.readUnsignedShort();
                    this.imageFormat = dataInputStream.readUnsignedShort();
                    this.rawImageWidth = dataInputStream.readUnsignedShort();
                    this.rawImageHeight = dataInputStream.readUnsignedShort();
                    this.intensityDepth = dataInputStream.readUnsignedByte();
                    this.imageTransformation = dataInputStream.readUnsignedByte();
                    byte[] bArr = new byte[16];
                    this.deviceUniqueId = bArr;
                    dataInputStream.readFully(bArr);
                    long j2 = 0;
                    for (int i = 0; i < readUnsignedByte; i++) {
                        IrisBiometricSubtypeInfo irisBiometricSubtypeInfo = new IrisBiometricSubtypeInfo(inputStream, this.imageFormat);
                        j2 += irisBiometricSubtypeInfo.getRecordLength();
                        add(irisBiometricSubtypeInfo);
                    }
                    if (j != j2) {
                        Logger logger = LOGGER;
                        logger.warning("ConstructedDataLength and dataLength differ: dataLength = " + j + ", constructedDataLength = " + j2);
                        return;
                    }
                    return;
                }
                throw new IllegalArgumentException("Expected header length " + 45 + ", found " + readUnsignedShort);
            }
            throw new IllegalArgumentException("'010' version number expected! Found " + Integer.toHexString(readInt2));
        }
        throw new IllegalArgumentException("'IIR' marker expected! Found " + Integer.toHexString(readInt));
    }

    public void removeIrisBiometricSubtypeInfo(int i) {
        remove(i);
    }

    public String toString() {
        return "IrisInfo [" + "]";
    }

    public void writeObject(OutputStream outputStream) throws IOException {
        DataOutputStream dataOutputStream;
        List<IrisBiometricSubtypeInfo> subRecords = getSubRecords();
        int i = 0;
        for (IrisBiometricSubtypeInfo recordLength2 : subRecords) {
            i = (int) (((long) i) + recordLength2.getRecordLength());
        }
        int i2 = i + 45;
        if (outputStream instanceof DataOutputStream) {
            dataOutputStream = (DataOutputStream) outputStream;
        } else {
            dataOutputStream = new DataOutputStream(outputStream);
        }
        dataOutputStream.writeInt(FORMAT_IDENTIFIER);
        dataOutputStream.writeInt(VERSION_NUMBER);
        dataOutputStream.writeInt(i2);
        dataOutputStream.writeShort(this.captureDeviceId);
        dataOutputStream.writeByte(subRecords.size());
        dataOutputStream.writeShort(45);
        dataOutputStream.writeShort((this.horizontalOrientation & 3) | ((this.verticalOrientation << 2) & 12) | ((this.scanType << 4) & LDSFile.EF_DG16_TAG) | ((this.irisOcclusion << 7) & 128) | ((this.occlusionFilling << 8) & 256) | ((this.boundaryExtraction << 9) & 512));
        dataOutputStream.writeShort(this.irisDiameter);
        dataOutputStream.writeShort(this.imageFormat);
        dataOutputStream.writeShort(this.rawImageWidth);
        dataOutputStream.writeShort(this.rawImageHeight);
        dataOutputStream.writeByte(this.intensityDepth);
        dataOutputStream.writeByte(this.imageTransformation);
        dataOutputStream.write(this.deviceUniqueId);
        for (IrisBiometricSubtypeInfo writeObject : subRecords) {
            writeObject.writeObject(outputStream);
        }
    }

    public IrisInfo(StandardBiometricHeader standardBiometricHeader, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, byte[] bArr, List<IrisBiometricSubtypeInfo> list) {
        byte[] bArr2 = bArr;
        this.sbh = standardBiometricHeader;
        if (list != null) {
            this.captureDeviceId = i;
            this.horizontalOrientation = i2;
            this.verticalOrientation = i3;
            this.scanType = i4;
            this.irisOcclusion = i5;
            this.occlusionFilling = i6;
            this.boundaryExtraction = i7;
            this.irisDiameter = i8;
            this.imageFormat = i9;
            this.rawImageWidth = i10;
            this.rawImageHeight = i11;
            this.intensityDepth = i12;
            this.imageTransformation = i13;
            long j = 0;
            for (IrisBiometricSubtypeInfo next : list) {
                j += next.getRecordLength();
                add(next);
            }
            if (bArr2 == null || bArr2.length != 16) {
                throw new IllegalArgumentException("deviceUniqueId invalid");
            }
            byte[] bArr3 = new byte[16];
            this.deviceUniqueId = bArr3;
            System.arraycopy(bArr2, 0, bArr3, 0, bArr2.length);
            this.recordLength = j + 45;
            return;
        }
        throw new IllegalArgumentException("Null irisBiometricSubtypeInfos");
    }

    public IrisInfo(InputStream inputStream) throws IOException {
        this((StandardBiometricHeader) null, inputStream);
    }

    public IrisInfo(StandardBiometricHeader standardBiometricHeader, InputStream inputStream) throws IOException {
        this.sbh = standardBiometricHeader;
        readObject(inputStream);
    }
}
