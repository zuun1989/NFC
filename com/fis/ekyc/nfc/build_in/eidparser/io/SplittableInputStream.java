package com.fis.ekyc.nfc.build_in.eidparser.io;

import com.fis.ekyc.nfc.build_in.eidparser.io.InputStreamBuffer;
import java.io.IOException;
import java.io.InputStream;

public class SplittableInputStream extends InputStream {
    private InputStreamBuffer.SubInputStream carrier;
    private InputStreamBuffer inputStreamBuffer;

    public SplittableInputStream(InputStream inputStream, int i) {
        InputStreamBuffer inputStreamBuffer2 = new InputStreamBuffer(inputStream, i);
        this.inputStreamBuffer = inputStreamBuffer2;
        this.carrier = inputStreamBuffer2.getInputStream();
    }

    public int available() throws IOException {
        return this.carrier.available();
    }

    public void close() throws IOException {
        this.carrier.close();
    }

    public int getBytesBuffered() {
        return this.inputStreamBuffer.getBytesBuffered();
    }

    public InputStream getInputStream(int i) {
        try {
            InputStreamBuffer.SubInputStream inputStream = this.inputStreamBuffer.getInputStream();
            long j = 0;
            while (true) {
                long j2 = (long) i;
                if (j >= j2) {
                    return inputStream;
                }
                j += inputStream.skip(j2 - j);
            }
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    public int getLength() {
        return this.inputStreamBuffer.getLength();
    }

    public int getPosition() {
        return this.carrier.getPosition();
    }

    public synchronized void mark(int i) {
        this.carrier.mark(i);
    }

    public boolean markSupported() {
        return this.carrier.markSupported();
    }

    public int read() throws IOException {
        return this.carrier.read();
    }

    public synchronized void reset() throws IOException {
        this.carrier.reset();
    }

    public long skip(long j) throws IOException {
        return this.carrier.skip(j);
    }

    public void updateFrom(SplittableInputStream splittableInputStream) {
        this.inputStreamBuffer.updateFrom(splittableInputStream.inputStreamBuffer);
    }
}
