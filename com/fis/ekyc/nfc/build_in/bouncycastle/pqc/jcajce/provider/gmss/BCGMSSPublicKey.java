package com.fis.ekyc.nfc.build_in.bouncycastle.pqc.jcajce.provider.gmss;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Encodable;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.AlgorithmIdentifier;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.CipherParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.asn1.GMSSPublicKey;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.asn1.PQCObjectIdentifiers;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.asn1.ParSet;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.gmss.GMSSParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.gmss.GMSSPublicKeyParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.jcajce.provider.util.KeyUtil;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.encoders.Hex;
import java.security.PublicKey;

public class BCGMSSPublicKey implements CipherParameters, PublicKey {
    private static final long serialVersionUID = 1;
    private GMSSParameters gmssParameterSet;
    private GMSSParameters gmssParams;
    private byte[] publicKeyBytes;

    public BCGMSSPublicKey(byte[] bArr, GMSSParameters gMSSParameters) {
        this.gmssParameterSet = gMSSParameters;
        this.publicKeyBytes = bArr;
    }

    public String getAlgorithm() {
        return "GMSS";
    }

    public byte[] getEncoded() {
        return KeyUtil.getEncodedSubjectPublicKeyInfo(new AlgorithmIdentifier(PQCObjectIdentifiers.gmss, new ParSet(this.gmssParameterSet.getNumOfLayers(), this.gmssParameterSet.getHeightOfTrees(), this.gmssParameterSet.getWinternitzParameter(), this.gmssParameterSet.getK()).toASN1Primitive()), (ASN1Encodable) new GMSSPublicKey(this.publicKeyBytes));
    }

    public String getFormat() {
        return "X.509";
    }

    public GMSSParameters getParameterSet() {
        return this.gmssParameterSet;
    }

    public byte[] getPublicKeyBytes() {
        return this.publicKeyBytes;
    }

    public String toString() {
        String str = "GMSS public key : " + new String(Hex.encode(this.publicKeyBytes)) + "\nHeight of Trees: \n";
        for (int i = 0; i < this.gmssParameterSet.getHeightOfTrees().length; i++) {
            str = str + "Layer " + i + " : " + this.gmssParameterSet.getHeightOfTrees()[i] + " WinternitzParameter: " + this.gmssParameterSet.getWinternitzParameter()[i] + " K: " + this.gmssParameterSet.getK()[i] + "\n";
        }
        return str;
    }

    public BCGMSSPublicKey(GMSSPublicKeyParameters gMSSPublicKeyParameters) {
        this(gMSSPublicKeyParameters.getPublicKey(), gMSSPublicKeyParameters.getParameters());
    }
}
