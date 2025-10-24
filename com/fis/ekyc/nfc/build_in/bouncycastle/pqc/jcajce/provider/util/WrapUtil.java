package com.fis.ekyc.nfc.build_in.bouncycastle.pqc.jcajce.provider.util;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.Wrapper;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines.AESEngine;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines.ARIAEngine;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines.CamelliaEngine;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines.RFC3394WrapEngine;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines.RFC5649WrapEngine;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.engines.SEEDEngine;

public class WrapUtil {
    public static Wrapper getWrapper(String str) {
        if (str.equalsIgnoreCase("AES")) {
            return new RFC3394WrapEngine(new AESEngine());
        }
        if (str.equalsIgnoreCase("ARIA")) {
            return new RFC3394WrapEngine(new ARIAEngine());
        }
        if (str.equalsIgnoreCase("Camellia")) {
            return new RFC3394WrapEngine(new CamelliaEngine());
        }
        if (str.equalsIgnoreCase("SEED")) {
            return new RFC3394WrapEngine(new SEEDEngine());
        }
        if (str.equalsIgnoreCase("AES-KWP")) {
            return new RFC5649WrapEngine(new AESEngine());
        }
        if (str.equalsIgnoreCase("Camellia-KWP")) {
            return new RFC5649WrapEngine(new CamelliaEngine());
        }
        if (str.equalsIgnoreCase("ARIA-KWP")) {
            return new RFC5649WrapEngine(new ARIAEngine());
        }
        throw new UnsupportedOperationException("unknown key algorithm: " + str);
    }
}
