package com.fis.ekyc.nfc.build_in.bouncycastle.asn1.util;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1InputStream;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive;
import java.io.FileInputStream;
import java.io.InputStream;

public class Dump {
    public static void main(String[] strArr) throws Exception {
        ASN1InputStream aSN1InputStream = new ASN1InputStream((InputStream) new FileInputStream(strArr[0]));
        while (true) {
            ASN1Primitive readObject = aSN1InputStream.readObject();
            if (readObject != null) {
                System.out.println(ASN1Dump.dumpAsString(readObject));
            } else {
                return;
            }
        }
    }
}
