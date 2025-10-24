package com.fis.ekyc.nfc.build_in.cvc.example;

import com.fis.ekyc.nfc.build_in.cvc.CertificateParser;
import java.io.File;

public final class Parse {
    private Parse() {
    }

    public static void main(String[] strArr) {
        try {
            System.out.println(CertificateParser.parseCVCObject(FileHelper.loadFile(new File("C:/cv_certs/mycert1.cvcert"))).getAsText());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
