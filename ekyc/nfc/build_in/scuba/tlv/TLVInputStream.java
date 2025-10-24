package com.fis.ekyc.nfc.build_in.scuba.tlv;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.eac.CertificateBody;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

public class TLVInputStream extends InputStream {
    private static final int MAX_BUFFER_LENGTH = 65535;
    private int bufferSize = 0;
    private DataInputStream inputStream;
    private TLVInputState markedState;
    private final InputStream originalInputStream;
    private TLVInputState state;

    public TLVInputStream(InputStream inputStream2) {
        DataInputStream dataInputStream;
        try {
            if ((inputStream2 instanceof BufferedInputStream) || (inputStream2 instanceof ByteArrayInputStream)) {
                this.bufferSize = inputStream2.available();
            }
        } catch (IOException unused) {
        }
        this.originalInputStream = inputStream2;
        if (inputStream2 instanceof DataInputStream) {
            dataInputStream = (DataInputStream) inputStream2;
        } else {
            dataInputStream = new DataInputStream(inputStream2);
        }
        this.inputStream = dataInputStream;
        this.state = new TLVInputState();
        this.markedState = null;
    }

    private long skipValue() throws IOException {
        if (!this.state.isAtStartOfTag() && !this.state.isAtStartOfLength()) {
            return skip((long) this.state.getValueBytesLeft());
        }
        return 0;
    }

    public int available() throws IOException {
        return this.inputStream.available();
    }

    public void close() throws IOException {
        this.inputStream.close();
    }

    public synchronized void mark(int i) {
        this.inputStream.mark(i);
        this.markedState = (TLVInputState) this.state.clone();
    }

    public boolean markSupported() {
        return this.inputStream.markSupported();
    }

    public int read() throws IOException {
        int read = this.inputStream.read();
        if (read < 0) {
            return -1;
        }
        this.state.updateValueBytesProcessed(1);
        return read;
    }

    public int readLength() throws IOException {
        if (this.state.isAtStartOfLength()) {
            int readUnsignedByte = this.inputStream.readUnsignedByte();
            int i = 1;
            if ((readUnsignedByte & 128) != 0) {
                int i2 = readUnsignedByte & CertificateBody.profileType;
                int i3 = 0;
                int i4 = 1;
                for (int i5 = 0; i5 < i2; i5++) {
                    i4++;
                    i3 = (i3 << 8) | this.inputStream.readUnsignedByte();
                }
                readUnsignedByte = i3;
                i = i4;
            }
            this.state.setLengthProcessed(readUnsignedByte, i);
            return readUnsignedByte;
        }
        throw new IllegalStateException("Not at start of length");
    }

    public int readTag() throws IOException {
        if (this.state.isAtStartOfTag() || this.state.isProcessingValue()) {
            int readUnsignedByte = this.inputStream.readUnsignedByte();
            int i = 1;
            while (true) {
                if (readUnsignedByte != 0 && readUnsignedByte != 255) {
                    break;
                }
                readUnsignedByte = this.inputStream.readUnsignedByte();
                i++;
            }
            if ((readUnsignedByte & 31) == 31) {
                int readUnsignedByte2 = this.inputStream.readUnsignedByte();
                while (true) {
                    i++;
                    if ((readUnsignedByte2 & 128) != 128) {
                        break;
                    }
                    readUnsignedByte = (readUnsignedByte << 8) | (readUnsignedByte2 & CertificateBody.profileType);
                    readUnsignedByte2 = this.inputStream.readUnsignedByte();
                }
                readUnsignedByte = (readUnsignedByte << 8) | (readUnsignedByte2 & CertificateBody.profileType);
            }
            this.state.setTagProcessed(readUnsignedByte, i);
            return readUnsignedByte;
        }
        throw new IllegalStateException("Not at start of tag");
    }

    public byte[] readValue() throws IOException {
        if (this.state.isProcessingValue()) {
            int length = this.state.getLength();
            byte[] bArr = new byte[length];
            this.inputStream.readFully(bArr);
            this.state.updateValueBytesProcessed(length);
            return bArr;
        }
        throw new IllegalStateException("Not yet processing value!");
    }

    public synchronized void reset() throws IOException {
        if (markSupported()) {
            this.inputStream.reset();
            this.state = this.markedState;
            this.markedState = null;
        } else {
            throw new IOException("mark/reset not supported");
        }
    }

    public long skip(long j) throws IOException {
        if (j <= 0) {
            return 0;
        }
        long skip = this.inputStream.skip(j);
        this.state.updateValueBytesProcessed((int) skip);
        return skip;
    }

    public void skipToTag(int i) throws IOException {
        while (true) {
            if (!this.state.isAtStartOfTag()) {
                if (this.state.isAtStartOfLength()) {
                    readLength();
                    if (TLVUtil.isPrimitive(this.state.getTag())) {
                        skipValue();
                    }
                } else if (TLVUtil.isPrimitive(this.state.getTag())) {
                    skipValue();
                }
            }
            int readTag = readTag();
            if (readTag != i) {
                if (TLVUtil.isPrimitive(readTag) && ((int) skipValue()) < readLength()) {
                    return;
                }
            } else {
                return;
            }
        }
    }

    public String toString() {
        return this.state.toString();
    }
}
