package com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.x509;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.CertificateList;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.util.JcaJceHelper;
import java.security.cert.CRLException;

class X509CRLInternal extends X509CRLImpl {
    private final byte[] encoding;

    public X509CRLInternal(JcaJceHelper jcaJceHelper, CertificateList certificateList, String str, byte[] bArr, boolean z, byte[] bArr2) {
        super(jcaJceHelper, certificateList, str, bArr, z);
        this.encoding = bArr2;
    }

    public byte[] getEncoded() throws CRLException {
        byte[] bArr = this.encoding;
        if (bArr != null) {
            return bArr;
        }
        throw new CRLException();
    }
}
