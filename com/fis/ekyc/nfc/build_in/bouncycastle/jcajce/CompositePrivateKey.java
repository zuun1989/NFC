package com.fis.ekyc.nfc.build_in.bouncycastle.jcajce;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1EncodableVector;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Encoding;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERSequence;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.misc.MiscObjectIdentifiers;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.AlgorithmIdentifier;
import java.io.IOException;
import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CompositePrivateKey implements PrivateKey {
    private final List<PrivateKey> keys;

    public CompositePrivateKey(PrivateKey... privateKeyArr) {
        if (privateKeyArr == null || privateKeyArr.length == 0) {
            throw new IllegalArgumentException("at least one public key must be provided");
        }
        ArrayList arrayList = new ArrayList(privateKeyArr.length);
        for (int i = 0; i != privateKeyArr.length; i++) {
            arrayList.add(privateKeyArr[i]);
        }
        this.keys = Collections.unmodifiableList(arrayList);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof CompositePrivateKey) {
            return this.keys.equals(((CompositePrivateKey) obj).keys);
        }
        return false;
    }

    public String getAlgorithm() {
        return "Composite";
    }

    public byte[] getEncoded() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        for (int i = 0; i != this.keys.size(); i++) {
            aSN1EncodableVector.add(PrivateKeyInfo.getInstance(this.keys.get(i).getEncoded()));
        }
        try {
            return new PrivateKeyInfo(new AlgorithmIdentifier(MiscObjectIdentifiers.id_alg_composite), new DERSequence(aSN1EncodableVector)).getEncoded(ASN1Encoding.DER);
        } catch (IOException e) {
            throw new IllegalStateException("unable to encode composite key: " + e.getMessage());
        }
    }

    public String getFormat() {
        return "PKCS#8";
    }

    public List<PrivateKey> getPrivateKeys() {
        return this.keys;
    }

    public int hashCode() {
        return this.keys.hashCode();
    }
}
