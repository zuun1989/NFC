package com.fis.ekyc.nfc.build_in.bouncycastle.asn1;

import com.fis.ekyc.nfc.build_in.bouncycastle.util.Arrays;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.Iterable;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.NoSuchElementException;

public abstract class ASN1Set extends ASN1Primitive implements Iterable<ASN1Encodable> {
    protected final ASN1Encodable[] elements;
    protected final boolean isSorted;

    public ASN1Set() {
        this.elements = ASN1EncodableVector.EMPTY_ELEMENTS;
        this.isSorted = true;
    }

    private static byte[] getDEREncoded(ASN1Encodable aSN1Encodable) {
        try {
            return aSN1Encodable.toASN1Primitive().getEncoded(ASN1Encoding.DER);
        } catch (IOException unused) {
            throw new IllegalArgumentException("cannot encode object added to SET");
        }
    }

    public static ASN1Set getInstance(Object obj) {
        if (obj == null || (obj instanceof ASN1Set)) {
            return (ASN1Set) obj;
        }
        if (obj instanceof ASN1SetParser) {
            return getInstance(((ASN1SetParser) obj).toASN1Primitive());
        }
        if (obj instanceof byte[]) {
            try {
                return getInstance(ASN1Primitive.fromByteArray((byte[]) obj));
            } catch (IOException e) {
                throw new IllegalArgumentException("failed to construct set from byte[]: " + e.getMessage());
            }
        } else {
            if (obj instanceof ASN1Encodable) {
                ASN1Primitive aSN1Primitive = ((ASN1Encodable) obj).toASN1Primitive();
                if (aSN1Primitive instanceof ASN1Set) {
                    return (ASN1Set) aSN1Primitive;
                }
            }
            throw new IllegalArgumentException("unknown object in getInstance: " + obj.getClass().getName());
        }
    }

    private static boolean lessThanOrEqual(byte[] bArr, byte[] bArr2) {
        byte b = bArr[0] & -33;
        byte b2 = bArr2[0] & -33;
        if (b == b2) {
            int min = Math.min(bArr.length, bArr2.length) - 1;
            int i = 1;
            while (i < min) {
                byte b3 = bArr[i];
                byte b4 = bArr2[i];
                if (b3 == b4) {
                    i++;
                } else if ((b3 & 255) < (b4 & 255)) {
                    return true;
                } else {
                    return false;
                }
            }
            if ((bArr[min] & 255) <= (bArr2[min] & 255)) {
                return true;
            }
            return false;
        } else if (b < b2) {
            return true;
        } else {
            return false;
        }
    }

    private static void sort(ASN1Encodable[] aSN1EncodableArr) {
        int i;
        int length = aSN1EncodableArr.length;
        if (length >= 2) {
            ASN1Encodable aSN1Encodable = aSN1EncodableArr[0];
            ASN1Encodable aSN1Encodable2 = aSN1EncodableArr[1];
            byte[] dEREncoded = getDEREncoded(aSN1Encodable);
            byte[] dEREncoded2 = getDEREncoded(aSN1Encodable2);
            if (lessThanOrEqual(dEREncoded2, dEREncoded)) {
                ASN1Encodable aSN1Encodable3 = aSN1Encodable2;
                aSN1Encodable2 = aSN1Encodable;
                aSN1Encodable = aSN1Encodable3;
                byte[] bArr = dEREncoded2;
                dEREncoded2 = dEREncoded;
                dEREncoded = bArr;
            }
            for (int i2 = 2; i2 < length; i2++) {
                ASN1Encodable aSN1Encodable4 = aSN1EncodableArr[i2];
                byte[] dEREncoded3 = getDEREncoded(aSN1Encodable4);
                if (lessThanOrEqual(dEREncoded2, dEREncoded3)) {
                    aSN1EncodableArr[i2 - 2] = aSN1Encodable;
                    aSN1Encodable = aSN1Encodable2;
                    dEREncoded = dEREncoded2;
                    aSN1Encodable2 = aSN1Encodable4;
                    dEREncoded2 = dEREncoded3;
                } else if (lessThanOrEqual(dEREncoded, dEREncoded3)) {
                    aSN1EncodableArr[i2 - 2] = aSN1Encodable;
                    aSN1Encodable = aSN1Encodable4;
                    dEREncoded = dEREncoded3;
                } else {
                    int i3 = i2 - 1;
                    while (true) {
                        i = i3 - 1;
                        if (i <= 0) {
                            break;
                        }
                        ASN1Encodable aSN1Encodable5 = aSN1EncodableArr[i3 - 2];
                        if (lessThanOrEqual(getDEREncoded(aSN1Encodable5), dEREncoded3)) {
                            break;
                        }
                        aSN1EncodableArr[i] = aSN1Encodable5;
                        i3 = i;
                    }
                    aSN1EncodableArr[i] = aSN1Encodable4;
                }
            }
            aSN1EncodableArr[length - 2] = aSN1Encodable;
            aSN1EncodableArr[length - 1] = aSN1Encodable2;
        }
    }

