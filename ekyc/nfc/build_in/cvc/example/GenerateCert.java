package com.fis.ekyc.nfc.build_in.cvc.example;

import com.fis.ekyc.nfc.build_in.bouncycastle.jce.provider.BouncyCastleProvider;
import com.fis.ekyc.nfc.build_in.cvc.AuthorizationRoleEnum;
import com.fis.ekyc.nfc.build_in.cvc.CAReferenceField;
import com.fis.ekyc.nfc.build_in.cvc.CertificateGenerator;
import com.fis.ekyc.nfc.build_in.cvc.CertificateParser;
import com.fis.ekyc.nfc.build_in.cvc.HolderReferenceField;
import java.io.File;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.Security;

public final class GenerateCert {
    private GenerateCert() {
    }

    public static void main(String[] strArr) {
        try {
            Security.addProvider(new BouncyCastleProvider());
            KeyPairGenerator instance = KeyPairGenerator.getInstance("RSA", BouncyCastleProvider.PROVIDER_NAME);
            instance.initialize(1024, new SecureRandom());
            KeyPair generateKeyPair = instance.generateKeyPair();
            CAReferenceField cAReferenceField = new CAReferenceField("SE", "PASS-CVCA", "00111");
            FileHelper.writeFile(new File("C:/cv_certs/mycert1.cvcert"), CertificateGenerator.createTestCertificate(generateKeyPair.getPublic(), generateKeyPair.getPrivate(), cAReferenceField, new HolderReferenceField(cAReferenceField.getCountry(), cAReferenceField.getMnemonic(), cAReferenceField.getSequence()), "SHA1WithRSA", AuthorizationRoleEnum.IS).getDEREncoded());
            System.out.println(CertificateParser.parseCertificate(FileHelper.loadFile(new File("C:/cv_certs/mycert1.cvcert"))).getAsText(""));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
