package com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.keystore.pkcs12;

import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Encodable;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1EncodableVector;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1OctetString;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERBMPString;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERNull;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DEROctetString;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERSequence;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERSet;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.cryptopro.GOST28147Parameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.eac.CertificateHolderAuthorization;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ntt.NTTObjectIdentifiers;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.oiw.OIWObjectIdentifiers;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.CertBag;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.PBES2Parameters;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.PBKDF2Params;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.PKCS12PBEParams;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.SafeBag;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.AlgorithmIdentifier;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.AuthorityKeyIdentifier;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.Extension;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.SubjectKeyIdentifier;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.X509ObjectIdentifiers;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.CryptoServicesRegistrar;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.Digest;
import com.fis.ekyc.nfc.build_in.bouncycastle.crypto.util.DigestFactory;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.PKCS12Key;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.PKCS12StoreParameter;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.spec.GOST28147ParameterSpec;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.spec.PBKDF2KeySpec;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.util.BCJcaJceHelper;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.util.DefaultJcaJceHelper;
import com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.util.JcaJceHelper;
import com.fis.ekyc.nfc.build_in.bouncycastle.jce.interfaces.BCKeyStore;
import com.fis.ekyc.nfc.build_in.bouncycastle.jce.interfaces.PKCS12BagAttributeCarrier;
import com.fis.ekyc.nfc.build_in.bouncycastle.jce.provider.JDKPKCS12StoreParameter;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.Arrays;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.Integers;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.Properties;
import com.fis.ekyc.nfc.build_in.bouncycastle.util.Strings;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.KeyStoreSpi;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Principal;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.spec.InvalidKeySpecException;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;

public class PKCS12KeyStoreSpi extends KeyStoreSpi implements PKCSObjectIdentifiers, X509ObjectIdentifiers, BCKeyStore {
    static final int CERTIFICATE = 1;
    static final int KEY = 2;
    static final int KEY_PRIVATE = 0;
    static final int KEY_PUBLIC = 1;
    static final int KEY_SECRET = 2;
    private static final int MIN_ITERATIONS = 51200;
    static final int NULL = 0;
    static final String PKCS12_MAX_IT_COUNT_PROPERTY = "com.fis.ekyc.nfc.build_in.bouncycastle.pkcs12.max_it_count";
    private static final int SALT_SIZE = 20;
    static final int SEALED = 4;
    static final int SECRET = 3;
    private static final DefaultSecretKeyProvider keySizeProvider = new DefaultSecretKeyProvider();
    private ASN1ObjectIdentifier certAlgorithm;
    private CertificateFactory certFact;
    private IgnoresCaseHashtable certs = new IgnoresCaseHashtable();
    private Hashtable chainCerts = new Hashtable();
    private final JcaJceHelper helper = new BCJcaJceHelper();
    private int itCount = 102400;
    private ASN1ObjectIdentifier keyAlgorithm;
    private Hashtable keyCerts = new Hashtable();
    private IgnoresCaseHashtable keys = new IgnoresCaseHashtable();
    private Hashtable localIds = new Hashtable();
    private AlgorithmIdentifier macAlgorithm = new AlgorithmIdentifier(OIWObjectIdentifiers.idSHA1, DERNull.INSTANCE);
    protected SecureRandom random = CryptoServicesRegistrar.getSecureRandom();
    private int saltLength = 20;

    public static class BCPKCS12KeyStore extends PKCS12KeyStoreSpi {
        public BCPKCS12KeyStore() {
            super(new BCJcaJceHelper(), PKCSObjectIdentifiers.pbeWithSHAAnd3_KeyTripleDES_CBC, PKCSObjectIdentifiers.pbeWithSHAAnd40BitRC2_CBC);
        }
    }

