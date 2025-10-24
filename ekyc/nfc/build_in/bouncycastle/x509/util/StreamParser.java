package com.fis.ekyc.nfc.build_in.bouncycastle.x509.util;

import java.util.Collection;

public interface StreamParser {
    Object read() throws StreamParsingException;

    Collection readAll() throws StreamParsingException;
}
