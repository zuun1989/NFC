package com.fis.ekyc.nfc.build_in.eidparser;

import com.fis.ekyc.nfc.build_in.bouncycastle.jce.provider.BouncyCastleProvider;
import java.security.Provider;
import java.security.Security;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

public class JMRTDSecurityProvider extends Provider {
    private static final Provider BC_PROVIDER;
    private static final String BC_PROVIDER_CLASS_NAME = "com.fis.ekyc.nfc.build_in.bouncycastle.jce.provider.BouncyCastleProvider";
    private static final Provider JMRTD_PROVIDER;
    private static final Logger LOGGER = Logger.getLogger("com.fis.ekyc.sdk.nfc.build_in..jmrtd");
    private static final Provider SC_PROVIDER;
    private static final String SC_PROVIDER_CLASS_NAME = "org.spongycastle.jce.provider.BouncyCastleProvider";
    private static final String SUN_PROVIDER_CLASS_NAME = "sun.security.provider.Sun";
    private static final long serialVersionUID = -2881416441551680704L;

    static {
        BouncyCastleProvider bouncyCastleProvider = new BouncyCastleProvider();
        BC_PROVIDER = bouncyCastleProvider;
        BouncyCastleProvider bouncyCastleProvider2 = new BouncyCastleProvider();
        SC_PROVIDER = bouncyCastleProvider2;
        JMRTDSecurityProvider jMRTDSecurityProvider = new JMRTDSecurityProvider();
        JMRTD_PROVIDER = jMRTDSecurityProvider;
        Security.insertProviderAt(bouncyCastleProvider, 1);
        Security.insertProviderAt(bouncyCastleProvider2, 2);
        Security.insertProviderAt(jMRTDSecurityProvider, 3);
    }

    private JMRTDSecurityProvider() {
        super("JMRTD", 0.1d, "JMRTD Security Provider");
        put("CertificateFactory.CVC", "com.fis.ekyc.sdk.nfc.build_in..jmrtd.cert.CVCertificateFactorySpi");
        if (BC_PROVIDER != null) {
            replicateFromProvider("CertificateFactory", "X.509", getBouncyCastleProvider());
            replicateFromProvider("CertStore", "Collection", getBouncyCastleProvider());
            replicateFromProvider("MessageDigest", "SHA1", getBouncyCastleProvider());
            replicateFromProvider("Signature", "SHA1withRSA/ISO9796-2", getBouncyCastleProvider());
            replicateFromProvider("Signature", "MD2withRSA", getBouncyCastleProvider());
            replicateFromProvider("Signature", "MD4withRSA", getBouncyCastleProvider());
            replicateFromProvider("Signature", "MD5withRSA", getBouncyCastleProvider());
            replicateFromProvider("Signature", "SHA1withRSA", getBouncyCastleProvider());
            replicateFromProvider("Signature", "SHA1withRSA/ISO9796-2", getBouncyCastleProvider());
            replicateFromProvider("Signature", "SHA256withRSA", getBouncyCastleProvider());
            replicateFromProvider("Signature", "SHA256withRSA/ISO9796-2", getBouncyCastleProvider());
            replicateFromProvider("Signature", "SHA384withRSA", getBouncyCastleProvider());
            replicateFromProvider("Signature", "SHA384withRSA/ISO9796-2", getBouncyCastleProvider());
            replicateFromProvider("Signature", "SHA512withRSA", getBouncyCastleProvider());
            replicateFromProvider("Signature", "SHA512withRSA/ISO9796-2", getBouncyCastleProvider());
            replicateFromProvider("Signature", "SHA224withRSA", getBouncyCastleProvider());
            replicateFromProvider("Signature", "SHA224withRSA/ISO9796-2", getBouncyCastleProvider());
            put("Alg.Alias.Mac.ISO9797Alg3Mac", "ISO9797ALG3MAC");
            put("Alg.Alias.CertificateFactory.X509", "X.509");
        }
    }

    public static int beginPreferBouncyCastleProvider() {
        Provider bouncyCastleProvider = getBouncyCastleProvider();
        if (bouncyCastleProvider == null) {
            return -1;
        }
        Provider[] providers = Security.getProviders();
        for (int i = 0; i < providers.length; i++) {
            Provider provider = providers[i];
            if (bouncyCastleProvider.getClass().getCanonicalName().equals(provider.getClass().getCanonicalName())) {
                Security.removeProvider(provider.getName());
                Security.insertProviderAt(bouncyCastleProvider, 1);
                return i + 1;
            }
        }
        return -1;
    }

    public static void endPreferBouncyCastleProvider(int i) {
        Provider bouncyCastleProvider = getBouncyCastleProvider();
        Security.removeProvider(bouncyCastleProvider.getName());
        if (i > 0) {
            Security.insertProviderAt(bouncyCastleProvider, i);
        }
    }

    public static Provider getBouncyCastleProvider() {
        Provider provider = BC_PROVIDER;
        if (provider != null) {
            return provider;
        }
        Provider provider2 = SC_PROVIDER;
        if (provider2 != null) {
            return provider2;
        }
        LOGGER.severe("No Bouncy or Spongy provider");
        return null;
    }

    public static Provider getInstance() {
        return JMRTD_PROVIDER;
    }

    private static Provider getProvider(String str, String str2) {
        List<Provider> providers = getProviders(str, str2);
        if (providers == null || providers.size() <= 0) {
            return null;
        }
        return providers.get(0);
    }

    private static List<Provider> getProviders(String str, String str2) {
        if (Security.getAlgorithms(str).contains(str2)) {
            return new ArrayList(Arrays.asList(Security.getProviders(str + "." + str2)));
        }
        Provider provider = BC_PROVIDER;
        if (provider != null && provider.getService(str, str2) != null) {
            return new ArrayList(Collections.singletonList(provider));
        }
        Provider provider2 = SC_PROVIDER;
        if (provider2 != null && provider2.getService(str, str2) != null) {
            return new ArrayList(Collections.singletonList(provider2));
        }
        Provider provider3 = JMRTD_PROVIDER;
        if (provider3 == null || provider3.getService(str, str2) == null) {
            return null;
        }
        return new ArrayList(Collections.singletonList(provider3));
    }

    public static Provider getSpongyCastleProvider() {
        Provider provider = SC_PROVIDER;
        if (provider != null) {
            return provider;
        }
        Provider provider2 = BC_PROVIDER;
        if (provider2 != null) {
            return provider2;
        }
        LOGGER.severe("No Bouncy or Spongy provider");
        return null;
    }

    private void replicateFromProvider(String str, String str2, Provider provider) {
        String str3 = str + "." + str2;
        Object obj = provider.get(str3);
        if (obj != null) {
            put(str3, obj);
        }
    }
}
