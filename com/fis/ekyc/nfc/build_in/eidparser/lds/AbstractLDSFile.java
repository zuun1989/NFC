package com.fis.ekyc.nfc.build_in.eidparser.lds;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

abstract class AbstractLDSFile implements LDSFile {
    private static final Logger LOGGER = Logger.getLogger("com.fis.ekyc.sdk.nfc.build_in..jmrtd");
    private static final long serialVersionUID = -4908935713109830409L;

    public byte[] getEncoded() {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            writeObject(byteArrayOutputStream);
            byteArrayOutputStream.flush();
            byteArrayOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            LOGGER.log(Level.WARNING, "Exception", e);
            return null;
        }
    }

    public abstract void readObject(InputStream inputStream) throws IOException;

    public abstract void writeObject(OutputStream outputStream) throws IOException;
}
