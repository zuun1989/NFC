package com.fis.ekyc.nfc.build_in.eidparser.lds.io;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Logger;

public class PositionInputStream extends InputStream {
    private static final Logger LOGGER = Logger.getLogger("com.fis.ekyc.sdk.nfc.build_in..jmrtd");
    private static final long MARK_NOT_SET = -1;
    private InputStream carrier;
    private long markedPosition = MARK_NOT_SET;
    private long position = 0;

    public PositionInputStream(InputStream inputStream) {
        this.carrier = inputStream;
    }

    public long getPosition() {
        return this.position;
    }

    public synchronized void mark(int i) {
        this.carrier.mark(i);
        this.markedPosition = this.position;
    }

    public boolean markSupported() {
        return this.carrier.markSupported();
    }

    public int read() throws IOException {
        int read = this.carrier.read();
        if (read >= 0) {
            this.position++;
        }
        return read;
    }

    public synchronized void reset() throws IOException {
        this.carrier.reset();
        this.position = this.markedPosition;
    }

    public long skip(long j) throws IOException {
        long skip = this.carrier.skip(j);
        if (skip <= 0) {
            LOGGER.warning("Carrier (" + this.carrier.getClass().getCanonicalName() + ")'s skip(" + j + ") only skipped " + skip + ", position = " + this.position);
        }
        this.position += skip;
        return skip;
    }

    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        int read = this.carrier.read(bArr, i, i2);
        this.position += (long) read;
        return read;
    }
}
