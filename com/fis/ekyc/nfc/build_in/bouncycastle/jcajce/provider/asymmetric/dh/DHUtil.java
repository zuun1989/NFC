package com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.dh;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.DHParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.Arrays;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.Fingerprint;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.Strings;
import java.math.BigInteger;

class DHUtil {
    private static String generateKeyFingerprint(BigInteger bigInteger, DHParameters dHParameters) {
        return new Fingerprint(Arrays.concatenate(bigInteger.toByteArray(), dHParameters.getP().toByteArray(), dHParameters.getG().toByteArray())).toString();
    }

    public static String privateKeyToString(String str, BigInteger bigInteger, DHParameters dHParameters) {
        StringBuffer stringBuffer = new StringBuffer();
        String lineSeparator = Strings.lineSeparator();
        BigInteger modPow = dHParameters.getG().modPow(bigInteger, dHParameters.getP());
        stringBuffer.append(str);
        stringBuffer.append(" Private Key [");
        stringBuffer.append(generateKeyFingerprint(modPow, dHParameters));
        stringBuffer.append("]");
        stringBuffer.append(lineSeparator);
        stringBuffer.append("              Y: ");
        stringBuffer.append(modPow.toString(16));
        stringBuffer.append(lineSeparator);
        return stringBuffer.toString();
    }

    public static String publicKeyToString(String str, BigInteger bigInteger, DHParameters dHParameters) {
        StringBuffer stringBuffer = new StringBuffer();
        String lineSeparator = Strings.lineSeparator();
        stringBuffer.append(str);
        stringBuffer.append(" Public Key [");
        stringBuffer.append(generateKeyFingerprint(bigInteger, dHParameters));
        stringBuffer.append("]");
        stringBuffer.append(lineSeparator);
        stringBuffer.append("             Y: ");
        stringBuffer.append(bigInteger.toString(16));
        stringBuffer.append(lineSeparator);
        return stringBuffer.toString();
    }
}
