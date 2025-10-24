package com.fis.ekyc.nfc.build_in.scuba.smartcards;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.logging.Logger;

public class CardFileInputStream extends InputStream {
    private static final Logger LOGGER = Logger.getLogger("com.fis.ekyc.nfc.build_in.scuba");
    private final byte[] buffer;
    private int bufferLength;
    private int fileLength;
    private FileSystemStructured fs;
    private int markedOffset;
    private int offsetBufferInFile;
    private int offsetInBuffer;
    private FileInfo[] path;

    public CardFileInputStream(int i, FileSystemStructured fileSystemStructured) throws CardServiceException {
        this.fs = fileSystemStructured;
        synchronized (fileSystemStructured) {
            try {
                FileInfo[] selectedPath = fileSystemStructured.getSelectedPath();
                if (selectedPath == null || selectedPath.length < 1) {
                    throw new CardServiceException("No valid file selected, path = " + Arrays.toString(selectedPath));
                }
                FileInfo[] fileInfoArr = new FileInfo[selectedPath.length];
                this.path = fileInfoArr;
                System.arraycopy(selectedPath, 0, fileInfoArr, 0, selectedPath.length);
                this.fileLength = selectedPath[selectedPath.length - 1].getFileLength();
                this.buffer = new byte[i];
                this.bufferLength = 0;
                this.offsetBufferInFile = 0;
                this.offsetInBuffer = 0;
                this.markedOffset = -1;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private int fillBufferFromFile(FileInfo[] fileInfoArr, int i, int i2) throws CardServiceException {
        synchronized (this.fs) {
            try {
                if (i2 <= this.buffer.length) {
                    if (!Arrays.equals(this.fs.getSelectedPath(), fileInfoArr)) {
                        for (FileInfo fid : fileInfoArr) {
                            this.fs.selectFile(fid.getFID());
                        }
                    }
                    byte[] readBinary = this.fs.readBinary(i, i2);
                    if (readBinary == null) {
                        return 0;
                    }
                    System.arraycopy(readBinary, 0, this.buffer, 0, readBinary.length);
                    int length = readBinary.length;
                    return length;
                }
                throw new IllegalArgumentException("length too big");
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public synchronized int available() {
        return this.bufferLength - this.offsetInBuffer;
    }

    public int getLength() {
        return this.fileLength;
    }

    public int getPostion() {
        return this.offsetBufferInFile + this.offsetInBuffer;
    }

    public void mark(int i) {
        synchronized (this.fs) {
            this.markedOffset = this.offsetBufferInFile + this.offsetInBuffer;
        }
    }

    public boolean markSupported() {
        synchronized (this.fs) {
        }
        return true;
    }

    public int read() throws IOException {
        synchronized (this.fs) {
            try {
                if (!Arrays.equals(this.path, this.fs.getSelectedPath())) {
                    for (FileInfo fid : this.path) {
                        this.fs.selectFile(fid.getFID());
                    }
                }
                int i = this.offsetBufferInFile;
                int i2 = this.offsetInBuffer;
                int i3 = i + i2;
                int i4 = this.fileLength;
                if (i3 >= i4) {
                    return -1;
                }
                if (i2 >= this.bufferLength) {
                    int min = Math.min(this.buffer.length, i4 - i3);
                    int i5 = this.offsetBufferInFile + this.bufferLength;
                    int i6 = 0;
                    while (i6 == 0) {
                        i6 = fillBufferFromFile(this.path, i5, min);
                    }
                    this.offsetBufferInFile = i5;
                    this.offsetInBuffer = 0;
                    this.bufferLength = i6;
                }
                byte[] bArr = this.buffer;
                int i7 = this.offsetInBuffer;
                byte b = bArr[i7] & 255;
                this.offsetInBuffer = i7 + 1;
                return b;
            } catch (CardServiceException e) {
                throw new IOException("Unexpected exception", e);
            } catch (Exception e2) {
                throw new IOException("Unexpected exception", e2);
            } catch (CardServiceException e3) {
                throw new IOException("Unexpected exception", e3);
            }
        }
    }

    public void reset() throws IOException {
        synchronized (this.fs) {
            try {
                int i = this.markedOffset;
                if (i >= 0) {
                    this.offsetBufferInFile = i;
                    this.offsetInBuffer = 0;
                    this.bufferLength = 0;
                } else {
                    throw new IOException("Mark not set");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public long skip(long j) {
        synchronized (this.fs) {
            try {
                int i = this.bufferLength;
                int i2 = this.offsetInBuffer;
                if (j < ((long) (i - i2))) {
                    this.offsetInBuffer = (int) (((long) i2) + j);
                } else {
                    this.offsetBufferInFile = (int) (((long) (this.offsetBufferInFile + i2)) + j);
                    this.offsetInBuffer = 0;
                    this.bufferLength = 0;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return j;
    }
}
