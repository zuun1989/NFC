package com.fis.ekyc.nfc.build_in.eidparser.lds.icao;

import com.fis.ekyc.nfc.build_in.eidparser.Util;
import com.fis.ekyc.nfc.build_in.eidparser.lds.DataGroup;
import com.fis.ekyc.nfc.build_in.eidparser.lds.LDSFile;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DG15File extends DataGroup {
    private static final Logger LOGGER = Logger.getLogger("com.fis.ekyc.sdk.nfc.build_in..jmrtd");
    private static final String[] PUBLIC_KEY_ALGORITHMS = {"RSA", "EC"};
    private static final long serialVersionUID = 3834304239673755744L;
    private PublicKey publicKey;

    public DG15File(PublicKey publicKey2) {
        super(LDSFile.EF_DG15_TAG);
        this.publicKey = publicKey2;
    }

    private static PublicKey getPublicKey(byte[] bArr) throws GeneralSecurityException {
        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(bArr);
        String[] strArr = PUBLIC_KEY_ALGORITHMS;
        int length = strArr.length;
        int i = 0;
        while (i < length) {
            try {
                return Util.getPublicKey(strArr[i], x509EncodedKeySpec);
            } catch (InvalidKeySpecException e) {
                LOGGER.log(Level.FINE, "Ignore, try next algorithm", e);
                i++;
            }
        }
        throw new InvalidAlgorithmParameterException();
    }

    public boolean equals(Object obj) {
        if (obj != null && obj.getClass() == getClass()) {
            return this.publicKey.equals(((DG15File) obj).publicKey);
        }
        return false;
    }

    public int hashCode() {
        return (this.publicKey.hashCode() * 5) + 61;
    }

    public void readContent(InputStream inputStream) throws IOException {
        DataInputStream dataInputStream;
        if (inputStream instanceof DataInputStream) {
            dataInputStream = (DataInputStream) inputStream;
        } else {
            dataInputStream = new DataInputStream(inputStream);
        }
        try {
            byte[] bArr = new byte[getLength()];
            dataInputStream.readFully(bArr);
            this.publicKey = getPublicKey(bArr);
        } catch (GeneralSecurityException e) {
            LOGGER.log(Level.WARNING, "Unexpected exception while reading DG15 content", e);
        }
    }

    public String toString() {
        return "DG15File [" + Util.getDetailedPublicKeyAlgorithm(this.publicKey) + "]";
    }

    public void writeContent(OutputStream outputStream) throws IOException {
        outputStream.write(this.publicKey.getEncoded());
    }

    public DG15File(InputStream inputStream) throws IOException {
        super(LDSFile.EF_DG15_TAG, inputStream);
    }

    public PublicKey getPublicKey() {
        return this.publicKey;
    }
}
