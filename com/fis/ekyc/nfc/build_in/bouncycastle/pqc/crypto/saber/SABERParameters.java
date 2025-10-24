package com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.saber;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.eac.CertificateHolderAuthorization;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.CipherParameters;

public class SABERParameters implements CipherParameters {
    public static final SABERParameters firesaberkem128r3 = new SABERParameters("firesaberkem128r3", 4, 128);
    public static final SABERParameters firesaberkem192r3 = new SABERParameters("firesaberkem192r3", 4, CertificateHolderAuthorization.CVCA);
    public static final SABERParameters firesaberkem256r3 = new SABERParameters("firesaberkem256r3", 4, 256);
    public static final SABERParameters lightsaberkem128r3 = new SABERParameters("lightsaberkem128r3", 2, 128);
    public static final SABERParameters lightsaberkem192r3 = new SABERParameters("lightsaberkem192r3", 2, CertificateHolderAuthorization.CVCA);
    public static final SABERParameters lightsaberkem256r3 = new SABERParameters("lightsaberkem256r3", 2, 256);
    public static final SABERParameters saberkem128r3 = new SABERParameters("saberkem128r3", 3, 128);
    public static final SABERParameters saberkem192r3 = new SABERParameters("saberkem192r3", 3, CertificateHolderAuthorization.CVCA);
    public static final SABERParameters saberkem256r3 = new SABERParameters("saberkem256r3", 3, 256);
    private final int defaultKeySize;
    private final SABEREngine engine;
    private final int l;
    private final String name;

    public SABERParameters(String str, int i, int i2) {
        this.name = str;
        this.l = i;
        this.defaultKeySize = i2;
        this.engine = new SABEREngine(i, i2);
    }

    public int getDefaultKeySize() {
        return this.defaultKeySize;
    }

    public SABEREngine getEngine() {
        return this.engine;
    }

    public int getL() {
        return this.l;
    }

    public String getName() {
        return this.name;
    }
}
