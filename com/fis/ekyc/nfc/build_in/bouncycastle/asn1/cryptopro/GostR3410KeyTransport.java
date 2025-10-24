package com.fis.ekyc.nfc.build_in.bouncycastle.asn1.cryptopro;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1EncodableVector;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Object;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Sequence;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1TaggedObject;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERSequence;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERTaggedObject;

public class GostR3410KeyTransport extends ASN1Object {
    private final Gost2814789EncryptedKey sessionEncryptedKey;
    private final GostR3410TransportParameters transportParameters;

    private GostR3410KeyTransport(ASN1Sequence aSN1Sequence) {
        this.sessionEncryptedKey = Gost2814789EncryptedKey.getInstance(aSN1Sequence.getObjectAt(0));
        this.transportParameters = GostR3410TransportParameters.getInstance(ASN1TaggedObject.getInstance(aSN1Sequence.getObjectAt(1)), false);
    }

    public static GostR3410KeyTransport getInstance(Object obj) {
        if (obj instanceof GostR3410KeyTransport) {
            return (GostR3410KeyTransport) obj;
        }
        if (obj != null) {
            return new GostR3410KeyTransport(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public Gost2814789EncryptedKey getSessionEncryptedKey() {
        return this.sessionEncryptedKey;
    }

    public GostR3410TransportParameters getTransportParameters() {
        return this.transportParameters;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(2);
        aSN1EncodableVector.add(this.sessionEncryptedKey);
        GostR3410TransportParameters gostR3410TransportParameters = this.transportParameters;
        if (gostR3410TransportParameters != null) {
            aSN1EncodableVector.add(new DERTaggedObject(false, 0, gostR3410TransportParameters));
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public GostR3410KeyTransport(Gost2814789EncryptedKey gost2814789EncryptedKey, GostR3410TransportParameters gostR3410TransportParameters) {
        this.sessionEncryptedKey = gost2814789EncryptedKey;
        this.transportParameters = gostR3410TransportParameters;
    }
}
