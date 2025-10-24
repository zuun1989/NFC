package com.fis.ekyc.nfc.build_in.bouncycastle.pqc.jcajce.provider.rainbow;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Encodable;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERNull;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.AlgorithmIdentifier;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.asn1.PQCObjectIdentifiers;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.asn1.RainbowPublicKey;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.rainbow.RainbowParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.rainbow.RainbowPublicKeyParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.rainbow.util.RainbowUtil;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.jcajce.provider.util.KeyUtil;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.jcajce.spec.RainbowPublicKeySpec;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.Arrays;
import java.security.PublicKey;

public class BCRainbowPublicKey implements PublicKey {
    private static final long serialVersionUID = 1;
    private short[][] coeffquadratic;
    private short[] coeffscalar;
    private short[][] coeffsingular;
    private int docLength;
    private RainbowParameters rainbowParams;

    public BCRainbowPublicKey(int i, short[][] sArr, short[][] sArr2, short[] sArr3) {
        this.docLength = i;
        this.coeffquadratic = sArr;
        this.coeffsingular = sArr2;
        this.coeffscalar = sArr3;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof BCRainbowPublicKey)) {
            return false;
        }
        BCRainbowPublicKey bCRainbowPublicKey = (BCRainbowPublicKey) obj;
        if (this.docLength != bCRainbowPublicKey.getDocLength() || !RainbowUtil.equals(this.coeffquadratic, bCRainbowPublicKey.getCoeffQuadratic()) || !RainbowUtil.equals(this.coeffsingular, bCRainbowPublicKey.getCoeffSingular()) || !RainbowUtil.equals(this.coeffscalar, bCRainbowPublicKey.getCoeffScalar())) {
            return false;
        }
        return true;
    }

    public final String getAlgorithm() {
        return "Rainbow";
    }

    public short[][] getCoeffQuadratic() {
        return this.coeffquadratic;
    }

    public short[] getCoeffScalar() {
        return Arrays.clone(this.coeffscalar);
    }

    public short[][] getCoeffSingular() {
        short[][] sArr = new short[this.coeffsingular.length][];
        int i = 0;
        while (true) {
            short[][] sArr2 = this.coeffsingular;
            if (i == sArr2.length) {
                return sArr;
            }
            sArr[i] = Arrays.clone(sArr2[i]);
            i++;
        }
    }

    public int getDocLength() {
        return this.docLength;
    }

    public byte[] getEncoded() {
        return KeyUtil.getEncodedSubjectPublicKeyInfo(new AlgorithmIdentifier(PQCObjectIdentifiers.rainbow, DERNull.INSTANCE), (ASN1Encodable) new RainbowPublicKey(this.docLength, this.coeffquadratic, this.coeffsingular, this.coeffscalar));
    }

    public String getFormat() {
        return "X.509";
    }

    public int hashCode() {
        return (((((this.docLength * 37) + Arrays.hashCode(this.coeffquadratic)) * 37) + Arrays.hashCode(this.coeffsingular)) * 37) + Arrays.hashCode(this.coeffscalar);
    }

    public BCRainbowPublicKey(RainbowPublicKeySpec rainbowPublicKeySpec) {
        this(rainbowPublicKeySpec.getDocLength(), rainbowPublicKeySpec.getCoeffQuadratic(), rainbowPublicKeySpec.getCoeffSingular(), rainbowPublicKeySpec.getCoeffScalar());
    }

    public BCRainbowPublicKey(RainbowPublicKeyParameters rainbowPublicKeyParameters) {
        this(rainbowPublicKeyParameters.getDocLength(), rainbowPublicKeyParameters.getCoeffQuadratic(), rainbowPublicKeyParameters.getCoeffSingular(), rainbowPublicKeyParameters.getCoeffScalar());
    }
}
