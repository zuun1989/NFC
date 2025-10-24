package com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.symmetric;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.misc.MiscObjectIdentifiers;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.PasswordConverter;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.generators.SCrypt;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.params.KeyParameter;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.config.ConfigurableProvider;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.symmetric.util.BCPBEKey;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.symmetric.util.BaseSecretKeyFactory;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.util.AlgorithmProvider;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.spec.ScryptKeySpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import javax.crypto.SecretKey;

public class SCRYPT {

    public static class BasePBKDF2 extends BaseSecretKeyFactory {
        private int scheme;

        public BasePBKDF2(String str, int i) {
            super(str, MiscObjectIdentifiers.id_scrypt);
            this.scheme = i;
        }

        public SecretKey engineGenerateSecret(KeySpec keySpec) throws InvalidKeySpecException {
            if (keySpec instanceof ScryptKeySpec) {
                ScryptKeySpec scryptKeySpec = (ScryptKeySpec) keySpec;
                if (scryptKeySpec.getSalt() == null) {
                    throw new IllegalArgumentException("Salt S must be provided.");
                } else if (scryptKeySpec.getCostParameter() <= 1) {
                    throw new IllegalArgumentException("Cost parameter N must be > 1.");
                } else if (scryptKeySpec.getKeyLength() <= 0) {
                    throw new InvalidKeySpecException("positive key length required: " + scryptKeySpec.getKeyLength());
                } else if (scryptKeySpec.getPassword().length != 0) {
                    return new BCPBEKey(this.algName, new KeyParameter(SCrypt.generate(PasswordConverter.UTF8.convert(scryptKeySpec.getPassword()), scryptKeySpec.getSalt(), scryptKeySpec.getCostParameter(), scryptKeySpec.getBlockSize(), scryptKeySpec.getParallelizationParameter(), scryptKeySpec.getKeyLength() / 8)));
                } else {
                    throw new IllegalArgumentException("password empty");
                }
            } else {
                throw new InvalidKeySpecException("Invalid KeySpec");
            }
        }
    }

    public static class Mappings extends AlgorithmProvider {
        private static final String PREFIX = SCRYPT.class.getName();

        public void configure(ConfigurableProvider configurableProvider) {
            StringBuilder sb2 = new StringBuilder();
            String str = PREFIX;
            sb2.append(str);
            sb2.append("$ScryptWithUTF8");
            configurableProvider.addAlgorithm("SecretKeyFactory.SCRYPT", sb2.toString());
            ASN1ObjectIdentifier aSN1ObjectIdentifier = MiscObjectIdentifiers.id_scrypt;
            configurableProvider.addAlgorithm("SecretKeyFactory", aSN1ObjectIdentifier, str + "$ScryptWithUTF8");
        }
    }

    public static class ScryptWithUTF8 extends BasePBKDF2 {
        public ScryptWithUTF8() {
            super("SCRYPT", 5);
        }
    }

    private SCRYPT() {
    }
}
