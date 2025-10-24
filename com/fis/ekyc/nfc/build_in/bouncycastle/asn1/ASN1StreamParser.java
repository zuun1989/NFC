package com.fis.ekyc.nfc.build_in.bouncycastle.asn1;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ASN1StreamParser {
    private final InputStream _in;
    private final int _limit;
    private final byte[][] tmpBuffers;

    public ASN1StreamParser(InputStream inputStream) {
        this(inputStream, StreamUtil.findLimit(inputStream));
    }

    private void set00Check(boolean z) {
        InputStream inputStream = this._in;
        if (inputStream instanceof IndefiniteLengthInputStream) {
            ((IndefiniteLengthInputStream) inputStream).setEofOn00(z);
        }
    }

    public ASN1Encodable readImplicit(boolean z, int i) throws IOException {
        InputStream inputStream = this._in;
        if (!(inputStream instanceof IndefiniteLengthInputStream)) {
            if (z) {
                if (i == 4) {
                    return new BEROctetStringParser(this);
                }
                if (i == 16) {
                    return new DLSequenceParser(this);
                }
                if (i == 17) {
                    return new DLSetParser(this);
                }
            } else if (i == 4) {
                return new DEROctetStringParser((DefiniteLengthInputStream) inputStream);
            } else {
                if (i == 16) {
                    throw new ASN1Exception("sets must use constructed encoding (see X.690 8.11.1/8.12.1)");
                } else if (i == 17) {
                    throw new ASN1Exception("sequences must use constructed encoding (see X.690 8.9.1/8.10.1)");
                }
            }
            throw new ASN1Exception("implicit tagging not implemented");
        } else if (z) {
            return readIndef(i);
        } else {
            throw new IOException("indefinite-length primitive encoding encountered");
        }
    }

    public ASN1Encodable readIndef(int i) throws IOException {
        if (i == 4) {
            return new BEROctetStringParser(this);
        }
        if (i == 8) {
            return new DERExternalParser(this);
        }
        if (i == 16) {
            return new BERSequenceParser(this);
        }
        if (i == 17) {
            return new BERSetParser(this);
        }
        throw new ASN1Exception("unknown BER object encountered: 0x" + Integer.toHexString(i));
    }

    public ASN1Encodable readObject() throws IOException {
        boolean z;
        int read = this._in.read();
        if (read == -1) {
            return null;
        }
        boolean z2 = false;
        set00Check(false);
        int readTagNumber = ASN1InputStream.readTagNumber(this._in, read);
        if ((read & 32) != 0) {
            z = true;
        } else {
            z = false;
        }
        InputStream inputStream = this._in;
        int i = this._limit;
        if (readTagNumber == 4 || readTagNumber == 16 || readTagNumber == 17 || readTagNumber == 8) {
            z2 = true;
        }
        int readLength = ASN1InputStream.readLength(inputStream, i, z2);
        if (readLength >= 0) {
            DefiniteLengthInputStream definiteLengthInputStream = new DefiniteLengthInputStream(this._in, readLength, this._limit);
            if ((read & 64) != 0) {
                return new DLApplicationSpecific(z, readTagNumber, definiteLengthInputStream.toByteArray());
            }
            if ((read & 128) != 0) {
                return new BERTaggedObjectParser(z, readTagNumber, new ASN1StreamParser((InputStream) definiteLengthInputStream));
            }
            if (z) {
                if (readTagNumber == 4) {
                    return new BEROctetStringParser(new ASN1StreamParser((InputStream) definiteLengthInputStream));
                }
                if (readTagNumber == 8) {
                    return new DERExternalParser(new ASN1StreamParser((InputStream) definiteLengthInputStream));
                }
                if (readTagNumber == 16) {
                    return new DLSequenceParser(new ASN1StreamParser((InputStream) definiteLengthInputStream));
                }
                if (readTagNumber == 17) {
                    return new DLSetParser(new ASN1StreamParser((InputStream) definiteLengthInputStream));
                }
                throw new IOException("unknown tag " + readTagNumber + " encountered");
            } else if (readTagNumber == 4) {
                return new DEROctetStringParser(definiteLengthInputStream);
            } else {
                try {
                    return ASN1InputStream.createPrimitiveDERObject(readTagNumber, definiteLengthInputStream, this.tmpBuffers);
                } catch (IllegalArgumentException e) {
                    throw new ASN1Exception("corrupted stream detected", e);
                }
            }
        } else if (z) {
            ASN1StreamParser aSN1StreamParser = new ASN1StreamParser(new IndefiniteLengthInputStream(this._in, this._limit), this._limit);
            if ((read & 64) != 0) {
                return new BERApplicationSpecificParser(readTagNumber, aSN1StreamParser);
            }
            if ((read & 128) != 0) {
                return new BERTaggedObjectParser(true, readTagNumber, aSN1StreamParser);
            }
            return aSN1StreamParser.readIndef(readTagNumber);
        } else {
            throw new IOException("indefinite-length primitive encoding encountered");
        }
    }

    public ASN1Primitive readTaggedObject(boolean z, int i) throws IOException {
        if (!z) {
            return new DLTaggedObject(false, i, new DEROctetString(((DefiniteLengthInputStream) this._in).toByteArray()));
        }
        ASN1EncodableVector readVector = readVector();
        if (this._in instanceof IndefiniteLengthInputStream) {
            if (readVector.size() == 1) {
                return new BERTaggedObject(true, i, readVector.get(0));
            }
            return new BERTaggedObject(false, i, BERFactory.createSequence(readVector));
        } else if (readVector.size() == 1) {
            return new DLTaggedObject(true, i, readVector.get(0));
        } else {
            return new DLTaggedObject(false, i, DLFactory.createSequence(readVector));
        }
    }

    public ASN1EncodableVector readVector() throws IOException {
        ASN1Encodable readObject = readObject();
        if (readObject == null) {
            return new ASN1EncodableVector(0);
        }
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        do {
            if (readObject instanceof InMemoryRepresentable) {
                aSN1EncodableVector.add(((InMemoryRepresentable) readObject).getLoadedObject());
            } else {
                aSN1EncodableVector.add(readObject.toASN1Primitive());
            }
            readObject = readObject();
        } while (readObject != null);
        return aSN1EncodableVector;
    }

    public ASN1StreamParser(InputStream inputStream, int i) {
        this._in = inputStream;
        this._limit = i;
        this.tmpBuffers = new byte[11][];
    }

    public ASN1StreamParser(byte[] bArr) {
        this(new ByteArrayInputStream(bArr), bArr.length);
    }
}
