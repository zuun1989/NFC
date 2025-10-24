package com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.util;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import java.io.IOException;
import java.security.PrivateKey;
import java.security.PublicKey;

public interface AsymmetricKeyInfoConverter {
    PrivateKey generatePrivate(PrivateKeyInfo privateKeyInfo) throws IOException;

    PublicKey generatePublic(SubjectPublicKeyInfo subjectPublicKeyInfo) throws IOException;
}
