package com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Encodable;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1EncodableVector;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Object;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Sequence;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERSequence;
import java.util.Enumeration;

public class PBES2Parameters extends ASN1Object implements PKCSObjectIdentifiers {
    private KeyDerivationFunc func;
    private EncryptionScheme scheme;

    public PBES2Parameters(KeyDerivationFunc keyDerivationFunc, EncryptionScheme encryptionScheme) {
        this.func = keyDerivationFunc;
        this.scheme = encryptionScheme;
    }

    public static PBES2Parameters getInstance(Object obj) {
        if (obj instanceof PBES2Parameters) {
            return (PBES2Parameters) obj;
        }
        if (obj != null) {
            return new PBES2Parameters(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public EncryptionScheme getEncryptionScheme() {
        return this.scheme;
    }

    public KeyDerivationFunc getKeyDerivationFunc() {
        return this.func;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(2);
        aSN1EncodableVector.add(this.func);
        aSN1EncodableVector.add(this.scheme);
        return new DERSequence(aSN1EncodableVector);
    }

    private PBES2Parameters(ASN1Sequence aSN1Sequence) {
        Enumeration objects = aSN1Sequence.getObjects();
        ASN1Sequence instance = ASN1Sequence.getInstance(((ASN1Encodable) objects.nextElement()).toASN1Primitive());
        ASN1Encodable objectAt = instance.getObjectAt(0);
        ASN1ObjectIdentifier aSN1ObjectIdentifier = PKCSObjectIdentifiers.id_PBKDF2;
        if (objectAt.equals(aSN1ObjectIdentifier)) {
            this.func = new KeyDerivationFunc(aSN1ObjectIdentifier, PBKDF2Params.getInstance(instance.getObjectAt(1)));
        } else {
            this.func = KeyDerivationFunc.getInstance(instance);
        }
        this.scheme = EncryptionScheme.getInstance(objects.nextElement());
    }
}
