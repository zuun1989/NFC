package com.fis.ekyc.nfc.build_in.bouncycastle.asn1;

import com.fis.ekyc.nfc.build_in.bouncycastle.util.Arrays;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.Strings;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.encoders.Hex;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public abstract class ASN1OctetString extends ASN1Primitive implements ASN1OctetStringParser {
    byte[] string;

    public ASN1OctetString(byte[] bArr) {
        if (bArr != null) {
            this.string = bArr;
            return;
        }
        throw new NullPointerException("'string' cannot be null");
    }

    public static ASN1OctetString getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        if (!z) {
            ASN1Primitive object = aSN1TaggedObject.getObject();
            if (aSN1TaggedObject.isExplicit()) {
                ASN1OctetString instance = getInstance(object);
                if (aSN1TaggedObject instanceof BERTaggedObject) {
                    return new BEROctetString(new ASN1OctetString[]{instance});
                }
                return (ASN1OctetString) new BEROctetString(new ASN1OctetString[]{instance}).toDLObject();
            } else if (object instanceof ASN1OctetString) {
                ASN1OctetString aSN1OctetString = (ASN1OctetString) object;
                if (aSN1TaggedObject instanceof BERTaggedObject) {
                    return aSN1OctetString;
                }
                return (ASN1OctetString) aSN1OctetString.toDLObject();
            } else if (object instanceof ASN1Sequence) {
                ASN1Sequence aSN1Sequence = (ASN1Sequence) object;
                if (aSN1TaggedObject instanceof BERTaggedObject) {
                    return BEROctetString.fromSequence(aSN1Sequence);
                }
                return (ASN1OctetString) BEROctetString.fromSequence(aSN1Sequence).toDLObject();
            } else {
                throw new IllegalArgumentException("unknown object in getInstance: " + aSN1TaggedObject.getClass().getName());
            }
        } else if (aSN1TaggedObject.isExplicit()) {
            return getInstance(aSN1TaggedObject.getObject());
        } else {
            throw new IllegalArgumentException("object implicit - explicit expected.");
        }
    }

    public boolean asn1Equals(ASN1Primitive aSN1Primitive) {
        if (!(aSN1Primitive instanceof ASN1OctetString)) {
            return false;
        }
        return Arrays.areEqual(this.string, ((ASN1OctetString) aSN1Primitive).string);
    }

    public abstract void encode(ASN1OutputStream aSN1OutputStream, boolean z) throws IOException;

    public ASN1Primitive getLoadedObject() {
        return toASN1Primitive();
    }

    public InputStream getOctetStream() {
        return new ByteArrayInputStream(this.string);
    }

    public byte[] getOctets() {
        return this.string;
    }

    public int hashCode() {
        return Arrays.hashCode(getOctets());
    }

    public ASN1OctetStringParser parser() {
        return this;
    }

    public ASN1Primitive toDERObject() {
        return new DEROctetString(this.string);
    }

    public ASN1Primitive toDLObject() {
        return new DEROctetString(this.string);
    }

    public String toString() {
        return "#" + Strings.fromByteArray(Hex.encode(this.string));
    }

    public static ASN1OctetString getInstance(Object obj) {
        if (obj == null || (obj instanceof ASN1OctetString)) {
            return (ASN1OctetString) obj;
        }
        if (obj instanceof byte[]) {
            try {
                return getInstance(ASN1Primitive.fromByteArray((byte[]) obj));
            } catch (IOException e) {
                throw new IllegalArgumentException("failed to construct OCTET STRING from byte[]: " + e.getMessage());
            }
        } else {
            if (obj instanceof ASN1Encodable) {
                ASN1Primitive aSN1Primitive = ((ASN1Encodable) obj).toASN1Primitive();
                if (aSN1Primitive instanceof ASN1OctetString) {
                    return (ASN1OctetString) aSN1Primitive;
                }
            }
            throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
        }
    }
}
