package com.fis.ekyc.nfc.build_in.cvc;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.nio.ByteBuffer;

public abstract class CVCObject implements Serializable {
    public static final int CVC_VERSION = 0;
    private static final int INT_LENGTH = 4;
    private static final int LONG_LENGTH = 8;
    public static final String NEWLINE = System.getProperty("line.separator");
    private static final long serialVersionUID = 1;
    private AbstractSequence parent;
    private final CVCTagEnum tag;

    public CVCObject(CVCTagEnum cVCTagEnum) {
        this.tag = cVCTagEnum;
    }

    public static int decodeLength(DataInputStream dataInputStream) throws IOException {
        int read = dataInputStream.read();
        if (read <= 127) {
            return read;
        }
        if ((read & 15) == 1) {
            return dataInputStream.readUnsignedByte();
        }
        return dataInputStream.readShort();
    }

    public static byte[] encodeLength(int i) {
        int i2;
        if (i <= 127) {
            i2 = 0;
        } else if (i > 255) {
            i2 = 2;
        } else {
            i2 = 1;
        }
        ByteBuffer allocate = ByteBuffer.allocate(i2 + 1);
        if (i2 == 0) {
            allocate.put(0, (byte) i);
        } else {
            allocate.put(0, (byte) (i2 + 128));
            if (i2 == 1) {
                allocate.put(1, (byte) i);
            } else {
                allocate.putShort(1, (short) i);
            }
        }
        return allocate.array();
    }

    public static byte[] toByteArray(Integer num) {
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.putInt(num.intValue());
        return trimByteArray(allocate.array());
    }

    public static byte[] trimByteArray(byte[] bArr) {
        int i = 0;
        boolean z = false;
        while (i < bArr.length) {
            if (bArr[i] != 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                break;
            }
            i++;
        }
        if (z) {
            byte[] bArr2 = new byte[(bArr.length - i)];
            System.arraycopy(bArr, i, bArr2, 0, bArr.length - i);
            return bArr2;
        }
        return new byte[]{0};
    }

    public abstract int encode(DataOutputStream dataOutputStream) throws IOException;

    public String getAsText() {
        return getAsText("", true);
    }

    public AbstractSequence getParent() {
        return this.parent;
    }

    public CVCTagEnum getTag() {
        return this.tag;
    }

    public void setParent(AbstractSequence abstractSequence) {
        this.parent = abstractSequence;
    }

    public String getAsText(boolean z) {
        return getAsText("", z);
    }

    public String getAsText(String str) {
        return getAsText(str, true);
    }

    public static byte[] toByteArray(Long l) {
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.putLong(l.longValue());
        return trimByteArray(allocate.array());
    }

    public String getAsText(String str, boolean z) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        if (z) {
            stringBuffer.append(Integer.toHexString(getTag().getValue()));
            stringBuffer.append(' ');
        }
        stringBuffer.append(getTag().name());
        stringBuffer.append("  ");
        return stringBuffer.toString();
    }
}
