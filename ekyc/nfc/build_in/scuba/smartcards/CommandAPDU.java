package com.fis.ekyc.nfc.build_in.scuba.smartcards;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.Arrays;

public final class CommandAPDU implements Serializable {
    private static final int MAX_APDU_SIZE = 65544;
    private static final long serialVersionUID = 398698301286670877L;
    private byte[] apdu;
    private transient int dataOffset;
    private transient int nc;
    private transient int ne;

    public CommandAPDU(byte[] bArr) {
        this.apdu = (byte[]) bArr.clone();
        parse();
    }

    private static int arrayLength(byte[] bArr) {
        if (bArr != null) {
            return bArr.length;
        }
        return 0;
    }

    private void checkArrayBounds(byte[] bArr, int i, int i2) {
        if (i < 0 || i2 < 0) {
            throw new IllegalArgumentException("Offset and length must not be negative");
        } else if (bArr == null) {
            if (i != 0 && i2 != 0) {
                throw new IllegalArgumentException("offset and length must be 0 if array is null");
            }
        } else if (i > bArr.length - i2) {
            throw new IllegalArgumentException("Offset plus length exceed array size");
        }
    }

    private void parse() {
        byte[] bArr = this.apdu;
        if (bArr.length < 4) {
            throw new IllegalArgumentException("apdu must be at least 4 bytes long");
        } else if (bArr.length != 4) {
            byte b = bArr[4] & 255;
            byte b2 = 256;
            if (bArr.length == 5) {
                if (b == 0) {
                    b = 256;
                }
                this.ne = b;
            } else if (b != 0) {
                if (bArr.length == b + 5) {
                    this.nc = b;
                    this.dataOffset = 5;
                } else if (bArr.length == b + 6) {
                    this.nc = b;
                    this.dataOffset = 5;
                    byte b3 = bArr[bArr.length - 1] & 255;
                    if (b3 != 0) {
                        b2 = b3;
                    }
                    this.ne = b2;
                } else {
                    throw new IllegalArgumentException("Invalid APDU: length=" + this.apdu.length + ", b1=" + b);
                }
            } else if (bArr.length >= 7) {
                byte b4 = ((bArr[5] & 255) << 8) | (bArr[6] & 255);
                byte b5 = 65536;
                if (bArr.length == 7) {
                    if (b4 == 0) {
                        b4 = 65536;
                    }
                    this.ne = b4;
                } else if (b4 == 0) {
                    throw new IllegalArgumentException("Invalid APDU: length=" + this.apdu.length + ", b1=" + b + ", b2||b3=" + b4);
                } else if (bArr.length == b4 + 7) {
                    this.nc = b4;
                    this.dataOffset = 7;
                } else if (bArr.length == b4 + 9) {
                    this.nc = b4;
                    this.dataOffset = 7;
                    int length = bArr.length;
                    byte b6 = (bArr[length - 1] & 255) | ((bArr[length - 2] & 255) << 8);
                    if (b6 != 0) {
                        b5 = b6;
                    }
                    this.ne = b5;
                } else {
                    throw new IllegalArgumentException("Invalid APDU: length=" + this.apdu.length + ", b1=" + b + ", b2||b3=" + b4);
                }
            } else {
                throw new IllegalArgumentException("Invalid APDU: length=" + this.apdu.length + ", b1=" + b);
            }
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        this.apdu = (byte[]) objectInputStream.readUnshared();
        parse();
    }

    private void setHeader(int i, int i2, int i3, int i4) {
        byte[] bArr = this.apdu;
        bArr[0] = (byte) i;
        bArr[1] = (byte) i2;
        bArr[2] = (byte) i3;
        bArr[3] = (byte) i4;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CommandAPDU)) {
            return false;
        }
        return Arrays.equals(this.apdu, ((CommandAPDU) obj).apdu);
    }

    public byte[] getBytes() {
        return (byte[]) this.apdu.clone();
    }

    public int getCLA() {
        return this.apdu[0] & 255;
    }

    public byte[] getData() {
        int i = this.nc;
        byte[] bArr = new byte[i];
        System.arraycopy(this.apdu, this.dataOffset, bArr, 0, i);
        return bArr;
    }

    public int getINS() {
        return this.apdu[1] & 255;
    }

    public int getNc() {
        return this.nc;
    }

    public int getNe() {
        return this.ne;
    }

    public int getP1() {
        return this.apdu[2] & 255;
    }

    public int getP2() {
        return this.apdu[3] & 255;
    }

    public int hashCode() {
        return Arrays.hashCode(this.apdu);
    }

    public String toString() {
        return "CommmandAPDU: " + this.apdu.length + " bytes, nc=" + this.nc + ", ne=" + this.ne;
    }

    public CommandAPDU(byte[] bArr, int i, int i2) {
        checkArrayBounds(bArr, i, i2);
        byte[] bArr2 = new byte[i2];
        this.apdu = bArr2;
        System.arraycopy(bArr, i, bArr2, 0, i2);
        parse();
    }

    public CommandAPDU(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[byteBuffer.remaining()];
        this.apdu = bArr;
        byteBuffer.get(bArr);
        parse();
    }

    public CommandAPDU(int i, int i2, int i3, int i4) {
        this(i, i2, i3, i4, (byte[]) null, 0, 0, 0);
    }

    public CommandAPDU(int i, int i2, int i3, int i4, int i5) {
        this(i, i2, i3, i4, (byte[]) null, 0, 0, i5);
    }

    public CommandAPDU(int i, int i2, int i3, int i4, byte[] bArr) {
        this(i, i2, i3, i4, bArr, 0, arrayLength(bArr), 0);
    }

    public CommandAPDU(int i, int i2, int i3, int i4, byte[] bArr, int i5, int i6) {
        this(i, i2, i3, i4, bArr, i5, i6, 0);
    }

    public CommandAPDU(int i, int i2, int i3, int i4, byte[] bArr, int i5) {
        this(i, i2, i3, i4, bArr, 0, arrayLength(bArr), i5);
    }

    public CommandAPDU(int i, int i2, int i3, int i4, byte[] bArr, int i5, int i6, int i7) {
        byte b;
        byte[] bArr2 = bArr;
        int i8 = i5;
        int i9 = i6;
        int i10 = i7;
        checkArrayBounds(bArr2, i8, i9);
        if (i9 > 65535) {
            throw new IllegalArgumentException("dataLength is too large");
        } else if (i10 < 0) {
            throw new IllegalArgumentException("ne must not be negative");
        } else if (i10 <= 65536) {
            this.ne = i10;
            this.nc = i9;
            byte b2 = 0;
            if (i9 == 0) {
                if (i10 == 0) {
                    this.apdu = new byte[4];
                    setHeader(i, i2, i3, i4);
                } else if (i10 <= 256) {
                    b2 = i10 != 256 ? (byte) i10 : b2;
                    this.apdu = new byte[5];
                    setHeader(i, i2, i3, i4);
                    this.apdu[4] = b2;
                } else {
                    if (i10 == 65536) {
                        b = 0;
                    } else {
                        b2 = (byte) (i10 >> 8);
                        b = (byte) i10;
                    }
                    this.apdu = new byte[7];
                    setHeader(i, i2, i3, i4);
                    byte[] bArr3 = this.apdu;
                    bArr3[5] = b2;
                    bArr3[6] = b;
                }
            } else if (i10 == 0) {
                if (i9 <= 255) {
                    this.apdu = new byte[(i9 + 5)];
                    setHeader(i, i2, i3, i4);
                    byte[] bArr4 = this.apdu;
                    bArr4[4] = (byte) i9;
                    this.dataOffset = 5;
                    System.arraycopy(bArr2, i8, bArr4, 5, i9);
                    return;
                }
                this.apdu = new byte[(i9 + 7)];
                setHeader(i, i2, i3, i4);
                byte[] bArr5 = this.apdu;
                bArr5[4] = 0;
                bArr5[5] = (byte) (i9 >> 8);
                bArr5[6] = (byte) i9;
                this.dataOffset = 7;
                System.arraycopy(bArr2, i8, bArr5, 7, i9);
            } else if (i9 > 255 || i10 > 256) {
                this.apdu = new byte[(i9 + 9)];
                setHeader(i, i2, i3, i4);
                byte[] bArr6 = this.apdu;
                bArr6[4] = 0;
                bArr6[5] = (byte) (i9 >> 8);
                bArr6[6] = (byte) i9;
                this.dataOffset = 7;
                System.arraycopy(bArr2, i8, bArr6, 7, i9);
                if (i10 != 65536) {
                    byte[] bArr7 = this.apdu;
                    int length = bArr7.length;
                    bArr7[length - 2] = (byte) (i10 >> 8);
                    bArr7[length - 1] = (byte) i10;
                }
            } else {
                this.apdu = new byte[(i9 + 6)];
                setHeader(i, i2, i3, i4);
                byte[] bArr8 = this.apdu;
                bArr8[4] = (byte) i9;
                this.dataOffset = 5;
                System.arraycopy(bArr2, i8, bArr8, 5, i9);
                byte[] bArr9 = this.apdu;
                bArr9[bArr9.length - 1] = i10 != 256 ? (byte) i10 : b2;
            }
        } else {
            throw new IllegalArgumentException("ne is too large");
        }
    }
}
