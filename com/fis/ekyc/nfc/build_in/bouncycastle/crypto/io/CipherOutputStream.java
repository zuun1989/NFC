package com.fis.ekyc.nfc.build_in.bouncycastle.crypto.io;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.BufferedBlockCipher;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.StreamCipher;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.modes.AEADBlockCipher;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class CipherOutputStream extends FilterOutputStream {
    private AEADBlockCipher aeadBlockCipher;
    private byte[] buf;
    private BufferedBlockCipher bufferedBlockCipher;
    private final byte[] oneByte = new byte[1];
    private StreamCipher streamCipher;

    public CipherOutputStream(OutputStream outputStream, BufferedBlockCipher bufferedBlockCipher2) {
        super(outputStream);
        this.bufferedBlockCipher = bufferedBlockCipher2;
    }

    private void ensureCapacity(int i, boolean z) {
        if (z) {
            BufferedBlockCipher bufferedBlockCipher2 = this.bufferedBlockCipher;
            if (bufferedBlockCipher2 != null) {
                i = bufferedBlockCipher2.getOutputSize(i);
            } else {
                AEADBlockCipher aEADBlockCipher = this.aeadBlockCipher;
                if (aEADBlockCipher != null) {
                    i = aEADBlockCipher.getOutputSize(i);
                }
            }
        } else {
            BufferedBlockCipher bufferedBlockCipher3 = this.bufferedBlockCipher;
            if (bufferedBlockCipher3 != null) {
                i = bufferedBlockCipher3.getUpdateOutputSize(i);
            } else {
                AEADBlockCipher aEADBlockCipher2 = this.aeadBlockCipher;
                if (aEADBlockCipher2 != null) {
                    i = aEADBlockCipher2.getUpdateOutputSize(i);
                }
            }
        }
        byte[] bArr = this.buf;
        if (bArr == null || bArr.length < i) {
            this.buf = new byte[i];
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x005a A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x005b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void close() throws java.io.IOException {
        /*
            r4 = this;
            r0 = 1
            r1 = 0
            r4.ensureCapacity(r1, r0)
            com.fis.ekyc.nfc.build_in.bouncycastle.crypto.BufferedBlockCipher r0 = r4.bufferedBlockCipher     // Catch:{ InvalidCipherTextException -> 0x001b, Exception -> 0x0019 }
            if (r0 == 0) goto L_0x001d
            byte[] r2 = r4.buf     // Catch:{ InvalidCipherTextException -> 0x001b, Exception -> 0x0019 }
            int r0 = r0.doFinal(r2, r1)     // Catch:{ InvalidCipherTextException -> 0x001b, Exception -> 0x0019 }
            if (r0 == 0) goto L_0x0038
            java.io.OutputStream r2 = r4.out     // Catch:{ InvalidCipherTextException -> 0x001b, Exception -> 0x0019 }
            byte[] r3 = r4.buf     // Catch:{ InvalidCipherTextException -> 0x001b, Exception -> 0x0019 }
            r2.write(r3, r1, r0)     // Catch:{ InvalidCipherTextException -> 0x001b, Exception -> 0x0019 }
            goto L_0x0038
        L_0x0019:
            r0 = move-exception
            goto L_0x003a
        L_0x001b:
            r0 = move-exception
            goto L_0x0043
        L_0x001d:
            com.fis.ekyc.nfc.build_in.bouncycastle.crypto.modes.AEADBlockCipher r0 = r4.aeadBlockCipher     // Catch:{ InvalidCipherTextException -> 0x001b, Exception -> 0x0019 }
            if (r0 == 0) goto L_0x0031
            byte[] r2 = r4.buf     // Catch:{ InvalidCipherTextException -> 0x001b, Exception -> 0x0019 }
            int r0 = r0.doFinal(r2, r1)     // Catch:{ InvalidCipherTextException -> 0x001b, Exception -> 0x0019 }
            if (r0 == 0) goto L_0x0038
            java.io.OutputStream r2 = r4.out     // Catch:{ InvalidCipherTextException -> 0x001b, Exception -> 0x0019 }
            byte[] r3 = r4.buf     // Catch:{ InvalidCipherTextException -> 0x001b, Exception -> 0x0019 }
            r2.write(r3, r1, r0)     // Catch:{ InvalidCipherTextException -> 0x001b, Exception -> 0x0019 }
            goto L_0x0038
        L_0x0031:
            com.fis.ekyc.nfc.build_in.bouncycastle.crypto.StreamCipher r0 = r4.streamCipher     // Catch:{ InvalidCipherTextException -> 0x001b, Exception -> 0x0019 }
            if (r0 == 0) goto L_0x0038
            r0.reset()     // Catch:{ InvalidCipherTextException -> 0x001b, Exception -> 0x0019 }
        L_0x0038:
            r0 = 0
            goto L_0x004b
        L_0x003a:
            com.fis.ekyc.nfc.build_in.bouncycastle.crypto.io.CipherIOException r1 = new com.fis.ekyc.nfc.build_in.bouncycastle.crypto.io.CipherIOException
            java.lang.String r2 = "Error closing stream: "
            r1.<init>(r2, r0)
        L_0x0041:
            r0 = r1
            goto L_0x004b
        L_0x0043:
            com.fis.ekyc.nfc.build_in.bouncycastle.crypto.io.InvalidCipherTextIOException r1 = new com.fis.ekyc.nfc.build_in.bouncycastle.crypto.io.InvalidCipherTextIOException
            java.lang.String r2 = "Error finalising cipher data"
            r1.<init>(r2, r0)
            goto L_0x0041
        L_0x004b:
            r4.flush()     // Catch:{ IOException -> 0x0054 }
            java.io.OutputStream r1 = r4.out     // Catch:{ IOException -> 0x0054 }
            r1.close()     // Catch:{ IOException -> 0x0054 }
            goto L_0x0058
        L_0x0054:
            r1 = move-exception
            if (r0 != 0) goto L_0x0058
            r0 = r1
        L_0x0058:
            if (r0 != 0) goto L_0x005b
            return
        L_0x005b:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fis.ekyc.nfc.build_in.bouncycastle.crypto.io.CipherOutputStream.close():void");
    }

    public void flush() throws IOException {
        this.out.flush();
    }

    public void write(int i) throws IOException {
        byte[] bArr = this.oneByte;
        byte b = (byte) i;
        bArr[0] = b;
        StreamCipher streamCipher2 = this.streamCipher;
        if (streamCipher2 != null) {
            this.out.write(streamCipher2.returnByte(b));
        } else {
            write(bArr, 0, 1);
        }
    }

    public CipherOutputStream(OutputStream outputStream, StreamCipher streamCipher2) {
        super(outputStream);
        this.streamCipher = streamCipher2;
    }

    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    public void write(byte[] bArr, int i, int i2) throws IOException {
        ensureCapacity(i2, false);
        BufferedBlockCipher bufferedBlockCipher2 = this.bufferedBlockCipher;
        if (bufferedBlockCipher2 != null) {
            int processBytes = bufferedBlockCipher2.processBytes(bArr, i, i2, this.buf, 0);
            if (processBytes != 0) {
                this.out.write(this.buf, 0, processBytes);
                return;
            }
            return;
        }
        AEADBlockCipher aEADBlockCipher = this.aeadBlockCipher;
        if (aEADBlockCipher != null) {
            int processBytes2 = aEADBlockCipher.processBytes(bArr, i, i2, this.buf, 0);
            if (processBytes2 != 0) {
                this.out.write(this.buf, 0, processBytes2);
                return;
            }
            return;
        }
        this.streamCipher.processBytes(bArr, i, i2, this.buf, 0);
        this.out.write(this.buf, 0, i2);
    }

    public CipherOutputStream(OutputStream outputStream, AEADBlockCipher aEADBlockCipher) {
        super(outputStream);
        this.aeadBlockCipher = aEADBlockCipher;
    }
}
