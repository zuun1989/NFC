package com.fis.ekyc.nfc.build_in.bouncycastle.asn1;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.eac.CertificateBody;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.Arrays;
import com.fis.ekyc.nfc.build_in.scuba.smartcards.ISOFileInfo;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class ASN1ObjectIdentifier extends ASN1Primitive {
    private static final long LONG_LIMIT = 72057594037927808L;
    private static final ConcurrentMap<OidHandle, ASN1ObjectIdentifier> pool = new ConcurrentHashMap();
    private byte[] body;
    private final String identifier;

    public static class OidHandle {
        private final byte[] enc;
        private final int key;

        public OidHandle(byte[] bArr) {
            this.key = Arrays.hashCode(bArr);
            this.enc = bArr;
        }

        public boolean equals(Object obj) {
            if (obj instanceof OidHandle) {
                return Arrays.areEqual(this.enc, ((OidHandle) obj).enc);
            }
            return false;
        }

        public int hashCode() {
            return this.key;
        }
    }

    public ASN1ObjectIdentifier(byte[] bArr) {
        int i;
        byte[] bArr2 = bArr;
        StringBuffer stringBuffer = new StringBuffer();
        boolean z = true;
        BigInteger bigInteger = null;
        int i2 = 0;
        long j = 0;
        while (i2 != bArr2.length) {
            byte b = bArr2[i2];
            if (j <= LONG_LIMIT) {
                i = i2;
                long j2 = j + ((long) (b & Byte.MAX_VALUE));
                if ((b & ISOFileInfo.DATA_BYTES1) == 0) {
                    if (z) {
                        if (j2 < 40) {
                            stringBuffer.append('0');
                        } else if (j2 < 80) {
                            stringBuffer.append('1');
                            j2 -= 40;
                        } else {
                            stringBuffer.append('2');
                            j2 -= 80;
                        }
                        z = false;
                    }
                    stringBuffer.append('.');
                    stringBuffer.append(j2);
                } else {
                    j = j2 << 7;
                    i2 = i + 1;
                }
            } else {
                i = i2;
                BigInteger or = (bigInteger == null ? BigInteger.valueOf(j) : bigInteger).or(BigInteger.valueOf((long) (b & Byte.MAX_VALUE)));
                if ((b & ISOFileInfo.DATA_BYTES1) == 0) {
                    if (z) {
                        stringBuffer.append('2');
                        or = or.subtract(BigInteger.valueOf(80));
                        z = false;
                    }
                    stringBuffer.append('.');
                    stringBuffer.append(or);
                    bigInteger = null;
                } else {
                    bigInteger = or.shiftLeft(7);
                    i2 = i + 1;
                }
            }
            j = 0;
            i2 = i + 1;
        }
        this.identifier = stringBuffer.toString();
        this.body = Arrays.clone(bArr);
    }

    private void doOutput(ByteArrayOutputStream byteArrayOutputStream) {
        OIDTokenizer oIDTokenizer = new OIDTokenizer(this.identifier);
        int parseInt = Integer.parseInt(oIDTokenizer.nextToken()) * 40;
        String nextToken = oIDTokenizer.nextToken();
        if (nextToken.length() <= 18) {
            writeField(byteArrayOutputStream, ((long) parseInt) + Long.parseLong(nextToken));
        } else {
            writeField(byteArrayOutputStream, new BigInteger(nextToken).add(BigInteger.valueOf((long) parseInt)));
        }
        while (oIDTokenizer.hasMoreTokens()) {
            String nextToken2 = oIDTokenizer.nextToken();
            if (nextToken2.length() <= 18) {
                writeField(byteArrayOutputStream, Long.parseLong(nextToken2));
            } else {
                writeField(byteArrayOutputStream, new BigInteger(nextToken2));
            }
        }
    }

    public static ASN1ObjectIdentifier fromOctetString(byte[] bArr) {
        ASN1ObjectIdentifier aSN1ObjectIdentifier = pool.get(new OidHandle(bArr));
        if (aSN1ObjectIdentifier == null) {
            return new ASN1ObjectIdentifier(bArr);
        }
        return aSN1ObjectIdentifier;
    }

    private synchronized byte[] getBody() {
        try {
            if (this.body == null) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                doOutput(byteArrayOutputStream);
                this.body = byteArrayOutputStream.toByteArray();
            }
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
        return this.body;
    }

    public static ASN1ObjectIdentifier getInstance(Object obj) {
        if (obj == null || (obj instanceof ASN1ObjectIdentifier)) {
            return (ASN1ObjectIdentifier) obj;
        }
        if (obj instanceof ASN1Encodable) {
            ASN1Primitive aSN1Primitive = ((ASN1Encodable) obj).toASN1Primitive();
            if (aSN1Primitive instanceof ASN1ObjectIdentifier) {
                return (ASN1ObjectIdentifier) aSN1Primitive;
            }
        }
        if (obj instanceof byte[]) {
            try {
                return (ASN1ObjectIdentifier) ASN1Primitive.fromByteArray((byte[]) obj);
            } catch (IOException e) {
                throw new IllegalArgumentException("failed to construct object identifier from byte[]: " + e.getMessage());
            }
        } else {
            throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
        }
    }

    private static boolean isValidBranchID(String str, int i) {
        int length = str.length();
        int i2 = 0;
        while (true) {
            int i3 = length - 1;
            if (i3 >= i) {
                char charAt = str.charAt(i3);
                if (charAt == '.') {
                    if (i2 == 0 || (i2 > 1 && str.charAt(length) == '0')) {
                        return false;
                    }
                    i2 = 0;
                } else if ('0' > charAt || charAt > '9') {
                    return false;
                } else {
                    i2++;
                }
                length = i3;
            } else if (i2 == 0 || (i2 > 1 && str.charAt(length) == '0')) {
                return false;
            } else {
                return true;
            }
        }
        return false;
    }

    private static boolean isValidIdentifier(String str) {
        char charAt;
        if (str.length() < 3 || str.charAt(1) != '.' || (charAt = str.charAt(0)) < '0' || charAt > '2') {
            return false;
        }
        return isValidBranchID(str, 2);
    }

    private void writeField(ByteArrayOutputStream byteArrayOutputStream, long j) {
        byte[] bArr = new byte[9];
        int i = 8;
        bArr[8] = (byte) (((int) j) & CertificateBody.profileType);
        while (j >= 128) {
            j >>= 7;
            i--;
            bArr[i] = (byte) ((((int) j) & CertificateBody.profileType) | 128);
        }
        byteArrayOutputStream.write(bArr, i, 9 - i);
    }

    public boolean asn1Equals(ASN1Primitive aSN1Primitive) {
        if (aSN1Primitive == this) {
            return true;
        }
        if (!(aSN1Primitive instanceof ASN1ObjectIdentifier)) {
            return false;
        }
        return this.identifier.equals(((ASN1ObjectIdentifier) aSN1Primitive).identifier);
    }

    public ASN1ObjectIdentifier branch(String str) {
        return new ASN1ObjectIdentifier(this, str);
    }

    public void encode(ASN1OutputStream aSN1OutputStream, boolean z) throws IOException {
        aSN1OutputStream.writeEncoded(z, 6, getBody());
    }

    public int encodedLength() throws IOException {
        int length = getBody().length;
        return StreamUtil.calculateBodyLength(length) + 1 + length;
    }

    public String getId() {
        return this.identifier;
    }

    public int hashCode() {
        return this.identifier.hashCode();
    }

    public ASN1ObjectIdentifier intern() {
        OidHandle oidHandle = new OidHandle(getBody());
        ConcurrentMap<OidHandle, ASN1ObjectIdentifier> concurrentMap = pool;
        ASN1ObjectIdentifier aSN1ObjectIdentifier = concurrentMap.get(oidHandle);
        if (aSN1ObjectIdentifier != null) {
            return aSN1ObjectIdentifier;
        }
        ASN1ObjectIdentifier putIfAbsent = concurrentMap.putIfAbsent(oidHandle, this);
        if (putIfAbsent == null) {
            return this;
        }
        return putIfAbsent;
    }

    public boolean isConstructed() {
        return false;
    }

    public boolean on(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        String id = getId();
        String id2 = aSN1ObjectIdentifier.getId();
        if (id.length() <= id2.length() || id.charAt(id2.length()) != '.' || !id.startsWith(id2)) {
            return false;
        }
        return true;
    }

    public String toString() {
        return getId();
    }

    private void writeField(ByteArrayOutputStream byteArrayOutputStream, BigInteger bigInteger) {
        int bitLength = (bigInteger.bitLength() + 6) / 7;
        if (bitLength == 0) {
            byteArrayOutputStream.write(0);
            return;
        }
        byte[] bArr = new byte[bitLength];
        int i = bitLength - 1;
        for (int i2 = i; i2 >= 0; i2--) {
            bArr[i2] = (byte) ((bigInteger.intValue() & CertificateBody.profileType) | 128);
            bigInteger = bigInteger.shiftRight(7);
        }
        bArr[i] = (byte) (bArr[i] & Byte.MAX_VALUE);
        byteArrayOutputStream.write(bArr, 0, bitLength);
    }

    public static ASN1ObjectIdentifier getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        ASN1Primitive object = aSN1TaggedObject.getObject();
        if (z || (object instanceof ASN1ObjectIdentifier)) {
            return getInstance(object);
        }
        return fromOctetString(ASN1OctetString.getInstance(object).getOctets());
    }

    public ASN1ObjectIdentifier(String str) {
        if (str == null) {
            throw new NullPointerException("'identifier' cannot be null");
        } else if (isValidIdentifier(str)) {
            this.identifier = str;
        } else {
            throw new IllegalArgumentException("string " + str + " not an OID");
        }
    }

    public ASN1ObjectIdentifier(ASN1ObjectIdentifier aSN1ObjectIdentifier, String str) {
        if (isValidBranchID(str, 0)) {
            this.identifier = aSN1ObjectIdentifier.getId() + "." + str;
            return;
        }
        throw new IllegalArgumentException("string " + str + " not a valid OID branch");
    }
}
