package com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ua;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1EncodableVector;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Object;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1OctetString;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Sequence;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DEROctetString;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERSequence;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.Arrays;
import com.fis.ekyc.nfc.build_in.eidparser.IdCardService;
import com.fis.ekyc.nfc.build_in.scuba.smartcards.ISO7816;
import com.fis.ekyc.nfc.build_in.scuba.smartcards.ISOFileInfo;

public class DSTU4145Params extends ASN1Object {
    private static final byte[] DEFAULT_DKE = {-87, ISO7816.INS_UPDATE_BINARY, -21, 69, -15, 60, ISO7816.INS_MANAGE_CHANNEL, -126, ISOFileInfo.DATA_BYTES1, -60, -106, 123, 35, 31, 94, -83, -10, 88, -21, -92, ISO7816.INS_GET_RESPONSE, 55, 41, 29, 56, -39, 107, -16, 37, ISO7816.INS_GET_DATA, 78, 23, -8, -23, 114, IdCardService.SFI_DG13, -58, 21, ISO7816.INS_READ_BINARY_STAMPED, 58, 40, -105, 95, IdCardService.SFI_DG11, -63, -34, -93, ISOFileInfo.FMD_BYTE, 56, -75, ISOFileInfo.FMD_BYTE, -22, ISO7816.INS_UNBLOCK_CHV, 23, -97, ISO7816.INS_WRITE_BINARY, 18, 62, 109, -72, -6, -59, 121, 4};
    private byte[] dke = DEFAULT_DKE;
    private DSTU4145ECBinary ecbinary;
    private ASN1ObjectIdentifier namedCurve;

    public DSTU4145Params(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        this.namedCurve = aSN1ObjectIdentifier;
    }

    public static byte[] getDefaultDKE() {
        return Arrays.clone(DEFAULT_DKE);
    }

    public static DSTU4145Params getInstance(Object obj) {
        DSTU4145Params dSTU4145Params;
        if (obj instanceof DSTU4145Params) {
            return (DSTU4145Params) obj;
        }
        if (obj != null) {
            ASN1Sequence instance = ASN1Sequence.getInstance(obj);
            if (instance.getObjectAt(0) instanceof ASN1ObjectIdentifier) {
                dSTU4145Params = new DSTU4145Params(ASN1ObjectIdentifier.getInstance(instance.getObjectAt(0)));
            } else {
                dSTU4145Params = new DSTU4145Params(DSTU4145ECBinary.getInstance(instance.getObjectAt(0)));
            }
            if (instance.size() == 2) {
                byte[] octets = ASN1OctetString.getInstance(instance.getObjectAt(1)).getOctets();
                dSTU4145Params.dke = octets;
                if (octets.length != DEFAULT_DKE.length) {
                    throw new IllegalArgumentException("object parse error");
                }
            }
            return dSTU4145Params;
        }
        throw new IllegalArgumentException("object parse error");
    }

    public byte[] getDKE() {
        return Arrays.clone(this.dke);
    }

    public DSTU4145ECBinary getECBinary() {
        return this.ecbinary;
    }

    public ASN1ObjectIdentifier getNamedCurve() {
        return this.namedCurve;
    }

    public boolean isNamedCurve() {
        if (this.namedCurve != null) {
            return true;
        }
        return false;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(2);
        ASN1ObjectIdentifier aSN1ObjectIdentifier = this.namedCurve;
        if (aSN1ObjectIdentifier != null) {
            aSN1EncodableVector.add(aSN1ObjectIdentifier);
        } else {
            aSN1EncodableVector.add(this.ecbinary);
        }
        if (!Arrays.areEqual(this.dke, DEFAULT_DKE)) {
            aSN1EncodableVector.add(new DEROctetString(this.dke));
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public DSTU4145Params(ASN1ObjectIdentifier aSN1ObjectIdentifier, byte[] bArr) {
        this.namedCurve = aSN1ObjectIdentifier;
        this.dke = Arrays.clone(bArr);
    }

    public DSTU4145Params(DSTU4145ECBinary dSTU4145ECBinary) {
        this.ecbinary = dSTU4145ECBinary;
    }
}
