package com.fis.ekyc.nfc.build_in.bouncycastle.pqc.jcajce.provider.rainbow;

import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.rainbow.Layer;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.rainbow.RainbowPrivateKeyParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.rainbow.util.RainbowUtil;
import com.fis.ekyc.nfc.build_in.bouncycastle.pqc.jcajce.spec.RainbowPrivateKeySpec;
import java.security.PrivateKey;
import java.util.Arrays;

public class BCRainbowPrivateKey implements PrivateKey {
    private static final long serialVersionUID = 1;
    private short[][] A1inv;
    private short[][] A2inv;
    private short[] b1;
    private short[] b2;
    private Layer[] layers;
    private int[] vi;

    public BCRainbowPrivateKey(short[][] sArr, short[] sArr2, short[][] sArr3, short[] sArr4, int[] iArr, Layer[] layerArr) {
        this.A1inv = sArr;
        this.b1 = sArr2;
        this.A2inv = sArr3;
        this.b2 = sArr4;
        this.vi = iArr;
        this.layers = layerArr;
    }

    public boolean equals(Object obj) {
        boolean z;
        if (obj == null || !(obj instanceof BCRainbowPrivateKey)) {
            return false;
        }
        BCRainbowPrivateKey bCRainbowPrivateKey = (BCRainbowPrivateKey) obj;
        if (!RainbowUtil.equals(this.A1inv, bCRainbowPrivateKey.getInvA1()) || !RainbowUtil.equals(this.A2inv, bCRainbowPrivateKey.getInvA2()) || !RainbowUtil.equals(this.b1, bCRainbowPrivateKey.getB1()) || !RainbowUtil.equals(this.b2, bCRainbowPrivateKey.getB2()) || !Arrays.equals(this.vi, bCRainbowPrivateKey.getVi())) {
            z = false;
        } else {
            z = true;
        }
        if (this.layers.length != bCRainbowPrivateKey.getLayers().length) {
            return false;
        }
        for (int length = this.layers.length - 1; length >= 0; length--) {
            z &= this.layers[length].equals(bCRainbowPrivateKey.getLayers()[length]);
        }
        return z;
    }

    public final String getAlgorithm() {
        return "Rainbow";
    }

    public short[] getB1() {
        return this.b1;
    }

    public short[] getB2() {
        return this.b2;
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public byte[] getEncoded() {
        /*
            r8 = this;
            com.fis.ekyc.nfc.build_in.bouncycastle.pqc.asn1.RainbowPrivateKey r7 = new com.fis.ekyc.nfc.build_in.bouncycastle.pqc.asn1.RainbowPrivateKey
            short[][] r1 = r8.A1inv
            short[] r2 = r8.b1
            short[][] r3 = r8.A2inv
            short[] r4 = r8.b2
            int[] r5 = r8.vi
            com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.rainbow.Layer[] r6 = r8.layers
            r0 = r7
            r0.<init>(r1, r2, r3, r4, r5, r6)
            r0 = 0
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.AlgorithmIdentifier r1 = new com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.AlgorithmIdentifier     // Catch:{ IOException -> 0x0025 }
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier r2 = com.fis.ekyc.nfc.build_in.bouncycastle.pqc.asn1.PQCObjectIdentifiers.rainbow     // Catch:{ IOException -> 0x0025 }
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERNull r3 = com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERNull.INSTANCE     // Catch:{ IOException -> 0x0025 }
            r1.<init>(r2, r3)     // Catch:{ IOException -> 0x0025 }
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.PrivateKeyInfo r2 = new com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.PrivateKeyInfo     // Catch:{ IOException -> 0x0025 }
            r2.<init>(r1, r7)     // Catch:{ IOException -> 0x0025 }
            byte[] r0 = r2.getEncoded()     // Catch:{  }
        L_0x0025:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fis.ekyc.nfc.build_in.bouncycastle.pqc.jcajce.provider.rainbow.BCRainbowPrivateKey.getEncoded():byte[]");
    }

    public String getFormat() {
        return "PKCS#8";
    }

    public short[][] getInvA1() {
        return this.A1inv;
    }

    public short[][] getInvA2() {
        return this.A2inv;
    }

    public Layer[] getLayers() {
        return this.layers;
    }

    public int[] getVi() {
        return this.vi;
    }

    public int hashCode() {
        int length = (((((((((this.layers.length * 37) + com.fis.ekyc.nfc.build_in.bouncycastle.util.Arrays.hashCode(this.A1inv)) * 37) + com.fis.ekyc.nfc.build_in.bouncycastle.util.Arrays.hashCode(this.b1)) * 37) + com.fis.ekyc.nfc.build_in.bouncycastle.util.Arrays.hashCode(this.A2inv)) * 37) + com.fis.ekyc.nfc.build_in.bouncycastle.util.Arrays.hashCode(this.b2)) * 37) + com.fis.ekyc.nfc.build_in.bouncycastle.util.Arrays.hashCode(this.vi);
        for (int length2 = this.layers.length - 1; length2 >= 0; length2--) {
            length = (length * 37) + this.layers[length2].hashCode();
        }
        return length;
    }

    public BCRainbowPrivateKey(RainbowPrivateKeySpec rainbowPrivateKeySpec) {
        this(rainbowPrivateKeySpec.getInvA1(), rainbowPrivateKeySpec.getB1(), rainbowPrivateKeySpec.getInvA2(), rainbowPrivateKeySpec.getB2(), rainbowPrivateKeySpec.getVi(), rainbowPrivateKeySpec.getLayers());
    }

    public BCRainbowPrivateKey(RainbowPrivateKeyParameters rainbowPrivateKeyParameters) {
        this(rainbowPrivateKeyParameters.getInvA1(), rainbowPrivateKeyParameters.getB1(), rainbowPrivateKeyParameters.getInvA2(), rainbowPrivateKeyParameters.getB2(), rainbowPrivateKeyParameters.getVi(), rainbowPrivateKeyParameters.getLayers());
    }
}
