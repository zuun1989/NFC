package com.fis.ekyc.nfc.build_in.bouncycastle.asn1.util;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ApplicationSpecific;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Boolean;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Encodable;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Encoding;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Enumerated;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1External;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1GeneralizedTime;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Integer;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1OctetString;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Sequence;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Set;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1TaggedObject;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1UTCTime;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.BERApplicationSpecific;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.BEROctetString;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.BERSequence;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.BERSet;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.BERTaggedObject;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERApplicationSpecific;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERBMPString;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERBitString;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERGraphicString;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERIA5String;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERNull;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERPrintableString;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERSequence;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERSet;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERT61String;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERUTF8String;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERVideotexString;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERVisibleString;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DLApplicationSpecific;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.Strings;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.encoders.Hex;
import java.io.IOException;
import java.util.Enumeration;

public class ASN1Dump {
    private static final int SAMPLE_SIZE = 32;
    private static final String TAB = "    ";

    public static void _dumpAsString(String str, boolean z, ASN1Primitive aSN1Primitive, StringBuffer stringBuffer) {
        String lineSeparator = Strings.lineSeparator();
        if (aSN1Primitive instanceof ASN1Sequence) {
            Enumeration objects = ((ASN1Sequence) aSN1Primitive).getObjects();
            String str2 = str + TAB;
            stringBuffer.append(str);
            if (aSN1Primitive instanceof BERSequence) {
                stringBuffer.append("BER Sequence");
            } else if (aSN1Primitive instanceof DERSequence) {
                stringBuffer.append("DER Sequence");
            } else {
                stringBuffer.append("Sequence");
            }
            stringBuffer.append(lineSeparator);
            while (objects.hasMoreElements()) {
                Object nextElement = objects.nextElement();
                if (nextElement == null || nextElement.equals(DERNull.INSTANCE)) {
                    stringBuffer.append(str2);
                    stringBuffer.append("NULL");
                    stringBuffer.append(lineSeparator);
                } else if (nextElement instanceof ASN1Primitive) {
                    _dumpAsString(str2, z, (ASN1Primitive) nextElement, stringBuffer);
                } else {
                    _dumpAsString(str2, z, ((ASN1Encodable) nextElement).toASN1Primitive(), stringBuffer);
                }
            }
        } else if (aSN1Primitive instanceof ASN1TaggedObject) {
            String str3 = str + TAB;
            stringBuffer.append(str);
            if (aSN1Primitive instanceof BERTaggedObject) {
                stringBuffer.append("BER Tagged [");
            } else {
                stringBuffer.append("Tagged [");
            }
            ASN1TaggedObject aSN1TaggedObject = (ASN1TaggedObject) aSN1Primitive;
            stringBuffer.append(Integer.toString(aSN1TaggedObject.getTagNo()));
            stringBuffer.append(']');
            if (!aSN1TaggedObject.isExplicit()) {
                stringBuffer.append(" IMPLICIT ");
            }
            stringBuffer.append(lineSeparator);
            _dumpAsString(str3, z, aSN1TaggedObject.getObject(), stringBuffer);
        } else if (aSN1Primitive instanceof ASN1Set) {
            Enumeration objects2 = ((ASN1Set) aSN1Primitive).getObjects();
            String str4 = str + TAB;
            stringBuffer.append(str);
            if (aSN1Primitive instanceof BERSet) {
                stringBuffer.append("BER Set");
            } else if (aSN1Primitive instanceof DERSet) {
                stringBuffer.append("DER Set");
            } else {
                stringBuffer.append("Set");
            }
            stringBuffer.append(lineSeparator);
            while (objects2.hasMoreElements()) {
                Object nextElement2 = objects2.nextElement();
                if (nextElement2 == null) {
                    stringBuffer.append(str4);
                    stringBuffer.append("NULL");
                    stringBuffer.append(lineSeparator);
                } else if (nextElement2 instanceof ASN1Primitive) {
                    _dumpAsString(str4, z, (ASN1Primitive) nextElement2, stringBuffer);
                } else {
                    _dumpAsString(str4, z, ((ASN1Encodable) nextElement2).toASN1Primitive(), stringBuffer);
                }
            }
        } else if (aSN1Primitive instanceof ASN1OctetString) {
            ASN1OctetString aSN1OctetString = (ASN1OctetString) aSN1Primitive;
            if (aSN1Primitive instanceof BEROctetString) {
                stringBuffer.append(str + "BER Constructed Octet String[" + aSN1OctetString.getOctets().length + "] ");
            } else {
                stringBuffer.append(str + "DER Octet String[" + aSN1OctetString.getOctets().length + "] ");
            }
            if (z) {
                stringBuffer.append(dumpBinaryDataAsString(str, aSN1OctetString.getOctets()));
            } else {
                stringBuffer.append(lineSeparator);
            }
        } else if (aSN1Primitive instanceof ASN1ObjectIdentifier) {
            stringBuffer.append(str + "ObjectIdentifier(" + ((ASN1ObjectIdentifier) aSN1Primitive).getId() + ")" + lineSeparator);
        } else if (aSN1Primitive instanceof ASN1Boolean) {
            stringBuffer.append(str + "Boolean(" + ((ASN1Boolean) aSN1Primitive).isTrue() + ")" + lineSeparator);
        } else if (aSN1Primitive instanceof ASN1Integer) {
            stringBuffer.append(str + "Integer(" + ((ASN1Integer) aSN1Primitive).getValue() + ")" + lineSeparator);
        } else if (aSN1Primitive instanceof DERBitString) {
            DERBitString dERBitString = (DERBitString) aSN1Primitive;
            stringBuffer.append(str + "DER Bit String[" + dERBitString.getBytes().length + ", " + dERBitString.getPadBits() + "] ");
            if (z) {
                stringBuffer.append(dumpBinaryDataAsString(str, dERBitString.getBytes()));
            } else {
                stringBuffer.append(lineSeparator);
            }
        } else if (aSN1Primitive instanceof DERIA5String) {
            stringBuffer.append(str + "IA5String(" + ((DERIA5String) aSN1Primitive).getString() + ") " + lineSeparator);
        } else if (aSN1Primitive instanceof DERUTF8String) {
            stringBuffer.append(str + "UTF8String(" + ((DERUTF8String) aSN1Primitive).getString() + ") " + lineSeparator);
        } else if (aSN1Primitive instanceof DERPrintableString) {
            stringBuffer.append(str + "PrintableString(" + ((DERPrintableString) aSN1Primitive).getString() + ") " + lineSeparator);
        } else if (aSN1Primitive instanceof DERVisibleString) {
            stringBuffer.append(str + "VisibleString(" + ((DERVisibleString) aSN1Primitive).getString() + ") " + lineSeparator);
        } else if (aSN1Primitive instanceof DERBMPString) {
            stringBuffer.append(str + "BMPString(" + ((DERBMPString) aSN1Primitive).getString() + ") " + lineSeparator);
        } else if (aSN1Primitive instanceof DERT61String) {
            stringBuffer.append(str + "T61String(" + ((DERT61String) aSN1Primitive).getString() + ") " + lineSeparator);
        } else if (aSN1Primitive instanceof DERGraphicString) {
            stringBuffer.append(str + "GraphicString(" + ((DERGraphicString) aSN1Primitive).getString() + ") " + lineSeparator);
        } else if (aSN1Primitive instanceof DERVideotexString) {
            stringBuffer.append(str + "VideotexString(" + ((DERVideotexString) aSN1Primitive).getString() + ") " + lineSeparator);
        } else if (aSN1Primitive instanceof ASN1UTCTime) {
            stringBuffer.append(str + "UTCTime(" + ((ASN1UTCTime) aSN1Primitive).getTime() + ") " + lineSeparator);
        } else if (aSN1Primitive instanceof ASN1GeneralizedTime) {
            stringBuffer.append(str + "GeneralizedTime(" + ((ASN1GeneralizedTime) aSN1Primitive).getTime() + ") " + lineSeparator);
        } else if (aSN1Primitive instanceof BERApplicationSpecific) {
            stringBuffer.append(outputApplicationSpecific(ASN1Encoding.BER, str, z, aSN1Primitive, lineSeparator));
        } else if (aSN1Primitive instanceof DERApplicationSpecific) {
            stringBuffer.append(outputApplicationSpecific(ASN1Encoding.DER, str, z, aSN1Primitive, lineSeparator));
        } else if (aSN1Primitive instanceof DLApplicationSpecific) {
            stringBuffer.append(outputApplicationSpecific("", str, z, aSN1Primitive, lineSeparator));
        } else if (aSN1Primitive instanceof ASN1Enumerated) {
            stringBuffer.append(str + "DER Enumerated(" + ((ASN1Enumerated) aSN1Primitive).getValue() + ")" + lineSeparator);
        } else if (aSN1Primitive instanceof ASN1External) {
            ASN1External aSN1External = (ASN1External) aSN1Primitive;
            stringBuffer.append(str + "External " + lineSeparator);
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append(TAB);
            String sb3 = sb2.toString();
            if (aSN1External.getDirectReference() != null) {
                stringBuffer.append(sb3 + "Direct Reference: " + aSN1External.getDirectReference().getId() + lineSeparator);
            }
            if (aSN1External.getIndirectReference() != null) {
                stringBuffer.append(sb3 + "Indirect Reference: " + aSN1External.getIndirectReference().toString() + lineSeparator);
            }
            if (aSN1External.getDataValueDescriptor() != null) {
                _dumpAsString(sb3, z, aSN1External.getDataValueDescriptor(), stringBuffer);
            }
            stringBuffer.append(sb3 + "Encoding: " + aSN1External.getEncoding() + lineSeparator);
            _dumpAsString(sb3, z, aSN1External.getExternalContent(), stringBuffer);
        } else {
            stringBuffer.append(str + aSN1Primitive.toString() + lineSeparator);
        }
    }

