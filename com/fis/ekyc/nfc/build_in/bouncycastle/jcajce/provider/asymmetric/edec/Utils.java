package com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.edec;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.AsymmetricKeyParameter;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.Ed25519PublicKeyParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.Ed448PublicKeyParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.X25519PublicKeyParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.X448PublicKeyParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.Fingerprint;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.Strings;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.encoders.Hex;

class Utils {
    private static String generateKeyFingerprint(byte[] bArr) {
        return new Fingerprint(bArr).toString();
    }

    public static boolean isValidPrefix(byte[] bArr, byte[] bArr2) {
        if (bArr2.length < bArr.length) {
            return !isValidPrefix(bArr, bArr);
        }
        byte b = 0;
        for (int i = 0; i != bArr.length; i++) {
            b |= bArr[i] ^ bArr2[i];
        }
        if (b == 0) {
            return true;
        }
        return false;
    }

    public static String keyToString(String str, String str2, AsymmetricKeyParameter asymmetricKeyParameter) {
        byte[] bArr;
        StringBuffer stringBuffer = new StringBuffer();
        String lineSeparator = Strings.lineSeparator();
        if (asymmetricKeyParameter instanceof X448PublicKeyParameters) {
            bArr = ((X448PublicKeyParameters) asymmetricKeyParameter).getEncoded();
        } else if (asymmetricKeyParameter instanceof Ed448PublicKeyParameters) {
            bArr = ((Ed448PublicKeyParameters) asymmetricKeyParameter).getEncoded();
        } else if (asymmetricKeyParameter instanceof X25519PublicKeyParameters) {
            bArr = ((X25519PublicKeyParameters) asymmetricKeyParameter).getEncoded();
        } else {
            bArr = ((Ed25519PublicKeyParameters) asymmetricKeyParameter).getEncoded();
        }
        stringBuffer.append(str2);
        stringBuffer.append(" ");
        stringBuffer.append(str);
        stringBuffer.append(" [");
        stringBuffer.append(generateKeyFingerprint(bArr));
        stringBuffer.append("]");
        stringBuffer.append(lineSeparator);
        stringBuffer.append("    public data: ");
        stringBuffer.append(Hex.toHexString(bArr));
        stringBuffer.append(lineSeparator);
        return stringBuffer.toString();
    }
}
