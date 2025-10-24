package com.fis.ekyc.nfc.build_in.bouncycastle.jce.provider;

import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.PKIXExtendedParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.util.BCJcaJceHelper;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.util.JcaJceHelper;
import com.fis.ekyc.nfc.build_in.bouncycastle.x509.ExtendedPKIXParameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.x509.X509AttributeCertStoreSelector;
import java.security.InvalidAlgorithmParameterException;
import java.security.cert.CertPath;
import java.security.cert.CertPathParameters;
import java.security.cert.CertPathValidatorException;
import java.security.cert.CertPathValidatorResult;
import java.security.cert.CertPathValidatorSpi;
import java.security.cert.PKIXParameters;
import java.util.HashSet;

public class PKIXAttrCertPathValidatorSpi extends CertPathValidatorSpi {
    private final JcaJceHelper helper = new BCJcaJceHelper();

    public CertPathValidatorResult engineValidate(CertPath certPath, CertPathParameters certPathParameters) throws CertPathValidatorException, InvalidAlgorithmParameterException {
        PKIXExtendedParameters pKIXExtendedParameters;
        if ((certPathParameters instanceof ExtendedPKIXParameters) || (certPathParameters instanceof PKIXExtendedParameters)) {
            new HashSet();
            new HashSet();
            new HashSet();
            new HashSet();
            if (certPathParameters instanceof PKIXParameters) {
                PKIXExtendedParameters.Builder builder = new PKIXExtendedParameters.Builder((PKIXParameters) certPathParameters);
                if (certPathParameters instanceof ExtendedPKIXParameters) {
                    ExtendedPKIXParameters extendedPKIXParameters = (ExtendedPKIXParameters) certPathParameters;
                    builder.setUseDeltasEnabled(extendedPKIXParameters.isUseDeltasEnabled());
                    builder.setValidityModel(extendedPKIXParameters.getValidityModel());
                    extendedPKIXParameters.getAttrCertCheckers();
                    extendedPKIXParameters.getProhibitedACAttributes();
                    extendedPKIXParameters.getNecessaryACAttributes();
                }
                pKIXExtendedParameters = builder.build();
            } else {
                pKIXExtendedParameters = (PKIXExtendedParameters) certPathParameters;
            }
            pKIXExtendedParameters.getTargetConstraints();
            throw new InvalidAlgorithmParameterException("TargetConstraints must be an instance of " + X509AttributeCertStoreSelector.class.getName() + " for " + getClass().getName() + " class.");
        }
        throw new InvalidAlgorithmParameterException("Parameters must be a " + ExtendedPKIXParameters.class.getName() + " instance.");
    }
}
