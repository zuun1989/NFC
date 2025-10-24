package com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x9;

public abstract class X9ECParametersHolder {
    private X9ECParameters params;

    public abstract X9ECParameters createParameters();

    public synchronized X9ECParameters getParameters() {
        try {
            if (this.params == null) {
                this.params = createParameters();
            }
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
        return this.params;
    }
}
