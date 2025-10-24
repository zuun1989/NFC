package com.fis.ekyc.nfc.build_in.eidparser.lds.io;

import com.fis.ekyc.nfc.build_in.eidparser.io.FragmentBuffer;
import com.fis.ekyc.nfc.build_in.eidparser.io.PositionInputStream;
import java.io.IOException;
import java.io.InputStream;

public class InputStreamBuffer {
    /* access modifiers changed from: private */
    public FragmentBuffer buffer;
    /* access modifiers changed from: private */
    public PositionInputStream carrier;

    public InputStreamBuffer(InputStream inputStream, int i) {
        PositionInputStream positionInputStream = new PositionInputStream(inputStream);
        this.carrier = positionInputStream;
        positionInputStream.mark(i);
        this.buffer = new FragmentBuffer(i);
    }

    public synchronized int getBytesBuffered() {
        return this.buffer.getBytesBuffered();
    }

    public SubInputStream getInputStream() {
        SubInputStream subInputStream;
        synchronized (this.carrier) {
            subInputStream = new SubInputStream(this.carrier);
        }
        return subInputStream;
    }

    public int getLength() {
        return this.buffer.getLength();
    }

    public synchronized int getPosition() {
        return this.buffer.getPosition();
    }

    public String toString() {
        return "InputStreamBuffer [" + this.buffer + "]";
    }

    public void updateFrom(InputStreamBuffer inputStreamBuffer) {
        this.buffer.updateFrom(inputStreamBuffer.buffer);
    }

    public class SubInputStream extends InputStream {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private int markedPosition = -1;
        private int position = 0;
        private Object syncObject;

        public SubInputStream(Object obj) {
            this.syncObject = obj;
        }

        private void syncCarrierPosition(int i) throws IOException {
            if (((long) i) != InputStreamBuffer.this.carrier.getPosition()) {
                InputStreamBuffer.this.carrier.reset();
                int i2 = 0;
                while (i2 < i) {
                    i2 = (int) (((long) i2) + InputStreamBuffer.this.carrier.skip((long) (i - i2)));
                }
            }
        }

        public int available() throws IOException {
            return InputStreamBuffer.this.buffer.getBufferedLength(this.position);
        }

        public void close() throws IOException {
        }

        public FragmentBuffer getBuffer() {
            return InputStreamBuffer.this.buffer;
        }

        public int getPosition() {
            return this.position;
        }

        public synchronized void mark(int i) {
            this.markedPosition = this.position;
        }

        public boolean markSupported() {
            return true;
        }

        public int read() throws IOException {
            synchronized (this.syncObject) {
                try {
                    if (this.position >= InputStreamBuffer.this.buffer.getLength()) {
                        return -1;
                    }
                    if (InputStreamBuffer.this.buffer.isCoveredByFragment(this.position)) {
                        byte[] buffer = InputStreamBuffer.this.buffer.getBuffer();
                        int i = this.position;
                        this.position = i + 1;
                        byte b = buffer[i] & 255;
                        return b;
                    }
                    if (InputStreamBuffer.this.carrier.markSupported()) {
                        syncCarrierPosition(this.position);
                    }
                    int read = InputStreamBuffer.this.carrier.read();
                    if (read < 0) {
                        return -1;
                    }
                    FragmentBuffer access$000 = InputStreamBuffer.this.buffer;
                    int i2 = this.position;
                    this.position = i2 + 1;
                    access$000.addFragment(i2, (byte) read);
                    return read;
                } catch (IOException e) {
                    throw e;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public synchronized void reset() throws IOException {
            int i = this.markedPosition;
            if (i >= 0) {
                this.position = i;
            } else {
                throw new IOException("Invalid reset, was mark() called?");
            }
        }

        public long skip(long j) throws IOException {
            long j2;
            synchronized (this.syncObject) {
                try {
                    int bufferedLength = InputStreamBuffer.this.buffer.getBufferedLength(this.position);
                    long j3 = (long) bufferedLength;
                    if (j <= j3) {
                        this.position = (int) (((long) this.position) + j);
                        return j;
                    }
                    this.position += bufferedLength;
                    if (InputStreamBuffer.this.carrier.markSupported()) {
                        syncCarrierPosition(this.position);
                        j2 = InputStreamBuffer.this.carrier.skip(j - j3);
                        this.position += (int) j2;
                    } else {
                        j2 = super.skip(j - j3);
                    }
                    long j4 = j3 + j2;
                    return j4;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public int read(byte[] bArr) throws IOException {
            int read;
            synchronized (this.syncObject) {
                read = read(bArr, 0, bArr.length);
            }
            return read;
        }

        public int read(byte[] bArr, int i, int i2) throws IOException {
            synchronized (this.syncObject) {
                if (bArr != null) {
                    if (i >= 0 && i2 >= 0) {
                        try {
                            if (i2 <= bArr.length - i) {
                                if (i2 == 0) {
                                    return 0;
                                }
                                if (i2 > InputStreamBuffer.this.buffer.getLength() - this.position) {
                                    i2 = InputStreamBuffer.this.buffer.getLength() - this.position;
                                }
                                if (this.position >= InputStreamBuffer.this.buffer.getLength()) {
                                    return -1;
                                }
                                if (InputStreamBuffer.this.carrier.markSupported()) {
                                    syncCarrierPosition(this.position);
                                }
                                FragmentBuffer.Fragment smallestUnbufferedFragment = InputStreamBuffer.this.buffer.getSmallestUnbufferedFragment(this.position, i2);
                                if (smallestUnbufferedFragment.getLength() > 0) {
                                    int offset = smallestUnbufferedFragment.getOffset() - this.position;
                                    int length = smallestUnbufferedFragment.getLength();
                                    System.arraycopy(InputStreamBuffer.this.buffer.getBuffer(), this.position, bArr, i, offset);
                                    this.position += offset;
                                    if (InputStreamBuffer.this.carrier.markSupported()) {
                                        syncCarrierPosition(this.position);
                                    }
                                    int i3 = i + offset;
                                    int read = InputStreamBuffer.this.carrier.read(bArr, i3, length);
                                    InputStreamBuffer.this.buffer.addFragment(smallestUnbufferedFragment.getOffset(), bArr, i3, read);
                                    this.position += read;
                                    int i4 = offset + read;
                                    return i4;
                                }
                                int min = Math.min(i2, InputStreamBuffer.this.buffer.getLength() - this.position);
                                System.arraycopy(InputStreamBuffer.this.buffer.getBuffer(), this.position, bArr, i, min);
                                this.position += min;
                                return min;
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    throw new IndexOutOfBoundsException();
                }
                throw new NullPointerException();
            }
        }
    }
}
