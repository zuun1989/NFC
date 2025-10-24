package com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Sequence;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.misc.MiscObjectIdentifiers;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.CompositePrivateKey;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.CompositePublicKey;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.util.BaseKeyFactorySpi;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.config.ConfigurableProvider;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.util.AsymmetricAlgorithmProvider;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.util.AsymmetricKeyInfoConverter;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.HashMap;
import java.util.Map;

public class COMPOSITE {
    private static final String PREFIX = "com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.COMPOSITE";
    /* access modifiers changed from: private */
    public static AsymmetricKeyInfoConverter baseConverter;
    private static final Map<String, String> compositeAttributes;

    public static class CompositeKeyInfoConverter implements AsymmetricKeyInfoConverter {
        private final ConfigurableProvider provider;

        public CompositeKeyInfoConverter(ConfigurableProvider configurableProvider) {
            this.provider = configurableProvider;
        }

        public PrivateKey generatePrivate(PrivateKeyInfo privateKeyInfo) throws IOException {
            ASN1Sequence instance = ASN1Sequence.getInstance(privateKeyInfo.getPrivateKey().getOctets());
            PrivateKey[] privateKeyArr = new PrivateKey[instance.size()];
            for (int i = 0; i != instance.size(); i++) {
                PrivateKeyInfo instance2 = PrivateKeyInfo.getInstance(instance.getObjectAt(i));
                privateKeyArr[i] = this.provider.getKeyInfoConverter(instance2.getPrivateKeyAlgorithm().getAlgorithm()).generatePrivate(instance2);
            }
            return new CompositePrivateKey(privateKeyArr);
        }

        public PublicKey generatePublic(SubjectPublicKeyInfo subjectPublicKeyInfo) throws IOException {
            ASN1Sequence instance = ASN1Sequence.getInstance(subjectPublicKeyInfo.getPublicKeyData().getBytes());
            PublicKey[] publicKeyArr = new PublicKey[instance.size()];
            for (int i = 0; i != instance.size(); i++) {
                SubjectPublicKeyInfo instance2 = SubjectPublicKeyInfo.getInstance(instance.getObjectAt(i));
                publicKeyArr[i] = this.provider.getKeyInfoConverter(instance2.getAlgorithm().getAlgorithm()).generatePublic(instance2);
            }
            return new CompositePublicKey(publicKeyArr);
        }
    }

    public static class KeyFactory extends BaseKeyFactorySpi {
        public Key engineTranslateKey(Key key) throws InvalidKeyException {
            try {
                if (key instanceof PrivateKey) {
                    return generatePrivate(PrivateKeyInfo.getInstance(key.getEncoded()));
                }
                if (key instanceof PublicKey) {
                    return generatePublic(SubjectPublicKeyInfo.getInstance(key.getEncoded()));
                }
                throw new InvalidKeyException("key not recognized");
            } catch (IOException e) {
                throw new InvalidKeyException("key could not be parsed: " + e.getMessage());
            }
        }

        public PrivateKey generatePrivate(PrivateKeyInfo privateKeyInfo) throws IOException {
            return COMPOSITE.baseConverter.generatePrivate(privateKeyInfo);
        }

        public PublicKey generatePublic(SubjectPublicKeyInfo subjectPublicKeyInfo) throws IOException {
            return COMPOSITE.baseConverter.generatePublic(subjectPublicKeyInfo);
        }
    }

    public static class Mappings extends AsymmetricAlgorithmProvider {
        public void configure(ConfigurableProvider configurableProvider) {
            configurableProvider.addAlgorithm("KeyFactory.COMPOSITE", "com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.COMPOSITE$KeyFactory");
            StringBuilder sb2 = new StringBuilder();
            sb2.append("KeyFactory.");
            ASN1ObjectIdentifier aSN1ObjectIdentifier = MiscObjectIdentifiers.id_alg_composite;
            sb2.append(aSN1ObjectIdentifier);
            configurableProvider.addAlgorithm(sb2.toString(), "com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.COMPOSITE$KeyFactory");
            configurableProvider.addAlgorithm("KeyFactory.OID." + aSN1ObjectIdentifier, "com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.asymmetric.COMPOSITE$KeyFactory");
            AsymmetricKeyInfoConverter unused = COMPOSITE.baseConverter = new CompositeKeyInfoConverter(configurableProvider);
            configurableProvider.addKeyInfoConverter(aSN1ObjectIdentifier, COMPOSITE.baseConverter);
        }
    }

    static {
        HashMap hashMap = new HashMap();
        compositeAttributes = hashMap;
        hashMap.put("SupportedKeyClasses", "com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.CompositePublicKey|com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.CompositePrivateKey");
        hashMap.put("SupportedKeyFormats", "PKCS#8|X.509");
    }
}
