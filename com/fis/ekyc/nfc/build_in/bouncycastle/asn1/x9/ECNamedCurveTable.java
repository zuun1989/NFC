package com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x9;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.anssi.ANSSINamedCurves;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.cryptlib.CryptlibObjectIdentifiers;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.cryptopro.ECGOST3410NamedCurves;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.gm.GMNamedCurves;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.nist.NISTNamedCurves;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.sec.SECNamedCurves;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.teletrust.TeleTrusTNamedCurves;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.ec.CustomNamedCurves;
import java.util.Enumeration;
import java.util.Vector;

public class ECNamedCurveTable {
    private static void addEnumeration(Vector vector, Enumeration enumeration) {
        while (enumeration.hasMoreElements()) {
            vector.addElement(enumeration.nextElement());
        }
    }

    public static X9ECParameters getByName(String str) {
        X9ECParameters byName = X962NamedCurves.getByName(str);
        if (byName == null) {
            byName = SECNamedCurves.getByName(str);
        }
        if (byName == null) {
            byName = NISTNamedCurves.getByName(str);
        }
        if (byName == null) {
            byName = TeleTrusTNamedCurves.getByName(str);
        }
        if (byName == null) {
            byName = ANSSINamedCurves.getByName(str);
        }
        if (byName == null) {
            byName = ECGOST3410NamedCurves.getByNameX9(str);
        }
        if (byName == null) {
            return GMNamedCurves.getByName(str);
        }
        return byName;
    }

    public static X9ECParameters getByOID(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        X9ECParameters byOID = X962NamedCurves.getByOID(aSN1ObjectIdentifier);
        if (byOID == null) {
            byOID = SECNamedCurves.getByOID(aSN1ObjectIdentifier);
        }
        if (byOID == null) {
            byOID = TeleTrusTNamedCurves.getByOID(aSN1ObjectIdentifier);
        }
        if (byOID == null) {
            byOID = ANSSINamedCurves.getByOID(aSN1ObjectIdentifier);
        }
        if (byOID == null) {
            byOID = ECGOST3410NamedCurves.getByOIDX9(aSN1ObjectIdentifier);
        }
        if (byOID == null) {
            return GMNamedCurves.getByOID(aSN1ObjectIdentifier);
        }
        return byOID;
    }

    public static String getName(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        String name = X962NamedCurves.getName(aSN1ObjectIdentifier);
        if (name == null) {
            name = SECNamedCurves.getName(aSN1ObjectIdentifier);
        }
        if (name == null) {
            name = NISTNamedCurves.getName(aSN1ObjectIdentifier);
        }
        if (name == null) {
            name = TeleTrusTNamedCurves.getName(aSN1ObjectIdentifier);
        }
        if (name == null) {
            name = ANSSINamedCurves.getName(aSN1ObjectIdentifier);
        }
        if (name == null) {
            name = ECGOST3410NamedCurves.getName(aSN1ObjectIdentifier);
        }
        if (name == null) {
            name = GMNamedCurves.getName(aSN1ObjectIdentifier);
        }
        if (name == null) {
            return CustomNamedCurves.getName(aSN1ObjectIdentifier);
        }
        return name;
    }

    public static Enumeration getNames() {
        Vector vector = new Vector();
        addEnumeration(vector, X962NamedCurves.getNames());
        addEnumeration(vector, SECNamedCurves.getNames());
        addEnumeration(vector, NISTNamedCurves.getNames());
        addEnumeration(vector, TeleTrusTNamedCurves.getNames());
        addEnumeration(vector, ANSSINamedCurves.getNames());
        addEnumeration(vector, ECGOST3410NamedCurves.getNames());
        addEnumeration(vector, GMNamedCurves.getNames());
        return vector.elements();
    }

    public static ASN1ObjectIdentifier getOID(String str) {
        ASN1ObjectIdentifier oid = X962NamedCurves.getOID(str);
        if (oid == null) {
            oid = SECNamedCurves.getOID(str);
        }
        if (oid == null) {
            oid = NISTNamedCurves.getOID(str);
        }
        if (oid == null) {
            oid = TeleTrusTNamedCurves.getOID(str);
        }
        if (oid == null) {
            oid = ANSSINamedCurves.getOID(str);
        }
        if (oid == null) {
            oid = ECGOST3410NamedCurves.getOID(str);
        }
        if (oid == null) {
            oid = GMNamedCurves.getOID(str);
        }
        if (oid != null || !str.equals("curve25519")) {
            return oid;
        }
        return CryptlibObjectIdentifiers.curvey25519;
    }
}