    public static class BCPKCS12KeyStore3DES extends PKCS12KeyStoreSpi {
        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public BCPKCS12KeyStore3DES() {
            /*
                r2 = this;
                com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.util.BCJcaJceHelper r0 = new com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.util.BCJcaJceHelper
                r0.<init>()
                com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier r1 = com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers.pbeWithSHAAnd3_KeyTripleDES_CBC
                r2.<init>(r0, r1, r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.keystore.pkcs12.PKCS12KeyStoreSpi.BCPKCS12KeyStore3DES.<init>():void");
        }
    }

    public static class DefPKCS12KeyStore extends PKCS12KeyStoreSpi {
        public DefPKCS12KeyStore() {
            super(new DefaultJcaJceHelper(), PKCSObjectIdentifiers.pbeWithSHAAnd3_KeyTripleDES_CBC, PKCSObjectIdentifiers.pbeWithSHAAnd40BitRC2_CBC);
        }
    }

    public static class DefPKCS12KeyStore3DES extends PKCS12KeyStoreSpi {
        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public DefPKCS12KeyStore3DES() {
            /*
                r2 = this;
                com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.util.DefaultJcaJceHelper r0 = new com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.util.DefaultJcaJceHelper
                r0.<init>()
                com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier r1 = com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers.pbeWithSHAAnd3_KeyTripleDES_CBC
                r2.<init>(r0, r1, r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.keystore.pkcs12.PKCS12KeyStoreSpi.DefPKCS12KeyStore3DES.<init>():void");
        }
    }

    public static class DefaultSecretKeyProvider {
        private final Map KEY_SIZES;

        public DefaultSecretKeyProvider() {
            HashMap hashMap = new HashMap();
            hashMap.put(new ASN1ObjectIdentifier("1.2.840.113533.7.66.10"), Integers.valueOf(128));
            hashMap.put(PKCSObjectIdentifiers.des_EDE3_CBC, Integers.valueOf(CertificateHolderAuthorization.CVCA));
            hashMap.put(NISTObjectIdentifiers.id_aes128_CBC, Integers.valueOf(128));
            hashMap.put(NISTObjectIdentifiers.id_aes192_CBC, Integers.valueOf(CertificateHolderAuthorization.CVCA));
            hashMap.put(NISTObjectIdentifiers.id_aes256_CBC, Integers.valueOf(256));
            hashMap.put(NTTObjectIdentifiers.id_camellia128_cbc, Integers.valueOf(128));
            hashMap.put(NTTObjectIdentifiers.id_camellia192_cbc, Integers.valueOf(CertificateHolderAuthorization.CVCA));
            hashMap.put(NTTObjectIdentifiers.id_camellia256_cbc, Integers.valueOf(256));
            hashMap.put(CryptoProObjectIdentifiers.gostR28147_gcfb, Integers.valueOf(256));
            this.KEY_SIZES = Collections.unmodifiableMap(hashMap);
        }

        public int getKeySize(AlgorithmIdentifier algorithmIdentifier) {
            Integer num = (Integer) this.KEY_SIZES.get(algorithmIdentifier.getAlgorithm());
            if (num != null) {
                return num.intValue();
            }
            return -1;
        }
    }

    public static class IgnoresCaseHashtable {
        private Hashtable keys;
        private Hashtable orig;

        private IgnoresCaseHashtable() {
            this.orig = new Hashtable();
            this.keys = new Hashtable();
        }

        public Enumeration elements() {
            return this.orig.elements();
        }

        public Object get(String str) {
            String str2;
            Hashtable hashtable = this.keys;
            if (str == null) {
                str2 = null;
            } else {
                str2 = Strings.toLowerCase(str);
            }
            String str3 = (String) hashtable.get(str2);
            if (str3 == null) {
                return null;
            }
            return this.orig.get(str3);
        }

        public Enumeration keys() {
            return this.orig.keys();
        }

        public void put(String str, Object obj) {
            String str2;
            if (str == null) {
                str2 = null;
            } else {
                str2 = Strings.toLowerCase(str);
            }
            String str3 = (String) this.keys.get(str2);
            if (str3 != null) {
                this.orig.remove(str3);
            }
            this.keys.put(str2, str);
            this.orig.put(str, obj);
        }

        public Object remove(String str) {
            String str2;
            Hashtable hashtable = this.keys;
            if (str == null) {
                str2 = null;
            } else {
                str2 = Strings.toLowerCase(str);
            }
            String str3 = (String) hashtable.remove(str2);
            if (str3 == null) {
                return null;
            }
            return this.orig.remove(str3);
        }

        public int size() {
            return this.orig.size();
        }
    }

    public PKCS12KeyStoreSpi(JcaJceHelper jcaJceHelper, ASN1ObjectIdentifier aSN1ObjectIdentifier, ASN1ObjectIdentifier aSN1ObjectIdentifier2) {
        this.keyAlgorithm = aSN1ObjectIdentifier;
        this.certAlgorithm = aSN1ObjectIdentifier2;
        try {
            this.certFact = jcaJceHelper.createCertificateFactory("X.509");
        } catch (Exception e) {
            throw new IllegalArgumentException("can't create cert factory - " + e.toString());
        }
    }

    private byte[] calculatePbeMac(ASN1ObjectIdentifier aSN1ObjectIdentifier, byte[] bArr, int i, char[] cArr, boolean z, byte[] bArr2) throws Exception {
        PBEParameterSpec pBEParameterSpec = new PBEParameterSpec(bArr, i);
        Mac createMac = this.helper.createMac(aSN1ObjectIdentifier.getId());
        createMac.init(new PKCS12Key(cArr, z), pBEParameterSpec);
        createMac.update(bArr2);
        return createMac.doFinal();
    }

    private Cipher createCipher(int i, char[] cArr, AlgorithmIdentifier algorithmIdentifier) throws NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, NoSuchProviderException {
        SecretKey secretKey;
        PBES2Parameters instance = PBES2Parameters.getInstance(algorithmIdentifier.getParameters());
        PBKDF2Params instance2 = PBKDF2Params.getInstance(instance.getKeyDerivationFunc().getParameters());
        AlgorithmIdentifier instance3 = AlgorithmIdentifier.getInstance(instance.getEncryptionScheme());
        SecretKeyFactory createSecretKeyFactory = this.helper.createSecretKeyFactory(instance.getKeyDerivationFunc().getAlgorithm().getId());
        if (instance2.isDefaultPrf()) {
            secretKey = createSecretKeyFactory.generateSecret(new PBEKeySpec(cArr, instance2.getSalt(), validateIterationCount(instance2.getIterationCount()), keySizeProvider.getKeySize(instance3)));
        } else {
            secretKey = createSecretKeyFactory.generateSecret(new PBKDF2KeySpec(cArr, instance2.getSalt(), validateIterationCount(instance2.getIterationCount()), keySizeProvider.getKeySize(instance3), instance2.getPrf()));
        }
        Cipher instance4 = Cipher.getInstance(instance.getEncryptionScheme().getAlgorithm().getId());
        ASN1Encodable parameters = instance.getEncryptionScheme().getParameters();
        if (parameters instanceof ASN1OctetString) {
            instance4.init(i, secretKey, new IvParameterSpec(ASN1OctetString.getInstance(parameters).getOctets()));
        } else {
            GOST28147Parameters instance5 = GOST28147Parameters.getInstance(parameters);
            instance4.init(i, secretKey, new GOST28147ParameterSpec(instance5.getEncryptionParamSet(), instance5.getIV()));
        }
        return instance4;
    }

    private SafeBag createSafeBag(String str, Certificate certificate) throws CertificateEncodingException {
        CertBag certBag = new CertBag(PKCSObjectIdentifiers.x509Certificate, new DEROctetString(certificate.getEncoded()));
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        boolean z = false;
        if (certificate instanceof PKCS12BagAttributeCarrier) {
            PKCS12BagAttributeCarrier pKCS12BagAttributeCarrier = (PKCS12BagAttributeCarrier) certificate;
            ASN1ObjectIdentifier aSN1ObjectIdentifier = PKCSObjectIdentifiers.pkcs_9_at_friendlyName;
            DERBMPString dERBMPString = (DERBMPString) pKCS12BagAttributeCarrier.getBagAttribute(aSN1ObjectIdentifier);
            if ((dERBMPString == null || !dERBMPString.getString().equals(str)) && str != null) {
                pKCS12BagAttributeCarrier.setBagAttribute(aSN1ObjectIdentifier, new DERBMPString(str));
            }
            Enumeration bagAttributeKeys = pKCS12BagAttributeCarrier.getBagAttributeKeys();
            while (bagAttributeKeys.hasMoreElements()) {
                ASN1ObjectIdentifier aSN1ObjectIdentifier2 = (ASN1ObjectIdentifier) bagAttributeKeys.nextElement();
                if (!aSN1ObjectIdentifier2.equals((ASN1Primitive) PKCSObjectIdentifiers.pkcs_9_at_localKeyId)) {
                    ASN1EncodableVector aSN1EncodableVector2 = new ASN1EncodableVector();
                    aSN1EncodableVector2.add(aSN1ObjectIdentifier2);
                    aSN1EncodableVector2.add(new DERSet(pKCS12BagAttributeCarrier.getBagAttribute(aSN1ObjectIdentifier2)));
                    aSN1EncodableVector.add(new DERSequence(aSN1EncodableVector2));
                    z = true;
                }
            }
        }
        if (!z) {
            ASN1EncodableVector aSN1EncodableVector3 = new ASN1EncodableVector();
            aSN1EncodableVector3.add(PKCSObjectIdentifiers.pkcs_9_at_friendlyName);
            aSN1EncodableVector3.add(new DERSet((ASN1Encodable) new DERBMPString(str)));
            aSN1EncodableVector.add(new DERSequence(aSN1EncodableVector3));
        }
        return new SafeBag(PKCSObjectIdentifiers.certBag, certBag.toASN1Primitive(), new DERSet(aSN1EncodableVector));
    }

    /* access modifiers changed from: private */
    public SubjectKeyIdentifier createSubjectKeyId(PublicKey publicKey) {
        try {
            return new SubjectKeyIdentifier(getDigest(SubjectPublicKeyInfo.getInstance(publicKey.getEncoded())));
        } catch (Exception unused) {
            throw new RuntimeException("error creating key");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:53:0x025d A[Catch:{ CertificateEncodingException -> 0x024a }] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0273 A[Catch:{ CertificateEncodingException -> 0x024a }, LOOP:4: B:55:0x026d->B:57:0x0273, LOOP_END] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void doStore(java.io.OutputStream r21, char[] r22, boolean r23) throws java.io.IOException {
        /*
            r20 = this;
            r8 = r20
            r0 = r21
            r7 = r22
            com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.keystore.pkcs12.PKCS12KeyStoreSpi$IgnoresCaseHashtable r1 = r8.keys
            int r1 = r1.size()
            java.lang.String r9 = "BER"
            java.lang.String r2 = "Error encoding certificate: "
            java.lang.String r10 = "DER"
            if (r1 != 0) goto L_0x00bc
            if (r7 != 0) goto L_0x00be
            com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.keystore.pkcs12.PKCS12KeyStoreSpi$IgnoresCaseHashtable r1 = r8.certs
            java.util.Enumeration r1 = r1.keys()
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1EncodableVector r3 = new com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1EncodableVector
            r3.<init>()
        L_0x0021:
            boolean r4 = r1.hasMoreElements()
            if (r4 == 0) goto L_0x0057
            java.lang.Object r4 = r1.nextElement()     // Catch:{ CertificateEncodingException -> 0x003d }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ CertificateEncodingException -> 0x003d }
            com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.keystore.pkcs12.PKCS12KeyStoreSpi$IgnoresCaseHashtable r5 = r8.certs     // Catch:{ CertificateEncodingException -> 0x003d }
            java.lang.Object r5 = r5.get(r4)     // Catch:{ CertificateEncodingException -> 0x003d }
            java.security.cert.Certificate r5 = (java.security.cert.Certificate) r5     // Catch:{ CertificateEncodingException -> 0x003d }
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.SafeBag r4 = r8.createSafeBag(r4, r5)     // Catch:{ CertificateEncodingException -> 0x003d }
            r3.add(r4)     // Catch:{ CertificateEncodingException -> 0x003d }
            goto L_0x0021
        L_0x003d:
            r0 = move-exception
            java.io.IOException r1 = new java.io.IOException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r2)
            java.lang.String r0 = r0.toString()
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            r1.<init>(r0)
            throw r1
        L_0x0057:
            r1 = 0
            if (r23 == 0) goto L_0x008b
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.ContentInfo r2 = new com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.ContentInfo
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier r4 = com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers.data
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DEROctetString r5 = new com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DEROctetString
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERSequence r6 = new com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERSequence
            r6.<init>((com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1EncodableVector) r3)
            byte[] r3 = r6.getEncoded()
            r5.<init>((byte[]) r3)
            r2.<init>(r4, r5)
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.Pfx r3 = new com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.Pfx
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.ContentInfo r5 = new com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.ContentInfo
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DEROctetString r6 = new com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DEROctetString
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERSequence r7 = new com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERSequence
            r7.<init>((com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Encodable) r2)
            byte[] r2 = r7.getEncoded()
            r6.<init>((byte[]) r2)
            r5.<init>(r4, r6)
            r3.<init>(r5, r1)
            r3.encodeTo(r0, r10)
            goto L_0x00bb
        L_0x008b:
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.ContentInfo r2 = new com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.ContentInfo
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier r4 = com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers.data
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.BEROctetString r5 = new com.fis.ekyc.nfc.build_in.bouncycastle.asn1.BEROctetString
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.BERSequence r6 = new com.fis.ekyc.nfc.build_in.bouncycastle.asn1.BERSequence
            r6.<init>((com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1EncodableVector) r3)
            byte[] r3 = r6.getEncoded()
            r5.<init>((byte[]) r3)
            r2.<init>(r4, r5)
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.Pfx r3 = new com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.Pfx
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.ContentInfo r5 = new com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.ContentInfo
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.BEROctetString r6 = new com.fis.ekyc.nfc.build_in.bouncycastle.asn1.BEROctetString
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.BERSequence r7 = new com.fis.ekyc.nfc.build_in.bouncycastle.asn1.BERSequence
            r7.<init>((com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Encodable) r2)
            byte[] r2 = r7.getEncoded()
            r6.<init>((byte[]) r2)
            r5.<init>(r4, r6)
            r3.<init>(r5, r1)
            r3.encodeTo(r0, r9)
        L_0x00bb:
            return
        L_0x00bc:
            if (r7 == 0) goto L_0x04c9
        L_0x00be:
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1EncodableVector r1 = new com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1EncodableVector
            r1.<init>()
            com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.keystore.pkcs12.PKCS12KeyStoreSpi$IgnoresCaseHashtable r3 = r8.keys
            java.util.Enumeration r3 = r3.keys()
        L_0x00c9:
            boolean r4 = r3.hasMoreElements()
            r11 = 51200(0xc800, float:7.1746E-41)
            r12 = 20
            if (r4 == 0) goto L_0x01d2
            byte[] r4 = new byte[r12]
            java.security.SecureRandom r12 = r8.random
            r12.nextBytes(r4)
            java.lang.Object r12 = r3.nextElement()
            java.lang.String r12 = (java.lang.String) r12
            com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.keystore.pkcs12.PKCS12KeyStoreSpi$IgnoresCaseHashtable r13 = r8.keys
            java.lang.Object r13 = r13.get(r12)
            java.security.PrivateKey r13 = (java.security.PrivateKey) r13
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.PKCS12PBEParams r14 = new com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.PKCS12PBEParams
            r14.<init>(r4, r11)
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier r4 = r8.keyAlgorithm
            java.lang.String r4 = r4.getId()
            byte[] r4 = r8.wrapKey(r4, r13, r14, r7)
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.AlgorithmIdentifier r11 = new com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.AlgorithmIdentifier
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier r15 = r8.keyAlgorithm
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive r14 = r14.toASN1Primitive()
            r11.<init>(r15, r14)
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.EncryptedPrivateKeyInfo r14 = new com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.EncryptedPrivateKeyInfo
            r14.<init>(r11, r4)
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1EncodableVector r4 = new com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1EncodableVector
            r4.<init>()
            boolean r11 = r13 instanceof com.fis.ekyc.nfc.build_in.bouncycastle.jce.interfaces.PKCS12BagAttributeCarrier
            if (r11 == 0) goto L_0x0175
            com.fis.ekyc.nfc.build_in.bouncycastle.jce.interfaces.PKCS12BagAttributeCarrier r13 = (com.fis.ekyc.nfc.build_in.bouncycastle.jce.interfaces.PKCS12BagAttributeCarrier) r13
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier r11 = com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers.pkcs_9_at_friendlyName
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Encodable r15 = r13.getBagAttribute(r11)
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERBMPString r15 = (com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERBMPString) r15
            if (r15 == 0) goto L_0x0127
            java.lang.String r15 = r15.getString()
            boolean r15 = r15.equals(r12)
            if (r15 != 0) goto L_0x012f
        L_0x0127:
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERBMPString r15 = new com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERBMPString
            r15.<init>((java.lang.String) r12)
            r13.setBagAttribute(r11, r15)
        L_0x012f:
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier r11 = com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers.pkcs_9_at_localKeyId
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Encodable r15 = r13.getBagAttribute(r11)
            if (r15 != 0) goto L_0x0146
            java.security.cert.Certificate r15 = r8.engineGetCertificate(r12)
            java.security.PublicKey r15 = r15.getPublicKey()
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.SubjectKeyIdentifier r15 = r8.createSubjectKeyId(r15)
            r13.setBagAttribute(r11, r15)
        L_0x0146:
            java.util.Enumeration r11 = r13.getBagAttributeKeys()
            r6 = 0
        L_0x014b:
            boolean r15 = r11.hasMoreElements()
            if (r15 == 0) goto L_0x0176
            java.lang.Object r6 = r11.nextElement()
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier r6 = (com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier) r6
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1EncodableVector r15 = new com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1EncodableVector
            r15.<init>()
            r15.add(r6)
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERSet r5 = new com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERSet
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Encodable r6 = r13.getBagAttribute(r6)
            r5.<init>((com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Encodable) r6)
            r15.add(r5)
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERSequence r5 = new com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERSequence
            r5.<init>((com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1EncodableVector) r15)
            r4.add(r5)
            r6 = 1
            goto L_0x014b
        L_0x0175:
            r6 = 0
        L_0x0176:
            if (r6 != 0) goto L_0x01bd
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1EncodableVector r5 = new com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1EncodableVector
            r5.<init>()
            java.security.cert.Certificate r6 = r8.engineGetCertificate(r12)
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier r11 = com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers.pkcs_9_at_localKeyId
            r5.add(r11)
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERSet r11 = new com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERSet
            java.security.PublicKey r6 = r6.getPublicKey()
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.SubjectKeyIdentifier r6 = r8.createSubjectKeyId(r6)
            r11.<init>((com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Encodable) r6)
            r5.add(r11)
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERSequence r6 = new com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERSequence
            r6.<init>((com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1EncodableVector) r5)
            r4.add(r6)
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1EncodableVector r5 = new com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1EncodableVector
            r5.<init>()
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier r6 = com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers.pkcs_9_at_friendlyName
            r5.add(r6)
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERSet r6 = new com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERSet
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERBMPString r11 = new com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERBMPString
            r11.<init>((java.lang.String) r12)
            r6.<init>((com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Encodable) r11)
            r5.add(r6)
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERSequence r6 = new com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERSequence
            r6.<init>((com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1EncodableVector) r5)
            r4.add(r6)
        L_0x01bd:
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.SafeBag r5 = new com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.SafeBag
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier r6 = com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers.pkcs8ShroudedKeyBag
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive r11 = r14.toASN1Primitive()
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERSet r12 = new com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERSet
            r12.<init>((com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1EncodableVector) r4)
            r5.<init>(r6, r11, r12)
            r1.add(r5)
            goto L_0x00c9
        L_0x01d2:
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERSequence r3 = new com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERSequence
            r3.<init>((com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1EncodableVector) r1)
            byte[] r1 = r3.getEncoded(r10)
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.BEROctetString r13 = new com.fis.ekyc.nfc.build_in.bouncycastle.asn1.BEROctetString
            r13.<init>((byte[]) r1)
            byte[] r1 = new byte[r12]
            java.security.SecureRandom r3 = r8.random
            r3.nextBytes(r1)
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1EncodableVector r3 = new com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1EncodableVector
            r3.<init>()
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.PKCS12PBEParams r4 = new com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.PKCS12PBEParams
            r4.<init>(r1, r11)
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.AlgorithmIdentifier r11 = new com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.AlgorithmIdentifier
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier r1 = r8.certAlgorithm
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive r4 = r4.toASN1Primitive()
            r11.<init>(r1, r4)
            java.util.Hashtable r1 = new java.util.Hashtable
            r1.<init>()
            com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.keystore.pkcs12.PKCS12KeyStoreSpi$IgnoresCaseHashtable r4 = r8.keys
            java.util.Enumeration r4 = r4.keys()
        L_0x0207:
            boolean r5 = r4.hasMoreElements()
            if (r5 == 0) goto L_0x031f
            java.lang.Object r5 = r4.nextElement()     // Catch:{ CertificateEncodingException -> 0x024a }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ CertificateEncodingException -> 0x024a }
            java.security.cert.Certificate r12 = r8.engineGetCertificate(r5)     // Catch:{ CertificateEncodingException -> 0x024a }
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.CertBag r14 = new com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.CertBag     // Catch:{ CertificateEncodingException -> 0x024a }
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier r15 = com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers.x509Certificate     // Catch:{ CertificateEncodingException -> 0x024a }
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DEROctetString r6 = new com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DEROctetString     // Catch:{ CertificateEncodingException -> 0x024a }
            r17 = r4
            byte[] r4 = r12.getEncoded()     // Catch:{ CertificateEncodingException -> 0x024a }
            r6.<init>((byte[]) r4)     // Catch:{ CertificateEncodingException -> 0x024a }
            r14.<init>(r15, r6)     // Catch:{ CertificateEncodingException -> 0x024a }
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1EncodableVector r4 = new com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1EncodableVector     // Catch:{ CertificateEncodingException -> 0x024a }
            r4.<init>()     // Catch:{ CertificateEncodingException -> 0x024a }
            boolean r6 = r12 instanceof com.fis.ekyc.nfc.build_in.bouncycastle.jce.interfaces.PKCS12BagAttributeCarrier     // Catch:{ CertificateEncodingException -> 0x024a }
            if (r6 == 0) goto L_0x02a2
            r6 = r12
            com.fis.ekyc.nfc.build_in.bouncycastle.jce.interfaces.PKCS12BagAttributeCarrier r6 = (com.fis.ekyc.nfc.build_in.bouncycastle.jce.interfaces.PKCS12BagAttributeCarrier) r6     // Catch:{ CertificateEncodingException -> 0x024a }
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier r15 = com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers.pkcs_9_at_friendlyName     // Catch:{ CertificateEncodingException -> 0x024a }
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Encodable r18 = r6.getBagAttribute(r15)     // Catch:{ CertificateEncodingException -> 0x024a }
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERBMPString r18 = (com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERBMPString) r18     // Catch:{ CertificateEncodingException -> 0x024a }
            if (r18 == 0) goto L_0x024d
            java.lang.String r7 = r18.getString()     // Catch:{ CertificateEncodingException -> 0x024a }
            boolean r7 = r7.equals(r5)     // Catch:{ CertificateEncodingException -> 0x024a }
            if (r7 != 0) goto L_0x0255
            goto L_0x024d
        L_0x024a:
            r0 = move-exception
            goto L_0x0306
        L_0x024d:
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERBMPString r7 = new com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERBMPString     // Catch:{ CertificateEncodingException -> 0x024a }
            r7.<init>((java.lang.String) r5)     // Catch:{ CertificateEncodingException -> 0x024a }
            r6.setBagAttribute(r15, r7)     // Catch:{ CertificateEncodingException -> 0x024a }
        L_0x0255:
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier r7 = com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers.pkcs_9_at_localKeyId     // Catch:{ CertificateEncodingException -> 0x024a }
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Encodable r15 = r6.getBagAttribute(r7)     // Catch:{ CertificateEncodingException -> 0x024a }
            if (r15 != 0) goto L_0x0268
            java.security.PublicKey r15 = r12.getPublicKey()     // Catch:{ CertificateEncodingException -> 0x024a }
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.SubjectKeyIdentifier r15 = r8.createSubjectKeyId(r15)     // Catch:{ CertificateEncodingException -> 0x024a }
            r6.setBagAttribute(r7, r15)     // Catch:{ CertificateEncodingException -> 0x024a }
        L_0x0268:
            java.util.Enumeration r7 = r6.getBagAttributeKeys()     // Catch:{ CertificateEncodingException -> 0x024a }
            r15 = 0
        L_0x026d:
            boolean r18 = r7.hasMoreElements()     // Catch:{ CertificateEncodingException -> 0x024a }
            if (r18 == 0) goto L_0x029f
            java.lang.Object r15 = r7.nextElement()     // Catch:{ CertificateEncodingException -> 0x024a }
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier r15 = (com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier) r15     // Catch:{ CertificateEncodingException -> 0x024a }
            r18 = r7
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1EncodableVector r7 = new com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1EncodableVector     // Catch:{ CertificateEncodingException -> 0x024a }
            r7.<init>()     // Catch:{ CertificateEncodingException -> 0x024a }
            r7.add(r15)     // Catch:{ CertificateEncodingException -> 0x024a }
            r19 = r9
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERSet r9 = new com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERSet     // Catch:{ CertificateEncodingException -> 0x024a }
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Encodable r15 = r6.getBagAttribute(r15)     // Catch:{ CertificateEncodingException -> 0x024a }
            r9.<init>((com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Encodable) r15)     // Catch:{ CertificateEncodingException -> 0x024a }
            r7.add(r9)     // Catch:{ CertificateEncodingException -> 0x024a }
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERSequence r9 = new com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERSequence     // Catch:{ CertificateEncodingException -> 0x024a }
            r9.<init>((com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1EncodableVector) r7)     // Catch:{ CertificateEncodingException -> 0x024a }
            r4.add(r9)     // Catch:{ CertificateEncodingException -> 0x024a }
            r7 = r18
            r9 = r19
            r15 = 1
            goto L_0x026d
        L_0x029f:
            r19 = r9
            goto L_0x02a5
        L_0x02a2:
            r19 = r9
            r15 = 0
        L_0x02a5:
            if (r15 != 0) goto L_0x02e8
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1EncodableVector r6 = new com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1EncodableVector     // Catch:{ CertificateEncodingException -> 0x024a }
            r6.<init>()     // Catch:{ CertificateEncodingException -> 0x024a }
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier r7 = com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers.pkcs_9_at_localKeyId     // Catch:{ CertificateEncodingException -> 0x024a }
            r6.add(r7)     // Catch:{ CertificateEncodingException -> 0x024a }
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERSet r7 = new com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERSet     // Catch:{ CertificateEncodingException -> 0x024a }
            java.security.PublicKey r9 = r12.getPublicKey()     // Catch:{ CertificateEncodingException -> 0x024a }
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.SubjectKeyIdentifier r9 = r8.createSubjectKeyId(r9)     // Catch:{ CertificateEncodingException -> 0x024a }
            r7.<init>((com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Encodable) r9)     // Catch:{ CertificateEncodingException -> 0x024a }
            r6.add(r7)     // Catch:{ CertificateEncodingException -> 0x024a }
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERSequence r7 = new com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERSequence     // Catch:{ CertificateEncodingException -> 0x024a }
            r7.<init>((com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1EncodableVector) r6)     // Catch:{ CertificateEncodingException -> 0x024a }
            r4.add(r7)     // Catch:{ CertificateEncodingException -> 0x024a }
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1EncodableVector r6 = new com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1EncodableVector     // Catch:{ CertificateEncodingException -> 0x024a }
            r6.<init>()     // Catch:{ CertificateEncodingException -> 0x024a }
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier r7 = com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers.pkcs_9_at_friendlyName     // Catch:{ CertificateEncodingException -> 0x024a }
            r6.add(r7)     // Catch:{ CertificateEncodingException -> 0x024a }
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERSet r7 = new com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERSet     // Catch:{ CertificateEncodingException -> 0x024a }
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERBMPString r9 = new com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERBMPString     // Catch:{ CertificateEncodingException -> 0x024a }
            r9.<init>((java.lang.String) r5)     // Catch:{ CertificateEncodingException -> 0x024a }
            r7.<init>((com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Encodable) r9)     // Catch:{ CertificateEncodingException -> 0x024a }
            r6.add(r7)     // Catch:{ CertificateEncodingException -> 0x024a }
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERSequence r5 = new com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERSequence     // Catch:{ CertificateEncodingException -> 0x024a }
            r5.<init>((com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1EncodableVector) r6)     // Catch:{ CertificateEncodingException -> 0x024a }
            r4.add(r5)     // Catch:{ CertificateEncodingException -> 0x024a }
        L_0x02e8:
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.SafeBag r5 = new com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.SafeBag     // Catch:{ CertificateEncodingException -> 0x024a }
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier r6 = com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers.certBag     // Catch:{ CertificateEncodingException -> 0x024a }
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive r7 = r14.toASN1Primitive()     // Catch:{ CertificateEncodingException -> 0x024a }
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERSet r9 = new com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERSet     // Catch:{ CertificateEncodingException -> 0x024a }
            r9.<init>((com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1EncodableVector) r4)     // Catch:{ CertificateEncodingException -> 0x024a }
            r5.<init>(r6, r7, r9)     // Catch:{ CertificateEncodingException -> 0x024a }
            r3.add(r5)     // Catch:{ CertificateEncodingException -> 0x024a }
            r1.put(r12, r12)     // Catch:{ CertificateEncodingException -> 0x024a }
            r7 = r22
            r4 = r17
            r9 = r19
            goto L_0x0207
        L_0x0306:
            java.io.IOException r1 = new java.io.IOException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r2)
            java.lang.String r0 = r0.toString()
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            r1.<init>(r0)
            throw r1
        L_0x031f:
            r19 = r9
            com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.keystore.pkcs12.PKCS12KeyStoreSpi$IgnoresCaseHashtable r4 = r8.certs
            java.util.Enumeration r4 = r4.keys()
        L_0x0327:
            boolean r5 = r4.hasMoreElements()
            if (r5 == 0) goto L_0x0369
            java.lang.Object r5 = r4.nextElement()     // Catch:{ CertificateEncodingException -> 0x034f }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ CertificateEncodingException -> 0x034f }
            com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.keystore.pkcs12.PKCS12KeyStoreSpi$IgnoresCaseHashtable r6 = r8.certs     // Catch:{ CertificateEncodingException -> 0x034f }
            java.lang.Object r6 = r6.get(r5)     // Catch:{ CertificateEncodingException -> 0x034f }
            java.security.cert.Certificate r6 = (java.security.cert.Certificate) r6     // Catch:{ CertificateEncodingException -> 0x034f }
            com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.keystore.pkcs12.PKCS12KeyStoreSpi$IgnoresCaseHashtable r7 = r8.keys     // Catch:{ CertificateEncodingException -> 0x034f }
            java.lang.Object r7 = r7.get(r5)     // Catch:{ CertificateEncodingException -> 0x034f }
            if (r7 == 0) goto L_0x0344
            goto L_0x0327
        L_0x0344:
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.SafeBag r5 = r8.createSafeBag(r5, r6)     // Catch:{ CertificateEncodingException -> 0x034f }
            r3.add(r5)     // Catch:{ CertificateEncodingException -> 0x034f }
            r1.put(r6, r6)     // Catch:{ CertificateEncodingException -> 0x034f }
            goto L_0x0327
        L_0x034f:
            r0 = move-exception
            java.io.IOException r1 = new java.io.IOException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r2)
            java.lang.String r0 = r0.toString()
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            r1.<init>(r0)
            throw r1
        L_0x0369:
            java.util.Set r4 = r20.getUsedCertificateSet()
            java.util.Hashtable r5 = r8.chainCerts
            java.util.Enumeration r5 = r5.keys()
        L_0x0373:
            boolean r6 = r5.hasMoreElements()
            if (r6 == 0) goto L_0x041e
            java.lang.Object r6 = r5.nextElement()     // Catch:{ CertificateEncodingException -> 0x03ea }
            com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.keystore.pkcs12.PKCS12KeyStoreSpi$CertId r6 = (com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.keystore.pkcs12.PKCS12KeyStoreSpi.CertId) r6     // Catch:{ CertificateEncodingException -> 0x03ea }
            java.util.Hashtable r7 = r8.chainCerts     // Catch:{ CertificateEncodingException -> 0x03ea }
            java.lang.Object r6 = r7.get(r6)     // Catch:{ CertificateEncodingException -> 0x03ea }
            java.security.cert.Certificate r6 = (java.security.cert.Certificate) r6     // Catch:{ CertificateEncodingException -> 0x03ea }
            boolean r7 = r4.contains(r6)     // Catch:{ CertificateEncodingException -> 0x03ea }
            if (r7 != 0) goto L_0x038e
            goto L_0x0373
        L_0x038e:
            java.lang.Object r7 = r1.get(r6)     // Catch:{ CertificateEncodingException -> 0x03ea }
            if (r7 == 0) goto L_0x0395
            goto L_0x0373
        L_0x0395:
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.CertBag r7 = new com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.CertBag     // Catch:{ CertificateEncodingException -> 0x03ea }
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier r9 = com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers.x509Certificate     // Catch:{ CertificateEncodingException -> 0x03ea }
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DEROctetString r12 = new com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DEROctetString     // Catch:{ CertificateEncodingException -> 0x03ea }
            byte[] r14 = r6.getEncoded()     // Catch:{ CertificateEncodingException -> 0x03ea }
            r12.<init>((byte[]) r14)     // Catch:{ CertificateEncodingException -> 0x03ea }
            r7.<init>(r9, r12)     // Catch:{ CertificateEncodingException -> 0x03ea }
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1EncodableVector r9 = new com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1EncodableVector     // Catch:{ CertificateEncodingException -> 0x03ea }
            r9.<init>()     // Catch:{ CertificateEncodingException -> 0x03ea }
            boolean r12 = r6 instanceof com.fis.ekyc.nfc.build_in.bouncycastle.jce.interfaces.PKCS12BagAttributeCarrier     // Catch:{ CertificateEncodingException -> 0x03ea }
            if (r12 == 0) goto L_0x03ec
            com.fis.ekyc.nfc.build_in.bouncycastle.jce.interfaces.PKCS12BagAttributeCarrier r6 = (com.fis.ekyc.nfc.build_in.bouncycastle.jce.interfaces.PKCS12BagAttributeCarrier) r6     // Catch:{ CertificateEncodingException -> 0x03ea }
            java.util.Enumeration r12 = r6.getBagAttributeKeys()     // Catch:{ CertificateEncodingException -> 0x03ea }
        L_0x03b4:
            boolean r14 = r12.hasMoreElements()     // Catch:{ CertificateEncodingException -> 0x03ea }
            if (r14 == 0) goto L_0x03ec
            java.lang.Object r14 = r12.nextElement()     // Catch:{ CertificateEncodingException -> 0x03ea }
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier r14 = (com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier) r14     // Catch:{ CertificateEncodingException -> 0x03ea }
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier r15 = com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers.pkcs_9_at_localKeyId     // Catch:{ CertificateEncodingException -> 0x03ea }
            boolean r15 = r14.equals((com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive) r15)     // Catch:{ CertificateEncodingException -> 0x03ea }
            if (r15 == 0) goto L_0x03c9
            goto L_0x03b4
        L_0x03c9:
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1EncodableVector r15 = new com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1EncodableVector     // Catch:{ CertificateEncodingException -> 0x03ea }
            r15.<init>()     // Catch:{ CertificateEncodingException -> 0x03ea }
            r15.add(r14)     // Catch:{ CertificateEncodingException -> 0x03ea }
            r16 = r1
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERSet r1 = new com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERSet     // Catch:{ CertificateEncodingException -> 0x03ea }
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Encodable r14 = r6.getBagAttribute(r14)     // Catch:{ CertificateEncodingException -> 0x03ea }
            r1.<init>((com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Encodable) r14)     // Catch:{ CertificateEncodingException -> 0x03ea }
            r15.add(r1)     // Catch:{ CertificateEncodingException -> 0x03ea }
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERSequence r1 = new com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERSequence     // Catch:{ CertificateEncodingException -> 0x03ea }
            r1.<init>((com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1EncodableVector) r15)     // Catch:{ CertificateEncodingException -> 0x03ea }
            r9.add(r1)     // Catch:{ CertificateEncodingException -> 0x03ea }
            r1 = r16
            goto L_0x03b4
        L_0x03ea:
            r0 = move-exception
            goto L_0x0405
        L_0x03ec:
            r16 = r1
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.SafeBag r1 = new com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.SafeBag     // Catch:{ CertificateEncodingException -> 0x03ea }
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier r6 = com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers.certBag     // Catch:{ CertificateEncodingException -> 0x03ea }
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive r7 = r7.toASN1Primitive()     // Catch:{ CertificateEncodingException -> 0x03ea }
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERSet r12 = new com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERSet     // Catch:{ CertificateEncodingException -> 0x03ea }
            r12.<init>((com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1EncodableVector) r9)     // Catch:{ CertificateEncodingException -> 0x03ea }
            r1.<init>(r6, r7, r12)     // Catch:{ CertificateEncodingException -> 0x03ea }
            r3.add(r1)     // Catch:{ CertificateEncodingException -> 0x03ea }
            r1 = r16
            goto L_0x0373
        L_0x0405:
            java.io.IOException r1 = new java.io.IOException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r2)
            java.lang.String r0 = r0.toString()
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            r1.<init>(r0)
            throw r1
        L_0x041e:
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERSequence r1 = new com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERSequence
            r1.<init>((com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1EncodableVector) r3)
            byte[] r6 = r1.getEncoded(r10)
            r2 = 1
            r5 = 0
            r1 = r20
            r3 = r11
            r4 = r22
            byte[] r1 = r1.cryptData(r2, r3, r4, r5, r6)
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.EncryptedData r2 = new com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.EncryptedData
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier r3 = com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers.data
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.BEROctetString r4 = new com.fis.ekyc.nfc.build_in.bouncycastle.asn1.BEROctetString
            r4.<init>((byte[]) r1)
            r2.<init>(r3, r11, r4)
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.ContentInfo r1 = new com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.ContentInfo
            r1.<init>(r3, r13)
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.ContentInfo r4 = new com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.ContentInfo
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier r5 = com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers.encryptedData
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive r2 = r2.toASN1Primitive()
            r4.<init>(r5, r2)
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.ContentInfo[] r1 = new com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.ContentInfo[]{r1, r4}
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.AuthenticatedSafe r2 = new com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.AuthenticatedSafe
            r2.<init>((com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.ContentInfo[]) r1)
            if (r23 == 0) goto L_0x045b
            r1 = r10
            goto L_0x045d
        L_0x045b:
            r1 = r19
        L_0x045d:
            byte[] r1 = r2.getEncoded(r1)
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.ContentInfo r9 = new com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.ContentInfo
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.BEROctetString r2 = new com.fis.ekyc.nfc.build_in.bouncycastle.asn1.BEROctetString
            r2.<init>((byte[]) r1)
            r9.<init>(r3, r2)
            int r1 = r8.saltLength
            byte[] r11 = new byte[r1]
            java.security.SecureRandom r1 = r8.random
            r1.nextBytes(r11)
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Encodable r1 = r9.getContent()
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1OctetString r1 = (com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1OctetString) r1
            byte[] r7 = r1.getOctets()
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.AlgorithmIdentifier r1 = r8.macAlgorithm     // Catch:{ Exception -> 0x04ad }
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier r2 = r1.getAlgorithm()     // Catch:{ Exception -> 0x04ad }
            int r4 = r8.itCount     // Catch:{ Exception -> 0x04ad }
            r6 = 0
            r1 = r20
            r3 = r11
            r5 = r22
            byte[] r1 = r1.calculatePbeMac(r2, r3, r4, r5, r6, r7)     // Catch:{ Exception -> 0x04ad }
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.DigestInfo r2 = new com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.DigestInfo     // Catch:{ Exception -> 0x04ad }
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.AlgorithmIdentifier r3 = r8.macAlgorithm     // Catch:{ Exception -> 0x04ad }
            r2.<init>(r3, r1)     // Catch:{ Exception -> 0x04ad }
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.MacData r1 = new com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.MacData     // Catch:{ Exception -> 0x04ad }
            int r3 = r8.itCount     // Catch:{ Exception -> 0x04ad }
            r1.<init>(r2, r11, r3)     // Catch:{ Exception -> 0x04ad }
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.Pfx r2 = new com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.Pfx
            r2.<init>(r9, r1)
            if (r23 == 0) goto L_0x04a7
            r9 = r10
            goto L_0x04a9
        L_0x04a7:
            r9 = r19
        L_0x04a9:
            r2.encodeTo(r0, r9)
            return
        L_0x04ad:
            r0 = move-exception
            java.io.IOException r1 = new java.io.IOException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "error constructing MAC: "
            r2.append(r3)
            java.lang.String r0 = r0.toString()
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            throw r1
        L_0x04c9:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "no password supplied for PKCS#12 KeyStore"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.keystore.pkcs12.PKCS12KeyStoreSpi.doStore(java.io.OutputStream, char[], boolean):void");
    }

    private static byte[] getDigest(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        Digest createSHA1 = DigestFactory.createSHA1();
        byte[] bArr = new byte[createSHA1.getDigestSize()];
        byte[] bytes = subjectPublicKeyInfo.getPublicKeyData().getBytes();
        createSHA1.update(bytes, 0, bytes.length);
        createSHA1.doFinal(bArr, 0);
        return bArr;
    }

    private Set getUsedCertificateSet() {
        HashSet hashSet = new HashSet();
        Enumeration keys2 = this.keys.keys();
        while (keys2.hasMoreElements()) {
            Certificate[] engineGetCertificateChain = engineGetCertificateChain((String) keys2.nextElement());
            for (int i = 0; i != engineGetCertificateChain.length; i++) {
                hashSet.add(engineGetCertificateChain[i]);
            }
        }
        Enumeration keys3 = this.certs.keys();
        while (keys3.hasMoreElements()) {
            hashSet.add(engineGetCertificate((String) keys3.nextElement()));
        }
        return hashSet;
    }

    private int validateIterationCount(BigInteger bigInteger) {
        int intValue = bigInteger.intValue();
        if (intValue >= 0) {
            BigInteger asBigInteger = Properties.asBigInteger(PKCS12_MAX_IT_COUNT_PROPERTY);
            if (asBigInteger == null || asBigInteger.intValue() >= intValue) {
                return intValue;
            }
            throw new IllegalStateException("iteration count " + intValue + " greater than " + asBigInteger.intValue());
        }
        throw new IllegalStateException("negative iteration count found");
    }

    public byte[] cryptData(boolean z, AlgorithmIdentifier algorithmIdentifier, char[] cArr, boolean z2, byte[] bArr) throws IOException {
        int i;
        ASN1ObjectIdentifier algorithm = algorithmIdentifier.getAlgorithm();
        if (z) {
            i = 1;
        } else {
            i = 2;
        }
        if (algorithm.on(PKCSObjectIdentifiers.pkcs_12PbeIds)) {
            PKCS12PBEParams instance = PKCS12PBEParams.getInstance(algorithmIdentifier.getParameters());
            try {
                PBEParameterSpec pBEParameterSpec = new PBEParameterSpec(instance.getIV(), instance.getIterations().intValue());
                PKCS12Key pKCS12Key = new PKCS12Key(cArr, z2);
                Cipher createCipher = this.helper.createCipher(algorithm.getId());
                createCipher.init(i, pKCS12Key, pBEParameterSpec);
                return createCipher.doFinal(bArr);
            } catch (Exception e) {
                throw new IOException("exception decrypting data - " + e.toString());
            }
        } else if (algorithm.equals((ASN1Primitive) PKCSObjectIdentifiers.id_PBES2)) {
            try {
                return createCipher(i, cArr, algorithmIdentifier).doFinal(bArr);
            } catch (Exception e2) {
                throw new IOException("exception decrypting data - " + e2.toString());
            }
        } else {
            throw new IOException("unknown PBE algorithm: " + algorithm);
        }
    }

    public Enumeration engineAliases() {
        Hashtable hashtable = new Hashtable();
        Enumeration keys2 = this.certs.keys();
        while (keys2.hasMoreElements()) {
            hashtable.put(keys2.nextElement(), "cert");
        }
        Enumeration keys3 = this.keys.keys();
        while (keys3.hasMoreElements()) {
            String str = (String) keys3.nextElement();
            if (hashtable.get(str) == null) {
                hashtable.put(str, "key");
            }
        }
        return hashtable.keys();
    }

    public boolean engineContainsAlias(String str) {
        if (this.certs.get(str) == null && this.keys.get(str) == null) {
            return false;
        }
        return true;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: java.security.cert.Certificate} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void engineDeleteEntry(java.lang.String r6) throws java.security.KeyStoreException {
        /*
            r5 = this;
            com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.keystore.pkcs12.PKCS12KeyStoreSpi$IgnoresCaseHashtable r0 = r5.keys
            java.lang.Object r0 = r0.remove(r6)
            java.security.Key r0 = (java.security.Key) r0
            com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.keystore.pkcs12.PKCS12KeyStoreSpi$IgnoresCaseHashtable r1 = r5.certs
            java.lang.Object r1 = r1.remove(r6)
            java.security.cert.Certificate r1 = (java.security.cert.Certificate) r1
            if (r1 == 0) goto L_0x0020
            java.util.Hashtable r2 = r5.chainCerts
            com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.keystore.pkcs12.PKCS12KeyStoreSpi$CertId r3 = new com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.keystore.pkcs12.PKCS12KeyStoreSpi$CertId
            java.security.PublicKey r4 = r1.getPublicKey()
            r3.<init>((java.security.PublicKey) r4)
            r2.remove(r3)
        L_0x0020:
            if (r0 == 0) goto L_0x0045
            java.util.Hashtable r0 = r5.localIds
            java.lang.Object r6 = r0.remove(r6)
            java.lang.String r6 = (java.lang.String) r6
            if (r6 == 0) goto L_0x0035
            java.util.Hashtable r0 = r5.keyCerts
            java.lang.Object r6 = r0.remove(r6)
            r1 = r6
            java.security.cert.Certificate r1 = (java.security.cert.Certificate) r1
        L_0x0035:
            if (r1 == 0) goto L_0x0045
            java.util.Hashtable r6 = r5.chainCerts
            com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.keystore.pkcs12.PKCS12KeyStoreSpi$CertId r0 = new com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.keystore.pkcs12.PKCS12KeyStoreSpi$CertId
            java.security.PublicKey r1 = r1.getPublicKey()
            r0.<init>((java.security.PublicKey) r1)
            r6.remove(r0)
        L_0x0045:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.keystore.pkcs12.PKCS12KeyStoreSpi.engineDeleteEntry(java.lang.String):void");
    }

    public Certificate engineGetCertificate(String str) {
        if (str != null) {
            Certificate certificate = (Certificate) this.certs.get(str);
            if (certificate != null) {
                return certificate;
            }
            String str2 = (String) this.localIds.get(str);
            if (str2 != null) {
                return (Certificate) this.keyCerts.get(str2);
            }
            return (Certificate) this.keyCerts.get(str);
        }
        throw new IllegalArgumentException("null alias passed to getCertificate.");
    }

    public String engineGetCertificateAlias(Certificate certificate) {
        Enumeration elements = this.certs.elements();
        Enumeration keys2 = this.certs.keys();
        while (elements.hasMoreElements()) {
            String str = (String) keys2.nextElement();
            if (((Certificate) elements.nextElement()).equals(certificate)) {
                return str;
            }
        }
        Enumeration elements2 = this.keyCerts.elements();
        Enumeration keys3 = this.keyCerts.keys();
        while (elements2.hasMoreElements()) {
            String str2 = (String) keys3.nextElement();
            if (((Certificate) elements2.nextElement()).equals(certificate)) {
                return str2;
            }
        }
        return null;
    }

    public Certificate[] engineGetCertificateChain(String str) {
        X509Certificate x509Certificate;
        byte[] keyIdentifier;
        if (str != null) {
            Certificate[] certificateArr = null;
            if (!engineIsKeyEntry(str)) {
                return null;
            }
            Certificate engineGetCertificate = engineGetCertificate(str);
            if (engineGetCertificate != null) {
                Vector vector = new Vector();
                while (engineGetCertificate != null) {
                    X509Certificate x509Certificate2 = (X509Certificate) engineGetCertificate;
                    byte[] extensionValue = x509Certificate2.getExtensionValue(Extension.authorityKeyIdentifier.getId());
                    if (extensionValue == null || (keyIdentifier = AuthorityKeyIdentifier.getInstance(ASN1OctetString.getInstance(extensionValue).getOctets()).getKeyIdentifier()) == null) {
                        x509Certificate = null;
                    } else {
                        x509Certificate = (Certificate) this.chainCerts.get(new CertId(keyIdentifier));
                    }
                    if (x509Certificate == null) {
                        Principal issuerDN = x509Certificate2.getIssuerDN();
                        if (!issuerDN.equals(x509Certificate2.getSubjectDN())) {
                            Enumeration keys2 = this.chainCerts.keys();
                            while (true) {
                                if (!keys2.hasMoreElements()) {
                                    break;
                                }
                                X509Certificate x509Certificate3 = (X509Certificate) this.chainCerts.get(keys2.nextElement());
                                if (x509Certificate3.getSubjectDN().equals(issuerDN)) {
                                    try {
                                        x509Certificate2.verify(x509Certificate3.getPublicKey());
                                        x509Certificate = x509Certificate3;
                                        break;
                                    } catch (Exception unused) {
                                        continue;
                                    }
                                }
                            }
                        }
                    }
                    if (!vector.contains(engineGetCertificate)) {
                        vector.addElement(engineGetCertificate);
                        if (x509Certificate != engineGetCertificate) {
                            engineGetCertificate = x509Certificate;
                        }
                    }
                    engineGetCertificate = null;
                }
                int size = vector.size();
                certificateArr = new Certificate[size];
                for (int i = 0; i != size; i++) {
                    certificateArr[i] = (Certificate) vector.elementAt(i);
                }
            }
            return certificateArr;
        }
        throw new IllegalArgumentException("null alias passed to getCertificateChain.");
    }

    public Date engineGetCreationDate(String str) {
        if (str == null) {
            throw new NullPointerException("alias == null");
        } else if (this.keys.get(str) == null && this.certs.get(str) == null) {
            return null;
        } else {
            return new Date();
        }
    }

    public Key engineGetKey(String str, char[] cArr) throws NoSuchAlgorithmException, UnrecoverableKeyException {
        if (str != null) {
            return (Key) this.keys.get(str);
        }
        throw new IllegalArgumentException("null alias passed to getKey.");
    }

    public boolean engineIsCertificateEntry(String str) {
        if (this.certs.get(str) == null || this.keys.get(str) != null) {
            return false;
        }
        return true;
    }

    public boolean engineIsKeyEntry(String str) {
        if (this.keys.get(str) != null) {
            return true;
        }
        return false;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v7, resolved type: com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v9, resolved type: com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1OctetString} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v16, resolved type: com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v30, resolved type: com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1OctetString} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v15, resolved type: com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v30, resolved type: com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v35, resolved type: com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1OctetString} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v36, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v40, resolved type: com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1OctetString} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v41, resolved type: com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1OctetString} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v43, resolved type: com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1OctetString} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x048e  */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x04ad  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x010d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void engineLoad(java.io.InputStream r23, char[] r24) throws java.io.IOException {
        /*
            r22 = this;
            r8 = r22
            r0 = r23
            r9 = r24
            if (r0 != 0) goto L_0x0009
            return
        L_0x0009:
            java.io.BufferedInputStream r1 = new java.io.BufferedInputStream
            r1.<init>(r0)
            r0 = 10
            r1.mark(r0)
            int r0 = r1.read()
            r2 = 48
            if (r0 != r2) goto L_0x05e8
            r1.reset()
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1InputStream r0 = new com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1InputStream
            r0.<init>((java.io.InputStream) r1)
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive r0 = r0.readObject()     // Catch:{ Exception -> 0x05dd }
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.Pfx r0 = com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.Pfx.getInstance(r0)     // Catch:{ Exception -> 0x05dd }
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.ContentInfo r10 = r0.getAuthSafe()
            java.util.Vector r11 = new java.util.Vector
            r11.<init>()
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.MacData r1 = r0.getMacData()
            r12 = 1
            r13 = 0
            if (r1 == 0) goto L_0x00da
            if (r9 == 0) goto L_0x00d2
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.MacData r0 = r0.getMacData()
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.DigestInfo r14 = r0.getMac()
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.AlgorithmIdentifier r1 = r14.getAlgorithmId()
            r8.macAlgorithm = r1
            byte[] r15 = r0.getSalt()
            java.math.BigInteger r0 = r0.getIterationCount()
            int r0 = r8.validateIterationCount(r0)
            r8.itCount = r0
            int r0 = r15.length
            r8.saltLength = r0
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Encodable r0 = r10.getContent()
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1OctetString r0 = (com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1OctetString) r0
            byte[] r0 = r0.getOctets()
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.AlgorithmIdentifier r1 = r8.macAlgorithm     // Catch:{ IOException -> 0x00ad, Exception -> 0x00ab }
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier r2 = r1.getAlgorithm()     // Catch:{ IOException -> 0x00ad, Exception -> 0x00ab }
            int r4 = r8.itCount     // Catch:{ IOException -> 0x00ad, Exception -> 0x00ab }
            r6 = 0
            r1 = r22
            r3 = r15
            r5 = r24
            r7 = r0
            byte[] r1 = r1.calculatePbeMac(r2, r3, r4, r5, r6, r7)     // Catch:{ IOException -> 0x00ad, Exception -> 0x00ab }
            byte[] r14 = r14.getDigest()     // Catch:{ IOException -> 0x00ad, Exception -> 0x00ab }
            boolean r1 = com.fis.ekyc.nfc.build_in.bouncycastle.util.Arrays.constantTimeAreEqual(r1, r14)     // Catch:{ IOException -> 0x00ad, Exception -> 0x00ab }
            if (r1 != 0) goto L_0x00ed
            int r1 = r9.length     // Catch:{ IOException -> 0x00ad, Exception -> 0x00ab }
            java.lang.String r7 = "PKCS12 key store mac invalid - wrong password or corrupted file."
            if (r1 > 0) goto L_0x00af
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.AlgorithmIdentifier r1 = r8.macAlgorithm     // Catch:{ IOException -> 0x00ad, Exception -> 0x00ab }
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier r2 = r1.getAlgorithm()     // Catch:{ IOException -> 0x00ad, Exception -> 0x00ab }
            int r4 = r8.itCount     // Catch:{ IOException -> 0x00ad, Exception -> 0x00ab }
            r6 = 1
            r1 = r22
            r3 = r15
            r5 = r24
            r15 = r7
            r7 = r0
            byte[] r0 = r1.calculatePbeMac(r2, r3, r4, r5, r6, r7)     // Catch:{ IOException -> 0x00ad, Exception -> 0x00ab }
            boolean r0 = com.fis.ekyc.nfc.build_in.bouncycastle.util.Arrays.constantTimeAreEqual(r0, r14)     // Catch:{ IOException -> 0x00ad, Exception -> 0x00ab }
            if (r0 == 0) goto L_0x00a5
            r0 = r12
            goto L_0x00ee
        L_0x00a5:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ IOException -> 0x00ad, Exception -> 0x00ab }
            r0.<init>(r15)     // Catch:{ IOException -> 0x00ad, Exception -> 0x00ab }
            throw r0     // Catch:{ IOException -> 0x00ad, Exception -> 0x00ab }
        L_0x00ab:
            r0 = move-exception
            goto L_0x00b6
        L_0x00ad:
            r0 = move-exception
            goto L_0x00d1
        L_0x00af:
            r15 = r7
            java.io.IOException r0 = new java.io.IOException     // Catch:{ IOException -> 0x00ad, Exception -> 0x00ab }
            r0.<init>(r15)     // Catch:{ IOException -> 0x00ad, Exception -> 0x00ab }
            throw r0     // Catch:{ IOException -> 0x00ad, Exception -> 0x00ab }
        L_0x00b6:
            java.io.IOException r1 = new java.io.IOException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "error constructing MAC: "
            r2.append(r3)
            java.lang.String r0 = r0.toString()
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            throw r1
        L_0x00d1:
            throw r0
        L_0x00d2:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "no password supplied when one expected"
            r0.<init>(r1)
            throw r0
        L_0x00da:
            if (r9 == 0) goto L_0x00ed
            java.lang.String r0 = "com.fis.ekyc.nfc.build_in.bouncycastle.pkcs12.ignore_useless_passwd"
            boolean r0 = com.fis.ekyc.nfc.build_in.bouncycastle.util.Properties.isOverrideSet(r0)
            if (r0 == 0) goto L_0x00e5
            goto L_0x00ed
        L_0x00e5:
            java.io.IOException r0 = new java.io.IOException
            java.lang.String r1 = "password supplied for keystore that does not require one"
            r0.<init>(r1)
            throw r0
        L_0x00ed:
            r0 = r13
        L_0x00ee:
            com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.keystore.pkcs12.PKCS12KeyStoreSpi$IgnoresCaseHashtable r1 = new com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.keystore.pkcs12.PKCS12KeyStoreSpi$IgnoresCaseHashtable
            r7 = 0
            r1.<init>()
            r8.keys = r1
            java.util.Hashtable r1 = new java.util.Hashtable
            r1.<init>()
            r8.localIds = r1
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier r1 = r10.getContentType()
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier r2 = com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers.data
            boolean r1 = r1.equals((com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive) r2)
            java.lang.String r14 = "unmarked"
            java.lang.String r15 = "attempt to add existing attribute with different value"
            if (r1 == 0) goto L_0x048e
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Encodable r1 = r10.getContent()
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1OctetString r1 = com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1OctetString.getInstance(r1)
            byte[] r1 = r1.getOctets()
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.AuthenticatedSafe r1 = com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.AuthenticatedSafe.getInstance(r1)
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.ContentInfo[] r10 = r1.getContentInfo()
            r6 = r13
            r16 = r6
        L_0x0124:
            int r1 = r10.length
            if (r6 == r1) goto L_0x0490
            r1 = r10[r6]
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier r1 = r1.getContentType()
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier r2 = com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers.data
            boolean r1 = r1.equals((com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive) r2)
            if (r1 == 0) goto L_0x025c
            r1 = r10[r6]
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Encodable r1 = r1.getContent()
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1OctetString r1 = com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1OctetString.getInstance(r1)
            byte[] r1 = r1.getOctets()
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Sequence r1 = com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Sequence.getInstance(r1)
            r2 = r13
        L_0x0148:
            int r3 = r1.size()
            if (r2 == r3) goto L_0x0257
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Encodable r3 = r1.getObjectAt(r2)
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.SafeBag r3 = com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.SafeBag.getInstance(r3)
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier r4 = r3.getBagId()
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier r5 = com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers.pkcs8ShroudedKeyBag
            boolean r4 = r4.equals((com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive) r5)
            if (r4 == 0) goto L_0x021f
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Encodable r4 = r3.getBagValue()
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.EncryptedPrivateKeyInfo r4 = com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.EncryptedPrivateKeyInfo.getInstance(r4)
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.AlgorithmIdentifier r5 = r4.getEncryptionAlgorithm()
            byte[] r4 = r4.getEncryptedData()
            java.security.PrivateKey r4 = r8.unwrapKey(r5, r4, r9, r0)
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Set r5 = r3.getBagAttributes()
            if (r5 == 0) goto L_0x01f7
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Set r3 = r3.getBagAttributes()
            java.util.Enumeration r3 = r3.getObjects()
            r5 = r7
            r17 = r5
        L_0x0187:
            boolean r18 = r3.hasMoreElements()
            if (r18 == 0) goto L_0x01fa
            java.lang.Object r18 = r3.nextElement()
            r7 = r18
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Sequence r7 = (com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Sequence) r7
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Encodable r18 = r7.getObjectAt(r13)
            r13 = r18
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier r13 = (com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier) r13
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Encodable r7 = r7.getObjectAt(r12)
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Set r7 = (com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Set) r7
            int r18 = r7.size()
            if (r18 <= 0) goto L_0x01d2
            r12 = 0
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Encodable r7 = r7.getObjectAt(r12)
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive r7 = (com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive) r7
            boolean r12 = r4 instanceof com.fis.ekyc.nfc.build_in.bouncycastle.jce.interfaces.PKCS12BagAttributeCarrier
            if (r12 == 0) goto L_0x01d3
            r12 = r4
            com.fis.ekyc.nfc.build_in.bouncycastle.jce.interfaces.PKCS12BagAttributeCarrier r12 = (com.fis.ekyc.nfc.build_in.bouncycastle.jce.interfaces.PKCS12BagAttributeCarrier) r12
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Encodable r20 = r12.getBagAttribute(r13)
            if (r20 == 0) goto L_0x01ce
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive r12 = r20.toASN1Primitive()
            boolean r12 = r12.equals((com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive) r7)
            if (r12 == 0) goto L_0x01c8
            goto L_0x01d3
        L_0x01c8:
            java.io.IOException r0 = new java.io.IOException
            r0.<init>(r15)
            throw r0
        L_0x01ce:
            r12.setBagAttribute(r13, r7)
            goto L_0x01d3
        L_0x01d2:
            r7 = 0
        L_0x01d3:
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier r12 = com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers.pkcs_9_at_friendlyName
            boolean r12 = r13.equals((com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive) r12)
            if (r12 == 0) goto L_0x01e7
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERBMPString r7 = (com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERBMPString) r7
            java.lang.String r5 = r7.getString()
            com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.keystore.pkcs12.PKCS12KeyStoreSpi$IgnoresCaseHashtable r7 = r8.keys
            r7.put(r5, r4)
            goto L_0x01f3
        L_0x01e7:
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier r12 = com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers.pkcs_9_at_localKeyId
            boolean r12 = r13.equals((com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive) r12)
            if (r12 == 0) goto L_0x01f3
            r17 = r7
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1OctetString r17 = (com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1OctetString) r17
        L_0x01f3:
            r7 = 0
            r12 = 1
            r13 = 0
            goto L_0x0187
        L_0x01f7:
            r5 = 0
            r17 = 0
        L_0x01fa:
            if (r17 == 0) goto L_0x0217
            java.lang.String r3 = new java.lang.String
            byte[] r7 = r17.getOctets()
            byte[] r7 = com.fis.ekyc.nfc.build_in.bouncycastle.util.encoders.Hex.encode(r7)
            r3.<init>(r7)
            if (r5 != 0) goto L_0x0211
            com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.keystore.pkcs12.PKCS12KeyStoreSpi$IgnoresCaseHashtable r5 = r8.keys
            r5.put(r3, r4)
            goto L_0x0250
        L_0x0211:
            java.util.Hashtable r4 = r8.localIds
            r4.put(r5, r3)
            goto L_0x0250
        L_0x0217:
            com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.keystore.pkcs12.PKCS12KeyStoreSpi$IgnoresCaseHashtable r3 = r8.keys
            r3.put(r14, r4)
            r16 = 1
            goto L_0x0250
        L_0x021f:
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier r4 = r3.getBagId()
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier r5 = com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers.certBag
            boolean r4 = r4.equals((com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive) r5)
            if (r4 == 0) goto L_0x022f
            r11.addElement(r3)
            goto L_0x0250
        L_0x022f:
            java.io.PrintStream r4 = java.lang.System.out
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r7 = "extra in data "
            r5.append(r7)
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier r7 = r3.getBagId()
            r5.append(r7)
            java.lang.String r5 = r5.toString()
            r4.println(r5)
            java.lang.String r3 = com.fis.ekyc.nfc.build_in.bouncycastle.asn1.util.ASN1Dump.dumpAsString(r3)
            r4.println(r3)
        L_0x0250:
            int r2 = r2 + 1
            r7 = 0
            r12 = 1
            r13 = 0
            goto L_0x0148
        L_0x0257:
            r17 = r0
            r13 = r6
            goto L_0x0485
        L_0x025c:
            r1 = r10[r6]
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier r1 = r1.getContentType()
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier r2 = com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers.encryptedData
            boolean r1 = r1.equals((com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive) r2)
            if (r1 == 0) goto L_0x0446
            r1 = r10[r6]
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Encodable r1 = r1.getContent()
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.EncryptedData r1 = com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.EncryptedData.getInstance(r1)
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.AlgorithmIdentifier r3 = r1.getEncryptionAlgorithm()
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1OctetString r1 = r1.getContent()
            byte[] r7 = r1.getOctets()
            r2 = 0
            r1 = r22
            r4 = r24
            r5 = r0
            r13 = r6
            r6 = r7
            byte[] r1 = r1.cryptData(r2, r3, r4, r5, r6)
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Sequence r1 = com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Sequence.getInstance(r1)
            r12 = 0
        L_0x0291:
            int r2 = r1.size()
            if (r12 == r2) goto L_0x0443
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Encodable r2 = r1.getObjectAt(r12)
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.SafeBag r2 = com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.SafeBag.getInstance(r2)
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier r3 = r2.getBagId()
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier r4 = com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers.certBag
            boolean r3 = r3.equals((com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive) r4)
            if (r3 == 0) goto L_0x02b4
            r11.addElement(r2)
            r17 = r0
            r21 = r1
            goto L_0x043b
        L_0x02b4:
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier r3 = r2.getBagId()
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier r4 = com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers.pkcs8ShroudedKeyBag
            boolean r3 = r3.equals((com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive) r4)
            if (r3 == 0) goto L_0x036f
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Encodable r3 = r2.getBagValue()
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.EncryptedPrivateKeyInfo r3 = com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.EncryptedPrivateKeyInfo.getInstance(r3)
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.AlgorithmIdentifier r4 = r3.getEncryptionAlgorithm()
            byte[] r3 = r3.getEncryptedData()
            java.security.PrivateKey r3 = r8.unwrapKey(r4, r3, r9, r0)
            r4 = r3
            com.fis.ekyc.nfc.build_in.bouncycastle.jce.interfaces.PKCS12BagAttributeCarrier r4 = (com.fis.ekyc.nfc.build_in.bouncycastle.jce.interfaces.PKCS12BagAttributeCarrier) r4
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Set r2 = r2.getBagAttributes()
            java.util.Enumeration r2 = r2.getObjects()
            r5 = 0
            r6 = 0
        L_0x02e1:
            boolean r7 = r2.hasMoreElements()
            if (r7 == 0) goto L_0x034e
            java.lang.Object r7 = r2.nextElement()
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Sequence r7 = (com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Sequence) r7
            r17 = r0
            r0 = 0
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Encodable r19 = r7.getObjectAt(r0)
            r0 = r19
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier r0 = (com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier) r0
            r21 = r1
            r1 = 1
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Encodable r7 = r7.getObjectAt(r1)
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Set r7 = (com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Set) r7
            int r1 = r7.size()
            if (r1 <= 0) goto L_0x0329
            r1 = 0
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Encodable r7 = r7.getObjectAt(r1)
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive r7 = (com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive) r7
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Encodable r1 = r4.getBagAttribute(r0)
            if (r1 == 0) goto L_0x0325
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive r1 = r1.toASN1Primitive()
            boolean r1 = r1.equals((com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive) r7)
            if (r1 == 0) goto L_0x031f
            goto L_0x032a
        L_0x031f:
            java.io.IOException r0 = new java.io.IOException
            r0.<init>(r15)
            throw r0
        L_0x0325:
            r4.setBagAttribute(r0, r7)
            goto L_0x032a
        L_0x0329:
            r7 = 0
        L_0x032a:
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier r1 = com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers.pkcs_9_at_friendlyName
            boolean r1 = r0.equals((com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive) r1)
            if (r1 == 0) goto L_0x033e
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERBMPString r7 = (com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERBMPString) r7
            java.lang.String r6 = r7.getString()
            com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.keystore.pkcs12.PKCS12KeyStoreSpi$IgnoresCaseHashtable r0 = r8.keys
            r0.put(r6, r3)
            goto L_0x0349
        L_0x033e:
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier r1 = com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers.pkcs_9_at_localKeyId
            boolean r0 = r0.equals((com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive) r1)
            if (r0 == 0) goto L_0x0349
            r5 = r7
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1OctetString r5 = (com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1OctetString) r5
        L_0x0349:
            r0 = r17
            r1 = r21
            goto L_0x02e1
        L_0x034e:
            r17 = r0
            r21 = r1
            java.lang.String r0 = new java.lang.String
            byte[] r1 = r5.getOctets()
            byte[] r1 = com.fis.ekyc.nfc.build_in.bouncycastle.util.encoders.Hex.encode(r1)
            r0.<init>(r1)
            if (r6 != 0) goto L_0x0368
            com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.keystore.pkcs12.PKCS12KeyStoreSpi$IgnoresCaseHashtable r1 = r8.keys
            r1.put(r0, r3)
            goto L_0x043b
        L_0x0368:
            java.util.Hashtable r1 = r8.localIds
            r1.put(r6, r0)
            goto L_0x043b
        L_0x036f:
            r17 = r0
            r21 = r1
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier r0 = r2.getBagId()
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier r1 = com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers.keyBag
            boolean r0 = r0.equals((com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive) r1)
            if (r0 == 0) goto L_0x041a
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Encodable r0 = r2.getBagValue()
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.PrivateKeyInfo r0 = com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.PrivateKeyInfo.getInstance(r0)
            java.security.PrivateKey r0 = com.fis.ekyc.nfc.build_in.bouncycastle.jce.provider.BouncyCastleProvider.getPrivateKey(r0)
            r1 = r0
            com.fis.ekyc.nfc.build_in.bouncycastle.jce.interfaces.PKCS12BagAttributeCarrier r1 = (com.fis.ekyc.nfc.build_in.bouncycastle.jce.interfaces.PKCS12BagAttributeCarrier) r1
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Set r2 = r2.getBagAttributes()
            java.util.Enumeration r2 = r2.getObjects()
            r3 = 0
            r4 = 0
        L_0x0398:
            boolean r5 = r2.hasMoreElements()
            if (r5 == 0) goto L_0x03ff
            java.lang.Object r5 = r2.nextElement()
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Sequence r5 = com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Sequence.getInstance(r5)
            r6 = 0
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Encodable r7 = r5.getObjectAt(r6)
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier r7 = com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier.getInstance(r7)
            r6 = 1
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Encodable r5 = r5.getObjectAt(r6)
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Set r5 = com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Set.getInstance(r5)
            int r6 = r5.size()
            if (r6 <= 0) goto L_0x0398
            r6 = 0
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Encodable r5 = r5.getObjectAt(r6)
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive r5 = (com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive) r5
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Encodable r6 = r1.getBagAttribute(r7)
            if (r6 == 0) goto L_0x03dc
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive r6 = r6.toASN1Primitive()
            boolean r6 = r6.equals((com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive) r5)
            if (r6 == 0) goto L_0x03d6
            goto L_0x03df
        L_0x03d6:
            java.io.IOException r0 = new java.io.IOException
            r0.<init>(r15)
            throw r0
        L_0x03dc:
            r1.setBagAttribute(r7, r5)
        L_0x03df:
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier r6 = com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers.pkcs_9_at_friendlyName
            boolean r6 = r7.equals((com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive) r6)
            if (r6 == 0) goto L_0x03f3
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERBMPString r5 = (com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERBMPString) r5
            java.lang.String r4 = r5.getString()
            com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.keystore.pkcs12.PKCS12KeyStoreSpi$IgnoresCaseHashtable r5 = r8.keys
            r5.put(r4, r0)
            goto L_0x0398
        L_0x03f3:
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier r6 = com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers.pkcs_9_at_localKeyId
            boolean r6 = r7.equals((com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive) r6)
            if (r6 == 0) goto L_0x0398
            r3 = r5
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1OctetString r3 = (com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1OctetString) r3
            goto L_0x0398
        L_0x03ff:
            java.lang.String r1 = new java.lang.String
            byte[] r2 = r3.getOctets()
            byte[] r2 = com.fis.ekyc.nfc.build_in.bouncycastle.util.encoders.Hex.encode(r2)
            r1.<init>(r2)
            if (r4 != 0) goto L_0x0414
            com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.keystore.pkcs12.PKCS12KeyStoreSpi$IgnoresCaseHashtable r2 = r8.keys
            r2.put(r1, r0)
            goto L_0x043b
        L_0x0414:
            java.util.Hashtable r0 = r8.localIds
            r0.put(r4, r1)
            goto L_0x043b
        L_0x041a:
            java.io.PrintStream r0 = java.lang.System.out
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "extra in encryptedData "
            r1.append(r3)
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier r3 = r2.getBagId()
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            r0.println(r1)
            java.lang.String r1 = com.fis.ekyc.nfc.build_in.bouncycastle.asn1.util.ASN1Dump.dumpAsString(r2)
            r0.println(r1)
        L_0x043b:
            int r12 = r12 + 1
            r0 = r17
            r1 = r21
            goto L_0x0291
        L_0x0443:
            r17 = r0
            goto L_0x0485
        L_0x0446:
            r17 = r0
            r13 = r6
            java.io.PrintStream r0 = java.lang.System.out
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "extra "
            r1.append(r2)
            r3 = r10[r13]
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier r3 = r3.getContentType()
            java.lang.String r3 = r3.getId()
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            r0.println(r1)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r2)
            r2 = r10[r13]
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Encodable r2 = r2.getContent()
            java.lang.String r2 = com.fis.ekyc.nfc.build_in.bouncycastle.asn1.util.ASN1Dump.dumpAsString(r2)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.println(r1)
        L_0x0485:
            int r6 = r13 + 1
            r0 = r17
            r7 = 0
            r12 = 1
            r13 = 0
            goto L_0x0124
        L_0x048e:
            r16 = 0
        L_0x0490:
            com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.keystore.pkcs12.PKCS12KeyStoreSpi$IgnoresCaseHashtable r0 = new com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.keystore.pkcs12.PKCS12KeyStoreSpi$IgnoresCaseHashtable
            r1 = 0
            r0.<init>()
            r8.certs = r0
            java.util.Hashtable r0 = new java.util.Hashtable
            r0.<init>()
            r8.chainCerts = r0
            java.util.Hashtable r0 = new java.util.Hashtable
            r0.<init>()
            r8.keyCerts = r0
            r12 = 0
        L_0x04a7:
            int r0 = r11.size()
            if (r12 == r0) goto L_0x05dc
            java.lang.Object r0 = r11.elementAt(r12)
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.SafeBag r0 = (com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.SafeBag) r0
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Encodable r2 = r0.getBagValue()
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.CertBag r2 = com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.CertBag.getInstance(r2)
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier r3 = r2.getCertId()
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier r4 = com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers.x509Certificate
            boolean r3 = r3.equals((com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive) r4)
            if (r3 == 0) goto L_0x05c1
            java.io.ByteArrayInputStream r3 = new java.io.ByteArrayInputStream     // Catch:{ Exception -> 0x05b6 }
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Encodable r2 = r2.getCertValue()     // Catch:{ Exception -> 0x05b6 }
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1OctetString r2 = (com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1OctetString) r2     // Catch:{ Exception -> 0x05b6 }
            byte[] r2 = r2.getOctets()     // Catch:{ Exception -> 0x05b6 }
            r3.<init>(r2)     // Catch:{ Exception -> 0x05b6 }
            java.security.cert.CertificateFactory r2 = r8.certFact     // Catch:{ Exception -> 0x05b6 }
            java.security.cert.Certificate r2 = r2.generateCertificate(r3)     // Catch:{ Exception -> 0x05b6 }
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Set r3 = r0.getBagAttributes()
            if (r3 == 0) goto L_0x0557
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Set r0 = r0.getBagAttributes()
            java.util.Enumeration r0 = r0.getObjects()
            r3 = r1
            r4 = r3
        L_0x04ec:
            boolean r5 = r0.hasMoreElements()
            if (r5 == 0) goto L_0x0554
            java.lang.Object r5 = r0.nextElement()
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Sequence r5 = com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Sequence.getInstance(r5)
            r6 = 0
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Encodable r7 = r5.getObjectAt(r6)
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier r7 = com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier.getInstance(r7)
            r9 = 1
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Encodable r5 = r5.getObjectAt(r9)
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Set r5 = com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Set.getInstance(r5)
            int r10 = r5.size()
            if (r10 <= 0) goto L_0x04ec
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Encodable r5 = r5.getObjectAt(r6)
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive r5 = (com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive) r5
            boolean r10 = r2 instanceof com.fis.ekyc.nfc.build_in.bouncycastle.jce.interfaces.PKCS12BagAttributeCarrier
            if (r10 == 0) goto L_0x0539
            r10 = r2
            com.fis.ekyc.nfc.build_in.bouncycastle.jce.interfaces.PKCS12BagAttributeCarrier r10 = (com.fis.ekyc.nfc.build_in.bouncycastle.jce.interfaces.PKCS12BagAttributeCarrier) r10
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Encodable r13 = r10.getBagAttribute(r7)
            if (r13 == 0) goto L_0x0536
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive r10 = r13.toASN1Primitive()
            boolean r10 = r10.equals((com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive) r5)
            if (r10 == 0) goto L_0x0530
            goto L_0x0539
        L_0x0530:
            java.io.IOException r0 = new java.io.IOException
            r0.<init>(r15)
            throw r0
        L_0x0536:
            r10.setBagAttribute(r7, r5)
        L_0x0539:
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier r10 = com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers.pkcs_9_at_friendlyName
            boolean r10 = r7.equals((com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive) r10)
            if (r10 == 0) goto L_0x0548
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERBMPString r5 = (com.fis.ekyc.nfc.build_in.bouncycastle.asn1.DERBMPString) r5
            java.lang.String r3 = r5.getString()
            goto L_0x04ec
        L_0x0548:
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier r10 = com.fis.ekyc.nfc.build_in.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers.pkcs_9_at_localKeyId
            boolean r7 = r7.equals((com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1Primitive) r10)
            if (r7 == 0) goto L_0x04ec
            r4 = r5
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1OctetString r4 = (com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1OctetString) r4
            goto L_0x04ec
        L_0x0554:
            r6 = 0
            r9 = 1
            goto L_0x055b
        L_0x0557:
            r6 = 0
            r9 = 1
            r3 = r1
            r4 = r3
        L_0x055b:
            java.util.Hashtable r0 = r8.chainCerts
            com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.keystore.pkcs12.PKCS12KeyStoreSpi$CertId r5 = new com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.keystore.pkcs12.PKCS12KeyStoreSpi$CertId
            java.security.PublicKey r7 = r2.getPublicKey()
            r5.<init>((java.security.PublicKey) r7)
            r0.put(r5, r2)
            if (r16 == 0) goto L_0x0597
            java.util.Hashtable r0 = r8.keyCerts
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x05b2
            java.lang.String r0 = new java.lang.String
            java.security.PublicKey r3 = r2.getPublicKey()
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.x509.SubjectKeyIdentifier r3 = r8.createSubjectKeyId(r3)
            byte[] r3 = r3.getKeyIdentifier()
            byte[] r3 = com.fis.ekyc.nfc.build_in.bouncycastle.util.encoders.Hex.encode(r3)
            r0.<init>(r3)
            java.util.Hashtable r3 = r8.keyCerts
            r3.put(r0, r2)
            com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.keystore.pkcs12.PKCS12KeyStoreSpi$IgnoresCaseHashtable r2 = r8.keys
            java.lang.Object r3 = r2.remove(r14)
            r2.put(r0, r3)
            goto L_0x05b2
        L_0x0597:
            if (r4 == 0) goto L_0x05ab
            java.lang.String r0 = new java.lang.String
            byte[] r4 = r4.getOctets()
            byte[] r4 = com.fis.ekyc.nfc.build_in.bouncycastle.util.encoders.Hex.encode(r4)
            r0.<init>(r4)
            java.util.Hashtable r4 = r8.keyCerts
            r4.put(r0, r2)
        L_0x05ab:
            if (r3 == 0) goto L_0x05b2
            com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.keystore.pkcs12.PKCS12KeyStoreSpi$IgnoresCaseHashtable r0 = r8.certs
            r0.put(r3, r2)
        L_0x05b2:
            int r12 = r12 + 1
            goto L_0x04a7
        L_0x05b6:
            r0 = move-exception
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            java.lang.String r0 = r0.toString()
            r1.<init>(r0)
            throw r1
        L_0x05c1:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "Unsupported certificate type: "
            r1.append(r3)
            com.fis.ekyc.nfc.build_in.bouncycastle.asn1.ASN1ObjectIdentifier r2 = r2.getCertId()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x05dc:
            return
        L_0x05dd:
            r0 = move-exception
            java.io.IOException r1 = new java.io.IOException
            java.lang.String r0 = r0.getMessage()
            r1.<init>(r0)
            throw r1
        L_0x05e8:
            java.io.IOException r0 = new java.io.IOException
            java.lang.String r1 = "stream does not represent a PKCS12 key store"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fis.ekyc.nfc.build_in.bouncycastle.jcajce.provider.keystore.pkcs12.PKCS12KeyStoreSpi.engineLoad(java.io.InputStream, char[]):void");
    }

    public void engineSetCertificateEntry(String str, Certificate certificate) throws KeyStoreException {
        if (this.keys.get(str) == null) {
            this.certs.put(str, certificate);
            this.chainCerts.put(new CertId(certificate.getPublicKey()), certificate);
            return;
        }
        throw new KeyStoreException("There is a key entry with the name " + str + ".");
    }

    public void engineSetKeyEntry(String str, byte[] bArr, Certificate[] certificateArr) throws KeyStoreException {
        throw new RuntimeException("operation not supported");
    }

    public int engineSize() {
        Hashtable hashtable = new Hashtable();
        Enumeration keys2 = this.certs.keys();
        while (keys2.hasMoreElements()) {
            hashtable.put(keys2.nextElement(), "cert");
        }
        Enumeration keys3 = this.keys.keys();
        while (keys3.hasMoreElements()) {
            String str = (String) keys3.nextElement();
            if (hashtable.get(str) == null) {
                hashtable.put(str, "key");
            }
        }
        return hashtable.size();
    }

    public void engineStore(KeyStore.LoadStoreParameter loadStoreParameter) throws IOException, NoSuchAlgorithmException, CertificateException {
        PKCS12StoreParameter pKCS12StoreParameter;
        char[] cArr;
        if (loadStoreParameter != null) {
            boolean z = loadStoreParameter instanceof PKCS12StoreParameter;
            if (z || (loadStoreParameter instanceof JDKPKCS12StoreParameter)) {
                if (z) {
                    pKCS12StoreParameter = (PKCS12StoreParameter) loadStoreParameter;
                } else {
                    JDKPKCS12StoreParameter jDKPKCS12StoreParameter = (JDKPKCS12StoreParameter) loadStoreParameter;
                    pKCS12StoreParameter = new PKCS12StoreParameter(jDKPKCS12StoreParameter.getOutputStream(), loadStoreParameter.getProtectionParameter(), jDKPKCS12StoreParameter.isUseDEREncoding());
                }
                KeyStore.ProtectionParameter protectionParameter = loadStoreParameter.getProtectionParameter();
                if (protectionParameter == null) {
                    cArr = null;
                } else if (protectionParameter instanceof KeyStore.PasswordProtection) {
                    cArr = ((KeyStore.PasswordProtection) protectionParameter).getPassword();
                } else {
                    throw new IllegalArgumentException("No support for protection parameter of type " + protectionParameter.getClass().getName());
                }
                doStore(pKCS12StoreParameter.getOutputStream(), cArr, pKCS12StoreParameter.isForDEREncoding());
                return;
            }
            throw new IllegalArgumentException("No support for 'param' of type " + loadStoreParameter.getClass().getName());
        }
        throw new IllegalArgumentException("'param' arg cannot be null");
    }

    public void setRandom(SecureRandom secureRandom) {
        this.random = secureRandom;
    }

    public PrivateKey unwrapKey(AlgorithmIdentifier algorithmIdentifier, byte[] bArr, char[] cArr, boolean z) throws IOException {
        ASN1ObjectIdentifier algorithm = algorithmIdentifier.getAlgorithm();
        try {
            if (algorithm.on(PKCSObjectIdentifiers.pkcs_12PbeIds)) {
                PKCS12PBEParams instance = PKCS12PBEParams.getInstance(algorithmIdentifier.getParameters());
                PBEParameterSpec pBEParameterSpec = new PBEParameterSpec(instance.getIV(), validateIterationCount(instance.getIterations()));
                Cipher createCipher = this.helper.createCipher(algorithm.getId());
                createCipher.init(4, new PKCS12Key(cArr, z), pBEParameterSpec);
                return (PrivateKey) createCipher.unwrap(bArr, "", 2);
            } else if (algorithm.equals((ASN1Primitive) PKCSObjectIdentifiers.id_PBES2)) {
                return (PrivateKey) createCipher(4, cArr, algorithmIdentifier).unwrap(bArr, "", 2);
            } else {
                throw new IOException("exception unwrapping private key - cannot recognise: " + algorithm);
            }
        } catch (Exception e) {
            throw new IOException("exception unwrapping private key - " + e.toString());
        }
    }

    public byte[] wrapKey(String str, Key key, PKCS12PBEParams pKCS12PBEParams, char[] cArr) throws IOException {
        PBEKeySpec pBEKeySpec = new PBEKeySpec(cArr);
        try {
            SecretKeyFactory createSecretKeyFactory = this.helper.createSecretKeyFactory(str);
            PBEParameterSpec pBEParameterSpec = new PBEParameterSpec(pKCS12PBEParams.getIV(), pKCS12PBEParams.getIterations().intValue());
            Cipher createCipher = this.helper.createCipher(str);
            createCipher.init(3, createSecretKeyFactory.generateSecret(pBEKeySpec), pBEParameterSpec);
            return createCipher.wrap(key);
        } catch (Exception e) {
            throw new IOException("exception encrypting data - " + e.toString());
        }
    }

    public class CertId {
        byte[] id;

        public CertId(PublicKey publicKey) {
            this.id = PKCS12KeyStoreSpi.this.createSubjectKeyId(publicKey).getKeyIdentifier();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof CertId)) {
                return false;
            }
            return Arrays.areEqual(this.id, ((CertId) obj).id);
        }

        public int hashCode() {
            return Arrays.hashCode(this.id);
        }

        public CertId(byte[] bArr) {
            this.id = bArr;
        }
    }

    public void engineSetKeyEntry(String str, Key key, char[] cArr, Certificate[] certificateArr) throws KeyStoreException {
        if (!(key instanceof PrivateKey)) {
            throw new KeyStoreException("PKCS12 does not support non-PrivateKeys");
        } else if (!(key instanceof PrivateKey) || certificateArr != null) {
            if (this.keys.get(str) != null) {
                engineDeleteEntry(str);
            }
            this.keys.put(str, key);
            if (certificateArr != null) {
                this.certs.put(str, certificateArr[0]);
                for (int i = 0; i != certificateArr.length; i++) {
                    this.chainCerts.put(new CertId(certificateArr[i].getPublicKey()), certificateArr[i]);
                }
            }
        } else {
            throw new KeyStoreException("no certificate chain for private key");
        }
    }

    public void engineStore(OutputStream outputStream, char[] cArr) throws IOException {
        doStore(outputStream, cArr, false);
    }
}
