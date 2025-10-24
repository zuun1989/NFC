package com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x9;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Object;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1OctetString;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DEROctetString;
import com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECCurve;
import com.fis.ekyc.nfc.build_in.bouncycastle.math.ec.ECPoint;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.Arrays;

public class X9ECPoint extends ASN1Object {
    private ECCurve c;
    private final ASN1OctetString encoding;
    private ECPoint p;

    public X9ECPoint(ECPoint eCPoint, boolean z) {
        this.p = eCPoint.normalize();
        this.encoding = new DEROctetString(eCPoint.getEncoded(z));
    }

    public synchronized ECPoint getPoint() {
        try {
            if (this.p == null) {
                this.p = this.c.decodePoint(this.encoding.getOctets()).normalize();
            }
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
        return this.p;
    }

    public byte[] getPointEncoding() {
        return Arrays.clone(this.encoding.getOctets());
    }

    public boolean isPointCompressed() {
        byte[] octets = this.encoding.getOctets();
        if (octets == null || octets.length <= 0) {
            return false;
        }
        byte b = octets[0];
        if (b == 2 || b == 3) {
            return true;
        }
        return false;
    }

    public ASN1Primitive toASN1Primitive() {
        return this.encoding;
    }

    public X9ECPoint(ECCurve eCCurve, byte[] bArr) {
        this.c = eCCurve;
        this.encoding = new DEROctetString(Arrays.clone(bArr));
    }

    public X9ECPoint(ECCurve eCCurve, ASN1OctetString aSN1OctetString) {
        this(eCCurve, aSN1OctetString.getOctets());
    }
}
