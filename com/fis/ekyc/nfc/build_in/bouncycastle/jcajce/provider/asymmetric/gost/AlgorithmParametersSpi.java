package com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.gost;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Encoding;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Sequence;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.cryptopro.GOST3410PublicKeyAlgParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.jce.spec.GOST3410ParameterSpec;
import com.fis.ekyc.nfc.build_in.bouncycastle.jce.spec.GOST3410PublicKeyParameterSetSpec;
import java.io.IOException;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;

public class AlgorithmParametersSpi extends java.security.AlgorithmParametersSpi {
    GOST3410ParameterSpec currentSpec;

    public byte[] engineGetEncoded() {
        try {
            return new GOST3410PublicKeyAlgParameters(new ASN1ObjectIdentifier(this.currentSpec.getPublicKeyParamSetOID()), new ASN1ObjectIdentifier(this.currentSpec.getDigestParamSetOID()), new ASN1ObjectIdentifier(this.currentSpec.getEncryptionParamSetOID())).getEncoded(ASN1Encoding.DER);
        } catch (IOException unused) {
            throw new RuntimeException("Error encoding GOST3410Parameters");
        }
    }

    public AlgorithmParameterSpec engineGetParameterSpec(Class cls) throws InvalidParameterSpecException {
        if (cls != null) {
            return localEngineGetParameterSpec(cls);
        }
        throw new NullPointerException("argument to getParameterSpec must not be null");
    }

    public void engineInit(AlgorithmParameterSpec algorithmParameterSpec) throws InvalidParameterSpecException {
        if (algorithmParameterSpec instanceof GOST3410ParameterSpec) {
            this.currentSpec = (GOST3410ParameterSpec) algorithmParameterSpec;
            return;
        }
        throw new InvalidParameterSpecException("GOST3410ParameterSpec required to initialise a GOST3410 algorithm parameters object");
    }

    public String engineToString() {
        return "GOST3410 Parameters";
    }

    public boolean isASN1FormatString(String str) {
        if (str == null || str.equals("ASN.1")) {
            return true;
        }
        return false;
    }

    public AlgorithmParameterSpec localEngineGetParameterSpec(Class cls) throws InvalidParameterSpecException {
        if (cls == GOST3410PublicKeyParameterSetSpec.class || cls == AlgorithmParameterSpec.class) {
            return this.currentSpec;
        }
        throw new InvalidParameterSpecException("unknown parameter spec passed to GOST3410 parameters object.");
    }

    public byte[] engineGetEncoded(String str) {
        if (isASN1FormatString(str) || str.equalsIgnoreCase("X.509")) {
            return engineGetEncoded();
        }
        return null;
    }

    public void engineInit(byte[] bArr) throws IOException {
        try {
            this.currentSpec = GOST3410ParameterSpec.fromPublicKeyAlg(GOST3410PublicKeyAlgParameters.getInstance((ASN1Sequence) ASN1Primitive.fromByteArray(bArr)));
        } catch (ClassCastException unused) {
            throw new IOException("Not a valid GOST3410 Parameter encoding.");
        } catch (ArrayIndexOutOfBoundsException unused2) {
            throw new IOException("Not a valid GOST3410 Parameter encoding.");
        }
    }

    public void engineInit(byte[] bArr, String str) throws IOException {
        if (isASN1FormatString(str) || str.equalsIgnoreCase("X.509")) {
            engineInit(bArr);
            return;
        }
        throw new IOException("Unknown parameter format " + str);
    }
}
