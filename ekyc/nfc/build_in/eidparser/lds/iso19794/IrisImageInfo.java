package com.fis.ekyc.nfc.build_in.eidparser.lds.iso19794;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.cmc.BodyPartID;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.digests.Blake2xsDigest;
import com.fis.ekyc.nfc.build_in.eidparser.lds.AbstractImageInfo;
import com.fis.ekyc.nfc.build_in.eidparser.lds.ImageInfo;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class IrisImageInfo extends AbstractImageInfo {
    public static final int IMAGE_QUAL_HIGH_HI = 100;
    public static final int IMAGE_QUAL_HIGH_LO = 76;
    public static final int IMAGE_QUAL_LOW_HI = 50;
    public static final int IMAGE_QUAL_LOW_LO = 26;
    public static final int IMAGE_QUAL_MED_HI = 75;
    public static final int IMAGE_QUAL_MED_LO = 51;
    public static final int IMAGE_QUAL_UNDEF = 254;
    private static final int ROT_ANGLE_UNDEF = 65535;
    private static final int ROT_UNCERTAIN_UNDEF = 65535;
    private static final long serialVersionUID = 833541246115625112L;
    private int imageFormat;
    private int imageNumber;
    private int quality;
    private int rotationAngle;
    private int rotationAngleUncertainty;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public IrisImageInfo(int i, int i2, int i3, int i4, int i5, int i6, InputStream inputStream, int i7, int i8) throws IOException {
        super(3, i5, i6, inputStream, (long) i7, getMimeTypeFromImageFormat(i8));
        if (inputStream != null) {
            this.imageNumber = i;
            this.quality = i2;
            this.rotationAngle = i3;
            this.rotationAngleUncertainty = i4;
            return;
        }
        throw new IllegalArgumentException("Null image bytes");
    }

    private static String getMimeTypeFromImageFormat(int i) {
        if (i == 2 || i == 4) {
            return ImageInfo.WSQ_MIME_TYPE;
        }
        if (i == 6 || i == 8 || i == 10 || i == 12) {
            return ImageInfo.JPEG_MIME_TYPE;
        }
        if (i == 14 || i == 16) {
            return ImageInfo.JPEG2000_MIME_TYPE;
        }
        return null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj) || getClass() != obj.getClass()) {
            return false;
        }
        IrisImageInfo irisImageInfo = (IrisImageInfo) obj;
        if (this.imageFormat == irisImageInfo.imageFormat && this.imageNumber == irisImageInfo.imageNumber && this.quality == irisImageInfo.quality && this.rotationAngle == irisImageInfo.rotationAngle && this.rotationAngleUncertainty == irisImageInfo.rotationAngleUncertainty) {
            return true;
        }
        return false;
    }

    public int getImageFormat() {
        return this.imageFormat;
    }

    public int getImageNumber() {
        return this.imageNumber;
    }

    public int getQuality() {
        return this.quality;
    }

    public long getRecordLength() {
        return ((long) getImageLength()) + 11;
    }

    public int getRotationAngle() {
        return this.rotationAngle;
    }

    public int getRotationAngleUncertainty() {
        return this.rotationAngleUncertainty;
    }

    public int hashCode() {
        return (((((((((super.hashCode() * 31) + this.imageFormat) * 31) + this.imageNumber) * 31) + this.quality) * 31) + this.rotationAngle) * 31) + this.rotationAngleUncertainty;
    }

    public void readObject(InputStream inputStream) throws IOException {
        DataInputStream dataInputStream;
        if (inputStream instanceof DataInputStream) {
            dataInputStream = (DataInputStream) inputStream;
        } else {
            dataInputStream = new DataInputStream(inputStream);
        }
        this.imageNumber = dataInputStream.readUnsignedShort();
        this.quality = dataInputStream.readUnsignedByte();
        this.rotationAngle = dataInputStream.readShort();
        this.rotationAngleUncertainty = dataInputStream.readUnsignedShort();
        readImage(inputStream, ((long) dataInputStream.readInt()) & BodyPartID.bodyIdMax);
    }

    public String toString() {
        return "IrisImageInfo [image number: " + this.imageNumber + ", quality: " + this.quality + ", image: " + getWidth() + " x " + getHeight() + "mime-type: " + getMimeTypeFromImageFormat(this.imageFormat) + "]";
    }

    public void writeObject(OutputStream outputStream) throws IOException {
        DataOutputStream dataOutputStream;
        if (outputStream instanceof DataOutputStream) {
            dataOutputStream = (DataOutputStream) outputStream;
        } else {
            dataOutputStream = new DataOutputStream(outputStream);
        }
        dataOutputStream.writeShort(this.imageNumber);
        dataOutputStream.writeByte(this.quality);
        dataOutputStream.writeShort(this.rotationAngle);
        dataOutputStream.writeShort(this.rotationAngleUncertainty);
        dataOutputStream.writeInt(getImageLength());
        writeImage(dataOutputStream);
    }

    public IrisImageInfo(int i, int i2, int i3, InputStream inputStream, int i4, int i5) throws IOException {
        this(i, IMAGE_QUAL_UNDEF, Blake2xsDigest.UNKNOWN_DIGEST_LENGTH, Blake2xsDigest.UNKNOWN_DIGEST_LENGTH, i2, i3, inputStream, i4, i5);
    }

    public IrisImageInfo(InputStream inputStream, int i) throws IOException {
        super(3);
        this.imageFormat = i;
        setMimeType(getMimeTypeFromImageFormat(i));
        readObject(inputStream);
    }
}
