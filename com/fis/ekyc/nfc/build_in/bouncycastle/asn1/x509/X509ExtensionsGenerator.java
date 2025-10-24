package com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Encodable;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Encoding;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1OctetString;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DEROctetString;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Vector;

public class X509ExtensionsGenerator {
    private Vector extOrdering = new Vector();
    private Hashtable extensions = new Hashtable();

    public void addExtension(ASN1ObjectIdentifier aSN1ObjectIdentifier, boolean z, ASN1Encodable aSN1Encodable) {
        try {
            addExtension(aSN1ObjectIdentifier, z, aSN1Encodable.toASN1Primitive().getEncoded(ASN1Encoding.DER));
        } catch (IOException e) {
            throw new IllegalArgumentException("error encoding value: " + e);
        }
    }

    public X509Extensions generate() {
        return new X509Extensions(this.extOrdering, this.extensions);
    }

    public boolean isEmpty() {
        return this.extOrdering.isEmpty();
    }

    public void reset() {
        this.extensions = new Hashtable();
        this.extOrdering = new Vector();
    }

    public void addExtension(ASN1ObjectIdentifier aSN1ObjectIdentifier, boolean z, byte[] bArr) {
        if (!this.extensions.containsKey(aSN1ObjectIdentifier)) {
            this.extOrdering.addElement(aSN1ObjectIdentifier);
            this.extensions.put(aSN1ObjectIdentifier, new X509Extension(z, (ASN1OctetString) new DEROctetString(bArr)));
            return;
        }
        throw new IllegalArgumentException("extension " + aSN1ObjectIdentifier + " already added");
    }
}
