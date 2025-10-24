package com.fis.ekyc.nfc.build_in.bouncycastle.asn1.tsp;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1EncodableVector;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Object;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1OctetString;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Sequence;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DEROctetString;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERSequence;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.AlgorithmIdentifier;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.Arrays;

public class MessageImprint extends ASN1Object {
    AlgorithmIdentifier hashAlgorithm;
    byte[] hashedMessage;

    private MessageImprint(ASN1Sequence aSN1Sequence) {
        this.hashAlgorithm = AlgorithmIdentifier.getInstance(aSN1Sequence.getObjectAt(0));
        this.hashedMessage = ASN1OctetString.getInstance(aSN1Sequence.getObjectAt(1)).getOctets();
    }

    public static MessageImprint getInstance(Object obj) {
        if (obj instanceof MessageImprint) {
            return (MessageImprint) obj;
        }
        if (obj != null) {
            return new MessageImprint(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public AlgorithmIdentifier getHashAlgorithm() {
        return this.hashAlgorithm;
    }

    public byte[] getHashedMessage() {
        return Arrays.clone(this.hashedMessage);
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(2);
        aSN1EncodableVector.add(this.hashAlgorithm);
        aSN1EncodableVector.add(new DEROctetString(this.hashedMessage));
        return new DERSequence(aSN1EncodableVector);
    }

    public MessageImprint(AlgorithmIdentifier algorithmIdentifier, byte[] bArr) {
        this.hashAlgorithm = algorithmIdentifier;
        this.hashedMessage = Arrays.clone(bArr);
    }
}