    public boolean asn1Equals(ASN1Primitive aSN1Primitive) {
        if (!(aSN1Primitive instanceof ASN1Set)) {
            return false;
        }
        ASN1Set aSN1Set = (ASN1Set) aSN1Primitive;
        int size = size();
        if (aSN1Set.size() != size) {
            return false;
        }
        DERSet dERSet = (DERSet) toDERObject();
        DERSet dERSet2 = (DERSet) aSN1Set.toDERObject();
        for (int i = 0; i < size; i++) {
            ASN1Primitive aSN1Primitive2 = dERSet.elements[i].toASN1Primitive();
            ASN1Primitive aSN1Primitive3 = dERSet2.elements[i].toASN1Primitive();
            if (aSN1Primitive2 != aSN1Primitive3 && !aSN1Primitive2.asn1Equals(aSN1Primitive3)) {
                return false;
            }
        }
        return true;
    }

    public abstract void encode(ASN1OutputStream aSN1OutputStream, boolean z) throws IOException;

    public ASN1Encodable getObjectAt(int i) {
        return this.elements[i];
    }

    public Enumeration getObjects() {
        return new Enumeration() {
            private int pos = 0;

            public boolean hasMoreElements() {
                if (this.pos < ASN1Set.this.elements.length) {
                    return true;
                }
                return false;
            }

            public Object nextElement() {
                int i = this.pos;
                ASN1Encodable[] aSN1EncodableArr = ASN1Set.this.elements;
                if (i < aSN1EncodableArr.length) {
                    this.pos = i + 1;
                    return aSN1EncodableArr[i];
                }
                throw new NoSuchElementException();
            }
        };
    }

    public int hashCode() {
        int length = this.elements.length;
        int i = length + 1;
        while (true) {
            length--;
            if (length < 0) {
                return i;
            }
            i += this.elements[length].toASN1Primitive().hashCode();
        }
    }

    public boolean isConstructed() {
        return true;
    }

    public Iterator<ASN1Encodable> iterator() {
        return new Arrays.Iterator(toArray());
    }

    public ASN1SetParser parser() {
        final int size = size();
        return new ASN1SetParser() {
            private int pos = 0;

            public ASN1Primitive getLoadedObject() {
                return ASN1Set.this;
            }

            public ASN1Encodable readObject() throws IOException {
                int i = size;
                int i2 = this.pos;
                if (i == i2) {
                    return null;
                }
                ASN1Encodable[] aSN1EncodableArr = ASN1Set.this.elements;
                this.pos = i2 + 1;
                ASN1Encodable aSN1Encodable = aSN1EncodableArr[i2];
                if (aSN1Encodable instanceof ASN1Sequence) {
                    return ((ASN1Sequence) aSN1Encodable).parser();
                }
                if (aSN1Encodable instanceof ASN1Set) {
                    return ((ASN1Set) aSN1Encodable).parser();
                }
                return aSN1Encodable;
            }

            public ASN1Primitive toASN1Primitive() {
                return ASN1Set.this;
            }
        };
    }

