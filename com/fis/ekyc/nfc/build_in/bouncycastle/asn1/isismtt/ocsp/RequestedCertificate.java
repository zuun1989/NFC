package com.fis.ekyc.nfc.build_in.bouncycastle.asn1.isismtt.ocsp;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Choice;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Object;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1OctetString;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Sequence;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1TaggedObject;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DEROctetString;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERTaggedObject;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.Certificate;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.Arrays;
import java.io.IOException;

public class RequestedCertificate extends ASN1Object implements ASN1Choice {
    public static final int attributeCertificate = 1;
    public static final int certificate = -1;
    public static final int publicKeyCertificate = 0;
    private byte[] attributeCert;
    private Certificate cert;
    private byte[] publicKeyCert;

    private RequestedCertificate(ASN1TaggedObject aSN1TaggedObject) {
        if (aSN1TaggedObject.getTagNo() == 0) {
            this.publicKeyCert = ASN1OctetString.getInstance(aSN1TaggedObject, true).getOctets();
        } else if (aSN1TaggedObject.getTagNo() == 1) {
            this.attributeCert = ASN1OctetString.getInstance(aSN1TaggedObject, true).getOctets();
        } else {
            throw new IllegalArgumentException("unknown tag number: " + aSN1TaggedObject.getTagNo());
        }
    }

    public static RequestedCertificate getInstance(Object obj) {
        if (obj == null || (obj instanceof RequestedCertificate)) {
            return (RequestedCertificate) obj;
        }
        if (obj instanceof ASN1Sequence) {
            return new RequestedCertificate(Certificate.getInstance(obj));
        }
        if (obj instanceof ASN1TaggedObject) {
            return new RequestedCertificate((ASN1TaggedObject) obj);
        }
        throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
    }

    public byte[] getCertificateBytes() {
        Certificate certificate2 = this.cert;
        if (certificate2 != null) {
            try {
                return certificate2.getEncoded();
            } catch (IOException e) {
                throw new IllegalStateException("can't decode certificate: " + e);
            }
        } else {
            byte[] bArr = this.publicKeyCert;
            if (bArr != null) {
                return Arrays.clone(bArr);
            }
            return Arrays.clone(this.attributeCert);
        }
    }

    public int getType() {
        if (this.cert != null) {
            return -1;
        }
        if (this.publicKeyCert != null) {
            return 0;
        }
        return 1;
    }

    public ASN1Primitive toASN1Primitive() {
        byte[] bArr = this.publicKeyCert;
        if (bArr != null) {
            return new DERTaggedObject(0, new DEROctetString(bArr));
        }
        byte[] bArr2 = this.attributeCert;
        if (bArr2 != null) {
            return new DERTaggedObject(1, new DEROctetString(bArr2));
        }
        return this.cert.toASN1Primitive();
    }

    public RequestedCertificate(Certificate certificate2) {
        this.cert = certificate2;
    }

    public RequestedCertificate(int i, byte[] bArr) {
        this((ASN1TaggedObject) new DERTaggedObject(i, new DEROctetString(bArr)));
    }

    public static RequestedCertificate getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        if (z) {
            return getInstance(aSN1TaggedObject.getObject());
        }
        throw new IllegalArgumentException("choice item must be explicitly tagged");
    }
}
