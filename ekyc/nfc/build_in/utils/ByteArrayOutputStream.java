package com.fis.ekyc.nfc.build_in.utils;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.SequenceInputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ByteArrayOutputStream extends OutputStream {
    private static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
    private final List<byte[]> buffers;
    private int count;
    private byte[] currentBuffer;
    private int currentBufferIndex;
    private int filledBufferSum;

    public ByteArrayOutputStream() {
        this(1024);
    }

    private void needNewBuffer(int i) {
        if (this.currentBufferIndex < this.buffers.size() - 1) {
            this.filledBufferSum += this.currentBuffer.length;
            int i2 = this.currentBufferIndex + 1;
            this.currentBufferIndex = i2;
            this.currentBuffer = this.buffers.get(i2);
            return;
        }
        byte[] bArr = this.currentBuffer;
        if (bArr == null) {
            this.filledBufferSum = 0;
        } else {
            i = Math.max(bArr.length << 1, i - this.filledBufferSum);
            this.filledBufferSum += this.currentBuffer.length;
        }
        this.currentBufferIndex++;
        byte[] bArr2 = new byte[i];
        this.currentBuffer = bArr2;
        this.buffers.add(bArr2);
    }

    public static InputStream toBufferedInputStream(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byteArrayOutputStream.write(inputStream);
        return byteArrayOutputStream.toBufferedInputStream();
    }

    public void close() throws IOException {
    }

    public synchronized void reset() {
        this.count = 0;
        this.filledBufferSum = 0;
        this.currentBufferIndex = 0;
        this.currentBuffer = this.buffers.get(0);
    }

    public synchronized int size() {
        return this.count;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002e, code lost:
        return r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized byte[] toByteArray() {
        /*
            r7 = this;
            monitor-enter(r7)
            int r0 = r7.count     // Catch:{ all -> 0x0009 }
            if (r0 != 0) goto L_0x000b
            byte[] r0 = EMPTY_BYTE_ARRAY     // Catch:{ all -> 0x0009 }
            monitor-exit(r7)
            return r0
        L_0x0009:
            r0 = move-exception
            goto L_0x002f
        L_0x000b:
            byte[] r1 = new byte[r0]     // Catch:{ all -> 0x0009 }
            java.util.List<byte[]> r2 = r7.buffers     // Catch:{ all -> 0x0009 }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x0009 }
            r3 = 0
            r4 = r3
        L_0x0015:
            boolean r5 = r2.hasNext()     // Catch:{ all -> 0x0009 }
            if (r5 == 0) goto L_0x002d
            java.lang.Object r5 = r2.next()     // Catch:{ all -> 0x0009 }
            byte[] r5 = (byte[]) r5     // Catch:{ all -> 0x0009 }
            int r6 = r5.length     // Catch:{ all -> 0x0009 }
            int r6 = java.lang.Math.min(r6, r0)     // Catch:{ all -> 0x0009 }
            java.lang.System.arraycopy(r5, r3, r1, r4, r6)     // Catch:{ all -> 0x0009 }
            int r4 = r4 + r6
            int r0 = r0 - r6
            if (r0 != 0) goto L_0x0015
        L_0x002d:
            monitor-exit(r7)
            return r1
        L_0x002f:
            monitor-exit(r7)     // Catch:{ all -> 0x0009 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fis.ekyc.nfc.build_in.utils.ByteArrayOutputStream.toByteArray():byte[]");
    }

    public String toString() {
        return new String(toByteArray());
    }

    public void write(byte[] bArr, int i, int i2) {
        int i3;
        if (i < 0 || i > bArr.length || i2 < 0 || (i3 = i + i2) > bArr.length || i3 < 0) {
            throw new IndexOutOfBoundsException();
        } else if (i2 != 0) {
            synchronized (this) {
                try {
                    int i4 = this.count;
                    int i5 = i4 + i2;
                    int i6 = i4 - this.filledBufferSum;
                    while (i2 > 0) {
                        int min = Math.min(i2, this.currentBuffer.length - i6);
                        System.arraycopy(bArr, i3 - i2, this.currentBuffer, i6, min);
                        i2 -= min;
                        if (i2 > 0) {
                            needNewBuffer(i5);
                            i6 = 0;
                        }
                    }
                    this.count = i5;
                } finally {
                }
            }
        }
    }

    public synchronized void writeTo(OutputStream outputStream) throws IOException {
        int i = this.count;
        for (byte[] next : this.buffers) {
            int min = Math.min(next.length, i);
            outputStream.write(next, 0, min);
            i -= min;
            if (i == 0) {
                break;
            }
        }
    }

    public ByteArrayOutputStream(int i) {
        this.buffers = new ArrayList();
        if (i >= 0) {
            synchronized (this) {
                needNewBuffer(i);
            }
            return;
        }
        throw new IllegalArgumentException("Negative initial size: " + i);
    }

    public String toString(String str) throws UnsupportedEncodingException {
        return new String(toByteArray(), str);
    }

    private InputStream toBufferedInputStream() {
        int i = this.count;
        if (i == 0) {
            return new ClosedInputStream();
        }
        ArrayList arrayList = new ArrayList(this.buffers.size());
        for (byte[] next : this.buffers) {
            int min = Math.min(next.length, i);
            arrayList.add(new ByteArrayInputStream(next, 0, min));
            i -= min;
            if (i == 0) {
                break;
            }
        }
        return new SequenceInputStream(Collections.enumeration(arrayList));
    }

    public synchronized void write(int i) {
        try {
            int i2 = this.count;
            int i3 = i2 - this.filledBufferSum;
            if (i3 == this.currentBuffer.length) {
                needNewBuffer(i2 + 1);
                i3 = 0;
            }
            this.currentBuffer[i3] = (byte) i;
            this.count++;
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
    }

    public synchronized int write(InputStream inputStream) throws IOException {
        int i;
        try {
            int i2 = this.count - this.filledBufferSum;
            byte[] bArr = this.currentBuffer;
            int read = inputStream.read(bArr, i2, bArr.length - i2);
            i = 0;
            while (read != -1) {
                i += read;
                i2 += read;
                this.count += read;
                byte[] bArr2 = this.currentBuffer;
                if (i2 == bArr2.length) {
                    needNewBuffer(bArr2.length);
                    i2 = 0;
                }
                byte[] bArr3 = this.currentBuffer;
                read = inputStream.read(bArr3, i2, bArr3.length - i2);
            }
        } finally {
            while (true) {
            }
        }
        return i;
    }
}
