package com.fis.ekyc.nfc.build_in.eidparser.lds;

import com.fis.ekyc.nfc.build_in.eidparser.cert.CVCPrincipal;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class CVCAFile extends AbstractLDSFile {
    public static final byte CAR_TAG = 66;
    public static final int LENGTH = 36;
    private static final long serialVersionUID = -1100904058684365703L;
    private String altCAReference;
    private String caReference;
    private short fid;

    public CVCAFile(InputStream inputStream) throws IOException {
        this(284, inputStream);
    }

    public boolean equals(Object obj) {
        if (obj == null || !getClass().equals(obj.getClass())) {
            return false;
        }
        CVCAFile cVCAFile = (CVCAFile) obj;
        if (!this.caReference.equals(cVCAFile.caReference)) {
            return false;
        }
        String str = this.altCAReference;
        if ((str != null || cVCAFile.altCAReference != null) && (str == null || !str.equals(cVCAFile.altCAReference))) {
            return false;
        }
        return true;
    }

    public CVCPrincipal getAltCAReference() {
        if (this.altCAReference == null) {
            return null;
        }
        return new CVCPrincipal(this.altCAReference);
    }

    public CVCPrincipal getCAReference() {
        if (this.caReference == null) {
            return null;
        }
        return new CVCPrincipal(this.caReference);
    }

    public /* bridge */ /* synthetic */ byte[] getEncoded() {
        return super.getEncoded();
    }

    public short getFID() {
        return this.fid;
    }

    public int getLength() {
        return 36;
    }

    public int hashCode() {
        int i;
        int hashCode = this.caReference.hashCode() * 11;
        String str = this.altCAReference;
        if (str != null) {
            i = str.hashCode() * 13;
        } else {
            i = 0;
        }
        return hashCode + i + 5;
    }

    public void readObject(InputStream inputStream) throws IOException {
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        int read = dataInputStream.read();
        if (read == 66) {
            int read2 = dataInputStream.read();
            if (read2 <= 16) {
                byte[] bArr = new byte[read2];
                dataInputStream.readFully(bArr);
                this.caReference = new String(bArr);
                int read3 = dataInputStream.read();
                if (!(read3 == 0 || read3 == -1)) {
                    if (read3 == 66) {
                        int read4 = dataInputStream.read();
                        if (read4 <= 16) {
                            byte[] bArr2 = new byte[read4];
                            dataInputStream.readFully(bArr2);
                            this.altCAReference = new String(bArr2);
                            read3 = dataInputStream.read();
                        } else {
                            throw new IllegalArgumentException("Wrong length");
                        }
                    } else {
                        throw new IllegalArgumentException("Wrong tag");
                    }
                }
                while (read3 != -1) {
                    if (read3 == 0) {
                        read3 = dataInputStream.read();
                    } else {
                        throw new IllegalArgumentException("Bad file padding");
                    }
                }
                return;
            }
            throw new IllegalArgumentException("Wrong length");
        }
        throw new IllegalArgumentException("Wrong tag, expected " + Integer.toHexString(66) + ", found " + Integer.toHexString(read));
    }

    public String toString() {
        String str;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("CA reference: \"");
        sb2.append(this.caReference);
        sb2.append("\"");
        if (this.altCAReference != null) {
            str = ", Alternative CA reference: " + this.altCAReference;
        } else {
            str = "";
        }
        sb2.append(str);
        return sb2.toString();
    }

    public void writeObject(OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[36];
        bArr[0] = CAR_TAG;
        bArr[1] = (byte) this.caReference.length();
        System.arraycopy(this.caReference.getBytes(), 0, bArr, 2, bArr[1]);
        String str = this.altCAReference;
        if (str != null) {
            byte b = bArr[1];
            bArr[b + 2] = CAR_TAG;
            int i = b + 3;
            bArr[i] = (byte) str.length();
            System.arraycopy(this.altCAReference.getBytes(), 0, bArr, b + 4, bArr[i]);
        }
        outputStream.write(bArr);
    }

    public CVCAFile(short s, InputStream inputStream) throws IOException {
        this.caReference = null;
        this.altCAReference = null;
        this.fid = s;
        readObject(inputStream);
    }

    public CVCAFile(String str, String str2) {
        this(284, str, str2);
    }

    public CVCAFile(short s, String str, String str2) {
        this.caReference = null;
        this.altCAReference = null;
        if (str == null || str.length() > 16 || (str2 != null && str2.length() > 16)) {
            throw new IllegalArgumentException();
        }
        this.fid = s;
        this.caReference = str;
        this.altCAReference = str2;
    }

    public CVCAFile(short s, String str) {
        this(s, str, (String) null);
    }
}
