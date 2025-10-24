package com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1EncodableVector;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Integer;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Object;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1OctetString;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Sequence;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1TaggedObject;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DEROctetString;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERSequence;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERTaggedObject;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.digests.SHA1Digest;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.encoders.Hex;
import java.math.BigInteger;
import java.util.Enumeration;

public class AuthorityKeyIdentifier extends ASN1Object {
    GeneralNames certissuer;
    ASN1Integer certserno;
    ASN1OctetString keyidentifier;

    public AuthorityKeyIdentifier(ASN1Sequence aSN1Sequence) {
        this.keyidentifier = null;
        this.certissuer = null;
        this.certserno = null;
        Enumeration objects = aSN1Sequence.getObjects();
        while (objects.hasMoreElements()) {
            ASN1TaggedObject instance = ASN1TaggedObject.getInstance(objects.nextElement());
            int tagNo = instance.getTagNo();
            if (tagNo == 0) {
                this.keyidentifier = ASN1OctetString.getInstance(instance, false);
            } else if (tagNo == 1) {
                this.certissuer = GeneralNames.getInstance(instance, false);
            } else if (tagNo == 2) {
                this.certserno = ASN1Integer.getInstance(instance, false);
            } else {
                throw new IllegalArgumentException("illegal tag");
            }
        }
    }

    public static AuthorityKeyIdentifier fromExtensions(Extensions extensions) {
        return getInstance(Extensions.getExtensionParsedValue(extensions, Extension.authorityKeyIdentifier));
    }

    public static AuthorityKeyIdentifier getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }

    public GeneralNames getAuthorityCertIssuer() {
        return this.certissuer;
    }

    public BigInteger getAuthorityCertSerialNumber() {
        ASN1Integer aSN1Integer = this.certserno;
        if (aSN1Integer != null) {
            return aSN1Integer.getValue();
        }
        return null;
    }

    public byte[] getKeyIdentifier() {
        ASN1OctetString aSN1OctetString = this.keyidentifier;
        if (aSN1OctetString != null) {
            return aSN1OctetString.getOctets();
        }
        return null;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(3);
        ASN1OctetString aSN1OctetString = this.keyidentifier;
        if (aSN1OctetString != null) {
            aSN1EncodableVector.add(new DERTaggedObject(false, 0, aSN1OctetString));
        }
        GeneralNames generalNames = this.certissuer;
        if (generalNames != null) {
            aSN1EncodableVector.add(new DERTaggedObject(false, 1, generalNames));
        }
        ASN1Integer aSN1Integer = this.certserno;
        if (aSN1Integer != null) {
            aSN1EncodableVector.add(new DERTaggedObject(false, 2, aSN1Integer));
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public String toString() {
        String str;
        ASN1OctetString aSN1OctetString = this.keyidentifier;
        if (aSN1OctetString != null) {
            str = Hex.toHexString(aSN1OctetString.getOctets());
        } else {
            str = "null";
        }
        return "AuthorityKeyIdentifier: KeyID(" + str + ")";
    }

    public static AuthorityKeyIdentifier getInstance(Object obj) {
        if (obj instanceof AuthorityKeyIdentifier) {
            return (AuthorityKeyIdentifier) obj;
        }
        if (obj != null) {
            return new AuthorityKeyIdentifier(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public AuthorityKeyIdentifier(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        this(subjectPublicKeyInfo, (GeneralNames) null, (BigInteger) null);
    }

    public AuthorityKeyIdentifier(SubjectPublicKeyInfo subjectPublicKeyInfo, GeneralNames generalNames, BigInteger bigInteger) {
        ASN1Integer aSN1Integer = null;
        this.keyidentifier = null;
        this.certissuer = null;
        this.certserno = null;
        SHA1Digest sHA1Digest = new SHA1Digest();
        byte[] bArr = new byte[sHA1Digest.getDigestSize()];
        byte[] bytes = subjectPublicKeyInfo.getPublicKeyData().getBytes();
        sHA1Digest.update(bytes, 0, bytes.length);
        sHA1Digest.doFinal(bArr, 0);
        this.keyidentifier = new DEROctetString(bArr);
        this.certissuer = generalNames;
        this.certserno = bigInteger != null ? new ASN1Integer(bigInteger) : aSN1Integer;
    }

    public AuthorityKeyIdentifier(GeneralNames generalNames, BigInteger bigInteger) {
        this((byte[]) null, generalNames, bigInteger);
    }

    public AuthorityKeyIdentifier(byte[] bArr) {
        this(bArr, (GeneralNames) null, (BigInteger) null);
    }

    public AuthorityKeyIdentifier(byte[] bArr, GeneralNames generalNames, BigInteger bigInteger) {
        ASN1Integer aSN1Integer = null;
        this.keyidentifier = null;
        this.certissuer = null;
        this.certserno = null;
        this.keyidentifier = bArr != null ? new DEROctetString(bArr) : null;
        this.certissuer = generalNames;
        this.certserno = bigInteger != null ? new ASN1Integer(bigInteger) : aSN1Integer;
    }
}
