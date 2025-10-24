package com.fis.ekyc.nfc.build_in.eidparser.lds;

import com.fis.ekyc.nfc.build_in.eidparser.io.SplittableInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class AbstractImageInfo implements ImageInfo {
    private static final Logger LOGGER = Logger.getLogger("com.fis.ekyc.sdk.nfc.build_in..jmrtd");
    private static final long serialVersionUID = 2870092217269116309L;
    private int height;
    private byte[] imageBytes;
    private int imageLength;
    private int imagePositionInInputStream;
    private String mimeType;
    private transient SplittableInputStream splittableInputStream;
    private int type;
    private int width;

    public AbstractImageInfo() {
        this(-1, 0, 0, (String) null);
    }

    private byte[] getImageBytes() throws IOException {
        byte[] bArr = new byte[getImageLength()];
        new DataInputStream(getImageInputStream()).readFully(bArr);
        return bArr;
    }

    private static String typeToString(int i) {
        if (i == -1) {
            return "Unknown";
        }
        if (i == 0) {
            return "Portrait";
        }
        if (i == 1) {
            return "Signature or usual mark";
        }
        if (i == 2) {
            return "Finger";
        }
        if (i == 3) {
            return "Iris";
        }
        throw new NumberFormatException("Unknown type: " + Integer.toHexString(i));
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0042  */
    /* JADX WARNING: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r6) {
        /*
            r5 = this;
            r0 = 0
            if (r6 != 0) goto L_0x0004
            return r0
        L_0x0004:
            r1 = 1
            if (r6 != r5) goto L_0x0008
            return r1
        L_0x0008:
            java.lang.Class r2 = r6.getClass()     // Catch:{ Exception -> 0x0030 }
            java.lang.Class r3 = r5.getClass()     // Catch:{ Exception -> 0x0030 }
            boolean r2 = r2.equals(r3)     // Catch:{ Exception -> 0x0030 }
            if (r2 != 0) goto L_0x0017
            return r0
        L_0x0017:
            com.fis.ekyc.nfc.build_in.eidparser.lds.AbstractImageInfo r6 = (com.fis.ekyc.nfc.build_in.eidparser.lds.AbstractImageInfo) r6     // Catch:{ Exception -> 0x0030 }
            byte[] r2 = r5.getImageBytes()     // Catch:{ Exception -> 0x0030 }
            byte[] r3 = r6.getImageBytes()     // Catch:{ Exception -> 0x0030 }
            boolean r2 = java.util.Arrays.equals(r2, r3)     // Catch:{ Exception -> 0x0030 }
            if (r2 == 0) goto L_0x0043
            java.lang.String r2 = r5.mimeType     // Catch:{ Exception -> 0x0030 }
            if (r2 != 0) goto L_0x0032
            java.lang.String r3 = r6.mimeType     // Catch:{ Exception -> 0x0030 }
            if (r3 == 0) goto L_0x003c
            goto L_0x0032
        L_0x0030:
            r6 = move-exception
            goto L_0x0044
        L_0x0032:
            if (r2 == 0) goto L_0x0043
            java.lang.String r3 = r6.mimeType     // Catch:{ Exception -> 0x0030 }
            boolean r2 = r2.equals(r3)     // Catch:{ Exception -> 0x0030 }
            if (r2 == 0) goto L_0x0043
        L_0x003c:
            int r2 = r5.type     // Catch:{ Exception -> 0x0030 }
            int r6 = r6.type     // Catch:{ Exception -> 0x0030 }
            if (r2 != r6) goto L_0x0043
            r0 = r1
        L_0x0043:
            return r0
        L_0x0044:
            java.util.logging.Logger r1 = LOGGER
            java.util.logging.Level r2 = java.util.logging.Level.WARNING
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Exception"
            r3.append(r4)
            r3.append(r6)
            java.lang.String r6 = r3.toString()
            r1.log(r2, r6)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fis.ekyc.nfc.build_in.eidparser.lds.AbstractImageInfo.equals(java.lang.Object):boolean");
    }

    public byte[] getEncoded() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            writeObject(byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            LOGGER.log(Level.WARNING, "Exception", e);
            return null;
        }
    }

    public int getHeight() {
        return this.height;
    }

    public InputStream getImageInputStream() {
        SplittableInputStream splittableInputStream2 = this.splittableInputStream;
        if (splittableInputStream2 != null) {
            return splittableInputStream2.getInputStream(this.imagePositionInInputStream);
        }
        if (this.imageBytes != null) {
            return new ByteArrayInputStream(this.imageBytes);
        }
        throw new IllegalStateException("Both the byte buffer and the stream are null");
    }

    public int getImageLength() {
        if (this.splittableInputStream != null) {
            return this.imageLength;
        }
        byte[] bArr = this.imageBytes;
        if (bArr != null) {
            return bArr.length;
        }
        throw new IllegalStateException("Cannot get length of null");
    }

    public String getMimeType() {
        return this.mimeType;
    }

    public int getType() {
        return this.type;
    }

    public int getWidth() {
        return this.width;
    }

    public int hashCode() {
        int i;
        int i2 = -591263623 + (this.type * 5);
        String str = this.mimeType;
        if (str == null) {
            i = 1337;
        } else {
            i = str.hashCode();
        }
        return i2 + (i * 5) + 7 + (getImageLength() * 7) + 11;
    }

    public void readImage(InputStream inputStream, long j) throws IOException {
        this.splittableInputStream = null;
        this.imageBytes = new byte[((int) j)];
        new DataInputStream(inputStream).readFully(this.imageBytes);
    }

    public abstract void readObject(InputStream inputStream) throws IOException;

    public final void setHeight(int i) {
        this.height = i;
    }

    public final void setImageBytes(byte[] bArr) {
        if (bArr != null) {
            try {
                readImage(new ByteArrayInputStream(bArr), (long) bArr.length);
            } catch (IOException e) {
                LOGGER.log(Level.WARNING, "Exception", e);
            }
        } else {
            throw new IllegalArgumentException("Cannot set null image bytes");
        }
    }

    public final void setMimeType(String str) {
        this.mimeType = str;
    }

    public final void setType(int i) {
        this.type = i;
    }

    public final void setWidth(int i) {
        this.width = i;
    }

    public String toString() {
        return getClass().getSimpleName() + " [type: " + typeToString(this.type) + ", size: " + getImageLength() + "]";
    }

    public void writeImage(OutputStream outputStream) throws IOException {
        outputStream.write(getImageBytes());
    }

    public abstract void writeObject(OutputStream outputStream) throws IOException;

    public AbstractImageInfo(int i) {
        this(i, 0, 0, (String) null);
    }

    public AbstractImageInfo(int i, String str) {
        this(i, 0, 0, str);
    }

    private AbstractImageInfo(int i, int i2, int i3, String str) {
        this.type = i;
        this.mimeType = str;
        this.width = i2;
        this.height = i3;
    }

    public AbstractImageInfo(int i, int i2, int i3, InputStream inputStream, long j, String str) throws IOException {
        this(i, i2, i3, str);
        readImage(inputStream, j);
    }
}
