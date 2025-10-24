package com.fis.ekyc.nfc.build_in.eidparser.lds;

import com.fis.ekyc.nfc.build_in.scuba.tlv.TLVInputStream;
import com.fis.ekyc.nfc.build_in.scuba.tlv.TLVOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class AbstractTaggedLDSFile extends AbstractLDSFile {
    private static final Logger LOGGER = Logger.getLogger("com.fis.ekyc.sdk.nfc.build_in..jmrtd");
    private static final long serialVersionUID = -4761360877353069639L;
    private int length;
    private int tag;

    public AbstractTaggedLDSFile(int i) {
        this.tag = i;
    }

    private byte[] getContent() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            writeContent(byteArrayOutputStream);
            byteArrayOutputStream.flush();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
            } catch (IOException e) {
                LOGGER.log(Level.FINE, "Error closing stream", e);
            }
            return byteArray;
        } catch (IOException e2) {
            throw new IllegalStateException("Could not get DG content", e2);
        } catch (Throwable th) {
            try {
                byteArrayOutputStream.close();
            } catch (IOException e3) {
                LOGGER.log(Level.FINE, "Error closing stream", e3);
            }
            throw th;
        }
    }

    public /* bridge */ /* synthetic */ byte[] getEncoded() {
        return super.getEncoded();
    }

    public int getLength() {
        if (this.length <= 0) {
            this.length = getContent().length;
        }
        return this.length;
    }

    public int getTag() {
        return this.tag;
    }

    public abstract void readContent(InputStream inputStream) throws IOException;

    public void readObject(InputStream inputStream) throws IOException {
        TLVInputStream tLVInputStream;
        if (inputStream instanceof TLVInputStream) {
            tLVInputStream = (TLVInputStream) inputStream;
        } else {
            tLVInputStream = new TLVInputStream(inputStream);
        }
        int readTag = tLVInputStream.readTag();
        if (readTag == this.tag) {
            this.length = tLVInputStream.readLength();
            readContent(tLVInputStream);
            return;
        }
        throw new IllegalArgumentException("Was expecting tag " + Integer.toHexString(this.tag) + ", found " + Integer.toHexString(readTag));
    }

    public String toString() {
        return "TaggedLDSFile [" + Integer.toHexString(getTag()) + " (" + getLength() + ")]";
    }

    public abstract void writeContent(OutputStream outputStream) throws IOException;

    public void writeObject(OutputStream outputStream) throws IOException {
        TLVOutputStream tLVOutputStream;
        int i;
        if (outputStream instanceof TLVOutputStream) {
            tLVOutputStream = (TLVOutputStream) outputStream;
        } else {
            tLVOutputStream = new TLVOutputStream(outputStream);
        }
        int tag2 = getTag();
        if (this.tag != tag2) {
            this.tag = tag2;
        }
        tLVOutputStream.writeTag(tag2);
        byte[] content = getContent();
        if (content == null) {
            i = 0;
        } else {
            i = content.length;
        }
        if (this.length != i) {
            this.length = i;
        }
        tLVOutputStream.writeValue(content);
    }

    public AbstractTaggedLDSFile(int i, InputStream inputStream) throws IOException {
        this.tag = i;
        readObject(inputStream);
    }
}
