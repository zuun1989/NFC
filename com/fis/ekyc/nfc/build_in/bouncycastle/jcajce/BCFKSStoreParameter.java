package com.fis.ekyc.nfc.build_in.bouncycastle.jcajce;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.util.PBKDFConfig;
import java.io.OutputStream;
import java.security.KeyStore;

public class BCFKSStoreParameter implements KeyStore.LoadStoreParameter {
    private OutputStream out;
    private final KeyStore.ProtectionParameter protectionParameter;
    private final PBKDFConfig storeConfig;

    public BCFKSStoreParameter(OutputStream outputStream, PBKDFConfig pBKDFConfig, char[] cArr) {
        this(outputStream, pBKDFConfig, (KeyStore.ProtectionParameter) new KeyStore.PasswordProtection(cArr));
    }

    public OutputStream getOutputStream() {
        return this.out;
    }

    public KeyStore.ProtectionParameter getProtectionParameter() {
        return this.protectionParameter;
    }

    public PBKDFConfig getStorePBKDFConfig() {
        return this.storeConfig;
    }

    public BCFKSStoreParameter(OutputStream outputStream, PBKDFConfig pBKDFConfig, KeyStore.ProtectionParameter protectionParameter2) {
        this.out = outputStream;
        this.storeConfig = pBKDFConfig;
        this.protectionParameter = protectionParameter2;
    }
}