    public int size() {
        return this.elements.length;
    }

    public ASN1Encodable[] toArray() {
        return ASN1EncodableVector.cloneElements(this.elements);
    }

    public ASN1Primitive toDERObject() {
        ASN1Encodable[] aSN1EncodableArr;
        if (this.isSorted) {
            aSN1EncodableArr = this.elements;
        } else {
            aSN1EncodableArr = (ASN1Encodable[]) this.elements.clone();
            sort(aSN1EncodableArr);
        }
        return new DERSet(true, aSN1EncodableArr);
    }

    public ASN1Primitive toDLObject() {
        return new DLSet(this.isSorted, this.elements);
    }

    public String toString() {
        int size = size();
        if (size == 0) {
            return "[]";
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append('[');
        int i = 0;
        while (true) {
            stringBuffer.append(this.elements[i]);
            i++;
            if (i >= size) {
                stringBuffer.append(']');
                return stringBuffer.toString();
            }
            stringBuffer.append(", ");
        }
    }

    public ASN1Set(ASN1Encodable aSN1Encodable) {
        if (aSN1Encodable != null) {
            this.elements = new ASN1Encodable[]{aSN1Encodable};
            this.isSorted = true;
            return;
        }
        throw new NullPointerException("'element' cannot be null");
    }

    public ASN1Set(ASN1EncodableVector aSN1EncodableVector, boolean z) {
        ASN1Encodable[] aSN1EncodableArr;
        if (aSN1EncodableVector != null) {
            if (!z || aSN1EncodableVector.size() < 2) {
                aSN1EncodableArr = aSN1EncodableVector.takeElements();
            } else {
                aSN1EncodableArr = aSN1EncodableVector.copyElements();
                sort(aSN1EncodableArr);
            }
            this.elements = aSN1EncodableArr;
            this.isSorted = z || aSN1EncodableArr.length < 2;
            return;
        }
        throw new NullPointerException("'elementVector' cannot be null");
    }

    public static ASN1Set getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        if (!z) {
            ASN1Primitive object = aSN1TaggedObject.getObject();
            if (aSN1TaggedObject.isExplicit()) {
                if (aSN1TaggedObject instanceof BERTaggedObject) {
                    return new BERSet((ASN1Encodable) object);
                }
                return new DLSet((ASN1Encodable) object);
            } else if (object instanceof ASN1Set) {
                ASN1Set aSN1Set = (ASN1Set) object;
                if (aSN1TaggedObject instanceof BERTaggedObject) {
                    return aSN1Set;
                }
                return (ASN1Set) aSN1Set.toDLObject();
            } else if (object instanceof ASN1Sequence) {
                ASN1Encodable[] arrayInternal = ((ASN1Sequence) object).toArrayInternal();
                if (aSN1TaggedObject instanceof BERTaggedObject) {
                    return new BERSet(false, arrayInternal);
                }
                return new DLSet(false, arrayInternal);
            } else {
                throw new IllegalArgumentException("unknown object in getInstance: " + aSN1TaggedObject.getClass().getName());
            }
        } else if (aSN1TaggedObject.isExplicit()) {
            return getInstance(aSN1TaggedObject.getObject());
        } else {
            throw new IllegalArgumentException("object implicit - explicit expected.");
        }
    }

    public ASN1Set(ASN1Encodable[] aSN1EncodableArr, boolean z) {
        if (!Arrays.isNullOrContainsNull(aSN1EncodableArr)) {
            ASN1Encodable[] cloneElements = ASN1EncodableVector.cloneElements(aSN1EncodableArr);
            if (z && cloneElements.length >= 2) {
                sort(cloneElements);
            }
            this.elements = cloneElements;
            this.isSorted = z || cloneElements.length < 2;
            return;
        }
        throw new NullPointerException("'elements' cannot be null, or contain null");
    }

    public ASN1Set(boolean z, ASN1Encodable[] aSN1EncodableArr) {
        this.elements = aSN1EncodableArr;
        this.isSorted = z || aSN1EncodableArr.length < 2;
    }
}
