package com.fis.ekyc.nfc.build_in.bouncycastle.pqc.crypto.lms;

import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.AsymmetricKeyParameter;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.Encodable;
import java.io.IOException;

public abstract class LMSKeyParameters extends AsymmetricKeyParameter implements Encodable {
    public LMSKeyParameters(boolean z) {
        super(z);
    }

    public abstract byte[] getEncoded() throws IOException;
}