    private static String calculateAscString(byte[] bArr, int i, int i2) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i3 = i; i3 != i + i2; i3++) {
            byte b = bArr[i3];
            if (b >= 32 && b <= 126) {
                stringBuffer.append((char) b);
            }
        }
        return stringBuffer.toString();
    }

    public static String dumpAsString(Object obj) {
        return dumpAsString(obj, false);
    }

    private static String dumpBinaryDataAsString(String str, byte[] bArr) {
        String lineSeparator = Strings.lineSeparator();
        StringBuffer stringBuffer = new StringBuffer();
        String str2 = str + TAB;
        stringBuffer.append(lineSeparator);
        for (int i = 0; i < bArr.length; i += 32) {
            if (bArr.length - i > 32) {
                stringBuffer.append(str2);
                stringBuffer.append(Strings.fromByteArray(Hex.encode(bArr, i, 32)));
                stringBuffer.append(TAB);
                stringBuffer.append(calculateAscString(bArr, i, 32));
                stringBuffer.append(lineSeparator);
            } else {
                stringBuffer.append(str2);
                stringBuffer.append(Strings.fromByteArray(Hex.encode(bArr, i, bArr.length - i)));
                for (int length = bArr.length - i; length != 32; length++) {
                    stringBuffer.append("  ");
                }
                stringBuffer.append(TAB);
                stringBuffer.append(calculateAscString(bArr, i, bArr.length - i));
                stringBuffer.append(lineSeparator);
            }
        }
        return stringBuffer.toString();
    }

    private static String outputApplicationSpecific(String str, String str2, boolean z, ASN1Primitive aSN1Primitive, String str3) {
        ASN1ApplicationSpecific instance = ASN1ApplicationSpecific.getInstance(aSN1Primitive);
        StringBuffer stringBuffer = new StringBuffer();
        if (instance.isConstructed()) {
            try {
                ASN1Sequence instance2 = ASN1Sequence.getInstance(instance.getObject(16));
                stringBuffer.append(str2 + str + " ApplicationSpecific[" + instance.getApplicationTag() + "]" + str3);
                Enumeration objects = instance2.getObjects();
                while (objects.hasMoreElements()) {
                    _dumpAsString(str2 + TAB, z, (ASN1Primitive) objects.nextElement(), stringBuffer);
                }
            } catch (IOException e) {
                stringBuffer.append(e);
            }
            return stringBuffer.toString();
        }
        return str2 + str + " ApplicationSpecific[" + instance.getApplicationTag() + "] (" + Strings.fromByteArray(Hex.encode(instance.getContents())) + ")" + str3;
    }

    public static String dumpAsString(Object obj, boolean z) {
        StringBuffer stringBuffer = new StringBuffer();
        if (obj instanceof ASN1Primitive) {
            _dumpAsString("", z, (ASN1Primitive) obj, stringBuffer);
        } else if (obj instanceof ASN1Encodable) {
            _dumpAsString("", z, ((ASN1Encodable) obj).toASN1Primitive(), stringBuffer);
        } else {
            return "unknown object type " + obj.toString();
        }
        return stringBuffer.toString();
    }
}
