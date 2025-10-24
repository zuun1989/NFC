package com.fis.ekyc.nfc.build_in.bouncycastle.x509;

import com.fis.ekyc.nfc.build_in.bouncycastle.x509.util.StreamParsingException;
import java.io.InputStream;
import java.util.Collection;

public abstract class X509StreamParserSpi {
    public abstract void engineInit(InputStream inputStream);

    public abstract Object engineRead() throws StreamParsingException;

    public abstract Collection engineReadAll() throws StreamParsingException;
}
