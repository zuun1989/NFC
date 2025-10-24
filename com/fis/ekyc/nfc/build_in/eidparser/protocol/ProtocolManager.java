package com.fis.ekyc.nfc.build_in.eidparser.protocol;

import com.fis.ekyc.nfc.build_in.bouncycastle.util.encoders.Base64;
import kotlin.jvm.internal.n;
import u4.C0053d;

public final class ProtocolManager {
    private final String al = "here";
    private final String eal = "Stub!";
    private final String key1 = "something";
    private final String key2 = "stuck";

    public final String getAl() {
        return C0053d.a.d(this.al);
    }

    public final String getEAL() {
        return C0053d.a.d(this.eal);
    }

    public final byte[] getK1() {
        return Base64.decode(C0053d.a.d(this.key1));
    }

    public final byte[] getK2() {
        return Base64.decode(C0053d.a.d(this.key2));
    }

    public final void saveAl(String str) {
        n.f(str, "data");
        C0053d.a.l(this.key1, str);
    }

    public final void saveK1(byte[] bArr) {
        n.f(bArr, "data");
        C0053d.a aVar = C0053d.a;
        String str = this.key1;
        String base64String = Base64.toBase64String(bArr);
        n.e(base64String, "toBase64String(data)");
        aVar.l(str, base64String);
    }

    public final void saveK2(byte[] bArr) {
        n.f(bArr, "data");
        C0053d.a aVar = C0053d.a;
        String str = this.key2;
        String base64String = Base64.toBase64String(bArr);
        n.e(base64String, "toBase64String(data)");
        aVar.l(str, base64String);
    }
}
