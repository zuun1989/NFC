package com.fis.ekyc.nfc.build_in.cvc;

import com.fis.ekyc.nfc.build_in.cvc.exception.ConstructionException;
import com.fis.ekyc.nfc.build_in.cvc.util.BCECUtil;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.CertificateException;

public class CVCertificate extends AbstractSequence implements Signable {
    private static CVCTagEnum[] allowedFields = {CVCTagEnum.CERTIFICATE_BODY, CVCTagEnum.SIGNATURE};
    private static final long serialVersionUID = 1;

    public CVCertificate() {
        super(CVCTagEnum.CV_CERTIFICATE);
    }

    public CVCTagEnum[] getAllowedFields() {
        return allowedFields;
    }

    public CVCertificateBody getCertificateBody() throws NoSuchFieldException {
        return (CVCertificateBody) getSubfield(CVCTagEnum.CERTIFICATE_BODY);
    }

    public byte[] getSignature() throws NoSuchFieldException {
        return ((ByteField) getSubfield(CVCTagEnum.SIGNATURE)).getData();
    }

    public byte[] getTBS() throws ConstructionException {
        try {
            return getCertificateBody().getDEREncoded();
        } catch (IOException e) {
            throw new ConstructionException((Throwable) e);
        } catch (NoSuchFieldException e2) {
            throw new ConstructionException((Throwable) e2);
        }
    }

    public void setSignature(byte[] bArr) throws ConstructionException {
        addSubfield(new ByteField(CVCTagEnum.SIGNATURE, bArr));
    }

    public String toString() {
        return getAsText("");
    }

    public void verify(PublicKey publicKey, String str) throws CertificateException, NoSuchAlgorithmException, NoSuchProviderException, InvalidKeyException, SignatureException {
        OIDField oIDField;
        try {
            if (publicKey instanceof CVCPublicKey) {
                oIDField = ((CVCPublicKey) publicKey).getObjectIdentifier();
            } else {
                oIDField = getCertificateBody().getPublicKey().getObjectIdentifier();
            }
            String algorithmName = AlgorithmUtil.getAlgorithmName(oIDField);
            Signature instance = Signature.getInstance(algorithmName, str);
            instance.initVerify(publicKey);
            instance.update(getTBS());
            if (!instance.verify(BCECUtil.convertCVCSigToX962(algorithmName, getSignature()))) {
                throw new SignatureException("Signature verification failed!");
            }
        } catch (NoSuchFieldException e) {
            throw new CertificateException("CV-Certificate is corrupt", e);
        } catch (ConstructionException e2) {
            throw new CertificateException("CV-Certificate is corrupt", e2);
        }
    }

    public CVCertificate(CVCertificateBody cVCertificateBody) throws ConstructionException {
        this();
        if (cVCertificateBody != null) {
            addSubfield(cVCertificateBody);
            return;
        }
        throw new IllegalArgumentException("body is null");
    }
}
