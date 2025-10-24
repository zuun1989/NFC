package com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.x509;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.BasicConstraints;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.Certificate;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.util.JcaJceHelper;
import java.security.cert.CertificateEncodingException;

class X509CertificateInternal extends X509CertificateImpl {
    private final byte[] encoding;

    public X509CertificateInternal(JcaJceHelper jcaJceHelper, Certificate certificate, BasicConstraints basicConstraints, boolean[] zArr, String str, byte[] bArr, byte[] bArr2) {
        super(jcaJceHelper, certificate, basicConstraints, zArr, str, bArr);
        this.encoding = bArr2;
    }

    public byte[] getEncoded() throws CertificateEncodingException {
        byte[] bArr = this.encoding;
        if (bArr != null) {
            return bArr;
        }
        throw new CertificateEncodingException();
    }
}
