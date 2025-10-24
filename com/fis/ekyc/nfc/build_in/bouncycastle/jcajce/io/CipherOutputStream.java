package com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.io;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import javax.crypto.Cipher;

public class CipherOutputStream extends FilterOutputStream {
    private final Cipher cipher;
    private final byte[] oneByte = new byte[1];

    public CipherOutputStream(OutputStream outputStream, Cipher cipher2) {
        super(outputStream);
        this.cipher = cipher2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0043 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0044  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void close() throws java.io.IOException {
        /*
            r4 = this;
            javax.crypto.Cipher r0 = r4.cipher     // Catch:{ GeneralSecurityException -> 0x0010, Exception -> 0x000e }
            byte[] r0 = r0.doFinal()     // Catch:{ GeneralSecurityException -> 0x0010, Exception -> 0x000e }
            if (r0 == 0) goto L_0x0012
            java.io.OutputStream r1 = r4.out     // Catch:{ GeneralSecurityException -> 0x0010, Exception -> 0x000e }
            r1.write(r0)     // Catch:{ GeneralSecurityException -> 0x0010, Exception -> 0x000e }
            goto L_0x0012
        L_0x000e:
            r0 = move-exception
            goto L_0x0014
        L_0x0010:
            r0 = move-exception
            goto L_0x002c
        L_0x0012:
            r0 = 0
            goto L_0x0034
        L_0x0014:
            java.io.IOException r1 = new java.io.IOException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Error closing stream: "
            r2.append(r3)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
        L_0x002a:
            r0 = r1
            goto L_0x0034
        L_0x002c:
            com.fis.ekyc.nfc.build_in.bouncycastle.crypto.io.InvalidCipherTextIOException r1 = new com.fis.ekyc.nfc.build_in.bouncycastle.crypto.io.InvalidCipherTextIOException
            java.lang.String r2 = "Error during cipher finalisation"
            r1.<init>(r2, r0)
            goto L_0x002a
        L_0x0034:
            r4.flush()     // Catch:{ IOException -> 0x003d }
            java.io.OutputStream r1 = r4.out     // Catch:{ IOException -> 0x003d }
            r1.close()     // Catch:{ IOException -> 0x003d }
            goto L_0x0041
        L_0x003d:
            r1 = move-exception
            if (r0 != 0) goto L_0x0041
            r0 = r1
        L_0x0041:
            if (r0 != 0) goto L_0x0044
            return
        L_0x0044:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.io.CipherOutputStream.close():void");
    }

    public void flush() throws IOException {
        this.out.flush();
    }

    public void write(int i) throws IOException {
        byte[] bArr = this.oneByte;
        bArr[0] = (byte) i;
        write(bArr, 0, 1);
    }

    public void write(byte[] bArr, int i, int i2) throws IOException {
        byte[] update = this.cipher.update(bArr, i, i2);
        if (update != null) {
            this.out.write(update);
        }
    }
}
