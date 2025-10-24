package com.fis.ekyc.nfc.build_in.cvc.example;

import com.fis.ekyc.nfc.build_in.bouncycastle.jce.provider.BouncyCastleProvider;
import com.fis.ekyc.nfc.build_in.cvc.CAReferenceField;
import com.fis.ekyc.nfc.build_in.cvc.CVCAuthenticatedRequest;
import com.fis.ekyc.nfc.build_in.cvc.CVCertificate;
import com.fis.ekyc.nfc.build_in.cvc.CertificateGenerator;
import com.fis.ekyc.nfc.build_in.cvc.HolderReferenceField;
import java.io.File;
import java.io.PrintStream;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.Security;

public final class GenerateRequest {
    private GenerateRequest() {
    }

    public static void main(String[] strArr) {
        try {
            Security.addProvider(new BouncyCastleProvider());
            KeyPairGenerator instance = KeyPairGenerator.getInstance("RSA", BouncyCastleProvider.PROVIDER_NAME);
            instance.initialize(1024, new SecureRandom());
            KeyPair generateKeyPair = instance.generateKeyPair();
            CAReferenceField cAReferenceField = new CAReferenceField("SE", "PASSRD1", "00008");
            CVCertificate createRequest = CertificateGenerator.createRequest(generateKeyPair, "SHA256WITHRSAANDMGF1", new HolderReferenceField("SE", "PASSRD1", "00009"));
            PrintStream printStream = System.out;
            printStream.println(createRequest.getAsText());
            CVCAuthenticatedRequest createAuthenticatedRequest = CertificateGenerator.createAuthenticatedRequest(createRequest, generateKeyPair, "SHA256WITHRSAANDMGF1", cAReferenceField);
            printStream.println(createAuthenticatedRequest.getAsText());
            FileHelper.writeFile(new File("C:/cv_certs/request1.cvcert"), createAuthenticatedRequest.getDEREncoded());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
