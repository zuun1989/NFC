package com.fis.ekyc.nfc.build_in.bouncycastle.jce.spec;

import com.fis.ekyc.nfc.build_in.bouncycastle.jce.interfaces.IESKey;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.KeySpec;

public class IEKeySpec implements KeySpec, IESKey {
    private PrivateKey privKey;
    private PublicKey pubKey;

    public IEKeySpec(PrivateKey privateKey, PublicKey publicKey) {
        this.privKey = privateKey;
        this.pubKey = publicKey;
    }

    public String getAlgorithm() {
        return "IES";
    }

    public byte[] getEncoded() {
        return null;
    }

    public String getFormat() {
        return null;
    }

    public PrivateKey getPrivate() {
        return this.privKey;
    }

    public PublicKey getPublic() {
        return this.pubKey;
    }
}
