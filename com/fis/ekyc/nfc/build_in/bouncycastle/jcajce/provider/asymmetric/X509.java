package com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric;

import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.config.ConfigurableProvider;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.util.AsymmetricAlgorithmProvider;

public class X509 {

    public static class Mappings extends AsymmetricAlgorithmProvider {
        public void configure(ConfigurableProvider configurableProvider) {
            configurableProvider.addAlgorithm("KeyFactory.X.509", "com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.x509.KeyFactory");
            configurableProvider.addAlgorithm("Alg.Alias.KeyFactory.X509", "X.509");
            configurableProvider.addAlgorithm("CertificateFactory.X.509", "com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.x509.CertificateFactory");
            configurableProvider.addAlgorithm("Alg.Alias.CertificateFactory.X509", "X.509");
        }
    }
}
